

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
	
	   static int solve(int dp[][] , ArrayList<Integer> one , ArrayList<Integer> zero , int i,int j)
	   {
	       int n=one.size();
	       int m=zero.size();
	       
	       if(i>=n)
	           return 0;
	       
	       else if(j>=m)
	           return Integer.MAX_VALUE;
	       
	       else if(dp[i][j]!=-1)
	           return dp[i][j];
	       
	       int val1 = Math.abs(one.get(i)-zero.get(j))+solve(dp, one ,zero ,i+1,j+1);
	       int val2 = solve(dp , one , zero , i,j+1);
	       
	        dp[i][j]= Math.min(val1,val2);
	        
	        return dp[i][j];
	   }
	     
	   public static void main(String args[]) throws Exception { 
		
		   Scanner sc = new Scanner();
		   StringBuffer res = new StringBuffer();
		   
		   int tc = 1;
		   
		   while(tc-->0) { 
			
			    int n = sc.nextInt();
			    
			    ArrayList<Integer> one = new ArrayList<>();
			    ArrayList<Integer> zero = new ArrayList<>();
			    
			    for(int i=0;i<n;i++) { 
			    	
			    	int x = sc.nextInt();
			    	
			    	if(x==1) { 
			    		one.add(i);
			    	}
			    	else { 
			    		zero.add(i);
			    	}
			    }
			    
			    int dp[][] = new int[one.size()+1][zero.size()+1];
			    
			     for(int i=1;i<=one.size();i++)
			     {
			         dp[i][i]=dp[i-1][i-1]+Math.abs(zero.get(i-1)-one.get(i-1));
			         for(int j=i+1;j<=zero.size();j++)
			         {
			             dp[i][j]=Math.min(dp[i][j-1],dp[i-1][j-1]+Math.abs(one.get(i-1)-zero.get(j-1)));
			         }
			     }
			     System.out.println(dp[one.size()][zero.size()]);
		   }
			System.out.println(res);
	   }
}  




