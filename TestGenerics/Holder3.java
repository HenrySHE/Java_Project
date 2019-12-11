/*
这里的意义在于,不用事先定义好什么类型的数据结构,让后面创建的人去定义,而且定义了之后,不能够随便更改。
*/
public class Holder3<T>{
  private T a;
  public Holder3(T a){
    this.a = a;
  }
  public void set(T a){
    this.a = a;
  } 
  public T get() { return a; }
  public static void main(String[] args){
    Holder3<Automobile> h3 = new Holder3<Automobile>(new Automobile());
    Automobile a = h3.get();
    System.out.println(a);
  }
}
/*
Automobile@6bc7c054
*/