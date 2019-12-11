class Amphibian{}
class Vehicle{}

public class TupleTest{
  static TwoTuple<String, Integer> f(){
    return new TwoTuple<String, Integer>("hi", 47);
  }
  public static void main(String[] args){
    TwoTuple<String, Integer> ttsi = f();
    System.out.println(ttsi);
  }
}