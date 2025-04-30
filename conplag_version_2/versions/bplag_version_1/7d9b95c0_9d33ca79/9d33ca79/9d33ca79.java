import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class NotAssigning {
    static ArrayList<Integer>[]adj;
    static boolean vis [];
    static int edges[];
    // we need to check that every path of length 1 or 2 must be a prime number
    // Idea--> we will only use 2 , 3 for the weight assignment
    // no assignment will be valid if there exists a node connected to 3 others

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            vis= new boolean [n];
            adj= new ArrayList[n];
            TreeMap<Integer,Pair> idx = new TreeMap<>();
            TreeMap<Pair,Integer> w= new TreeMap<>();
            boolean notValid = false;
            for(int i =0;i<n;i++){
                adj[i]= new ArrayList<>();
            }
            for(int i =1;i<n;i++){
                int u = sc.nextInt()-1;
                int v = sc.nextInt()-1;
                int max = Math.max(u,v);
                int min = Math.min(u,v);
                idx.put(i,new Pair(min , max));
                adj[u].add(v);
                adj[v].add(u);
                if(adj[u].size()>2||adj[v].size()>2)notValid=true;
            }
            if(notValid){
                pw.println(-1);
                continue;
            }
            dfs(0,2,w);
//            vis[0]=true;
//            dfs(adj[0].get(0),2,w);
//            if(adj[0].size()==2)dfs(adj[0].get(1),3,w);
            for(int i =1;i<n;i++){
                pw.print(w.get(idx.get(i))+" ");
            }
            pw.println();

        }
        pw.close();
    }
    static void dfs(int node , int w , TreeMap<Pair , Integer>weight){
        vis[node]=true;
        int i =0;
        for(int x : adj[node]){
            if(!vis[x]) {
                int min = Math.min(x , node);
                int max = Math.max(x , node);
                if(i%2==0){
                    weight.put(new Pair(min , max),w);
                    dfs(x, 5-w,weight);
                }
                else{
                    weight.put(new Pair(min , max),5-w);
                    dfs(x, w, weight);
                }
                i++;
            }

            }
        }


    static class Pair implements Comparable<Pair>{
        int x;
        int y ;
        Pair(int x , int y ){
            this.x=x;
            this.y=y;
        }

        @Override
        public int compareTo(Pair o) {
            if(this.x==o.x)return this.y-o.y;
            return this.x-o.x;
        }
    }
    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public Scanner(FileReader r) {
            br = new BufferedReader(r);
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public double nextDouble() throws IOException {
            String x = next();
            StringBuilder sb = new StringBuilder("0");
            double res = 0, f = 1;
            boolean dec = false, neg = false;
            int start = 0;
            if (x.charAt(0) == '-') {
                neg = true;
                start++;
            }
            for (int i = start; i < x.length(); i++)
                if (x.charAt(i) == '.') {
                    res = Long.parseLong(sb.toString());
                    sb = new StringBuilder("0");
                    dec = true;
                } else {
                    sb.append(x.charAt(i));
                    if (dec)
                        f *= 10;
                }
            res += Long.parseLong(sb.toString()) / f;
            return res * (neg ? -1 : 1);
        }
        public long[] nextlongArray(int n) throws IOException {
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            return a;
        }

        public Long[] nextLongArray(int n) throws IOException {
            Long[] a = new Long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            return a;
        }

        public int[] nextIntArray(int n) throws IOException {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        public Integer[] nextIntegerArray(int n) throws IOException {
            Integer[] a = new Integer[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }


        public boolean ready() throws IOException {
            return br.ready();
        }

    }
}
