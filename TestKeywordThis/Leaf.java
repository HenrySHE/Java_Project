/*
这个的目的测试This 的代码
*/
public class Leaf{
  int i = 0;
  Leaf increment(){
    i++;
    return this;
  }

  void print(){
    System.out.println("i = "+ i);
  }

  public static void main(String[] args){
    Leaf x = new Leaf();
    Leaf y = new Leaf();
    x.increment().increment().increment().print();
    y.increment().print();
  }
}