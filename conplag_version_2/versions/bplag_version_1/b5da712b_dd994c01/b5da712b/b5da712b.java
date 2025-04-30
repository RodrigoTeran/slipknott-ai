
import java.io.*;
import java.util.*;


public class codeforces2 {
    static List<Integer> primes;
    static final long X = 10000000000L;
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        PrintWriter pw = new PrintWriter(System.out);
//        primes = sieveOfEratosthenes(100_000);
//        System.out.println(primes.toString());
        int tc = sc.ni();
//        int tc = 1;
        for (int rep = 0; rep < tc; rep++) {
            int N = sc.ni();
            int[][] edges= new int[N-1][];
            for (int i = 0; i < edges.length; i++) {
                edges[i] = new int[] {sc.ni() - 1, sc.ni() - 1};
            }
            pw.println(solve(edges, N));
            

        }
        pw.close();
    }
    public static String solve(int[][] edges, int N) {
        Map<Integer, Set<Integer>> graph = new HashMap();
        Map<Long, Integer> hash = new HashMap();
        int idx = 0;
        for (int[] e : edges) {
            graph.putIfAbsent(e[0], new HashSet());
            graph.get(e[0]).add(e[1]);
            graph.putIfAbsent(e[1], new HashSet());
            graph.get(e[1]).add(e[0]);
            
            
            
            hash.put(getHash(e[0], e[1]), idx);
            idx++;
        }
        
        Queue<int[]> q = new LinkedList();
        //node, previous weight
        int[] initial = new int[2];
        for (int node : graph.keySet()) {
            int len = graph.get(node).size();
            if (len > 2) return "-1";
            if (len == 2) initial = new int[] {node, -1};
        }
        q.offer(initial);
        
        int rotate = 0;
//        System.out.println(graph.toString());
           
        int[] ret = new int[edges.length];
        boolean[] vis = new boolean[N];
        vis[initial[0]] = true;
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int node = temp[0];
            int old_color = temp[1];
            
            if (old_color == -1) {
                int[] arr = new int[] {2, 11};
                int p = 0;
                for (int neighbor : graph.get(node)) {
                    ret[hash.get( getHash(node,neighbor) )] = arr[p];
                    q.offer(new int[] {neighbor, arr[p]});
                    p++;
//                    System.out.println();
//                    System.out.println(neighbor + " " + graph.toString());
//                    System.out.println(Arrays.deepToString(edges));
                    vis[neighbor] = true;
                    
                }
                
            }
            else if (old_color == 2) {
                
                int amt = 0;
                for (int neighbor : graph.get(node)) {
                    if (vis[neighbor] == true) continue;
                    vis[neighbor] = true;
                    
                    ret[hash.get( getHash(node,neighbor) )] = 11;
                    q.offer(new int[] {neighbor, 11});
                    
                    amt++;
                }
                if (amt >= 2) return "-1";
            }
            else {
                
                int amt = 0;
                for (int neighbor : graph.get(node)) {
                    if (vis[neighbor] == true) continue;
                    vis[neighbor] = true;
                    
                    ret[hash.get( getHash(node,neighbor) )] = 2;
                    q.offer(new int[] {neighbor, 2});
                    
                    amt++;
                }
                if (amt >= 2) return "-1";
            
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int x : ret) sb.append(x + " ");
        return sb.substring(0, sb.length() -1);
        
    }
    static long getHash(int u, int v) {
        
        if (u > v) {
            int temp = u;
            u = v;
            v = temp;
        }
        return u*X+v;
    }
        
     
   
    static boolean isSet(long n, int bit) {
        if (((1 << bit) & n) > 0) return true;
        return false;
    }
    static long nextPrime(long input){
        long counter;
        input++;
        while(true){
          int l = (int) Math.sqrt(input);
          counter = 0;
          for(long i = 2; i <= l; i ++){
            if(input % i == 0)  counter++;
          }
          if(counter == 0)
            return input;
          else{
            input++;
            continue;
          }
        }
      }
    public static List<Integer> sieveOfEratosthenes(int n) {
        boolean prime[] = new boolean[n + 1];
        Arrays.fill(prime, true);
        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int i = p * 2; i <= n; i += p) {
                    prime[i] = false;
                }
            }
        }
        List<Integer> primeNumbers = new LinkedList<>();
        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
    }
    public static boolean perfectSquare(long n) {
        long lo = 0;
        long hi = n;
        while (lo < hi) {
            long k = (lo + hi) / 2;
            if (k * k < n)
                lo = k + 1;
            else
                hi = k;
        }
        return (lo * lo == n);
    }
    static Set<Integer> divisors(int n) {
        Set<Integer> set = new HashSet();
        for (int i=1; i<=Math.sqrt(n); i++)
        {
            if (n%i==0)
            {
                // If divisors are equal, print only one
                if (n/i == i)
                    set.add(i);
      
                else {// Otherwise print both
                    set.add(i);
                    set.add(n / i);
                }
            }
        }
        return set;
    }
    static Map<Integer, Integer> primeFactorization(int x) {
        //first divide by 2
        Map<Integer, Integer> map = new HashMap();
        if (x == 0) return map;
        int count = 0;
        while (x % 2 == 0) {
            x /=2;
            count++;
        }
        //insert 2
        if (count > 0) map.put(2, count);
        for (int divisor = 3; divisor * divisor <= x; divisor += 2) {
            int cnt = 0;
            while (x % divisor == 0) {
                x /= divisor;
                cnt++;
            }
            if (cnt > 0) map.put(divisor, cnt);
        }
        if (x > 1) {
            map.put(x, 1);
        }
        return map;
    }
    static boolean isPrime(int n)
    {
 
        // Check if number is less than
        // equal to 1
        if (n <= 1)
            return false;
 
        // Check if number is 2
        else if (n == 2)
            return true;
 
        // Check if n is a multiple of 2
        else if (n % 2 == 0)
            return false;
 
        // If not, then just check the odds
        for (int i = 3; i <= Math.sqrt(n); i += 2) 
        {
            if (n % i == 0)
                return false;
        }
        return true;
    }
    static int gcd(int a, int b)
    {
        if (a == 0)
            return b; 
        return gcd(b % a, a); 
    }
    static long gcd(long a, long b) {
        if (a == 0)
            return b; 
        return gcd(b % a, a); 
    }
     
    // method to return LCM of two numbers
    static int lcm(int a, int b)
    {
        return (a / gcd(a, b)) * b;
    }
    public static void sort(int[] arr) {
        Random rgen = new Random();
        for (int i = 0; i < arr.length; i++) {
            int r = rgen.nextInt(arr.length);
            int temp = arr[i];
            arr[i] = arr[r];
            arr[r] = temp;
        }
        Arrays.sort(arr);
    }
 
    public static void sort(long[] arr) {
        Random rgen = new Random();
        for (int i = 0; i < arr.length; i++) {
            int r = rgen.nextInt(arr.length);
            long temp = arr[i];
            arr[i] = arr[r];
            arr[r] = temp;
        }
        Arrays.sort(arr);
    }
    /* */
    //printing methods
    /* */
    //WOW!
    /* */
    public static void printArr(PrintWriter pw, int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int x : arr) {
            sb.append(x + "");
        }
        sb.setLength(sb.length() - 1);
        pw.println(sb.toString());
    }
    public static void printArr2d(PrintWriter pw, int[][] arr) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : arr) {
            for (int x : row) {
                sb.append(x + " ");
            }
            sb.setLength(sb.length() - 1);
            sb.append("\n");
        }
        sb.setLength(sb.length() - 1);
        pw.println(sb.toString());
    }
}
class FastScanner {
    BufferedReader br;
    StringTokenizer st;

