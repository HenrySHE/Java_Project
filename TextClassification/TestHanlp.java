package test;


import com.hankcs.hanlp.classification.classifiers.IClassifier;
import com.hankcs.hanlp.classification.classifiers.NaiveBayesClassifier;
import com.hankcs.hanlp.classification.models.NaiveBayesModel;
import com.hankcs.hanlp.corpus.io.IOUtil;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * TestHanlp
 *
 * @author shehy2
 * date 2019/11/6
 */

public class TestHanlp {
    /**
     * 搜狗文本分类语料库5个类目，每个类目下1000篇文章，共计5000篇文章
     */
    public static final String CORPUS_FOLDER = "D:\\Code\\情感分类THUCTC\\Data\\Train";
    /**
     * 模型保存路径
     */
    public static final String MODEL_PATH = "D:\\Code\\情感分类HanLP\\model\\classification-model.ser";


    public static void main(String[] args) throws IOException
    {
        IClassifier classifier = new NaiveBayesClassifier(trainOrLoadModel());
        predict(classifier, "卧槽这什么劣质玩意儿!再也不买这个牌子的车了, 完全不能用");
        predict(classifier, "这根看似普通的带子，已经成功挽救了上百万的生命");
        predict(classifier, "不到两月第四起自燃！特斯拉Model S在充电时起火");
        predict(classifier, "沃尔沃的销量增长迅速, 有望出更好的车");
        predict(classifier, "发布了头条文章：《沃尔沃XC40走精致生活路线，林志玲代言效果不俗！》O沃尔沃XC40走精致生活路线，林志玲代言效果不俗！");
        predict(classifier, "定价太高，30几万不去买Q5和X3,会来买你？");
        predict(classifier, "悦享|福满中秋佳节劲爆车展来袭！200元即领取8880元");
    }

    private static void predict(IClassifier classifier, String text)
    {
        //System.out.printf("《%s》 属于分类 【%s】\n", text, classifier.classify(text));
        Map<String, Double> predictResult = classifier.predict(text);
        Double posProp = 0.0;
        Double negProp=  0.0;
        for(String key : predictResult.keySet()){
            if("neg".equals(key)){
                negProp = predictResult.get(key);
            }else{
                posProp = predictResult.get(key);
            }
            //System.out.println(key+" :"+ predictResult.get(key));
        }
        if(posProp > negProp){
            System.out.format("《%s》 属于分类 【正面】, 概率为【%.2f%%】\n", text, posProp*100);
        }else{
            System.out.format("《%s》 属于分类 【负面】, 概率为【%.2f%%】\n", text, negProp*100);
        }
    }

    private static NaiveBayesModel trainOrLoadModel() throws IOException
    {
        NaiveBayesModel model = (NaiveBayesModel) IOUtil.readObjectFrom(MODEL_PATH);
        if (model != null) {
            return model;
        }

        File corpusFolder = new File(CORPUS_FOLDER);
        if (!corpusFolder.exists() || !corpusFolder.isDirectory())
        {
            System.err.println("没有文本分类语料, 请检查训练文件路径。");
            System.exit(1);
        }
        // 创建分类器，更高级的功能请参考IClassifier的接口定义
        IClassifier classifier = new NaiveBayesClassifier();
        // 训练后的模型支持持久化，下次就不必训练了
        classifier.train(CORPUS_FOLDER);
        model = (NaiveBayesModel) classifier.getModel();
        IOUtil.saveObjectTo(model, MODEL_PATH);
        return model;
    }
}
