public class TestNumber{
  public static void main(String [ ] args){
    //--------------------[Numbers类]---------------------------
    //1.xxValue()
    Integer x = 5;
    System.out.println(x.longValue());
    System.out.println(x.byteValue());
    //2. compareTo()
    //指定的数小于参数返回-1, 大于参数返回1, 等于返回0
    Integer y = 6;
    System.out.println(x.compareTo(y));
    //3. equals()
    System.out.println(x.equals(y));
    //4. toString()
    System.out.println(x.toString());
    //5.parseInt()
    String a = "666";
    System.out.println(Integer.parseInt(a));
    System.out.println(Double.parseDouble(a));//ParseDouble
    System.out.println(Integer.parseInt(a,16));//返回16进制(10,2,8.16)皆可
    //6. Math.abs(): 调用时使用 Math.abs(xxx)
    Integer z = -666;
    System.out.println(Math.abs(z));
    //7. Math.ceil(): 上舍入,只适用于float, double
    double i = 6.6;
    System.out.println(Math.ceil(i));
    //8. Math.floor() : 下舍入,只适用于float, double
    System.out.println(Math.floor(i));
    //9. Math.rint(): 返回最接近参数的整数值
    System.out.println(Math.rint(100.675));
    System.out.println(Math.rint(100.500));//返回100(模棱两可的时候返回偶数Int值)
    //10. Math.round(): 四舍五入= Math.floor(x+0.5); double/float
    System.out.println(Math.round(100.675));
    System.out.println(Math.round(100.500));
    //11. Math.min(a,b), Math.max(a,b): 注意a/b必须是同样数据类型
    System.out.println(Math.max(12.12,12.13));
    System.out.println(Math.min(12.13,12.12));
    //12. Math.exp()
    double d = 11;
    System.out.printf("exp(%.3f) 为 %.3f%n", d, Math.exp(d)); 
    //13. Math.log()
    System.out.printf("log(%.3f) 为 %.3f%n", d, Math.log(d));
    //14. Math.pow(x,y)= x^y
    System.out.println(Math.pow(2, 4));//16
    //15. Math.sqrt(double d)
    System.out.println(Math.sqrt(11.635));
    //16. Math.sin() Math.cos() Math.tan() Math.asin() Math.atan() Math.atan2()
    double degrees = 45.0;
    System.out.format("%.1f 度的正弦值为 %.4f%n", degrees, Math.sin(Math.toRadians(degrees)));
    //17. toDegrees() 转换为角度
    double double_num = 45.0;
    System.out.println(Math.toDegrees(double_num));//2578.3100....
    //18. toRadians() 转换为弧度
    System.out.println(Math.toRadians(double_num));//0.7853981....
    //19. random() 随机数 -- 返回double值
    double random_num = Math.random();
    System.out.println(random_num);
  }
}