/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai2;

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
        Atoms[] at = new Atoms[10];
        for (int i = 0; i < 10; i++) {
            at[i] = new Atoms();
            System.out.printf("Enter atomic number:");
            at[i].setNumber(Integer.parseInt(sc.nextLine()));
            if (at[i].accept() == false) {
                break;
            }
            System.out.printf("Enter symbol:");
            at[i].setSymbol(sc.nextLine());
            System.out.printf("Enter full name:");
            at[i].setFullname(sc.nextLine());
            System.out.printf("Enter weight:");
            at[i].setWeight(Float.parseFloat(sc.nextLine()));
        }
        for(int i = 0; i < 10;i++){
            if(at[i].accept() == false) break;
            at[i].display();
        }
    }

}
