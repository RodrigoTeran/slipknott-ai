import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int modulo=998244353;
    public static void main(String[] args) {
       
        FastScanner in = new FastScanner();
        int test=in.nextInt();
        while(test-->0){
            int n=in.nextInt();
            int m=in.nextInt();
            int x=in.nextInt();
             PriorityQueue<pair> pq=new PriorityQueue<>();
            int arr[]=new int[n];
            for(int i=1;i<=m;i++){
                pq.add(new pair(i,0));
            }
            System.out.println("YES");
            for(int i=0;i<n;i++){
                pair p=pq.poll();
                int a=in.nextInt();
                p.y+=a;
                pq.add(p);
                System.out.print(p.x+" ");
            }
            
            
            
            System.out.println();
        }
        
        
       
        
        
//        int sum=in.nextInt();
//        
//        boolean dp[][]=new boolean[n+1][sum+1];
//        
//        for(int i=0;i<=n;i++){
//            for(int j=0;j<=sum;j++){
//                if(i==0)
//                    dp[i][j]=false;
//                if(j==0)
//                    dp[i][j]=true;
//                    
//            }
//        }
//        
//        for(int i=1;i<=n;i++){
//            for(int j=1;j<=sum;j++){
//                if(arr[i-1]<=j)
//                    dp[i][j]=(dp[i-1][j])||(dp[i-1][j-arr[i-1]]);
//                else
//                    dp[i][j]=dp[i-1][j];
//                
//            }
//        }
//         boolean flag=false;
//        for(int i=0;i<=n;i++){
//            if(dp[i][sum]==true){
//                flag=true;
//                System.out.println(1);
//                break;
//            }
//            
//        }
//        if(!flag)
//            System.out.println(0);
    }
    public static void solve1(int n,int arr[]){
        int b[]=new int[2*n+1];
        for(int i=0;i<n;i++){
            b[arr[i]]=i+1;
        }
        int count=0;
        for(int i=3;i<2*n;i++){
        for(int j=1;j*j<i;j++){
            if(i%j==0 && i!=j*j){
                if(b[j]+b[i/j]==i){
                    count++;
                }
            }
        }
    }
        System.out.println(count);
    }
    public static long modpow(long a, long b){
	    if(b==0){
	        return 1;
	    }
	    long x = modpow(a, b/2);
	    x = (x*x)%modulo;
	    if(b%2==1){
	        return (x*a)%modulo;
	    }
	    return x;
	}
    public static long factorial(long n){
        if(n==1) return 1;
        if(n==2) return 2;
        if(n==3) return 6;
        return n*factorial(n-1);
    }
    public static long benches(int n){
        return ncr(n,5)*n*(n-1)*(n-2)*(n-3)*(n-4);
    }
    public static long ncr(int n,int r){
        long dp[][]=new long[n+1][r+1];
        
        for(int i=0;i<=n;i++){
            for(int j=0;j<=Math.min(i,r);j++){
                if(j==0 ||j==i)
                    dp[i][j]=1;
                else{
                    dp[i][j]=dp[i-1][j]+dp[i-1][j-1];
                }
            }
        }
        
        return dp[n][r];
    }
    public static  long select(int n){
    return ncr(n,5)+ncr(n,6)+ncr(n,7);

    }
    public static long ncr1(int n,int r){
        long k=Math.max(r,n-r);
        long num=1;
        long den=1;
        long j=1;
        
        for(long i=n;i>k;i--){
            num*=i;
            den*=j;
            j++;
        }
        return num/den;
    }
    public static int countDiff(int arr[],int n,int diff){
        int sum=0;
       
        for(int i=0;i<n;i++){
            
            sum+=arr[i];
        }
        
        int max=sum/2;
        
        boolean dp[][]=new boolean[n+1][max+1];
        
        for(int i=0;i<=n;i++){
            for(int j=0;j<=max;j++){
                if(i==0)
                    dp[i][j]=false;
                if(j==0)
                    dp[i][j]=true;
            }
        }
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=max;j++){
                if(arr[i-1]<=j)
                    dp[i][j]=dp[i-1][j]||dp[i-1][j-arr[i-1]];
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        int min=0;
        int count=0;
        for(int j=0;j<=max;j++){
            min=0;
            if(dp[n][j]==true){
                min=sum-2*j;
                if(min==diff)
                    count++;
            }
        }
        
        return count;
    }
    public static int minimumDiff(int arr[],int n){
        int sum=0;
       
        for(int i=0;i<n;i++){
            
            sum+=arr[i];
        }
        
        int max=sum/2;
        
        boolean dp[][]=new boolean[n+1][max+1];
        
        for(int i=0;i<=n;i++){
            for(int j=0;j<=max;j++){
                if(i==0)
                    dp[i][j]=false;
                if(j==0)
                    dp[i][j]=true;
            }
        }
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=max;j++){
                if(arr[i-1]<=j)
                    dp[i][j]=dp[i-1][j]||dp[i-1][j-arr[i-1]];
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        int min=Integer.MAX_VALUE;
        for(int j=0;j<=max;j++){
            if(dp[n][j]==true){
                min=Math.min(min,sum-2*j);
            }
        }
        
        return min;
    }
    public static int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
         int dp[][]=new int[n+1][target+1];
         
         for(int i=0;i<=n;i++){
             for(int j=0;j<=target;j++){
                 if(i==0)
                 dp[i][j]=0;
                 
                 if(j==0)
                     dp[i][j]=1;
             }
         }
         
         for(int i=1;i<=n;i++){
             for(int j=1;j<=target;j++){
                 if(nums[i-1]<=j)
                     dp[i][j]=dp[i-1][j]+dp[i-1][j-nums[i-1]];
                 else
                     dp[i][j]=dp[i-1][j];
             }
         }
         
