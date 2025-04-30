import javax.swing.text.html.parser.Entity;
import java.io.*;
import java.util.*;
import java.math.BigInteger;


public class Main{
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        solver.solve(in, out);
        out.close();
    }
    // main solver
    static class Task{

        double eps= 0.00000001;
        static final int MAXN = 1010;
        static final int MOD= 1000000007;

        // stores smallest prime factor for every number
        static int spf[] = new int[MAXN];

        static boolean[] prime;

        // Calculating SPF (Smallest Prime Factor) for every
        // number till MAXN.
        // Time Complexity : O(nloglogn)
        public void sieve()
        {
            spf[1] = 1;
            for (int i=2; i<MAXN; i++)

                // marking smallest prime factor for every
                // number to be itself.
                spf[i] = i;

            // separately marking spf for every even
            // number as 2
            for (int i=4; i<MAXN; i+=2)
                spf[i] = 2;

            for (int i=3; i*i<MAXN; i++)
            {
                // checking if i is prime
                if (spf[i] == i)
                {
                    // marking SPF for all numbers divisible by i
                    for (int j=i*i; j<MAXN; j+=i)

                        // marking spf[j] if it is not
                        // previously marked
                        if (spf[j]==j)
                            spf[j] = i;
                }
            }
        }

        void sieveOfEratosthenes(int n)
        {
            // Create a boolean array
            // "prime[0..n]" and
            // initialize all entries
            // it as true. A value in
            // prime[i] will finally be
            // false if i is Not a
            // prime, else true.
            prime= new boolean[n + 1];
            for (int i = 0; i <= n; i++)
                prime[i] = true;

            for (int p = 2; p * p <= n; p++)
            {
                // If prime[p] is not changed, then it is a
                // prime
                if (prime[p] == true)
                {
                    // Update all multiples of p
                    for (int i = p * p; i <= n; i += p)
                        prime[i] = false;
                }
            }
        }

        // function to find first index >= x
        public int lowerIndex(List<Integer> arr, int n, int x)
        {
            int l = 0, h = n - 1;
            while (l <= h)
            {
                int mid = (l + h) / 2;
                if (arr.get(mid) >= x)
                    h = mid - 1;
                else
                    l = mid + 1;
            }
            return l;
        }
        public int lowerIndex(int[] arr, int n, int x)
        {
            int l = 0, h = n - 1;
            while (l <= h)
            {
                int mid = (l + h) / 2;
                if (arr[mid] >= x)
                    h = mid - 1;
                else
                    l = mid + 1;
            }
            return l;
        }

        // function to find last index <= y
        public int upperIndex(List<Integer> arr, int n, int y)
        {
            int l = 0, h = n - 1;
            while (l <= h)
            {
                int mid = (l + h) / 2;
                if (arr.get(mid) <= y)
                    l = mid + 1;
                else
                    h = mid - 1;
            }
            return h;
        }
        public int upperIndex(int[] arr, int n, int y)
        {
            int l = 0, h = n - 1;
            while (l <= h)
            {
                int mid = (l + h) / 2;
                if (arr[mid] <= y)
                    l = mid + 1;
                else
                    h = mid - 1;
            }
            return h;
        }

        // function to count elements within given range
        public int countInRange(List<Integer> arr, int n, int x, int y)
        {
            // initialize result
            int count = 0;
            count = upperIndex(arr, n, y) -
                    lowerIndex(arr, n, x) + 1;
            return count;
        }

        public int _gcd(int a,  int  b)
        {

            if(b == 0) {
                return a;
            }
            else {
                return _gcd(b, a % b);
            }
        }

        public int add(int a, int b){
            a+=b;
            if(a>=MOD) a-=MOD;
            else if(a<0) a+=MOD;
            return a;
        }

        public int mul(int a, int b){
            long res= (long)a*(long)b;
            return (int)(res%MOD);
        }

        public int power(int a, int b) {
            int ans=1;
            while(b>0){
                if((b&1)!=0) ans= mul(ans,a);
                b>>=1;
                a= mul(a,a);
            }
            return ans;
        }

        int[] fact= new int[MAXN];
        int[] inv= new int[MAXN];

        public int Ckn(int n, int k){
            if(k<0 || n<0) return 0;
            return mul(mul(fact[n],inv[k]),inv[n-k]);
        }

        public int inverse(int a){
            return power(a,MOD-2);
        }

        public void preprocess() {
            fact[0]=1;
            for(int i=1;i<MAXN;i++) fact[i]= mul(fact[i-1],i);
            inv[MAXN-1]= inverse(fact[MAXN-1]);
            for(int i=MAXN-2;i>=0;i--){
                inv[i]= mul(inv[i+1],i+1);
            }
        }

        /**
         * return VALUE of lower bound for unsorted array
         */
        public int lowerBoundNormalArray(int[] arr, int x){
            TreeSet<Integer> set= new TreeSet<>();
            for(int num: arr) set.add(num);
            return set.lower(x);
        }
        /**
         * return VALUE of upper bound for unsorted array
         */
        public int upperBoundNormalArray(int[] arr, int x){
            TreeSet<Integer> set= new TreeSet<>();
            for(int num: arr) set.add(num);
            return set.higher(x);
        }

        public void debugArr(int[] arr){
            for(int i: arr) out.print(i+" ");
            out.println();
        }

        public int rand(){
            int min=0, max= MAXN;
            int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
            return random_int;
        }

        InputReader in; PrintWriter out;
        static int mod = 1000000007;
        int ans = 0;
        ArrayList<Integer>g[] = new ArrayList[101];
        int cnt[][] = new int[101][101];
        int dp[][] = new int[101][101];
        int Add(int a, int b){
            a+=b; while (a>=mod)a-=mod;
            return a;
        }
        int Mul(int a, int b){
            return (int)(((long)a * b) % mod);
        }
        void dfs(int node, int par, int root, int depth){
            cnt[root][depth]++;
            for (int v : g[node]){
                if (v != par){
                    dfs(v, node, root, depth+1);
                }
            }
        }
        public void solve(InputReader in, PrintWriter out) {
           int t = in.nextInt();
           while (t-- > 0){
               int n = in.nextInt();
               String[] str = new String[n];
               ArrayList<Integer> diff[] = new ArrayList[5];
               for (int i = 0; i < 5; i++) diff[i] = new ArrayList<>();
               for (int i = 0; i < n; i++){
                   str[i] = in.nextToken();
                   int[] cnt = new int[5];
                   for (int j = 0; j < str[i].length(); j++){
                       cnt[str[i].charAt(j) - 'a']++;
                   }
                   for (int j = 0; j < 5; j++){
                       diff[j].add(cnt[j] * 2 - str[i].length());
                   }
               }
               int ans = 0;
               for (int i = 0; i < 5; i++){
                   Collections.sort(diff[i]);
                   Collections.reverse(diff[i]);
                   int cur = 0, x = 0;
                   for (int j = 0; j < diff[i].size(); j++){
                       cur+=diff[i].get(j);
                       if (cur <= 0){
                           break;
                       }
                       x++;
                   }
                   ans = Math.max(ans, x);
               }
               out.println(ans);
           }
        }

        class SEG {
            int n;
            int[] segs;
            public SEG (int[] a){
                this.n= a.length;
                segs= new int[4*this.n];
                build(a,0,0,this.n-1);
            }
            public void build(int[] a, int root, int l, int r){
                if(l==r){
                    segs[root]=a[l];
                    return;
                }
                int m= (l+r)/2;
                build(a,2*root+1,l,m);
                build(a,2*root+2,m+1,r);
                segs[root]= _gcd(segs[2*root+1], segs[2*root+2]);
            }
            public int query(int root, int l, int r, int lq, int rq){
                if(lq<=l && rq>=r) return segs[root];
                if(lq>r || rq<l) return 0;
                int m= (l+r)/2;
                int left= query(2*root+1, l, m, lq, rq);
                int right= query(2*root+2, m+1, r, lq, rq);
                return _gcd(left,right);
            }

        }

    }

    static class Venice{
        public Map<Long,Long> m= new HashMap<>();
        public long base=0;
        public long totalValue=0;
        private int M= 1000000007;

        private long addMod(long a, long b){
            a+=b;
            if(a>=M) a-=M;
            return a;
        }

        public void reset(){
            m= new HashMap<>();
            base=0;
            totalValue=0;
        }
        public void update(long add){
            base= base+ add;
        }
        public void add(long key, long val){
            long newKey= key-base;
            m.put(newKey, addMod(m.getOrDefault(newKey,(long)0),val));
        }
    }



    static class Tuple implements Comparable<Tuple>{
        int x, y, z;
        public Tuple(int x, int y, int z){
            this.x= x;
            this.y= y;
            this.z=z;
        }
        @Override
        public int compareTo(Tuple o){
            return this.x-o.x;
        }
    }

    static class Pair implements Comparable<Pair>{
        public int x;
        public int y;
        public Pair(int x, int y){
            this.x= x;
            this.y= y;
        }

        @Override
        public int compareTo(Pair o) {
            return this.x-o.x;
        }
    }

    // public static class compareL implements Comparator<Tuple>{
    //     @Override
    //     public int compare(Tuple t1, Tuple t2) {
    //         return t2.l - t1.l;
    //     }
    // }

    // fast input reader class;
    static class InputReader {
        BufferedReader br;
        StringTokenizer st;

        public InputReader(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream));
        }

        public String nextToken() {
            while (st == null || !st.hasMoreTokens()) {
                String line = null;
                try {
                    line = br.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                if (line == null) {
                    return null;
                }
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(nextToken());
        }
        public double nextDouble(){
            return Double.parseDouble(nextToken());
        }
        public long nextLong(){
            return Long.parseLong(nextToken());
        }
        public int[] nextIntArr(int n){
            int[] arr= new int[n];
            for(int i=0;i<n;i++) arr[i]= nextInt();
            return arr;
        }
        public long[] nextLongArr(int n){
            long[] arr= new long[n];
            for(int i=0;i<n;i++) arr[i]= nextLong();
            return arr;
        }
        public List<Integer> nextIntList(int n){
            List<Integer> arr= new ArrayList<>();
            for(int i=0;i<n;i++) arr.add(nextInt());
            return arr;
        }
        public int[][] nextIntMatArr(int n, int m){
            int[][] mat= new int[n][m];
            for(int i=0;i<n;i++) for(int j=0;j<m;j++) mat[i][j]= nextInt();
            return mat;
        }
        public List<List<Integer>> nextIntMatList(int n, int m){
            List<List<Integer>> mat= new ArrayList<>();
            for(int i=0;i<n;i++){
                List<Integer> temp= new ArrayList<>();
                for(int j=0;j<m;j++) temp.add(nextInt());
                mat.add(temp);
            }
            return mat;
        }
        public char[] nextStringCharArr(){
            return nextToken().toCharArray();
        }
    }
}