import java.io.*; 
import java.util.*; 

public class D  
{
   public static ArrayList<Integer> adj[];
   public static int node;
   public static int dist = 0;
   public static void main(String[] args) throws IOException
   {
      FastScanner sc = new FastScanner();
      int T = sc.nextInt();
      PrintWriter out = new PrintWriter(System.out);
      for(int t = 0; t < T; t++){
         int N = sc.nextInt();
         int a = sc.nextInt(); int b = sc.nextInt();
         int da = sc.nextInt(); int db = sc.nextInt();
         adj = new ArrayList[N+1];
         for(int i = 0; i <= N; i++){
            adj[i] = new ArrayList<Integer>();
         }
         for(int i = 0; i < N-1; i++){
            int v = sc.nextInt();
            int u = sc.nextInt();
            adj[v].add(u);
            adj[u].add(v);
         }
         if(db > 2*da){
            dfs1(a, 0, b, 0);
            if(dist <= da){
               out.println("Alice");
            }
            else{
               node = 0;
               dist = 0;
               dfs(1, 0, 0);
               dfs(node, 0, 0);
               if(dist > 2*da){
                  out.println("Bob");
               }
               else{
                  out.println("Alice");
               }
            }
         }
         else{
            out.println("Alice");
         }
      }
      out.close();
   }  
   public static void dfs1(int a, int p, int b, int d){
      if(a == b){
         dist = d;
      }
      for(int next : adj[a]){
         if(next != p){
            dfs1(next, a, b, d+1);
         }  
      }
   }
   public static void dfs(int i, int p, int d){
      if(d > dist){
         node = i;
         dist = d;
      }
      for(int next : adj[i]){
         if(next != p){
            dfs(next, i, d+1);
         }  
      }
   }


   static class FastScanner {
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
            if (size == -1) 
               return NC;
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
         if (c > 32) 
            return true;
         while (true) {
            c = getChar();
            if (c == NC) 
               return false;
            else if (c > 32) 
               return true;
         }
      }
   }

   static void ASSERT(boolean assertion, String message) {
      if (!assertion) throw new AssertionError(message);
   }
}
