import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class First {

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
        Map<Integer, ArrayList<Integer>> map;
        long[][] arr;
        long[][] dp = new long[2][100005];
        public void call(InputReader in, PrintWriter out) {
            int n;
            n = in.nextInt();

            map = new HashMap<>();
            arr = new long[n][2];

            for (int i = 0; i < n; i++) {
                arr[i][0] = in.nextLong();
                arr[i][1] = in.nextLong();
            }

            int u, v;

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j <= n; j++) {
                    dp[i][j] = -1;
                }
            }

            for (int i = 0; i < n-1; i++) {
                u = in.nextInt()-1;
                v = in.nextInt()-1;

                if(map.getOrDefault(u,null)==null){
                    map.put(u, new ArrayList<>());
                }
                map.get(u).add(v);

                if(map.getOrDefault(v,null)==null){
                    map.put(v, new ArrayList<>());
                }
                map.get(v).add(u);
            }

            out.println(Math.max(ans(0, -1,0), ans(0,-1,1)));

        }
        public long ans (int child, int par, int choice){
            if(dp[choice][child]!=-1){
                return dp[choice][child];
            }
            long opt = 0;
            
            for (Integer i : map.get(child)) {
                if(i!=par) {
                    opt += Math.max(Math.abs(arr[i][0] - arr[child][choice]) + ans(i, child, 0), Math.abs(arr[child][choice] - arr[i][1]) + ans(i, child, 1));
                }
            }
            
            return dp[choice][child] = opt;
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
        long a;
        long b;

        public answer(long a, long b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(answer o) {
            return 0;
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
            if(o.c==this.c){
                return this.a - o.a;
            }
            return o.c - this.c;
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
        for (Long i:a) l.add(i);
        Collections.sort(l);
        for (int i=0; i<a.length; i++) a[i]=l.get(i);
    }

    static final Random random=new Random();

    static void shuffleSort(int[] a) {
        int n=a.length;
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