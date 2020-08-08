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
public class Atoms {

    private int number;
    private String symbol;
    private String fullname;
    private float weight;

    public Atoms() {
    }

    public Atoms(int number, String symbol, String fullname, float weight) {
        this.number = number;
        this.symbol = symbol;
        this.fullname = fullname;
        this.weight = weight;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
  
    public boolean accept(){
        if(number > 0) {
            return true;
        }
        return false;
    }
    
    public void display() {
        System.out.println(number + " " + symbol + " " + fullname + " " + weight);
    }
}
