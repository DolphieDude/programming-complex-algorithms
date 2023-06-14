package cherevatyi.andrii;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Size of the array = ");
        int n = input.nextInt();
        int[][] insertArr = new int[n][n];
        int[][] selectArr = new int[n][n];
        long time1, time2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                insertArr[i][j] = (int) Math.round(Math.random() * (9 - 1) + 0);
                selectArr[i][j] = insertArr[i][j];
            }
        }
        System.out.println("Initial:");
        print2d(selectArr);

        System.out.println("\n\n*****************************\n\n");
        System.out.println("After Insertion Sort:");
        time1 = System.currentTimeMillis();
        insertSort(insertArr);
        time2 = System.currentTimeMillis();
        print2d(insertArr);
        System.out.println(time2 - time1 + "ms");

        System.out.println("\n\n*****************************\n\n");
        System.out.println("After Selection Sort:");
        time1 = System.currentTimeMillis();
        selectSort(selectArr);
        time2 = System.currentTimeMillis();
        print2d(selectArr);
        System.out.println(time2 - time1 + "ms");
    }

    static void print2d(int[][] arr) {
        for (int[] i : arr) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    static void insertSort(int[][] arr)
    {
        int n = arr.length;
        for (int col = 0; col < n; col++) {
            for (int i = n - col - 1; i > 0; i--) {
                int key = arr[i - 1][col];
                int j = i;
                while (arr[j][col] > key) {
                    arr[j - 1][col] = arr[j][col];
                    j++;
                    if (j == n - col) break;
                }
                arr[j - 1][col] = key;
            }
        }
    }

    static void selectSort(int[][] arr)
    {
        int n = arr.length;
        int min, swap;
        for (int col = 0; col < n; col++) {
            for (int i = n - col - 1; i >= 0; i--)
            {
                // Find the minimum element in unsorted array
                min = i;
                for (int j = i - 1; j >= 0; j--)
                    if (arr[j][col] < arr[min][col]) min = j;

                // Swap the found minimum element with the first
                // element
                swap = arr[min][col];
                arr[min][col] = arr[i][col];
                arr[i][col] = swap;
            }
        }

    }
}
