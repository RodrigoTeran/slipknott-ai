//package pack;
import java.io.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.*;
import java.io.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.math.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Vector;
import static java.lang.Math.sqrt;
import static java.lang.Math.floor;






public class topcoder {
   
	static class pair{
		 
		 int first;
		 int second;
		  public pair(int first, int second) {
			  this.first = first;
			  this.second = second;
		  }
	}


	static class Compare{
		
		 static void compare(ArrayList<pair>arr, int n) {
			 
			 Collections.sort(arr,new Comparator<pair>() {
				 public int compare(pair p1, pair p2) {
					 return p1.first-p2.first;
				 }
			 });
		
	}
	}
	
	
static class pairr implements  Comparable<pairr>{
	Integer value;
	Integer index;
	
	   public pairr(Integer value, Integer index) {
		    this.value = value;
		    this.index = index;
	   }
	   @Override
	   
	   public int compareTo(pairr o) {
		   return value-o.value;
	   }
}



	 static class Key<K1, K2>
	{
	    public K1 key1;
	    public K2 key2;
	 
	    public Key(K1 key1, K2 key2)
	    {
	        this.key1 = key1;
	        this.key2 = key2;
	    }
	 
	    @Override
	    public boolean equals(Object o)
	    {
	        if (this == o) {
	            return true;
	        }
	 
	        if (o == null || getClass() != o.getClass()) {
	            return false;
	        }
	 
	        Key key = (Key) o;
	        if (key1 != null ? !key1.equals(key.key1) : key.key1 != null) {
	            return false;
	        }
	 
	        if (key2 != null ? !key2.equals(key.key2) : key.key2 != null) {
	            return false;
	        }
	 
	        return true;
	    }
	 
	    @Override
	    public int hashCode()
	    {
	        int result = key1 != null ? key1.hashCode() : 0;
	        result = 31 * result + (key2 != null ? key2.hashCode() : 0);
	        return result;
	    }
	 
	    @Override
	    public String toString() {
	        return "[" + key1 + ", " + key2 + "]";
	    }
	}
	
	
	 public static int sumOfDigits (long n) {
		 
		 int sum = 0;
		 
		 while(n > 0) {
			 sum += n%10;
			 n /= 10;
		 }
		 
		 return sum;
	 
	 }
	 
	 
	 public static long binary_search(int s, int e, long num, long []ar) {
		 
		 if(s > e) {
			 return -1;
		 }	 
			 
		 
		     int mid = (s+e)/2;
		     
		      if(s == e && ar[s] >= num) {
		    	  return ar[s];
		      }else if(s == e && ar[s] < num) {
		    	  return -1;
		      }else if(ar[mid] < num) {
		    	  return binary_search(mid+1,e,num,ar);
		      }else if(ar[mid] >= num) {
		    	    return binary_search(s,mid,num,ar);
		      }
		      
		      return -1;
		 
	 }
	 
	 
	 public static int index_search(int s, int e, long num, long []ar) {
		 
		 if(s > e) {
			 return -1;
		 }	 
			 
		 
		     int mid = (s+e)/2;
		     
		      if(s == e && ar[s] >= num) {
		    	  return s;
		      }else if(s == e && ar[s] < num) {
		    	  return -1;
		      }else if(ar[mid] < num) {
		    	  return index_search(mid+1,e,num,ar);
		      }else if(ar[mid] >= num) {
		    	    return index_search(s,mid,num,ar);
		      }
		      
		      return -1;
		 
	 }
		     public static void swap(int []ar, int i, int j) {
		    	 
		    	 
		    	 for(int k= j; k >= i; k--) {
		    		 int temp = ar[k];
		    		 ar[k] = ar[k+1];
		    		 ar[k+1] = temp;
		    	 }
		     }
		     
		     public static boolean digit_exists(long n) {
		    	 
		    	 while(n > 0) {
		    		 if(n%10 == 9)
		    			 return true;
		    		 n = n/10;
		    	 }
		    	 
		    	 return false;
		     }
		     public static int log(int n) {
		    	 
		    	 int c = 0;
		    	 while(n > 0) {
		    		 c++;
		    		 n /=2;
		    	 }
		    	 
		    	 return c;
		     }
			  public static int findOr(int[]bits){
	    	        int or=0;
	    	            for(int i=0;i<32;i++){
	    	                or=or<<1;
	    	                if(bits[i]>0)
	    	                    or=or+1;
	    	            }
	    	        return or;
	    	    }
			  
