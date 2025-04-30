import java.util.*;
import java.io.*;

public class Main {
    // For fast input output
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            try {
                br = new BufferedReader(
                        new FileReader("input.txt"));
                PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
                System.setOut(out);
            } catch (Exception e) {
                br = new BufferedReader(new InputStreamReader(System.in));
            }
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

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
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

    // end of fast i/o code
    public static void main(String[] args) {
        FastReader reader = new FastReader();
        StringBuilder sb = new StringBuilder("");

        int t = reader.nextInt();
        int ans = 0;        

        while (t-- > 0) {
            int n = reader.nextInt();
            int nodes[] = new int[n];
            int edges[][] = new int[n-1][2];
            ArrayList<Pair> graph[] = new ArrayList[n];
            for(int i=0; i<n; i++){
                graph[i] = new ArrayList<>();
            }
            for(int i=0; i<n-1; i++){
                int a = reader.nextInt()-1;
                int b = reader.nextInt()-1;
                graph[a].add(new Pair(b, i));
                graph[b].add(new Pair(a, i));
                nodes[a]++;
                nodes[b]++;
            }
            boolean possible = true;
            for(int i=0; i<n; i++){
                if(nodes[i]>2){
                    possible = false;
                }
            }
            Arrays.fill(nodes, 0);
            int first = 2;
            int second = 5;
            
            if(possible){
                int fill_ans[] = new int[n-1];
                find(0, -1, graph, fill_ans, n, first, second, true);
                for(int i=0; i<n-1; i++){
                    sb.append(fill_ans[i]+" ");
                }
            }else{
                sb.append("-1");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void find(int node, int par, ArrayList<Pair> graph[], int fill_ans[], int n, int first, int second, boolean first_fill){

        for(Pair p: graph[node]){
            if(p.a==par){
                continue;
            }
            if(first_fill){
                fill_ans[p.b] = first;
            }else{
                fill_ans[p.b] = second;
            }
            find(p.a, node, graph, fill_ans, n, first, second, !first_fill);
            first_fill = !first_fill;
        }

    }

    static class Pair{
        int a, b;
        Pair(int x, int y){
            a = x;
            b = y;
        }
    }
}