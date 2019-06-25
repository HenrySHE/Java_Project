public class CommandLine{
    public static void main(String args[]){
        for (int i=0; i<args.length; i++){
            System.out.println("args["+i+"]:" + args[i]);
            //execute: javac CommandLine hello world test
            // args[0]: hello
            // args[1]: world
            // args[2]: test
        }
    }
}