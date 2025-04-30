import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class C_CF {

    public static void main(String[] args) {
        FastScanner57 fs = new FastScanner57();
        PrintWriter pw = new PrintWriter(System.out);
        int t = fs.ni();
        //int t = 1;
        for (int tc = 0; tc < t; tc++) {
            int n = fs.ni();
            long[][] lr = new long[n][2];
            for (int i = 0; i < n; i++) {
                lr[i][0] = fs.nl();
                lr[i][1] = fs.nl();
            }
            List<List<Integer>> list = new ArrayList();
            for (int i = 0; i < n;i ++) {
                List<Integer> temp = new ArrayList();
                list.add(temp);
            }
            for (int i = 0; i < n-1; i++) {
                int a = fs.ni()-1, b = fs.ni()-1;
                list.get(a).add(b);
                list.get(b).add(a);
            }
            Long[][] dp = new Long[n][2];
            pw.println(recur(0,0,-1,new long[] {0,0},dp,lr,list));
        }
        pw.close();

    }
    // 0 -> left was chosen
    // 1 -> right was chosen
    public static long recur(int ind, int p,int prev, long[] v, Long[][] dp, long[][] lr,List<List<Integer>> list) {

        long last = v[0];
        long ls = 0L;
        long rs = 0L;
        if (p==1) {
            last = v[1];
        }
        if (ind!=0) ls += (long)Math.abs(last-lr[ind][0]);
        if (ind!=0) rs += (long)Math.abs(last-lr[ind][1]);
        if (dp[ind][p]!=null) return dp[ind][p];
        long[] cur = lr[ind];
        
        List<Integer> temp = list.get(ind);
        for (int val : temp) {
            if (prev==val) continue;
            ls += recur(val,0,ind,cur,dp,lr,list);
            rs += recur(val,1,ind,cur,dp,lr,list);
        }
        return dp[ind][p] = Math.max(ls,rs);
    }

    public static void sort(long[] a) {
        List<Long> list = new ArrayList();
        for (int i = 0; i < a.length; i++) {
            list.add(a[i]);
        }
        Collections.sort(list);
        for (int i = 0; i < a.length; i++) {
            a[i] = list.get(i);
        }
    }

    public static long gcd(long n1, long n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcd(n2, n1 % n2);
    }

}

class UnionFind16 {

    int[] id;

    public UnionFind16(int size) {
        id = new int[size];
        for (int i = 0; i < size; i++) {
            id[i] = i;
        }
    }

    public int find(int p) {
        int root = p;
        while (root != id[root]) {
            root = id[root];
        }
        while (p != root) {
            int next = id[p];
            id[p] = root;
            p = next;
        }
        return root;
    }

    public void union(int p, int q) {
        int a = find(p), b = find(q);
        if (a == b) {
            return;
        }
        id[b] = a;
    }
}

class FastScanner57 {

    BufferedReader br;
    StringTokenizer st;

    public FastScanner57() {
        br = new BufferedReader(new InputStreamReader(System.in), 32768);
        st = null;
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int ni() {
        return Integer.parseInt(next());
    }

    int[] intArray(int N) {
        int[] ret = new int[N];
        for (int i = 0; i < N; i++) {
            ret[i] = ni();
        }
        return ret;
    }

    long nl() {
        return Long.parseLong(next());
    }

    long[] longArray(int N) {
        long[] ret = new long[N];
        for (int i = 0; i < N; i++) {
            ret[i] = nl();
        }
        return ret;
    }

    double nd() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
