package cherevatyi.andrii;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	    int n = 10;
        ArrayList<ArrayList<Integer[]>> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<Integer[]>());
            for (int j = 0; j < n; j++) {
                if (((int) (Math.random() * (9 + 1)) + 0) < 8) continue;
                Integer[] element = new Integer[2];
                element[0] = (int) (Math.random() * (9 + 1)) + 0;
                element[1] = j;
                list.get(i).add(element);
            }
        }

        System.out.println("How the matrix looks:");
        for (int i = 0; i < n; i++) {
            int jj = 0;
            int jjmax = list.get(i).size() - 1;
            for (int j = 0; j < n; j++) {
                if (jjmax == jj || jjmax == -1) System.out.print("0; ");
                else if (list.get(i).get(jj)[1] != j) System.out.print("0; ");
                else {
                    System.out.print(list.get(i).get(jj)[0] + "; ");
                    jj++;
                }
            }
            System.out.println();
        }
        System.out.println("How it's actually stored:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j)[0] + "; ");
            }
            System.out.println();
        }
        sumsOfColumns(list);
    }

    static void sumsOfColumns (ArrayList<ArrayList<Integer[]>> list) {
        int n = list.size();
        int[] sums = new int[n];
        for (int i = 0; i < n; i++) {
            sums[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                sums[list.get(i).get(j)[1]] += list.get(i).get(j)[0];
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println("The " + i + "th column sum = " + sums[i]);
        }
    }
}
