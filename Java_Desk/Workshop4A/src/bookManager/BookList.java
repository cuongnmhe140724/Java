/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookManager;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

import java.util.*;
import java.io.*;
import javax.swing.*;
/**
 *
 * @author Minh Thanh
 */
public class BookList {

    ArrayList<Book> t;

    public BookList() {
        t = new ArrayList<Book>();
    }

    boolean isEmpty() {
        return (t.isEmpty());
    }

    void clear() {
        t.clear();
    }

    int searchByCode(String xCode) {
        int n, i;
        Book x;
        n = t.size();
        for (i = 0; i < n; i++) {
            x = t.get(i);
            if (x.bookID.equals(xCode)) {
                return (i);
            }
        }
        return (-1);
    }

    void add(Book x) {
        int k = searchByCode(x.bookID);
        if (k >= 0) {
            JOptionPane.showMessageDialog(null, "The book id " + x.bookID + " already exists!");
            return;
        }
        t.add(x);
    }

    int searchByName(String xName) {
        int n, i;
        Book x;
        n = t.size();
        for (i = 0; i < n; i++) {
            x = t.get(i);
            if (x.bookName.equals(xName)) {
                return (i);
            }
        }
        return (-1);
    }

    void searchByName(BookList h, String xName) {
        int n, i;
        Book x;
        n = t.size();
        for (i = 0; i < n; i++) {
            x = t.get(i);
            if (x.bookName.equals(xName)) {
                h.add(new Book(x.bookID, x.bookName, x.quantity, x.price));
            }
        }
    }

    void searchByNameRel(BookList h, String xName) {
        int n, i;
        Book x;
        n = t.size();
        for (i = 0; i < n; i++) {
            x = t.get(i);
            if (x.bookName.indexOf(xName) >= 0) {
                h.add(new Book(x.bookID, x.bookName, x.quantity, x.price));
            }
        }
    }

    int size() {
        return (t.size());
    }

    Book get(int i) {
        int n = size();
        if (i < 0 || i >= n) {
            return (null);
        }
        Book x = (Book) t.get(i);
        return (x);

    }
    
    void dele(int i) {
        int n = size();
        if (i < 0 || i >= n - 1) {
            return;
        }
        t.remove(i);
    }

    void dele(String xName) {
        int k = searchByName(xName);
        dele(k);
    }

    void sortByName() {
        Collections.sort(t);
    }

}
