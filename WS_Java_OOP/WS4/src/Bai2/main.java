/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        SimpleDateFormat df = new SimpleDateFormat("dd MM yyyy");
        Student st = new Student();
        
    //test set method
        System.out.print("Enter name student: ");
        st.setName(sc.nextLine());
        System.out.print("Enter student ID: ");
        st.setStudentId(sc.nextLine());
        System.out.print("Enter date of birth: ");
        Date date = null;
            try {
                date = df.parse(sc.nextLine());
            } catch (ParseException ex) {

            }
        st.setBirthDate(date);
        System.out.print("Enter student address: ");
        st.setAddress(sc.nextLine());
        System.out.print("Enter major: ");
        st.setMajor(sc.nextLine());
        System.out.print("Enter student mark: ");
        st.setMark(Double.parseDouble(sc.nextLine()));
        System.out.println("\n------------------------------\n");
    // test printAllAttributes method
        st.printAllAttributes();
    }

}
