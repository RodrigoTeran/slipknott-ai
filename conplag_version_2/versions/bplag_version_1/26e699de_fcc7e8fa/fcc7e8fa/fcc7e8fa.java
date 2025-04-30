import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

public class Main {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA solver = new TaskA();
        int t;
        t = in.nextInt();
        //t = 1;
        while (t > 0) {
            solver.call(in,out);
            t--;
        }
        out.close();
    }

    static class TaskA {
        public void call(InputReader in, PrintWriter out) {
            int n, _00 = 0, _01 = 0, _11 = 0, _10 = 0;
            n = in.nextInt();
            char[] s = in.next().toCharArray();
            char[] s1 = in.next().toCharArray();

            for (int i = 0; i < n; i++) {
                if(s[i]==s1[i]){
                    if(s[i]=='0'){
                        _00++;
                    }
                    else{
                        _11++;
                    }
                }
                else{
                    if(s[i]=='0'){
                        _01++;
                    }
                    else{
                        _10++;
                    }
                }
            }
            int ans = Integer.MAX_VALUE;

            if(_10 ==_01){
                ans = 2*_01;
            }
            if(_11 == _00 + 1){
                ans = Math.min(ans, 2*_00 + 1);
            }

            if(ans == Integer.MAX_VALUE){
                out.println(-1);
            }
            else{
                out.println(ans);
            }
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
            return o.a - this.a;
        }
    }

    static class arrayListClass {
        ArrayList<Integer> arrayList2 ;

        public arrayListClass(ArrayList<Integer> arrayList) {
            this.arrayList2 = arrayList;
        }
    }

    static long gcd(long a, long b)
    {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    static void sort(long[] a) {
        ArrayList<Long> l=new ArrayList<>();
        for (long i:a) l.add(i);
        Collections.sort(l);
        for (int i=0; i<a.length; i++) a[i]=l.get(i);
    }

    static final Random random=new Random();

    static void shuffleSort(int[] a) {
        int n = a.length;
        for (int i=0; i<n; i++) {
            int oi=random.nextInt(n), temp=a[oi];
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