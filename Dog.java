public class Dog{
  String breed;
  int age;
  String color;

  //-------------重载-------------------

  public Dog(){
    System.out.println("I am a dog without name");
  }

  public Dog(String name){
    System.out.println("I am a dog with name :"+ name);
  }

  //---------定义对象里面的方法-----------

  public void setAge(int puppyAge){
    age = puppyAge;
  }

  public int getAge(){
    //System.out.println("Puppy's age is:"+ age);
    return age;
  }

  void barking(){
    System.out.println("barking");
  }

  void hungry(){
    System.out.println("I'm hungry");
  }

  void sleeping(){
    System.out.println("I wanna sleep");
  }

  public static void main(String [ ] args){
    Dog myDog = new Dog();
    myDog.barking();
    myDog.setAge(2);
    int myDogAge = myDog.getAge();
    System.out.println("The dog's age is:"+ myDogAge);
    System.out.println("The dog's age is(Method 2):"+ myDog.age);
    myDog.setAge(3);
    System.out.println("The dog's age is(Method 3):"+ myDog.getAge());
  }
}