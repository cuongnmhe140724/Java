/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai3;

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
        Rectangle re = new Rectangle();
    //intpur height and width
        System.out.println("Enter height: ");
        re.setHeight(Double.parseDouble(sc.nextLine()));
        System.out.println("Enter width:");
        re.setWidth(Double.parseDouble(sc.nextLine()));
        System.out.println("------------------------");
    //calculate area and perimeter
        System.out.println("The rectangle have height " + re.getHeight() + " and width " + re.getWidth());
        System.out.println("The are of rectangle: " + re.area(re.getHeight(), re.getWidth()));
        System.out.println("The perimeter of rectangle: " + re.perimeter(re.getHeight(), re.getWidth()));
    }
    
}
