/*                       In_The_Name_Of_Allah_The_Merciful                        */
import java.util.*;

import java.io.*;  
public class Main
{
	class Pair implements Comparable<Pair>{
		int f,s;
		Pair(int x,int y){
			f=x;
			s=y;
		}
		@Override
		public int compareTo(Pair a) {
			if(a.f!=this.f)return Integer.compare(f,a.f);
			else return Integer.compare(s,a.s);
		}
	}
    PrintWriter out;
    FastReader sc;
    long[] m1= {(long)(1e9+7),998244353};
    long mod=m1[1];
    long maxlong=Long.MAX_VALUE;
    long minlong=Long.MIN_VALUE;
    StringBuilder sb;
   
    /******************************************************************************************
     *****************************************************************************************/
    
	public void sol() {
		int n=ni();
		int[] ar=new int[n];
		for(int i=0;i<n;i++)ar[i]=ni();
		char[] s=rl();
		PriorityQueue<Integer> red=new PriorityQueue<>(Collections.reverseOrder()),blue=new PriorityQueue<>();
		for(int i=0;i<n;i++) {
			if(s[i]=='R')red.add(ar[i]);
			else blue.add(ar[i]);
		}
		int a=n;
		while(red.size()>0) {
			if(red.poll()>a) {
				no();return;
			}a--;
		}a=1;
		while(blue.size()>0) {
			if(blue.poll()<a) {
				no();return;
			}a++;
		}yes();
	}
    public static void main(String[] args) 
	{ 
	    Main g=new Main();
		g.out=new PrintWriter(System.out);
		g.sc=new FastReader();
		int t=1;
 		t=g.ni();
		while(t-->0)
		g.sol();
		g.out.flush();
	}
	
