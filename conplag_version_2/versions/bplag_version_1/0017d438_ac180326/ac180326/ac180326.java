import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class A {
    static List<Integer> [] adj;
    static ArrayList<Integer> temp;
    static int mod = (int) 1e9+7;
    static boolean[] vis = new boolean[(int)1e5];
    static List<Integer> l = new ArrayList<>();
    static final Reader s = new Reader();

    public static void main(String[] args) throws IOException {
        int t = s.nextInt();
//        int t=1;
       while(t-->0) {
           int n = s.nextInt();
           int m = s.nextInt();
           int d = s.nextInt();
           System.out.println("YES");
           PriorityQueue<Pair> pq = new PriorityQueue<>();
            for(int i=1;i<=m;i++){
               pq.add(new Pair(i));
            }
            for(int i=0;i<n;i++){
                int v = s.nextInt();
                Pair p = pq.poll();
                p.sum+=v;
                pq.add(p);
                System.out.print(p.id+" ");
            }
           System.out.println();
       }
    }
    static class Pair implements Comparable<Pair> {
        int id;
        long sum=0;
        public Pair(int id) {
            this.id=id;
        }
        public int compareTo(Pair o) {
            return Long.compare(sum, o.sum);
        }
    }
    //Important
    //Dont't stick on same approach
    //Check long
    static void dfs(int i){
        vis[i]=true;
        l.add(i);
        List<Integer> Y = adj[i];
        for(int x:Y){
            if(!vis[x])dfs(x);
        }
    }

    static long gcd(long a, long b) throws IOException {
        return (b == 0) ? a : gcd(b, a % b);
    }

    static int gcd(int a, int b) throws IOException {
        return (b == 0) ? a : gcd(b, a % b);
    }

    static void sortr(int[] a) {
        ArrayList<Integer> l = new ArrayList<>();
        for (int i : a)
            l.add(i);
        Collections.sort(l, Collections.reverseOrder());
        for (int i = 0; i < a.length; i++)
            a[i] = l.get(i);
    }

    static void sort(int[] a) {
        ArrayList<Integer> l = new ArrayList<>();
        for (int i : a)
            l.add(i);
        Collections.sort(l);
        for (int i = 0; i < a.length; i++)
            a[i] = l.get(i);
    }

    static void sort(long[] a) {
        ArrayList<Long> l = new ArrayList<>();
        for (long i : a)
            l.add(i);
        Collections.sort(l);
        for (int i = 0; i < a.length; i++)
            a[i] = l.get(i);
    }

    static class Reader {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String next() {
            while(st==null||!st.hasMoreTokens()) {
                try {
                    st=new StringTokenizer(in.readLine());
                } catch(Exception e) {}
            }
            return st.nextToken();
        }
        int nextInt() {
            return Integer.parseInt(next());
        }
        long nextLong() {
            return Long.parseLong(next());
        }
    }

}