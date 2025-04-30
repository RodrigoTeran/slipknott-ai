import java.io.*;
import java.util.*;
import java.math.*;
import java.math.BigInteger; 
//import javafx.util.*; 
public final class B
{    
	static StringBuilder ans=new StringBuilder();
	static FastReader in=new FastReader();
	static ArrayList<ArrayList<Integer>> g;
	static long mod=(long)(1e9+7);
	static int D1[],D2[],par[];
	static boolean set[];
	static int value[];
	static long INF=Long.MAX_VALUE;
	static int dp[][];
	static int N,M;
	static int A[][],B[][];
	static int s=1;
	public static void main(String args[])throws IOException
	{  					
		int N=i();
		int A[]=input(N);
		ArrayList<Integer> one=new ArrayList<Integer>();
		ArrayList<Integer> zero=new ArrayList<Integer>();
		for(int i=1; i<=N; i++)
		{
			if(A[i-1]==1)one.add(i);
			else zero.add(i);
		}
		int sum[][]=new int[N+5][N+5];
		for(int i=1; i<=one.size(); i++)
		{
			for(int j=1; j<=zero.size(); j++)
			{
				sum[i][j]=Math.abs(one.get(i-1)-zero.get(j-1));
			}
			//print(sum[i]);
		}
		dp=new int[N+5][N+5];
		//for(int d[]:dp)Arrays.fill(d, Integer.MAX_VALUE);
		Arrays.fill(dp[0], 0);
		for(int i=1; i<=one.size(); i++)
		{
			for(int j=i; j<=zero.size(); j++)
			{
				if(i==j)
				{
					dp[i][j]=dp[i-1][j-1]+sum[i][j];
				}
				else
				{
					dp[i][j]=Math.min(dp[i][j-1], dp[i-1][j-1]+sum[i][j]);
				}
			}
		}
		System.out.println(dp[one.size()][zero.size()]);
//		f(0,0,one,zero,0);
		//for(int d[]:dp)print(d);
		
	}	
	static int f(int i,int j,ArrayList<Integer> one,ArrayList<Integer> zero, int s)
	{
		if(i==one.size())return s;
		if(j==zero.size())return Integer.MAX_VALUE;
		int a=one.get(i),b=zero.get(j);
        if(dp[a][b]==-1)
        {
        	int min=Integer.MAX_VALUE;
        	for(int t=j; t<zero.size(); t++)
    		{
                 min=Math.min(min, f(i+1,t+1,one,zero,s+Math.abs(b-a))); 
    		}  
        	dp[a][b]=min;
        }	
        a=one.get(i);b=zero.get(j);
		return dp[a][b];
	}
	static boolean isSorted(int A[])
	{
		int N=A.length;
		for(int i=0; i<N-1; i++)
		{
			if(A[i]>A[i+1])return false;
		}

		return true;		
	}
	static int f1(int x,ArrayList<Integer> A)
	{
		int l=-1,r=A.size();
		while(r-l>1)
		{
			int m=(l+r)/2;
			int a=A.get(m);
			if(a<x)l=m;
			else r=m;
		}		
		return l;
	}


	static int ask(int t,int i,int j,int x)
	{
		System.out.println("? "+t+" "+i+" "+j+" "+x);
		return i();
	}

	static int ask(int a)
	{
		System.out.println("? 1 "+a);
		return i();
	}
	static int f(int st,int end,int d)
	{
		if(st>end)return 0;
		int a=0,b=0,c=0;
		if(d>1)a=f(st+d-1,end,d-1);
		b=f(st+d,end,d);
		c=f(st+d+1,end,d+1);
		return value[st]+max(a,b,c);
	}
	static int max(int a,int b,int c)
	{
		return Math.max(a, Math.max(c, b));
	}
	static int value(char X[],char Y[])
	{
		int c=0;
		for(int i=0; i<7; i++)
		{
			if(Y[i]=='1' && X[i]=='0')return -1;
			if(X[i]=='1' && Y[i]=='0')c++;
		}
		return c;
	}
	static boolean isValid(int i,int j)
	{
		if(i<0 || i>=N)return false;
		if(j<0 || j>=M)return false;
		return true;
	}

	static long fact(long N)
	{
		long num=1L;
		while(N>=1)
		{
			num=((num%mod)*(N%mod))%mod;
			N--;
		}
		return num;
	}
	static boolean reverse(long A[],int l,int r)
	{
		while(l<r)
		{
			long t=A[l];
			A[l]=A[r];
			A[r]=t;
			l++;
			r--;
		}
		if(isSorted(A))return true;
		else return false;
	}
	static boolean isSorted(long A[])
	{
		for(int i=1; i<A.length; i++)if(A[i]<A[i-1])return false;
		return true;
	}
	static boolean isPalindrome(char X[],int l,int r)
	{
		while(l<r)
		{
			if(X[l]!=X[r])return false;
			l++; r--;
		}
		return true;
	}

	static long min(long a,long b,long c)
	{
		return Math.min(a, Math.min(c, b));
	}

	static void print(int a)
	{
		System.out.println("! "+a);
	}
	static int ask(int a,int b)
	{
		System.out.println("? "+a+" "+b);
		return i();
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
			par[a]+=par[b]; //transfers the size
			par[b]=a;       //changes the parent
		}
	}
	static void swap(char A[],int a,int b)
	{
		char ch=A[a];
		A[a]=A[b];
		A[b]=ch;
	}

	static void sort(long[] a) //check for long
	{
		ArrayList<Long> l=new ArrayList<>();
		for (long i:a) l.add(i);
		Collections.sort(l);
		for (int i=0; i<a.length; i++) a[i]=l.get(i);
	}
	static void setGraph(int N)
	{
		g=new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<=N; i++)
		{
			g.add(new ArrayList<Integer>());
		}
	}

	static  long pow(long a,long b)
	{
		long mod=1000000007;
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
	static long GCD(long a,long b) 
	{
		if(b==0)
		{
			return a;
		}
		else return GCD(b,a%b );
	}

	//Debugging Functions Starts

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

	//Debugging Functions END
	//----------------------
	//IO FUNCTIONS STARTS
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

	//IO FUNCTIONS END

}

class node implements Comparable<node>
{
	int l,r,index;
	node(int l,int r,int index)
	{
		this.l=l;
		this.r=r;
		this.index=index;
	}
	public int compareTo(node X)
	{
		return X.r-this.r;
	}
}
class node1 implements Comparable<node1>
{
	int l,r,index;
	node1(int l,int r,int index)
	{
		this.l=l;
		this.r=r;
		this.index=index;
	}
	public int compareTo(node1 X)
	{
		if(this.l==X.l)
			return X.r-this.r;
		return this.l-X.l;
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
	//gey
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