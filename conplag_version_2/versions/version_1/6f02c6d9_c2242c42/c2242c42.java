// package codechef;

import java.io.*;
import java.util.*;



     

public class cp_2 {
	static int mod=998244353;
	
//	static  Reader sc=new Reader();
	static FastReader sc=new FastReader(System.in);
	static int[] sp;
	static int size=(int)1e6;
	public static void main(String[] args) throws IOException { 
		long tc=sc.nextLong();
//		Scanner sc=new Scanner(System.in);
//			int tc=1;
			
//			primeSet=new HashSet<>();
//			sieveOfEratosthenes((int)1e5);
			while(tc-->0)
			{
				int n=sc.nextInt();
				int arr[]=new int[n];
				for (int i = 0; i < arr.length; i++) {
					arr[i]=sc.nextInt();
				}
				
				String s=sc.next();
				ArrayList<Integer> blue=new ArrayList<>();
				ArrayList<Integer> red=new ArrayList<>();
				for(int i=0;i<n;i++)
				{
					if(s.charAt(i)=='B')
						blue.add(arr[i]);
					else {
						red.add(arr[i]);
					}
				}
				
				Collections.sort(blue);
				Collections.sort(red,Collections.reverseOrder());
				boolean flag=true;
				for(int i=0;i<blue.size();i++)
				{
					if(blue.get(i)<i+1)
						flag=false;
				}
				
				for(int i=0;i<red.size();i++)
				{
					if(red.get(i)>n-i)
						flag=false;
				}
				
				printYesNo(flag);
				
			}
				
				
			
			
			out.flush();
			out.close();
			System.gc();
	
	}
	
	
	


	/*
	   ...SOLUTION ENDS HERE...........SOLUTION ENDS HERE...
 */

	static int N = 501; 
	 
	// Array to store inverse of 1 to N
	static long[] factorialNumInverse = new long[N + 1];
	 
	// Array to precompute inverse of 1! to N!
	static long[] naturalNumInverse = new long[N + 1];
	 
	// Array to store factorial of first N numbers
	static long[] fact = new long[N + 1];
	 
	// Function to precompute inverse of numbers
	public static void InverseofNumber(int p)
	{
	    naturalNumInverse[0] = naturalNumInverse[1] = 1;
	     
	    for(int i = 2; i <= N; i++)
	        naturalNumInverse[i] = naturalNumInverse[p % i] *
	                                 (long)(p - p / i) % p;
	}
	 
	// Function to precompute inverse of factorials
	public static void InverseofFactorial(int p)
	{
	    factorialNumInverse[0] = factorialNumInverse[1] = 1;
	 
	    // Precompute inverse of natural numbers
	    for(int i = 2; i <= N; i++)
	        factorialNumInverse[i] = (naturalNumInverse[i] *
	                           factorialNumInverse[i - 1]) % p;
	}
	 
	// Function to calculate factorial of 1 to N
	public static void factorial(int p)
	{
	    fact[0] = 1;
	 
	    // Precompute factorials
	    for(int i = 1; i <= N; i++)
	    {
	        fact[i] = (fact[i - 1] * (long)i) % p;
	    }
	}
	 
	// Function to return nCr % p in O(1) time
	public static long Binomial(int N, int R, int p)
	{
	     
	    // n C r = n!*inverse(r!)*inverse((n-r)!)
	    long ans = ((fact[N] * factorialNumInverse[R]) %
	                       p * factorialNumInverse[N - R]) % p;
	     
	    return ans;
	}
	
	
	static String tr(String s)
	{
		int now = 0;
		while (now + 1 < s.length() && s.charAt(now)== '0')
			++now;
		return s.substring(now);
	}
	
	 static ArrayList<Integer> ans;
	static void dfs(int node,Graph gg,int cnt,int k,ArrayList<Integer> temp)
	{
		if(cnt==k)
			return;
		
		for(Integer each:gg.list[node])
		{
			if(each==0)
			{
				temp.add(each);
				ans=new ArrayList<>(temp);
				temp.remove(temp.size()-1);
				continue;
			}
			temp.add(each);
			dfs(each,gg,cnt+1,k,temp);
			temp.remove(temp.size()-1);
			
		}
		
		return;
	}
	
	
	static HashSet<Integer> factors(int x)
	{
		HashSet<Integer> a=new HashSet<Integer>();
		for(int i=2;i*i<=x;i++)
		{
			if(x%i==0)
			{
				a.add(i);
				a.add(x/i);
			}
		}
		return a;
	}
		
	
static class Node
{
	int vertex;
	HashSet<Node> adj;
	boolean rem;
	Node(int ver)
	{
		vertex=ver;
		rem=false;
		adj=new HashSet<Node>();
	}
	@Override
	public String toString()
	{
		return vertex+" ";
	}
}

