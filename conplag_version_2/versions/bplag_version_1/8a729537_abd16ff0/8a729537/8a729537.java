
import java.io.*;
import java.util.*;

public class test3 {

	public static void main(String[] args) throws  IOException {
		FastReader f = new FastReader();
		int t = f.nextInt();
		while(t-->0) {
			 int n = f.nextInt();
			 int C[] = new int[n];
			 long ans=Long.MAX_VALUE,pre = 0;
			 PriorityQueue<Integer> epq = new PriorityQueue<Integer>();
			 PriorityQueue<Integer> opq = new PriorityQueue<Integer>();
			 for(int i = 0;i<n;i++) {
				 C[i] = f.nextInt();
				 if(i%2==0)epq.add(C[i]);
				 else opq.add(C[i]);
				 pre+=C[i];
				 if(i>0) {
					 ans  = Math.min(ans,pre+ ((long)n-(long)epq.size())*(long)epq.peek()
							 		+ ((long)n-(long)opq.size())*(long)opq.peek());
				 }
			 }
			 System.out.println(ans);
			}
    }
	
	static boolean isPrime(int n)
    {
 
        // Check if number is less than
        // equal to 1
        if (n <= 1)
            return false;
 
        // Check if number is 2
        else if (n == 2)
            return true;
 
        // Check if n is a multiple of 2
        else if (n % 2 == 0)
            return false;
 
        // If not, then just check the odds
        for (int i = 3; i <= Math.sqrt(n); i += 2)
        {
            if (n % i == 0)
                return false;
        }
        return true;
    }
	
	static void print(int x,int y,int d,int n) {
		int i = 0;
		System.out.print(x+" "+y+" ");
			for(int j = x+d;j<y;j+=d) {
				System.out.print(j+" ");
				i++;
			}
			for(int j = x-d;j>0;j-=d) {
				if(i==n)return;
				System.out.print(j+" ");
				i++;
			}
			for(int j = y+d;j<1000000000;j+=d) {
				if(i==n)return;
				System.out.print(j+" ");
				i++;
			}
	}

	static int prime(int n){
	    int ret = 0;
	    while(n%2==0){
	        ret++;
	        n/=2;
	    }
	    for(int i=3;i<=Math.sqrt(n);i+=2){
	        while(n%i==0){
	            ret++;
	            n/=i;
	        }
	    }
	    if(n>2)ret++;
	    return ret;
	}
	static long nCr(int n, int r) 
	{ if(n<r) {
		return 0;
	} 
	    long[] C=new long[r+1]; 
	    C[0] = 1; 
	    for (int i = 1; i <= n; i++) 
	    {  
	        for (int j = Math.min(i, r); j > 0; j--) 
	            C[j] = (C[j] + C[j-1]); 
	    } 
	    return C[r]; 
	}
	static int power(int a,int n, int p)
    {
        int res = 1;
        a = a % p; 
        while (n > 0)
        {
            if ((n & 1) == 1)
                res = (res * a) % p;
            n = n >> 1; 
            a = (a * a) % p;
        }
        return res;
    }
    static boolean isPrime(int n, int k)
    {
    if (n <= 1 || n == 4) return false;
    if (n <= 3) return true;
    while (k > 0)
    {
        int a = 2 + (int)(Math.random() % (n - 4)); 
        if (power(a, n - 1, n) != 1)
            return false;
     
        k--;
        }
     
        return true;
    }
	  static long GCD(long a,long b) {
		  if(a%b==0)return b;
		  else return GCD(b,a%b);
	  }
		static ArrayList<Integer> readArray(FastReader f,int size){
			ArrayList<Integer> ret = new ArrayList<Integer>();
			for(int i=0;i<size;i++) {
				ret.add(f.nextInt());
			}return ret;
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



