/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai1;

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
        int size;
        String structure;
        String name;
        float weight;
        System.out.println("Enter numbers of molecules:");
        size = Integer.parseInt(sc.nextLine());
        Molecules[] molecules = new Molecules[size];
        for (int i = 0; i < size; i++) {
            System.out.println("Enter name");
            name = sc.nextLine();
            System.out.println("Enter structure");
            structure = sc.nextLine();
            System.out.println("Enter weight");
            weight = Float.parseFloat(sc.nextLine());
            molecules[i] = new Molecules(structure,name,weight);
        }
        for (int i = 0; i < size; i++) {
            molecules[i].display();
        }
    }

}
