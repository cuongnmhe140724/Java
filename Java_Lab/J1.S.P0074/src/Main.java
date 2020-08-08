
import java.util.Scanner;

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
    public final static Scanner sc = new Scanner(System.in);

    public void menu() {
        System.out.println("========================");
        System.out.println("1. Addition Matrix");
        System.out.println("2. Subtraction Matrix");
        System.out.println("3. Multiplication Matrix");
        System.out.println("4. Quit");
        System.out.println("Your choice:");
    }

    public int checkInputInt(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    System.out.println("Please input in range " + min + "-" + max);
                    System.out.println("Enter again:");
                } else {
                    return result;
                }
            } catch (NumberFormatException e) {
                System.out.println("Values of matrix must be the number!");
                System.out.println("Enter again");
            }
        }
    }

    public int[][] inputMatrix(int row, int col) {
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("Enter Matrix[" + (i + 1) + "][" + (j + 1) + "]: ");
                matrix[i][j] = checkInputInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
            }
        }
        return matrix;
    }

    public void displayMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println("");
        }
    }

    public void addMatrix(int[][] matrix1, int[][] matrix2) {
        int[][] result = new int[matrix1.length][matrix1[0].length];

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        System.out.println("------ Result ------");
        displayMatrix(matrix1);
        System.out.println("+");
        displayMatrix(matrix2);
        System.out.println("=");
        displayMatrix(result);
    }

    public void subMatrix(int[][] matrix1, int[][] matrix2) {
        int[][] result = new int[matrix1.length][matrix1[0].length];

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }

        System.out.println("------ Result ------");
        displayMatrix(matrix1);
        System.out.println("-");
        displayMatrix(matrix2);
        System.out.println("=");
        displayMatrix(result);
    }

    public void mulMatrix(int[][] matrix1, int[][] matrix2) {
        int[][] result = new int[matrix1.length][matrix2[0].length];

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                for (int k = 0; k < matrix1[0].length; k++) {
                    result[i][j] = result[i][j] + matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        
        System.out.println("------ Result ------");
        displayMatrix(matrix1);
        System.out.println("*");
        displayMatrix(matrix2);
        System.out.println("=");
        displayMatrix(result);
    }

    public void matrixHandling(int choice) {
        System.out.print("Enter row matrix 1: ");
        int row1 = checkInputInt(1, Integer.MAX_VALUE);
        System.out.print("Enter column matrix 1: ");
        int col1 = checkInputInt(1, Integer.MAX_VALUE);
        int[][] matrix1 = inputMatrix(row1, col1);

        int row2 = 0;
        int col2 = 0;
        while (true) {
            System.out.print("Enter row matrix 2: ");
            row2 = checkInputInt(1, Integer.MAX_VALUE);

            if (choice != 3) {
                if (row2 != row1) {
                    System.out.println("Two matrix must same size!");
                } else {
                    break;
                }
            } else {
                if (row2 != col1) {
                    System.out.println("Matrix2 rows number must equal Matrix1 cols number!");
                } else {
                    break;
                }
            }
        }
        while (true) {
            System.out.print("Enter column matrix 2: ");
            col2 = checkInputInt(1, Integer.MAX_VALUE);

            if (choice != 3) {
                if (col2 != col1) {
                    System.out.println("Two matrix must same size!");
                } else {
                    break;
                }
            } else {
                if (col2 != row1) {
                    System.out.println("Matrix2 column number must equal Matrix1 row number!");
                } else {
                    break;
                }
            }
        }
        int[][] matrix2 = inputMatrix(row2, col2);

        switch (choice) {
            case 1:
                addMatrix(matrix1, matrix2);
                break;
            case 2:
                subMatrix(matrix1, matrix2);
                break;
            case 3:
                break;
        }
    }

    public static void main(String[] args) {
        Main m = new Main();
        while (true) {
            m.menu();
            int choice = m.checkInputInt(1, 4);
            if (choice == 4) {
                return;
            }
            m.matrixHandling(choice);
        }
    }

}
