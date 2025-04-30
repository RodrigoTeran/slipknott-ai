//package Practise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public class AirConditioner {
	public static void main(String args[]) {
		FastScanner fs=new FastScanner();
		int t=fs.nextInt();
		for(int t1=0;t1<t;t1++) {
			int n=fs.nextInt();
			int k=fs.nextInt();
			int []arr1=new int[k];
			int []arr2=new int[k];
			arr1=fs.readArray(k);
			arr2=fs.readArray(k);
			int []dp=new int[n];
			//for(int i=0;i<k;i++)
				//dp[arr1[i]-1]=arr2[i];
			Arrays.fill(dp,Integer.MAX_VALUE/2);
			for(int i=0;i<k;i++) {
				dp[arr1[i]-1]=arr2[i];
			}
			for(int i=1;i<n;i++) {
				dp[i]=Math.min(dp[i],dp[i-1]+1);
			}
			//Print(dp);
			for(int i=n-2;i>=0;i--) {
				dp[i]=Math.min(dp[i], dp[i+1]+1);
			}
			//Print(dp);
			
			/*for(int i=0;i<n;i++) {
				int min=Integer.MAX_VALUE;
				for(int j=0;j<k;j++) {
					min=Math.min(min, arr2[j]+Math.abs(i-arr1[j]+1));
				}
				dp[i]=min;
			}*/
			for(int val:dp) {
				System.out.print(val+" ");
			}
			System.out.println();
		}
		
	}
	static final Random random=new Random();	
	static void ruffleSort(int[] a) {
		int n=a.length;//shuffle, then sort 
		for (int i=0; i<n; i++) {
			int oi=random.nextInt(n), temp=a[oi];
			a[oi]=a[i]; a[i]=temp;
		}
		Arrays.sort(a);
	}
	static void Print(int []arr) {
		for(int val:arr)
			System.out.print(val+" ");
		System.out.println();
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

