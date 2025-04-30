import java.io.*;
import java.util.*;



import java.math.*;
import java.math.BigInteger;


public final class A
{    
	static PrintWriter out = new PrintWriter(System.out); 
	static StringBuilder ans=new StringBuilder();
	static FastReader in=new FastReader();
	static ArrayList<Integer> g[];
	static long mod=(long)1e9+7,INF=Long.MAX_VALUE;
	static boolean set[],col[]; 
	static int par[],tot[],partial[];
	static int D[],P[][];
	static long dp[][],sum=0,max=0,size[];
	//	static node1 seg[];
	//static pair moves[]= {new pair(-1,0),new pair(1,0), new pair(0,-1), new pair(0,1)};
	public static void main(String args[])throws IOException
	{				


	
		int T=i();
		outer:while(T-->0)
		{
			int N=i();
			int size[]=new int[N];
			PriorityQueue<node1> q[]=new PriorityQueue[26];
			for(int i=0; i<26; i++)q[i]=new PriorityQueue<node1>();
			for(int i=0; i<N; i++)
			{
				char X[]=in.next().toCharArray();
				int s=X.length;
				size[i]=s;
				int f[]=new int[26];
				for(char x:X)f[x-'a']++;
				for(int j=0; j<26; j++)q[j].add(new node1(f[j],i,s));
			}
			
			int max=0;
			for(int i=0; i<26; i++)
			{
				PriorityQueue<node1> q_new=new PriorityQueue<>();
				q_new=q[i];
				int c=0;
				long f=0;
				while(q_new.size()>0)
				{
					node1 x=q_new.remove();
//					System.out.println(x.f+" "+x.size+" "+x.a);
					f+=x.a;
					if(f>0)
					{
						c++;
						max=Math.max(max, c);
					}
					else break;
				}
			}
			out.println(max);
		}
		out.close();

	}
	static int OR(int i,int j)
	{
		if(i>j)
		{
			int t=i;
			i=j;
			j=t;
		}
		System.out.println("OR "+i+" "+j);
		return i();
	}
	static int AND(int i,int j)
	{
		if(i>j)
		{
			int t=i;
			i=j;
			j=t;
		}
		System.out.println("AND "+i+" "+j);
		return i();
	}
	static int XOR(int i,int j)
	{
		if(i>j)
		{
			int t=i;
			i=j;
			j=t;
		}
		System.out.println("XOR "+i+" "+j);
		return i();
	}

	static boolean f1(int l,char X[])
	{
		int i=0;
		for(; l<X.length; l++)
		{
			if(X[i]!=X[l])return false;
			i++;
		}
		return true;
	}
	static int f(int a)
	{
		for(int i=a+1; a>0; a++)
		{
			if(GCD(i,a)==1)return i;
		}
		return 0;
	}
	static int min(char X[],char str[],int N)
	{
		int s=0;
		for(int i=0; i<N; i++)
		{
			int it=i%3;
			if(X[i]!=str[it])s++;
			//             ans.append(str[it]);
		}
		return s;
	}
	static char f(int i,char X[])
	{
		int a=0,b=0,c=0;
		for(; i<X.length; i+=3)
		{
			if(X[i]=='R')a++;
			if(X[i]=='B')b++;
			if(X[i]=='G')c++;
		}
		if(a>=b && a>=c)return 'R';
		if(b>=a && b>=c)return 'B';
		return 'G';
	}


