public class PrivateOverride{
  private void f(){
    System.out.println("private f()");
  }

  public static void main(String[] args){
    PrivateOverride p = new Derived();
    Derived d = new Derived();
    PrivateOverride pp = new PrivateOverride();
    p.f();
    d.f();
    pp.f();
  }
}

class Derived extends PrivateOverride{
  public void f(){
    System.out.println("public f()");
  }
}
/*
private f()
public f()
private f()
*/