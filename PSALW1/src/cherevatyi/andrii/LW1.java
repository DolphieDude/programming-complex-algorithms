package cherevatyi.andrii;

import java.util.Scanner;

public class LW1 {
    static int count1 = 0;
    static int count2 = 0;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Size of the array = ");
        int n = input.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = (int) Math.round(Math.random() * (99 + 100) - 100);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j]);
                if(arr[i][j] >= 10 || (arr[i][j] < 0 && arr[i][j] > -10)) System.out.print(" " + " ");
                else if(arr[i][j] <= -10) System.out.print(" ");
                else System.out.print(" " + " " + " ");
            }
            System.out.println();
        }
        long start = System.currentTimeMillis();
        whichColumnIsBigger(arr);
        long afterTask1 = System.currentTimeMillis();
        System.out.println("Iterations: " + count2);
        System.out.println("Time: " + (afterTask1 - start) + " ms");
        System.out.println("\n");
        int[][] newArr = arrayShift(arr);
        long afterTask2 = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(newArr[i][j]);
                if(newArr[i][j] >= 10 || (newArr[i][j] < 0 && arr[i][j] > -10)) System.out.print(" " + " ");
                else if(newArr[i][j] <= -10) System.out.print(" ");
                else System.out.print(" " + " " + " ");
            }
            System.out.println();
        }
        System.out.println("Iterations: " + count2);
        System.out.println("Time: " + (afterTask2 - afterTask1) + " ms");
    }

    static void whichColumnIsBigger(int[][] arr) {
        int n = arr.length;
        int[] max = {0, 0};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) { // n * n = 10 * 10 = 100
                count1++;
                if (arr[i][j] > arr[max[0]][max[1]]) {
                    max[0] = i;
                    max[1] = j;
                }
            }
        }

        int leftColPositive = 0;
        int leftColNegative = 0;
        int rightColPositive = 0;
        int rightColNegative = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) { // n * n = 10 * 10 = 100
                count1++;
                if (j < max[1]) {
                    if (arr[i][j] > 0) leftColPositive++;
                    else if (arr[i][j] < 0) leftColNegative++;
                }
                else if (j > max[1]) {
                    if (arr[i][j] > 0) rightColPositive++;
                    else if (arr[i][j] < 0) rightColNegative++;
                }
            }
        }
        // 100 + 100 = 200 iterations
        if (leftColPositive > rightColPositive) System.out.println("The left column has more positive numbers than the right one");
        else if (leftColPositive < rightColPositive) System.out.println("The right column has more positive numbers than the left one");
        else System.out.println("The columns have the same amount of the positive numbers");

        if (leftColNegative > rightColNegative) System.out.println("The right column has less negative numbers than the left one");
        else if (leftColNegative < rightColNegative) System.out.println("The left column has less negative numbers than the right one");
        else System.out.println("The columns have the same amount of the negative numbers");
    }

    static int[][] arrayShift(int[][] arr) {
        int n = arr.length;
        int[] lastRow = new int[n];
        for (int j = 0; j < n; j++) { //n = 10
            count2++;
            lastRow[j] = arr[n - 1][j];
        }
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < n; j++) { // (n - 1) * n = 9 * 10 = 90
                count2++;
                arr[i][j] = arr[i - 1][j];
            }
        }
        for (int j = 0; j < n; j++) { //n = 10
            count2++;
            arr[0][j] = lastRow[j];
        }
        int[][] oldArr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) { //n * n = 10 * 10 = 100
                count2++;
                oldArr[i][j] = arr[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) { //n * n = 10 * 10 = 100
                count2++;
                if (j + 5 >= n) arr[i][j + 5 - n] = oldArr[i][j];
                else arr[i][j + 5] = oldArr[i][j];
            }
        }
        //10 + 90 + 10 + 100 + 100 = 310 iterations
        return arr;
    }
}
