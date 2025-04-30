import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
 
 
public class Codeforces {
	
	static int mod =1000000007; 
	static Set<Integer> set;
	public static void main(String[] args) throws Exception {
		PrintWriter out=new PrintWriter(System.out);
	    FastScanner fs=new FastScanner();
	    int t=fs.nextInt();
	    while(t-->0) {
	    	int n=fs.nextInt();
	    	int arr[]=new int[n];
//	    	set=new HashSet<>();
	    	for(int i=0;i<n;i++) {
	    		arr[i]=Math.abs(fs.nextInt());
//	    		set.add(arr[i]);
	    	}
//	    	sort(arr);
//	    	for(int i=0;i<n;i++) System.out.print(arr[i]+" ");
//	    	System.out.println();
//	    	if(set.size()<n||set.contains(0)) {
//	    		System.out.println("YES");
//	    		continue;
//	    	}
	    	boolean f=false;
	    	for(int i=0;i<n;i++) {
	    		boolean cur=recur(0,i,arr,0);
	    		if(cur) {
	    			f=true;
	    			break;
	    		}
	    	}
	    	if(f) System.out.println("YES");
	    	else System.out.println("NO");
	    }
	    out.close();
	}
	static boolean recur(int pos,int ind,int arr[],int sum) {
		if(pos==ind) return recur(pos+1,ind,arr,sum);
		if(sum==arr[ind]) return true;
		if(pos==arr.length) {
			return false;
		}
		
		if(recur(pos+1,ind,arr,sum+arr[pos])) return true;
		if(recur(pos+1,ind,arr,sum)) return true;
		if(recur(pos+1,ind,arr,sum-arr[pos])) return true;
		return false;
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