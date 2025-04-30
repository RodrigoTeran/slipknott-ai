/*
 * akshaygupta26
 */
import java.io.*;
import java.util.*;
public class C
{ 
	static class Pair{
		int h,in;
		Pair(){}
		Pair(int in,int h){
			this.in=in;
			this.h=h;
		}
	}
	static class customSort implements Comparator<Pair>{
		public int compare(Pair a,Pair b) {
			return a.h-b.h;
		}
	}
    public static void main(String[] args) 
	{ 
		FastReader sc=new FastReader(); 
		StringBuffer ans=new StringBuffer();
		int test=sc.nextInt();
		while(test-->0)
		{
			
			int n=sc.nextInt(),m=sc.nextInt(),x=sc.nextInt();
			
			int arr[]=new int[n];
			int res[]=new int[n];
			
			int sum =0;
			for(int i=0;i<n;i++) {
				arr[i]=sc.nextInt();sum+=arr[i];
			}
			
			PriorityQueue<Pair> pq=new PriorityQueue<>(new customSort());
			
			for(int i=1;i<=m;i++) {
				pq.add(new Pair(i,0));
			}
			
			ans.append("YES\n");
			for(int a:arr) {
				Pair xx=pq.poll();
				ans.append(xx.in+" ");
				xx.h+=a;
				pq.add(xx);
			}
			ans.append("\n");
			
			
		}
	    System.out.print(ans);
	} 
    
 
    static long _gcd(long a,long b) {
    	if(b == 0) return a;
    	return _gcd(b,a%b);
    }
    
    static final Random random=new Random();
    
	static void ruffleSort(int[] a) {
		int n=a.length;//shuffle, then sort 
		for (int i=0; i<n; i++) {
			int oi=random.nextInt(n), temp=a[oi];
			a[oi]=a[i]; a[i]=temp;
		}
		Arrays.sort(a);
	}
	
	static void ruffleSort(long[] a) {
		int n=a.length;//shuffle, then sort 
		for (int i=0; i<n; i++) {
			int oi=random.nextInt(n);
			long temp=a[oi];
			a[oi]=a[i]; a[i]=temp;
		}
		Arrays.sort(a);
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
				catch (IOException e) 
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