	static void f1(int n,int p,long sum,int N)
	{
		for(int c:g[n])
		{
			if(c==p)continue;

			long s=sum+N-2*size[c];
			f1(c,n,s,N);
			max=Math.max(max, s);
		}
	}
	static long f(int i,int j,ArrayList<Integer> A)
	{

		if(i+1==A.size())
		{
			return j;
		}		
		int moves=1+A.get(i);
		if(j==1)return 1+f(i+1,moves,A);
		if(j>0 && dp[i][j-1]==0)f(i,j-1,A);
		return dp[i][j]=dp[i][j-1]+f(i+1,j+moves,A);
	}
	//	static void build(int v,int tl,int tr,long A[])
	//	{
	//		if(tl==tr)
	//		{
	//			seg[v]=new node1(A[tl],A[tr],1,true);
	//			return ;
	//		}
	//		int tm=(tl+tr)/2;
	//		build(2*v,tl,tm,A);
	//		build(2*v+1,tm+1,tr,A);
	//		seg[v]=merge(seg[2*v],seg[2*v+1]);
	//	}
	//	static node1 ask(int v,int tl,int tr,int l,int r)
	//	{
	//		if(l>r)return new node1(0,0,0,false);//verify true or false
	//		if(tl==l && tr==r)return seg[v];
	//		int tm=(tl+tr)/2;
	//		node1 a=ask(v*2,tl,tm,l,Math.min(tm, r));
	//		node1 b=ask(v*2+1,tm+1,tr,Math.max(tm+1, l),r);
	//		return merge(a,b);
	//	}
	//	static node1 merge(node1 a,node1 b)
	//	{
	//		long s=0;
	//		long l1=a.L,r1=a.R,c1=a.cnt;
	//		long l2=b.L,r2=b.R,c2=b.cnt;
	//		long g=GCD(l2,r1); s=c1+c2;
	//		if(g==1)
	//		{
	//			s--;
	//			g=(l2*r1)/g;
	//			if(c1==1)
	//			{
	//				l1=g;
	//			}
	//			if(c2==1)r2=g;
	//			return new node1(l1,r2,s,true);
	//		}
	//		return new node1(l1,r2,s,a.leaf^b.leaf);
	//	}
	static long f(long l,long r,long a,long b,long N)
	{
		while(r-l>1)
		{
			long m=(l+r)/2;
			long x=m*b;
			if(N<x)
			{
				r=m;
				continue;
			}
			if((N-x)%a==0)r=m;
			else l=m;

		}
		return r;
	}
	static long f1(long a,long A[],long bits[],long sum)
	{
		long s=A.length;
		s=mul(s,a);
		s=(s+(sum%mod))%mod;
		long p=1L;
		for(long x:bits)
		{
			if((a&p)!=0)s=((s-mul(x,p))+mod)%mod;
			p<<=1;
		}
		return s;
	}
	static long f2(long a,long A[],long bits[])
	{
		long s=0;
		long p=1L;
		for(long x:bits)
		{
			if((a&p)!=0)
			{
				s=(s+mul(p,x))%mod;
			}
			p<<=1;
		}
		return s;
	}
	static long f(long x1,long y1,long x2,long y2)
	{
		return Math.abs(x1-x2)+Math.abs(y1-y2);
	}
	static long f(long x,long max,long s)
	{
		long l=-1,r=(x/s)+1;
		while(r-l>1)
		{
			long m=(l+r)/2;
			if(x-m*s>max)l=m;
			else r=m;
		}
		return l+1;
	}
	static int f(long A[],long x)
	{
		int l=-1,r=A.length;
		while(r-l>1)
		{
			int m=(l+r)/2;
			if(A[m]>=x)r=m;
			else l=m;			
		}
		return r;
	}



	static int bin(int x,ArrayList<Integer> A)
	{
		int l=0,r=A.size()-1;
		while(l<=r)
		{
			int m=(l+r)/2;
			int a=A.get(m);
			if(a==x)return m;
			if(a<x)l=m+1;
			else r=m-1;
		}
		return 0;
	}
	static int left(int x,ArrayList<Integer> A)
	{
		int l=-1,r=A.size();
		while(r-l>1)
		{
			int m=(l+r)/2;
			int a=A.get(m);
			if(a<=x)l=m;
			else r=m;
		}
		return l;
	}
	static int right(int x,ArrayList<Integer> A)
	{
		int l=-1,r=A.size();
		while(r-l>1)
		{
			int m=(l+r)/2;
			int a=A.get(m);
			if(a<x)l=m;
			else r=m;
		}
		return r;
	}



	static boolean equal(long A[],long B[])
	{
		for(int i=0; i<A.length; i++)if(A[i]!=B[i])return false;
		return true;	
	}


	static int max(int a ,int b,int c,int d)
	{
		a=Math.max(a, b);
		c=Math.max(c,d);
		return Math.max(a, c);
	}
	static int min(int a ,int b,int c,int d)
	{
		a=Math.min(a, b);
		c=Math.min(c,d);
		return Math.min(a, c);
	}



	static HashMap<Integer,Integer> Hash(int A[])
	{
		HashMap<Integer,Integer> mp=new HashMap<>();
		for(int a:A)
		{
			int f=mp.getOrDefault(a,0)+1;
			mp.put(a, f);
		}
		return mp;
	}
	static long mul(long a, long b)
	{
		return ( a %mod * 1L * b%mod )%mod;
	}
	static void swap(int A[],int a,int b)
	{
		int t=A[a];
		A[a]=A[b];
		A[b]=t;
	}


	static int find(int a)
	{
		if(par[a]<0)return a;
		return par[a]=find(par[a]);
	}
	static void union(int a,int b)
	{
		a=find(a);
		b=find(b);
		if(a!=b)
		{
			par[a]+=par[b];
			par[b]=a;
		}
	}
	static boolean isSorted(int A[])
	{
		for(int i=1; i<A.length; i++)
		{
			if(A[i]<A[i-1])return false;
		}
		return true;
	}

	static boolean isDivisible(StringBuilder X,int i,long num)
	{
		long r=0;
		for(; i<X.length(); i++)
		{
			r=r*10+(X.charAt(i)-'0');
			r=r%num;
		}
		return r==0;
	}    



	static int lower_Bound(int A[],int low,int high, int x) 
	{ 
		if (low > high) 
			if (x >= A[high]) 
				return A[high]; 

		int mid = (low + high) / 2; 

		if (A[mid] == x) 
			return A[mid]; 

		if (mid > 0 && A[mid - 1] <= x && x < A[mid]) 
			return A[mid - 1]; 

		if (x < A[mid]) 
			return lower_Bound( A, low, mid - 1, x); 

		return lower_Bound(A, mid + 1, high, x); 
	} 

