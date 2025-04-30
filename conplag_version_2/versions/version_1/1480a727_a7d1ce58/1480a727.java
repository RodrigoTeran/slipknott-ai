/*
 * Everything is Hard 
 * Before Easy 
 * Jai Mata Dii 
 */ 
 
import java.util.*;
import java.io.*; 
  
public class Main {
	static class FastReader{ BufferedReader br;StringTokenizer st;public FastReader(){br = new BufferedReader(new InputStreamReader(System.in));}String next(){while (st == null || !st.hasMoreElements()){try{st = new StringTokenizer(br.readLine());}catch (IOException  e){e.printStackTrace();}}return st.nextToken();}int nextInt(){ return Integer.parseInt(next());}long nextLong(){return Long.parseLong(next());}double nextDouble(){return Double.parseDouble(next());}String nextLine(){String str = ""; try{str = br.readLine(); } catch (IOException e) {e.printStackTrace();} return str; }} 
	static long mod = (long)(1e9+7); 
//	 static long mod = 998244353; 
//	 static Scanner sc = new Scanner(System.in); 
	static FastReader sc = new FastReader(); 
	static PrintWriter out = new PrintWriter(System.out);
	public static void main (String[] args) {
		int ttt = 1;
		ttt = sc.nextInt();
		z :for(int tc=1;tc<=ttt;tc++){
			int n = sc.nextInt();
			long d[] = new long[n];
			for(int i=0;i<n;i++) {
				d[i] = sc.nextLong();
			}
			long h[] = new long[n];
			for(int i=0;i<n;i++) {
				h[i] = sc.nextLong();
			}
			
			long req[] = new long[n];
			
			for(int i=n-1;i>0;i--) {
				long dif = d[i] - d[i-1];
				long nxt = 0;
				if(i+1<n) nxt = req[i+1];
				long cur = Math.max(nxt, h[i]);
				if(dif >= cur) {
					req[i] = 0;
				}
				else {
					req[i] = cur-dif;
				}
//				System.out.println(i+" "+req[i]);
			}
			
			long ans = 0, prev = 0;
			
			for(int i=0;i<n;i++) {
				if(i == 0) {
					ans = ans + sumFrom(0, h[i]);
					prev = h[i];
				}
				else {
					if(req[i] == 0) {
						ans = ans + sumFrom(0, h[i]);
						prev = h[i];
					}
					else {
						if(req[i]>prev) {
							ans = ans + sumFrom(prev, req[i]);
							ans = ans + sumFrom(req[i], req[i] + (d[i]-d[i-1]));
							prev = req[i] + d[i] - d[i-1];
						}
						else {
							ans = ans + sumFrom(prev, prev + (d[i]-d[i-1]));
							prev = prev + d[i] - d[i-1];
						}
					}
				}
			}
			
			out.write(ans+"\n");
		}
		out.close();
	}
	private static long sumFrom(long l, long cur) {
		long is1 = (cur*(cur+1))/2;
		long is2 = (l*(l+1))/2;
		
		return is1 - is2;
	}
	static long pow(long a, long b){long ret = 1;while(b>0){if(b%2 == 0){a = (a*a)%mod;b /= 2;}else{ret = (ret*a)%mod;b--;}}return ret%mod;}
	static long gcd(long a,long b){if(b==0) return  a; return gcd(b,a%b); } 
	private static void sort(int[] a) {List<Integer> k = new ArrayList<>();for(int val : a) k.add(val);Collections.sort(k);for(int i=0;i<a.length;i++) a[i] = k.get(i);} 
	private static void ini(List<Integer>[] tre2){for(int i=0;i<tre2.length;i++){tre2[i] = new ArrayList<>();}} 
	private static void init(List<int[]>[] tre2){for(int i=0;i<tre2.length;i++){tre2[i] = new ArrayList<>();}} 
	private static void sort(long[] a) {List<Long> k = new ArrayList<>();for(long val : a) k.add(val);Collections.sort(k);for(int i=0;i<a.length;i++) a[i] = k.get(i);} 
}