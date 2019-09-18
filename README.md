# Java_Project

> @Author: HenrySHE
>
> @Created Time: 2019-06-18
>
> @Description: A project for reviewing Java knowledge, including Java basic data structure, algorithm, maven project, spring boost and etc.

Learning resources:
- [Runoob](https://www.runoob.com/java/java-tutorial.html): For reviewing the basic knowledge of Java
- [Spring Boot GitHub](https://github.com/hemin1003/SpringBoot-Learning) : For learning Spring
- **Spring Boot in Action**: A book that teach Spring Boot step by step

----

**Cloud Studio 教程:**
1. [代码编辑](https://dev.tencent.com/help/cloud-studio/editor-usage)
2. [配置 SSH 公钥访问代码仓库](https://dev.tencent.com/help/doc/faq/bbe781aee786/ssh)
3. [GitHub添加SSH公钥](https://dev.tencent.com/help/cloud-studio/how-to-add-ssh)
4. [选择,切换,删除,发布环境](https://dev.tencent.com/help/cloud-studio/environment)
5. [协同编辑](https://dev.tencent.com/help/cloud-studio/collaborate)

Maven: create a project form terminal: [[link]](https://www.mkyong.com/maven/how-to-create-a-java-project-with-maven/)

----

**Compile and run `.java`  file:**
```shell
javac hello.java
# The hello should match the class name (public class hello{...})
java hello
```

**创建,引用(变量/方法)**
```Java
/* 实例化对象 */ 
Object referenceVariable = new Constructor(); 
/* 访问类中的变量 */ 
referenceVariable.variableName; 
/* 访问类中的方法 */ 
referenceVariable.methodName();
```

----

**源文件声明**


- 一个源文件中只能有一个public类
- 一个源文件可以有多个非public类
- 源文件的名称应该和public类的类名保持一致。
    - 例如：源文件中public类的类名是Employee，那么源文件应该命名为Employee.java。
- 如果一个类定义在某个包中，那么package语句应该在源文件的首行。
- 如果源文件包含import语句，那么应该放在package语句和类定义之间。如果没有package语句，那么import语句应该在源文件中最前面。
- import语句和package语句对源文件中定义的所有类都有效。在同一源文件中，不能给不同的类不同的包声明。


类有若干种访问级别，并且类也分不同的类型：抽象类和final类等。这些将在访问控制章节介绍。除了上面提到的几种类型，Java还有一些特殊的类，如：内部类、匿名类。

----

### 项目文件:
```shell
├── Dog # 对象的重载
│   ├── Dog.class
│   └── Dog.java
├── Employee # Employee是创建雇员对象的文件, Test是存储对象信息,调用函数测试
│   ├── Employee.class
│   ├── Employee.java
│   ├── EmployeeTest.class
│   └── EmployeeTest.java
├── hello
│   ├── hello.class # 打印hello的文件
│   └── hello.java
└── README.md
├── NumberMath # Math方法集合
│   ├── TestNumber.class
│   └── TestNumber.java
├── README.md
└── TestPrimitiveType #查看基本数据长度
    ├── PrimitiveTypeTest.class
    ├── PrimitiveTypeTest.java
    ├── result.txt
    ├── TestDefaultValue.class
    └── TestDefaultValue.java

```

----

## Java 基本数据类型:


### 1. Java 内置类型
| Data Type | Length  | Description |
| --- | --- | --- |
| byte | (8bit)-2^7~2^7-1 | only cost 1/4 with `int` |
| short | (16bit) -2^15~2^15-1 | only cost 1/2 of `int` |
| int | (32bit) -2^31 ~2^23-1 | `0`  default |
| long | (64bit) -2^63 ~ 2^63-1 (64)| `0L` default |
| float | (32bit) | 0.0f (default) eg: `float f1=2.345f;`  |
| double | (64bit) | 0.0d (default) eg: `double d1 = 1.234;` |
| boolean | true/false | `false` as default |
| char | (16bit) 0~65,535 | `u0000`as default eg: `char letter='A';` |
| String | - |`null` as default

**Paremeters Default values**

```shell
Bool :false
Byte :0
Character:
Double :0.0
Float :0.0
Integer :0
Long :0
Short :0
String :null
```

### 2. Java常量 (not editable)
> use `final` to define the paremeter.

- 通常常量**开头大写**
- long, int, long, short 可赋予十进制,十六进制,八进制:
    - 八进制: `0`, 例如:  `octal = 0144` 
    - 十六进制: `0x` 例如: `int hexa = 0x64`  

- Java 转义符:
    - `\n` 换行
    - `\r` 回车
    - `\f`换页符
    - `\b`退格
    - `\0`空字符
    - `\s`字符串
    - `\t` 制表符
    - `\"` 双引号
    - `\'`单引号
    - `\\`反斜杠
    - `\ddd` 八进制字符
    - `\uxxxx`十六进制Unicode字符 
    
### 3. 类型转换:

> 转换从低级到高级:(低  --------> 高)`byte,short,char—> int —> long—> float —> double `，会有精度上面的损失，也有可能会导致溢出精度；

转换方式:
1. 自动转换
2. 强制转换


## Java 变量类型:

### 1. 变量声明
```java
int a, b, c;                                    // 声明三个int型整数：a、 b、c 
int d = 3, e = 4, f = 5;                    // 声明三个整数并赋予初值 
byte z = 22;                                 // 声明并初始化 z 
String s = "runoob";                      // 声明并初始化字符串 s 
double pi = 3.14159;                     // 声明了双精度浮点型变量 pi 
char x = 'x';                                 // 声明变量 x 的值是字符 'x'。
```

### 2. 变量类型(3种)
1. **类变量(静态变量)** (独立于方法之外的变量,用static修饰)
    1. 类变量也称为静态变量，**在类中以 static 关键字声明，但必须在方法之外。**
    2. 无论一个类创建了多少个对象，类只拥有类变量的一份拷贝。
    3. 静态变量除了被声明为常量外很少使用。常量是指声明为public/private，final和static类型的变量。常量初始化后不可改变。
    4. 静态变量储存在静态存储区。<u>经常被声明为常量，很少单独使用static声明变量</u>。
    5. 静态变量在第一次被访问时创建，在程序结束时销毁。
    6. 与实例变量具有相似的可见性。<u>但为了对类的使用者可见，大多数静态变量声明为public类型</u>。
    7. 默认值和实例变量相似。数值型变量默认值是0，布尔型默认值是false，引用类型默认值是null。变量的值可以在声明的时候指定，也可以在构造方法中指定。此外，静态变量还可以在静态语句块中初始化。
    8. 静态变量可以通过：ClassName.VariableName的方式访问。
    9. 类变量被声明为public static final类型时，类变量名称一般建议使用大写字母。如果静态变量不是public和final类型，其命名方式与实例变量以及局部变量的命名方式一致。
2. **实例变量** (独立于方法之外的变量, 没有static修饰)
    1. 实例变量声明在一个类中，但在方法、构造方法和语句块之外；
    2. 当一个对象被实例化之后，每个实例变量的值就跟着确定；
    3. 实例变量在对象创建的时候创建，在对象被销毁的时候销毁；
    4. 实例变量的值应该至少被一个方法、构造方法或者语句块引用，使得外部能够通过这些方式获取实例变量信息；
    5. 实例变量**可以声明在使用前或者使用后**；
    6. 访问修饰符可以修饰实例变量；
    7. 实例变量对于类中的方法、构造方法或者语句块是可见的。一般情况下应该把实例变量设为私有。通过使用访问修饰符可以使实例变量对子类可见；
    8. **实例变量具有默认值**。数值型变量的默认值是0，布尔型变量的默认值是false，引用类型变量的默认值是null。变量的值可以在声明时指定，也可以在构造方法中指定；
    9. **实例变量可以直接通过变量名访问。**但在静态方法以及其他类中，就应该使用完全限定名：ObejectReference.VariableName。
3. **局部变量** (类的方法中的变量)
    1. 局部变量声明在方法、构造方法或者语句块中；
    2. 局部变量在方法、构造方法、或者语句块被执行的时候创建，当它们执行完成后，变量将会被销毁；
    3. 访问修饰符不能用于局部变量；
    4. 局部变量只在声明它的方法、构造方法或者语句块中可见；
    5. 局部变量是在栈上分配的。
    6. **局部变量没有默认值**，所以局部变量被声明后，<u>必须经过初始化，才可以使用</u>。

```java
public class Variable{
    static int allClicks=0; // 类变量
    String str="hello world"; // 实例变量 
    public void method(){ 
        int i =0; // 局部变量 
    } 
}
```

## Java修饰符

### 1. 修饰符的种类:
1. 访问修饰符
    1. default (就是缺省): 在同一包内可见，不使用任何修饰符。使用对象：类、接口、变量、方法。
    2. private: 在同一类内可见。使用对象：变量、方法。 注意：不能修饰类（外部类）
    3. public: 对所有类可见。使用对象：类、接口、变量、方法
    4. protected: 对同一包内的类和所有子类可见。使用对象：变量、方法。 注意：**不能修饰类（外部类）**。我们可以通过以下表来说明访问权
2. 非访问修饰符
    1. static修饰符
        1. 静态变量(static) :关键字用来<u>声明独立于对象的静态变量</u>，无论一个类实例化多少对象，它的静态变量只有一份拷贝。 静态变量也被称为类变量。局部变量不能被声明为 static 变量。**这样做有两个好处：1）你的值只需要存在一个存储空间，重复创建对象不会占用多余的空间；2）你的方法、变量不用和你的对象绑定，即使new对象，也可以调用这个方法、变量。《Java编程思想》P29-30**
        2. 静态方法:  static 关键字用来<u>声明独立于对象的静态方法</u>。静态方法不能使用类的非静态变量。静态方法从参数列表得到数据，然后计算这些数据。
    2. final修饰符
        1. final变量: 变量一旦赋值后，不能被重新赋值。被 final 修饰的实例变量必须显式指定初始值。
        2. final方法: final类中的 final 方法可以被子类继承，但是不能被子类修改。声明 final 方法的主要目的是防止该方法的内容被修改。
        3. final类: final 类不能被继承，没有类能够继承 final 类的任何特性。`public final class Test {...}`
    3.  abstract修饰符
        1.  抽象类: 
            1.  抽象类不能用来实例化对象，声明抽象类的唯一目的是为了将来对该类进行扩充。
            2.  一个类不能同时被 abstract 和 final 修饰。如果一个类包含抽象方法，那么该类一定要声明为抽象类，否则将出现编译错误。
            3.  抽象类可以包含抽象方法和非抽象方法。
        2.  抽象方法:
            1.  抽象方法是一种没有任何实现的方法，该方法的的具体实现由子类提供。
            2.  抽象方法不能被声明成 final 和 static。
            3.  任何继承抽象类的子类必须实现父类的所有抽象方法，除非该子类也是抽象类。
            4.  如果一个类包含若干个抽象方法，那么该类必须声明为抽象类。
            5.  抽象类可以不包含抽象方法。抽象方法的声明以分号结尾，例如：`public abstract sample();`。
    4. synchronized修饰符: synchronized 关键字声明的方法同一时间只能被一个线程访问。synchronized 修饰符可以应用于四个访问修饰符。
    5. transient修饰符: 序列化的对象包含被 transient 修饰的实例变量时，java 虚拟机(JVM)跳过该特定的变量。该修饰符包含在定义变量的语句中，<u>用来预处理类和变量的数据类型</u>。
    6. volatile修饰符: volatile 修饰的成员变量在每次被线程访问时，<u>都强制从共享内存中重新读取该成员变量的值。而且，当成员变量发生变化时，会强制线程将变化值回写到共享内存。</u>这样在任何时刻，两个不同的线程总是看到某个成员变量的同一个值。一个 volatile 对象引用可能是 null。


### 访问控制和继承:

- 父类中声明为 public 的方法在子类中也必须为 public。
- 父类中声明为 protected 的方法在子类中要么声明为 protected，要么声明为 public，不能声明为 private。
- 父类中声明为 private 的方法，不能够被继承。 

## Java 运算符

1. 算术运算符: (`+  -  *  /  %  ++ --`)
    1. 注意`b = 2*++a`是先自增,然后再乘; `b=2*a++` 则是先乘,后自增
2. 关系运算符: (`==  !=  >  <  >=  <=`)
3. 位运算符: (`&  |  ^  ~  <<  >> >>>`)
    1.  `&`: 对位都是1,则结果为1,否则为0
    2.  `|` : 对位都是0,则结果为0,否则为1
    3.  `^`: 对位相同,结果为0,否则为1
    4.  `~`: 翻转(0变1, 1变0)
    5.  `<<`: 左位移
    6.  `>>>`: 按位移右移补0操作: `A=0001 1100, A>>>2 = 0000 1111(2) = 15(10)`
4. 逻辑运算符: (`&&  ||  !`)
5. 赋值运算符: (`=  +=  -=  *=  /=  (%)=  <<=  >>=  &=  ^=  |`)
6. 其他运算符: 
    1. 条件运算符: `?:` 例子(如果 a 等于 1 成立，则设置 b 为 20，否则为 30)  `b = (a == 1) ? 20 : 30;`
    2. `instaneof` 运算符: 返回`true/false`

## Java 循环:

几种循环方法:
- while 循环
- do..while循环
- for循环
- Java增强for循环: 
- break 关键字: 遇到某些条件即刻跳出循环
- continue关键字 : 跳过某些条件下的操作

### 1. Java增强for循环: (<u>主要用于数组(`int[]`或者 `String []`)</u>)

```java
public class Test { 
    public static void main(String args[]){ 
        int [] numbers = {10, 20, 30, 40, 50}; 
        for(int x : numbers ){ 
            System.out.print( x );
            System.out.print(",");
        } 
        System.out.print("\n");
        String [] names ={"James", "Larry", "Tom", "Lacy"};
        for( String name : names ) {
            System.out.print( name ); 
            System.out.print(","); 
        } 
    } 
}

// Answer:
//10,20,30,40,50,
//James,Larry,Tom,Lacy,
```

## Java Switch Case
格式:
```java
switch(expression){
    case value:
        //--do sth
        break;
    case value:
        //--do sth
        break;
    default:
        //--do sth
 }
```
- switch 语句中的变量类型可以是：**byte、short、int 或者 char** 。从 Java SE 7 开始，switch 支持**字符串 String** 类型了，同时 case 标签必须为字符串常量或字面量。
- 当遇到 break 语句时，switch 语句终止。程序跳转到 switch 语句后面的语句执行。case 语句不必须要包含 break 语句。**如果没有 break 语句出现，程序会继续执行下一条 case 语句，直到出现 break 语句**。
- switch 语句可以包含一个 default 分支，该分支一般是 switch 语句的最后一个分支（可以在任何位置，但建议在最后一个）。default 在没有 case 语句的值和变量值相等的时候执行。**default 分支不需要 break 语句**。
- 如果当前匹配成功的 case 语句块没有 break 语句，**则从当前 case 开始，后续所有 case 的值都会输出，如果后续的 case 语句块有 break 语句则会跳出判断**。

例子:
```java
public class Test{
    public static void main(String args[]){
        int i = 1;
        switch(i){
            case 0:
                System.out.println("0");
            case 1:
                System.out.println("1");
            case 2:
                System.out.println("2");
            case 3:
                System.out.println("3"); 
                break;
            default:
                System.out.println("default");
        }
    }
}

// 结果:
// 1
// 2
// 3
```

## Java Number,Math类
Number，Math类:
1. xxxValue(): 类型转换然后显示数值:
```java
Integer x = 5;
System.out.println(x.byteValue());
System.out.println(x.doubleValue());
```
2. compareTo(): 对比数值大小, 相等返回0,小于返回-1, 大于返回
3. equuals()
4. valueOf()
...
(具体参考`NumberMath/TestNumber.java`文件)

## Java Character类

> 3 types of char value:
>
> - Single character initialization: `char ch= 'a';`
> - Initialize Unicode: `char uniChar='\u039A;'`
> - Char Array: `char[] charArray = {'a','b','c'};`

构造对象的方式去创建character: `Character ch = new Character('a');`

### 1. 转义字符

| 转义序列 |         描述         |
| :------: | :------------------: |
|    \t    |   在文中插入tab键    |
|    \b    | 在文中插入一个后退键 |
|    \n    |    在文中该处换行    |
|    \r    |    在文中插入回车    |
|    \f    |   在文中插入换页符   |
|    \'    |   在文中插入单引号   |
|    \"    |   在文中插入双引号   |
|    \\    |   在文中插入反斜杠   |



### 2. Character 方法

Reference [[link]](https://www.runoob.com/manual/jdk1.6/java/lang/Character.html)

| Index | Methods          | Description                                |
| ----- | ---------------- | ------------------------------------------ |
| 1     | `isLetter()`     | `Boolean a = Character.isLetter('a');`     |
| 2     | `isDigit()`      | `Boolean a = Character.isDigit('a');`      |
| 3     | `isWhitespace()` | `Boolean a = Character.isWhitespace('a');` |
| 4     | `isUpperCase()`  | `Boolean a = Character.isUpperCase('a');`  |
| 5     | `isLowerCase()`  | `Boolean a = Character.isLowerCase('a');`  |
| 6     | `toUpperCase()`  | `Char a = Character.toUpperCase('a');`     |
| 7     | `toLowerCase()`  | `Char a = Character.toLowerCase('a');`     |
| 8     | `toString()`     | `String a = Character.toString('a');`      |


## Java String 类

最基本创建String: `String str = 'this is a string';`

构造方法创建`String对象`:

```java
public class StringTest{
    public static void main(String args[]){
        //initialize a char array
        char[] charArr = {'a','b','c','d'};
        //Create a String Obj
        String charStr = new String(charArr);
        System.out.println(charStr);
    }
}
```

1. 拼接String: 
   1. `"a".concat("b")`
   2. `"a"+"b"` (more easy, more commonly used)

2. String Formatting (字符串格式规范化): 使用`printf()`和`format()`来规范

   - 使用静态方法`format()`可以使用返回一个String对象,*可以创建可复用字符串*,而不是仅仅用于打印输出;

   ```java
   String fs;
   fs = String.format("浮点型变量的值为 " +
                      "%f, 整型变量的值为 " +
                      " %d, 字符串变量的值为 " +
                      " %s", floatVar, intVar, stringVar);
   //---------------[or you can just print]-------------------
   System.out.printf("浮点型变量的值为 " +
                     "%f, 整型变量的值为 " +
                     " %d, 字符串变量的值为 " +
                     "is %s", floatVar, intVar, stringVar);
   
   ```



### 1. String 方法

> 方法比较多，没有完全罗列出来，
>
> Reference [[link]](https://www.runoob.com/java/java-string.html), [[API文档]](https://www.runoob.com/manual/jdk1.6/java/lang/String.html)

具体方法参考`testStringChar/TestStringChar.java`文件。



## Java 数组

### 1. 数组变量声明

1. `dataType[] arrayRefVar;`  建议首选使用. 例: `double[] myList;`
2. `dataType arrayRefVar[];`  效果相同 例: `double myList[];`



### 2. 创建数组(new obj)

先声明: `arrayRefVar = new dataType[arraySize];`

直接创建: `dataType[] arrayRefVar = {value0, value1, value2};`

数组的**声明, 创建, 遍历**: (`TestArray/TestArray.java`)

```java
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
```

## Java 方法

### 1. 方法的定义:
- 是解决一类问题步骤的有序集合
- 方法包含于类与对象中
- 在程序中被创建, 在其他地方被引用 

### 2. 方法的优点：
- 是程序简短而清晰
- 有利于程序的维护
- 提高开发效率
- 提高代码重用

### 3. 方法的命名规则：
- 第一个单词以小写字母作为开头，后面的单词就用大写字母开头； 例如： `addPerson`,`editProfile`等等 
- 下划线可能出现在JUnit测试方法名称，例如： `testPop_emptyStack` 

### 4. 方法的定义

```java
修饰符[public static] 返回值类型[int/boolean/float] 方法名[findmax] (参数类型[int] 参数名[i]){
    方法体
    return 返回值
}
例如:
public static int age(int birthday) {...}
```

### 5. 方法的重载
 相同的方法名, 不同的参数, 调用的时候就会根据传递的参数去决定调用那个方法.
 
 ### 6. 变量作用域
 
 - 方法内定义的，称作**局部变量**
 - 局部变量必须声明才可以使用
 - for循环声明的变量，作用范围在整个循环

### 7.命令行参数（运行的时候伴随参数的传递）

```java
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
```

### 8. 构造方法/构造函数

1. 目的: 用来初始化对象;
2. 属性: 构造方法和所在的类名字相同,但**没有返回值**.
3. 所有类都有构造方法, (只是你不定义的话,Java自己默认定义构造方法), 一旦自己定义,默认构造方法就失效

#### 8.1 构造函数简单例子: (查看`/TestMethods/ConsDemo.java`文件)
```java
class MyClass{
    int x;
    MyClass(){
        x = 10;
    }    

public class ConsDemo{
    public static void main(String args[]){
        MyClass t1 = new MyClass(10);
        System.out.println(t1.x);
    }
}

```

### 9. 可变参数
格式: ` typeName... paremeterName`  (在指定参数类型后面加省略号)
(具体查看`TestMethods/VarargsDemo.java`文件

```java
public class VarargsDemo{
    public static void main (String args []){
        printMax(34,3,3,2,56.5);
        printMax(new double[]{1,2,3});
    }
    public static void printMax(double... numbers){
        if (numbers.length == 0){
            System.out.println("No args.");
        return;
        }
        double result = numbers[0];
        for (int i =1; i< numbers.length; i++){
            if(numbers[i]>result){
            result = numbers[i];
        }
        }
        System.out.println("The max value is "+ result);
        //The max value is 56.5
        //The max value is 3.0
    }
}
```

### 10. Finalization

在对象被垃圾收集器析构之前调用。
作用： 用来清除回收对象

格式：
```java
protected void finalize() throws java.lang.Throwable{
    super.finalize();
    System.out.println(id + "is desposed.");
}
```

## Java Stream, File and IO (输入输出操作）
> - Java.io基本包含了所有的操作输入,输出需要的类。
> - Java.io支持很多格式
> - Stream可以理解为数据的序列
> - Java对IO有很强大灵活的支持

### 1. Reading terminal input (读取控制台输入) `System.in`
创建`BufferedReader`去读取字符流：
```java
BufferedReader br = new BufferedReader(new
                                InputStreamReader(System.in));
```
**读取：**
- `read()`读取**单个字符**
-`readLine()`读取**一个字符串**

read()方法类型：`int read() throws IOException`
每次调用read()方法，就会从IO Stream里面读取一个字符，当作**Int**类型返回（要强制转换成char才能print）。然后Stream结束之后返回`-1`。

**read() 示例：**
```java
import java.io.*;

public class BRRead{
    public static void main (String args[]) throws IOException {
        char c;
        BufferedReader br = new BufferReader(new InputStreamReader(System.in));
        System.out.println("输入字符，按下‘q’退出。");
        do {
            //将int类型的数字强制转换成char类型
            c = (char) br.read();
            System.out.println(c);
        }while (c!='q');
    }
}
```

**readLine()示例**
```java
import java.io.*;

public class BRReadLines{
    public static void main (String args[]) throws IOException {
        String str;
        BufferedReader br = new BufferReader(new InputStreamReader(System.in));
        System.out.println("输入字符，按下‘end’退出。");
        do {
            //str类型就不需要转换
            str = br.readLine();
            System.out.println(str);
        }while (!str.equals("end");
    }
}
```

### 2. 控制台输出
常用： `System.out.println()` / `System.out.print()` / `System.out.write()`
用法都差不多，就是输出到控制台。 `write()`已经不太常用

### 3. File I/O

分为`InputStream`/`OutputStream`

例子：
```java
import java.io.*;
public class fileStreamTest{
    public static void main (String args[]){
        try {
            byte bWrite[] = {11,21,3,20,5};
            OutputStream os = new FileOutputStream("test.txt");
            for (int x =0; x< bWrite.length; x++){
                os.write(bWrite[x]);
            }
            os.close();
            
            Input Stream is = new FileInputStream("test.txt");
            int size = is.avalizble();
            
            for (int i = 0; i<size; i++){
                System.out.print((char) is.read() + "  ");
            }
            is.close;
        }catch (IOException e){
            System.out.print("Exception");
        }
    }
}
```

### 4. Java 目录


1. 创建目录
   - `mkdir()`用来创建一个文件夹,返回类型为true/false. False证明路径已经存在,或整个路径还不存在
   - `mkdirs()`则是用来创建所有文件夹以及子文件夹(创建多个)

```java
import java.io.File;

public class CreateDir{
    public static void main(String args[])
}
```



2. 读取目录
   - 其实就是`File`对象,包含其他文件夹
   - 可以通过`list()`方法来获取包含的文件以及文件夹

```java
import java.io.File;

public class DirList{
    public static void main(String args[]){
        String dirname = "/tmp";
        File f1 = new File(dirname);
        if (f1.isDirectory()){
            System.out.println("目录"+dirname);
            String s[]=f1.list();
            for(int i = 0;i<s.length;i++){
                if(f.isDirectory()){
                    System.out.println(s[i] + "是一个目录");
                }else{
                    System.out.println(s[i] + "是个文件");
                }
            }
        }else{
            System.out.println(dirname + "不是一个目录");
        }
    }
}
```

3. 删除目录或文件
   - 可以用`java.io.File.delete()`来删除


## Thinking in Java NotesNotes 《Java编程思想》

### this关键字
构造函数--This的使用方法`/TestKeywordThis/Leaf.java/`

```java
public class Leaf{
  int i = 0;
  Leaf increment(){
    i++;
    return this;
  }

  void print(){
    System.out.println("i = "+ i);
  }

  public static void main(String[] args){
    Leaf x = new Leaf();
    Leaf y = new Leaf();
    x.increment().increment().increment().print(); //i = 3
    y.increment().print();// i = 1
  }
}

```
因为返回了当前对象的引用，所以方便一条语句里面对同一对象重复操作。

### 测试继承
> 这里有重写方法,并且在同一个java文件里面写了2个main funcion, 并且告诉了如何调用非public class里面的Main方法 (★★★★★))
```java
/*
2019年9月17日17:38:25
测试继承
*/

class Cleanser{
  private String s = "Cleanser";
  public void append(String a) { s += a ;}
  public void dilute() {append(" dilute()");}
  public void apply() {append(" apply()"); }
  public void scrub() { append(" scrub()"); }
  public String toString(){
    return s;
  }
  
  public static void main(String[] args){
    Cleanser x = new Cleanser();
    x.dilute();
    x.apply();
    x.scrub();
    System.out.println(x);
  }
}

class Detergent extends Cleanser{
  //重写方法
  public void scrub(){
    //添加新的方法
    append("Detergent.scrub() ");
    //继承之前的scrub方法
    super.scrub();
  }

  public void foam(){ append(" foam()");}

  public static void main (String[] args){
    Detergent x = new Detergent();
    x.dilute();
    x.apply();
    x.scrub();
    x.foam();
    System.out.println(x);
    System.out.println("Testing base class:");
    //调用其他方法里面的那个main方法
    Cleanser.main(args);
    System.out.println("Testing DettergenSon (extended form Detergent class)");
    DettergentSon.main(args);
  }
}

//附加作业,添加一个继承于Detergent的,命名为DettergentSon,然后覆盖原来scrub方法
//接着添加一个自己的方法"sterilize()"

class DettergentSon extends Detergent{
  public void scrub(){
    //do nothing
    //覆盖原来的方法
  }
  public void sterilize(){
    append(" sterilize()");
  }

  public static void main(String[] args){
    DettergentSon s = new DettergentSon();
    s.dilute();
    s.apply();
    s.scrub();
    s.foam();
    s.sterilize();
    System.out.println(s);
  }
}
/*
Cleanser dilute() apply()Detergent.scrub()  scrub() foam()
Testing base class:
Cleanser dilute() apply() scrub()
Testing DettergenSon (extended form Detergent class)
Cleanser dilute() apply() foam() sterilize()
*/
```
To be continued..