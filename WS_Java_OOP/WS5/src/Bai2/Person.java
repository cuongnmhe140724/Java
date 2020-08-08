/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai2;

/**
 *
 * @author cuongnm
 */
abstract class Person {
    String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }
    
    void display(){
        System.out.println(name);
    }
    
    abstract double getSalary();
}
