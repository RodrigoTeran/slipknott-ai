import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

//import static com.sun.tools.javac.jvm.ByteCodes.swap;




public class fastTemp {


    static FastScanner fs = null;

    static int bit[][];
    static int c1;
    static int c2;
    public static void main(String[] args) {
        fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
           int p[] = new int[n];
           Arrays.fill(p,-1);
           for(int i=0;i<n;i++){
               if(p[i]!=-1){
                   continue;
               }
               System.out.println("? "+(i+1));
               int ans = (i+1);
               int x = fs.nextInt();
               while(p[x-1]==-1){
                   System.out.println("? "+(i+1));
                   int last = fs.nextInt();
                   p[x-1] = last;
                   x = last;
               }

           }
            System.out.print("! ");
           for(int i=0;i<n;i++){
               System.out.print(p[i]+" ");
           }

            System.out.flush();

        }
    }

    public static boolean binary (int l,int h,long k ){

        while(l<=h){
            int m = (l+h)/2;
            if(m*m==k){
                return true;
            }else if(m*m<k){
                l = m+1;
            }else{
                h = m-1;
            }

        }
        return false;
    }
    public static void solve1(int i,int c1){
        for(int j=0;j < bit.length;j++){
            if(j==c1){
                bit[j][i] = 1;
            }else{
                bit[j][i] = 0;
            }
        }

    }

    public static void solve30(int i,int c2){
        for(int j=0;j< bit.length;j++){
//            if(j>=c2 || j>=bit.length-2){
//                bit[j][i] = 1;
//            }else{
            bit[j][i] = 1;

            // }

        }}

    public static void solve0(int i,int c2){
        int val = bit.length/18;

        for(int j=0;j< bit.length;j++){
             if(j==c2 && j<bit.length-1){
                 bit[j][i] = 1;
                 bit[j+1][i] = 1;
                 j += 1;
             }else{
                 bit[j][i] = 0;
             }

        }}

    public static void union(int a,int b,int rank[],int [] p){
        int x = get(a,rank,p);
        int y = get(b,rank,p);

        if(rank[x]==rank[y]){
            rank[x]++;
        }

        if(rank[x]>rank[y]){
            p[y] = x;
        }else{
            p[x] = y;
        }
    }

    public static int get(int a,int [] rank,int []p){
        return p[a] = (p[a]==a)? a : get(p[a],rank,p);
    }

    public static long[] sort(long arr[]) {
        List<Long> list = new ArrayList<>();
        for(long i:arr)
            list.add(i);
        Collections.sort(list);
        for(int i = 0;i<list.size();i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    static class p {
        int id;
        int id1;
        p(int id,int id1){
            this.id=id;
            this.id1=id1;
        }



    }

    static long power(long x, long y, long p)
    {

        // Initialize result
        long res = 1;

        // Update x if it is more than or
        // equal to p
        x = x % p;

        while (y > 0) {

            // If y is odd, multiply x
            // with result
            if (y % 2 == 1)
                res = (res * x) % p;

            // y must be even now
            y = y >> 1; // y = y/2
            x = (x * x) % p;
        }

        return res;
    }

    // Returns n^(-1) mod p
    static long modInverse(long n, long p)
    {
        return power(n, p - 2, p);
    }

    // Returns nCr % p using Fermat's
    // little theorem.

    static long nCrModPFermat(long n, long r, long p)
    {

        if (n<r)
            return 0;
        // Base case
        if (r == 0)
            return 1;

        // Fill factorial array so that we
        // can find all factorial of r, n
        // and n-r
        long[] fac = new long[(int)n + 1];
        fac[0] = 1;

        for (int i = 1; i <= n; i++)
            fac[i] = fac[i - 1] * i % p;

        return (fac[(int)n] * modInverse(fac[(int)r], p) % p * modInverse(fac[(int)n - (int)r], p) % p) % p;
    }


//public static int dijkstra(int src , int dist[] ){
//
//PriorityQueue<Pair> q = new PriorityQueue<>();
//q.add(new Pair(1,0));
//
//while(q.size()>0){
//
//    Pair rem = q.remove();
//    for(Pair x:graph[rem.y]){
//        if(dist[x.y]>dist[rem.y]+x.wt){
//            dist[x.y] = dist[rem.y] + x.wt;
//            q.add(new Pair(x.y,dist[x.y]));
//        }
//    }
//
//}
//
//return dist[dist.length-1];
//
//}
    // T --> O(n) && S--> O(d)




    public static int lower(long arr[], long key) {
        int l = 0, r = arr.length-1;
        long ans = -1;
        while(l<=r) {
            int mid = l +(r-l)/2;
            if(arr[mid]<=key) {
                ans = arr[mid];
                l = mid+1;
            }
            else {
                r = mid-1;
            }
        }
        return l;
    }

    public static long upper(long arr[], long key) {
        int l = 0, r = arr.length-1;
        long ans = -1;
        while(l<=r) {
            int mid = l +(r-l)/2;
            if(arr[mid] >= key) {
                ans = arr[mid];
                r = mid-1;
            }
            else {
                l = mid+1;
            }
        }
        return ans;
    }



    public static class String1 implements Comparable<String1>{
        String str;
        int id;
        String1(String str , int id){
            this.str = str;
            this.id = id;
        }
        public  int compareTo(String1 o){
            int i=0;
            while(i<str.length() && str.charAt(i)==o.str.charAt(i)){
                i++;
            }
            if(i<str.length()){
                if(i%2==1){
                    return o.str.compareTo(str);   // descending order
                }else{
                    return str.compareTo(o.str);  // ascending order
                }
            }
            return str.compareTo(o.str);
        }
    }


    static void sort(int[] a) {
        ArrayList<Integer> l=new ArrayList<>();
        for (int i:a) l.add(i);
        Collections.sort(l);
        for (int i=0; i<a.length; i++) a[i]=l.get(i);
    }
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
    // ------------------------------------------swap----------------------------------------------------------------------

    static void swap(int arr[],int i,int j)
    {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }


    //-------------------------------------------seiveOfEratosthenes----------------------------------------------------


    static boolean prime[];
    static void sieveOfEratosthenes(int n)
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

        // Print all prime numbers
//        for (int i = 2; i <= n; i++)
//        {
//            if (prime[i] == true)
//                System.out.print(i + " ");
//        }
    }



    //------------------------------------------- power------------------------------------------------------------------



    public static long power(int a , int b) {
        if (b == 0) {
            return 1;
        } else if (b == 1) {
            return a;

        } else {

            long R = power(a, b / 2);
            if (b % 2 != 0) {


                return (((power(a, b / 2))) * a * ((power(a, b / 2))));
            } else {
                return ((power(a, b / 2))) * ((power(a, b / 2)));
            }
        }

    }
    public static int log2(int x) {
        return (int) (Math.log(x) / Math.log(2));
    }

    //---------------------------------------EXTENDED EUCLID ALGO--------------------------------------------------------
//    public static class Pair{
//        int x;
//        int y;
//        public Pair(int x,int y){
//            this.x = x;
//            this.y = y ;
//        }
//    }

//    public static Pair Euclid(int a,int b){
//
//        if(b==0){
//            return new Pair(1,0);  // answer of x and y
//        }
//
//        Pair dash = Euclid(b,a%b);
//
//        return new Pair(dash.y , dash.x - (a/b)*dash.y);
//
//
//    }
//--------------------------------GCD------------------GCD-----------GCD--------------------------------------------

    public static int gcd(int a,int b){
        if(b==0){
            return a;
        }

        return gcd(b,a%b);
    }
    public static void BFS(ArrayList<Integer>[] graph) {


    }

// This is an extension of method 2. Instead of moving one by one, divide the array in different sets
//where number of sets is equal to GCD of n and d and move the elements within sets.
//If GCD is 1 as is for the above example array (n = 7 and d =2), then elements will be moved within one set only, we just start with temp = arr[0] and keep moving arr[I+d] to arr[I] and finally store temp at the right place.
//Here is an example for n =12 and d = 3. GCD is 3 and


//     void leftRotate(int arr[], int d, int n)
//     {
//         /* To handle if d >= n */
//         d = d % n;
//         int i, j, k, temp;
//         int g_c_d = gcd(d, n);
//         for (i = 0; i < g_c_d; i++) {
//             /* move i-th values of blocks */
//             temp = arr[i];
//             j = i;
//             while (true) {
//                 k = j + d;
//                 if (k >= n)
//                     k = k - n;
//                 if (k == i)
//                     break;
//                 arr[j] = arr[k];
//                 j = k;
//             }
//             arr[j] = temp;
//         }
//     }


}
// Fenwick / BinaryIndexed  Tree  USE IT - FenwickTree ft1=new FenwickTree(n);
