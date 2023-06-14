package cherevatyi.andrii;

import java.util.Scanner;

public class RgrTr15Chere {

    public static void main(String[] args) {
        System.out.println("Початкова матриця:");
        double[][] arr = {
                {4., 1., 6., 6., -4., 91.8},
                {8., -2., -3., -1., -5., 27.9},
                {-7., 10., -2., -3., 7., -51.9},
                {-2., -3., -5., 0., 3., -27.4},
                {-4., 5., -3., -2., 4., -37.4}
        };
        for (double[] e: arr) {
            System.out.print("|");
            for (double ee: e) {
                System.out.print(ee + "|");
            }
            System.out.println();
        }
        for (double[] e : arr) {
            System.out.println(e[0] + "x1 + " + e[1] + "x2 + " + e[2] + "x3 + " + e[3] + "x4 + " + e[4] + "x5 = " + e[5]);
        }
        System.out.println();
        double[] result = task1(arr);
        System.out.println("Результат:");
        int index = (int) '1';
        for (double x: result) {
            System.out.printf("x%c = %.3f\n", ((char) index++), x);
        }
        System.out.println();

        Scanner input = new Scanner(System.in);
        System.out.print("Вхідні дані: ");
        int num = input.nextInt();
        System.out.print("Результат: ");
        System.out.println(task2(num));
        System.out.print("Вхідні дані: ");
        num = input.nextInt();
        System.out.print("Результат: ");
        System.out.println(task2(num));
        System.out.print("Вхідні дані: ");
        num = input.nextInt();
        System.out.print("Результат: ");
        System.out.println(task2(num));
    }

    static double[] task1(double[][] arr) {
        double[] lastInRow = new double[arr.length];
        for (int i = 0; i < lastInRow.length; i++) {
            lastInRow[i] = arr[i][arr[i].length - 1];
        }
        double m;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                m = arr[j][i - 1] / arr[i - 1][i - 1];
                for (int k = 0; k < arr[j].length; k++) {
                    arr[j][k] = arr[j][k] - m * arr[i - 1][k];
                }
                lastInRow[j] = lastInRow[j] - m * lastInRow[i - 1];
            }
        }
        System.out.println("Triangle matrix:");
        for (double[] e : arr) {
            System.out.printf("%.3fx1 + %.3fx2 + %.3fx3 + %.3fx4 + %.3fx5 = %.3f\n", e[0], e[1], e[2], e[3], e[4], e[5]);
        }
        System.out.println();
        for (int i = arr.length-1; i >= 0; i--) {
            for (int j = i + 1; j < arr.length; j++) lastInRow[i] -= arr[i][j] * lastInRow[j];
            lastInRow[i] = lastInRow[i] / arr[i][i];
        }
        return lastInRow;
    }

    static int task2(int num) {
        if (num < 0) num *= -1;
        String result = "";
        while (num != 0) {
            result = num % 10 + result;
            result = num % 10 + result;
            num /= 10;
        }
        return Integer.parseInt(result);
    }
}