//         for(int i=0;i<=n;i++){
//             for(int j=0;j<=target;j++){
//                 System.out.print(dp[i][j]+" ");
//             }
//             System.out.println();
//         }
         
         return dp[n][target];
         
    }
    static int equalPartition(int n, int arr[],int sum)
    {
       
       
      
           int max=sum;
           boolean dp[][]=new boolean[n+1][max+1];
           
           for(int i=0;i<=n;i++){
               for(int j=0;j<=max;j++){
                   if(i==0)
                   dp[i][j]=false;
                   if(j==0)
                   dp[i][j]=true;
               }
           }
           
           for(int i=1;i<=n;i++){
               for(int j=1;j<=max;j++){
                   if(arr[i-1]<=j){
                       dp[i][j]=(dp[i-1][j]||dp[i-1][j-arr[i-1]]);
                   }
                   else{
                       dp[i][j]=dp[i-1][j];
                   }
               }
           }
           
           for(int i=0;i<=n;i++){
               for(int j=0;j<=max;j++){
                   System.out.print(dp[i][j]+" ");
               }
               System.out.println();
           }
           int count=0;
           for(int i=0;i<=n;i++){
            if(dp[i][max]==true){
               
                count++;
            }
            
        }
        return count;
       }
    
    public static long power(long base,long power){
        long res=1;
        while(power!=0){
            if(power%2==0){
                power/=2;
                base=(base*base);
            }
            else{
                power--;
                res=(res*base);
            }
            
        }
        return res;
    }
}
class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
 
		String next() {
			while (!st.hasMoreTokens())
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}
 
		int nextInt() {
			return Integer.parseInt(next());
		}
 
		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}
 
		long nextLong() {
			return Long.parseLong(next());
		}
	}
class pair implements Comparable<pair>
	    {
	        int x;
	        int y;
 
	        pair(int x, int y) {
	            this.x = x;
	            this.y = y;
	        }
	        public int compareTo(pair o)
	        {
	        	return (int)(y-o.y);
	        	
	        }
}