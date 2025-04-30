import java.io.*;
import java.util.*;

public class GFG {
    
    public static class Pair{
        long first;
        long second;
        Pair(long first,long second){
            this.first = first;
            this.second = second;
        }
    }
    public static int gcd(int a, int b)
    {
        // if b=0, a is the GCD
        if (b == 0)
            return a;
 
        // call the gcd() method recursively by
        // replacing a with b and b with
        // modulus(a,b) as long as b != 0
        else
            return gcd(b, a % b);
    }
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	     while(t-- > 0){
	         int n = sc.nextInt();
	         long pre = 0,ans = Long.MAX_VALUE;
	         long[] arr = new long[n];
	         PriorityQueue<Long> epq = new PriorityQueue<>();
	         PriorityQueue<Long> opq = new PriorityQueue<>();
	         for(int i=0;i<n;i++)
	         {
	             arr[i] = sc.nextLong();
	             if(i%2==0)
	             epq.add(arr[i]);
	             else
	             opq.add(arr[i]);
	             pre+=arr[i];
	             if(i>0)
	             ans = Math.min(ans,pre+(n-epq.size())*epq.peek()+(n-opq.size())*opq.peek());
	         }
	         System.out.println(ans);
	     }    
	}
}
