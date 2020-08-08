/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai1;

import java.util.Scanner;

/**
 *
 * @author cuongnm
 */
public class Main {

    public static boolean checkAnagrams(String string1, String string2) {
        String alterString1 = removeSpace(string1);
        String alterString2 = removeSpace(string2);

        alterString1 = alterString1.toLowerCase();
        alterString2 = alterString2.toLowerCase();

        alterString1 = sort(alterString1);
        alterString2 = sort(alterString2);

        return alterString1.equals(alterString2);
    }

    public static String removeSpace(String string) {
        int len = string.length();
        StringBuilder dest = new StringBuilder(len);
        char c;
        for (int i = (len - 1); i >= 0; i--) {
            c = string.charAt(i);
            if (Character.isLetter(c)) {
                dest.append(c);
            }
        }
        return dest.toString();
    }

    public static String sort(String string) {
        char[] charArray = string.toCharArray();
        java.util.Arrays.sort(charArray);
        return new String(charArray);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        System.out.print("Input String 1: ");
        String string1 = sc.nextLine();
        System.out.print("Input String 2: ");
        String string2 = sc.nextLine();

        System.out.println("-------------------------");
       
        if (checkAnagrams(string1, string2)) {
            System.out.println("They ARE anagrams!");
        } else {
            System.out.println("They are NOT anagrams!");
        }
    }
}
