/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS2_1;

/**
 *
 * @author cuongnm
 */
public class WS2_1 {

    /**
     * @param args the command line arguments
     */
    //Create a code snippet that will print the even numbers from 2 to 10 using 
    //(a) a for loop and a continue statement and 
    //(b) a while loop and a boolean variable as a flag.
    public static void main(String[] args) {
        //a) Using  a for loop and a continue statement
        for (int i = 2; i <= 10; i++) {
            if (i % 2 != 0) {
                continue;
            }
            System.out.printf("%d\t",i);
        }
        System.out.printf("\n");
        //b) Using a while loop and a boolean variable as a flag
        int i = 2;
        boolean flag = true;
        while (flag) {
            if (i % 2 == 0) {
                System.out.printf("%d\t",i);
            }
            i++;
            if (i > 10) {
                flag = false;
            }
        }
    }

}
