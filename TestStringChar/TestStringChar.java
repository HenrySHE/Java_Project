/*
*@Author:  HenrySHE
*@Created_Time: 2019-06-20 15:52:52
*/

public class TestStringChar{
  public static void main(String [ ] args){
    //1. charArray to String
    char[] testChar = {'a','0','6','6','6'};
    String testString = new String(testChar);
    System.out.println(testString);

    //2. get String Length;
    System.out.println("String Length is: "+ testString.length());
    //char没有.length方法
    
    //3. connect String
    String concatString = testString.concat("666");
    System.out.println("Concat String Result is: "+ concatString);

    //4. Format the value
    float floatVar = 0.666f;
    int intVar = 666;
    String stringVar = "A0666";
    String string_result = String.format("Floating point: %f, Int value: %d, String value: %s",floatVar,intVar, stringVar);
    System.out.println(string_result);
    //Floating point: 0.666000, Int value: 666, String value: A0666   

    //5. char CharAt(int index)
    char val = string_result.charAt(19);
    System.out.println("Result on index 19 is:" + val);
    //Result on index 19 is:6

    //6. int compareTo(Object o)
    // a.compareTo(b), if a==b, return 0; if a<b, return num<0, else return num>0
    String str1 = "a0666";
    String str2 = "A0666";
    String str3 = "a06661";
    int result = str1.compareTo(str2);
    System.out.println("Compare result is:" + result);// 32
    System.out.println("Compare str with one letter diff: "+str1.compareTo(str3)); // -1

    //7. int ocmpareToIgnoreCase(String str) 忽略大小写比较
    System.out.println("Compare without case: "+str1.compareToIgnoreCase(str2));//0

    //8. boolean contentEquals(StringBuffer sb) 用于和指定的stringBuffer比较
    StringBuffer str4 = new StringBuffer("666");
    System.out.println(str3.contentEquals(str4));
  }
}