			  static void simpleSieve(int limit, Vector<Integer> prime)
			    {
			        // Create a boolean array "mark[0..n-1]" and initialize
			        // all entries of it as true. A value in mark[p] will
			        // finally be false if 'p' is Not a prime, else true.
			        boolean mark[] = new boolean[limit+1];
			         
			        for (int i = 0; i < mark.length; i++)
			            mark[i] = true;
			      
			        for (int p=2; p*p<limit; p++)
			        {
			            // If p is not changed, then it is a prime
			            if (mark[p] == true)
			            {
			                // Update all multiples of p
			                for (int i=p*p; i<limit; i+=p)
			                    mark[i] = false;
			            }
			        }
			      
			        // Print all prime numbers and store them in prime
			        for (int p=2; p<limit; p++)
			        {
			            if (mark[p] == true)
			            {
			                prime.add(p);
			             
			            }
			        }
			    }
			      
			    // Prints all prime numbers smaller than 'n'
			public    static void segmentedSieve(int n, ArrayList<Integer>l)
			    {
			        // Compute all primes smaller than or equal
			        // to square root of n using simple sieve
			        int limit = (int) (floor(sqrt(n))+1);
			        Vector<Integer> prime = new Vector<>(); 
			  
			        simpleSieve(limit, prime);
			      
			        // Divide the range [0..n-1] in different segments
			        // We have chosen segment size as sqrt(n).
			        int low  = limit;
			        int high = 2*limit;
			      
			        // While all segments of range [0..n-1] are not processed,
			        // process one segment at a time
			        while (low < n)
			        {
			            if (high >= n)
			                high = n;
			 
			            // To mark primes in current range. A value in mark[i]
			            // will finally be false if 'i-low' is Not a prime,
			            // else true.
			            boolean mark[] = new boolean[limit+1];
			             
			            for (int i = 0; i < mark.length; i++)
			                mark[i] = true;
			      
			            // Use the found primes by simpleSieve() to find
			            // primes in current range
			            for (int i = 0; i < prime.size(); i++)
			            {
			                // Find the minimum number in [low..high] that is
			                // a multiple of prime.get(i) (divisible by prime.get(i))
			                // For example, if low is 31 and prime.get(i) is 3,
			                // we start with 33.
			                int loLim = (int) (floor(low/prime.get(i)) * prime.get(i));
			                if (loLim < low)
			                    loLim += prime.get(i);
			      
			                /*  Mark multiples of prime.get(i) in [low..high]:
			                    We are marking j - low for j, i.e. each number
			                    in range [low, high] is mapped to [0, high-low]
			                    so if range is [50, 100]  marking 50 corresponds
			                    to marking 0, marking 51 corresponds to 1 and
			                    so on. In this way we need to allocate space only
			                    for range  */
			                for (int j=loLim; j<high; j+=prime.get(i))
			                    mark[j-low] = false;
			            }
			      
			            // Numbers which are not marked as false are prime
			            for (int i = low; i<high; i++)
			                if (mark[i - low] == true)
			                   l.add(i);
			      
			            // Update low and high for next segment
			            low  = low + limit;
			            high = high + limit;
			        }
			    }
			    
			    public static int find_indexNum(long k) {
			    	
			    	long k1 = k;
			    	int power = 0;
			    	
			    	while(k > 0) {
			    		power++;
			    		k /=2 ;
			    	}
			    	
			    	long check = (long)Math.pow(2, power-1);
			    	if(k1 == check) {
			    		return power;
			    	}
			//   System.out.println(power);
			    	long f = (long)Math.pow(2, power-1);
			    	long rem = k1-f;
			    	return find_indexNum(rem);
			    }
			    
			 public static void sortPair(ArrayList<pair>l, int n) {
				  n = l.size();
				  
				  Compare obj = new Compare();
				  obj.compare(l, n);
			 }
               
            
			  public static int add(long n, long num, long a, int i) {
				//System.out.println(num);
				  if(num > n)return -1;
				
				  if(num == n) {
					  
					  return i;
				  }
				  
				if(a < 2050)return -1;
				  
				
				 
				  long temp = num+a;
				  
				  if(temp <= n) {
				return	  add(n,temp,a,i+1);
				  }else if(temp > n){
					  a /= 10;
					  return add(n,num,a,i);
				  }
				  
			      return -1;
				  }
			
				   
		public static void shuffle(int []array, int num,int t_index,  boolean []vis, int m ) {	  
			 
		
		for(int i = 0; i < m; i++) {
			if(vis[i] == false) {
				
				
				int temp = array[i];
		          if(i < t_index) {
		        	  vis[i] = true;
		          }
				array[i] = num;
				array[t_index] = temp;
			//	System.out.println(array[t_index]+" "+array[i]);
				break;
			}
		}
		}
		
		public static void rotate(int []arr,int j, int times, int m) {
			
		
			
			 if(j == 0) {
				 int temp1 = arr[0];
				 arr[0] = arr[times];
				 arr[times] = temp1;
				 
			 }else {
			 int temp = arr[j];
			 int z = arr[0];
				
			 arr[0] = arr[times];
			
			 arr[j] = z;
			 arr[times] =  temp;
			    
			
			
		}

		}
		
