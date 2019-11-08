package test;
import com.google.common.collect.Lists;
import com.mayabot.mynlp.fasttext.*;
import com.mayabot.nlp.segment.LexerReader;
import com.mayabot.nlp.segment.Lexers;

import java.util.ArrayList;
import java.util.List;

/**
 * TestFastTextSingle class
 *
 * @author shehy2
 * @date 2019-11-8
 *
 */

public class TestFastTextSingle {
    public static void main(String[] args){
        FastText fastText1 = FastText.loadModel("model/car/model_file",true);
        ArrayList<String> sentences = new ArrayList<>();
        sentences.add( "卧槽这什么劣质玩意儿!再也不买这个牌子的车了, 完全不能用");
        sentences.add( "这根看似普通的带子，已经成功挽救了上百万的生命");
        sentences.add( "不到两月第四起自燃！特斯拉Model S在充电时起火");
        sentences.add( "沃尔沃的销量增长迅速, 有望出更好的车");
        sentences.add( "发布了头条文章：《沃尔沃XC40走精致生活路线，林志玲代言效果不俗！》O沃尔沃XC40走精致生活路线，林志玲代言效果不俗！");
        sentences.add( "定价太高，30几万不去买Q5和X3,会来买你？");
        sentences.add( "悦享|福满中秋佳节劲爆车展来袭！200元即领取8880元");

        int sentenceIndex = 1;
        System.out.println("FastText 预测结果:");
        for (String title: sentences){
            //进行分词操作:
            final LexerReader lexerReader = Lexers.coreBuilder().build().filterReader(true,true);
            List<String> inputList = Lists.newArrayList(lexerReader.scan(title).toWordSequence());

            if (inputList.isEmpty()){
                System.out.println("inputList is Empty");
            }else{
                List<FloatStringPair> list = fastText1.predict(inputList, 5);
                if (list. isEmpty()){
                    System.out.println("List is Empty");
                }else{
                    FloatStringPair first = list.get(0);
                    if (first.first < 0.6f) {
                        System.out.printf("《%s》 最高概率为【%.2f】，小于60%%\n", title, (first.first)*100);
                    }else{
                        String polarity;
                        if (first.second.equals("__label__pos")){
                            polarity = "正面";
                        }else{
                            polarity = "负面";
                        }
//                        System.out.format("\n\n句子%d预测结果:\n",sentenceIndex);
//                        System.out.println("---------------------------------------------------------------------------------------");
//                        System.out.format("标题Title: %s\n",title);
//                        System.out.format("情感正负: %s\n",polarity);
//                        System.out.format("预测概率 %f\n",first.first);
//                        System.out.println("---------------------------------------------------------------------------------------");
                        System.out.printf("《%s》 属于分类 【%s】, 概率为【%.2f%%】\n", title, polarity,(first.first)*100);
                    }
                }
            }
            sentenceIndex ++;
        }

    }
}
