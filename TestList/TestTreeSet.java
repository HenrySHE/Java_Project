import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

public class TestTreeSet{
  public static void main(String[] args){
    Random rand  = new Random(47);
    SortedSet<Integer> intset = new TreeSet<>();
    for (int i = 0; i< 1000; i++) {
      intset.add(rand.nextInt(30));
    }
    System.out.println(intset);
  }
}