//package com.company;
//import java.math.BigInteger;
import java.util.*;
//import java.util.Stack;
import java.io.BufferedReader;
import java.io.IOException;
//import java.io.*;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.SortedSet;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStream;
public class Main {


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

    public static int gcd(int a, int b)
    {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

     static class obj{
           long a1;
           long a2;
           //int a3;
           obj(long a1,long a2){
               this.a1=a1;
               this.a2=a2;
              // this.a3=a3;
           }
       }
       static  class sortby implements Comparator<obj>{
           public   int compare(obj o1,obj o2){
               return o1.a1>o2.a1?1:-1;
           }
       }
    static int LowerBound(int a[], int x) { // x is the target value or key
        int l=-1,r=a.length;
        while(l+1<r) {
            int m=(l+r)>>>1;
            if(a[m]>=x) r=m;
            else l=m;
        }
        return r;
    }
    static int UpperBound(int a[], int x) {// x is the key or target value
        int l=-1,r=a.length;
        while(l+1<r) {
            int m=(l+r)>>>1;
            if(a[m]<=x) l=m;
            else r=m;
        }
        return l+1;
    }
    static long power(long x,long y,long p){
        String b1=""+y;
        long d=p;
        long reminderb=0;
        for(int i=0;i<b1.length();i++){
            reminderb=(reminderb*10+b1.charAt(i)-'0')%d;
        }
        y=reminderb;
        long res=1;
        x=x%p;
        while(y>0){
            if((y&1)>0)
                res=(res*x)%p;
            y=y>>1;
            x=(x*x)%p;
        }
        return res;
    }
    static boolean isComposite(int n)
    {
        // Corner cases
        if (n <= 1)
            System.out.println("False");

        if (n <= 3)
            System.out.println("False");

        // This is checked so that we can skip
        // middle five numbers in below loop
        if (n % 2 == 0 || n % 3 == 0) return true;

        for (int i = 5; i * i <= n; i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return true;

        return false;
    }

    //static ArrayList<Integer>[] a;
   // static int[] vis;
    //static int[] col;
  /*  static boolean dfs(int i,int c){
        vis[i]=1;
        col[i]=c;
        //System.out.println(i+" "+c);
        for(int j:a[i]){
            if(vis[j]==0) {
                if (dfs(j, c ^ 1) == false)
                    return false;
            }
            else
                if(col[i]==col[j])
                    return false;
        }
        return true;
    }*/
   static int[] m;
    static int solve(int p,long d){
        if(p<1)
            return 0;
        if(m[p]!=0)
            return m[p];
      if(p==1)
          return 1;
      long to=0;
       for(int i=1;i<=p-1;i++){
           to+=solve(i,d);
           to=to%d;
       }
       for(int i=p;i>=2;i--){
           to+=solve(p/i,d);
           to=to%d;
       }
       m[p]=(int)to;
       return m[p];
   }
   static long[][] dis;
   // static long d=1000000007;
   public static long solve(long[] arr,int i,int j){
       if(i>j){
           return 0;
       }
       if(dis[i][j]!=-1)
       {
           return dis[i][j];
       }

       if(i==j){
           return arr[i];
       }
       long c=0;
     c=Math.max(arr[i]+Math.min(arr[j-1]+solve(arr,i+1,j-1),arr[i+1]+solve(arr,i+2,j)),arr[j]+Math.min(solve(arr,i+1,j-1),solve(arr,i,j-2)));
      dis[i][j]=c;
return c;
   }
    public static void main(String[] args) {
        FastReader s = new FastReader();
        //InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        PrintWriter out = new PrintWriter(outputStream);
        //Scanner s=new Scanner(System.in);
         int t = s.nextInt();

        while(t-->0) {
            int n = s.nextInt();
            int m = s.nextInt();
            int x=s.nextInt();
            long[] a = new long[n];
            for(int i=0;i<n;i++){
                a[i]=s.nextInt();
            }
           out.println("YES");
            PriorityQueue<obj> p = new PriorityQueue<>(new sortby());
            for (int i = 0; i <m; i++) {
             p.add(new obj(a[i],i+1));
             out.print(i+1+" ");
            }
            for(int i=m;i<n;i++){
                obj o=p.poll();
                p.add(new obj(o.a1+a[i],o.a2));
                out.print(o.a2+" ");
            }
            out.println();
        }
       out.close();

}}
