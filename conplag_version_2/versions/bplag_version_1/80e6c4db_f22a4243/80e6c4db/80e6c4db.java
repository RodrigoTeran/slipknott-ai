

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class C {
 
	public static void main(String[] args) {
		FastScanner fs=new FastScanner();
		int t=fs.nextInt();
		while(t-->0) 
		{
			int n;
			long k,sum=0L,temp=0L,min=Integer.MAX_VALUE;
			n=fs.nextInt();
			k=fs.nextLong();
			int[] arr=fs.readArray(n);
		    for(int i=0;i<n;i++)
		        sum+=arr[i];
		    sort(arr);
		    Stack<Integer> s=new Stack<>();
		    for(int i=1;i<n;i++){
		        s.push(arr[i]-arr[0]);
		    }
		    while(!s.empty() && sum>k){
		        min=Math.min(min,temp+(sum-k+temp)/(temp+1));
		        sum-=s.peek();
		        s.pop();
		        temp++;
		    }
		    if(sum>k){
		    	temp+=(sum-k+temp)/(temp+1);
		    }
		    System.out.println(Math.min(min, temp));
		}
	}
	public static void kThLexString(String st,int k, int n)
	{
	// Set to store the unique substring
	Set<String> z = new HashSet<String>();
	
	for(int i = 0; i < n; i++)
	{
	// String to create each substring
	String pp = "";
	
	for(int j = i; j < i + k; j++)
	{
	if (j >= n)
	break;
	pp += st.charAt(j);
	
	// Adding to set
	z.add(pp);
	}
	}
	
	// Converting set into a list
	Vector<String> fin = new Vector<String>();
	fin.addAll(z);
	
	// Sorting the strings int the list
	// into lexicographical order
	Collections.sort(fin);
	
	// Printing kth substring
	System.out.print(fin.get(k - 1));
	}
	static long gcd(long a, long b)
    {
      if (b == 0)
        return a;
      return gcd(b, a % b);
    }
 
	static void sort(int[] a) {
		ArrayList<Integer> l=new ArrayList<>();
		for (int i:a) l.add(i);
		Collections.sort(l);
		for (int i=0; i<a.length; i++) a[i]=l.get(i);
	}
	void shuffleArray(long[] arr){
        int n = arr.length;
        Random rnd = new Random();
        for(int i=0; i<n; ++i){
            long tmp = arr[i];
            int randomPos = i + rnd.nextInt(n-i);
            arr[i] = arr[randomPos];
            arr[randomPos] = tmp;
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