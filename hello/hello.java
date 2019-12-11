public class hello {
    public static void main(String []args) {
        System.out.println("Hello");
        List<List<String>> a = new ArrayList<>();
        List<String> tempList = new ArrayList<>();
        tempList.add("hello");
        a.add(tempList);
        System.out.println(a);
    }
}