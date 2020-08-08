/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS1_1;

import java.util.Scanner;

/**
 *
 * @author cuongnm
 */
public class WS1_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int hour;
        double minute;
        int total;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter hour:");
        hour = sc.nextInt();
        System.out.println("Enter minutes:");
        minute = sc.nextDouble();
        total = 60 * hour + minute;
        System.out.println("Total minutes :" + total);
        
    }

}
