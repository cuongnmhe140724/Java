/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package new1;

import java.util.Scanner;

/**
 *
 * @author cuongnm
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in);
        Book b = new Book();
        
        System.out.println("Enter author book");
        b.setAuthor(sc.nextLine());
        System.out.println("Enter book name:");
        b.setTitle(sc.nextLine());
        System.out.println("Enter 'true' if booj is fiction and 'false' if book is not");
        b.setFiction(Boolean.parseBoolean(sc.nextLine()));
        System.out.println("Enter no of pages:");
        b.setNoOfPages(Integer.parseInt(sc.nextLine()));
        
        System.out.println("-------------------------");
        System.out.println("Author:" + b.getAuthor());
        System.out.println("Book name:" + b.getTitle());
        b.isFiction();
        System.out.println("No of pages:" + b.getNoOfPages());
    }
    
}
