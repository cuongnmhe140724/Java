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
public class Worker extends Person{
    double hrs;
    final double RATE = 5.5;

    public Worker() {
    }

    public Worker(String name, double hrs) {
        super(name);
        this.hrs = hrs;
    }
    
    @Override
    void display(){
        System.out.println(name + " " + hrs  + " " + this.getSalary());
    }
    

    @Override
    double getSalary() {
       return hrs * RATE;
    }
    
}
