/*
2019年9月17日17:38:25
测试继承
*/

class Cleanser{
  private String s = "Cleanser";
  public void append(String a) { s += a ;}
  public void dilute() {append(" dilute()");}
  public void apply() {append(" apply()"); }
  public void scrub() { append(" scrub()"); }
  public String toString(){
    return s;
  }
  
  public static void main(String[] args){
    Cleanser x = new Cleanser();
    x.dilute();
    x.apply();
    x.scrub();
    System.out.println(x);
  }
}

class Detergent extends Cleanser{
  //重写方法
  public void scrub(){
    //添加新的方法
    append("Detergent.scrub() ");
    //继承之前的scrub方法
    super.scrub();
  }

  public void foam(){ append(" foam()");}

  public static void main (String[] args){
    Detergent x = new Detergent();
    x.dilute();
    x.apply();
    x.scrub();
    x.foam();
    System.out.println(x);
    System.out.println("Testing base class:");
    //调用其他方法里面的那个main方法
    Cleanser.main(args);
  }
}

/*
Inside Bath()
Soap()
S1 = Happy
S2 = Happy
S3 = Joy
S4 = Joy
i = 47
toy = 3.14
*/