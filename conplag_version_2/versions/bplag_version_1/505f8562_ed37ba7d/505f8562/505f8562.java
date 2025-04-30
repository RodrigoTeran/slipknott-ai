import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.System.out;
import static java.lang.Long.MAX_VALUE;

public final class Main{

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

    long MOD= 1000000007;
    void solve(){
        int n= in.nextInt();
        int k= in.nextInt();
        long[] a=longArr(k);
        long[] t=longArr(k);
        long[] ans= new long[n];
        for(int i=0;i<n;i++){
            ans[i]= Integer.MAX_VALUE;
        }
        for(int i=0;i<k;i++){
            ans[(int) (a[i]-1)]= t[i];
        }
        long[] left= new long[n];
        left[0]= ans[0];
        for(int i=1;i<n;i++) {
            left[i]= min(left[i-1]+1,ans[i]);
        }
        long[] right= new long[n];
        right[n-1]= ans[n-1];
        for(int i=n-2;i>=0;i--) {
            right[i]= min(right[i+1]+1,ans[i]);
        }
        for(int i=0;i<n;i++)
            sb.append(min(left[i], right[i])).append(" ");

        sb.append("\n");
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
                    return (int) (p1.first - p2.first);
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