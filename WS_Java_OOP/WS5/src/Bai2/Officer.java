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
public class Officer extends Person {

    double bSalary;

    public Officer() {
    }

    public Officer(String name, double bSalary) {
        super(name);
        this.bSalary = bSalary;
    }

    @Override
    double getSalary() {
        return bSalary;
    }
    
    @Override
    void display(){
        System.out.println(name +  " " + bSalary);
    }

}
