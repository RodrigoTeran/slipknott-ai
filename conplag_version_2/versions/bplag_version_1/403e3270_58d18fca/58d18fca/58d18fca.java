import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.*;

//import sun.nio.fs.RegistryFileTypeDetector;


 
public class Codeforces {
	static int mod= 998244353;
	
	public static void main(String[] args) throws Exception {
		PrintWriter out=new PrintWriter(System.out);
		FastScanner fs=new FastScanner();
		int t=fs.nextInt();
		
		outer:while(t-->0) {
			int n=fs.nextInt();
			int arr[]=fs.readArray(n);
			int l=0, r=1000000000;
			while(l<r) {
				int mid=(l+r+1)/2;
				if(check(arr,mid)) {
					l=mid;
				}
				else r=mid-1;
			}
			out.println(l);
			
//			System.out.println(check(arr,13));
			
		}
		
		out.close();
		
	}
	static boolean check(int arr[],int min) {
		int n=arr.length;
		int brr[]=new int[n];
		for(int i=n-1;i>1;i--) {
			if(brr[i]+arr[i]<min) return false;
			int cur= Math.min(arr[i], arr[i]+brr[i]-min);
//			System.out.println(cur+" ");
			int d=cur/3;
//			System.out.println(d);
			brr[i-1]+=d;
			brr[i-2]+=2*d;
		}
		
		return (arr[0]+brr[0]>=min)&&(arr[1]+brr[1]>=min);
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