	static String f(String A)
	{
		String X="";
		for(int i=A.length()-1; i>=0; i--)
		{
			int c=A.charAt(i)-'0';
			X+=(c+1)%2;
		}
		return X;
	}

	static void sort(long[] a) //check for long
	{
		ArrayList<Long> l=new ArrayList<>();
		for (long i:a) l.add(i);
		Collections.sort(l);
		for (int i=0; i<a.length; i++) a[i]=l.get(i);
	}

	static String swap(String X,int i,int j)
	{
		char ch[]=X.toCharArray();
		char a=ch[i];
		ch[i]=ch[j];
		ch[j]=a;
		return new String(ch);
	}

	static int sD(long n)  
	{  

		if (n % 2 == 0 )  
			return 2;  

		for (int i = 3; i * i <= n; i += 2) {  
			if (n % i == 0 )  
				return i;  
		}  

		return (int)n;  
	}  

	static void setGraph(int N)
	{
		tot=new int[N+1];
		partial=new int[N+1];
		D=new int[N+1];
		P=new int[N+1][(int)(Math.log(N)+10)];
		set=new boolean[N+1];
		g=new ArrayList[N+1];
		for(int i=0; i<=N; i++)
		{

			g[i]=new ArrayList<>();		
			D[i]=Integer.MAX_VALUE;
			//D2[i]=INF;
		}
	}



	static  long pow(long a,long b)
	{
		//long mod=1000000007;
		long pow=1;
		long x=a;
		while(b!=0)
		{
			if((b&1)!=0)pow=(pow*x)%mod;
			x=(x*x)%mod;
			b/=2;
		}
		return pow;
	}

	static long toggleBits(long x)//one's complement || Toggle bits
	{
		int n=(int)(Math.floor(Math.log(x)/Math.log(2)))+1;

		return ((1<<n)-1)^x;
	}

	static int countBits(long a)
	{
		return (int)(Math.log(a)/Math.log(2)+1);
	}

	static long fact(long N)
	{ 
		long n=2; 
		if(N<=1)return 1;
		else
		{
			for(int i=3; i<=N; i++)n=(n*i)%mod;
		}
		return n;
	}

	static int kadane(int A[])
	{
		int lsum=A[0],gsum=A[0];
		for(int i=1; i<A.length; i++)
		{
			lsum=Math.max(lsum+A[i],A[i]);
			gsum=Math.max(gsum,lsum);
		}
		return gsum;
	}

	static void sort(int[] a) {
		ArrayList<Integer> l=new ArrayList<>();
		for (int i:a) l.add(i);
		Collections.sort(l);
		for (int i=0; i<a.length; i++) a[i]=l.get(i);
	}

	static boolean isPrime(long N)
	{
		if (N<=1)  return false; 
		if (N<=3)  return true; 
		if (N%2 == 0 || N%3 == 0) return false; 
		for (int i=5; i*i<=N; i=i+6) 
			if (N%i == 0 || N%(i+2) == 0) 
				return false; 
		return true; 
	}
	static void print(char A[])
	{
		for(char c:A)System.out.print(c+" ");
		System.out.println();
	}
	static void print(boolean A[])
	{
		for(boolean c:A)System.out.print(c+" ");
		System.out.println();
	}
	static void print(int A[])
	{
		for(int a:A)System.out.print(a+" ");
		System.out.println();	
	}
	static void print(long A[])
	{
		for(long i:A)System.out.print(i+ " ");
		System.out.println();

	}
	static void print(ArrayList<Integer> A)
	{
		for(int a:A)System.out.print(a+" ");
		System.out.println();
	}

	static int i()
	{
		return in.nextInt();
	}

	static long l()
	{
		return in.nextLong();
	}

	static int[] input(int N){
		int A[]=new int[N];
		for(int i=0; i<N; i++)
		{
			A[i]=in.nextInt();
		}
		return A;
	}

	static long[] inputLong(int N)     {
		long A[]=new long[N];
		for(int i=0; i<A.length; i++)A[i]=in.nextLong();
		return A;
	}

	static long GCD(long a,long b) 
	{
		if(b==0)
		{
			return a;
		}
		else return GCD(b,a%b );
	}

}
class node1 implements Comparable<node1>
{
	int index,f,size;
	long a;
	node1(int f,int i,int size)
	{
		this.f=f;
		this.index=i;
		this.size=size;
		a=2*f-size;
	}
	public int compareTo(node1 x)
	{
		if(this.a==x.a)return 0;
		else if(this.a<x.a)return 1;
		else return -1;
	}
}


//Code For FastReader
//Code For FastReader
//Code For FastReader
//Code For FastReader
class FastReader
{
	BufferedReader br;
	StringTokenizer st;
	public FastReader()
	{
		br=new BufferedReader(new InputStreamReader(System.in));
	}

	String next()
	{
		while(st==null || !st.hasMoreElements())
		{
			try
			{
				st=new StringTokenizer(br.readLine());
			}
			catch(IOException e)
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
		String str="";
		try
		{
			str=br.readLine();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return str;
	}

}
