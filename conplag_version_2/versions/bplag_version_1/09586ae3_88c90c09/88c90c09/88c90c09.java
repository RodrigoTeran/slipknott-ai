import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLOutput;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA solver = new TaskA();
        //int a = 1;
        int t;
        t = in.nextInt();
        //t = 1;
        while (t > 0) {
            //out.print("Case #"+(a++)+": ");
            solver.call(in,out);
            t--;
        }
        out.close();

    }

    static class TaskA {
        int n;
        long[] arr;
        public void call(InputReader in, PrintWriter out) {
            n = in.nextInt();
            arr = new long[n];

            for (int i = 0; i < n; i++) {
                arr[i] = in.nextLong();
            }
            long l, r, mid;
            l = 0;
            r = (long)1e10;
            while (l  + 1 < r){
                mid = ( l + r)/2;
                if(ans(mid)){
                    l = mid;
                }
                else{
                    r = mid;
                }
            }

            out.println(l);
        }

        public boolean ans(long mid) {
            long[] array = new long[n];
            long a, b;
            for (int i = n - 1; i >= 2; i--) {
                a = mid - array[i];
                if(a > 0){
                    b = arr[i] - a;
                    if(b >= 0){
                        b/=3;
                        array[i - 1] += b;
                        array[i - 2] += 2*b;
                    }
                    else{
                        return false;
                    }
                }
                else{
                    b = arr[i];
                    b/=3;
                    array[i - 1] += b;
                    array[i - 2] += 2*b;
                }
            }
            for (int i = 0; i < 2; i++) {
                if(arr[i] + array[i] < mid){
                    return false;
                }
            }
            return true;
        }
    }

    static int gcd(int a, int b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    static int lcm(int a, int b)
    {
        return (a / gcd(a, b)) * b;
    }


    static class answer implements Comparable<answer>{
        int a, b;

        public answer(int a, int b) {
            this.a = a;
            this.b = b;
        }
        @Override
        public int compareTo(answer o) {
            return Integer.compare(this.a, o.a);
        }

    }

    static class answer1 implements Comparable<answer1>{
        int a, b, c;

        public answer1(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;

        }

        @Override
        public int compareTo(answer1 o) {
            return (o.a - this.a);
        }
    }

    static long gcd(long a, long b)
    {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    static void sort(long[] a) {
        ArrayList<Long> l = new ArrayList<>();
        for (Long i:a) l.add(i);
        l.sort(Collections.reverseOrder());
        for (int i=0; i<a.length; i++) a[i]=l.get(i);
    }

    static final Random random=new Random();

    static void shuffleSort(int[] a) {
        int n = a.length;
        for (int i=0; i<n; i++) {
            int oi= random.nextInt(n), temp=a[oi];
            a[oi]=a[i]; a[i]=temp;
        }
        Arrays.sort(a);
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
        public long nextLong(){
            return Long.parseLong(next());
        }
        public double nextDouble() {
            return Double.parseDouble(next());
        }

    }
}