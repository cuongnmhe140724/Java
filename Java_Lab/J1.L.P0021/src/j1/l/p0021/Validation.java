/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.l.p0021;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author cuongnm
 */
public class Validation {

    public final static Scanner sc = new Scanner(System.in);

    public static int checkInputInt(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Please input in range " + min + "-" + max);
                System.out.println("Enter again");
            }
        }
    }

    public static String checkInputString() {
        while (true) {
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.out.println("Not Emtpty");
                System.out.println("Enter again");
            } else {
                return result;
            }
        }
    }

    public static boolean checkInputYN() {
        //loop until user input correct
        while (true) {
            String result = checkInputString();
            //return true if user input y/Y
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            //return false if user input n/N
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }
    
    public static boolean checkInputUD() {
        //loop until user input correct
        while (true) {
            String result = checkInputString();
            //return true if user input y/Y
            if (result.equalsIgnoreCase("U")) {
                return true;
            }
            //return false if user input n/N
            if (result.equalsIgnoreCase("D")) {
                return false;
            }
            System.err.println("Please input d/D or u/U.");
            System.out.print("Enter again: ");
        }
    }

    public static boolean checkExistId(List<Student> ls, String id, String studentName) {
        for (Student student : ls) {
            if (id.equalsIgnoreCase(student.getId()) && !studentName.equalsIgnoreCase(student.getStudentName())) {
                return false;
            }
        }
        return true;
    }

    public static String checkInputCourse() {
        while (true) {
            String result = sc.nextLine().trim();
            if (result.equalsIgnoreCase("Java")
                    || result.equalsIgnoreCase("C/C++")
                    || result.equalsIgnoreCase(".Net")) {
                return result;
            }else {
                System.err.println("Please input only 3 course: Java, C/C++, .Net");
                System.out.println("Enter again:");
            }
        }
    }
    
    public static boolean checkDuplicate(List<Student> ls, String id, 
            String studentName, String semester, String courseName){
        for (Student student : ls) {
            if(id.equalsIgnoreCase(student.getId())
                    && studentName.equalsIgnoreCase(student.getStudentName())
                    && semester.equalsIgnoreCase(student.getSemester())
                    && courseName.equalsIgnoreCase(student.getCourseName())){
                return false;
            }
        }
        return true;
    }
    
    public static boolean checkReportExist(List<Report> lr, String name,
            String course, int total) {
        for (Report report : lr) {
            if (name.equalsIgnoreCase(report.getNameStudent())
                    && course.equalsIgnoreCase(report.getCourseName())
                    && total == report.getTotalCourse()) {
                return false;
            }
        }
        return true;
    }


}
