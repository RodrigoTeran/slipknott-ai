import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.*;


 
public class Codeforces {
	
	static int mod=1000000007 ;
	static List<Integer>[] adj;
	static boolean vst[];
	static int dp[];
	public static void main(String[] args) throws Exception {
		PrintWriter out=new PrintWriter(System.out);
		FastScanner fs=new FastScanner();
		int t=fs.nextInt();
		while(t-->0) {
			int n=fs.nextInt();
			int arr[]=fs.readArray(n);
			int ans[]=new int[n];
			if(n%2==0) {
				for(int i=0;i<n;i+=2) {
					ans[i]=-arr[i+1];
					ans[i+1]=arr[i];
				}
			}
			else {
				for(int i=3;i<n;i+=2) {
					ans[i]=-arr[i+1];
					ans[i+1]=arr[i];
				}
				int a=0, b=0, c=0;
				outer:for(int i=0;i<3;i++) {
					for(int j=i+1;j<3;j++) {
						if(arr[i]+arr[j]!=0) {
							b=i;
							c=j;
							a= 3-c-b;
							break outer;
						}
					}
				}
				ans[a]=arr[b]+arr[c];
				ans[b]=-arr[a];
				ans[c]=-arr[a];
			}
			for(int i=0;i<n;i++) {
				out.print(ans[i]+" ");
			}
			out.println();
//			long sum=0;
//			for(int i=0;i<n;i++) {
//				sum+=arr[i]*ans[i];
//			}
//			if(sum!=0) System.out.println(false);
		}
		out.close();
		
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
	static long gcd(long  a,long  b) {
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