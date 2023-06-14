package cherevatyi.andrii;

public class Main {
    static int iterations = 0;
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Recursion = " + recursion(1, 3));
        long recursionTime = System.currentTimeMillis();
        System.out.println("Iterations = " + iterations);
        System.out.println("Time = " + (recursionTime - startTime) + " ms");
        iterations = 0;
        System.out.println("Loop = " + loop(3));
        long loopTime = System.currentTimeMillis();
        System.out.println("Iterations = " + iterations);
        System.out.println("Time = " + (loopTime - recursionTime) + " ms");
    }

    static double recursion(int x, int n) {
        iterations++;
        if (x > n) return 1.;
        return (Math.sin(x) / (Math.pow(x, 2.) + 1)) * recursion(x + 1, n);
    }

    static double loop(int n) {
        double result = 1.;
        for (int x = 1; x <= n; x++) {
            iterations++;
            result *= Math.sin(x) / (Math.pow(x, 2.) + 1);
        }
        return result;
    }
}
