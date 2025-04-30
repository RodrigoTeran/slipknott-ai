import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.*;

public class B {
	static int tree[];
	static int up[];
	static int n;
	static int mod =1000000007; 
	public static void main(String[] args) throws Exception {
		PrintWriter out=new PrintWriter(System.out);
	    FastScanner fs=new FastScanner();
	    int t=fs.nextInt();
	   outer: while(t-->0) {
		    n=fs.nextInt();
		    int k=fs.nextInt();
		   int ac[]=fs.readArray(k);
		   int temp[]=fs.readArray(k);
		   int arr[]=new int[n];
		   Arrays.fill(arr, Integer.MAX_VALUE/2);
		   for(int i=0;i<k;i++) {
			   int ind = ac[i]-1;
			   arr[ind]=temp[i];
		   }
		   int ans[]=new int[n];
		   int left[]=new int[n];
		   Arrays.fill(left, Integer.MAX_VALUE/2);
//		   int right[]=new int[n];
		   left[0]=arr[0];
//		   Arrays.fill(right, Integer.MAX_VALUE/2);
		   
//		   right[n-1]=arr[n-1];
		   for(int i=1;i<n;i++) {
			   left[i]=Math.min(arr[i], left[i-1]+1);
		   }
		   ans[n-1]=Math.min(left[n-1],arr[n-1]);
		   for(int i=n-2;i>=0;i--) {
			   ans[i]=Math.min(Math.min(arr[i],left[i]),ans[i+1]+1);
		   }
//		   for(int i=0;i<n;i++) ans[i]=Math.min(left[i], right[i]);
		   for(int i=0;i<n;i++) out.print(ans[i]+" ");
		   out.println();
	   }
	    out.close();
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
		long res=1;
		for(int i=2;i<=n;i++) {
			res*=i;
			res%=mod;
		}
		return res;
	}
	static long pow(long a,long b) {
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