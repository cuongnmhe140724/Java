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
        Book book = new Book();
    
    // test set method
        System.out.print("Enter author of book: ");
        book.setAuthor(sc.nextLine());
        System.out.print("Enter title of book: ");
        book.setTitle(sc.nextLine());
        System.out.print("Enter noOfPages: ");
        book.setNoOfPages(Integer.parseInt(sc.nextLine()));
        System.out.print("Input 'true' for fiction and 'false' for not : ");
        book.setFiction(Boolean.parseBoolean(sc.nextLine()));
        
    // test get method
        System.out.println("\nAuthor: " + book.getAuthor());
        System.out.println("Title of book:" + book.getTitle());
        System.out.println("No of pages:" + book.getNoOfPages());
        book.isFiction();
        
    }
    
}
