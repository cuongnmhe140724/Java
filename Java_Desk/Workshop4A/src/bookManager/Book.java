/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookManager;

/**
 *
 * @author Minh Thanh
 */
public class Book implements Comparable{
    String bookID;
    String bookName;
    int quantity;
    int price;

    public Book() {
    }

    public Book(String bookID, String bookName, int quantity, int price) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public int compareTo(Object o) {
                Book y = (Book) o;
        return (bookName.compareTo(y.bookName)); //To change body of generated methods, choose Tools | Templates.
    }
    
}
