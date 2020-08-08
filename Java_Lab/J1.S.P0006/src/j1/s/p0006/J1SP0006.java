/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0006;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author cuongnm
 */
public class J1SP0006 {

    /**
     * @param args the command line arguments
     */
    public static Scanner sc = new Scanner(System.in);

    public static int inputInt(String mess, int min, int max) {
        System.out.print(mess);
        while (true) {
            String input = sc.nextLine();
            try {
                int number = Integer.parseInt(input);
                if (number < min || number > max) {
                    System.out.print("Please input between " + min + ", " + max + ": ");
                    continue;
                }
                return number;
            } catch (NumberFormatException e) {
                System.out.print("Please input an integer number: ");
            }
        }
    }

    public static void bubbleSort(int a[]) {
        int i, j;
        for (i = 0; i < a.length - 1; i++) {
            for (j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    public static void binarySearch(int arr[], int first, int last, int key) {
        int mid = (first + last) / 2;
        while (first <= last) {
            if (arr[mid] < key) {
                first = mid + 1;
            } else if (arr[mid] > key) {
                last = mid - 1;
            } else {
                System.out.println("Element is found at index: " + mid);
                break;
            }
            mid = (first + last) / 2;
        }
        if (first > last) {
            System.out.println("Element is not found!");
        }
    }

    static void display(int[] array) {
        int size = array.length;
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            if (i != size - 1) {
                System.out.print(array[i] + ", ");
            } else {
                System.out.print(array[i]);
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        int size = inputInt("Enter number of array: ", 1, Integer.MAX_VALUE);
        int[] arr = new int[size];
        Random r = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = r.nextInt(size);
        }
        int value = inputInt("Enter search value: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
        bubbleSort(arr);
        System.out.print("Sorted array: ");
        display(arr);
        binarySearch(arr, 0, size - 1, value);
    }

}
