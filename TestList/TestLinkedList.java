import java.util.LinkedList;

public class TestLinkedList {
  public static void main(String[] args){
    //LinkedList不用定义长度
    LinkedList<String> lk = new LinkedList<>();
    //peek()比 lk.getFirst()要好,因为如果为空会返回Null
    String firstElement = lk.peek();
    if (firstElement == null){
      System.out.println("The LinkedList is empty");
    }else{
      System.out.println("The LinkedList is not empty");
    }
    lk.add(0, "Hello");
    lk.add(1, "Hi");
    lk.add("How are you");
    System.out.println(lk);
    lk.addFirst("First");
    lk.addLast("Last");
    System.out.println(lk);
    
  }
}