	/****************************************************************************************
     *****************************************************************************************/
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
	} public int ni(){
	      return sc.nextInt();
	}public long nl(){
	      return sc.nextLong();
	}public double nd(){
	      return sc.nextDouble();
	}public char[] rl(){
	      return sc.nextLine().toCharArray();
	}public String rl1(){
	      return sc.nextLine();
	}
	public void pl(Object s){
	      out.println(s);
	}
	public void pr(Object s){
	      out.print(s);
	}public String next(){
	      return sc.next();
	}public long abs(long x){
	      return Math.abs(x);
	}
	public int abs(int x){
	      return Math.abs(x);
	}
	public double abs(double x){
	      return Math.abs(x);
	}public long min(long x,long y){
            return (long)Math.min(x,y);
      }
      public int min(int x,int y){
            return (int)Math.min(x,y);
      }
      public double min(double x,double y){
            return Math.min(x,y);
      }public long gcd(long a, long b) {
		if (a == 0)
			return b;
		return gcd(b % a, a);
	}public long lcm(long a, long b) {
            return (a / gcd(a, b)) * b;
      }
       void sort1(int[] a) {
		ArrayList<Integer> l = new ArrayList<>();
		for (int i : a) {
			l.add(i);
		}
		Collections.sort(l,Collections.reverseOrder());
		for (int i = 0; i < a.length; i++) {
			a[i] = l.get(i);
		}
	}
	 void sort(int[] a) {
		ArrayList<Integer> l = new ArrayList<>();
		for (int i : a) {
			l.add(i);
		}
		Collections.sort(l);
		for (int i = 0; i < a.length; i++) {
			a[i] = l.get(i);
		}
	}void sort(char[] a) {
		ArrayList<Character> l = new ArrayList<>();
		for (char i : a) {
			l.add(i);
		}
		Collections.sort(l);
		for (int i = 0; i < a.length; i++) {
			a[i] = l.get(i);
		}
	}void sort1(char[] a) {
		ArrayList<Character> l = new ArrayList<>();
		for (char i : a) {
			l.add(i);
		}
		Collections.sort(l,Collections.reverseOrder());
		for (int i = 0; i < a.length; i++) {
			a[i] = l.get(i);
		}
	}
	 void sort(long[] a) {
		ArrayList<Long> l = new ArrayList<>();
		for (long i : a) {
			l.add(i);
		}
		Collections.sort(l);
		for (int i = 0; i < a.length; i++) {
			a[i] = l.get(i);
		}
	}void sort1(long[] a) {
		ArrayList<Long> l = new ArrayList<>();
		for (long i : a) {
			l.add(i);
		}
		Collections.sort(l,Collections.reverseOrder());
		for (int i = 0; i < a.length; i++) {
			a[i] = l.get(i);
		}
	}
	void sort(double[] a) {
		ArrayList<Double> l = new ArrayList<>();
		for (double i : a) {
			l.add(i);
		}
		Collections.sort(l);
		for (int i = 0; i < a.length; i++) {
			a[i] = l.get(i);
		}
	}long pow(long a,long b){
          if(b==0){
                return 1;
          }long p=pow(a,b/2);
          if(b%2==0) return mMultiplication(p,p)%mod;
          else return (mMultiplication(mMultiplication(p,p),a))%mod;
    }
	
	int  swap(int a,int b){
	      return a;
	}long  swap(long a,long b){
	      return a;
	}double  swap(double a,double b){
	      return a;
	}
	boolean isPowerOfTwo (int x) 
      { 
            return x!=0 && ((x&(x-1)) == 0);     
      }boolean isPowerOfTwo (long x) 
      { 
            return x!=0 && ((x&(x-1)) == 0);     
      }public long max(long x,long y){
            return (long)Math.max(x,y);
      }
      public int max(int x,int y){
            return (int)Math.max(x,y);
      }
      public double max(double x,double y){
            return Math.max(x,y);
      }long sqrt(long x){
            return (long)Math.sqrt(x);
      }int sqrt(int x){
            return (int)Math.sqrt(x);
      }void input(int[] ar,int n){
            for(int i=0;i<n;i++)ar[i]=ni();
      }void input(long[] ar,int n){
            for(int i=0;i<n;i++)ar[i]=nl();
      }void fill(int[] ar,int k){
            Arrays.fill(ar,k);
      }void yes(){
            pl("YES");
      }void no(){
            pl("NO");
      }
      long c2(long n) {
    	  return (n*(n-1))/2;
      }
    long[] sieve(int n) 
    {
          long[] k=new long[n+1];
          boolean[] pr=new boolean[n+1];
          for(int i=1;i<=n;i++){
                k[i]=i;
                pr[i]=true;
          }for(int i=2;i<=n;i++){
                if(pr[i]){
                      for(int j=i+i;j<=n;j+=i){
                            pr[j]=false;
                            if(k[j]==j){
                                  k[j]=i;
                            }
                      }
                }
          }return k;
    }
    int strSmall(int[] arr, int target)  
    {  
        int start = 0, end = arr.length-1;  
        int ans = -1;  
        while (start <= end) {  
            int mid = (start + end) / 2;   
            if (arr[mid] >= target) {  
                end = mid - 1;  
            }   
            else {  
                ans = mid;  
                start = mid + 1;  
            }  
        }  
        return ans;  
    } int strSmall(ArrayList<Integer> arr, int target)  
    {  
        int start = 0, end = arr.size()-1;  
        int ans = -1;  
        while (start <= end) {  
            int mid = (start + end) / 2;   
            if (arr.get(mid) > target) {  
                start = mid + 1; 
                ans=start;
            }   
            else {
                end = mid - 1;  
            }  
        }  
        return ans;  
    }long mMultiplication(long a,long b) 
    { 
        long res = 0;    
        a %= mod; 
  
        while (b > 0)  
        {  
            if ((b & 1) > 0)  
            { 
                res = (res + a) % mod; 
            }  
            a = (2 * a) % mod; 
  
            b >>= 1;  
        } 
        return res; 
    }long nCr(int n, int r ,long p)
    {
 
          if (n<r) 
              return 0;
        if (r == 0)
            return 1;
            long[] fac = new long[n + 1];
        fac[0] = 1;
 
        for (int i = 1; i <= n; i++)
            fac[i] = fac[i - 1] * i %p;
        return (fac[n] * modInverse(fac[r], p)
                % p * modInverse(fac[n - r], p)
                % p)
            % p;
    }long power(long x, long y, long p)
    {
        long res = 1;
        x = x % p;
 
        while (y > 0) {
            if (y % 2 == 1)
                res = (res * x) % p;
            y = y >> 1; 
            x = (x * x) % p;
        }
 
        return res;
    }long modInverse(long n, long p)
    {
        return power(n, p - 2, p);
    }
    
    int[][] floydWarshall(int graph[][],int INF,int V)
    {
        int dist[][] = new int[V][V];
        int i, j, k;
        for (i = 0; i < V; i++)
            for (j = 0; j < V; j++)
                dist[i][j] = graph[i][j];
        for (k = 0; k < V; k++)
        {
            for (i = 0; i < V; i++)
            {
                for (j = 0; j < V; j++)
                {
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }return dist;
    }
    class minque {
		Deque<Long> q;
		minque(){
			q=new ArrayDeque<Long>();
		}public void add(long p){
			while(!q.isEmpty()&&q.peekLast()>p)q.pollLast();
			q.addLast(p);
		}public void remove(long p) {
			if(!q.isEmpty()&&q.getFirst()==p)q.removeFirst();
		}public long min() {
			return q.getFirst();
		}
	}
      int find(subset[] subsets, int i)
      {
          if (subsets[i].parent != i)
              subsets[i].parent
                  = find(subsets, subsets[i].parent);
          return subsets[i].parent;
      }void Union(subset[] subsets, int x, int y)
      {
          int xroot = find(subsets, x);
          int yroot = find(subsets, y);
   
          if (subsets[xroot].rank < subsets[yroot].rank) {
          	subsets[xroot].parent = yroot;
          }
          else if (subsets[yroot].rank < subsets[xroot].rank) {
          	subsets[yroot].parent = xroot;
          }
          else {
              subsets[xroot].parent = yroot;
              subsets[yroot].rank++;
          }
      }class subset
      {
          int parent;
          int rank;
      }
	 
}