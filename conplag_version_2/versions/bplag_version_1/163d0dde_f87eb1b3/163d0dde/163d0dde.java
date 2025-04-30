// Working program with FastReader 
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.*;
  
public class aa
{ 
    static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 
   public static int findIndex(long arr[], long t) 
    { 
  
        // if array is Null 
        if (arr == null) { 
            return -1; 
        } 
  
        // find length of array 
        int len = arr.length; 
        int i = 0; 
  
        // traverse in the array 
        while (i < len) { 
  
            // if the i-th element is t 
            // then return the index 
            if (arr[i] == t) { 
                return i; 
            } 
            else { 
                i = i + 1; 
            } 
        }
        return -1;
    }
    public static void main(String[] args) 
    {
            FastReader d=new FastReader();
            int t,i,j,c,z,k,l,n;
            int mod = (int) 1e9 + 7;
            int Inf=Integer.MAX_VALUE;
            int negInf=Integer.MIN_VALUE;
        t=d.nextInt();
        //t=1;
        //String s;
        //char ch,ch1,ch2,ch3;
        while(t-->0)
        {
            z=c=0;
            n=d.nextInt();
            int a[]=new int[n];
            for(i=0;i<n;i++)
            a[i]=d.nextInt();
            //s=d.nextLine();//dont need extra d.nextLine()
            long p=0;
            long ans;
            long x,y;
            long e,o;
            ans=Long.MAX_VALUE;
            x=y=Integer.MAX_VALUE;
            e=o=n;
            for(i=0;i<n;i++) {
                if(i%2==1) {
               	p+=a[i];
               	e--;
               	x=Long.min(x, a[i]);
               	ans=Long.min(ans,p+(o*y)+(e*x));
               	}
               	else {
               	p+=a[i];
               	o--;
               	y=Long.min(y, a[i]);
               	ans=Long.min(ans,p+(o*y)+(e*x));
                	}
                }
                System.out.println(ans);
        }
    } 
} 