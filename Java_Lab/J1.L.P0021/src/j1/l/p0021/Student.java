/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.l.p0021;

/**
 *
 * @author cuongnm
 */
public class Student implements Comparable<Student>{
    private String id;
    private String studentName;
    private String semester;
    private String courseName;

    public Student() {
    }

    public Student(String id, String studentName, String semester, String courseName) {
        this.id = id;
        this.studentName = studentName;
        this.semester = semester;
        this.courseName = courseName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

     public void print() {
        System.out.printf("%-15s%-15s%-15s\n", studentName, semester, courseName);
    }

    @Override
    public int compareTo(Student s) {
        return s.getStudentName().compareToIgnoreCase(this.getStudentName());
    }
    
    
}

class Report{
    private String nameStudent;
    private String courseName;
    private int totalCourse;

    public Report() {
    }

    public Report(String nameStudent, String courseName, int totalCourse) {
        this.nameStudent = nameStudent;
        this.courseName = courseName;
        this.totalCourse = totalCourse;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getTotalCourse() {
        return totalCourse;
    }

    public void setTotalCourse(int totalCourse) {
        this.totalCourse = totalCourse;
    }
    
    
}