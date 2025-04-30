//Some of the methods are copied from GeeksforGeeks Website  
import java.util.*;
import java.lang.*;
import java.io.*;
public class Main
{ 
  static  Reader sc=new Reader();
  // static FastReader sc=new FastReader(System.in);
  static ArrayList<Integer> one;
  static ArrayList<Integer> zero;
  static long dp[][];
  static void ini()
   {
      for(long a[] : dp)
        Arrays.fill(a,-1);
   }
static long solve(int i,int j)
 {
    if(i==one.size()) return 0;
    if(j==zero.size()) return int_max;
    
    if(dp[i][j]!=-1) return dp[i][j];
    
     long ans1=Math.abs(one.get(i)-zero.get(j))+solve(i+1,j+1);
     long ans2=solve(i,j+1);
     return dp[i][j]=Math.min(ans1,ans2);
 }
   // static int ceilSearch(ArrayList<Integer> arr, int low, int high, int x)
   //  {
   //    int mid;   
       
   //    /* If x is smaller than or equal to the
   //       first element, then return the first element */
   //    if(x <= arr.get(low))
   //     return low;
      
   //    /* If x is greater than the last
   //       element, then return -1 */
   //    if(x > arr.get(high))
   //     return -1; 
      
   //    /* get the index of middle element
   //       of arr[low..high]*/
   //    mid = (low + high)/2;  /* low + (high - low)/2 */
      
   //    /* If x is same as middle element,
   //       then return mid */
   //    if(arr.get(mid) == x)
   //     return mid;
          
   //    /* If x is greater than arr[mid], then
   //       either arr[mid + 1] is ceiling of x or
   //       ceiling lies in arr[mid+1...high] */
   //    else if(arr.get(mid) < x)
   //    {
   //     if(mid + 1 <= high && x <= arr.get(mid+1))
   //        return mid + 1;
   //     else
   //        return ceilSearch(arr, mid+1, high, x);
   //    }
      
   //    /* If x is smaller than arr[mid],
   //       then either arr[mid] is ceiling of x
   //       or ceiling lies in arr[low...mid-1] */  
   //    else
   //    {
   //     if(mid - 1 >= low && x > arr.get(mid-1))
   //        return mid;
   //     else   
   //        return ceilSearch(arr, low, mid - 1, x);
   //    }
   //  }
    
   //  static int floorSearch(
   //     ArrayList<Integer> arr, int low,
   //     int high, int x)
   //  {
   //     // If low and high cross each other
   //     if (low > high)
   //          return -1;
 
   //     // If last element is smaller than x
   //     if (x >= arr.get(high))
   //          return high;
 
   //     // Find the middle point
   //     int mid = (low + high) / 2;
 
   //     // If middle point is floor.
   //     if (arr.get(mid) == x)
   //          return mid;
 
   //     // If x lies between mid-1 and mid
   //     if (
   //          mid > 0 && arr.get(mid - 1) <= x && x < arr.get(mid))
   //          return mid - 1;
 
   //     // If x is smaller than mid, floor
   //     // must be in left half.
   //     if (x < arr.get(mid))
   //          return floorSearch(
   //              arr, low,
   //              mid - 1, x);
 
   //     // If mid-1 is not floor and x is
   //     // greater than arr[mid],
   //     return floorSearch(
   //          arr, mid + 1, high,
   //          x);
   //  }
 
 
 public static void main (String[] args) throws java.lang.Exception
   {
	try{
	  
		  int t = 1;// sc.nextInt();
		  int max=5001;
		  dp=new long[max][max];
		  ini();
		  one=new ArrayList<>();
		  zero=new ArrayList<>();
		  while(t-->0)
		    { 
		       int n=sc.nextInt();
		       long ans=0;
		       int a[]=new int[n];
		       for(int i=0;i<n;i++)
		         {
		           a[i]=sc.nextInt();
		           if(a[i]==1)
		            one.add(i);
		           else
		            zero.add(i);
		         }
		    //  print_int(one);
		    //  print_int(zero);
		      
		    //  for(int i=0;i<one.size();i++)
		    //    {
		    //       int ele=one.get(i);
		    //       int floor=floorSearch(zero,0,zero.size()-1,ele);
		    //       int ceil=ceilSearch(zero,0,zero.size()-1,ele);
		           
		    //       int left=int_max;
		    //       if(floor!=-1)
		    //        left=zero.get(floor);
		           
		    //       int right=int_max;
		    //       if(ceil!=-1)
		    //        right=zero.get(ceil);
		          
		    //      int left_val=Math.abs(ele-left);
		    //      int right_val=Math.abs(ele-right);
		          
		    //      if(left_val<=right_val)
		    //        {
		    //           ans+=left_val;
		    //           zero.remove(floor);
		    //        }
		    //      else
		    //        {
		    //           ans+=right_val;
		    //           zero.remove(ceil);
		    //        }
		    //    }
		    //   out.println(ans);
		    
		    ans=solve(0,0);
		    out.println(ans);
		    }
	     out.flush();
	     out.close();
	   }     
	catch(Exception e)
		 {}
	}
 
