public class SimpleEnumUse{
  public static void main(String[] args){
    /*默认方法:
    1. values() -- 用来遍历所有的枚举的内容
    2. Ordinal() -- 应该是顺序
    3. toString() -- 将枚举对象转换为String(在打印结果的时候直接调用toString)
    */
    for (Spiciness s : Spiciness.values()){
      System.out.println(s + " ,ordinal "+ s.ordinal());
    }
    System.out.println(Spiciness.SHIYUAN.toString());
  }
}

/*
ERSHIYUAN ,ordinal 0
SHIYUAN ,ordinal 1
WUYUAN ,ordinal 2
YIYUAN ,ordinal 3
YIJIAO ,ordinal 4
YIFEN ,ordinal 5
SHIYUAN
*/