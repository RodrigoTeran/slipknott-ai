import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.*;
import java.io.*;
import java.lang.*;
public class Main{
    public static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private InputReader.SpaceCharFilter filter;
        private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     
        public InputReader(InputStream stream) {
            this.stream = stream;
        }
     
        public int read() {
            if (numChars==-1)
                throw new InputMismatchException();
     
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                }
                catch (IOException e) {
                    throw new InputMismatchException();
                }
     
                if(numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }
     
        public String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
        public int nextInt() {
            int c = read();
     
            while(isSpaceChar(c))
                c = read();
     
            int sgn = 1;
     
            if (c == '-') {
                sgn = -1;
                c = read();
            }
     
            int res = 0;
            do {
                if(c<'0'||c>'9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));
     
            return res * sgn;
        }
     
        public long nextLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
     
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));
            return res * sgn;
        }
     
        public double nextDouble() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E')
                    return res * Math.pow(10, nextInt());
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E')
                        return res * Math.pow(10, nextInt());
                    if (c < '0' || c > '9')
                        throw new InputMismatchException();
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }
     
        public String readString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            }
            while (!isSpaceChar(c));
     
            return res.toString();
        }
     
        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
     
        public String next() {
            return readString();
        }
     
        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }
 
    static long gcd(long a, long b){
        if (a == 0)
            return b;  
        return gcd(b % a, a);  
    }
    static long lcm(long a, long b)  {
        return (a*b)/gcd(a, b);  
    }
    public static void sortbyColumn(int arr[][], int col) 
    { 
        
        Arrays.sort(arr, new Comparator<int[]>() { 
            
          @Override              
          
          public int compare(final int[] entry1,  
                             final int[] entry2) { 
  
            
            if (entry1[col] > entry2[col]) 
                return 1; 
            else
                return -1; 
          } 
        });  
    } 
    static long func(long a[],int size,int s){
        long max1=a[s];
        long maxc=a[s];
        for(int i=s+1;i<size;i++){
            maxc=Math.max(a[i],maxc+a[i]);
            max1=Math.max(maxc,max1);
        }
        return max1;
    }
    public static class Pair<U extends Comparable<U>, V extends Comparable<V>> implements Comparable<Pair<U, V>> {
        public U x;
        public V y;
    
        public Pair(U x, V y) {
            this.x = x;
            this.y = y;
        }
    
        public int hashCode() {
            return (x == null ? 0 : x.hashCode() * 31) + (y == null ? 0 : y.hashCode());
        }
    
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Pair<U, V> p = (Pair<U, V>) o;
            return (x == null ? p.x == null : x.equals(p.x)) && (y == null ? p.y == null : y.equals(p.y));
        }
    
        public int compareTo(Pair<U, V> b) {
            int cmpU = x.compareTo(b.x);
            return cmpU != 0 ? cmpU : y.compareTo(b.y);
        }
    
        public String toString() {
            return String.format("(%s, %s)", x.toString(), y.toString());
        }
    
    }
    static class MultiSet<U extends Comparable<U>> {
        public int sz = 0;
        public TreeMap<U, Integer> t;
 
        public MultiSet() {
            t = new TreeMap<>();
        }
 
        public void add(U x) {
            t.put(x, t.getOrDefault(x, 0) + 1);
            sz++;
        }
 
        public void remove(U x) {
            if (t.get(x) == 1) t.remove(x);
            else t.put(x, t.get(x) - 1);
            sz--;
        }
 
    }
    static void shuffle(long[] a) {
        Random get = new Random();
        for (int i = 0; i < a.length; i++) {
            int r = get.nextInt(a.length);
            long temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }
    static long myceil(long a, long b){
        return (a+b-1)/b;
    }
    
    static long C(long n,long r){
        long count=0,temp=n;
        long ans=1;
        long num=n-r+1,div=1;
        while(num<=n){
            ans*=num;
            //ans+=MOD;
            ans%=MOD;
            ans*=mypow(div,MOD-2);
            //ans+=MOD;
            ans%=MOD;
            num++;
            div++;
        }
        
        ans+=MOD;
        return ans%MOD;
    }
    static long fact(long a){
        long i,ans=1;
        for(i=1;i<=a;i++){
            ans*=i;
            ans%=MOD;
        }
        return ans%=MOD;
    }
    static void sieve(int n){
        is_sieve[0]=1;
        is_sieve[1]=1;
        int i,j,k;
        for(i=2;i<n;i++){
            if(is_sieve[i]==0){
                sieve[i]=i;
                tr.add(i);
                for(j=i*i;j<n;j+=i){
                    if(j>n||j<0){
                        break;
                    }
                    is_sieve[j]=1;
                    sieve[j]=i;
                }
            }
        }
    }
    // static void calc(int n){
    //     int i,j;
    //     dp[n-1]=0;
    //     if(n>1)
    //     dp[n-2]=1;
    //     for(i=n-3;i>=0;i--){
    //         long ind=n-i-1;
    //         dp[i]=((ind*(long)mypow(10,ind-1))%MOD+dp[i+1])%MOD;
    //     }
    // }
    static long mypow(long x,long y){
        long temp; 
        if( y == 0) 
            return 1; 
        temp = mypow(x, y/2); 
        if (y%2 == 0) 
            return (temp*temp)%MOD; 
        else
            return ((x*temp)%MOD*(temp)%MOD)%MOD; 
    }
    static long dist[],dp[][],left[],right[];
    static int visited[],isit[];
    static ArrayList<Pair<Integer,Pair<Long,Long>>> adj[],li;
    //static int dp[][][];
    static int MOD=1000000007;
    static char ch[];
    static int[] sieve,is_sieve;
    static TreeSet<Integer> tr;
    static long mat[][];
    
    // static void bfs(int node,int par,Pair<Long,Long> p[],long taken){
    //     LinkedList<Integer> li=new LinkedList<>();
    //     li.add(node);
        
    //     while(!li.isEmpty()){
    //         int x=li.pollFirst();
    //         long lowNode=p[x-1].x;
    //         long highNode=p[x-1].y;
    //         int left=0,right=0;
    //         visited[x]=1;
    //         for(Pair<Integer,Pair<Long,Long>> pp:adj[x]){
                    
    //                 long max=0;
                    
    //                 if(selected[pp.x]==0){
    //                     max=Math.max(Math.abs(lowNode-pp.y.y),Math.abs(highNode-pp.y.x));
                        
    //                     if(max==Math.abs(lowNode-pp.y.y)){
                            
    //                         left++;
    //                     }else{
                            
    //                         right++;
    //                     }
    //                 }else{
    //                     max=Math.max(Math.abs(lowNode-selected[pp.x]),Math.abs(highNode-selected[pp.x]));
    //                     if(max==Math.abs(lowNode-selected[pp.x])){
                            
    //                         left++;
    //                     }else{
                            
    //                         right++;
    //                     }
    //                 }
    //                 if(visited[pp.x]==0)
    //                 li.add(pp.x);
                
    //         }
    //         if(left>=right){
    //             selected[x]=lowNode;
    //         }else{
    //             selected[x]=highNode;
    //         }
    //     }
    // }
    static void dfs(int node,int par, Pair<Long,Long> p[]){
        for(Pair<Integer,Pair<Long,Long>> pp:adj[node]){
            if(pp.x!=par){
                //sum+=Math.abs(selected[node]-selected[pp.x]);
                dfs(pp.x,node,p);
                //System.out.println(node+" "+pp.x);
                long x=Math.abs(p[node].x-p[pp.x].x);
                long y=Math.abs(p[node].x-p[pp.x].y);
                long z=Math.abs(p[node].y-p[pp.x].x);
                long w=Math.abs(p[node].y-p[pp.x].y);
                
                left[node]+=Math.max(x+left[pp.x],y+right[pp.x]);
                right[node]+=Math.max(z+left[pp.x],w+right[pp.x]);
                
            }
        }
    }
    
    public static void main(String args[]){
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter w = new PrintWriter(outputStream);
        int t,i,j,tno=0,tte;
        
        t=in.nextInt();
        //t=1;
        //tte=t;
        
        while(t-->0){
            //sum=0;
            int n=in.nextInt();
            adj=new ArrayList[n+1];
            left=new long[n+1];
            right=new long[n+1];
            visited=new int[n+1];
            for(i=0;i<n+1;i++){
                adj[i]=new ArrayList<>();
            }
            Pair<Long,Long> p[]=new Pair[n+1];
            for(i=1;i<=n;i++){
                p[i]=new Pair<>(in.nextLong(),in.nextLong());
            } 
            for(i=0;i<n-1;i++){
                int u,v;
                u=in.nextInt();
                v=in.nextInt();
                adj[u].add(new Pair<>(v,p[v]));
                adj[v].add(new Pair<>(u,p[u]));
            }
            //bfs(1,-1,p,Long.MAX_VALUE);
            dfs(1,-1,p);
            // for(i=0;i<n+1;i++){
            //     w.print(selected[i]+" ");
            // }
            // w.println();
            w.println((long)Math.max(left[1],right[1]));
        }
        w.close();
    }
}