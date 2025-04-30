import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntToLongFunction;
import java.lang.*;
import java.io.*;
import java.math.*;
public final class CF
{
     public static void main(String[]args)throws IOException
    {
        FastReader ob=new FastReader();
        int t=ob.nextInt();
        StringBuffer sb=new StringBuffer();
        while(t-->0)
        {
            int n=ob.nextInt();
            PriorityQueue<Long> a=new PriorityQueue<>();
            PriorityQueue<Long> b=new PriorityQueue<>();
            long ans=Long.MAX_VALUE;
            long sum=0;
            for(int i=0;i<n;i++)
            {
               long x=ob.nextInt();
               if(i%2==0)
               a.add(x);
               else
               b.add(x);  
               sum+=x;
               if(i!=0)
               ans=Math.min(ans,sum+(a.peek()*(n-a.size()))+(b.peek()*(n-b.size())));
            }
            
            sb.append(ans+"\n");
        }
        System.out.println(sb);
    }
}
class Pair implements Comparable<Pair>
{
    int x,y;
    Pair(int x,int y)
    {
        this.x=x;
        this.y=y;
    }
    @Override
    public int compareTo(Pair a) {
        return a.y-y;
    }
}
class FastReader {
    BufferedReader br;
    StringTokenizer st;
    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e)  {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }
    public String nextLine()
    {
        String s="";
        try {
        s=br.readLine();
        } catch (IOException e)  {
                e.printStackTrace();
            }
        return s;
    }
    public int nextInt() {
        return Integer.parseInt(next());
    }
    public long nextLong() {
        return Long.parseLong(next());
    }
    public double nextDouble() {
        return Double.parseDouble(next());
    }
}
