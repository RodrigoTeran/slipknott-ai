import java.awt.image.AreaAveragingScaleFilter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF1 {
    public static void main(String[] args) {
        FastScanner sc=new FastScanner();
        int T=sc.nextInt();
//        int T=1;
        for (int tt=0; tt<T; tt++){
            int n = sc.nextInt();
            long k = sc.nextLong();
            int arr[]= sc.readArray(n);
            sort(arr);
            long sum=0L;
            long ans=Integer.MAX_VALUE;
            long min= (long)arr[0];


            for (int i=0; i<n; i++){
                sum+=arr[i];
            }
            if (sum<=k) System.out.println(0);
            else {
                long temp=sum;
                long x=0L;
                long y=0L;
                for (int i=n-1; i>=1; i--){
                    temp=sum;
                    //2x +arr[i]-min
                    y++;
                    x+=arr[i];
                    temp-=x-y*min;
                    if (temp<=k) {
                        ans=Math.min(ans,y);
                        break;
                    }
                    else {
                        long b=(temp-k);
                        if (b%(y+1)==0){
                            b/=(y+1);
                        }
                        else {
                            b/=(y+1);
                            b++;
                        }
                        ans=Math.min(ans, y+b);
                    }



                }
                if (n==1){
                    ans=arr[0]-k;
                }
                ans= Math.min(ans, sum-k);
                System.out.println(ans);
            }




        }
    }
    static long mod =998244353L;
    static long power (long a, long b){
        long res=1;
        while (b>0){
            if ((b&1)== 1){
                res= (res * a % mod)%mod;
            }
            a=(a%mod * a%mod)%mod;
            b=b>>1;
        }
        return res;
    }

    boolean[] sieveOfEratosthenes(int n)
    {

        boolean prime[] = new boolean[n+1];
        for(int i=0;i<=n;i++)
            prime[i] = true;

        for(int p = 2; p*p <=n; p++)
        {
            if(prime[p] == true)
            {
                for(int i = p*p; i <= n; i += p)
                    prime[i] = false;
            }
        }
        return prime;
    }
    static void sort(int[] a) {
        ArrayList<Integer> l=new ArrayList<>();
        for (int i:a) l.add(i);
        Collections.sort(l);
        for (int i=0; i<a.length; i++) a[i]=l.get(i);
    }
    static void sortLong(long[] a) {
        ArrayList<Long> l=new ArrayList<>();
        for (long i:a) l.add(i);
        Collections.sort(l);
        for (int i=0; i<a.length; i++) a[i]=l.get(i);
    }
    static long gcd (long n, long m){
        if (m==0) return n;
        else return gcd(m, n%m);
    }

    static class Pair implements Comparable<Pair>{
        int x,y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
        public int compareTo(Pair o){
            return this.x-o.x;
        }
    }
    static class FastScanner {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer("");
        String next() {
            while (!st.hasMoreTokens())
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
        int[] readArray(int n) {
            int[] a=new int[n];
            for (int i=0; i<n; i++) a[i]=nextInt();
            return a;
        }
        long nextLong() {
            return Long.parseLong(next());
        }
    }
}