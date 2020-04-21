/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS2_2;

import java.util.Scanner;

/**
 *
 * @author cuongnm
 */
public class WS2_2 {

    /**
     * @param a
     * @param n
     */
    public static void iMax(int[] a, int n) {
	int imax = 0, i;
	for(i = 1; i < n; i ++) {
		if(a[i] > a[imax]) {
			imax = i;
		}
	}
	       System.out.println(a[imax]);
    }
    
    public static void sortingArray(int[] a,int n) {
	int t;
	for (int i = 0;i < n - 1;i ++) {
		for (int j = i + 1;j < n;j ++) {
		if(a[i] > a[j]){
	            t = a[i];
	            a[i] = a[j];
	            a[j] = t;
                }
	    }  
        }
        for(int i = 0; i < n; i++){
            System.out.printf("%d\t",a[i]);
        }    
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size;
        System.out.println("Enter size of array:");
        size = sc.nextInt();
        int[] a = new int[size];
        for(int i = 0; i < size; i++){
            System.out.printf("a[%d]:",i);
            a[i] = sc.nextInt();
        }
        //display all
        for(int i = 0; i < size; i++){
            System.out.printf("%d\t",a[i]);
        }
        //sorting
        System.out.printf("\nNew array:\n");
        sortingArray(a,size);
        //maximum value
        System.out.printf("\nThe maximum value:\n");
        iMax(a,size);
    }
    
}
