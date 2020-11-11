import java.util.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Minh Thanh
 */
public class Employee implements Comparable{

    String code;
    String name;
    String sex ;
    double salary;
    double bonus;
    double income = salary + bonus;

    public Employee() {
    }

    public Employee(String code, String name,String sex ,double salary, double bonus, double income) {
        this.code = code;
        this.name = name;
        this.sex = sex;
        this.salary = salary;
        this.bonus = bonus;
        this.income = income;
    }

//    Employee(String string, String string0, String string1, int i, int i0, int i1) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public String toString() {
        return "%-10s" + code + "|%-10s" + name + "|%-10s" + sex + "|%-10s" + salary
                + "|%-10s" + bonus + "|%-10s" + income;
    }

    @Override
    public int compareTo(Object o) {
        Employee y = (Employee) o;
        return (name.compareTo(y.name));
    }

}
