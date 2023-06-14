package cherevatyi.andrii;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        int size = (int) Math.round(Math.random() * (100 - 1) + 0);
        System.out.println("The size is: " + size);
        for (int i = 0; i < size; i++) {
            list.add((int) (Math.random() * (100 - 1)) + 0);
            System.out.print(list.get(i) + "; ");
        }
        System.out.println();
        System.out.println("The arithmetic average is " + getAverage(list));
    }

    static double getAverage(LinkedList<Integer> list) {
        double sum = 0;
        for (Integer e : list) sum += e;
        return sum / list.size();
    }
}
