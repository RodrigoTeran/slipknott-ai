import java.io.*;
import java.util.*;
import java.math.BigInteger; 
import java.lang.*;




public class Main {
    
    static class sortLong implements Comparator<long[]>{
        public int compare(long[] a,long[] b){
          if(a[0] > b[0]) return 1;return -1;
        }
    }
    static class sortInt implements Comparator<int[]>{
        public int compare(int[] a,int[] b){
          if(a[1] > b[1]) return 1;return -1;
        }
    }
    
   public static String[] F(BufferedReader bf) throws Exception
    {
        return (bf.readLine().split(" "));
    }
    
   public static void pr(PrintWriter out,Object o)
   {
      
    out.println(o.toString());//out.flush();
    
   }
   public static void prW(PrintWriter out,Object o)
   {
      
    out.print(o.toString());//out.flush();
    
   }
   public static int intIn(String st)
   {
      return Integer.parseInt(st);
   }
   
   
    
    public static void pr(Object o)
    {
        System.out.println(o.toString());
    }
    public static void prW(Object o)
    {
        System.out.print(o.toString());
    }
    
   
    public static int inInt(String s)
    {
        return Integer.parseInt(s);
    }
    public static long in(String s)
    {
        return Long.parseLong(s);
    }
 
 
    static int[] toIntArray(String[] m) 
    { 
        int[] p=new int[m.length];
        for(int o=0;o<m.length;o++)
        {
            p[o]= inInt(m[o]);
        }
        return p;
    }
    static double[] toDArray(String[] m) 
    { 
        double[] p=new double[m.length];
        for(int o=0;o<m.length;o=0)
        {
            p[o]= Double.parseDouble(m[o]);
        }
        return p;
    }
    static long[] toLArray(String[] m) 
    { 
       long[] p=new long[m.length];
        for(int o=0;o<m.length;o++)
        {
            p[o]= in(m[o]);
        }
        return p;
    }
   
     static long gcd(long a, long b)
        {
          if (b == 0)
            return a;
          return gcd(b, a % b); 
        }
     
        static long pow(long x, long y, long p)
      {
        if(y == 0) return 1l;
        long res = 1; // Initialize result
     
        x = x % p; // Update x if it is more than or
        // equal to p
     
        if (x == 0)
          return 0l; // In case x is divisible by p;
     
        while (y > 0)
        {
     
          // If y is odd, multiply x with result
          if ((y & 1) != 0)
            res = (res * x) % p;
     
          // y must be even now
          y = y >> 1; // y = y/2
          x = (x * x) % p;
        }
        return res;
      }
    
   
    

   
   

   
    static long __gcd(long n1, long n2)
    {

        if(n1==0l) return n2;
        if(n2==0l) return n1;
        if(n1==1l || n2==1l) return 1l;
       // long gcd = 1;
        if(n1 == n2)  return n1;
        if(n1>n2) return __gcd(n1%n2,n2);
        return __gcd(n1,n2%n1);
        
    }
    
   
    public static int F(String[] arr,char ch){


      int[] nums = new int[arr.length];

      for(int i=0;i<arr.length;i++){
        String str = arr[i];int a=0;
        for(int j=0;j<str.length();j++){
              if(str.charAt(j) == ch){
                a++;
              }
        }
        //int b = (str.length()/2);
       // if((str.length()%2) != 0) b++;
        nums[i] = (2*a - (str.length()));
      }

      Arrays.sort(nums);
      int sum = 0;
      
   
      for(int i=arr.length-1;i>=0;i--){
        if((sum+nums[i]) <= 0){
          return  arr.length-1-i;
        }
        sum += nums[i];
      }

      return arr.length;
    }
    public static void main (String[] args) throws Exception {
        
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);;;//
        
        //int[] map=new int[1000001];
      
       int yy=inInt(bf.readLine());
       


        

        for(int w=0;w<yy;w++)
        {
             //String str = bf.readLine();
          out.flush();
         
            String[] xlp = bf.readLine().split(" ");
            
            //String st = bf.readLine();
      int n;//boolean bol=false;
           //  m;//long a,b,c;
           long k;long l;
          // int l;
           //int double avg  k;//pr(out,"vbc");
       // boolean bol = false;
           //long mod=1000000000+7
      n =inInt(xlp[0]);//int m = inInt(xlp[1]);//long b=in(xlp[3]);//long k=in(xlp[4]);
      String[] arr = new String[n];

      for(int i=0;i<n;i++){
        arr[i] = bf.readLine();
      }
      int ans=0;
      for(int i=0;i<5;i++){
        int v = F(arr,(char)(i+'a'));
       // pr(out,v+" "+i);
        ans = Math.max(ans,F(arr,(char)(i+'a')));

      }

      pr(out,ans);
      


      

   }
    out.close();//
   bf.close();//
       
}}


