

import java.io.*;
import java.math.*;
import java.util.*;


public class test {
	 
	   static class Pair{ 
		   long x;
		   long y;
		   
		   Pair(long x,long y){ 
			   this.x = x;
			   this.y = y;
			   
		   }
	   }
	   static class Duo{
		   int x;
		   String s;
		   
		   Duo(int x,String s){
			   this.x = x;
			   this.s = s;
		   }
	   }
	 
	   static class Sort implements Comparator<Pair>
	   {

	       @Override
	       public int compare(Pair a, Pair b)
	       {
	           if(a.x!=b.x)
	           {
	               return (int)(a.x - b.x);
	           }
	           else
	           {
	               return (int)(a.y-b.y);
	           }
	       }
	   }
	   
	   static class Compare { 
		   
		     void compare(Pair arr[], int n) 
		    { 
		        // Comparator to sort the pair according to second element 
		        Arrays.sort(arr, new Comparator<Pair>() { 
		            @Override public int compare(Pair p1, Pair p2) 
		            { 
		            	if(p1.x!=p2.x) {
		                return (int)(p1.x - p2.x); 
		            	}
		            	else { 
		            		return (int)(p1.y - p2.y);
		            	}
		            } 
		        }); 
		  
//		        for (int i = 0; i < n; i++) { 
//		            System.out.print(arr[i].x + " " + arr[i].y + " "); 
//		        } 
//		        System.out.println(); 
		    } 
		} 
	 
	   static class Scanner {
	        BufferedReader br;
	        StringTokenizer st;
	 
	        public Scanner()
	        {
	            br = new BufferedReader(
	                new InputStreamReader(System.in));
	        }
	 
	        String next()
	        {
	            while (st == null || !st.hasMoreElements()) {
	                try {
	                    st = new StringTokenizer(br.readLine());
	                }
	                catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	            return st.nextToken();
	        }
	 
	        int nextInt() { return Integer.parseInt(next()); }
	 
	        long nextLong() { return Long.parseLong(next()); }
	 
	        double nextDouble()
	        {
	            return Double.parseDouble(next());
	        }
	 
	        String nextLine()
	        {
	            String str = "";
	            try {
	                str = br.readLine();
	            }
	            catch (IOException e) {
	                e.printStackTrace();
	            }
	            return str;
	        }
	    }
	
	static boolean function(long a[],long x) {
		
		long arr[] = new long[a.length];
		
		for(int i=0;i<arr.length;i++) {
			arr[i] = a[i];
		}
		
		for(int i=arr.length-1;i>=2;i--) {
			
			if(arr[i] < x) {
				return false;
			}
			long d = Math.min(a[i],(arr[i]-x))/3;
			
			arr[i-1] += d;
			arr[i-2] += 2*d;
		}
		
		return (arr[0]>=x && arr[1]>=x);
	}
	   public static void main(String args[]) throws Exception { 
		
		   Scanner sc = new Scanner();
		   StringBuilder res = new StringBuilder();
		
		   int tc = sc.nextInt();
		  
		   while(tc-->0) { 
			  
			int n = sc.nextInt();
			
			long a[] = new long[n];
			
			for(int i=0;i<n;i++) {
				a[i] = sc.nextLong();
			}
			
			long l = 1;
			long r = 1000000000;
			
			long ans = 1;
			
			while(l<=r){
				
				long mid = l + (r-l)/2;
				
				if(function(a,mid)){
					ans = mid;
					l = mid+1;
				}
				else {
					r = mid-1;
				}
			}
			
			res.append(ans+"\n");
		   }
		   System.out.println(res);
	   }
}  




