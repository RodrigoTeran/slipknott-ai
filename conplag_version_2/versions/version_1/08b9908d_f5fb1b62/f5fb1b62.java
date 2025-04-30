//package graphs;
import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//import graphs.Segment_Trees.FastReader;

public class PW {
	
	//private static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static int memo[][];
	public static FastReader s = new FastReader();
	public static List<Long> primes;
	public static int sz= 1000000;
	//public static int arr[];
	public static int MOD=1000000007;
	public static List<List<Integer>> adj;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 
		//FastScanner sc=new FastScanner();
		 
		int t=s.nextInt();
		
		while(t-- >0)
		{
			
			//int n=0,a=0,b=0;
			int n=s.nextInt();
			int k=s.nextInt();
	
			  long arr[]=new long[n];
			  Arrays.fill(arr,Long.MAX_VALUE/10);
			  int ac[]=new int[k];
			  long tmp[]=new long[k];
			  for(int i = 0 ; i < k ; i++){
			    ac[i]=s.nextInt();
			    ac[i]--;
			  }
			  for(int i = 0 ; i < k ; i++){
			    tmp[i]=s.nextLong();
			    arr[ac[i]] = tmp[i];
			  }
			  long P[] = getP(arr, n);
			  
			  int i=0,j=arr.length-1;
			  while(i<=j)
			  {
				  long temp=arr[i];
				  arr[i]=arr[j];
				  arr[j]=temp;
				  i++;
				  j--;
			  }
			  //reverse(all(arr));
			  long[] S = getP(arr, n);
			  //reverse(all(S));
			  i=0;j=S.length-1;
			  while(i<=j)
			  {
				  long temp=S[i];
				  S[i]=S[j];
				  S[j]=temp;
				  i++;
				  j--;
			  }
			  for(i = 0 ; i < n ; i++){
			    System.out.print(Math.min(P[i], S[i])+" ");
			  }
			  System.out.println();
			
		}
		
	}
	
	public static long[] getP(long []arr, int n){
		  long mn = Long.MAX_VALUE/10;
		  long P[]=new long[n];
		  Arrays.fill(P, Long.MAX_VALUE/10);
		  int cnt = 0;
		  for(int i = 0 ; i < n ; i++){
		    long curr = arr[i];
		    if(mn + cnt < curr){
		      P[i] = mn + cnt;
		    }else{
		      mn = arr[i];
		      P[i] = arr[i];
		      cnt  = 0;
		    }
		    cnt++;
		  }
		  return  P;
		}
		
	public static void solve(int a[],int b[],int n,int m,int k)
	{
		List<Integer> ans = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
                    if (a[i] == 0) {
                ans.add(a[i]);
                k++;
                i++;
                continue;
            }
            if (b[j] == 0) {
                            ans.add(b[j]);
                k++;
                j++;
                continue;
            }
            if (a[i] > 0 && b[j] > 0) {
                if (a[i] <= b[j]) {
                    if (a[i] > k) {
                        System.out.println(-1);
                        return;
                    }
                    ans.add(a[i]);
                    i++;
                }
                else {
                    if (b[j] > k) {
                        System.out.println(-1);
                        return;
                    }
                    ans.add(b[j]);
                    j++;
                }
            }
        }
        while (i < n) {
            if (a[i] > k) {
                System.out.println(-1);
                return;
            }
            if (a[i] == 0) k++;
            ans.add(a[i++]);
        }
                   while (j < m) {
            if (b[j] > k) {
                System.out.println(-1);
                return;
            }
            if (b[j] == 0) k++;
            ans.add(b[j++]);
        }
        for (int x : ans) {
            System.out.print(x + " ");
        }
        System.out.println();
	}
		public static void dfs(int u, boolean visited[]){
		  visited[u] = true;
		  for(int v : adj.get(u)){
		    if(!visited[v])
		      dfs(v, visited);
		  }
		}
	
	public static boolean check(char c[][])
	{
		for(int i=0;i<c.length;i++)
		{
			for(int j=0;j<c[i].length;j++)
			{
				if(j+1<c[i].length && c[i][j]==c[i][j+1])
					return false;
				if(i+1<c.length && c[i][j]==c[i+1][j])
					return false;
				
			}
		}
		return true;
	}
	
	
	
	

	
	public static int solve(long n)
	{
		int c=0;
		for(long i=2;i<Math.sqrt(n);i++)
		{
			if(n%i==0)
			{
				while(n%i==0)
				{
					n/=i;
					c++;
				}
			}
		}
		
		if(n!=1)
			c++;
		
		return c;
	}
	
	public static boolean helper(int arr[], int i, int sum){
	     if(sum == 0){
	          return true;
	     }
	     if(i>=arr.length || sum < 0){
	          return false;
	     }
	     if(memo[i][sum] != -1){
	          return memo[i][sum]==0?false:true;
	     }
	     boolean ans1 = helper(arr,i+1,sum-arr[i]);
	     boolean ans2 = helper(arr,i+1,sum);
	     boolean fin=ans1||ans2;
	     if(fin==true)
	    	 memo[i][sum]=1;
	     else
	    	 memo[i][sum]=0;
	     return fin ;
	}
	
