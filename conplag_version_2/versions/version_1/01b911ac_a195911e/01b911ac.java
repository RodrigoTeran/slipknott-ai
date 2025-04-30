import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.TreeMap;
import java.util.PriorityQueue;
import java.util.Collections;
import java.util.Stack;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Iterator;

public class First {

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int T = fs.nextInt();
        for (int tt = 0; tt < T; tt++) {

            solve(fs);
        }
        
    }
    static void solve(FastScanner fs)
    {
        int n=fs.nextInt();
        long[] times=takeLong(n, fs);
        long[] damage=takeLong(n, fs);
        long reqTime=times[n-1]-damage[n-1]+1;
        long ans=0;
        for(int i=n-1;i>=0;)
        {
            reqTime=times[i]-damage[i]+1;
            long time=times[i];
            i--;    
            while(i>=0 && times[i]>=reqTime)
            {
                long thisReqTime=times[i]-damage[i]+1;
                reqTime=Math.min(reqTime, thisReqTime);
                i--;
            }
            long x=time-reqTime+1;
            // pn(x);
            ans+=(x*(x+1)/2);



        }
        pn(ans);
    }
    static long MOD=(long)(1e9+7);
    static boolean check(String x, String ans)
    {
        if(x.length()!=ans.length()) return x.length()>ans.length();
        if(x.compareTo(ans) <= -1) return false;
        else return true;
    }
    static long gcd(long a, long b) 
    {
        if (a == 0)
            return b;    
        return gcd(b%a, a);
    }
    static void pn(Object o) { System.out.println(o); } 
    static void p(Object o) { System.out.print(o); }
    static void flush() { System.out.flush(); }

    static void debugInt(int[] arr)
    {
        for(int i=0;i<arr.length;++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    static void debugIntInt(int[][] arr)
    {
        for(int i=0;i<arr.length;++i)
        {
            for(int j=0;j<arr[0].length;++j)
                System.out.print(arr[i][j]+" ");
            System.out.println();
        }
        System.out.println();
    }
    static void debugLong(long[] arr)
    {
        for(int i=0;i<arr.length;++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    static void debugLongLong(long[][] arr)
    {
        for(int i=0;i<arr.length;++i)
        {
            for(int j=0;j<arr[0].length;++j)
                System.out.print(arr[i][j]+" ");
            System.out.println();
        }
        System.out.println();
    }
    static long[] takeLong(int n, FastScanner fs)
    {
        long[] arr=new long[n];
        for(int i=0;i<n;++i)
            arr[i]=fs.nextLong();
        return arr;
    } 
    static long[][] takeLongLong(int m, int n, FastScanner fs)
    {
        long[][] arr=new long[m][n];
        for(int i=0;i<m;++i)
            for(int j=0;j<n;++j)
                arr[i][j]=fs.nextLong();
        return arr;
    } 
    static int[] takeInt(int n, FastScanner fs)
    {
        int[] arr=new int[n];
        for(int i=0;i<n;++i)
            arr[i]=fs.nextInt();
        return arr;
    } 
    static int[][] takeIntInt(int m, int n, FastScanner fs)
    {
        int[][] arr=new int[m][n];
        for(int i=0;i<m;++i)
            for(int j=0;j<n;++j)
                arr[i][j]=fs.nextInt();
        return arr;
    } 
    static void sort(int[] a) {
        ArrayList<Integer> l=new ArrayList<>();
        for (int i:a) l.add(i);
        Collections.sort(l);
        for (int i=0; i<a.length; i++) a[i]=l.get(i);
    }
    static int getDecimalFromBinary(String s)
    {
        long no=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='1')
                no++;
            no=no<<1;
        }
        return (int)(no>>1);
    }
    static String getBinaryFromDecimal(int x)
    {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<31;++i)
        {
            if((x&1)==0)
                sb.append('0');
            else
                sb.append('1');
            x=x>>1;
        }
        return sb.reverse().toString();
    }
    static boolean[] sieve()
    {
        int size=(int)(1e5+5);
        boolean[] isPrime=new boolean[size];
        Arrays.fill(isPrime, true);
        for(int i=2;i<size;++i)
            for(int j=2*i;isPrime[i]==true && j<size;j+=i)
                isPrime[j]=false;

        return isPrime;
    }
    static class FastScanner {
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
        long nextLong() {
            return Long.parseLong(next());
        }
    }


}
class SortComp implements Comparator<String>
{
    public int compare(String s1, String s2)
    {
        if(s1.length()!=s2.length()) return s2.length()-s1.length();
        if(s1.compareTo(s2) <= -1) return 1;
        else return -1;
    }
}