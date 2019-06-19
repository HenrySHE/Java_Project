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
        1. 静态变量(static) :关键字用来<u>声明独立于对象的静态变量</u>，无论一个类实例化多少对象，它的静态变量只有一份拷贝。 静态变量也被称为类变量。局部变量不能被声明为 static 变量。
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
