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
	static long mod=1000000007;
	static int D1[],D[],par[];
	static boolean set[];
	static long INF=Long.MAX_VALUE;
	public static void main(String args[])throws IOException
	{  	

		int T=i();
		while(T-->0)
		{
			int N=i();
			long A[]=inputLong(N);
			boolean f=true;
			TreeSet<Long> set=new TreeSet<>();
			for(int i=0; i<N; i++)
			{
				if(i>=2)
				{
					if(A[i]<A[i-1])
					{
						if(set.ceiling(A[i]+1)!=A[i-1])f=false;
					}
					if(A[i]>A[i-1])
					{
						if(set.floor(A[i]-1)!=A[i-1])f=false;
					}
				}
				set.add(A[i]);
			}
			if(f)System.out.println("YES");
			else System.out.println("NO");
		}
	}

	static int f2(int l,int r,int index)
	{
		while(r-l>1)
		{
			int m=(l+r)/2;
			if(ask(index,m)==index)r=m;
			else l=m;
		}
		return r;
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
		D=new int[N+1];
		set=new boolean[N+1];
		g=new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<=N; i++)
		{
			D[i]=N+1;
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
//class pair implements Comparable<pair>{
//	int index; long a;
//	pair(long a,int index)
//	{
//		this.a=a;
//		this.index=index;
//	}
//	public int compareTo(pair X)
//	{
//		if(this.a>X.a)return 1;
//		if(this.a==X.a)return this.index-X.index;
//		return -1;
//	}
//}

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