	static class Tuple{
		int a;
		int b;
		int c;
		public Tuple(int a,int b,int c) {
			this.a=a;
			this.b=b;
			this.c=c;
		}
		
	}

	//function to find prime factors of n
	static HashMap<Integer,Integer> findFactors(int n)
	{
		HashMap<Integer,Integer> ans=new HashMap<>();
		if(n%2==0)
		{
			ans.put(2, 0);
			while((n&1)==0)
			{
				n=n>>1;
				ans.put(2, ans.get(2)+1);
			}
				
		}
		for(int i=3;i*i<=n;i+=2)
		{
			if(n%i==0)
			{
				ans.put(i, 0);
				while(n%i==0)
				{
					n=n/i;
					ans.put(i, ans.get(i)+1);
				}
			}
		}
		if(n!=1)
			ans.put(n, ans.getOrDefault(n, 0)+1);
		return ans;
	}
	

	//fenwick tree implementaion
	static class fwt
	{
		int n;
		long BITree[];
		fwt(int n)
		{
			this.n=n;
			BITree=new long[n+1];
		}
		
		fwt(int arr[], int n)
		{
			this.n=n;
			BITree=new long[n+1];
			for(int i = 0; i < n; i++)
			updateBIT(n, i, arr[i]);
		 }
		
		   long getSum(int index)
		   {
		       long sum = 0;
		       index = index + 1;
		       while(index>0)
		       {
		           sum += BITree[index];
		           index -= index & (-index);
		       }
		       return sum;
		   }
		   void updateBIT(int n, int index,int val)
		   {
		       index = index + 1;
		       while(index <= n)
		       {
		       BITree[index] += val;
		       index += index & (-index);
		       }
		   }
		   void print()
		   {
			    for(int i=0;i<n;i++)
			    out.print(getSum(i)+" ");
			    out.println();
		   }
	}

	
	
	
	
	
	//Function to find number of set bits
	static int setBitNumber(long n)
    {
        if (n == 0)
            return 0;
 
        int msb = 0;
        n = n / 2;
 
        while (n != 0) {
            n = n / 2;
            msb++;
        }
 
        return msb;
    }
 
	
	
	static int getFirstSetBitPos(long n)
    {
        return (int)((Math.log10(n & -n)) / Math.log10(2)) + 1;
    }
	
	
	static ArrayList<Integer> primes;
	static HashSet<Integer> primeSet;
	static boolean prime[];
	static void sieveOfEratosthenes(int n)
    {
        // Create a boolean array
        // "prime[0..n]" and
        // initialize all entries
        // it as true. A value in
        // prime[i] will finally be
        // false if i is Not a
        // prime, else true.
       prime= new boolean[n + 1];
        for (int i = 2; i <= n; i++)
            prime[i] = true;
        
        for (int p = 2; p * p <= n; p++)
        {
            // If prime[p] is not changed, then it is a
            // prime
            if (prime[p] == true)
            {
                // Update all multiples of p
                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
            }
        }
 
        // Print all prime numbers
        for (int i = 2; i <= n; i++)
        {
            if (prime[i] == true)
               primeSet.add(i);
        }
    }
	
	
	
	static long mod(long a, long b) {
		  long c = a % b;
		  return (c < 0) ? c + b : c;
		}
	
	static void swap(long arr[],int i,int j)
	{
		long temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}

	
	
	static boolean util(int a,int b,int c)
	{
		if(b>a)util(b, a, c);
		
		while(c>=a)
		{
			c-=a;
			if(c%b==0)
				return true;
		}
		
		
		return (c%b==0);
	}
	
	
	
	static void flag(boolean flag)
	   {
	       out.println(flag ? "YES" : "NO");
	       out.flush();
	   }
	  
	
	static void print(int a[])
	  {
	     int n=a.length;
	     for(int i=0;i<n;i++)
	       {
	          out.print(a[i]+" ");
	       }
	     out.println();
	     out.flush();
	  }
	static void print(long a[])
	  {
	     int n=a.length;
	     for(int i=0;i<n;i++)
	       {
	          out.print(a[i]+" ");
	       }
	     out.println();
	     out.flush();
	  } 
	static void print_int(ArrayList<Integer> al)
	  {
	     int si=al.size();
	     for(int i=0;i<si;i++)
	       {
	          out.print(al.get(i)+" ");
	       }
	     out.println();
	     out.flush();
	  }
	static void print_long(ArrayList<Long> al)
	  {
	     int si=al.size();
	     for(int i=0;i<si;i++)
	       {
	          out.print(al.get(i)+" ");
	       }
	     out.println();
	     out.flush();
	  }
	  
