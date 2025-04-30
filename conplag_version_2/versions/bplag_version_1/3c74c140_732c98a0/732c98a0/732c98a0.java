import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Math.*;
import static java.lang.System.out;
import static java.lang.Long.MAX_VALUE;

public final class Main {

    FastReader in;
    StringBuffer sb;
    public static void main(String[] args) {
        new Main().run();
    }

    void run(){
        in= new FastReader();
        start();
    }

    void start(){
        sb= new StringBuffer();
        for(int t=in.nextInt();t>0;t--)
            solve();
        out.print(sb);
    }

    void solve(){
        int n = in.nextInt();
        int[][] mat = new int[n][5];
        for(int i = 0; i<n; i++) {
            char[] pp =in.nextLine().toCharArray();
            for(char c : pp) {
                mat[i][c-'a']++;
            }
            int[] p = new int[5];
            int tt = 0;
            for(int j : mat[i])
                tt +=j;
            for(int j = 0; j<5; j++) {
                mat[i][j]=2*mat[i][j]-tt;
            }
        }
        int ans  = 0;
        for(int i = 0; i<5; i++) {
            int g = check(i,mat, n);
            ans = Math.max(g,ans);
        }
        sb.append(ans).append("\n");
    }

    int check(int i, int[][] mat, int n) {
        ArrayList<Integer> x = new ArrayList<>();
        for(int j = 0; j<n; j++) {
            x.add(mat[j][i]);
        }
        Collections.sort(x);
        int s = 0;
        int cnt = 0;
        int l = n-1;
        while(l>=0) {
            int u = x.get(l);
            if(s+u>0) {
                s+=u;
                cnt++;
            }
            else
                break;
            l--;
        }
        return cnt;
    }

    long power(long x, long y, long p) {
        long res = 1;
        x = x % p;
        while (y > 0) {
            if (y % 2 == 1)
                res = (res * x) % p;

            y = y >> 1;
            x = (x * x) % p;
        }
        return res;
    }

    int upper_bound(long[] arr, int key) {
        int i=0, j=arr.length-1;
        if (arr[j]<=key) return j+1;
        if(arr[i]>key) return i;
        while (i<j){
            int mid= (i+j)/2;
            if(arr[mid]<=key){
                i= mid+1;
            }else{
                j=mid;
            }
        }
        return i;
    }

    void sort(long[] A){
        int n = A.length;
        Random rnd = new Random();
        for(int i=0; i<n; ++i){
            long tmp = A[i];
            int randomPos = i + rnd.nextInt(n-i);
            A[i] = A[randomPos];
            A[randomPos] = tmp;
        }
        Arrays.sort(A);
    }

    long[] longArr(int n){
        long[] res= new long[n];
        for(int i=0;i<n;i++){
            res[i]= in.nextLong();
        }
        return res;
    }

    // sieve of eratosthenes code for precomputing whether numbers are prime or not up to MAX_VALUE
    long MAX= MAX_VALUE;
    int[] precomp= new int[(int) (MAX+1)];
    void sieve(){
        long n= MAX;
        boolean[] prime = new boolean[(int) (n+1)];
        for(int i=0;i<=n;i++)
            prime[i] = true;

        for(long p = 2; p*p <=n; p++)
        {
            // If prime[p] is not changed, then it is a prime
            if(prime[(int) p])
            {
                // Update all multiples of p
                for(long i = p*p; i <= n; i += p)
                    prime[(int) i] = false;
            }
        }

        // Print all prime numbers
        for(long i = 2; i <= n; i++)
        {
            if(prime[(int) i])
                precomp[(int) i]= 1;
        }
    }

    boolean isDigitSumPalindrome(long N) {
        // code here
        long sum= sumOfDigits(String.valueOf(N));
        long rev=0;
        long org= sum;
        while (sum!=0){
            long d= sum%10;
            rev = rev*10 +d;
            sum /= 10;
        }
        return org == rev;
    }

    long sumOfDigits(String n){
        long sum= 0;
        for (char c: n.toCharArray()){
            sum += Integer.parseInt(String.valueOf(c));
        }
        return sum;
    }

    long[] revArray(long[] arr) {
        int n= arr.length;
        int i=0, j=n-1;
        while (i<j){
            long temp= arr[i];
            arr[i]= arr[j];
            arr[j]= temp;
            i++;
            j--;
        }
        return arr;
    }

    long gcd(long a, long b){
        if (b==0)
            return a;
        return gcd(b, a%b);
    }
    long lcm(long a,long b){
        return (a*b)/gcd(a,b);
    }

    static class Pair{
        long first;
        long second;
        Pair(long x,long y){
            this.first=x;
            this.second=y;
        }
    }

    static class Compare {
        static void compare(ArrayList<Pair> arr, long n) {
            arr.sort(new Comparator<Pair>() {
                @Override
                public int compare(Pair p1, Pair p2) {
                    return (int) (p2.first - p1.first);
                }
            });
        }
    }

    public static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br=new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while (st==null || !st.hasMoreElements()){
                try{
                    st=new StringTokenizer(br.readLine());
                }catch (Exception e){
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
        float nextFloat(){
            return Float.parseFloat(next());
        }
        String nextLine(){
            String str="";
            try{
                str=br.readLine();
            }catch (Exception e){
                e.printStackTrace();
            }
            return str;
        }
    }
}