/*
2019-9-17 17:13
测试复用类
*/
class Soap {
  private String s;
  Soap(){
    System.out.println("Soap()");
    s="Constructed";
  }
  public String toString(){ return s; }
}

public class Bath{
  private String s1="Happy", 
  s2="Happy", 
  s3, s4;
  private Soap castille;
  private int i;
  private float toy;

  public Bath(){
    System.out.println("Inside Bath()");
    s3 = "Joy";
    toy = 3.14f;
    castille = new Soap();
  }

  //Instance initalization
  //???
  {i = 47;}

  public String toString(){
    if (s4 == null)
      s4 = "Joy";
      return
        "S1 = " + s1 + "\n" +
        "S2 = " + s2 + "\n" +
        "S3 = " + s3 + "\n" +
        "S4 = " + s4 + "\n" +
        "i = " + i  + "\n" +
        "toy = " + toy + "\n" +
        "castille = " + castille ;
  }

  public static void main(String[] args){
    Bath b = new Bath();
    System.out.println(b);
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