	static void printYesNo(boolean condition)
	{
		if (condition) {
			out.println("Yes");
		}
		else {
			out.println("No");
		}
	}
	
	
	static int LowerBound(int a[], int x) 
	 { // x is the target value or key
	  int l=-1,r=a.length;
	  while(l+1<r) {
	    int m=(l+r)>>>1;
	    if(a[m]>=x) r=m;
	    else l=m;
	  }
	  return r;
	}
	
	
	static int lowerIndex(int arr[], int n, int x)
    {
        int l = 0, h = n - 1;
        while (l <= h)
        {
            int mid = (l + h) / 2;
            if (arr[mid] >= x)
                h = mid - 1;
            else
                l = mid + 1;
        }
        return l;
    }
	
	
	    // function to find last index <= y
    static int upperIndex(int arr[], int n, int y)
    {
        int l = 0, h = n - 1;
        while (l <= h)
        {
            int mid = (l + h) / 2;
            if (arr[mid] <= y)
                l = mid + 1;
            else
                h = mid - 1;
        }
        return h;
    }
    static int upperIndex(long arr[], int n, long y)
    {
    	int l = 0, h = n - 1;
    	while (l <= h)
    	{
    		int mid = (l + h) / 2;
    		if (arr[mid] <= y)
    			l = mid + 1;
    		else
    			h = mid - 1;
    	}
    	return h;
    }
     
	
	 static int UpperBound(int a[], int x)
	  {// x is the key or target value
	    int l=-1,r=a.length;
	    while(l+1<r) {
	       int m=(l+r)>>>1;
	       if(a[m]<=x) l=m;
	       else r=m;
	    }
	    return l+1;
	 }
	 static int UpperBound(long a[], long x)
	 {// x is the key or target value
		 int l=-1,r=a.length;
		 while(l+1<r) {
			 int m=(l+r)>>>1;
	       if(a[m]<=x) l=m;
	       else r=m;
		 }
		 return l+1;
	 }
	 
	 
	 
	 static class DisjointUnionSets
	 {
	    int[] rank, parent;
	    int n;
	    // Constructor
	    public DisjointUnionSets(int n)
	    {
	        rank = new int[n];
	        parent = new int[n];
	        this.n = n;
	        makeSet();
	    }
	    // Creates n sets with single item in each
	    void makeSet()
	    {
	        for (int i = 0; i < n; i++)
	            parent[i] = i;
	    }
	    int find(int x)
	    {
	        if (parent[x] != x) {
	            parent[x] = find(parent[x]);
	        }
	        return parent[x];
	    }
	    // Unites the set that includes x and the set
	    // that includes x
	    void union(int x, int y)
	    {
	        int xRoot = find(x), yRoot = find(y);
	        if (xRoot == yRoot)
	            return;
	        if (rank[xRoot] < rank[yRoot])
	            parent[xRoot] = yRoot;
	        else if (rank[yRoot] < rank[xRoot])
	         parent[yRoot] = xRoot;
	        else // if ranks are the same
	        {
	         parent[yRoot] = xRoot;
	            rank[xRoot] = rank[xRoot] + 1;
	        }
	        
//	        if(xRoot!=yRoot)
//	        	parent[y]=x;
	    }
	    
	    int connectedComponents()
	    {
	    	int cnt=0;
	    	for(int i=0;i<n;i++)
	    	{
	    		if(parent[i]==i)
	    			cnt++;
	    	}
	    	return cnt;
	    }
	 }

	 

	 
	 
