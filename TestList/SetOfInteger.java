import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.Collections;

public class SetOfInteger{
  public static void main(String[] args){
    Random rand = new Random(47);
    Set<Integer> intset = new HashSet<Integer>();
    Set<Integer> intset2 = new TreeSet<Integer>();
    for (int i = 0; i< 31; i++){
      intset.add(rand.nextInt(30));
    }
    for (int i = 0; i< 31; i++){
      intset2.add(rand.nextInt(30));
    }
    System.out.println(intset);
    System.out.println(intset.size());
    //TreeSet
    Set<String> set1 = new HashSet<String>();
    Collections.addAll(set1, "A B C D E F G H".split(" "));
    System.out.println(set1);
    
  }

}