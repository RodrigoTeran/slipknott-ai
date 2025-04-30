import java.io.*;
import java.util.*;

public class c {

    public static void main(String[] args){

        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while(t-- > 0){

            int n = sc.nextInt();


            ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
            for(int i=0; i<n; i++){
                graph.add(new ArrayList<Edge>());
            }

            for(int i=0; i<n-1; i++){
                int u = sc.nextInt();
                int v = sc.nextInt();

                Edge e = new Edge(u-1, v-1, i+1);
                Edge e2 = new Edge(v-1, u-1, i+1);

                graph.get(u-1). add(e);
                graph.get(v-1).add(e2);

            }

            int edges[] = new int[n];

            int indegree1count = 0;
            int indegree2count = 0;
            for(ArrayList<Edge> list : graph){
                if(list.size() == 1){
                    indegree1count++;
                }
                else if(list.size() == 2){
                    indegree2count++;
                }
            }

            if(indegree1count == 2 && indegree1count+indegree2count==n){

                for(int i=0; i<graph.size(); i++){
                    ArrayList<Edge> list = graph.get(i);
                    if(list.size() == 1){
                        dfs(graph, edges, false, -1, i) ;
                    }
                }

                for(int i=1; i<edges.length; i++){
                    System.out.print(edges[i] + " ");
                }
                System.out.println();

            }
            else{
                System.out.println(-1);
            }


        }

    }

    public static void dfs(ArrayList<ArrayList<Edge>> graph, int[] edges, boolean isprev2, int parent, int current){

        for(Edge e : graph.get(current)){

            if(e.v == parent){
                continue;
            }

            edges[e.id] = isprev2 ? 5 : 2;

            dfs(graph, edges, !isprev2, current, e.v);

        }

    }

}

class Edge {

    int u;
    int v;
    int id;

    public Edge(int u, int v, int id) {
        this.u = u;
        this.v = v;
        this.id = id;
    }

}

class FastScanner
{
    //I don't understand how this works lmao
    private int BS = 1 << 16;
    private char NC = (char) 0;
    private byte[] buf = new byte[BS];
    private int bId = 0, size = 0;
    private char c = NC;
    private double cnt = 1;
    private BufferedInputStream in;

    public FastScanner() {
        in = new BufferedInputStream(System.in, BS);
    }

    public FastScanner(String s) {
        try {
            in = new BufferedInputStream(new FileInputStream(new File(s)), BS);
        } catch (Exception e) {
            in = new BufferedInputStream(System.in, BS);
        }
    }

    private char getChar() {
        while (bId == size) {
            try {
                size = in.read(buf);
            } catch (Exception e) {
                return NC;
            }
            if (size == -1) return NC;
            bId = 0;
        }
        return (char) buf[bId++];
    }

    public int nextInt() {
        return (int) nextLong();
    }

    public int[] nextInts(int N) {
        int[] res = new int[N];
        for (int i = 0; i < N; i++) {
            res[i] = (int) nextLong();
        }
        return res;
    }

    public long[] nextLongs(int N) {
        long[] res = new long[N];
        for (int i = 0; i < N; i++) {
            res[i] = nextLong();
        }
        return res;
    }

    public long nextLong() {
        cnt = 1;
        boolean neg = false;
        if (c == NC) c = getChar();
        for (; (c < '0' || c > '9'); c = getChar()) {
            if (c == '-') neg = true;
        }
        long res = 0;
        for (; c >= '0' && c <= '9'; c = getChar()) {
            res = (res << 3) + (res << 1) + c - '0';
            cnt *= 10;
        }
        return neg ? -res : res;
    }

    public double nextDouble() {
        double cur = nextLong();
        return c != '.' ? cur : cur + nextLong() / cnt;
    }

    public double[] nextDoubles(int N) {
        double[] res = new double[N];
        for (int i = 0; i < N; i++) {
            res[i] = nextDouble();
        }
        return res;
    }

    public String next() {
        StringBuilder res = new StringBuilder();
        while (c <= 32) c = getChar();
        while (c > 32) {
            res.append(c);
            c = getChar();
        }
        return res.toString();
    }

    public String nextLine() {
        StringBuilder res = new StringBuilder();
        while (c <= 32) c = getChar();
        while (c != '\n') {
            res.append(c);
            c = getChar();
        }
        return res.toString();
    }

    public boolean hasNext() {
        if (c > 32) return true;
        while (true) {
            c = getChar();
            if (c == NC) return false;
            else if (c > 32) return true;
        }
    }
}