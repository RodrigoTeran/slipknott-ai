
import java.util.*;

import java.io.*;
import java.math.*;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Solution {
	 private static class MyScanner {
	        private static final int BUF_SIZE = 2048;
	        BufferedReader br;
	 
	        private MyScanner() {
	            br = new BufferedReader(new InputStreamReader(System.in));
	        }
	 
	        private boolean isSpace(char c) {
	            return c == '\n' || c == '\r' || c == ' ';
	        }
	 
	        String next() {
	            try {
	                StringBuilder sb = new StringBuilder();
	                int r;
	                while ((r = br.read()) != -1 && isSpace((char)r));
	                if (r == -1) {
	                    return null;
	                }
	 
	                sb.append((char) r);
	                while ((r = br.read()) != -1 && !isSpace((char)r)) {
	                    sb.append((char)r);
	                }
	                return sb.toString();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	            return null;
	        }
	 
	        int nextInt() {
	            return Integer.parseInt(next());
	        }
	 
	        long nextLong() {
	            return Long.parseLong(next());
	        }
	 
	        double nextDouble() {
	            return Double.parseDouble(next());
	        }
	    }
	  static class Reader{
		  
			BufferedReader br;
			StringTokenizer st;
			public Reader() {
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
	
	static void sort(char[] arr) {
		ArrayList<Character> al = new ArrayList<Character>();
		for(char cc:arr) al.add(cc);
		Collections.sort(al);
		for(int i = 0 ;i<arr.length ;i++) arr[i] = al.get(i);
	}

	static long mod_mul(  long... a) {
		long ans = a[0]%mod;
		for(int i = 1 ; i<a.length ; i++) {
			ans = (ans * (a[i]%mod))%mod;
		}
		
		return ans;
	}
	static long mod_sum( long... a) {
		long ans = 0;
		for(long e:a) {
			ans = (ans + e)%mod;
		}
		return ans;
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

	 static long modInverse(long a, long m)
	    {
	        long g = gcd(a, m);
	       
	          return   power(a, m - 2, m);
	        
	    }
	   static long lcm(long a , long b) {
		   return (a*b)/gcd(a, b);
	   }
	   static int lcm(int a , int b) {
		   return (int)((a*b)/gcd(a, b));
	   }
	 static long power(long x, long y, long m){
	        if (y == 0) return 1; long p = power(x, y / 2, m) % m; p = (int)((p * (long)p) % m);
	        if (y % 2 == 0) return p; else return (int)((x * (long)p) % m); }
	   
     static class Combinations{
	    	 private long[] z;
	    	 private long[] z1;
	    	 private long[] z2;
	    	 private long mod;
	    	  public Combinations(long N , long mod) {
	    		  this.mod = mod;
				z = new long[(int)N+1];
				z1 = new long[(int)N+1];
				z[0] = 1;
				for(int i =1 ; i<=N ; i++) z[i] = (z[i-1]*i)%mod;
			     z2 = new long[(int)N+1];
				z2[0] = z2[1] = 1;
			    for (int i = 2; i <= N; i++)
			        z2[i] = z2[(int)(mod % i)] * (mod - mod / i) % mod;
			    
			    
			    z1[0] = z1[1] = 1;
			    
			    for (int i = 2; i <= N; i++)
			        z1[i] = (z2[i] * z1[i - 1]) % mod;
			}
	    	  long fac(long n) {
	    		  return z[(int)n];
	    	  }
	    	  long invrsNum(long n) {
	    		  return z2[(int)n];
	    	  }
	    	  long invrsFac(long n) {
	    		  return invrsFac((int)n);
	    	  }
	    	  long ncr(long N, long R)
	    	  {		if(R<0 || R>N ) return 0;
	    		    long ans = ((z[(int)N] * z1[(int)R])
	    		              % mod * z1[(int)(N - R)])
	    		             % mod;
	    		    return ans;
	    		}
	      }
	      static class DisjointUnionSets {
			    int[] rank, parent;
			    int n;
			  
			    public DisjointUnionSets(int n)
			    {
			        rank = new int[n];
			        parent = new int[n];
			        this.n = n;
			        makeSet();
			    }
			  
			    void makeSet()
			    {
			        for (int i = 0; i < n; i++) {
			          
			            parent[i] = i;
			        }
			    }
			  
			    int find(int x)
			    {
			        if (parent[x] != x) {
			        
			            parent[x] = find(parent[x]);
			  
			        }
			  
			        return parent[x];
			    }
			  
			    void union(int x, int y)
			    {
			        int xRoot = find(x), yRoot = find(y);
			  
			        if (xRoot == yRoot)
			            return;
			  
			        if (rank[xRoot] < rank[yRoot])
			  
			            parent[xRoot] = yRoot;
			  
			        else if (rank[yRoot] < rank[xRoot])
			  
			            parent[yRoot] = xRoot;
			  
			        else
			        {
			            parent[yRoot] = xRoot;
			  
			            rank[xRoot] = rank[xRoot] + 1;
			        }
			    }
			}
	      static int max(int... a ) {
	    	  int max = a[0];
	    	  for(int e:a) max = Math.max(max, e);
	    	  return max;
	      }
	      static long max(long... a ) {
	    	  long max = a[0];
	    	  for(long e:a) max = Math.max(max, e);
	    	  return max;
	      }
	      static int min(int... a ) {
	    	  int min = a[0];
	    	  for(int e:a) min = Math.min(e, min);
	    	  return min;
	      }
	      static long min(long... a ) {
	    	  long min = a[0];
	    	  for(long e:a) min = Math.min(e, min);
	    	  return min;
	      }
	      static int[] KMP(String str) {
	    	  int n = str.length();
	    	  int[] kmp = new int[n];
	    	  for(int i = 1 ; i<n ; i++) {
	    		  int j = kmp[i-1];
	    		  while(j>0 && str.charAt(i) != str.charAt(j)) {
	    			  j = kmp[j-1];
	    		  }
	    		  if(str.charAt(i) == str.charAt(j)) j++;
	    		  kmp[i] = j;
	    	  }
	    	  
	    	  return kmp;
	      }
	      
	      
/************************************************ Query **************************************************************************************/	  
	 
/***************************************** 		Sparse Table	********************************************************/
	      static class SparseTable{
	    		
	    		private long[][] st;
	    		
	    		SparseTable(long[] arr){
	    			int n = arr.length;
	    			st = new long[n][25];
	    			log = new int[n+2];
	    			build_log(n+1);
	    			build(arr);
	    		}
	    		
	    		private void build(long[] arr) {
	    			int n = arr.length;
	    			
	    			for(int i = n-1 ; i>=0 ; i--) {
	    				for(int j = 0 ; j<25 ; j++) {
	    					int r = i + (1<<j)-1;
	    					if(r>=n) break;
	    					if(j == 0 ) st[i][j] = arr[i];
	    					else st[i][j] = Math.min(st[i][j-1] , st[ i + ( 1 << (j-1) ) ][ j-1 ] );
	    				}
	    			}
	    		}
	    		public long gcd(long a  ,long b) {
	    			if(a == 0) return b;
	    			return gcd(b%a , a);
	    		}
	    		public long query(int l ,int r) {
	    			int w = r-l+1;
	    			int power = log[w];
	    			return Math.min(st[l][power],st[r - (1<<power) + 1][power]);
	    		}
	    		private int[] log;
	    		void build_log(int n) {
	    			log[1] = 0;
	    			for(int i = 2 ; i<=n ; i++) {
	    				log[i] = 1 + log[i/2];
	    			}
	    		}
	    	}
	      
	      
/********************************************************	Segement Tree	*****************************************************/
/**
	 	 static class SegmentTree{
			 long[] tree;
			 long[] arr;
			 int n;
			 SegmentTree(long[] arr){
				 this.n = arr.length;
				 tree = new long[4*n+1];
				 this.arr = arr;
				 buildTree(0, n-1, 1);
			 }
			 
			 
			  void buildTree(int s ,int e  ,int index ) {
					if(s == e) {
						tree[index] = arr[s];
						return;
					}
				
					int mid = (s+e)/2;
					
					buildTree( s,  mid, 2*index);
					buildTree( mid+1, e, 2*index+1);
					
					tree[index] = Math.min(tree[2*index] , tree[2*index+1]);
				}
			  
			 long query(int si ,int ei) {
				 return query(0 ,n-1 , si ,ei , 1   );
			 }
			 private long query( int ss ,int se ,int qs , int qe,int index) {
					
					if(ss>=qs && se<=qe) return tree[index];
					
					if(qe<ss || se<qs) return (long)(1e17);
					
					int mid = (ss + se)/2;
					long left = query( ss , mid , qs ,qe , 2*index);
					long right= query(mid + 1 , se , qs ,qe , 2*index+1);
					return Math.min(left, right);
				}
			 public void update(int index , int val) {
				 arr[index] = val;
				 for(long e:arr) System.out.print(e+" ");
				 update(index , 0 , n-1 , 1);
			 }
			 private void update(int id ,int si , int ei , int index) {
				 if(id < si || id>ei) return;
				 if(si == ei ) { 
					 tree[index] = arr[id];
					 return;
				 }
				 if(si > ei) return;
				 int mid = (ei + si)/2;
					
					update( id,  si, mid , 2*index);
					update( id , mid+1, ei , 2*index+1);
					
					tree[index] = Math.min(tree[2*index] ,tree[2*index+1]);
			 }
			  
		 }
		 */

/* ***************************************************************************************************************************************************/	 
	 
//	      static MyScanner sc = new MyScanner(); // only in case of less memory
	      static Reader sc = new Reader();
	 static StringBuilder sb = new StringBuilder();
	 public static void main(String args[]) throws IOException {

		 int tc = 1;
		  tc = sc.nextInt();

		 for(int i = 1 ; i<=tc ; i++) {

//			 sb.append("Case #" + i + ": "  );	// During KickStart && HackerCup
			 TEST_CASE();
			  
		 }
		 System.out.println(sb);
	 }

	 static void TEST_CASE() {
		int n = sc.nextInt();
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for(int i =0 ; i<n ; i++) adj.add(new ArrayList<>());
		int[] U = new int[n-1] , V = new int[n-1];
		for(int i = 0 ; i<n-1 ; i++) {
			int u = sc.nextInt()-1 , v = sc.nextInt()-1;
			U[i] = u; V[i] = v;
			adj.get(u).add(v);
			adj.get(v).add(u);
		}
		int ind = -1;
		for(int i =0 ; i<n ; i++) {
			if(adj.get(i).size()>2) {
				sb.append("-1\n");
				return;
			}
			if(adj.get(i).size() == 1) {
				ind = i;
			}
		}
		Map<String , Integer> map = new HashMap<>();
		dfs(adj, ind, -1, true, map);
		for(int i =0 ; i<n-1 ; i++) {
		 int u = U[i];
		 int v = V[i];
		 if(map.containsKey(u+" "+v)) sb.append(map.get(u+" "+v)+" ");
		 else sb.append(map.get(v+" "+u)+" ");
		}
		sb.append("\n");
		
	 }
	 static void dfs(ArrayList<ArrayList<Integer>> adj ,int u , int p ,boolean eve ,Map<String , Integer> map ) {
		 if(eve) {
			 map.put(u+" "+p, 2);
		 }else {
			 map.put(u+" "+p, 3);
		 }
		 for(int v:adj.get(u)) {
			 if(v == p) continue;
			 eve = !eve;
			 dfs(adj, v, u, eve, map);
		 }
	 }
	}
/*******************************************************************************************************************************************************/

/**
1
		
 */

 

