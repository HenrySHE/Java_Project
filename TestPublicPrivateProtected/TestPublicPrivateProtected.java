class Cookie{
  public Cookie(){
    System.out.println("Cookie is created.");
    System.out.println("Now accessing the private cookie inside the class:");
    privateCookie();
  }

  private void privateCookie(){
    System.out.println("I'm private cookie");
  }

  public void publicCookie(){
    System.out.println("I'm public cookie");
  }

  protected void bite(){
    System.out.println("This is a protected class");
  }
}

//创建Soda对象必须通过调用makeSoda进行
class Soda{
  private Soda(){
    System.out.println("A new Soda obj is created!");
  }
  static Soda makeSoda(){
    return new Soda();
  }
  int getsodanum(){
    return 1;
  }
}


public class TestPublicPrivateProtected extends Cookie{
  public TestPublicPrivateProtected(){
    System.out.println("TestPublicPrivateProtected obj (which is extended form Cookie) is created");
  }

  public static void main(String[] args){
    Cookie k = new Cookie();
    //前面定义了private的话,在new对象之后就不能够调用了这个方法了..
    //k.privateCookie();
    k.publicCookie();
    //下面这样写会编译不通过!!
    //Soda sd = new Soda();
    Soda sd1 = Soda.makeSoda();
    //int result = sd1.getsodanum();
    System.out.println(sd1.getsodanum());

    TestPublicPrivateProtected t1 = new TestPublicPrivateProtected();
    /*Cookie is created.
      Now accessing the private cookie inside the class:
      I'm private cookie
      TestPublicPrivateProtected obj (which is extended form Cookie) is created
    */
    //只有在继承的class里面,才能够调用bite这个父类的方法
    t1.bite();
  }
}
