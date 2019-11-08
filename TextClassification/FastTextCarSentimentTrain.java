package test;

import com.google.common.io.Files;
import com.mayabot.mynlp.fasttext.FastText;
import com.mayabot.mynlp.fasttext.FloatStringPair;
import kotlin.text.Charsets;

import java.io.*;
import java.util.List;

public class FastTextCarSentimentTrain {
    public static void main(String[] args) throws Exception {
        // 训练模型
        File trainFile = new File("model/car/car_train_news_corpus.txt");
        FastText modelTrain = FasttextClassification.train(trainFile, 100, 0.05, 20);
        modelTrain.saveModel("model/car/model_file");

        // 加载模型
        FastText model = FastText.loadModel("model/car/model_file", false);
        String line2 = "不到两月第四起自燃！特斯拉Model S在充电时起火";
        line2 = "2019超64万辆车被召回，戳进来看你的车在名单里吗";
        //line = "运气不错, 能够开上沃尔沃XC60这么让人省心的车";

        // 模型预测
        FloatStringPair result2 = FasttextClassification.predictOne(model, line2);
        if (result2 != null) {
            System.out.println("原始句子：" + line2 + "\t" + "预测分类标签： " + result2.second + "\t预测概率： " + result2.first);
        }

        String line3 = "新车优惠不多——冷清车市期待9月回暖";
        FloatStringPair result3 = FasttextClassification.predictOne(model, line3);
        if (result3 != null) {
            System.out.println("原始句子：" + line3 + "\t" + "预测分类标签： " + result3.second + "\t预测概率： " + result3.first);
        }

        String inPath = "data/test_input.txt";
        String outPath = "data/test_output.txt";
        PrintWriter writer = null;

        try{
            File testFile = new File(inPath);
            List<String> examples = Files.readLines(testFile, Charsets.UTF_8);
            int total = 0;
            int success = 0;

            for(int i = 0; i < examples.size(); i++){
                String line = examples.get(i);
                String[] parts = line.split(" ");
                String label = null;
                for (String part: parts){
                    if (part.startsWith("__label__")){
                        label = part;
                    }
                }
                FloatStringPair predictResult = FasttextClassification.predictOne(model, line);

                String result = null;
                String polarity = null;
                float probability = 0;
//                if (predictResult.get(0).first > predictResult.get(1).first){
//                    result = predictResult.get(0).second;
//                    polarity = "负面";
//                }else{
//                    result = predictResult.get(1).second;
//                    polarity = "正面";
//                }
                if (predictResult.second.equals("__label__neg")){
                    result = predictResult.second;
                    polarity = "负面";
                    probability = predictResult.first;
                }if (predictResult.second.equals("__label__pos")){
                    result = predictResult.second;
                    polarity = "正面";
                    probability = predictResult.first;
                }

                //写入数据
                try{
                    BufferedWriter out = new BufferedWriter(new FileWriter(outPath,true));
                    out.write(line + '\t' + polarity + '\t' + probability+ '\n');
                    System.out.format("写入第%d条数据\n",total);
                    out.flush();
                    out.close();
                }catch (IOException e){
                    System.out.println("写入失败");
                }
                if(label != null){
                    if (label.equals(result)){
                        success ++;
                    }
                }

                total ++;
            }

            System.out.println("Total: " + total);
            System.out.println("Success: " + success);
            float accuracy = (float)success/(float)total;
            System.out.println("准确率: "+ accuracy);
        }catch (FileNotFoundException e){
            System.out.println("The File is not Exist");
        }
    }
}
