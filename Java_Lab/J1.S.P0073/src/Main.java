 
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author cuongnm
 */
public class Main {

    /**
     */
    public void menu() {
        System.out.println("========Handy Expense program========");
        System.out.println("1. Add an expense");
        System.out.println("2. Display all expense");
        System.out.println("3. Delete an expense");
        System.out.println("4. Quit");
        System.out.println("Your choice:");
    }

    public void addExpense(ArrayList<Expense> el) {
        int id;
        if (el.isEmpty()) {
            id = 1;
        } else {
            id = el.get(el.size() - 1).getId() + 1;
        }
        System.out.print("Enter date: ");
        String date = Validation.chekcInputDate();
        System.out.print("Enter amour: ");
        double number = Validation.checkInputDouble(0, Double.MAX_VALUE);
        System.out.print("Enter content: ");
        String content = Validation.checkInputString();
        Expense e = new Expense(id, date, number, content);

        el.add(e);
        System.out.println("Add new expense successfully");
    }

    public void display(ArrayList<Expense> el) {
        System.out.printf("%-20s%-20s%-20s%-20s\n", "ID", "Date", "Amount of money", "Content");
        double total = 0;
        for (Expense expense : el) {
            expense.print();
            total += expense.getNumber();
        }
        System.out.println("Total: " + total);
    }
    
    public void removeExpense(ArrayList<Expense> el){
        System.out.println("Enter id to remove:");
        int id = Validation.checkInputInt(0, Integer.MAX_VALUE);
        
        if(id > el.size()){
            System.out.println("Id does not exist");
            return;
        }
        el.remove(id - 1);
        resetId(el, id - 1);
        System.out.println("Remove successfull");
    }
    
    public void resetId(ArrayList<Expense> el,int n){
        for (int i = n; i < el.size(); i++) {
            el.get(i).setId(i + 1);
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Main m = new Main();
        ArrayList<Expense> el = new ArrayList<>();
        
        while (true) {
            m.menu();
            int choice = Validation.checkInputInt(1, 4);
            switch (choice) {
                case 1:
                    m.addExpense(el);
                    break;
                case 2:
                    m.display(el);
                    break;
                case 3:
                    m.removeExpense(el);
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }

}
