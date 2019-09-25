import java.util.regex.*;
import java.util.ArrayList;

public class TestStringReplace{
  public static void main(String[] args){
    ArrayList<String> content = new ArrayList<String>();
    content.add("此主帖已经被咔咔三叶设为精华帖 帖子标题：立秋过后，收获之季，看中RX5MAX，望成囊中之物。 精华理由：鼓励分享");
    content.add("此主帖已经被咔咔三叶设为精华帖 帖子标题：荣威MAX，就他了 精华理由：鼓励分享");
    content.add("此主帖已经被咔咔三叶设为精华帖 帖子标题：我今天看了一款很不错的车型，分享给大家 精华理由：精华鼓励");
    content.add("此主帖已经被咔咔三叶设为精华帖 帖子标题：新车到店，感觉还不错~ 精华理由：鼓励分享");
    content.add("此主帖已经被咔咔三叶设为精华帖 帖子标题：被RX5 MAX俘获芳心的二孩奶爸，试驾完就订车！ 精华理由：感谢分享");
    content.add("此主帖已经被咔咔三叶设为精华帖 帖子标题：订单，了解一下？ 精华理由：鼓励分享");
    content.add("此主帖已经被咔咔三叶设为精华帖 帖子标题：纯爷们的最爱，荣威RX5 MAX够硬核 精华理由：鼓励分享");
    content.add("此主帖已经被咔咔三叶设为精华帖 帖子标题：荣威RX5 max和我的荣威rx5比比看之外观篇，比完差点心肌梗塞。 精华理由：鼓励分享");
    content.add("此主帖已经被咔咔三叶设为精华帖 帖子标题：我这次终于目标了，期待新车试驾 精华理由：感谢分享");
    content.add("此主帖已经被咔咔三叶设为精华帖 帖子标题：人生的第二辆车一定要完美才行 精华理由：精华鼓励");
    content.add("此主帖已经被咔咔三叶设为精华帖 帖子标题：准备迎接我的第二辆车——RX5MAX看车小记 精华理由：鼓励分享");
    content.add("此主帖已经被咔咔三叶设为精华帖 帖子标题：豪华与科技并存的RX5MAX——2019成都车展 精华理由：精华鼓励");
    content.add("此主帖已经被咔咔三叶设为精华帖 帖子标题：2019年成都车展，带你去看荣威RX5 MAX，当然少不了香车美女！ 精华理由：精华鼓励");
    content.add("此主帖已经被xxx设为精华帖");
    content.add("此主帖已经被蒸水渔夫推荐");
    content.add("此主帖已经被菜羊羊推荐 恭喜楼主被推荐");
    content.add("此主帖已经被蔡蔡有话说推广为首页");
    content.add("此主帖已经被行政总监推荐。就这么简单？");
    content.add("此主帖已经被取消精华贴 理由:图太假，不够敬业");
    content.add("理当如此, 此主帖已经被蒸水渔夫设为精华帖");

    //content.add();
    //final String pattern = ".*此主帖已经被.*设为.*";
    final String pattern = ".*此主帖已经.*?[设为|推荐|取消|推广为首页].*";
    for (String c:content){
      boolean isMatch = Pattern.matches(pattern, c);
      if(isMatch){
        System.out.println("Filtered");
        //nlpDoc.setMark("3");
        //return nlpDoc;
      }else{
        System.out.println("Error!");
      }
    }
    //(此主帖已经.*?[设为|推荐|取消|推广为首页])
    //"(此主帖已经.*?[设|推|取])";
    final String pattern2 = "(此主帖已经.*?[设|推|取])";
    
    Pattern pt = Pattern.compile(pattern2);
    for(String c:content){
      String str = "";
      Matcher matcher = pt.matcher(c);
      while(matcher.find()){
        int length = matcher.group().length();
        for (int i = 0; i < length; i++){
          str = str + "*";
        }
        c = c.replace(matcher.group(),str);
        str = "";
        System.out.println(c);
      }
    }
    

  }
}