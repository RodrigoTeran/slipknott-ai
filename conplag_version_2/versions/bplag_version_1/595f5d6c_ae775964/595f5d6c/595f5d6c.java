
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.ObjectInputStream.GetField;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.sound.sampled.ReverbType;


public class Edu109 {
	static PrintWriter out;
	static Scanner sc;
	static ArrayList<int[]>q,w,x;
	static ArrayList<Integer>adj[];
	static HashSet<Integer>primesH;
	static boolean prime[];
	//static ArrayList<Integer>a;
	static HashSet<Long>tmp;
	static int[][][]dist;
	static boolean[]v;
	static int[]a,b,c,d;
	static Boolean[][]dp;
	static char[][]mp;
	static int A,B,n,m,h,ans,sum;
	//static String a,b;
	static long oo=(long)1e9+7;
	public static void main(String[]args) throws IOException {
		sc=new Scanner(System.in);
		out=new PrintWriter(System.out);
		//A();
		//B();
		//C();
		D();
		//E();
		//F();
		//G();
		out.close();
	}
	  private static void A() throws IOException {
		  int t=ni();
		  while(t-->0) {
				int k=ni();
				int ans=0;
				for(int i=1;i<=100;i++) {
					if((i*100)%k==0) {
						ans=i*100/k;break;
					}
				}
				ol(ans);
		  }
		
	   }
		static void B() throws IOException {
			int t=ni();
			while(t-->0) {
				int n=ni();
				a=nai(n);
				boolean isSorted=true,one=a[0]==1;
				int pos=0;
				for(int i=1;i<n;i++) {
					if(a[i]<a[i-1])isSorted=false;
					if(a[i]==1)pos=i;
				}
				boolean ok=true;
				for(int i=pos+1;i<n;i++) {
					if(a[i]<a[i-1])ok=false;
				}
				boolean lst=a[0]==n;
				boolean fir=a[n-1]==1;
				if(isSorted)ol(0);
				else if(lst&&fir)ol(3);
				else if(lst||fir)ol(2);
				else if(a[0]==1||a[n-1]==n)ol(1);
				else ol(2);
//				if(isSorted)ol(0);
//				else out.println(fl&&lst?3:((one?1:2)-(ok?1:0)+(lst?1:0)));
			}
		}
		
		static void C() throws IOException{
			 int t=ni();
			 while(t-->0) {
				int n=ni();
				int m=ni();
				a=nai(n);
				TreeMap<Integer, Integer>tr=new TreeMap<Integer, Integer>();
				for(int i=0;i<n;i++)tr.put(a[i], i);
				char[]mv=new char[n];
				for(int i=0;i<n;i++) {
					String s=ns();
					mv[i]=s.charAt(0);
				}
				long[]ans=new long[n];
				Arrays.fill(ans, -1);
				PriorityQueue<Integer>lodd=new PriorityQueue<Integer>();
				PriorityQueue<Integer>lev=new PriorityQueue<Integer>();
				PriorityQueue<Integer>rodd=new PriorityQueue<Integer>();
				PriorityQueue<Integer>rev=new PriorityQueue<Integer>();
				for(int i=0;i<n;i++) {
					if(a[i]%2==0) {
						if(mv[i]=='L')lev.add(a[i]);
						else rev.add(a[i]);
					}else {
						if(mv[i]=='L')lodd.add(a[i]);
						else rodd.add(a[i]);
					}
				}
				PriorityQueue<Integer>par[]=new PriorityQueue[4];
				par[0]=rev;par[1]=rodd;par[2]=lev;par[3]=lodd;
				for(int i=0;i<2;i++){
					while(par[i].size()>=1&&par[i+2].size()>=1) {
						int r=par[i].poll(),l=par[i+2].poll();
						int d1=(l-r)/2;
						if(l<r) {
							d1=clc(l,r,m);
						}
						int dr=Integer.MAX_VALUE,dl=Integer.MAX_VALUE;
						if(par[i].size()==1) {
							dr=m-par[i].peek()+(par[i].peek()-r)/2;
						}
						if(!par[i+2].isEmpty()) {
							dl=(par[i+2].peek()+l)/2;
						}
						int cur=Math.min(d1, Math.min(dl, dr));
						if(cur==d1) {
							ans[tr.get(r)]=ans[tr.get(l)]=cur;
						}
						else if(cur==dr) {
							ans[tr.get(r)]=ans[tr.get(par[i].poll())]=cur;
							par[i+2].add(l);
						}else {
							ans[tr.get(l)]=ans[tr.get(par[i+2].poll())]=cur;
							par[i].add(r);
						}
						
					}
				}
				for(int i=0;i<4;i++) {
					if(i<2&&par[i].size()%2==1)par[i].poll();
					while(par[i].size()>1) {
						int x=par[i].poll(),y=par[i].poll();
						int val=0;
						if(i<2) {
							val=m-y+(y-x)/2;
						}else {
							val=(x+y)/2;
						}
						ans[tr.get(x)]=ans[tr.get(y)]=val;
					}
				}
				for(int i=0;i<n;i++) {
					out.print(ans[i]+" ");
				}ol("");
			 }
		}
		private static int clc(int l, int r, int m) {
			int b1=0,b2=m;
			int ans=0;
			if(l>m-r) {
				ans+=l;
				b2=2*m - l -r;// m-(l-m+r) -> m-l+m-r
			}else {
				ans+=m-r;
				b1=m-r-l;
			}
			return ans+(b2-b1)/2;
		}
		private static Boolean dp(int i, int j) {
			if(j>sum/2)return false;
			if(i==x.size()) {
				return sum/2==j;
			}
			if(dp[i][j]!=null)return dp[i][j];
			
			return dp[i][j]=dp(i+1,j+x.get(i)[0])||dp(i+1,j);
		}
		static boolean isPrime(long n) {
			if(n==2)return true;
			if(n<2||n%2==0)return false;
			
			for(long i=3L;i*i<n;i+=2l) {
				long rem=(n%i);
				if(rem==0)return false;
			}
			return true;
		}
		static long[][]mem;
		static int ones;
		static ArrayList<Integer>pos;
		static void D() throws IOException {
			int t=1;
			while(t-->0) {
				n=ni();
				a=nai(n);
				mem=new long[n][n];
				ones=0;
				pos=new ArrayList<Integer>();
				for(int i=0;i<n;i++) {
					Arrays.fill(mem[i], -1);
					if(a[i]==1)pos.add(i);
				}
				ones=pos.size();
				long ans=solve(0,0);
				out.println(ans);
			}
		}
		private static long solve(int i, int j) {
			if(i==n||j>=ones)return j==ones?0:(long)1e14;
			if(mem[i][j]!=-1)return mem[i][j];
			long lv=solve(i+1,j);
			if(a[i]==0) {
				int pr=Math.abs(i-pos.get(j));
				lv=Math.min(lv, pr+solve(i+1,j+1));
			}
			return mem[i][j]=lv;
		}
		private static int bfs(int i, int j,int k) {
			boolean [][]vis=new boolean[dist.length][dist[0].length];
			Queue<int[]>q=new LinkedList<int[]>();
			int mn=Integer.MAX_VALUE;
			q.add(new int[] {i,j,0,0});
			int[]dx=new int[] {-1,1,0,0};
			int[]dy=new int[] {0,0,1,-1};
			while(!q.isEmpty()) {
				int []x=q.poll();
				vis[x[0]][x[1]]=true;
				int c=x[2];
				if(c>k/2)continue;
				if(c>0&&k%c==0&&(k/c)%2==0) {
					mn=Math.min(mn,x[3]*k/c );
				}
				for(int a=0;a<4;a++) {
					int nx=x[0]+dx[a];
					int ny=x[1]+dy[a];
					if(valid(nx,ny)&&!vis[nx][ny]) {
						q.add(new int[] {nx,ny,c+1,x[3]+dist[x[0]][x[1]][a]});
					}
				}
				
			}
			return mn;
		}
		private static boolean valid(int nx, int ny) {
			return nx>=0&&nx<dist.length&&ny>=0&&ny<dist[0].length;
		}
		static int gcd (int a, int b) {
		    return b==0?a:gcd (b, a % b);
		}
		
