//Siddhartha Bose
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class h {

	public static int r1=0;
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
	static long[][] f=new long[501][501];
	public static void main(String[] args)  {
		OutputStream outputStream =System.out;
	    PrintWriter out =new PrintWriter(outputStream);
		FastReader s=new FastReader();
			
		   int t=s.nextInt();
		 while(t>0) {
				int n=s.nextInt();
				for(int i=1;i<=n;i++) {
					vis[i]=0;
					deg[i]=0;
					ans[i]=0;
					f1[i]=new ArrayList<>();
				}
				for(int i=1;i<=n-1;i++) {
					int x=s.nextInt();
					int y=s.nextInt();
					f1[x].add(new pair1(y,i));
					f1[y].add(new pair1(x,i));
					deg[x]++;
					deg[y]++;
				}
//				dfs(1);
				int node=-1;
				boolean p=false;
				for(int i=1;i<=n;i++) {
					if(deg[i]>2) {
						p=true;
					}
					if(deg[i]==1) {
						node=i;
					}
				}
				if(p) {
					out.println(-1);
				}else {
					dfs(node,2);
//					System.out.println();
				for(int i=1;i<=n-1;i++) {
					out.print(ans[i]+" ");
				}
				out.println();
				}
			 t--;
			   }
			
		
		
	out.close();
	}
	static int[] ans=new int[100001];
	static int[] deg=new int[100001];
	static void dfs(int node,int v) {
		vis[node]=1;
//		deg[node]++;

		for(int i=0;i<f1[node].size();i++) {
			if(vis[f1[node].get(i).a]==0) {
			int g=2;
			if(v==2) {
				g=5;
			}
			ans[f1[node].get(i).b]=v;
				dfs(f1[node].get(i).a,g);
//				deg[node]++;
				
			}
			
		}
	}
//	static long ans(int[] a,int[] b,long till,long[] post,int n,int k,int i) {
//		if(k==0 || i==n) {
//			return till+post[i];
//		}
//		if(f[i][k]!=-1) {
//			return f[i][k];
//		}
//		
//	}
//	static class pair
	static int[] vis=new int[100001];
	static class pair1 {
		private int a;
		private int b;
		pair1(int a,int b){
			this.a=a;
			this.b=b;
		}
		
		
		
	}
	static class pair3 implements Comparable<pair3>{
		private int a;
		private int b;
		private int d;
		private int c;
		pair3(int a,int b,int c,int d){
			this.a=a;
			this.d=d;
			this.b=b;
			this.c=c;
		}
		@Override
		public int compareTo(pair3 c) {
			if(c.b-c.a!=this.b-this.a) {
				return Integer.compare(c.b-c.a, this.b-this.a);
			}else {
				return Integer.compare(this.c, c.c);
			}
			 
		}
	}
	static class pair2 implements Comparable<pair2>{
		private int a;
		private int b;
		private int d;
		private int c;
		pair2(int a,int b,int c,int d){
			this.a=a;
			this.d=d;
			this.b=b;
			this.c=c;
		}
		public int compareTo(pair2 c) {
			if(c.b!=this.b) {
				return Integer.compare(c.b, this.b);
			}else {
				if(c.c!=this.c) {
				return Integer.compare(this.c, c.c);
			}else {
				return Integer.compare(this.a, c.a);
			}
				
			}
			 
		}
	}
	static boolean r(int k) {
		for(int i=2;i<=k/2;i++) {
			if(k%i==0) {
				return false;
			}
		}
		return true;
	}
	public static int[] is_prime=new int[100001];
	public static ArrayList<Long> primes=new ArrayList<>();
	public static void sieve() {
		long maxN=100;
		for(long i=1;i<=maxN;i++) {
			is_prime[(int) i]=1;
		}
		is_prime[0]=0;
		is_prime[1]=0;
		for(long i=2;i*i<=maxN;i++) {
			if(is_prime[(int) i]!=0) {
				primes.add( i);
				long c=1;
				for(long j=i*i;j<=maxN;j+=i) {
					is_prime[(int) j]++;
				}
			}
		}
		
		for(long i=2;i<=maxN;i++) {
			is_prime[(int) i]=is_prime[(int) (i-1)]+is_prime[(int) i];
		}
//		int count=0;
//		for(long i=1;i<=maxN;i++) {
//			if(is_prime[(int) i]==1) {
//				count++;
//			}
//			if(is_prime[count]==1) {
//				arr[(int) i]=1;
//			}else {
//				arr[(int)i]=0;
//			}
//		}
	}
	public static long[] merge_sort(long[] A, int start, int end) {
		if (end > start) {
			int mid = (end + start) / 2;
			long[] v = merge_sort(A, start, mid);
			long[] o = merge_sort(A, mid + 1, end);
			return (merge(v, o));
		} else {
			long[] y = new long[1];
			y[0] = A[start];
			return y;
		}
	}
	static ArrayList<pair1>[] f1=new ArrayList[100001];
	
	public static long[] merge(long a[], long b[]) {
//		int count=0;
		long[] temp = new long[a.length + b.length];
		int m = a.length;
		int n = b.length;
		int i = 0;
		int j = 0;
		int c = 0;
		while (i < m && j < n) {
			if (a[i] < b[j]) {
				temp[c++] = a[i++];
			
			} else {
				temp[c++] = b[j++];
			}
		}
		while (i < m) {
			temp[c++] = a[i++];
		}
		while (j < n) {
			temp[c++] = b[j++];
		}
		return temp;
	}
	
	
	
}