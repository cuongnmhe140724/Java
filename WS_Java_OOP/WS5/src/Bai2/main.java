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
        Person[] e = new Person[10];
        int n = 0, c = 0;
        do{
            System.out.println("Worker (1); Officer(2): Exit(0): ");
            Scanner in = new Scanner(System.in);
            c = Integer.parseInt(in.nextLine());
            if(c == 1){
                //accept information of worker
                System.out.print("Enter worker name: ");
                String name = in.nextLine();
                System.out.print("Enter worker working hours: ");
                int hrs = Integer.parseInt(in.nextLine());
                e[n] = new Worker(name, hrs);
                n++;
            }else if(c == 2){
                //accept information of Officer
                System.out.print("Enter Officer name: ");
                String name = in.nextLine();
                System.out.print("Enter officer salary: ");
                double salary = Double.parseDouble(in.nextLine());
                e[n] = new Officer(name, salary);
                n++;
            }
        }while(c != 0);
        //print all objects of e
        System.out.println("List worker:");
        for(int i = 0; i < n; i++){
            //print the instance of Worker only
            if(e[i] instanceof Worker){
                e[i].display();
            }
        }
        System.out.println("List officer:");
        for (int i = 0; i < n; i++) {
            if(e[i] instanceof Officer){
                e[i].display();
            }
        }

    }
    
}