/*


Kickstart
 String rp;
            rp = "Case #"+(w+1)+": "+(n-ans)+" ";
static int[][] dir={{0,1},{1,0},{-1,0},{0,-1}};

static class SegmentTreeRMQ 
    { 
    int st[]; 
    int minVal(int x, int y) { 
        return (x > y) ? x : y; 
    } 
  
    
    int getMid(int s, int e) { 
        return s + (e - s) / 2; 
    } 
  
    
    int RMQUtil(int ss, int se, int qs, int qe, int index) 
    { 
        
        if (qs <= ss && qe >= se) 
            return st[index]; 
  
        // If segment of this node is outside the given range 
        if (se < qs || ss > qe) 
            return Integer.MIN_VALUE; 
  
        // If a part of this segment overlaps with the given range 
        int mid = getMid(ss, se); 
        return minVal(RMQUtil(ss, mid, qs, qe, 2 * index + 1), 
                RMQUtil(mid + 1, se, qs, qe, 2 * index + 2)); 
    } 
  
    // Return minimum of elements in range from index qs (query 
    // start) to qe (query end).  It mainly uses RMQUtil() 
    int RMQ(int n, int qs, int qe) 
    { 
        // Check for erroneous input values 
        
  
        return RMQUtil(0, n - 1, qs, qe, 0); 
    } 
  
    // A recursive function that constructs Segment Tree for 
    // array[ss..se]. si is index of current node in segment tree st 
    int constructSTUtil(int arr[], int ss, int se, int si) 
    { 
        // If there is one element in array, store it in current 
        //  node of segment tree and return 
        if (ss == se) { 
            st[si] = arr[ss]; 
            return arr[ss]; 
        } 
  
        // If there are more than one elements, then recur for left and 
        // right subtrees and store the minimum of two values in this node 
        int mid = getMid(ss, se); 
        st[si] = minVal(constructSTUtil(arr, ss, mid, si * 2 + 1), 
                constructSTUtil(arr, mid + 1, se, si * 2 + 2)); 
        return st[si]; 
    } 
  
    
    void con(int arr[]) 
    { 
        // Allocate memory for segment tree 
  
        //Height of segment tree 
        int n = (arr.length);
        int x = (int) (Math.ceil(Math.log(n) / Math.log(2))); 
  
        //Maximum size of segment tree 
        int max_size = 2 * (int) Math.pow(2, x) - 1; 
        st = new int[max_size]; // allocate memory 
  
        // Fill the allocated memory st 
        constructSTUtil(arr, 0, n - 1, 0); 
    }
    }
     static class DSU {
    
    int[] p;int[] sz;int op;int c;;
    int[] last;
    public void G(int n)
    {
        last=new int[n];
        p=new int[n];
        sz=new int[n];c=n;
        op=n;
        for(int h=0;h<n;h++)
        {
            sz[h]=1;p[h]=h;
            last[h]=h;
        }
    }
    public int find(int x)
    {
        int y=x;
        while(x!=p[x]) x=p[x];
        while(y!=p[y])
        {
            int tem=p[y];
            p[y]=x;y=tem;
        }
        return p[y];
    }
    public void union(int a,int b)
    {
        int x,y;
        x=find(a);y=find(b);
        if(x==y) return;
        if(sz[x]>sz[y])
        {
            p[y] = x;
            sz[x]+=sz[y];
            last[x]=Math.max(last[x],last[y]);
        }
        else
        {
            p[x]=y;sz[y]+=sz[x];
            last[y]=Math.max(last[y],last[x]);
        }
        c--;
        
    }}

    static long pow(long x, long y, long p)
      {
        long res = 1; // Initialize result
     
        x = x % p; // Update x if it is more than or
        // equal to p
     
        if (x == 0)
          return 0l; // In case x is divisible by p;
     
        while (y > 0)
        {
     
          // If y is odd, multiply x with result
          if ((y & 1) != 0)
            res = (res * x) % p;
     
          // y must be even now
          y = y >> 1; // y = y/2
          x = (x * x) % p;
        }
        return res;
      }
      static long gcd(long a, long b)
        {
          if (b == 0)
            return a;
          return gcd(b, a % b); 
        }
        static int gcd(int a, int b,int o)
        {
          if (b == 0)
            return a;
          return gcd(b, a % b,o); 
        }

Geometric median

public static double F(double[] x,double[] w)
    {
        double d1,d2;
        double S=0.00;
        for(double dp : w) S += dp;
        int k = 0;
        double sum = S - w[0]; // sum is the total weight of all `x[i] > x[k]`

        while(sum > S/2)
        {
            ++k;
            sum -= w[k];
        }
        d1=x[k];
        return d1;
        k = w.length-1;
       sum = S - w[k]; // sum is the total weight of all `x[i] > x[k]`

        while(sum > S/2)
        {
            --k;
            sum -= w[k];
        }
        d2=x[k];
        return new double[]{d1,d2};
    }
*/