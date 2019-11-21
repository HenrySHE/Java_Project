import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

import javax.print.attribute.standard.PrintQuality;

public class TestPriorityQueue{
  public static void main(String[] args){
    PriorityQueue<Integer> p = new PriorityQueue<Integer>();
    Random rand =new Random(47);
    for(int i = 0; i < 10; i++){
      p.offer(rand.nextInt(i+10));
    }
    while (p.peek() != null){
      System.out.print(p.remove()+ " ");
    }
    System.out.print("\n");
    List<Integer> ints = Arrays.asList(25,22,20,18,14,9,3,1,1,2,3,9,14,18,21,23,25);
    //此处在new PriorityQueue的时候,就先定义优先级
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>(ints.size(),Collections.reverseOrder());
    pq.addAll(ints);
    while (pq.peek() != null){
      System.out.print(pq.remove()+ " ");
    }
    System.out.println();

    //创建Char类型的
    String fact = "EDUCATION SHOULD ESCHEW OBFUSCATION";
    List<String> strings = Arrays.asList(fact.split(""));
    PriorityQueue StringPQ = new PriorityQueue<String>(strings.size(),Collections.reverseOrder());
    StringPQ.addAll(strings);
    while (pq.peek() != null){
      System.out.print(pq.remove()+ " ");
    }
    System.out.println();


  }
}