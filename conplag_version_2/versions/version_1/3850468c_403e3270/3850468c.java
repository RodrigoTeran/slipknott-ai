
import java.io.*;
import java.util.*;
public class solution {
	static long cr[][]=new long[1001][1001];
	//static double EPS = 1e-7;
   static long mod=1000000007;
   
public static void main(String[] args)  {
	FScanner sc = new FScanner();
	//Arrays.fill(prime, true);
	//sieve();
	
	//ncr();
	int t=sc.nextInt();
	StringBuilder sb = new StringBuilder();
      while(t-->0) {	
      int n=sc.nextInt();
      long arr[]=new long[n];
      long dp[]=new long[n];
      long sum=0;
      for(int i=0;i<n;i++)
      {
    	  arr[i]=sc.nextInt();
    	  dp[i]=arr[i];
      }
        
      long l=0;long r=1000000000;
      long ans=0;
      while(l<=r)
      {
    	  long mid=(l+r)/2;
    	  dp=Arrays.copyOf(arr, n);
    	  if(solve(arr,dp,mid,n) )
    	  {
    		  ans=mid;
    		  l=mid+1;
    	  }
    	  else
    		  r=mid-1;
    	  
      }
      
      sb.append(ans);
        sb.append("\n");
	}
      System.out.println(sb.toString());
}  
 public static boolean solve(long arr[],long dp[],long sum,int n)
 {  
	  
	 for(int i=n-1;i>1;i--)
     {    if(dp[i]<=sum)
   	      continue;
   	  long val=Math.min(arr[i],dp[i]-sum)/3;
   	  dp[i-1]+=val;
   	  dp[i-2]+=2*val;
     }
     long min=Integer.MAX_VALUE;
     for(int i=0;i<n;i++)
     {
   	  min=Math.min(min,dp[i]);
     }
     if(min>=sum)
    	 return true;
     else
     return false;
 }

public static long gcd(long a,long b)
{   
	
     return b==0 ? a:gcd(b,a%b);	
	
}
     
 /* public static void sieve()
{   prime[0]=prime[1]=false;
int n=1000000;
	for(int p = 2; p*p <=n; p++)
    {
        if(prime[p] == true)
        {
          
            for(int i = p*p; i <= n; i += p)
                prime[i] = false;
        }
    }
   */

public static void ncr()
{
	cr[0][0]=1;
	for(int i=1;i<=1000;i++)
	{
		cr[i][0]=1;
		for(int j=1;j<i;j++)
		{
			cr[i][j]=(cr[i-1][j-1]+cr[i-1][j])%mod;
		}
		cr[i][i]=1;
	}
}

}
 
  class pair
  //implements Comparable<pair> 
  {
	int a;int b;
	 pair(int a,int b)
	{   
		this.b=b;
		this.a=a;
	}
	
}
 
 class FScanner {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer sb = new StringTokenizer("");
 
	String next(){
		while(!sb.hasMoreTokens()){
			try{
				sb = new StringTokenizer(br.readLine());
			} catch(IOException e){ }
		}
		return sb.nextToken();
	}
	String nextLine(){
		try{ return br.readLine(); } 
		catch(IOException e) { } return "";
	}
 
	int nextInt(){
		return Integer.parseInt(next());
	}
 
	long nextLong() {
		return Long.parseLong(next());
	}
 
	int[] readArray(int n) {
		int a[] = new int[n];
		for(int i=0;i<n;i++) a[i] = nextInt();
		return a;
	}
 
	float nextFloat(){
	return Float.parseFloat(next());
	}
	
	double nextDouble(){
	return Double.parseDouble(next());
	}
}