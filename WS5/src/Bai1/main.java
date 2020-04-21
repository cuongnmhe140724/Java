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
        PhoneNumber phonelist[]  = new PhoneNumber[1000];
        int choice;
        int n = 0;
        do {
            System.out.println("Type of phone number ? (1 - local phone, 2 - Inter phone number, 0 - exit)");
            choice = Integer.parseInt(sc.nextLine());            
            if(choice == 1){
                System.out.print("Enter area code: ");
                int area = Integer.parseInt(sc.nextLine());
                System.out.print("Enter number: ");
                String number = sc.nextLine();
                phonelist[n] = new PhoneNumber(area, number);
                n ++;
            }
            if(choice == 2){
                System.out.print("Enter country code: ");
                String countryCode = sc.nextLine();
                System.out.print("Enter area code: ");
                int area = Integer.parseInt(sc.nextLine());
                System.out.print("Enter number: ");
                String number = sc.nextLine();
                phonelist[n] = new IntPhoneNumber(countryCode, area, number);
                n ++;
            }
        } while (choice != 0);
        System.out.println("List of number:");
        System.out.println("-----------------------------");
        for (int i = 0; i < n; i++) {
            phonelist[i].display();
        }
        
    }
    
}