		public static void recur(int i,int A, int B,int []dp,int []metal, int n, boolean took,int ind) {
			
		  if(i-A <= 0 && i-B <= 0)return;
		    int count = 0;
		    
		    for(int j = 1; j <= n; j++) {
		    	if(dp[j] >= metal[j]) {
		    		count++;
		    	}
		    }
		    
		    if(count == n)return;
			if(i-A >= 0 && i-B >= 0 && dp[i] > 0 && dp[i] > metal[i]) {
			dp[i]--;
		
			dp[i-A]++;
		
			dp[i-B]++;
			}
			
			
			if(ind == 6) {
		//	System.out.println(Arrays.toString(dp));
			}
			recur(i-A,A,B,dp,metal,n,took,ind);
			recur(i-B,A,B,dp,metal,n,took,ind);
		}
		
		
		public static boolean isPrime(int n) { 
	        if (n <= 1) return false; 
	        if (n <= 3) return true; 
	        if (n % 2 == 0 || n % 3 == 0) return false; 
	        for (int i = 5; i * i <= n; i = i + 6) 
	            if (n % i == 0 || n % (i + 2) == 0) 
	            return false; 
	        return true; 
	    }
		
		  public static boolean[] getSieve(int n) {
		        boolean[] isPrime = new boolean[n+1];
		        for (int i = 2; i <= n; i++) isPrime[i] = true;
		        for (int i = 2; i*i <= n; i++) if (isPrime[i]) 
		                for (int j = i; i*j <= n; j++) isPrime[i*j] = false;
		        return isPrime;
		    }
		  

		    public static int gcd(int a, int b) { 
		    	int tmp = 0;
		    	while(b != 0) {
		    		tmp = b;
		    		b = a%b;
		    		a = tmp;
		    	}
		    	return a;
		    }
		    
		    
		    public static long gcd(long a, long b) { 
		    	long tmp = 0;
		    	while(b != 0) {
		    		tmp = b;
		    		b = a%b;
		    		a = tmp;
		    	}
		    	return a;
		    }
		    
		
		public static boolean poss( int r, int c, int k, int n, int m,boolean [][]vis) {
			
			if(k < 0)return false;
			if(r > n || c > m || r < 1 || c < 1)return false;
			
			if(r == n &&  c == m &&  k == 0) {
			//	System.out.println(k);
				return true;
			}
              if(vis[r][c] == true) {
            	  return false;
              }
              vis[r][c] = true;
			
			
		return	poss(r+1,c,k-c,n,m,vis) || poss(r,c+1,k-r,n,m,vis);
			
			
		}
			
	    public static void dfs(LinkedList<Integer>[]list, HashMap<Integer,Integer>map, int parent, int n) {
	    	
	    	Stack<Integer>st = new Stack<>();
	   
	    	
	    }
	   public static boolean pos(int n) {
		
		   
		   int i = 1;
		   boolean pos = false;
		   
		   while(i*i <= n) {
			   if(i*i*2 == n || i*i*4 == n) {
				   pos = true;
				   break;
			   }
			   i++;
		   }
		   if(pos)return true;
		    return false;
		   
	   }
	  
			
	    public static void main(String args[])throws IOException{
			 
	    	//	 System.setIn(new FileInputStream("Case.txt"));
	    		 BufferedReader ob = new BufferedReader(new InputStreamReader(System.in));
	    	    
	    		 
	    		 int t = Integer.parseInt(ob.readLine());
	    		 
	    		 
	    		 while( t--> 0) {
	    		
	    		StringTokenizer	 st = new StringTokenizer(ob.readLine());
	    			 int n = Integer.parseInt(st.nextToken());
	    			 int m = Integer.parseInt(st.nextToken());
	    			 int x = Integer.parseInt(st.nextToken());
	    			 
	    			 int []ar = new int[n];
	    			 st = new StringTokenizer(ob.readLine());
	    			 PriorityQueue<Integer>pq = new PriorityQueue<>();
	    			 
	    			 for(int i = 0; i < n; i++) {
	    				 ar[i] = Integer.parseInt(st.nextToken());
	    				 pq.add(ar[i]);
	    			 }
	    			 
	    			 
	    	PriorityQueue<pairr>p = new PriorityQueue<>();
	    	for(int i =0; i < n; i++) {
	    		p.add(new pairr(ar[i],i));
	    	}
	    	int []ans = new int[n];
	    	
	    	
	    	for(int i = 0; i < n; i++) {
	    	pairr a = p.poll();
	    	ans[a.index] = (i%m)+1;
	    	}
	    	
	    	System.out.println("YES");
	    	for(int i = 0; i < n; i++ ) {
	    		System.out.print(ans[i]+" ");
	    	}
	    	System.out.println();
	    		 }
	    }
}
	    	
	    	
	    	
	    				 