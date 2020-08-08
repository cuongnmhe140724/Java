/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.l.p0021;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author cuongnm
 */
public class Manager {

    public static void menu() {
        System.out.println("--------------------");
        System.out.println(" 1.	Create");
        System.out.println(" 2.	Find and Sort");
        System.out.println(" 3.	Update/Delete");
        System.out.println(" 4.	Report");
        System.out.println(" 5.	Exit");
        System.out.print(" Enter your choice: ");
    }

    public static void create(List<Student> ls, int count) {
        if (count > 10) {
            System.out.println("Don you want to continue (Y/N)");
            if (!Validation.checkInputYN()) {
                return;
            }
        }
        while (true) {
            System.out.println("Enter student ID:");
            String id = Validation.checkInputString();
            System.out.println("Enter student name:");
            String studentName = Validation.checkInputString();
            if (!Validation.checkExistId(ls, id, studentName)) {
                System.out.println("Id has exist student. Pleas re-input.");
                continue;
            }
            System.out.println("Enter semester:");
            String semester = Validation.checkInputString();
            System.out.println("Enter course:");
            String courseName = Validation.checkInputCourse();
            if (Validation.checkDuplicate(ls, id, studentName, semester, courseName)) {
                Student student = new Student(id, studentName, semester, courseName);
                ls.add(student);
                count++;
                System.out.println("Add student succesful!");
                return;
            }
            System.err.println("Duplicate, enter again!");
        }
    }

    public static void findAndSort(List<Student> ls) {
        if (ls.isEmpty()) {
            System.out.println("List student empty");
            return;
        }
        List<Student> listStudentFindByName = listStudentFindByName(ls);
        if (listStudentFindByName.isEmpty()) {
            System.out.println("Student not exist");
        } else {
            Collections.sort(listStudentFindByName);
            System.out.printf("%-15s%-15s%-15s\n", "Student name", "semester", "Course Name");
            //loop from first to last element of list student
            for (Student student : listStudentFindByName) {
                student.print();
            }
        }
    }

    public static List<Student> listStudentFindByName(List<Student> ls) {
        List<Student> listStudentFindByName = new ArrayList<>();
        System.out.println("Enter name to search:");
        String name = Validation.checkInputString();
        for (Student student : ls) {
            if (student.getStudentName().contains(name)) {
                listStudentFindByName.add(student);
            }
        }
        return listStudentFindByName;
    }

    public static void updateOrDelete(List<Student> ls, int count) {
        if (ls.isEmpty()) {
            System.out.println("List student empty");
            return;
        }

        List<Student> listStudentByID = listStudentByID(ls);
        if (listStudentByID.isEmpty()) {
            System.out.println("ID not exist");
            return;
        } else {
            Student student = getStudentByListFound(listStudentByID);
            System.out.println("Do you want to update (U) or delete (D) student?");
            boolean choice = Validation.checkInputUD();
            if (choice) {
                System.out.println("Enter student name:");
                String studentName = Validation.checkInputString();
                System.out.println("Enter semester:");
                String semester = Validation.checkInputString();
                System.out.println("Enter course:");
                String courseName = Validation.checkInputCourse();

                student.setStudentName(studentName);
                student.setCourseName(courseName);
                student.setSemester(semester);

                System.out.println("Update succesful!");
                return;
            } else {
                ls.remove(student);
                count--;
                System.out.println("Delete succesful!");
                return;
            }
        }
    }

    public static List<Student> listStudentByID(List<Student> ls) {
        List<Student> listStudentByID = new ArrayList<>();
        System.out.println("Enter ID to search:");
        String id = Validation.checkInputString();
        for (Student student : ls) {
            if (id.equalsIgnoreCase(student.getId())) {
                listStudentByID.add(student);
            }
        }
        return listStudentByID;
    }

    public static Student getStudentByListFound(List<Student> listStudentByID) {
        System.out.println("List student:");
        int count = 1;
        System.out.printf("%-10s%-15s%-15s%-15s\n", "Number", "Student name",
                "semester", "Course Name");
        for (Student student : listStudentByID) {
            System.out.printf("%-10d%-15s%-15s%-15s\n", count,
                    student.getStudentName(), student.getSemester(),
                    student.getCourseName());
            count++;
        }
        System.out.println("Choose student to update or delete:");
        int choice = Validation.checkInputInt(1, listStudentByID.size());
        return listStudentByID.get(choice - 1);
    }

    public static void report(List<Student> ls) {
        if (ls.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        ArrayList<Report> lr = new ArrayList<>();
        
        for (Student student1 : ls) {
            int total = 0;
            for (Student student2 : ls) {
                if (student1.getId().equalsIgnoreCase(student2.getId())
                        && student1.getCourseName().equalsIgnoreCase(student2.getCourseName())) {
                    total++;
                }
            }
            if (Validation.checkReportExist(lr, student1.getStudentName(),
                    student1.getCourseName(), total)) {
                lr.add(new Report(student1.getStudentName(),
                        student1.getCourseName(), total));
            }
        }
        //print report
        for (int i = 0; i < lr.size(); i++) {
            System.out.printf("%-15s|%-10s|%-5d\n", lr.get(i).getNameStudent(),
                    lr.get(i).getCourseName(), lr.get(i).getTotalCourse());
        }
    }
}
