/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai1;

/**
 *
 * @author cuongnm
 */
public class Book {
    String author;
    String title;
    int noOfPages;
    boolean fiction;

    public Book() {
    }

    public Book(String author, String title, int noOfPages, boolean fiction) {
        this.author = author;
        this.title = title;
        this.noOfPages = noOfPages;
        this.fiction = fiction;
    }
    

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNoOfPages() {
        return noOfPages;
    }

    public void setNoOfPages(int noOfPages) {
        this.noOfPages = noOfPages;
    }

    public void isFiction() {
        if(fiction){
            System.out.println("This is fiction book");
        }else{
            System.out.println("This is not fiction book");
        }
    }

    public void setFiction(boolean fiction) {
        this.fiction = fiction;
    }
    
    
}
