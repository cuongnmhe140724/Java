/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.l.p0021;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cuongnm
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Student> ls = new ArrayList();
        Validation validation = new Validation();
        int count = 4;
        ls.add(new Student("1", "A", "2", "java"));
        ls.add(new Student("1", "A", "3", "java"));
        ls.add(new Student("2", "B", "2", "java"));
        ls.add(new Student("2", "B", "2", "c/c++"));
        ls.add(new Student("2", "B", "3", "c/c++"));
        
        while (true) {
            Manager.menu();
            int choice = Validation.checkInputInt(1, 5);
            switch(choice){
                case 1:
                   Manager.create(ls, count);
                   break;
                case 2:
                    Manager.findAndSort(ls);
                    break;
                case 3:
                    Manager.updateOrDelete(ls, count);
                    break;
                case 4:
                    Manager.report(ls);
                    break;
                case 5:
                    return;
            }
            
        }
    }
}
