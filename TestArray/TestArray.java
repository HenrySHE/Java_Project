public class TestArray{
  public static void main(String [ ] args){

    //----一个一个输入元素------
    int size = 6;
    double[] myList = new double[size];
    myList[0]=6.6;
    myList[1]=66.6;
    myList[2]=666.6;
    myList[3]=6666.6;
    myList[4]=66666.6;
    myList[5]=666666.6;
    for (int i =0; i < size ; i ++){
      System.out.println(myList[i]);
    }

    //----直接声明array-----
    double[] myList2 = {0.6,6.6,66.6,666.6,6666.6};
    //----遍历Array--------
    for(double element:myList2){
      System.out.println(element);
    }
    printDoubleArray(myList2);

    //----多维数组------
    int row = 2;
    int colunm = 2;
    int int_arr[][] = new int[row][colunm];
    int_arr[0][0] = 1;
    int_arr[0][1] = 2;
    int_arr[1][0] = 3;
    int_arr[1][1] = 4;
    //或者不定义是2*2，而是2*2+2*3
    String s[][]=new String[2][];
    s[0] = new String [2];
    s[1] = new String [3];


    //-------Array Class的方法----------

  }

  //------打印double类型的Array---
  public static void printDoubleArray(double[] array){
    for(int i =0; i<array.length; i++){
      System.out.print(array[i]+" ");
    }
  }
}