//	public static long fastExpo(long a, long n, long mod) {
//		  long result = 1;
//		  while (n > 0) {
//		    if ((n & 1)>0)
//		      result = (result * a) % mod;
//		    a = (a * a) % mod;
//		    n >>= 1;
//		  }
//		  return result;
//		}
//	1  4   8
	
	public static int digit(int n)
	{
		int c=0;
		while(n!=0)
		{
			n/=10;
			c++;
		}
		return c;
	}
	 
	public static int rev(String n)
	{
		String ans="";
		for(int i=n.length()-1;i>=0;i--)
			ans=ans+n.charAt(i);
		
		return Integer.valueOf(ans);
	}
	 
	public static boolean solve(HashMap<Integer,Integer> mp1,HashMap<Integer,Integer> mp2)
	{
		for(int i:mp2.keySet())
		{
			if(!mp1.containsKey(i))
				return false;
			
			if(mp1.get(i)<mp2.get(i))
				return false;
		}
		
		return true;
		
	}
	
	
	public static int count(int b[]){
		  int s = 0;
		  for (int i = 0; i < 32; i++) {
		    if(b[i]>0){
		      s |= (1<<i);
		    }
		  }
		  return s;
		}
	
	public static void remove(int b[], int val){
		  for (int i = 0; i < 32; i++) {
		    if(((val>>i)&1)==1)
		      b[i]--;
		  }
		}
	
	public static void add(int b[], int val){
		  for (int i = 0; i < 32; i++) {
		    if(((val>>i)&1)==1)
		      b[i]++;
		  }
		}
	    public static String largestNumber( List<String> ab) {
	        
	       // List<String> ab= new ArrayList<>();
	       // for(int i=0;i<A.size();i++)
	       // {
	       //     ab.add(String.valueOf(A.get(i)));
	       // }
	        
	        Collections.sort(ab, new Comparator<String>(){ 
	            
	            public int compare(String X, String Y) { 
	          
	        // first append Y at the end of X 
	        String XY=X + Y; 
	          
	        // then append X at the end of Y 
	        String YX=Y + X; 
	          
	        // Now see which of the two formed numbers  
	        // is greater 
	        return XY.compareTo(YX)>0?-1:1; 
	            
	                
	            }
	            
	            
	            
	        });
	        StringBuilder abc= new StringBuilder();
	        
	        
	        for(int i=0;i<ab.size();i++)
	        {
	           abc.append(ab.get(i));
	            
	        }
	        if(abc.length()==0)
	            return abc.toString();
	        
	        if(abc.charAt(0)=='0')
	        return "0";
	        else
	        return abc.toString();
	        
	    }
	
	public static boolean pal(String s)
	{
		int i=0;
		int j=s.length()-1;
		while(i<=j)
		{
			if(s.charAt(i)!=s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}
	
	
	
	
	static class FastReader {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader()
        {
            br = new BufferedReader(
                new InputStreamReader(System.in));
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt() { return Integer.parseInt(next()); }
 
        long nextLong() { return Long.parseLong(next()); }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
 
        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

	
	public static long solve(int n, int r)
    {


        long p = 1, k = 1;
        if (n - r < r) {
            r = n - r;
        }
 
        if (r != 0) {
            while (r > 0) {
                p *= n;
                k *= r;
 
                long m = __gcd(p, k);
 
                
                p /= m;
                k /= m;
 
                n--;
                r--;
            }
 
           
        }
        else {
            p = 1;
        }
 
        
        //System.out.println(p);
        return p;
    }
	
	
	public static long gcd(long a,long b)
	{
		if(a==0||b==0)
			return a+b;
		return gcd(b,(a%b));
	}
	
	public static long __gcd(long n1, long n2)
    {
        long gcd = 1;
 
        for (int i = 1; i <= n1 && i <= n2; ++i) {
            // Checks if i is factor of both integers
            if (n1 % i == 0 && n2 % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }
	
	public static boolean prime(int n)
	{
		if(n<=2)
			return true;
		
		for(int i=2;i<=Math.sqrt(n);i++)
		{
			if(n%i==0)
				return false;
		}
		
		return true;
		
	}
	public static long fastExpo(long a,long n,long mod){
        if (n == 0)
            return 1;
        else{
            long x = fastExpo(a,n/2,mod);
            if ((n&1) == 1){
                return (((a*x)%mod)*x)%mod;
            }
            else{
                return (((x%mod)*(x%mod))%mod)%mod;
            }
        }
    }
}
class pair{
	//public:
		int f;
		long s;
		pair(int x,long y)
		{
			f=x;
			s=y;
		}
        
}
 class FastScanner {
    BufferedReader br;
    StringTokenizer st;

    public FastScanner()
    {
        br = new BufferedReader(
                new InputStreamReader(System.in));
    }

    String next()
    {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() { return Integer.parseInt(next()); }

    long nextLong() { return Long.parseLong(next()); }

    double nextDouble()
    {
        return Double.parseDouble(next());
    }

    String nextLine()
    {
        String str = "";
        try {
            str = br.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}


