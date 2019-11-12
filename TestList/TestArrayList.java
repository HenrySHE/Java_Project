import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class TestArrayList{
  public static void main (String[] args){
    List<String> pets = new ArrayList<>();
    pets.add("Hello");
    pets.add("Hi");
    pets.add("How Are You");
    List<String> subPets = new ArrayList<>();
    subPets.add("Hello");
    System.out.println(pets); 
    System.out.println(pets.contains(subPets));
    //获取index = 0的值
    String TempValue = pets.get(0);
    System.out.println(TempValue); 
    System.out.println(pets);
    // pets.remove(0);
    // System.out.println(pets);
    //截断
    // List<String> petsCopy = pets.subList(0, 1);
    // System.out.println(pets.retainAll(petsCopy));
    //注意,只要不是从原来List复制过来的,那么他们就不相等
    // System.out.println(pets.retainAll(subPets));
    // System.out.println(pets);

    //------------------迭代器--------------
    Iterator<String> it = pets.iterator();
    while(it.hasNext()){
      System.out.println(it.next()); 
    }

    for(String pet: pets){
      System.out.println(pet);
    }
    //复制ArrayList
    List<String> copy = new ArrayList<String>(pets);
    System.out.println(copy);
    copy.remove(2);
    System.out.println(copy);
  }
}