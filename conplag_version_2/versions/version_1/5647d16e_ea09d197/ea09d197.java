//some updates in import stuff
import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.abs;

import java.util.*;
import java.io.*;
import java.math.*;


public class C{

    static int mod = (int) (Math.pow(10, 9)+7);
	static final int dx[] = { -1, 0, 1, 0 }, dy[] = { 0, -1, 0, 1 };
	static final int[] dx8 = { -1, -1, -1, 0, 0, 1, 1, 1 }, dy8 = { -1, 0, 1, -1, 1, -1, 0, 1 };
	static final int[] dx9 = { -1, -1, -1, 0, 0, 0, 1, 1, 1 }, dy9 = { -1, 0, 1, -1, 0, 1, -1, 0, 1 };

	static final double eps = 1e-10;
	static List<Integer> primeNumbers = new ArrayList<>();
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        //code below
        int test = sc.nextInt();
        while(test --> 0){
            int n = sc.nextInt();
            int[][] data = new int[n-1][2];

            Map<Integer, Integer> count = new HashMap<>();
            Graph g = new Graph(n+1);

            for(int i= 0; i < n-1; i++){
                int x = sc.nextInt();
                int y = sc.nextInt();

                data[i][0] = x;
                data[i][1] = y;

                g.addEdge(x, y);
            
                count.putIfAbsent(x, 0);
                count.put(x, count.get(x)+1);

                count.putIfAbsent(y, 0);
                count.put(y, count.get(y)+1);
            }

            //we will count 
            int one = 0;
            int two = 0;

            boolean flag = true;
            int start = 0;
            for(int i : count.keySet()){
                if(count.get(i) == 1){  
                    start = i;
                    one++;
                }else if(count.get(i) == 2){
                    two++;
                }else{
                    flag = false;
                    break;
                }
            }

            if(one != 2){
                flag = false;
            }

            if(!flag){
                out.println(-1);
                continue;
            }

            //now we know this question is solvable for sure
            //we do something really cool
            Map<Integer, ArrayList<Pair>> fuck = new HashMap<>();
            g.addData(start, fuck);
            
            for(int i = 0; i < n-1; i++){
                int x = data[i][0];
                int y = data[i][1];

                //search for the answer 
                ArrayList<Pair> temp = fuck.get(x);
                for(Pair curr : temp){
                    if(curr.a == y){
                        out.print(curr.b + " ");
                        break;
                    }
                }
            }
            
            out.println();
        }


