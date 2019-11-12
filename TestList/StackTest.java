public class StackTest {
  public static void main (String[] args){
    //直接引用
    Stack<String> stack = new Stack<String>();
    for (String s: "My dog has fleas".split(" ")){
      stack.push(s);
    } 
    while(!stack.empty()){
      System.out.println(stack.pop() + " ");
    }
    stack.hello();
  }
}