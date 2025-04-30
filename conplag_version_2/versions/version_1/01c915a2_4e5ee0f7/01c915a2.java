			/*
			TO LEARN
			1-segment trees
			2-euler tour
		
			*/
			/*
			TO SOLVE 
			uva 1103
			codeforces 722 kavi on pairing duty
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
					    import java.util.stream.Collectors;

					       public class A{
					     
					  static InputStream inputStream = System.in;
			            static FastScanner scan=new FastScanner();
					     public static PrintWriter out = new PrintWriter (new BufferedOutputStream(System.out));
	static final long p=29;
	static final long mod=(long)1e9+9;
	static int n,m;
	static String spotty[],plain[];
	static boolean check(int l)
	{
		 Map<Long,Set<Pair>>hashes=new HashMap<Long,Set<Pair>>();
					    HashSet<Long>hashes2=new HashSet<Long>();
					    long pow_p[]=new long[m];
					    pow_p[0]=1;
					    for(int i=1;i<m;i++)
					    	pow_p[i]=(pow_p[i-1]*p);
					    for(int i=0;i<n;i++)
					    {
					    	String s=plain[i];
					    	long h[]=new long[m+1];
					    	for(int j=0;j<m;j++)
					    	{
					    		h[j+1]=(h[j]+(s.charAt(j)-'a'+1)*pow_p[j]);
					    	}
					    	
					    		for(int j=0;j<=m-l;j++)
					    		{
					    			long cur_h=(h[j+l]-h[j]);
					    			cur_h=(cur_h*pow_p[m-j-1]);
					    			if(hashes.containsKey(cur_h))
					    				hashes.get(cur_h).add(new Pair(j,j+l));
					    			else 
					    			{
					    				hashes.put(cur_h,new HashSet());
					    				hashes.get(cur_h).add(new Pair(j,j+l));
					    			}
					    			//map.getOrDefault(cur_h,new ArrayList()).add(new Pair(j,j+1));
					    			//hashes.put(cur_h,);
					    		//	out.println("FIR "+cur_h);
					    		}				    	
					    }

					        for(int i=0;i<n;i++)
					    {
					    	String s=spotty[i];
					    	long h[]=new long[m+1];
					    	for(int j=0;j<m;j++)
					    	{
					    		h[j+1]=(h[j]+(s.charAt(j)-'a'+1)*pow_p[j]);
					    	}
					    	
					    		for(int j=0;j<=m-l;j++)
					    		{
					    			long cur_h=(h[j+l]-h[j]);
					    			cur_h=(cur_h*pow_p[m-j-1]);

					    			if(hashes.containsKey(cur_h)){
					    				if(!hashes.get(cur_h).contains(new Pair(j,j+l)))
					    					return true;
					    			}
					    			else{
					    				out.println(j+" "+i);
					    			 return true;
					    			}
					    		
					    		}
					    	
					    }	
					    return false;
	}

				public static void main(String[] args)  throws Exception 
			      {
				
						///scan=new FastScanner("cownomics.in");
					//out = new PrintWriter("cownomics.out");
					 
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
					 5-read more about mobious and inculsion-exclusion 
					 */
		



					    int tt=1;
					tt=scan.nextInt();
					int T=tt;
					/*Map<Integer,Pair>map=new HashMap<Integer,Pair>();
					for(int i=1;i<=333333334;i++)
					{
						map.put(i+2*i,new Pair(i,2*i));
						map.put(i+(2*(i+1)),new Pair(i,i+1));
						map.put(i+1+(2*i),new Pair(i+1,i));
					}*/

				 outer:while(tt-->0)
					    {
					    int n=scan.nextInt();
					   int cnt[][]=new int[n][5];
					   String arr[]=new String[n];
					   int sumlens=0;
					   for(int i=0;i<n;i++)
					   {
					   	String s=scan.next();
					   	sumlens+=s.length();
					   	arr[i]=s;
					   	for(int j=0;j<s.length();j++)
					   		cnt[i][s.charAt(j)-'a']++;
					   }
					   int res=0;
					   for(int to=0;to<5;to++)
					   {
					   	ArrayList<Pair>tmp=new ArrayList<Pair>();
					   	int sumall=0;
					   	for(int i=0;i<n;i++)
					   		sumall+=cnt[i][to];
					   	for(int i=0;i<n;i++)
					   	{
					   		int sum=0;
					   		for(int j=0;j<5;j++)
					   		{
					   			if(j!=to)
					   			{
					   				sum+=cnt[i][j];
					   			}
					   		}
					   		tmp.add(new Pair(arr[i].length()-sum,sum));
					   	}
					   	Collections.sort(tmp);
					   	int THIS=sumall,THAT=sumlens-sumall;
					   	//if(to==3)
					  // 		out.println(tmp);
					   	for(int i=0;i<tmp.size();i++)
					   	{
					   		if(THIS>THAT)
					   		{
					   		//	if(to==3)
					   		//		out.println("AHA "+(n-i));
					   			res=Math.max(res,n-i);
					   			break;
					   		}
					   		THIS-=tmp.get(i).x;
					   		THAT-=tmp.get(i).y;
					   	}
					   }
					   out.println(res);
					   
					    

					   

					   
					    	
					    	
			}
			   out.close();
		}
		  	 
			 		  
					   
					
					static class special{
						boolean bool;
						int n;
						//int id;
						special(boolean bool,int n)
						{
							this.bool=bool;
							this.n=n;
						}
						@Override
						    public int hashCode() {
					                int hash = 7;
		    hash = 31 * hash + (int) n;
		   
		    return hash;
					            }
					              @Override
					            public boolean equals(Object o){
					                if (o == this) return true;
					                if (o.getClass() != getClass()) return false;
					                special t = (special)o;
					                return t.bool == bool && t.n == n;
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
					    	
					    
					    	return (int)((o.y-o.x)-(y-x));
					     
					        }
					     
					    }
					    
					    }

					     
