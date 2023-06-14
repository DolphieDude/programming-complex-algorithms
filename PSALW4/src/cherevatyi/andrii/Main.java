package cherevatyi.andrii;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int n = 15;
        int[] arr = new int[n];
        long time1, time2;
        for (int i = 0; i < n; i++) {
            arr[i] = (int) Math.round(Math.random() * (100 + 1) + 0);
            System.out.print(arr[i] + "; ");
        }
        System.out.println();
        int min = arr[0], minpos = 0;
        int sum = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] < min) {
                min = arr[i];
                minpos = i;
            }
            sum += arr[i];
        }
        sum -= arr[minpos];
        arr[minpos] = 0;
        for (int e : arr) {
            System.out.print(e + "; ");
        }
        sum /= n;
        System.out.println("\nAverage is " + sum);


        n = 6;
        int[][] arr2d = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr2d[i][j] = (int) Math.round(Math.random() * (100 + 1) + 0);
                System.out.print(arr2d[i][j] + "; ");
            }
            System.out.println();
        }
        sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                sum += arr2d[i][j];
            }
        }
        System.out.println("The sum is: " + sum);
    }
}
