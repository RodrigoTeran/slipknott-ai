import java.util.*;

import java.io.*;
import java.math.*;



public class Main

{ 
	 static FastReader sc=new FastReader(); 
	 static int dp[];
	 static boolean v[];
//	 static int mod=998244353;;
	 static int mod=1000000007;
	 static int max;
	 static int bit[];
	 //static long fact[];
//	 static long A[];
	 static HashMap<Integer,Integer> map;
	 //static StringBuffer sb=new StringBuffer("");
	 //static HashMap<Integer,Integer> map;
	   static PrintWriter out=new PrintWriter(System.out);
	  public static void main(String[] args)
	  {
		 //  StringBuffer sb=new StringBuffer("");
		  int ttt=1;
		       ttt =i();		       
	        outer :while (ttt-- > 0) 
	        {
	        	int n=i();
	        	long A[]=inputL(n);
	        	long B[]=inputL(n);
	        	long C[]=new long[n];
	        	for(int i=0;i<n;i++) {
	        		C[i]=A[i]-B[i]+1;
	        	}
	        	long min=C[n-1];
	        	long ans=0;
	        	long last=A[n-1];
	        	for(int i=n-1;i>=0;i--) {
	        		if(C[i]>min) {
	        			continue;
	        		}
	        		if(A[i]<min) {
	        			long y=last-min+1;
	        			ans+=y*(y+1)/2;
	        			last=A[i];
	        			min=C[i];
	        			continue;
	        		}
	        		
	        		min=C[i];
	        		
	        	}
	        	long y=last-min+1;
    			ans+=y*(y+1)/2;
	        	System.out.println(ans);
	        }
	        //System.out.println(sb.toString());
		     out.close();
	     
	     
	    //CHECK FOR N=1                    //CHECK FOR M=0
        //CHECK FOR N=1                    //CHECK FOR M=0
       	//CHECK FOR N=1
       	
		        
		     
    }
	 
	 
	 
	
	
	  
	 
	 
static class Pair implements Comparable<Pair>
     {
    	 int x;
    	 int y;
    	 int z;
    	 Pair(int x,int y){
    		 this.x=x;
    		 this.y=y;
//    		 this.z=z;
    		 
    	 }
		@Override
		public int compareTo(Pair o) {
			if(this.x>o.x)
				return 1;
			else if(this.x<o.x)
				return -1;
			else {
				if(this.y>o.y)
					return 1;
				else if(this.y<o.y)
					return -1;
				else
					return 0;
			}
		}
		public int hashCode() 
		{ 
			final int temp = 14; 
			int ans = 1; 
			ans =x*31+y*13; 
			return ans; 
		} 
		@Override
		public boolean equals(Object o) 
		{ 
			if (this == o) { 
				return true; 
			} 
			if (o == null) { 
				return false; 
			} 
			if (this.getClass() != o.getClass()) { 
				return false; 
			} 
			Pair other = (Pair)o; 
			if (this.x != other.x || this.y!=other.y) { 
				return false; 
			} 
			return true; 
		} 	
//		
		/* FOR TREE MAP PAIR USE */
		
//		public int compareTo(Pair o) {
// 			if (x > o.x) {
// 				return 1;
// 			}
// 			if (x < o.x) {
// 				return -1;
// 			}
// 			if (y > o.y) {
// 				return 1;
// 			}
// 			if (y < o.y) {
// 				return -1;
// 			}
// 			return 0;
// 		}
		
     }

static int find(int A[],int a) {
	  if(A[a]==a)
		  return a;
	  return A[a]=find(A, A[a]);
}
//static int find(int A[],int a) {
//	  if(A[a]==a)
//		  return a;
//	  return find(A, A[a]);
//}
//FENWICK TREE
static void update(int i, int x){
	for(; i < bit.length; i += (i&-i))
		bit[i] += x;
}

static int sum(int i){
	int ans = 0;
	for(; i > 0; i -= (i&-i))
		ans += bit[i];
	return ans;
}
//END
static void add(int v) {
	if(!map.containsKey(v)) {
		map.put(v, 1);
	}
	else {
		map.put(v, map.get(v)+1);
	}
}
static void remove(int v) {
	if(map.containsKey(v)) {
		map.put(v, map.get(v)-1);
		if(map.get(v)==0)
			map.remove(v);
	}
}
public static int upper(int A[],int k,int si,int ei)
{
	int l=si;
	int u=ei;
	int ans=-1;
	while(l<=u) {
		int mid=(l+u)/2;
		if(A[mid]<=k) {
			ans=mid;
			l=mid+1;
		}
		else {
			u=mid-1;
		}
	}
	return ans;
}
public static int lower(int A[],int k,int si,int ei)
{
	int l=si;
	int u=ei;
	int ans=-1;
	while(l<=u) {
		int mid=(l+u)/2;
		if(A[mid]<=k) {
			l=mid+1;
		}
		else {
			ans=mid;
			u=mid-1;
		}
	}
	return ans;
	
    
}
static int[] copy(int A[]) {
	int B[]=new int[A.length];
	for(int i=0;i<A.length;i++) {
		B[i]=A[i];
	}
	return B;
}
static long[] copy(long A[]) {
	long B[]=new long[A.length];
	for(int i=0;i<A.length;i++) {
		B[i]=A[i];
	}
	return B;
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
static String[] inputS(int n) {
	String A[]=new String[n];
	   for(int i=0;i<n;i++) {
		   A[i]=sc.next();
	   }
	   return A;
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
static void reverse(long A[]) {
	int n=A.length;
	long B[]=new long[n];
	for(int i=0;i<n;i++) {
		B[i]=A[n-i-1];
	}
	for(int i=0;i<n;i++)
		A[i]=B[i];
	
}
static void reverse(int A[]) {
	int n=A.length;
	int B[]=new int[n];
	for(int i=0;i<n;i++) {
		B[i]=A[n-i-1];
	}
	for(int i=0;i<n;i++)
		A[i]=B[i];
	
}
static void input(int A[],int B[]) {
	   for(int i=0;i<A.length;i++) {
		   A[i]=sc.nextInt();
		   B[i]=sc.nextInt();
	   }
}
static int[][] input(int n,int m){
	int A[][]=new int[n][m];
	for(int i=0;i<n;i++) {
		for(int j=0;j<m;j++) {
			A[i][j]=i();
		}
	}
	return A;
}
static char[][] charinput(int n,int m){
	char A[][]=new char[n][m];
	for(int i=0;i<n;i++) {
		String s=s();
		for(int j=0;j<m;j++) {
			A[i][j]=s.charAt(j);
		}
	}
	return A;
}
static int nextPowerOf2(int n)
{
    n--;
    n |= n >> 1;
    n |= n >> 2;
    n |= n >> 4;
    n |= n >> 8;
    n |= n >> 16;
    n++;
     
    return n;
}
static int highestPowerof2(int x)
{
   
    x |= x >> 1;
    x |= x >> 2;
    x |= x >> 4;
    x |= x >> 8;
    x |= x >> 16;
     
    return x ^ (x >> 1); 
 
}
static long highestPowerof2(long x)
{
   
    x |= x >> 1;
    x |= x >> 2;
    x |= x >> 4;
    x |= x >> 8;
    x |= x >> 16;
    return x ^ (x >> 1); 
 
}

static int max(int A[]) {
	int max=Integer.MIN_VALUE;
	for(int i=0;i<A.length;i++) {
		max=Math.max(max, A[i]);
	}
	return max;
}
static int min(int A[]) {
	int min=Integer.MAX_VALUE;
	for(int i=0;i<A.length;i++) {
		min=Math.min(min, A[i]);
	}
	return min;
}
static long max(long A[]) {
	long max=Long.MIN_VALUE;
	for(int i=0;i<A.length;i++) {
		max=Math.max(max, A[i]);
	}
	return max;
}
static long min(long A[]) {
	long min=Long.MAX_VALUE;
	for(int i=0;i<A.length;i++) {
		min=Math.min(min, A[i]);
	}
	return min;
}
static long [] prefix(long A[]) {
	long p[]=new long[A.length];
	p[0]=A[0];
	for(int i=1;i<A.length;i++)
		p[i]=p[i-1]+A[i];
	return p;
}
static long [] prefix(int A[]) {
	long p[]=new long[A.length];
	p[0]=A[0];
	for(int i=1;i<A.length;i++)
		p[i]=p[i-1]+A[i];
	return p;
}
static long [] suffix(long A[]) {
	long p[]=new long[A.length];
	p[A.length-1]=A[A.length-1];
	for(int i=A.length-2;i>=0;i--)
		p[i]=p[i+1]+A[i];
	return p;
}
static long [] suffix(int A[]) {
	long p[]=new long[A.length];
	p[A.length-1]=A[A.length-1];
	for(int i=A.length-2;i>=0;i--)
		p[i]=p[i+1]+A[i];
	return p;
}
static void fill(int dp[]) {
	Arrays.fill(dp, -1);
}
static void fill(int dp[][]) {
	for(int i=0;i<dp.length;i++)
	Arrays.fill(dp[i], -1);
}
static void fill(int dp[][][]) {
	for(int i=0;i<dp.length;i++) {
		for(int j=0;j<dp[0].length;j++) {
			Arrays.fill(dp[i][j],-1);
		}
	}
}
static void fill(int dp[][][][]) {
	for(int i=0;i<dp.length;i++) {
		for(int j=0;j<dp[0].length;j++) {
			for(int k=0;k<dp[0][0].length;k++) {
			Arrays.fill(dp[i][j][k],-1);
			}
		}
	}
}
static void fill(long dp[]) {
	Arrays.fill(dp, -1);
}
static void fill(long dp[][]) {
	for(int i=0;i<dp.length;i++)
	Arrays.fill(dp[i], -1);
}
static void fill(long dp[][][]) {
	for(int i=0;i<dp.length;i++) {
		for(int j=0;j<dp[0].length;j++) {
			Arrays.fill(dp[i][j],-1);
		}
	}
}
static void fill(long dp[][][][]) {
	for(int i=0;i<dp.length;i++) {
		for(int j=0;j<dp[0].length;j++) {
			for(int k=0;k<dp[0][0].length;k++) {
			Arrays.fill(dp[i][j][k],-1);
			}
		}
	}
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

static long power(long x, long y, long p)
{

	if(y==0)
		return 1;
	if(x==0)
		return 0;
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
static long power(long x, long y)
{

	if(y==0)
		return 1;
	if(x==0)
		return 0;
    long res = 1;

    while (y > 0) {

        if (y % 2 == 1)
            res = (res * x);

        y = y >> 1; 
        x = (x * x);
    }

    return res;
}
static void print(int A[]) {
	for(int i : A) {
		out.print(i+" ");
	}
	out.println();
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
static String reverse(String s) {
	StringBuffer p=new StringBuffer(s);
	p.reverse();
	return p.toString();
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
     static void sort(int[] A){
        int n = A.length;
        Random rnd = new Random();
        for(int i=0; i<n; ++i){
            int tmp = A[i];
            int randomPos = i + rnd.nextInt(n-i);
            A[i] = A[randomPos];
            A[randomPos] = tmp;
        }
        Arrays.sort(A);
     }
     static void sort(long[] A){
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
  static String sort(String s) {
 	 Character ch[]=new Character[s.length()];
 	 for(int i=0;i<s.length();i++) {
 		 ch[i]=s.charAt(i);
 	 }
 	 Arrays.sort(ch);
 	 StringBuffer st=new StringBuffer("");
 	 for(int i=0;i<s.length();i++) {
 		 st.append(ch[i]);
 	 }
 	 return st.toString();
  }
  static HashMap<Integer,Integer> hash(int A[]){
	  HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();
	  for(int i : A) {
		  if(map.containsKey(i)) {
			  map.put(i, map.get(i)+1);
		  }
		  else {
			  map.put(i, 1);
		  }
	  }
	  return map;
  }
  static HashMap<Long,Integer> hash(long A[]){
	  HashMap<Long,Integer> map=new HashMap<Long, Integer>();
	  for(long i : A) {
		  if(map.containsKey(i)) {
			  map.put(i, map.get(i)+1);
		  }
		  else {
			  map.put(i, 1);
		  }
	  }
	  return map;
  }
  static TreeMap<Integer,Integer> tree(int A[]){
	  TreeMap<Integer,Integer> map=new TreeMap<Integer, Integer>();
	  for(int i : A) {
		  if(map.containsKey(i)) {
			  map.put(i, map.get(i)+1);
		  }
		  else {
			  map.put(i, 1);
		  }
	  }
	  return map;
  }
  static TreeMap<Long,Integer> tree(long A[]){
	  TreeMap<Long,Integer> map=new TreeMap<Long, Integer>();
	  for(long i : A) {
		  if(map.containsKey(i)) {
			  map.put(i, map.get(i)+1);
		  }
		  else {
			  map.put(i, 1);
		  }
	  }
	  return map;
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
} 



