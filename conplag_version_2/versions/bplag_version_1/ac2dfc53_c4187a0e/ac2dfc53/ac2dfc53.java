import java.io.*;

import java.util.*;
/*




*/

 
 public class C{
	static FastReader fs=null;
	static Scanner sc=null;
	
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		int t=sc.nextInt();
		
		for(int tt=0;tt<t;tt++) {
			int n=sc.nextInt();
			
			boolean visited[]=new boolean[n+1];
			int p[]=new int[n+1];
			for(int i=1;i<=n;i++) {
				if(visited[i])continue;
				
				while(true) {
					int val=Query(i);
					if(val==i)break;
				}
				
				int cur=i;
				while(!visited[cur]) {
					int val=Query(i);
					visited[cur]=true;
					p[cur]=val;
					cur=val;
				}
			}
			
			System.out.print("! ");
			for(int i=1;i<=n;i++)System.out.print(p[i]+" ");
			System.out.println();
		}
	}
	static int Query(int id) {
		System.out.println("? "+id);
		int val=sc.nextInt();
		return val;
	}
	
	static int[] ruffleSort(int a[]) {
		ArrayList<Integer> al=new ArrayList<>();
		for(int i:a)al.add(i);
		Collections.sort(al);
		for(int i=0;i<a.length;i++)a[i]=al.get(i);
		return a;
	}
	
	static void print(int a[]) {
		for(int e:a) {
			System.out.print(e+" ");
		}
		System.out.println();
	}
	
	static class FastReader{
		
		StringTokenizer st=new StringTokenizer("");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String next() {
			while(!st.hasMoreTokens()) 
				try {
					st=new StringTokenizer(br.readLine());
				}
			   catch(IOException e){
				   e.printStackTrace();
			   }
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		int[] readArray(int n) {
			int a[]=new int[n];
			for(int i=0;i<n;i++)a[i]=sc.nextInt();
			return a;
		}
	}
	
	
}
