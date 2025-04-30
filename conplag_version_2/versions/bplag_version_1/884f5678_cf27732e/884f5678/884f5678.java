import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class JaiShreeRam{
	static Scanner in=new Scanner();
	static long mod = 1000000007;
	static ArrayList<ArrayList<Integer>> adj;
	public static void main(String[] args) throws Exception{
		class Element{
			int x;
			char c;
			public Element(int y,char k) {
				x=y;
				c=k;
			}
		}
		int z=in.readInt();
		while(z-->0) {
			int n=in.readInt();
			int a[]=nia(n);
			char c[]=in.readString().toCharArray();
			ArrayList<Integer> d=new ArrayList<>();
			ArrayList<Integer> in=new ArrayList<>();
			for(int i=0;i<n;i++) {
				if(c[i]=='R') {
					in.add(a[i]);
				}
				else {
					d.add(a[i]);
				}
			}
			String ans="YES";
			Collections.sort(d);
			int k=1;
			for(int i:d) {
				if(i<k) {
					ans="NO";
				}
				k++;
			}
			Collections.sort(in);
			for(int i=in.size()-1;i>=0;i--) {
				if(in.get(i)>n) {
					ans="NO";
					break;
				}
				n--;
			}
			System.out.println(ans);
		}
	}
	static long ans(long l,long r,long x,long y) {
		long mid=(r-l)/2+l;
		long a=mid%x;
		long b=y%mid;
		long c=0;
		if(l>r) {
			return 0;
		}
		if(a==b) {
			return mid;
		}
		else if(a<b) {
			c=ans(l,mid-1,x,y);
			if(c==0) {
				c=ans(mid+1,r,x,y);
			}
		}
		else{
			c=ans(l,mid-1,x,y);
			if(c==0) {
				c=ans(mid+1,r,x,y);
			}
		}
		return c;
	}
	static int[] nia(int n){
		int[] arr= new int[n];
		int i=0;
		while(i<n){
			arr[i++]=in.readInt();
		}
		return arr;
	}
	static long[] nla(int n){
		long[] arr= new long[n];
		int i=0;
		while(i<n){
			arr[i++]=in.readLong();
		}
		return arr;
	}
	static int[] nia1(int n){
		int[] arr= new int[n+1];
		int i=1;
		while(i<=n){
			arr[i++]=in.readInt();
		}
		return arr;
	}
	static long gcd(long a, long b) {
		if (b==0) return a;
		return gcd(b, a%b);
	}
	static class Scanner{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
		String readString() {
			while (!st.hasMoreTokens())
				try {
					st=new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}
		double readDouble() {
			return Double.parseDouble(readString());
		}
		int readInt() {
			return Integer.parseInt(readString());
		}
		long readLong() {
			return Long.parseLong(readString());
		}
	}	
}