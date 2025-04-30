import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class a{ 
    public static void main(String args[]) throws java.lang.Exception{ 
    	FastScanner s=new FastScanner();
		PrintWriter out=new PrintWriter(System.out);
		int t=s.nextInt();
		for(int tt=0;tt<t;tt++) {
			int n=s.nextInt(),k=s.nextInt();
			int pos[]=s.readArray(k);
			int temp[]=s.readArray(k);
			long ans[]=new long[n];
			Arrays.fill(ans,Integer.MAX_VALUE);
			for(int i=0;i<k;i++){
				ans[pos[i]-1]=temp[i];
			}
			for(int i=1;i<n;i++){
				ans[i]=Math.min(ans[i-1]+1,ans[i]);
			}
			for(int i=n-2;i>=0;i--){
				ans[i]=Math.min(ans[i],ans[i+1]+1);
			}
			for(int i=0;i<n;i++){
				out.print(ans[i]+" ");
			}
			out.println();
		}
		out.close();
    }
	static boolean isPrime(int n){
        if (n <= 1)
            return false;
        else if (n == 2)
            return true;
        else if (n % 2 == 0)
            return false;
        for (int i = 3; i <= Math.sqrt(n); i += 2){
            if (n % i == 0)
                return false;
        }
        return true;
    }
    static void sort(long [] a) {
		ArrayList<Long> l=new ArrayList<>();
		for (long i:a) l.add(i);
		Collections.sort(l);
		for (int i=0; i<a.length; i++) a[i]=l.get(i);
	}
	static void sort(char [] a) {
		ArrayList<Character> l=new ArrayList<>();
		for (char i:a) l.add(i);
		Collections.sort(l);
		for (int i=0; i<a.length; i++) a[i]=l.get(i);
	}
    static void sort(int [] a) {
		ArrayList<Integer> l=new ArrayList<>();
		for (int i:a) l.add(i);
		Collections.sort(l);
		for (int i=0; i<a.length; i++) a[i]=l.get(i);
	}
    static int gcd(int a, int b){
      if (b == 0)
        return a;
      return gcd(b, a % b);
    }
    static void sortcol(int a[][],int c) {
		Arrays.sort(a, (x, y) -> {
			if(x[c]>y[c]) {
				return 1;
			}else {
				return -1;
			}
		});
	}
    public static void printb(boolean ans) {
    	if(ans) {
    		System.out.println("Yes");
    	}else {
    		System.out.println("No");
    	}
    }
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
		double nextDouble() {
			return Double.parseDouble(next());
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
    static class Pair implements Comparable<Pair>{
    	int a , b; 
    	Pair(int x , int y){
    		a=x;
    		b=y;
    	}
    	public int compareTo(Pair o) {
    		return a != o.a ? a - o.a : b - o.b;
    	}
    }
}
