/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0056;

import java.util.ArrayList;

/**
 *
 * @author cuongnm
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Worker> wl = new ArrayList<>();
        ArrayList<History> hl = new ArrayList<>();
        while (true) {            
            int choice = Manager.menu();
            switch (choice) {
                case 1:
                    Manager.addWorker(wl);
                    break;
                case 2:
                    Manager.changeSalary(wl, hl, "UP");
                    break;
                case 3:
                    Manager.changeSalary(wl, hl, "DOWN");
                    break;
                case 4:
                    Manager.printListHistory(hl);
                    break;
                case 5:
                    return;
                case 6 :
                    Manager.display(wl);
                    break;
            }
        }
    }
    
}
