//package Current;

import java.util.*;

public class test {
    static final long mod = (long) 1e9 + 7;

    static class pair {
        int x, y;

        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int t = 1;
        t = sc.nextInt();
        while (t-- > 0) {
            // Start code
            int n = sc.nextInt();
            long[] cost = new long[n];
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                cost[i] = sc.nextLong();
                a[i] = cost[i];
                if (i > 1)
                    a[i] = Math.min(a[i], a[i - 2]);
            }
            long sum = cost[0];
            long res = Long.MAX_VALUE;

            for (int i = 1; i < n; i++) {
                sum += cost[i];
                long cur = sum - a[i] - a[i - 1];
                int p = (i + 1) / 2;
                int q = (i + 1) - p;
                int x = n - p + 1;
                int y = n - q + 1;
                cur += (a[i - 1] * x + a[i] * y);
                res = Math.min(res, cur);
            }
            println(res);
        }
        sc.close();
    }

    static void print(Object o) {
        System.out.print(o + " ");
    }

    static void println(Object o) {
        System.out.println(o);
    }

    static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static ArrayList<Long> factorial(int num) {
        ArrayList<Long> fac = new ArrayList<>();
        fac.add((long) 0);
        fac.add((long) 1);

        for (int i = 2; i < num; i++) {
            fac.add((fac.get(i - 1) * i) % mod);
        }

        return fac;
    }

    static long ncr(long x, long y, ArrayList<Long> fac) {
        if (y >= x)
            return (long) 1;

        long res = fac.get((int) x);
        long z = (fac.get((int) y) * fac.get((int) (x - y))) % mod;
        z = modInv(z);
        res = (res * z) % mod;
        return res;
    }

    static long modInv(long x) {
        return modExpo(x, mod - 2);
    }

    static long modExpo(long x, long y) {
        long res = 1;
        x = x % mod;
        while (y > 0) {
            if (y % 2 == 1)
                res = (res * x) % mod;
            y = y / 2;
            x = (x * x) % mod;
        }
        return res;
    }

    static int lowerBound(int n, long[] arr, long value) {
        int res = (int) 1e7;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] >= value) {
                res = mid;
                r = mid - 1;
            } else
                l = mid + 1;
        }
        return res;
    }
}