	static class Graph
	  {
	        int v;
	        ArrayList<Integer> list[];
	        Graph(int v)
	        {
	            this.v=v;
	            list=new ArrayList[v+1];
	            for(int i=1;i<=v;i++)
	                list[i]=new ArrayList<Integer>();
	        }
	        void addEdge(int a, int b)
	        {
	            this.list[a].add(b);
	        }
	    }
	
	
	
//	static class GraphMap{
//		Map<String,ArrayList<String>> graph;
//		GraphMap() {
//			// TODO Auto-generated constructor stub
//			graph=new HashMap<String,ArrayList<String>>();
//			
//		}
//		void addEdge(String a,String b)
//		{
//			if(graph.containsKey(a))
//			this.graph.get(a).add(b);
//			else {
//				this.graph.put(a, new ArrayList<>());
//				this.graph.get(a).add(b);
//			}
//		}
//	}
//	static void dfsMap(GraphMap g,HashSet<String> vis,String src,int ok)
//	{
//		vis.add(src);
//		
//		if(g.graph.get(src)!=null)
//		{
//			for(String each:g.graph.get(src))
//			{
//				if(!vis.contains(each))
//				{
//					dfsMap(g, vis, each, ok+1);
//				}
//			}
//		}
//		
//		cnt=Math.max(cnt, ok);
//	}
	static double sum[];
	static long cnt;
	static void DFS(Graph g, boolean[] visited, int u)
		{
	        visited[u]=true;
	        
	        for(int i=0;i<g.list[u].size();i++)
	        {
	            int v=g.list[u].get(i);
	            
	            if(!visited[v])
	            {
	            	cnt=cnt*2;
	            	DFS(g, visited, v);
	            
	            }
	            
	        }
	       

	  } 
	
	
	  
	 static class Pair implements Comparable<Pair>
	    {
	       int x,y;
	       Pair(int x,int y)
	        {
	           this.x=x;
	           this.y=y;
	          
	        }
		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return this.x-o.x;
		}
	       
	       
	       
	    }
	   
	static long sum_array(int a[])
	 {
	    int n=a.length;
	    long sum=0;
	    for(int i=0;i<n;i++)
	     sum+=a[i];
	    return sum;
	 }
	static long sum_array(long a[])
	 {
	    int n=a.length;
	    long sum=0;
	    for(int i=0;i<n;i++)
	     sum+=a[i];
	    return sum;
	 }

	 static void sort(int[] a) 
	   {
			ArrayList<Integer> l=new ArrayList<>();
			for (int i:a) l.add(i);
			Collections.sort(l);
			for (int i=0; i<a.length; i++) a[i]=l.get(i);
		}
	static void sort(long[] a) 
	   {
			ArrayList<Long> l=new ArrayList<>();
			for (long i:a) l.add(i);
			Collections.sort(l);
			for (int i=0; i<a.length; i++) a[i]=l.get(i);
		}

	static void reverse_array(int a[])
	 {
	    int n=a.length;
	    int i,t; 
	    for (i = 0; i < n / 2; i++) { 
	            t = a[i]; 
	            a[i] = a[n - i - 1]; 
	            a[n - i - 1] = t; 
	        } 
	 }
	static void reverse_array(long a[])
	 {
	    int n=a.length;
	    int i; long t; 
	    for (i = 0; i < n / 2; i++) { 
	            t = a[i]; 
	            a[i] = a[n - i - 1]; 
	            a[n - i - 1] = t; 
	        } 
	 }
