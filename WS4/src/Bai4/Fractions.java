/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai4;

/**
 *
 * @author cuongnm
 */
public class Fractions {

    private int numer;
    private int denom;

    public Fractions(int numer, int denom) {
        this.numer = numer;
        this.denom = denom;
    }

    public int getNumer() {
        return numer;
    }

    public void setNumer(int numer) {
        this.numer = numer;
    }

    public int getDenom() {
        return denom;
    }

    public void setDenom(int denom) {
        this.denom = denom;
    }

    public int findGCD(int a, int b) {
        while (a != b) {
            if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }
        return a;
    }

    public void simplify() {
        int i = findGCD(this.getNumer(), this.getDenom());
        this.setNumer(this.getNumer() / i);
        this.setDenom(this.getDenom() / i);
    }

    public void add(Fractions ps) {
        int nu = this.getNumer() * ps.getDenom() + ps.getNumer() * this.getDenom();
        int de = this.getDenom() * ps.getDenom();
        Fractions add = new Fractions(nu, de);
        add.simplify();
        System.out.println("Sum of two fractions = " + add.numer + "/" + add.denom);
    }

    public void subtraction(Fractions ps) {
        int nu = this.getNumer() * ps.getDenom() - ps.getNumer() * this.getDenom();
        int de = this.getDenom() * ps.getDenom();
        Fractions sub = new Fractions(nu, de);
        sub.simplify();
        System.out.println("Subtraction of two fractions = " + sub.numer + "/" + sub.denom);
    }

    public void multiplication(Fractions ps) {
        int nu = this.getNumer() * ps.getNumer();
        int de = this.getDenom() * ps.getDenom();
        Fractions multi = new Fractions(nu, de);
        multi.simplify();
        System.out.println("Product of two fractions = " + multi.numer + "/" + multi.denom);
    }

    public void division(Fractions ps) {
        int nu = this.getNumer() * ps.getDenom();
        int de = this.getDenom() * ps.getNumer();
        Fractions divis = new Fractions(nu, de);
        divis.simplify();
        System.out.println("Division of two fractions = " + divis.numer + "/" + divis.denom);
    }
}
