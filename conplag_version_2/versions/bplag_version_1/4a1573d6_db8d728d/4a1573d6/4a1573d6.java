

import java.util.*;
import java.math.*;
import java.io.*; 
 public class A{

static FastReader scan=new FastReader();
 public static PrintWriter out = new PrintWriter (new BufferedOutputStream(System.out));
  static LinkedList<Integer>edges[];
  static boolean stdin = true;
    static String filein = "input";
    static String fileout = "output";
static int dx[] = { -1, 0, 1, 0 };
static int dy[] = { 0, 1, 0, -1 };
int dx_8[]={1,1,1,0,0,-1,-1,-1};
int dy_8[]={-1,0,1,-1,1,-1,0,1};
static char sts[]={'U','R','D','L'};
static boolean prime[];
static long LCM(long a,long b){
    return (Math.abs(a*b))/gcd(a,b);
   }
    public static int upperBound(long[] array, int length, long value) {
        int low = 0;
        int high = length;
        while (low < high) {
            final int mid = low+(high-low) / 2;
            if ( array[mid]>value) {
                high = mid ;
            } else {
                low = mid+1;
            }
        }
        return low;
    }
   static long gcd(long a, long b) {
    if(a!=0&&b!=0)
        while((a%=b)!=0&&(b%=a)!=0);
    return a^b;
}
static int countSetBits(int n) 
    { 
        int count = 0; 
        while (n > 0) { 
            if((n&1)!=1)
                count++;
            //count += n & 1; 
            n >>= 1; 
        } 
        return count; 
    } 
 static void sieve(long n) 
    { 
        
        prime = new boolean[(int)n+1]; 
        for(int i=0;i<n;i++) 
            prime[i] = true; 
          
        for(int p = 2; p*p <=n; p++) 
        { 
           
            if(prime[p] == true) 
            { 
                
                for(int i = p*p; i <= n; i += p) 
                    prime[i] = false; 
            } 
        } 
    }  
  
 
 
           static boolean isprime(long x)
           {
            for(long i=2;i*i<=x;i++)
                if(x%i==0)
                    return false;
                return true;
           }
           static int perm=0,FOR=0;
           
     

static boolean flag=false;
static int len=100000000;

static ArrayList<Pair>inters=new ArrayList<Pair>();





static StringBuilder sb;
static void swap(int i,int j,StringBuilder st)
{
    char tmp=st.charAt(i);
    st.setCharAt(i,st.charAt(j));
    st.setCharAt(j,tmp);
}


 private static int next(int[] arr, int target)  
    {  
        int start = 0, end = arr.length - 1;  
    
        int ans = -1;  
        while (start <= end) {  
            int mid = (start + end) / 2;  
    
            // Move to right side if target is  
            // greater.  
            if(arr[mid]==target)
                return mid;
            if (arr[mid] <target) {  
                start = mid + 1;  
            }  
    
            // Move left side.  
            else {  
                ans = mid;  
                end = mid - 1;  
            }  
        }  
        return ans;  
    }  
//static boolean vis[][];
    static long solve(int h,long n,int cur)
    {
        if(h==0)
            return 0;
        long half=1L<<(h-1);
        if(n<=half)
        {
            if((cur^1)==0)
                return 1+solve(h-1,n,0);
            else 
                return 2*half+solve(h-1,n,0);
        }
        else 
        {
              if((cur^1)==0)
             return 2*half+solve(h-1,n-half,1);
            else 
                return 1+solve(h-1,n-half,1);
        }
    }

  
public static class comp1 implements Comparator<String>{  
public int compare(String o1,String o2){
return o1.length()-o2.length(); 
}
  }
  public static class comp2 implements Comparator<String>{  
public int compare(String o1,String o2){
return o1.compareTo(o2); 
}
  }
  static StringBuilder a,b;

    static boolean isPowerOfTwo(int n)
{
    if(n==0)
    return false;
 
return (int)(Math.ceil((Math.log(n) / Math.log(2)))) == 
       (int)(Math.floor(((Math.log(n) / Math.log(2)))));
}
static ArrayList<Integer>v;
static ArrayList<Integer>pows;
static void block(long x) 
{ 
   v = new ArrayList<Integer>(); 
      
    pows=new ArrayList<Integer>();
   
    while (x > 0)  
    { 
        v.add((int)x % 3); 
        x = x / 3; 
    } 
  
    // Displaying the output when 
    // the bit is '1' in binary 
    // equivalent of number. 
    for (int i = 0; i < v.size(); i++)  
    { 
        if (v.get(i)==1||v.get(i)==0)  
        { 
      pows.add(i); 

        } 
    } 

} 


   static long mod=(long)(1e9)+7;
    static int countWaysUtil(int x, int n, int num) 
    { 
        // Base cases 
        int val = (int) (x - Math.pow(num, n)); 
        if (val == 0) 
            return 1; 
        if (val < 0) 
            return 0; 
       
        // Consider two possibilities, num is 
        // included and num is not included. 
        return countWaysUtil(val, n, num + 1) + 
               countWaysUtil(x, n, num + 1); 
    }
       static int countWays(int x, int n) 
    { 
        return countWaysUtil(x, n, 1); 
    } 
    static int dp[][];
    static int n;
    static int arr[];
        static int rec(int i,int prev)
        {
            if(i==n)
                return 0;
            if(dp[i][prev]!=-1){
                //out.println("FUCK");
                return dp[i][prev];
            }
            if(i==0)
                return dp[i][prev]=Math.max(rec(i+1,1),rec(i+1,0));
            else 
            return dp[i][prev]=Math.max(rec(i+1,0)+Math.abs(arr[i]-(prev==0?arr[i-1]:1)),rec(i+1,1)+Math.abs(1-(prev==0?arr[i-1]:1)));
        }
        static boolean can(int i,int j)
        {
            int x=i,y=j;
            int x2=Math.abs(y-x),y2=y+x;
            if(x>=x2&&y<=y2)
                return true;
            return false;
        }
public static void main(String[] args)  throws Exception 
{
//SUCK IT UP AND DO IT ALRIGHT
//scan=new FastReader("div7.in");
//out = new PrintWriter("div7.out");
   //System.out.println(countSetBits(2015));
    //int elem[]={1,2,3,4,5};
//System.out.println("avjsmlfpb".compareTo("avjsmbpfl"));
int tt=1;

/*for(int i=0;i<=100;i++)
    if(prime[i])
        arr.add(i);
    System.out.println(arr.size());*/
   // check(new StringBuilder("05:11"));
   // System.out.println(26010000000000L%150);
   tt=scan.nextInt();

outer:while(tt-->0)
{
 int n=scan.nextInt(),m=scan.nextInt();
 char board[][]=new char[n][m];
 for(int i=0;i<n;i++)
    board[i]=scan.next().toCharArray();
ArrayList<Pair>res[]=new ArrayList[3*n*m];
for(int i=0;i<3*n*m;i++)
res[i]=new ArrayList();
int k=0;
for(int i=0;i<n;i++)
{
    for(int j=0;j<m;j++)
    {
        ArrayList<Pair>arr=new ArrayList<Pair>();
        ArrayList<Pair>arr2=new ArrayList<Pair>();
        if(i+1<n&&j+1<m)
        {
            if(board[i][j]=='1')
                arr.add(new Pair(i,j));
            else arr2.add(new Pair(i,j));
            if(board[i][j+1]=='1')
                arr.add(new Pair(i,j+1));
            else  arr2.add(new Pair(i,j+1));
            
            if(board[i+1][j]=='1')
                arr.add(new Pair(i+1,j));
            else arr2.add(new Pair(i+1,j));
            if(board[i+1][j+1]=='1')
                arr.add(new Pair(i+1,j+1));
            else arr2.add(new Pair(i+1,j+1));
            if(arr.size()==3)
            {
                for(Pair p:arr){
                    board[p.x][p.y]='0';
                    res[k].add(new Pair(p.x,p.y));
                }
                k++;
            }
            else if(arr.size()==2)
            {
                for(Pair p:arr2)
                {
                    board[p.x][p.y]='1';
                     res[k].add(new Pair(p.x,p.y));
                }
                //k++;
                Pair p=arr.get(0);
                board[p.x][p.y]='0';
                res[k].add(new Pair(p.x,p.y));
                k++;
                for(Pair pp:arr2)
                {
                    board[pp.x][pp.y]='0';
                    res[k].add(new Pair(pp.x,pp.y));
                }
                p=arr.get(1);
                board[p.x][p.y]='0';
                res[k].add(new Pair(p.x,p.y));
                k++;
            }
            else if(arr.size()==1)
            {
                Pair p=arr.get(0);
                Pair tmp=new Pair(p.x,p.y);
                board[p.x][p.y]='0';
                res[k].add(new Pair(p.x,p.y));
                p=arr2.get(1);
                 board[p.x][p.y]='1';
                res[k].add(new Pair(p.x,p.y));
                  p=arr2.get(2);
                 board[p.x][p.y]='1';
                res[k].add(new Pair(p.x,p.y));
                k++;
                arr=new ArrayList();
                arr.add(new Pair(arr2.get(1).x,arr2.get(1).y));
                arr.add(new Pair(arr2.get(2).x,arr2.get(2).y));
                arr2.remove(1);
                arr2.remove(1);
                arr2.add(new Pair(tmp.x,tmp.y));

                for(Pair pp:arr2)
                {
                    board[pp.x][pp.y]='1';
                     res[k].add(new Pair(pp.x,pp.y));
                }
                //k++;
                 p=arr.get(0);
                board[p.x][p.y]='0';
                res[k].add(new Pair(p.x,p.y));
                k++;
                for(Pair pp:arr2)
                {
                    board[pp.x][pp.y]='0';
                    res[k].add(new Pair(pp.x,pp.y));
                }
                p=arr.get(1);
                board[p.x][p.y]='0';
                res[k].add(new Pair(p.x,p.y));
                k++;
            }
            else if(arr.size()==4)
            {
                Pair p=arr.get(0);
                board[p.x][p.y]='0';
                arr2.add(new Pair(p.x,p.y));
                res[k].add(new Pair(p.x,p.y));
                 p=arr.get(1);
                board[p.x][p.y]='0';
                arr2.add(new Pair(p.x,p.y));
                  res[k].add(new Pair(p.x,p.y));

                 p=arr.get(2);
                board[p.x][p.y]='0';
                arr2.add(new Pair(p.x,p.y));
                  res[k].add(new Pair(p.x,p.y));
                  k++;
                arr.remove(0);
                arr.remove(0);
                arr.remove(0);
                p=arr.get(0);

                Pair tmp=new Pair(p.x,p.y);
                board[p.x][p.y]='0';
                res[k].add(new Pair(p.x,p.y));
                p=arr2.get(1);
                 board[p.x][p.y]='1';
                res[k].add(new Pair(p.x,p.y));
                  p=arr2.get(2);
                 board[p.x][p.y]='1';
                res[k].add(new Pair(p.x,p.y));
                k++;
                arr=new ArrayList();
                arr.add(new Pair(arr2.get(1).x,arr2.get(1).y));
                arr.add(new Pair(arr2.get(2).x,arr2.get(2).y));
                arr2.remove(1);
                arr2.remove(1);
                arr2.add(new Pair(tmp.x,tmp.y));

                for(Pair pp:arr2)
                {
                    board[pp.x][pp.y]='1';
                     res[k].add(new Pair(pp.x,pp.y));
                }
                //k++;
                 p=arr.get(0);
                board[p.x][p.y]='0';
                res[k].add(new Pair(p.x,p.y));
                k++;
                for(Pair pp:arr2)
                {
                    board[pp.x][pp.y]='0';
                    res[k].add(new Pair(pp.x,pp.y));
                }
                p=arr.get(1);
                board[p.x][p.y]='0';
                res[k].add(new Pair(p.x,p.y));
                k++;
            }


        }
    }
}
/*for(int i=0;i<n;i++){
for(int j=0;j<m;j++)
{
    out.print(board[i][j]+" ");
}
out.println();
}*/
out.println(k);
for(int i=0;i<k;i++)
{
    for(Pair p:res[i])
        out.print((p.x+1)+" "+(p.y+1)+" ");
    out.println();
}


}




 
out.close();

//SEE UP 

}
static class special{
    char c;
    int idx;
    special(char c,int idx)
    {
        this.c=c;
        this.idx=idx;
    }
}
static long binexp(long a,long n)
{
    if(n==0)
        return 1;
    long res=binexp(a,n/2);
    if(n%2==1)
        return res*res*a;
    else 
        return res*res;
}
static long fastPow(int base, int pow) {
        if (pow==0)
            return 1;
        long half=fastPow(base, pow/2);
        if (pow%2==0)
            return half*half%mod;
        return half*half%mod*base%mod;
    }
static long powMod(long base, long exp, long mod) {
       if (base == 0 || base == 1) return base;
       if (exp == 0) return 1;
       if (exp == 1) return (base % mod+mod)%mod;
       long R = (powMod(base, exp/2, mod) % mod+mod)%mod;
       R *= R;
       R %= mod;
       if ((exp & 1) == 1) {
           return (base * R % mod+mod)%mod;
       }
       else return (R %mod+mod)%mod;
   }
static double dis(double x1,double y1,double x2,double y2)
{
    return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
}
static long mod(long x,long y)
    {
        if(x<0)
            x=x+(-x/y+1)*y;
        return x%y;
    }
 public static  long pow(long b, long e) {
            long r = 1;
            while (e > 0) {
                if (e % 2 == 1) r = r * b ;
                b = b * b;
                e >>= 1;
            }
            return r;
        }
private static void sort(long[] arr) {
        List<Long> list = new ArrayList<>();
        for (long object : arr) list.add(object);
        Collections.sort(list);
    //Collections.reverse(list);
        for (int i = 0; i < list.size(); ++i) arr[i] = list.get(i);
    }
private static void sort2(long[] arr) {
        List<Long> list = new ArrayList<>();
        for (long object : arr) list.add(object);
        Collections.sort(list);
    Collections.reverse(list);
        for (int i = 0; i < list.size(); ++i) arr[i] = list.get(i);
    }
 public static class FastReader {
        BufferedReader br;
        StringTokenizer root;
        
 
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        FastReader(String filename)throws Exception
        {

            br=new BufferedReader(new FileReader(filename));
        }

        boolean hasNext(){
            String line;
            while(root.hasMoreTokens())
                return true;
            return false;
        }
 
        String next() {
            while (root == null || !root.hasMoreTokens()) {
                try {
                    root = new StringTokenizer(br.readLine());
                } catch (Exception addd) {
                    addd.printStackTrace();
                }
            }
            return root.nextToken();
        }
 
        int nextInt() {
            return Integer.parseInt(next());
        }
 
        double nextDouble() {
            return Double.parseDouble(next());
        }
 
        long nextLong() {
            return Long.parseLong(next());
        }
 
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (Exception addd) {
                addd.printStackTrace();
            }
            return str;
        }
         public int[] nextIntArray(int arraySize) {
            int array[] = new int[arraySize];
 
            for (int i = 0; i < arraySize; i++) {
                array[i] = nextInt();
            }
 
            return array;
        }
}
 static class Pair implements Comparable<Pair>{
        public int x, y;
        public Pair(int x1, int y1) {
            x=x1;
            y=y1;
        }
        @Override
        public int hashCode() {
            return (int)(x + 31 * y);
        }
        public String toString() {
            return x + " " + y;
        }
        @Override
        public boolean equals(Object o){
            if (o == this) return true;
            if (o.getClass() != getClass()) return false;
            Pair t = (Pair)o;
            return t.x == x && t.y == y;
        }
public int compareTo(Pair o)
{
    return (o.y-y);

    }

static class pair{
    int i;
    int j;
pair(int i,int j){
    this.i=i;
    this.j=j;
}}}
 static class tuple{
        int x,y,z;
        tuple(int a,int b,int c){
            x=a;
            y=b;
            z=c;
        }
    }
    static class Edge{
        int d,w;
        Edge(int d,int w)
        {
            this.d=d;
            this.w=w;
        }
    }
}









