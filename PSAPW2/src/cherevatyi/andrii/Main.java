package cherevatyi.andrii;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Size of the array = ");
        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) Math.round((Math.random() * (9 - 1)) + 0);
            System.out.print(arr[i] + "; ");
        }
        System.out.println();
        System.out.print("key = ");
        int key = input.nextInt();
        for (int i = 0; i < n; i++) {
            if (arr[i] == key) {
                System.out.println("Key's found on " + i + " position");
                break;
            }
            else if (i == n - 1) System.out.println("Key isn't found");
        } 
    }
}
