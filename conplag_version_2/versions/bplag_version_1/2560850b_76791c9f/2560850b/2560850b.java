import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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
        Map<Integer, ArrayList<Integer>> ans;
        Map<Integer,Boolean> visited;
        Map<Integer, List<Integer>> map;
        public void call(InputReader in, PrintWriter out) {
            int n = in.nextInt();
            answer[] arr = new answer[n];
            visited = new HashMap<>();
            ans = new HashMap<>();
            int u, v;
            map = new HashMap<>();
            for (int i = 0; i < n - 1; i++) {
                arr[i] = new answer(in.nextInt(), in.nextInt());
                u = arr[i].a;
                v = arr[i].b;
                map.putIfAbsent(u, new ArrayList<>());
                map.get(u).add(v);
                map.putIfAbsent(v, new ArrayList<>());
                map.get(v).add(u);
            }
            int a = 0;
            for(Integer i : map.keySet()){
                if(map.get(i).size() > 2){
                    out.println(-1);
                    return;
                }
                if(map.get(i).size()==1){
                    a = i;
                }
            }
            dfs(a, -1, 0);

            int[] ans1 = new int[n - 1];

            for(int i = 0; i < n-1; i++){
                u = arr[i].a;
                v = arr[i].b;
                if(ans.getOrDefault(u, null)!=null && ans.get(u).get(0)==v){
                    if(ans.get(u).get(1)==0){
                        ans1[i] = 2;
                    }
                    else{
                        ans1[i] = 5;
                    }
                }
                else{
                    if(ans.get(v).get(1)==0){
                        ans1[i] = 2;
                    }
                    else{
                        ans1[i] = 5;
                    }
                }
            }
            for(Integer i : ans1){
                out.print(i+" ");
            }
            out.println();
        }
        public void dfs(int child, int par, int c){
            if(par!=-1){
                ans.putIfAbsent(par, new ArrayList<>());
                ans.get(par).add(child);
                ans.get(par).add(c);
            }
            visited.put(child, true);
            for(Integer i : map.get(child)){
                if(!visited.getOrDefault(i, false)){
                    dfs(i, child, c^1);
                }
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