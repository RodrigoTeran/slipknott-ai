import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
//import java.text.DecimalFormat;
import java.util.*;

//import B.Node;
 
public class Codeforces {
	static int mod= 998244353;
	static char arr[];
	static class Node{
		int l,r,c,ind;
		Node(){
			
		}
		Node(int l,int r,int c){
			this.l=l;
			this.r=r;
			this.c=c;
		}
		Node(int l,int r,int c,int d){
			this.l=l;
			ind=d;
			this.r=r;
			this.c=c;
		}
	}
	public static void main(String[] args) throws Exception {
		PrintWriter out=new PrintWriter(System.out);
		FastScanner fs=new FastScanner();
//		int t=fs.nextInt();
		int t=fs.nextInt();
		outer:while(t-->0) {
			int n=fs.nextInt();
			int p[]=new int[n];
			Arrays.fill(p, -1);
			for(int i=0;i<n;i++) {
				if(p[i]==-1) {
					List<Integer> list=new ArrayList<>();
					Set<Integer> set=new HashSet<>();
					while(true) {
						System.out.println("? "+(i+1));
						int cur=fs.nextInt();
						list.add(cur);
						if(set.contains(cur)) break;
						set.add(cur);
						
					}
					for(int j=0;j<list.size()-1;j++) {
						int cur=list.get(j), next=list.get(j+1);
						p[cur-1]=next;
					}
				}
			}
			StringBuilder ans=new StringBuilder("! ");
			for(int ele:p) {
				ans.append(ele+ " ");
			}
			System.out.println(ans);
		}
		
		
		out.close();
		
	}
	static void query(int p[],int i,FastScanner fs) {
		System.out.println("? "+i);
		System.out.flush();
		int last=fs.nextInt();
		while(true) {
			System.out.println("? "+i);
			System.out.flush();
			int cur=fs.nextInt();
			p[last-1]=cur;
			if(cur==1) return ;
			last=cur;
		}
		
	}
	static long pow(long a,long b) {
		if(b<0) return 1;
		long res=1;
		while(b!=0) {
			if((b&1)!=0) {
				res*=a;
				res%=mod;
			}
			a*=a;
			a%=mod;
			b=b>>1;
		}
		return res;
	}
	static int gcd(int  a,int  b) {
		if(b==0) return a;
		return gcd(b,a%b);
	}
	static long nck(int n,int k) {
		if(k>n) return 0;
		long res=1;
		res*=fact(n);
		res%=mod;
		res*=modInv(fact(k));
		res%=mod;
		res*=modInv(fact(n-k)); 
		res%=mod;
		return res;
	}
	static long fact(long n) {
//		return fact[(int)n];
		long res=1;
		for(int i=2;i<=n;i++) {
			res*=i;
			res%=mod;
		}
		return res;
	}
	
	static long modInv(long n) {
		return pow(n,mod-2);
	}
	
	static void sort(int[] a) {
		//suffle
		int n=a.length;
		Random r=new Random();
		for (int i=0; i<a.length; i++) {
			int oi=r.nextInt(n);
			int temp=a[i];
			a[i]=a[oi];
			a[oi]=temp;
		}
		
		//then sort
		Arrays.sort(a);
	}
	
	// Use this to input code since it is faster than a Scanner
	static class FastScanner {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
		String next() {
			while (!st.hasMoreTokens())
				try {
					st=new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		long[] lreadArray(int n) {
			long a[]=new long[n];
			for(int i=0;i<n;i++) a[i]=nextLong();
			return a;
		}
		int[] readArray(int n) {
			int[] a=new int[n];
			for (int i=0; i<n; i++) a[i]=nextInt();
			return a;
		}
		long nextLong() {
			return Long.parseLong(next());
		}
	}
 
}