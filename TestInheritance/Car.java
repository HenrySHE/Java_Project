/**
2019年9月18日17:37:22
*/

class Wheel{
  public int weelNum = 0;
  Wheel(int weelNum){
    this.weelNum = weelNum;
  }
  public void inflate(int psi){
    System.out.println("wheel with psi ="+ psi);
  }
}

public class Car{
//这里创建了ArrayList(Wheel类型的),长度为4
public Wheel[] wheel = new Wheel[4];

  public Car(){
    for(int i = 0; i < 4; i++){
      wheel[i] = new Wheel(i);
    }
  }
  
  public static void main(String[] args){
    Car car = new Car();
    car.wheel[0].inflate(72);
    
    car.wheel[1].inflate(100);
    for (int j = 0; j < 4 ; j++){
      System.out.println("Wheel["+j+"] value is: "+ car.wheel[j].weelNum);
    }
  }
}

/**Output
wheel with psi =72
wheel with psi =100
Wheel[0] value is: 0
Wheel[1] value is: 1
Wheel[2] value is: 2
Wheel[3] value is: 3
*/