/*
    JAI MATA DI
 */

import java.util.*;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import java.io.*;
import java.math.*;
import java.sql.Array;;



public class Main {
	  static class FR{
		  
			BufferedReader br;
			StringTokenizer st;
			public FR() {
				br = new BufferedReader(new InputStreamReader(System.in));
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
	 
	  static long mod = (long)(1e9 + 7);
	 
	static void sort(long[] arr ) {
		 ArrayList<Long> al = new ArrayList<>();
		 for(long e:arr) al.add(e);
		 Collections.sort(al);
		 for(int i = 0 ; i<al.size(); i++) arr[i] = al.get(i);
	 }
	static void sort(int[] arr ) {
		 ArrayList<Integer> al = new ArrayList<>();
		 for(int e:arr) al.add(e);
		 Collections.sort(al);
		 for(int i = 0 ; i<al.size(); i++) arr[i] = al.get(i);
	 }
	static int UB(long[] arr , long find , int l , int r) {
		while(l<=r) {
			int m = (l+r)/2;
			if(arr[m]<find) l = m+1;
			else r = m-1;
		}
		return l;
	}
	static int LB(long[] arr , long find,int l ,int r ) {
		while(l<=r) {
			int m = (l+r)/2;
			if(arr[m] > find) r = m-1;
			else l = m+1;
		}
		return r;
	}
	static int UB(int[] arr , long find , int l , int r) {
		while(l<=r) {
			int m = (l+r)/2;
			if(arr[m]<find) l = m+1;
			else r = m-1;
		}
		return l;
	}
	static int LB(int[] arr , long find,int l ,int r ) {
		while(l<=r) {
			int m = (l+r)/2;
			if(arr[m] > find) r = m-1;
			else l = m+1;
		}
		return r;
	}
	 static long gcd(long a, long b)
	  {      
	     if (b == 0)
	        return a;
	     return gcd(b, a % b); 
	  }
	 static boolean[] prime(int num) {
			boolean[] bool = new boolean[num];
		     
		      for (int i = 0; i< bool.length; i++) {
		         bool[i] = true;
		      }
		      for (int i = 2; i< Math.sqrt(num); i++) {
		         if(bool[i] == true) {
		            for(int j = (i*i); j<num; j = j+i) {
		               bool[j] = false;
		            }
		         }
		      }
		      if(num >= 0) {
		    	  bool[0] = false;
		    	  bool[1] = false;
		      }
		      
		      return bool;
		}
	 static void sort(char[] arr) {
		 ArrayList<Character> al = new ArrayList<Character>();
		 for(char cc:arr) al.add(cc);
		 Collections.sort(al);
		 for(int i = 0 ;i<arr.length ;i++) arr[i] = al.get(i);
		 
	 }
	 static long[][] ncr(int n, int k)
	    {
	        long C[][] = new long[n + 1][k + 1];
	        int i, j;
	 
	        // Calculate  value of Binomial
	        // Coefficient in bottom up manner
	        for (i = 0; i <= n; i++) {
	            for (j = 0; j <= Math.min(i, k); j++) {
	                // Base Cases
	                if (j == 0 || j == i)
	                    C[i][j] = 1;
	 
	                // Calculate value using
	                // previously stored values
	                else
	                    C[i][j] = (C[i - 1][j - 1] + C[i - 1][j])%mod;
	            }
	        }
	 
	        return C;
	    }
	 static long modInverse(long a, long m)
	    {
	        long g = gcd(a, m);
	       
	          return   power(a, m - 2, m);
	        
	    }
	   
	      static long power(long x, long y, long m)
	    {
	        if (y == 0)
	            return 1;
	        long p = power(x, y / 2, m) % m;
	        p = (int)((p * (long)p) % m);
	        if (y % 2 == 0)
	            return p;
	        else
	            return (int)((x * (long)p) % m);
	    }

/* ***************************************************************************************************************************************************/	 
	 
	      static FR sc = new FR();
	 static StringBuilder sb = new StringBuilder();
	 public static void main(String args[]) {
		
		 int tc = 1;
		  tc = sc.nextInt();
		 
		 
		 while(tc-->0) {
			 TEST_CASE();
			 
		 }
		 
	    System.out.println(sb);
	 }


	 static void TEST_CASE() {
		 int n = sc.nextInt(); ;
		 int[] arr = new int[n];
		 for(int i =0 ; i<n;i++) {
			 arr[i] = sc.nextInt();
		 } 
		 boolean cond = false;
		
		 Set<Integer> set = new HashSet<>();
		 set.add(0);
		 for(int i =0 ; i<n ; i++) {
			 ArrayList<Integer> al = new ArrayList<>(set);
			 for(int e:al) {
				 int num = e+arr[i];
				 if(set.contains(num)) {
					 cond = true;
					 break;
				 }
				 set.add(num);
			 }
		 }
		 if(cond) System.out.println("YES");
		 else System.out.println("NO");
	 }

	 
}