	static void E() throws IOException {
		int t=ni();
		while(t-->0) {
			
			
		}
		
	}

	static void F() throws IOException {
		int t=ni();
		while(t-->0) {
			
		}
	}
	static void CC() throws IOException {
		for(int kk=2;kk<21;kk++) {
			ol(kk+"   -------");
		int n=kk;
		int k=n-2;
		int msk=1<<k;
		int[]a=new int[k];
		for(int i=0;i<a.length;i++)a[i]=i+2;
		int mx=1;
		int ms=0;
		for(int i=1;i<msk;i++) {
			long prod=1;
			int cnt=0;
			for(int j=0;j<a.length;j++) {
				if(((i>>j)&1)!=0) {
					prod*=a[j];
					cnt++;
				}
			}
			if(cnt>=mx&&prod%n==1) {
				mx=cnt;
				ms=i;
			}
			
		}
		ol(mx==1?mx:mx+1);
		out.print(1+" ");
		long pr=1;
		for(int j=0;j<a.length;j++) {
			if(((ms>>j)&1)!=0) {
				out.print(a[j]+" ");
				pr*=a[j];
			}
		}
		ol("");
		ol("Prod: "+pr);
		ol(n+"*"+((pr-1)/n)+" + "+1);
		}
	}
	static int ni() throws IOException {
		return sc.nextInt();
	}
	static double nd() throws IOException {
		return sc.nextDouble();
	}
	static long nl() throws IOException {
		return  sc.nextLong();
	}
	static String ns() throws IOException {
		return sc.next();
	}
	static int[] nai(int n) throws IOException {
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = sc.nextInt();
		return a;
	}
	static long[] nal(int n) throws IOException {
		long[] a = new long[n];
		for (int i = 0; i < n; i++)
			a[i] = sc.nextLong();
		return a;
	}
	static int[][] nmi(int n,int m) throws IOException{
		int[][]a=new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				a[i][j]=sc.nextInt();
			}
		}
		return a;
	}

	static long[][] nml(int n,int m) throws IOException{
		long[][]a=new long[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				a[i][j]=sc.nextLong();
			}
		}
		return a;
	}
	static void o(String x) {
		out.print(x);
	}
	static void ol(String x) {
		out.println(x);
	}
	static void ol(int x) {
		out.println(x);
	}
	static void disp1(int []a) {
		for(int i=0;i<a.length;i++) {
			out.print(a[i]+" ");
		}
		out.println();
	}

	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

		public String next() throws IOException 
		{
			while (st == null || !st.hasMoreTokens()) 
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}
		public boolean hasNext() {return st.hasMoreTokens();}
		public int nextInt() throws IOException {return Integer.parseInt(next());}
		
		public double nextDouble() throws IOException {return Double.parseDouble(next());}
		
		public long nextLong() throws IOException {return Long.parseLong(next());}

		public String nextLine() throws IOException {return br.readLine();}
			
		public boolean ready() throws IOException {return br.ready(); }
		

	}
}
