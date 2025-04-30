import java.util.*;
import java.io.*;

public class Main{
    static final Random random=new Random();
    static long mod=1000000007L;
    static HashMap<String,Integer>map=new HashMap<>();

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br=new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st==null || !st.hasMoreTokens()){
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
        long nextLong(){
            return Long.parseLong(next());
        }
        double nextDouble(){
            return Double.parseDouble(next());
        }
        String nextLine(){
            String str="";
            try {
                str=br.readLine().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
        int[] readIntArray(int n){
            int[] res=new int[n];
            for(int i=0;i<n;i++)res[i]=nextInt();
            return res;
        }
    }
    static class FastWriter {
		private final BufferedWriter bw;

		public FastWriter() {
			this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
		}

		public void print(Object object) throws IOException {
			bw.append("" + object);
		}

		public void println(Object object) throws IOException {
			print(object);
			bw.append("\n");
		}

		public void close() throws IOException {
			bw.close();
		}
	}
    public static void main(String[] args) {
        try {
            FastReader in=new FastReader();
            FastWriter out = new FastWriter();
            int testCases=in.nextInt();
            //out.println("hee");
            //int testCases=1;
            while(testCases-- > 0){
                solve(in);
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
    public static void solve( FastReader in){
        int n=in.nextInt();
                List<List<Pair>> graph=new ArrayList<>();
                for(int i=0;i<n;i++){
                    graph.add(new ArrayList<>());
                }
                //out.println("hee");
                for(int i=0;i<n-1;i++){
                    int u=in.nextInt();
                    int v=in.nextInt();
                    u--;v--;
                    graph.get(u).add(new Pair(v,i));
                    graph.get(v).add(new Pair(u,i));
                }
                int start=0;
                for(int i=0;i<n;i++){
                    if(graph.get(i).size()>2){
                        System.out.println(""+-1);
                        return;
                    }
                    else if(graph.get(i).size()==1){
                        start=i;
                    }
                }
                int[] ans=new int[n-1];
                int[] vis=new int[n+1];
                vis[start]=1;
                int w=2;
                Queue<Integer> q=new LinkedList<>();
                q.add(start);
                while(!q.isEmpty()){
                    int x=q.poll();
                    for(Pair p:graph.get(x)){
                        if(vis[p.node]==0){
                            vis[p.node]=1;
                            q.add(p.node);
                            int idx=p.eg_indx;
                            ans[idx]=w;
                            if(w==2)w=5;
                            else w=2;    
                        }
                    }
                }
                for(int i:ans){
                    System.out.print(i+" ");
                }
                System.out.println("");
    }
    static class Pair{
        int node;
        int eg_indx;
        Pair(int node,int eg_indx){
            this.node=node;
            this.eg_indx=eg_indx;
        }
    }
    static int gcd(int a,int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
}