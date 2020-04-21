/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai4;

import java.util.Scanner;

/**
 *
 * @author cuongnm
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numer1, numer2;
        int denom1,denom2;
        
        System.out.println("Enter numerator of fractions 1:");
        numer1 = Integer.parseInt(sc.nextLine()); 
        System.out.println("Enter denominator of fractions 1");
        denom1 = Integer.parseInt(sc.nextLine());
        System.out.println("Enter numerator of fractions 2:");
        numer2 = Integer.parseInt(sc.nextLine());
        System.out.println("Enter denominator of fractions 2:");
        denom2 = Integer.parseInt(sc.nextLine());
        
        Fractions fraction1=new Fractions(numer1,denom1);   
        Fractions fraction2=new Fractions(numer2,denom2);
         
        // test method addition, subtraction, multiplication and division
        fraction1.add(fraction2);
        fraction1.subtraction(fraction2);
        fraction1.multiplication(fraction2);
        fraction1.division(fraction2);


    }
    
}
