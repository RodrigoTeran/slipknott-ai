		/*
		TO LEARN
		1-segment trees
		2-euler tour
		3-fenwick tree and interval tree
		*/
		/*
		TO SOLVE 
		uva 1103
		program codeforces edu 102 D
		*/
		/*
		bit manipulation shit
		1-Computer Systems: A Programmer's Perspective
		2-hacker's delight
		3-(02-03-bits-ints)
		4-machine-basics
		5-Bits Manipulation tutorialspoint
		*/
		/*
		TO WATCH
		1-what is bitmasking by kartik arora youtube

		*/
		            import java.util.*;
				    import java.math.*;
				    import java.io.*; 
				    import java.util.concurrent.ThreadLocalRandom;
				    import java.util.stream.Collectors;

				     public class A{
				     
				  static InputStream inputStream = System.in;
		            static FastScanner scan=new FastScanner();
		          

				   
				     public static PrintWriter out = new PrintWriter (new BufferedOutputStream(System.out));
	 static boolean vis[]=new boolean[26];
	 static LinkedList<Integer>edges[];
	 static int cnt=0;
	 static ArrayList<Integer>arr=new ArrayList();
	 static void dfs(int c,boolean vis2[])
	 {
	 	vis[c]=true;
	 //	vis2[c]=true;
	 	arr.add(c);
	 	for(int v:edges[c])
	 	{
	 		

	 		if(!vis[v])
	 		{
	 			
	 			dfs(v,vis2);
	 		}
	 	}
	 }

			public static void main(String[] args)  throws Exception 
		      {
			
				//	scan=new FastScanner("lifeguards.in");
				//out = new PrintWriter("lifeguards.out");
				 
				 /*
				 currently doing 
				 1-digit dp
				 2-ds like fenwick and interval tree and sparse table 
				 */
				 /*
				 READING 
				 1-Everything About Dynamic Programming codeforces
				 2-DYNAMIC PROGRAMMING: FROM NOVICE TO ADVANCED topcoder
				 3-Introduction to DP with Bitmasking codefoces
				 4-Bit Manipulation hackerearth 
				 */


				    int tt=1;
				 
		

				     


	//System.out.println(2&0);
	/*for(int i=0;i<=70;i++)
		for(int j=0;j<=70;j++){
			if((i&j)==i)
			System.out.println(i+" "+j+" "+(i&j));
		}*/
		//System.out.println(1^14);
		//System.out.println(15&6);

	tt=scan.nextInt();
			 	    
			 outer:while(tt-->0)
				    {
				    	int l=scan.nextInt(),n=scan.nextInt();
				    	int arr[]=new int[n];
				    	long t[]=new long[n];
				    	int pos[]=new int[l+1];
				    	Arrays.fill(pos,-1);
				    	TreeSet<Integer>tree=new TreeSet<Integer>();
				    	for(int i=0;i<n;i++){
				    		arr[i]=scan.nextInt();
				    		tree.add(arr[i]);
				    		pos[arr[i]]=i;
				    	}
				    	
				    		for(int i=0;i<n;i++)
				    		t[i]=scan.nextLong();
				    	long L[]=new long[l+5];
				    	long R[]=new long[l+5];
				    	Arrays.fill(L,Integer.MAX_VALUE);
				    	Arrays.fill(R,Integer.MAX_VALUE);
				    	for(int i=1;i<=l;i++)
				    	{
				    		if(pos[i]!=-1)
				    		{
				    			L[i]=t[pos[i]];
				    		}
				    		L[i]=Math.min(L[i],L[i-1]+1);
				    	}
				    		for(int i=l;i>=1;i--)
				    	{
				    		if(pos[i]!=-1)
				    		{
				    			R[i]=t[pos[i]];
				    		}
				    		R[i]=Math.min(R[i],R[i+1]+1);
				    	}
				    	for(int i=1;i<=l;i++)
				    		out.print(Math.min(L[i],R[i])+" ");

out.println();
				    
				    
		           

		            }

				  	    out.close();
		 		  
				   
				}
				static class special{
					long x1,y1,x2,y2;
					//int id;
					special(long x1,long y1,long x2,long y2)
					{
						this.x1=x1;
						this.y1=y1;
						this.x2=x2;
						this.y2=y2;
						//this.id=id;
					}
					@Override
					    public int hashCode() {
				                int hash = 7;
	    hash = 31 * hash + (int) x1;
	    hash = 31 * hash + (int)x2;
	    hash = 31 * hash + (int)y1;
	    hash = 31 * hash + (int)y2;
	    return hash;
				            }
				              @Override
				            public boolean equals(Object o){
				                if (o == this) return true;
				                if (o.getClass() != getClass()) return false;
				                special t = (special)o;
				                return t.x1 == x1 && t.y1 == y1&&t.x2==x2&&t.y2==y2;
				            }
				}

				   
				     static long binexp(long a,long n)
				    {
				        if(n==0)
				            return 1;
				        long res=binexp(a,n/2);
				        if(n%2==1)
				            return res*res*a;
				        else 
				            return res*res;
				    }
				     
				    static long powMod(long base, long exp, long mod) {
				           if (base == 0 || base == 1) return base;
				           if (exp == 0) return 1;
				           if (exp == 1) return (base % mod+mod)%mod;
				           long R = (powMod(base, exp/2, mod) % mod+mod)%mod;
				           R *= R;
				           R %= mod;
				           if ((exp & 1) == 1) {
				               return (base * R % mod+mod)%mod;
				           }
				           else return (R %mod+mod)%mod;
				       }
				    static double dis(double x1,double y1,double x2,double y2)
				    {
				        return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
				    }
				    static long mod(long x,long y)
				        {
				            if(x<0)
				                x=x+(-x/y+1)*y;
				            return x%y;
				        }
				     public static  long pow(long b, long e) {
				                long r = 1;
				                while (e > 0) {
				                    if (e % 2 == 1) r = r * b ;
				                    b = b * b;
				                    e >>= 1;
				                }
				                return r;
				            }
				    private static void sort(long[] arr) {
				            List<Long> list = new ArrayList<>();
				            for (long object : arr) list.add(object);
				            Collections.sort(list);
				        //Collections.reverse(list);
				            for (int i = 0; i < list.size(); ++i) arr[i] = list.get(i);
				        }
				    private static void sort2(long[] arr) {
				            List<Long> list = new ArrayList<>();
				            for (Long object : arr) list.add(object);
				            Collections.sort(list);
				        Collections.reverse(list);
				            for (int i = 0; i < list.size(); ++i) arr[i] = list.get(i);
				        }
				     static class FastScanner
		{
		    private int BS = 1 << 16;
		    private char NC = (char) 0;
		    private byte[] buf = new byte[BS];
		    private int bId = 0, size = 0;
		    private char c = NC;
		    private double cnt = 1;
		    private BufferedInputStream in;
		 
		    public FastScanner() {
		        in = new BufferedInputStream(System.in, BS);
		    }
		 
		    public FastScanner(String s) {
		        try {
		            in = new BufferedInputStream(new FileInputStream(new File(s)), BS);
		        } catch (Exception e) {
		            in = new BufferedInputStream(System.in, BS);
		        }
		    }
		 
		    private char getChar() {
		        while (bId == size) {
		            try {
		                size = in.read(buf);
		            } catch (Exception e) {
		                return NC;
		            }
		            if (size == -1) return NC;
		            bId = 0;
		        }
		        return (char) buf[bId++];
		    }
		 
		    public int nextInt() {
		        return (int) nextLong();
		    }
		 
		    public int[] nextInts(int N) {
		        int[] res = new int[N];
		        for (int i = 0; i < N; i++) {
		            res[i] = (int) nextLong();
		        }
		        return res;
		    }
		 
		    public long[] nextLongs(int N) {
		        long[] res = new long[N];
		        for (int i = 0; i < N; i++) {
		            res[i] = nextLong();
		        }
		        return res;
		    }
		 
		    public long nextLong() {
		        cnt = 1;
		        boolean neg = false;
		        if (c == NC) c = getChar();
		        for (; (c < '0' || c > '9'); c = getChar()) {
		            if (c == '-') neg = true;
		        }
		        long res = 0;
		        for (; c >= '0' && c <= '9'; c = getChar()) {
		            res = (res << 3) + (res << 1) + c - '0';
		            cnt *= 10;
		        }
		        return neg ? -res : res;
		    }
		 
		    public double nextDouble() {
		        double cur = nextLong();
		        return c != '.' ? cur : cur + nextLong() / cnt;
		    }
		 
		    public double[] nextDoubles(int N) {
		        double[] res = new double[N];
		        for (int i = 0; i < N; i++) {
		            res[i] = nextDouble();
		        }
		        return res;
		    }
		 
		    public String next() {
		        StringBuilder res = new StringBuilder();
		        while (c <= 32) c = getChar();
		        while (c > 32) {
		            res.append(c);
		            c = getChar();
		        }
		        return res.toString();
		    }
		 
		    public String nextLine() {
		        StringBuilder res = new StringBuilder();
		        while (c <= 32) c = getChar();
		        while (c != '\n') {
		            res.append(c);
		            c = getChar();
		        }
		        return res.toString();
		    }
		 
		    public boolean hasNext() {
		        if (c > 32) return true;
		        while (true) {
		            c = getChar();
		            if (c == NC) return false;
		            else if (c > 32) return true;
		        }
		    }
		}

				     static class Pair implements Comparable<Pair>{
				            public long x, y,z;
				            public Pair(long x1, long y1,long z1) {
				                x=x1;
				                y=y1;
				                z=z1;
				            }
				             public Pair(long x1, long y1) {
				                x=x1;
				                y=y1;
				    
				            }
				            
				            @Override
				            public int hashCode() {
				                return (int)(x + 31 * y);
				            }
				            public String toString() {
				                return x + " " + y+" "+z;
				            }
				            @Override
				            public boolean equals(Object o){
				                if (o == this) return true;
				                if (o.getClass() != getClass()) return false;
				                Pair t = (Pair)o;
				                return t.x == x && t.y == y&&t.z==z;
				            }
				    public int compareTo(Pair o)
				    {
				    
				    	return (int)(x-o.x);
				     
				        }
				     
				    }
				    
				    }

				     
