/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai1;

/**
 *
 * @author cuongnm
 */
public class PhoneNumber {

    int area;
    String number;

    public PhoneNumber() {
    }

    public PhoneNumber(int area, String number) {
        this.area = area;
        this.number = number;
    }
    
    void display(){
        System.out.println(area + " - " + number);
    }

    public void setArea(int area) {
        this.area = area;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    
    public int getArea() {
        return area;
    }

    public String getNumber() {
        return number;
    }
    
    

}
