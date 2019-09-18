
/*
2019年9月18日09:42:07
测试初始化顺序
*/
class Art{
  Art() {System.out.println("Art()");}
}

class Drawing extends Art{
  Drawing (){System.out.println("Drawing()");}
}

public class Cartoon extends Drawing{
  public Cartoon(){ System.out.println("Cartoon()");}

  public static void main(String[] args){
    Cartoon x = new Cartoon();
  }
}
/*
Art()
Drawing()
Cartoon()
*/