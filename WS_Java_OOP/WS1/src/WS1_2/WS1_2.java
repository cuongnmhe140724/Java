/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS1_2;

import java.util.Scanner;

/**
 *
 * @author cuongnm
 */
public class WS1_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int stHour;
        int stMinute;
        int minutes;
        int endHour;
        int endMinute;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter start hour:");
        stHour = sc.nextInt();
        System.out.println("Enter start minutes:");
        stMinute = sc.nextInt();
        System.out.println("Enter minutes:");
        minutes = sc.nextInt();
        if (minutes > 60) {
            endHour = stHour + minutes / 60;
            endMinute = stMinute + minutes % 60;
        } else {
            if (minutes + stMinute >= 60) {
                endHour = stHour + 1;
                endMinute = stMinute + minutes - 60;
            } else {
                endHour = stHour;
                endMinute = stMinute + minutes;
            }
        }
        System.out.printf("If an event starts at %d %d and lasts %d minutes, it will end at %d %d\n", stHour, stMinute, minutes, endHour, endMinute);
    }

}
