import java.io.*;

public class EmployeeTest{
  public static void main(String [ ] args){
    Employee empOne = new Employee("Worker1");
    Employee empTwo = new Employee("Worker2");

    empOne.empAge(26);
    empOne.empDesignation("High Level Programmer");
    empOne.empSalary(1000);
    empOne.printEmployee();

    empTwo.empAge(21);
    empTwo.empDesignation("Low Level Programmer");
    empTwo.empSalary(500);
    empTwo.printEmployee();
  }
}