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
    System.out.println("Testing DettergenSon (extended form Detergent class)");
    DettergentSon.main(args);
  }
}

//附加作业,添加一个继承于Detergent的,命名为DettergentSon,然后覆盖原来scrub方法
//接着添加一个自己的方法"sterilize()"

class DettergentSon extends Detergent{
  public void scrub(){
    //do nothing
    //覆盖原来的方法
  }
  public void sterilize(){
    append(" sterilize()");
  }

  public static void main(String[] args){
    DettergentSon s = new DettergentSon();
    s.dilute();
    s.apply();
    s.scrub();
    s.foam();
    s.sterilize();
    System.out.println(s);
  }
}
/*
Cleanser dilute() apply()Detergent.scrub()  scrub() foam()
Testing base class:
Cleanser dilute() apply() scrub()
Testing DettergenSon (extended form Detergent class)
Cleanser dilute() apply() foam() sterilize()
*/