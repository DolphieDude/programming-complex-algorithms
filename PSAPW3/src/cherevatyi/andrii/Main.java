package cherevatyi.andrii;

public class Main {

    public static void main(String[] args) {
	    int n = 10;
        double[] a = new double[n];
        long time1, time2;
        System.out.println("a:");
        for (int i = 0; i < n; i++) {
            a[i] = Math.random() * (50 + 50 + 1) - 50;
            System.out.print(a[i] + "; ");
        }
        int n2 = 0;
        for (double e: a) if (e > 0.) n2++;
        double[] bInsertion = new double[n2];
        double[] bShell = new double[n2];
        System.out.println("\nb:");
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] > 0.) {
                bInsertion[j] = a[i];
                bShell[j] = a[i];
                System.out.print(bInsertion[j] + "; ");
                j++;
            }
        }
        time1 = System.currentTimeMillis();
        bInsertion = insertionSort(bInsertion);
        time2 = System.currentTimeMillis();
        System.out.println("\nInsertion sort:");
        for (double e: bInsertion) System.out.print(e + "; ");
        System.out.println("\n" + (time2 - time1) + "ms");
        time1 = System.currentTimeMillis();
        bShell = shellSort(bShell);
        time2 = System.currentTimeMillis();
        System.out.println("Shell sort:");
        for (double e: bShell) System.out.print(e + "; ");
        System.out.println("\n" + (time2 - time1) + "ms");
    }

    static double[] insertionSort(double[] arr) {
        int n = arr.length;
        int j;
        double key;
        for (int i = 1; i < n; ++i) {
            key = arr[i];
            j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        return arr;
    }

    static double[] shellSort(double[] arr) {
        int n = arr.length;
        for (int gap = n / 2; gap > 0; gap /= 2)
        {
            for (int i = gap; i < n; i += 1)
            {
                double swap = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > swap; j -= gap) arr[j] = arr[j - gap];
                arr[j] = swap;
            }
        }
        return arr;
    }
}
