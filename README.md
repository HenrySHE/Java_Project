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