    public FastScanner() {
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
        for (int i = 0; i < N; i++)
            ret[i] = ni();
        return ret;
    }

    long nl() {
        return Long.parseLong(next());
    }

    long[] longArray(int N) {
        long[] ret = new long[N];
        for (int i = 0; i < N; i++)
            ret[i] = nl();
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
class UnionFind {
    int size;
    private int[] id;
    public UnionFind(int size) {
        this.size = size;
        id = new int[size];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }
    public int find(int a) {
        if (id[a] != a) {
            id[a] = find(id[a]);
        }
        return id[a];
    }
    public void union(int a, int b) {
        int r1 = find(a);
        int r2 = find(b);
        if (r1 == r2) return;
        size--;
        id[r1] = r2;
    }
    @Override
    public String toString() {
        return Arrays.toString(id);
    }
}

class isSame {
    private long[] arr;
    TreeMap<Integer, Integer> map = new TreeMap();
    public isSame(long[] in) {
        arr = in;
        int prev = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i-1]) {
                
            }
            else {
                map.put(prev, i-1);
                prev = i;
            }
        }
        map.put(prev, arr.length - 1);
        
        
    }
    public boolean query(int l, int r) {
        Integer lower = map.floorKey(l);
        //should never happen i think
        if (lower == null) return false;
        
        return map.get(lower) >= r;
    }
    @Override
    public String toString() {
        return map.toString();
    }
    
}