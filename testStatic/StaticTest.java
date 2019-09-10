class StaticTest{
  //详见《Java编程思想》29-30页
  //类变量
  static int i = 10086;
  private static int j = 10087;

  //类方法
  public static void hello(){
    System.out.println("This is a static method called hello~");
  }

  public void hi(){
    System.out.println("This is not static method called hi~");
  }


  public static void main(String [ ] args){
    StaticTest st1 = new StaticTest();
    StaticTest st2 = new StaticTest();
    //调用static 变量的方法:
    //1.先创建对象,然后调用对象里面的变量
    //2.直接调用class里面的变量
    System.out.println(st1.i);
    System.out.println(st2.i);
    //Change the value of i:
    st1.i ++;
    //print st2.i
    System.out.println("The value of st2.i is :"+st2.i);// It should be 10087
    //证明了是同一存储空间；
    System.out.println(StaticTest.i);
    System.out.println(StaticTest.j);
    //有了static便可以直接通过类名调用
    StaticTest.hello();
    //没有static的只能通过创建对象去调用
    st1.hi();
  }
}