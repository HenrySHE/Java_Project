public class TestInnerClass{
  static class Obj1 {
    private final int i = 0;
    public void getVal(){
      System.out.println(i);
    }
  }
  static class Obj2 {
    private final String s= "Hello Obj2";
    public void getStr(){
      System.out.println(s);
    }
  }
  public static void main(String[] args){
    TestInnerClass tic = new TestInnerClass();
    TestInnerClass.Obj1 a = new TestInnerClass.Obj1();
    a.getVal();
    TestInnerClass.Obj2 b = new TestInnerClass.Obj2();
    b.getStr();
  }
}