 /*
   ...SOLUTION ENDS HERE...........SOLUTION ENDS HERE...
 */
 
static void flag(boolean flag)
   {
       out.println(flag ? "YES" : "NO");
       out.flush();
   }
   
 /*                     
    Map<Long,Long> map=new HashMap<>();
             for(int i=0;i<n;i++)
               {
                  if(!map.containsKey(a[i]))
                   map.put(a[i],1);
                 else
                   map.replace(a[i],map.get(a[i])+1);
               }
     
    Set<Map.Entry<Long,Long>> hmap=map.entrySet();
             for(Map.Entry<Long,Long> data : hmap)
               {
          
               }
       
   Iterator<Integer> it = set.iterator();
          while(it.hasNext()) 
           { 
            int x=it.next();
           }
   */

static void print(int a[])
  {
     int n=a.length;
     for(int i=0;i<n;i++)
       {
          out.print(a[i]+" ");
       }
     out.println();
     out.flush();
  }
static void print(long a[])
  {
     int n=a.length;
     for(int i=0;i<n;i++)
       {
          out.print(a[i]+" ");
       }
     out.println();
     out.flush();
  } 
static void print_int(ArrayList<Integer> al)
  {
     int si=al.size();
     for(int i=0;i<si;i++)
       {
          out.print(al.get(i)+" ");
       }
     out.println();
     out.flush();
  }
static void print_long(ArrayList<Long> al)
  {
     int si=al.size();
     for(int i=0;i<si;i++)
       {
          out.print(al.get(i)+" ");
       }
     out.println();
     out.flush();
  }

static class Graph
  {
        int v;
        ArrayList<Integer> list[];
        Graph(int v)
        {
            this.v=v;
            list=new ArrayList[v+1];
            for(int i=1;i<=v;i++)
                list[i]=new ArrayList<Integer>();
        }
        void addEdge(int a, int b)
        {
            this.list[a].add(b);
        }
    }
static void DFS(Graph g, boolean[] visited, int u)
	{
        visited[u]=true;
        int v=0;
        for(int i=0;i<g.list[u].size();i++)
        {
            v=g.list[u].get(i);
            if(!visited[v])
               DFS(g,visited,v);
        }
  } 
  
// static class Pair
//    {
//       int x,y;
//       Pair(int x,int y)
//        {
//           this.x=x;
//           this.y=y;
//        }
//    }
   
static long sum_array(int a[])
 {
    int n=a.length;
    long sum=0;
    for(int i=0;i<n;i++)
     sum+=a[i];
    return sum;
 }
static long sum_array(long a[])
 {
    int n=a.length;
    long sum=0;
    for(int i=0;i<n;i++)
     sum+=a[i];
    return sum;
 }

 static void sort(int[] a) 
   {
		ArrayList<Integer> l=new ArrayList<>();
		for (int i:a) l.add(i);
		Collections.sort(l);
		for (int i=0; i<a.length; i++) a[i]=l.get(i);
	}
static void sort(long[] a) 
   {
		ArrayList<Long> l=new ArrayList<>();
		for (long i:a) l.add(i);
		Collections.sort(l);
		for (int i=0; i<a.length; i++) a[i]=l.get(i);
	}

static void reverse_array(int a[])
 {
    int n=a.length;
    int i,t; 
    for (i = 0; i < n / 2; i++) { 
            t = a[i]; 
            a[i] = a[n - i - 1]; 
            a[n - i - 1] = t; 
        } 
 }
static void reverse_array(long a[])
 {
    int n=a.length;
    int i; long t; 
    for (i = 0; i < n / 2; i++) { 
            t = a[i]; 
            a[i] = a[n - i - 1]; 
            a[n - i - 1] = t; 
        } 
 }
 
static long gcd(long a, long b) 
    { 
        if (a == 0) 
            return b; 
          
        return gcd(b%a, a); 
    } 
static int gcd(int a, int b) 
    { 
        if (a == 0) 
            return b; 
          
        return gcd(b%a, a); 
    } 