//	 static long modInverse(long a, long m)
//		    {
//		        long g = gcd(a, m);
//		       
//		          return   power(a, m - 2, m);
//		        
//		    }
	static long power(long x, long y)
	 {
	   long res = 1;
	   x = x % mod;
	   if (x == 0)
	     return 0;
	   while (y > 0)
	   {
	    if ((y & 1) != 0)
	    res = (res * x) % mod;
	   
	    y = y >> 1; // y = y/2
	    x = (x * x) % mod;
	   }
	   return res;
	 }
	static long gcd(long a, long b) 
	    { 
			
	        if (a == 0) 
	            return b; 
	         //cnt+=a/b;
	        return gcd(b%a,a); 
	    } 
	static int gcd(int a, int b) 
	    { 
	        if (a == 0) 
	            return b; 
	          
	        return gcd(b%a, a); 
	    } 

	   static class FastReader{
	 
	        byte[] buf = new byte[2048];
	        int index, total;
	        InputStream in;
	 
	        FastReader(InputStream is) {
	            in = is;
	        }
	 
	        int scan() throws IOException {
	            if (index >= total) {
	                index = 0;
	                total = in.read(buf);
	                if (total <= 0) {
	                    return -1;
	                }
	            }
	            return buf[index++];
	        }
	 
	        String next() throws IOException {
	            int c;
	            for (c = scan(); c <= 32; c = scan());
	            StringBuilder sb = new StringBuilder();
	            for (; c > 32; c = scan()) {
	                sb.append((char) c);
	            }
	            return sb.toString();
	        }
	 
	        int nextInt() throws IOException {
	            int c, val = 0;
	            for (c = scan(); c <= 32; c = scan());
	            boolean neg = c == '-';
	            if (c == '-' || c == '+') {
	                c = scan();
	            }
	            for (; c >= '0' && c <= '9'; c = scan()) {
	                val = (val << 3) + (val << 1) + (c & 15);
	            }
	            return neg ? -val : val;
	        }
	 
	        long nextLong() throws IOException {
	            int c;
	            long val = 0;
	            for (c = scan(); c <= 32; c = scan());
	            boolean neg = c == '-';
	            if (c == '-' || c == '+') {
	                c = scan();
	            }
	            for (; c >= '0' && c <= '9'; c = scan()) {
	                val = (val << 3) + (val << 1) + (c & 15);
	            }
	            return neg ? -val : val;
	        }
	    }
	   
	    static class Reader 
	    { 
	        final private int BUFFER_SIZE = 1 << 16; 
	        private DataInputStream din; 
	        private byte[] buffer; 
	        private int bufferPointer, bytesRead; 
	  
	        public Reader() 
	        { 
	            din = new DataInputStream(System.in); 
	            buffer = new byte[BUFFER_SIZE]; 
	            bufferPointer = bytesRead = 0; 
	        } 
	  
	        public Reader(String file_name) throws IOException 
	        { 
	            din = new DataInputStream(new FileInputStream(file_name)); 
	            buffer = new byte[BUFFER_SIZE]; 
	            bufferPointer = bytesRead = 0; 
	        } 
	  
	        public String readLine() throws IOException 
	        { 
	            byte[] buf = new byte[64]; // line length 
	            int cnt = 0, c; 
	            while ((c = read()) != -1) 
	            { 
	                if (c == '\n') 
	                    break; 
	                buf[cnt++] = (byte) c; 
	            } 
	            return new String(buf, 0, cnt); 
	        } 
	  
	        public int nextInt() throws IOException 
	        { 
	            int ret = 0; 
	            byte c = read(); 
	            while (c <= ' ') 
	                c = read(); 
	            boolean neg = (c == '-'); 
	            if (neg) 
	                c = read(); 
	            do
	            { 
	                ret = ret * 10 + c - '0'; 
	            }  while ((c = read()) >= '0' && c <= '9'); 
	  
	            if (neg) 
	                return -ret; 
	            return ret; 
	        } 
	  
	        public long nextLong() throws IOException 
	        { 
	            long ret = 0; 
	            byte c = read(); 
	            while (c <= ' ') 
	                c = read(); 
	            boolean neg = (c == '-'); 
	            if (neg) 
	                c = read(); 
	            do { 
	                ret = ret * 10 + c - '0'; 
	            } 
	            while ((c = read()) >= '0' && c <= '9'); 
	            if (neg) 
	                return -ret; 
	            return ret; 
	        } 
	  
	        public double nextDouble() throws IOException 
	        { 
	            double ret = 0, div = 1; 
	            byte c = read(); 
	            while (c <= ' ') 
	                c = read(); 
	            boolean neg = (c == '-'); 
	            if (neg) 
	                c = read(); 
	  
	            do { 
	                ret = ret * 10 + c - '0'; 
	            } 
	            while ((c = read()) >= '0' && c <= '9'); 
	  
	            if (c == '.') 
	            { 
	                while ((c = read()) >= '0' && c <= '9') 
	                { 
	                    ret += (c - '0') / (div *= 10); 
	                } 
	            } 
	  
	            if (neg) 
	                return -ret; 
	            return ret; 
	        } 
	  
	        private void fillBuffer() throws IOException 
	        { 
	            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE); 
	            if (bytesRead == -1) 
	                buffer[0] = -1; 
	        } 
	  
	        private byte read() throws IOException 
	        { 
	            if (bufferPointer == bytesRead) 
	                fillBuffer(); 
	            return buffer[bufferPointer++]; 
	        } 
	  
	        public void close() throws IOException 
	        { 
	            if (din == null) 
	                return; 
	            din.close(); 
	        } 
	    }
	  static  PrintWriter out=new PrintWriter(System.out);
	  static int int_max=Integer.MAX_VALUE;
	  static int int_min=Integer.MIN_VALUE;
	  static long long_max=Long.MAX_VALUE;
	  static long long_min=Long.MIN_VALUE;

}




