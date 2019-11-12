import java.awt.List;
import java.util.ArrayList;

public class SaveCarBrand{
  public static void main(String[] args){
    ArrayList<String> carBrandList = new ArrayList<>();
    ArrayList<ArrayList<String>> wholeCarBrandList = new ArrayList<>();
    carBrandList.add(0,"比亚迪");
    carBrandList.add(1,"NULL");
    carBrandList.add(2,"广汽传祺");
    wholeCarBrandList.add(carBrandList);
    carBrandList.add("沃尔沃");
    ArrayList<String> carBrandList1 = new ArrayList<>();
    carBrandList1.add("东风本田");
    wholeCarBrandList.add(carBrandList1);
    int index = 0;
    String ar1 = "";
    for (ArrayList<String> carBrand: wholeCarBrandList){
      System.out.println(index + carBrand.toString());
      System.out.println("Size="+carBrand.size());
      if (carBrand.size() == 1){
        for (String item: carBrand){
          System.out.println(item);
          ar1 = item;
        }
      }
      
      index++;
    }
    // ar1 = "NULL";
    if ("NULL".equals(ar1)){
      System.out.println("这一条数据里面没有识别到任何汽车");
    }else{
      System.out.printf("ar1 = %s\n", ar1);
    }
    // System.out.println(carBrandList);
    // System.out.println(wholeCarBrandList);
  }
}