   static class FastReader{
 
        byte[] buf = new byte[2048];
        int index, total;
        InputStream in;
 
        FastReader(InputStream is) {
            in = is;
        }
 
        int scan() throws IOException {
            if (index >= total) {
                index = 0;
                total = in.read(buf);
                if (total <= 0) {
                    return -1;
                }
            }
            return buf[index++];
        }
 
        String next() throws IOException {
            int c;
            for (c = scan(); c <= 32; c = scan());
            StringBuilder sb = new StringBuilder();
            for (; c > 32; c = scan()) {
                sb.append((char) c);
            }
            return sb.toString();
        }
 
        int nextInt() throws IOException {
            int c, val = 0;
            for (c = scan(); c <= 32; c = scan());
            boolean neg = c == '-';
            if (c == '-' || c == '+') {
                c = scan();
            }
            for (; c >= '0' && c <= '9'; c = scan()) {
                val = (val << 3) + (val << 1) + (c & 15);
            }
            return neg ? -val : val;
        }
 
        long nextLong() throws IOException {
            int c;
            long val = 0;
            for (c = scan(); c <= 32; c = scan());
            boolean neg = c == '-';
            if (c == '-' || c == '+') {
                c = scan();
            }
            for (; c >= '0' && c <= '9'; c = scan()) {
                val = (val << 3) + (val << 1) + (c & 15);
            }
            return neg ? -val : val;
        }
    }
   
    static class Reader 
    { 
        final private int BUFFER_SIZE = 1 << 16; 
        private DataInputStream din; 
        private byte[] buffer; 
        private int bufferPointer, bytesRead; 
  
        public Reader() 
        { 
            din = new DataInputStream(System.in); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 
  
        public Reader(String file_name) throws IOException 
        { 
            din = new DataInputStream(new FileInputStream(file_name)); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 
  
        public String readLine() throws IOException 
        { 
            byte[] buf = new byte[64]; // line length 
            int cnt = 0, c; 
            while ((c = read()) != -1) 
            { 
                if (c == '\n') 
                    break; 
                buf[cnt++] = (byte) c; 
            } 
            return new String(buf, 0, cnt); 
        } 
  
        public int nextInt() throws IOException 
        { 
            int ret = 0; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
            do
            { 
                ret = ret * 10 + c - '0'; 
            }  while ((c = read()) >= '0' && c <= '9'); 
  
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        public long nextLong() throws IOException 
        { 
            long ret = 0; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
            do { 
                ret = ret * 10 + c - '0'; 
            } 
            while ((c = read()) >= '0' && c <= '9'); 
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        public double nextDouble() throws IOException 
        { 
            double ret = 0, div = 1; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
  
            do { 
                ret = ret * 10 + c - '0'; 
            } 
            while ((c = read()) >= '0' && c <= '9'); 
  
            if (c == '.') 
            { 
                while ((c = read()) >= '0' && c <= '9') 
                { 
                    ret += (c - '0') / (div *= 10); 
                } 
            } 
  
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        private void fillBuffer() throws IOException 
        { 
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE); 
            if (bytesRead == -1) 
                buffer[0] = -1; 
        } 
  
        private byte read() throws IOException 
        { 
            if (bufferPointer == bytesRead) 
                fillBuffer(); 
            return buffer[bufferPointer++]; 
        } 
  
        public void close() throws IOException 
        { 
            if (din == null) 
                return; 
            din.close(); 
        } 
    }
  static  PrintWriter out=new PrintWriter(System.out);
  static int int_max=Integer.MAX_VALUE;
  static int int_min=Integer.MIN_VALUE;
  static long long_max=Long.MAX_VALUE;
  static long long_min=Long.MIN_VALUE;
}
// Thank You !