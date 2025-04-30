import java.util.*;

import java.io.*;
import java.math.*;


public class A		
{ 
			 static FastReader sc=new FastReader(); 
			 static long dp[][];
			 static int mod=1000000007;
			 static int max;
			 static int bit[];
			 static long ans;
			 static HashMap<Integer,Integer> map;
			
				
		     public static void main(String[] args)
		    {
		    	//CHECK FOR N=1
		        	//CHECK FOR N=1
			  PrintWriter out=new PrintWriter(System.out);
			  StringBuffer sb=new StringBuffer("");
			 
		  int ttt=1;
		     ttt =i();
		   
		    outer :while (ttt-- > 0) 
			{	
		    	int n=i();
		    	String A[]=inputS(n);
		    	Pair P[]=new Pair[n];
		    	int B[][]=new int[n][5];
		    	for(int i=0;i<n;i++) {
		    		for(int j=0;j<A[i].length();j++) {
		    			B[i][A[i].charAt(j)-'a']++;
		    		}
		    	}
		    	int ans=Integer.MAX_VALUE;
		    	for(int k=0;k<5;k++) {
		    		int s1=0;
		    		int s2=0;
		    	for(int i=0;i<n;i++) {
		    		int a=B[i][k];
		    		int b=A[i].length()-a;
		    		s1+=a;
		    		s2+=b;
		    		P[i]=new Pair(a, b);
		    	}
		    	Arrays.sort(P);
		    	int res=go(P,s1,s2);
		    	ans=min(ans,res);
		    	
		    	}
		    	System.out.println(n-ans);
		    	
		    			
		    	
		    	
			}
		   out.close();
		  // System.out.println(sb.toString());
		   
		   
		   //CHECK FOR N=1                    //CHECK FOR M=0
		    //CHECK FOR N=1                    //CHECK FOR M=0
		   
    }
		 static int go(Pair P[],int a,int b) {
			 int i=0;
			 int ans=0;
			 while(a<=b&& i<P.length) {
				 a-=P[i].x;
				 b-=P[i].y;
				 ans++;
				 i++;
			 }
			 return ans;
		 }


static class Pair implements Comparable<Pair>
     {
    	 int x;
    	 int y;
    	 Pair(int x,int y){
    		 this.x=x;
    		 this.y=y;
    		 
    	 }
		@Override
		public int compareTo(Pair o) {
			int a=o.y-o.x;
			int b=this.y-this.x;
			if(a>b)
				return 1;
			else if(a<b)
				return -1;
			else {
				
					return 0;
			}
		}
		
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
//		public int hashCode() 
//		{ 
//			final int temp = 14; 
//			int ans = 1; 
//			ans =x*31+y*13; 
//			return ans; 
//		} 
//  
//		// Equal objects must produce the same 
//		// hash code as long as they are equal 
//		@Override
//		public boolean equals(Object o) 
//		{ 
//			if (this == o) { 
//				return true; 
//			} 
//			if (o == null) { 
//				return false; 
//			} 
//			if (this.getClass() != o.getClass()) { 
//				return false; 
//			} 
//			Pair other = (Pair)o; 
//			if (this.x != other.x || this.y!=other.y) { 
//				return false; 
//			} 
//			return true; 
//		} 	
		
     }
//FRENWICK TREE
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
static int find(int A[],int a) {
	  if(A[a]==a)
		  return a;
	  return A[a]=find(A, A[a]);
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
