class MyException extends Exception{
  public MyException() {}
  public MyException(String msg) { super(msg);}
}

public class FullConstructors{
  public static void f() throws MyException {
    System.out.println("Throwing MyException from f()");
    throw new MyException();
  }

  public static void g() throws MyException{
    System.out.println("Throwing MyException form g()");
    throw new MyException("Originated in g()");
  }

  public static void main(String[] args){
    try{
      f();
    }catch (MyException e){
      e.printStackTrace(System.out);
    }

    try{
      g();
    }catch(MyException e){
        e.printStackTrace(System.out);
      }
  }
}

/**
Throwing MyException from f()
MyException
        at FullConstructors.f(FullConstructors.java:9)
        at FullConstructors.main(FullConstructors.java:19)
Throwing MyException form g()
MyException: Originated in g()
        at FullConstructors.g(FullConstructors.java:14)
        at FullConstructors.main(FullConstructors.java:25)
*/