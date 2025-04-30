import java.io.*;
import java.util.*;


public class Practice
{
//	static final long mod=7420738134811L;
	static int mod=1000000007;
	static final int size=501;
	static FastReader sc=new FastReader(System.in);
//	static Reader sc=new Reader();
//	static Scanner sc=new Scanner(System.in);
	static  PrintWriter out=new PrintWriter(System.out);
	static long[] factorialNumInverse;
	static long[] naturalNumInverse;	
	static int[] sp;
	static long[] fact;
	static ArrayList<Integer> pr;
	public static void main(String[] args) throws IOException, CloneNotSupportedException
	{
//		System.setIn(new FileInputStream("input.txt"));
//		System.setOut(new PrintStream("output.txt"));
//		factorial(mod);
//		InverseofNumber(mod);
//		InverseofFactorial(mod);
//		make_seive();
		int t=1;
		t=sc.nextInt();
		for(int i=1;i<=t;i++)
			solve(i);
		out.close();
		out.flush();
//		System.out.flush();
//		System.exit(0);
	}
	
	static void solve(int CASENO) throws IOException, CloneNotSupportedException
	{
		int n=sc.nextInt();
		int k[]=new int[n];
		int h[]=new int[n];
		for(int i=0;i<n;i++)
			k[i]=sc.nextInt();
		for(int i=0;i<n;i++)
			h[i]=sc.nextInt();
		ArrayList<Pair> interval=new ArrayList<Pair>();
		ArrayList<Pair> act=new ArrayList<Pair>();
		for(int i=0;i<n;i++)
			interval.add(new Pair(k[i]-h[i]+1,k[i]));
		Collections.sort(interval);
//		out.println(interval);
		act.add(interval.get(0).clone());
		for(int i=1;i<n;i++)
		{
			Pair p=act.get(act.size()-1);
			if(p.y<interval.get(i).x)
				act.add(interval.get(i).clone());
			else
				p.y=Math.max(p.y, interval.get(i).y);
		}
//		out.println(act);
		long mana=0;
		for(Pair p: act)
		{
			long x=p.y-p.x+1;
			mana+=(x*(x+1))/2;
		}
		out.println(mana);
	}
	static class Pair implements Cloneable, Comparable<Pair>
	{
		int x,y;
		Pair(int a,int b)
		{
			this.x=a;
			this.y=b;
		}
		@Override
		public boolean equals(Object obj) 
		{
			if(obj instanceof  Pair)
			{
				Pair p=(Pair)obj;
				return p.x==this.x && p.y==this.y;
			}
			return false;
		}
		@Override
		public int hashCode() 
		{
			return Math.abs(x)+500*Math.abs(y);
		}
		@Override
		public String toString() 
		{
			return "("+x+" "+y+")";
		}
		@Override
		protected Pair clone() throws CloneNotSupportedException {
			return new Pair(this.x,this.y);
		}
		@Override
		public int compareTo(Pair a) 
		{
			long t=(this.x-a.x);
			if(t!=0)
				return t>0?1:-1;
			else
				return (int)(this.y-a.y);
		}
		public void swap()
		{
			this.y=this.y+this.x;
			this.x=this.y-this.x;
			this.y=this.y-this.x;			
		}
	}
	static class Tuple implements Cloneable, Comparable<Tuple>
	{
		int x,y,z;
		Tuple(int a,int b,int c)
		{
			this.x=a;
			this.y=b;
			this.z=c;
		}
		public boolean equals(Object obj) 
		{
			if(obj instanceof  Tuple)
			{
				Tuple p=(Tuple)obj;
				return p.x==this.x && p.y==this.y && p.z==this.z;
			}
			return false;
		}
		@Override
		public int hashCode() 
		{
			return (this.x+501*this.y);
		}
		@Override
		public String toString() 
		{
			return "("+x+","+y+","+z+")";
		}
		@Override
		protected Tuple clone() throws CloneNotSupportedException {
			return new Tuple(this.x,this.y,this.z);
		}
		@Override
		public int compareTo(Tuple a) 
		{
			int x=this.z-a.z;
			if(x!=0)
				return x;
			int X= this.x-a.x;
			if(X!=0)
				return X;
			return a.y-this.y;
		}
	}
	static void arraySort(int arr[])
	{
		ArrayList<Integer> a=new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			a.add(arr[i]);
		}
		Collections.sort(a,Comparator.reverseOrder());
		for (int i = 0; i < arr.length; i++) {
			arr[i]=a.get(i);
		}
	}
	static void arraySort(long arr[])
	{
		ArrayList<Long> a=new ArrayList<Long>();
		for (int i = 0; i < arr.length; i++) {
			a.add(arr[i]);
		}
		Collections.sort(a);
		for (int i = 0; i < arr.length; i++) {
			arr[i]=a.get(i);
		}
	}
	static HashSet<Integer> primeFactors(int n)
	{
		HashSet<Integer> ans=new HashSet<Integer>();
		if(n%2==0)
		{
			ans.add(2);
			while((n&1)==0)
				n=n>>1;
		}
		for(int i=3;i*i<=n;i+=2)
		{
			if(n%i==0)
			{
				ans.add(i);
				while(n%i==0)
					n=n/i;
			}
		}
		if(n!=1)
			ans.add(n);
		return ans;
	}
	static void make_seive()
	{
		sp=new int[size];
		pr=new ArrayList<Integer>();
		for (int i=2; i<size; ++i) {
		    if (sp[i] == 0) {
		        sp[i] = i;
		        pr.add(i);
		    }
		    for (int j=0; j<(int)pr.size() && pr.get(j)<=sp[i] && i*pr.get(j)<size; ++j)
		        sp[i * pr.get(j)] = pr.get(j);
		}
	}
	public static void InverseofNumber(int p)
	{
		naturalNumInverse=new long[size];
	    naturalNumInverse[0] = naturalNumInverse[1] = 1;
	    for(int i = 2; i < size; i++)
	        naturalNumInverse[i] = naturalNumInverse[p % i] * (long)(p - p / i) % p;
	}
	// Function to precompute inverse of factorials
	public static void InverseofFactorial(int p)
	{
		factorialNumInverse=new long[size];
	    factorialNumInverse[0] = factorialNumInverse[1] = 1;
	    // pre-compute inverse of natural numbers
	    for(int i = 2; i < size; i++)
	        factorialNumInverse[i] = (naturalNumInverse[i] * factorialNumInverse[i - 1]) % p;
	}
	// Function to calculate factorial of 1 to 200001
	public static void factorial(int p)
	{
		fact=new long[size];
	    fact[0] = 1;
	    for(int i = 1; i < size; i++)
	        fact[i] = (fact[i - 1] * (long)i) % p;
	}
	 
	// Function to return nCr % p in O(1) time
	public static long Binomial(int N, int R)
	{
		if(R<0)
			return 1;
	    // n C r = n!*inverse(r!)*inverse((n-r)!)
	    long ans = ((fact[N] * factorialNumInverse[R]) % mod * factorialNumInverse[N - R]) % mod;
	    return ans;
	}
	static int findXOR(int x)	//from 0 to x
	{
		if(x<0)
			return 0;
		if(x%4==0)
			return x;
		if(x%4==1)
			return 1;
		if(x%4==2)
			return x+1;
		return 0;
	}
	static boolean isPrime(long x)
	{
		if(x==1)
			return false;
		if(x<=3)
			return true;
		if(x%2==0 || x%3==0)
			return false;
		for(int i=5;i<=Math.sqrt(x);i+=2)
			if(x%i==0)
				return false;
		return true;
	}
	static long gcd(long a,long b)
	{
		return (b==0)?a:gcd(b,a%b);
	}
	static int gcd(int a,int b)
	{
		return (b==0)?a:gcd(b,a%b);
	}
	static class Node
	{
		int vertex,dis;
		HashSet<Node> adj;
		Node(int ver)
		{
			vertex=ver;
			dis=-1;
			adj=new HashSet<Node>();
		}
		@Override
		public String toString() 
		{
			return vertex+" ";
		}
	}
	static class Edge
	{
		Node to;
		int cost;
		Edge(Node t,int c)
		{
			this.to=t;
			this.cost=c;
		}
		@Override
		public String toString() {
			return "("+to.vertex+","+cost+") ";
		}
	}
	static long power(long x, long y)
	  {
		if(x<=0)
			return 1;
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
	    return res%mod;
	  }
	static long binomialCoeff(long n, long k)
    {
		if(n<k)
			return 0;
        long res = 1;
        // Since C(n, k) = C(n, n-k)
        if (k > n - k)
            k = n - k;
 
        // Calculate value of
        // [n * (n-1) *---* (n-k+1)] / [k * (k-1) *----* 1]
        for (long i = 0; i < k; ++i) {
            res *= (n - i);
            res /= (i + 1);
        }
 
        return res;
    }
	static class FastReader
	{
        byte[] buf = new byte[2048];
        int index, total;
        InputStream in;
 
        FastReader(InputStream is) 
        {
            in = is;
        }
 
        int scan() throws IOException 
        {
            if (index >= total) {
                index = 0;
                total = in.read(buf);
                if (total <= 0) {
                    return -1;
                }
            }
            return buf[index++];
        }
 
        String next() throws IOException 
        {
            int c;
            for (c = scan(); c <= 32; c = scan());
            StringBuilder sb = new StringBuilder();
            for (; c > 32; c = scan()) {
                sb.append((char) c);
            }
            return sb.toString();
        }
 
        int nextInt() throws IOException 
        {
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
 
        long nextLong() throws IOException 
        {
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
            din = new DataInputStream(
                new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    }
                    else {
                        continue;
                    }
                }
                buf[cnt++] = (byte)c;
            }
            return new String(buf, 0, cnt);
        }
 
        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
 
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
            } while ((c = read()) >= '0' && c <= '9');
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
            } while ((c = read()) >= '0' && c <= '9');
 
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }
 
            if (neg)
                return -ret;
            return ret;
        }
 
        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0,
                                 BUFFER_SIZE);
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
        public void printarray(int arr[])
        {
        	for (int i = 0; i < arr.length; i++)
				System.out.print(arr[i]+" ");
        	System.out.println();
        }
    }
}







