package test;
import org.thunlp.text.classifiers.BasicTextClassifier;
import org.thunlp.text.classifiers.ClassifyResult;
import org.thunlp.text.classifiers.LinearBigramChineseTextClassifier;

import java.util.ArrayList;

/**
 *TestThuctc
 *
 * @author shehy2
 * date 2019/11/6
*/
public class TestThuctc {
    /**
     * 如果需要对一批文本进行训练，再进行测试，可以按照本函数的代码调用分类器
     *
     */
    public static void runTrainAndTest() {

        // 新建分类器对象
        BasicTextClassifier classifier = new BasicTextClassifier();

        // 设置参数
        String defaultArguments = ""
                + "-train D:\\Code\\情感分类THUCTC\\Data\\Train "  // 设置您的训练路径，这里的路径只是给出样例
                //+ "-test D:\\Code\\情感分类THUCTC\\trainingData\\Train"
                //	+ "-l C:\\Users\\do\\workspace\\TestJar\\my_novel_model "
                //	+ "-cdir E:\\Corpus\\书库_cleared "
                //	+ "-n 1 "
                // + "-classify E:\\Corpus\\书库_cleared\\言情小说 "  // 设置您的测试路径。一般可以设置为与训练路径相同，即把所有文档放在一起。
                + "-d1 0.7 "  // 前70%用于训练
                + "-d2 0.3 "  // 后30%用于测试
                + "-f 35000 " // 设置保留特征数，可以自行调节以优化性能
                + "-filter .txt "
                +  "-s D:\\Code\\情感分类THUCTC\\model "  // 将训练好的模型保存在硬盘上，便于以后测试或部署时直接读取模型，无需训练
                ;

        // 初始化
        classifier.Init(defaultArguments.split(" "));

        // 运行
        classifier.runAsBigramChineseTextClassifier();

    }


    /**
     * 如果需要读取已经训练好的模型，再用其进行分类，可以按照本函数的代码调用分类器
     *
     */
    public static void runLoadModelAndUse() {
        // 新建分类器对象
        BasicTextClassifier classifier = new BasicTextClassifier();

        // 设置分类种类，并读取模型
        classifier.loadCategoryListFromFile("D:\\Code\\情感分类THUCTC\\model\\category");
        classifier.setTextClassifier(new LinearBigramChineseTextClassifier(classifier.getCategorySize()));
        classifier.getTextClassifier().loadModel("D:\\Code\\情感分类THUCTC\\model");

		/*
		 * 上面三行代码等价于设置如下参数，然后初始化并运行：
		 *
		   String defaultArguments = ""
		 +  "-l  my_novel_model"  // 设置您的训练好的模型的路径，这里的路径只是给出样例
		 ;
		 classifier.Init(defaultArguments.split(" "));
		 classifier.runAsLinearBigramChineseTextClassifier();
		 *
		 */

        // 之后就可以使用分类器进行分类
        ArrayList<String> sentences = new ArrayList<>();
        sentences.add( "卧槽这什么劣质玩意儿!再也不买这个牌子的车了, 完全不能用");
        sentences.add( "这根看似普通的带子，已经成功挽救了上百万的生命");
        sentences.add( "不到两月第四起自燃！特斯拉Model S在充电时起火");
        sentences.add( "沃尔沃的销量增长迅速, 有望出更好的车");
        sentences.add( "发布了头条文章：《沃尔沃XC40走精致生活路线，林志玲代言效果不俗！》O沃尔沃XC40走精致生活路线，林志玲代言效果不俗！");
        sentences.add( "定价太高，30几万不去买Q5和X3,会来买你？");
        sentences.add( "悦享|福满中秋佳节劲爆车展来袭！200元即领取8880元");

//        int topN = 2;  // 保留最有可能的2个结果 (其实就分了2类, 负面和非负面)
//        ClassifyResult[] result = classifier.classifyText(text, topN);
//        for (int i = 0; i < topN; ++i) {
//            // 输出分类编号，分类名称，以及概率值。
//            System.out.println(result[i].label + "\t" +
//                    classifier.getCategoryName(result[i].label) + "\t" +
//                    result[i].prob);
//        }
        for(String text: sentences){
            String polarity;
            ClassifyResult[] result = classifier.classifyText(text,1);
            if (result[0].label == 0){
                polarity = "负面";
            }else{
                polarity = "正面";
            }
            System.out.format("《%s》 属于分类 【%s】, 概率为【%.2f%%】\n", text, polarity,(result[0].prob)*100);
        }

    }

    /**
     * 如果需要按照特殊需求自行添加训练文件，可以按照本函数的代码调用分类器
     *
     */
    public static void AddFilesManuallyAndTrain() {

        // 新建分类器对象
        BasicTextClassifier classifier = new BasicTextClassifier();

        // 设置分类种类
        classifier.loadCategoryListFromFile("在此输入您的类型列表文件的路径，例如  /media/disk2/data/novel/category.lst");
        classifier.setTextClassifier(new LinearBigramChineseTextClassifier(classifier.getCategorySize()));

		/*
		 * 上面两行代码等价于设置如下参数，然后初始化：
		 *
		   String defaultArguments = ""
		 + "-c /media/disk2/data/novel/category_list "  // 设置您的类型列表文件的路径
		 ;
		 classifier.Init(defaultArguments.split(" "));
		 *
		 */

        // 手动添加文件的方法。每个训练文件按照下面的接口调用一次。
        String filepath = "在此输入您的一个训练文件路径";
        String category = "在此输入训练文件对应的类型名称";
        if (!classifier.addTrainingText(category, filepath)) {
            System.out.println("添加训练文件失败。文件路径为：" + filepath);
            return;
        }

        // 训练并保存模型
        classifier.getTextClassifier().train();
        classifier.getTextClassifier().saveModel("在此输入您保存的模型的路径，例如  /media/disk2/data/novel/my_novel_model");

    }

    public static void main (String args[]) {
        //runTrainAndTest();
        runLoadModelAndUse();
        // AddFilesManuallyAndTrain();
    }
}
