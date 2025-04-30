/*****  --->         :)    Vijender  Srivastava      (:       <---       *****/
import java.util.*;
import java.lang.*;
import java.io.*;
public class Main  
{
    static FastReader sc =new FastReader();
    static PrintWriter out=new PrintWriter(System.out);
    static int mod=10000007;
   static StringBuilder sb=new StringBuilder();
    /* start */
       public static void main(String [] args)
    {
            int t = i();
            while(t-->0)
            {
                int n = i();
                int a[] = input(n);
                char c[] = inputC();
                ArrayList<Integer> b = new ArrayList<>();
                ArrayList<Integer> r = new ArrayList<>();
                for(int i=0;i<n;i++)
                {
                    if(c[i]=='R')
                    r.add(a[i]);
                    else 
                    b.add(a[i]);
                }
                Collections.sort(b);
                Collections.sort(r,Collections.reverseOrder());
                boolean is = true;
                int cnt = 1;
                for(int i=0;i<b.size();i++)
                {
                    if(b.get(i)<cnt)
                    {
                        is = false;
                        break;
                    }
                    cnt++;
                }
                for(int i=0;i<r.size();i++)
                {
                    if(r.get(i)>n-i)
                    {
                        is = false;
                        break;
                    }
                }

                out.println(is==true?"YES":"NO");
            }
            out.close();
    }

    
    /* end */
    static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 

        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 

        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 

        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 

        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 

        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 

        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 

    
    static int i() {
        return sc.nextInt();
    }

    static String s() {
        return sc.next();
    }

    static long l() {
        return sc.nextLong();
    }

    static char[] inputC()
    {
        String s = sc.nextLine();
        return s.toCharArray();
    }

    static int[] input(int n) {
        int A[]=new int[n];
           for(int i=0;i<n;i++) {
               A[i]=sc.nextInt();
           }
        return A;
    }

    static long[] inputL(int n) {
        long A[]=new long[n];
           for(int i=0;i<n;i++) {
               A[i]=sc.nextLong();
           }
           return A;
    }

    static long[] putL(long a[]) {
        long A[]=new long[a.length];
           for(int i=0;i<a.length;i++) {
               A[i]=a[i];
           }
           return A;
    }

    static String[] inputS(int n) {
        String A[]=new String[n];
           for(int i=0;i<n;i++) {
               A[i]=sc.next();
           }
           return A;
    }
      
    static int gcd(int a, int b) 
     { 
         if (a == 0) 
             return b; 
         return gcd(b % a, a); 
     } 

     static long gcd(long a, long b) 
     { 
         if (a == 0) 
             return b; 
         return gcd(b % a, a); 
     } 

     
    
     static String reverse(String s) {
        StringBuffer p=new StringBuffer(s);
        p.reverse();
        return p.toString();
     }

     static int min(int a,int b) {
        return Math.min(a, b);
    }
    static int min(int a,int b,int c) {
        return Math.min(a, Math.min(b, c));
    }
    static int min(int a,int b,int c,int d) {
        return Math.min(a, Math.min(b, Math.min(c, d)));
    }

    static int max(int a,int b) {
        return Math.max(a, b);
    }
    static int max(int a,int b,int c) {
        return Math.max(a, Math.max(b, c));
    }
    static int max(int a,int b,int c,int d) {
        return Math.max(a, Math.max(b, Math.max(c, d)));
    }
    static long min(long a,long b) {
        return Math.min(a, b);
    }
    static long min(long a,long b,long c) {
        return Math.min(a, Math.min(b, c));
    }
    static long min(long a,long b,long c,long d) {
        return Math.min(a, Math.min(b, Math.min(c, d)));
    }
    static long max(long a,long b) {
        return Math.max(a, b);
    }
    static long max(long a,long b,long c) {
        return Math.max(a, Math.max(b, c));
    }
    static long max(long a,long b,long c,long d) {
        return Math.max(a, Math.max(b, Math.max(c, d)));
    }

    static long sum(int A[]) {
        long sum=0;
        for(int i : A) {
            sum+=i;
        }
        return sum;
    }

    static long sum(long A[]) {
        long sum=0;
        for(long i : A) {
            sum+=i;
        }
        return sum;
    }

    static void print(int A[]) {
        for(int i : A) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

    static void print(long A[]) {
        for(long i : A) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

    static long mod(long x) {
          return ((x%mod + mod)%mod);
    }

    static long power(long x, long y)
    {

	if(y==0)
		return 1;
	if(x==0)
		return 0;
    long res = 1;
    while (y > 0) {

        if (y % 2 == 1)
            res = (res * x) ;

        y = y >> 1; 
        x = (x * x);
    }

    return res;
    }

    static boolean prime(int n) 
	    { 
	        if (n <= 1) 
	            return false; 
	        if (n <= 3) 
	            return true; 
	        if (n % 2 == 0 || n % 3 == 0) 
	            return false; 
	        double sq=Math.sqrt(n);
	  
	        for (int i = 5; i <= sq; i = i + 6) 
	            if (n % i == 0 || n % (i + 2) == 0) 
	                return false; 
	        return true; 
	    } 

     static boolean prime(long n) 
	    { 
	        if (n <= 1) 
	            return false; 
	        if (n <= 3) 
	            return true; 
	        if (n % 2 == 0 || n % 3 == 0) 
	            return false; 
	        double sq=Math.sqrt(n);
	  
	        for (int i = 5; i <= sq; i = i + 6) 
	            if (n % i == 0 || n % (i + 2) == 0) 
	                return false; 
	        return true; 
	    } 
        //pair class
        private static class Pair implements Comparable<Pair> {
            int first, second;
            public Pair(int f, int s) {
                first = f;
                second = s;
            }
            @Override
            public int compareTo(Pair p) {
                if (first > p.first)
                    return 1;
                else if (first < p.first)
                    return -1;
                else {
                    if (second > p.second)
                        return 1;
                    else if (second < p.second)
                        return -1;
                    else
                        return 0;
                }
            }
     
        }
}