        out.close();
    }

    //Updation Required
    //Fenwick Tree (customisable)
    //Segment Tree (customisable)

    //-----CURRENTLY PRESENT-------//
    //Graph
    //DSU
    //powerMODe
    //power
    //Segment Tree (work on this one) 
    //Prime Sieve
    //Count Divisors
    //Next Permutation 
    //Get NCR 
    //isVowel
    //Sort (int)
    //Sort (long)
    //Binomial Coefficient
    //Pair
    //Triplet
    //lcm (int & long)
    //gcd (int & long)
    //gcd (for binomial coefficient)
    //swap (int & char)
    //reverse

    //Fast input and output 

    //-------------------------------------------------------------------
    //-------------------------------------------------------------------
    //-------------------------------------------------------------------
    //-------------------------------------------------------------------
    //-------------------------------------------------------------------

    //GRAPH (basic structure)
    public static class Graph{
        public int V;
        public ArrayList<ArrayList<Integer>> edges;

        //2 -> [0,1,2] (current)
        Graph(int V){
            this.V  = V;
            edges = new ArrayList<>(V+1);
            for(int i= 0; i <= V; i++){
                edges.add(new ArrayList<>());
            }
        }

        public void addEdge(int from , int to){
            edges.get(from).add(to);
            edges.get(to).add(from);
        }

        public void addData(int start, Map<Integer, ArrayList<Pair>> fuck){
            //we will add stuff here
            int curr = start;
            int[] visited = new int[V+1];
            visited[curr] = 1;

            int index = 0;
            while(true){
                int make = 0;
                boolean last = true;
                for(int edge : edges.get(curr)){
                    if(visited[edge] == 1){
                        continue;
                    }else{
                        make = edge; 
                        last = false;
                        break;
                    }
                }

                if(last){
                    break;
                }

                //now we have found make, we make and add it in map
                fuck.putIfAbsent(curr, new ArrayList<>());
                fuck.putIfAbsent(make, new ArrayList<>());

                fuck.get(curr).add(new Pair(make, index %2 == 0 ? 2 : 3));
                fuck.get(make).add(new Pair(curr, index %2 == 0 ? 2 : 3));

                visited[make] = 1;
                curr = make;
                index++;
            }
        }
    }

    //DSU (path and rank optimised)
    public static class DisjointUnionSets {
        int[] rank, parent;
        int n;
      
        public DisjointUnionSets(int n)
        {
            rank = new int[n];
            parent = new int[n];
            Arrays.fill(rank, 1);
            Arrays.fill(parent,-1);
            this.n = n;
        }
      
        public int find(int curr){
            if(parent[curr] == -1)
                return curr;
 
            //path compression optimisation
            return parent[curr] = find(parent[curr]);
        }
 
        public void union(int a, int b){
            int s1 = find(a);
            int s2 = find(b);
 
            if(s1 != s2){
                if(rank[s1] < rank[s2]){
                    parent[s1] = s2;
                    rank[s2] += rank[s1];
                }else{
                    parent[s2] = s1;
                    rank[s1] += rank[s2];
                }
            }
        }
    }

    //with mod
    public static long powerMOD(long x, long y)
    {
        long res = 1L;    
        while (y > 0)
        {
            // If y is odd, multiply x with result
            if ((y & 1) != 0){
                x %= mod;
                res %= mod;
                res = (res * x)%mod;
            }
            // y must be even now
            y = y >> 1; // y = y/2
            x%= mod;
            x = (x * x)%mod;  // Change x to x^2
        }
        return res%mod;
    }

    //without mod
    public static long power(long x, long y)
    {
        long res = 1L;     
        while (y > 0)
        {
            // If y is odd, multiply x with result
            if ((y & 1) != 0){
                res = (res * x);
            }
            // y must be even now
            y = y >> 1; // y = y/
            x = (x * x);
        }
        return res;
    }

    public static class segmentTree{

        public long[] arr;
        public long[] tree;
        public long[] lazy;

        segmentTree(long[] array){
            int n = array.length;
            arr = new long[n];
            for(int i= 0; i < n; i++) arr[i] = array[i];
            tree = new long[4*n + 1];
            lazy = new long[4*n + 1];
        }

        public  void build(int[]arr, int s, int e, int[] tree, int index){

            if(s == e){
                tree[index] = arr[s];
                return;
            }
    
            //otherwise divide in two parts and fill both sides simply
            int mid = (s+e)/2;
            build(arr, s, mid, tree, 2*index);
            build(arr, mid+1, e, tree, 2*index+1);
    
            //who will build the current position dude
            tree[index] = Math.min(tree[2*index], tree[2*index+1]);
        }
    
        public  int query(int sr, int er, int sc, int ec, int index, int[] tree){
            
            if(lazy[index] != 0){
                tree[index] += lazy[index];
    
                if(sc != ec){
                    lazy[2*index+1] += lazy[index];
                    lazy[2*index] += lazy[index];
                }
    
                lazy[index] = 0;
            }
            
            //no overlap
            if(sr > ec || sc > er) return Integer.MAX_VALUE;
    
            //found the index baby
            if(sr <= sc && ec <= er) return tree[index];
    
            //finding the index on both sides hehehehhe
            int mid = (sc + ec)/2;
            int left = query(sr, er, sc, mid, 2*index, tree);
            int right = query(sr, er, mid+1, ec, 2*index + 1, tree);
    
            return Integer.min(left, right);
        }
    
        //now we will do point update implementation
        //it should be simple then we expected for sure
        public  void update(int index, int indexr, int increment, int[] tree, int s, int e){
    
            if(lazy[index] != 0){
                tree[index] += lazy[index];
    
                if(s != e){
                    lazy[2*index+1] = lazy[index];
                    lazy[2*index] = lazy[index];
                }
                
                lazy[index] = 0;
            }
    
            //no overlap
            if(indexr < s || indexr > e) return;
    
            //found the required index
            if(s == e){
                tree[index] += increment;
                return;
            } 
    
            //search for the index on both sides
            int mid = (s+e)/2;
            update(2*index, indexr, increment, tree, s, mid);
            update(2*index+1, indexr, increment, tree, mid+1, e);
    
            //now update the current range simply
            tree[index] = Math.min(tree[2*index+1], tree[2*index]);
        }
    
        public  void rangeUpdate(int[] tree , int index, int s, int e, int sr, int er, int increment){
    
            //if not at all in the same range
            if(e < sr || er < s) return;
    
            //complete then also move forward
            if(s == e){
                tree[index] += increment;
                return;
            }
    
            //otherwise move in both subparts
            int mid = (s+e)/2;
            rangeUpdate(tree, 2*index, s, mid, sr, er, increment);
            rangeUpdate(tree, 2*index + 1, mid+1, e, sr, er, increment);
    
            //update current range too na
            //i always forget this step for some reasons hehehe, idiot
            tree[index] = Math.min(tree[2*index], tree[2*index + 1]);
        }
        
        public  void rangeUpdateLazy(int[] tree, int index, int s, int e, int sr, int er, int increment){
            
            //update lazy values
            //resolve lazy value before going down
            if(lazy[index] != 0){
                tree[index] += lazy[index];
    
                if(s != e){
                    lazy[2*index+1] += lazy[index];
                    lazy[2*index] += lazy[index];
                }
    
                lazy[index] = 0;
            }
    
            //no overlap case
            if(sr > e || s > er) return;
    
            //complete overlap
            if(sr <= s && er >= e){
                tree[index] += increment;
    
                if(s != e){
                    lazy[2*index+1] += increment;
                    lazy[2*index] += increment;
                }
                return;
            }
    
            //otherwise go on both left and right side and do your shit
            int mid = (s + e)/2;
            rangeUpdateLazy(tree, 2*index, s, mid, sr, er, increment);
            rangeUpdateLazy(tree, 2*index + 1, mid+1, e, sr, er, increment);
    
            tree[index] = Math.min(tree[2*index+1], tree[2*index]);
            return;
    
        }
    
    }

    //prime sieve
    public static void primeSieve(int n){
        BitSet bitset = new BitSet(n+1);
        for(long i = 0; i < n ; i++){
            if (i == 0 || i == 1) {
                bitset.set((int) i);
                continue;
            }
            if(bitset.get((int) i)) continue;
            primeNumbers.add((int)i);
            for(long j = i; j <= n ; j+= i)
                bitset.set((int)j);
        }
    }

    //number of divisors
    public static int countDivisors(long number){
        if(number == 1) return 1;
        List<Integer> primeFactors = new ArrayList<>();
        int index = 0;
        long curr = primeNumbers.get(index);
        while(curr * curr <= number){
            while(number % curr == 0){
                number = number/curr;
                primeFactors.add((int) curr);
            }    
            index++;
            curr = primeNumbers.get(index);
        }

        if(number != 1) primeFactors.add((int) number);
        int current = primeFactors.get(0);
        int totalDivisors = 1;
        int currentCount = 2;
        for (int i = 1; i < primeFactors.size(); i++) {
            if (primeFactors.get(i) == current) {
                currentCount++;
            } else {
                totalDivisors *= currentCount;
                currentCount = 2;
                current = primeFactors.get(i);
            }
        }
        totalDivisors *= currentCount;
        return totalDivisors;
    }

    //now adding next permutation function to java hehe
    public static boolean next_permutation(int[] p) {
        for (int a = p.length - 2; a >= 0; --a)
          if (p[a] < p[a + 1])
            for (int b = p.length - 1;; --b)
              if (p[b] > p[a]) {
                int t = p[a];
                p[a] = p[b];
                p[b] = t;
                for (++a, b = p.length - 1; a < b; ++a, --b) {
                  t = p[a];
                  p[a] = p[b];
                  p[b] = t;
                }
                return true;
              }
        return false;
    }

    //finding the value of NCR in O(RlogN) time and O(1) space
    public static long getNcR(int n, int r)
    {
        long p = 1, k = 1;
        if (n - r < r) r = n - r;

        if (r != 0) {
            while (r > 0) {
                p *= n;
                k *= r;
                long m = __gcd(p, k);
                p /= m;
                k /= m;
                n--;
                r--;
            }
        }
        else {
            p = 1;
        }
        return p;
    }

    //is vowel function 
    public static boolean isVowel(char c)
    {
        return (c=='a' || c=='A' || c=='e' || c=='E' || c=='i' || c=='I' || c=='o' || c=='O' ||     c=='u' || c=='U');
    }   

    //to sort the array with better method
	public static void sort(int[] a) {
		ArrayList<Integer> l=new ArrayList<>();
		for (int i:a) l.add(i);
		Collections.sort(l);
		for (int i=0; i<a.length; i++) a[i]=l.get(i);
	}

    //sort long
    public static void sort(long[] a) {
		ArrayList<Long> l=new ArrayList<>();
		for (long i:a) l.add(i);
		Collections.sort(l);
		for (int i=0; i<a.length; i++) a[i]=l.get(i);
	}
	
    //for calculating binomialCoeff
    public static int binomialCoeff(int n, int k)
    {
        int C[] = new int[k + 1];
        // nC0 is 1
        C[0] = 1;
        for (int i = 1; i <= n; i++) {
            // Compute next row of pascal
            // triangle using the previous row
            for (int j = Math.min(i, k); j > 0; j--)
                C[j] = C[j] + C[j - 1];
        }
        return C[k];
    }

    //Pair with int int 
    public static class Pair{
        public int a;
        public int b;

        Pair(int a , int b){
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString(){
            return a + " -> " + b; 
        }
    }

    //Triplet with int int int
    public static class Triplet{

        public int a;
        public int b;
        public int c;

        Triplet(int a , int b, int c){
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public String toString(){
            return a + " -> " + b; 
        }
    }

    //Shortcut function
    public static long lcm(long a , long b){
        return a * (b/gcd(a,b));
    }

    //let's make one for calculating lcm basically
    public static int lcm(int a , int b){
        return (a * b)/gcd(a,b);
    }

    //int version for gcd
    public static int gcd(int a, int b){
        if(b == 0)
            return a;
            
        return gcd(b , a%b);
    }

    //long version for gcd
    public static long gcd(long a, long b){
        if(b == 0)
            return a;

        return gcd(b , a%b);
    }

     //for ncr calculator(ignore this code)
     public static long __gcd(long n1, long n2)
     {
         long gcd = 1;
         for (int i = 1; i <= n1 && i <= n2; ++i) {
             // Checks if i is factor of both integers
             if (n1 % i == 0 && n2 % i == 0) {
                 gcd = i;
             }
         }
         return gcd;
     }

    //swapping two elements in an array
    public static void swap(int[] arr, int left , int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    //for char array
    public static void swap(char[] arr, int left , int right){
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    //reversing an array
    public static void reverse(int[] arr){
        int left = 0;
        int right = arr.length-1;

        while(left <= right){
            swap(arr, left,right);
            left++;
            right--;
        }
    }


    public static long expo(long a, long b, long mod) {
        long res = 1; 
        while (b > 0) {
            if ((b & 1) == 1L) res = (res * a) % mod;  //think about this one for a second
            a = (a * a) % mod;
            b = b >> 1;
        } 
        return res;
    }

    //SOME EXTRA DOPE FUNCTIONS 
    public static long mminvprime(long a, long b) {
        return expo(a, b - 2, b);
    }

    public static long mod_add(long a, long b, long m) {
        a = a % m;
        b = b % m;
        return (((a + b) % m) + m) % m;
    }

    public static long mod_sub(long a, long b, long m) {
        a = a % m; 
        b = b % m; 
        return (((a - b) % m) + m) % m;
    }
   
    public static long mod_mul(long a, long b, long m) {
        a = a % m;
        b = b % m;
        return (((a * b) % m) + m) % m;
    }

    public static long mod_div(long a, long b, long m) {
        a = a % m;
        b = b % m;
        return (mod_mul(a, mminvprime(b, m), m) + m) % m;
    }

    //O(n) every single time remember that
    public static long nCr(long N, long K , long mod){
        long upper = 1L;
        long lower = 1L;
        long lowerr = 1L;

        for(long i = 1; i <= N; i++){
            upper = mod_mul(upper, i, mod);
        }

        for(long i = 1; i <= K; i++){
            lower = mod_mul(lower, i, mod);
        }

        for(long i = 1; i <= (N - K); i++){
            lowerr = mod_mul(lowerr, i, mod);
        }

        // out.println(upper + " " + lower + " " + lowerr);
        long answer = mod_mul(lower, lowerr, mod);
        answer = mod_div(upper, answer, mod);

        return answer;
    }

    // ll *fact = new ll[2 * n + 1];
	// ll *ifact = new ll[2 * n + 1];
	// fact[0] = 1;
	// ifact[0] = 1;
	// for (ll i = 1; i <= 2 * n; i++)
	// {
	// 	fact[i] = mod_mul(fact[i - 1], i, MOD1);
	// 	ifact[i] = mminvprime(fact[i], MOD1);
	// }
    //ifact is basically inverse factorial in here!!!!!(imp)
    public static long combination(long n, long r, long m, long[] fact, long[] ifact) {
        long val1 = fact[(int)n];
        long val2 = ifact[(int)(n - r)];
        long val3 = ifact[(int)r];
        return (((val1 * val2) % m) * val3) % m;
    }

  

     
    //-----------PrintWriter for faster output---------------------------------
    public static PrintWriter out;
      
    //-----------MyScanner class for faster input----------
    public static class MyScanner {
      BufferedReader br;
      StringTokenizer st;
 
        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
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
    
        String nextLine(){
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

    }
   //--------------------------------------------------------
}