package test;
import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.io.Files;
import com.mayabot.mynlp.fasttext.*;
import com.mayabot.nlp.segment.LexerReader;
import com.mayabot.nlp.segment.Lexers;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.List;

/**
 * App class
 *
 * @author shehy2
 * @date 2019-11-4
 *
*/

public class App 
{
    public static void main( String[] args ) throws Exception
    {
        // 训练模型
        File trainFile = new File("model/car/car_train_news_corpus.txt");
        //FastText fastText = FastText.train(trainFile, ModelName.sup);
        TrainArgs args1 = new TrainArgs();
        args1.setDim(100);
        args1.setLr(0.05);
        args1.setEpoch(30);
        args1.setLoss(LossName.hs);
        //这里trainfile需要转换

        final LexerReader analyzer = Lexers.coreBuilder().build().filterReader(true,true);

        FileTrainExampleSource source = new FileTrainExampleSource(new WordSplitter() {
            @NotNull
            @Override
            public List<String> split(String s) {
                List<String> result = Lists.newArrayList();
                String[] parts = s.split(" ");
                for (String part:parts){
                    if(part.startsWith("__label__")){
                        result.add(part);
                    }else{
                        for (String word: analyzer.scan(part).toWordSequence()){
                            result.add(word);
                        }
                    }
                }
                return result;
            }
        },trainFile);

//        final Splitter splitter = Splitter.on(CharMatcher.whitespace()).omitEmptyStrings().trimResults();
//        FileTrainExampleSource source = new FileTrainExampleSource(new WordSplitter() {
//            @NotNull
//            @Override
//            public List<String> split(String text) {
//                List<String> result = Lists.newArrayList();
//                Iterable<String> parts = splitter.split(text);
//                for (String part: parts){
//                    if(part.startsWith("__label__")){
//                        result.add(part);
//                    }else{
//                        for (String word: analyzer.scan(part).toWordSequence()){
//                            result.add(word);
//                        }
//                    }
//                }
//                return result;
//            }
//        },trainFile);

        FastText fastText = FastText.train(source, ModelName.sup,args1);
        fastText.saveModel("model/car/model_file");

        FastText fastText1 = FastText.loadModel("model/car/model_file",true);
        String line1 = "卧槽这什么劣质玩意儿!再也不买这个牌子的车了, 完全不能用";
        line1 = "超51万辆小汽车被召回！涉及多个品牌，有没有你的爱车? ";
        //line1 = "不到两月第四起自燃！特斯拉Model S在充电时起火";
        //line1 = "运气不错, 能够开上沃尔沃XC60这么让人省心的车";
        //line1 = "沃尔沃的销量增长迅速, 有望出更好的车";

        //进行分词操作:
        final LexerReader lexerReader = Lexers.coreBuilder().build().filterReader(true,true);
        List<String> inputList = Lists.newArrayList(lexerReader.scan(line1).toWordSequence());

        if (inputList.isEmpty()){
            System.out.println("inputList is Empty");
        }else{
            List<FloatStringPair> list = fastText1.predict(inputList, 5);
            if (list. isEmpty()){
                System.out.println("List is Empty");
            }else{
                FloatStringPair first = list.get(0);
                if (first.first < 0.6f) {
                    System.out.println("The accuracy is lower than 50%");
                }else{
                    System.out.println("first Value is:");
                    System.out.println(first);
                    System.out.println("---------------");
                }
            }
        }



//        List<FloatStringPair> predict = fastText1.predict(Arrays.asList(line1.split(" ")),3);
//        System.out.println(predict.get(0).first);
//        System.out.println(predict.get(0).second);
//        System.out.println(predict.get(1).first);
//        System.out.println(predict.get(1).second);
//        if (predict.get(0).first > predict.get(1).first){
//            System.out.println("正面");
//        }else{
//            System.out.println("负面");
//        }

        String inPath = "data/test_input.txt";
        String outPath = "data/test_output.txt";
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
                String result = null;
                String polarity = null;
                float probability = 0;
                //List<FloatStringPair> predictResult = fastText1.predict(Arrays.asList(line.split(" ")),5);
                List<String> inputListResult = Lists.newArrayList(lexerReader.scan(line).toWordSequence());
                if (inputListResult.isEmpty()){
                    System.out.println("inputListResult is Empty");
                }else{
                    List<FloatStringPair> listResult = fastText1.predict(inputListResult, 5);
                    if (listResult.isEmpty()){
                        System.out.println("listResult is Empty");
                    }else{
                        //获取第一个预测结果, 里面有分类结果+Accuracy
                        FloatStringPair first = listResult.get(0);
                        //判断Accuracy是否小于50%
                        if (first.first < 0.6f){
                            System.out.println("词条"+line+"准确率小于50%");
                            //System.out.println();
                        }
                        //此处可以写else去判断, 如果>50才用FastText的结果

                        result = first.second;
                        probability = first.first;
                        if (result.equals("__label__neg")){
                            polarity = "负面";
                        }else{
                            polarity = "正面";
                        }
                    }
                }


//                if (predictResult.get(0).second.equals("__label__neg")){
//                    result = predictResult.get(0).second;
//                    polarity = "负面";
//                    probability = predictResult.get(0).first;
//                }if (predictResult.get(0).second.equals("__label__pos")){
//                    result = predictResult.get(0).second;
//                    polarity = "正面";
//                    probability = predictResult.get(0).first;
//                }

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
