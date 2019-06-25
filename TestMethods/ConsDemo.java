class MyClass{
  int x;
  MyClass(int i){
    x = i;
  }
}

public class ConsDemo{
  public static void main(String args[]){
    MyClass t1 = new MyClass(10);
    System.out.println(t1.x);
  }
}
