/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS1_3;

import java.util.Scanner;

/**
 *
 * @author cuongnm
 */
public class WS1_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String firstName;
        String middleName;
        String lastName;
        String fullName;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your firt name: ");
        firstName = sc.nextLine();
        System.out.println("Enter your middle name: ");
        middleName = sc.nextLine();
        System.out.println("Enter your last name:");
        lastName = sc.nextLine();
        fullName ="Hello" + " " + firstName + " " + middleName + " " + lastName;
        System.out.println(fullName);
    }
    
}
