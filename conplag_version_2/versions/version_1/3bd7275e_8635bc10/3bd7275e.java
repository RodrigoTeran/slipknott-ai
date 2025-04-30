// ＼(≧▽≦)／
// Terminus
// TODO : get good

import java.io.*;
import java.util.*;

public class tank {

    static final FastScanner fs = new FastScanner();

    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = fs.nextInt();
        while(t-- > 0) run_case();

        out.close();
    }

    static void run_case() {
        int n = fs.nextInt();
        long k = fs.nextLong();
        int[] a = fs.readArray(n);

        ruffleSort(a);

        long sum = 0;

        for(int i: a) sum += i;

        if(sum <= k) {
            out.println(0);
            return;
        }

        long ans = sum - k, dif;

        for (int i = 1; i < n; i++) {
            sum -= a[n - i];
            sum += a[0];
            //out.println(sum);
            if(sum <= k) {
                ans = Math.min(ans, i);
                continue;
            }
            dif = sum - k;
            if(dif % (i + 1) == 0) {
                ans = Math.min(ans, dif / (i + 1) + i);
            } else {
                ans = Math.min(ans, dif / (i + 1) + 1 + i);
            }
        }

        out.println(ans);
    }

    static void ruffleSort(int[] a) {
        int n=a.length;
        Random r=new Random();
        for (int i=0; i<a.length; i++) {
            int oi=r.nextInt(n), temp=a[i];
            a[i]=a[oi];
            a[oi]=temp;
        }

        Arrays.sort(a);
    }

    static class FastScanner {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer("");
        String next() {
            while (!st.hasMoreTokens())
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        String nextLine(){
            try {
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return "";
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a=new int[n];
            for (int i=0; i<n; i++) a[i]=nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}