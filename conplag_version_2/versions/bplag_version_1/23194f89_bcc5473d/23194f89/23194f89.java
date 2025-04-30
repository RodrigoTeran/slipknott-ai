
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class k
{		//public static int mod=1000000007;
	public static void printDivisors(int n)
	{
	    // Note that this loop runs till square root
		int x=(int) Math.sqrt(n);
		int p=0;
	    for (int i=1; i<=x; i++)
	    {
	        if (n%i == 0)
	        {
	            // If divisors are equal, print only one
	            if (n/i == i)
	                p++;
	  
	            else // Otherwise print both
	                p=p+2;
	        }
	    }
	    System.out.println(p);
	}
	public static ArrayList<Long> Factors(long n)
    {
		ArrayList<Long> arr=new ArrayList<Long>();
        int k=0;
        while (n%2==0)
        {
            k++;
            n /=2;
            arr.add((long)2);
        }
	int p=(int) Math.sqrt(n); 
        for (int i = 3; i <=p; i+= 2)
        
        {  if(n==1)break;
            while (n%i == 0)
            {
                k++;
                arr.add((long)i);
                n /= i;
            }
        }
        if (n > 2)
        {
        	arr.add(n);
        }
        
   return arr;
    } 
	static class Reader {
		 
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
	            din = new DataInputStream(
	                new FileInputStream(file_name));
	            buffer = new byte[BUFFER_SIZE];
	            bufferPointer = bytesRead = 0;
	        }
	 
	        public String readLine() throws IOException
	        {
	            byte[] buf = new byte[64]; // line length
	            int cnt = 0, c;
	            while ((c = read()) != -1) {
	                if (c == '\n') {
	                    if (cnt != 0) {
	                        break;
	                    }
	                    else {
	                        continue;
	                    }
	                }
	                buf[cnt++] = (byte)c;
	            }
	            return new String(buf, 0, cnt);
	        }
	 
	        public int nextInt() throws IOException
	        {
	            int ret = 0;
	            byte c = read();
	            while (c <= ' ') {
	                c = read();
	            }
	            boolean neg = (c == '-');
	            if (neg)
	                c = read();
	            do {
	                ret = ret * 10 + c - '0';
	            } while ((c = read()) >= '0' && c <= '9');
	 
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
	            } while ((c = read()) >= '0' && c <= '9');
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
	            } while ((c = read()) >= '0' && c <= '9');
	 
	            if (c == '.') {
	                while ((c = read()) >= '0' && c <= '9') {
	                    ret += (c - '0') / (div *= 10);
	                }
	            }
	 
	            if (neg)
	                return -ret;
	            return ret;
	        }
	 
	        private void fillBuffer() throws IOException
	        {
	            bytesRead = din.read(buffer, bufferPointer = 0,
	                                 BUFFER_SIZE);
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
	 public static long gcd(long x, long p)
	    {
	        if (x == 0)
	            return p;
	         
	        return gcd(p%x, x);
	    }
	    // method to return LCM of two numbers
	    static long lcm(long a, long b)
	    {
	        return (a / gcd(a, b)) * b;
	    }
	 public static HashMap<Integer, Integer> sortByValue(HashMap<Integer, Integer> hm)
	    {
	        // Create a list from elements of HashMap
	        List<Map.Entry<Integer, Integer> > list =
	               new LinkedList<Map.Entry<Integer, Integer> >(hm.entrySet());
	 
	        // Sort the list
	        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() {
	            public int compare(Map.Entry<Integer, Integer> o1,
	                               Map.Entry<Integer, Integer> o2)
	            {
	                return (o1.getValue()).compareTo(o2.getValue());
	            }
	        });
	         
	        // put data from sorted list to hashmap
	        HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>();
	        for (Map.Entry<Integer, Integer> aa : list) {
	            temp.put(aa.getKey(), aa.getValue());
	        }
	        return temp;
	    }
	 static int sieve =  1000000 ;


	 static boolean[] prime =  new boolean[sieve + 1] ;

	 public static void sieveOfEratosthenes() 
	     { 
	         // FALSE == prime and 1 // TRUE ==  COMPOSITE
	         
	         // time complexity = 0(NlogLogN)== o(N)
	         
	         // gives prime nos bw 1 to N // size - 1e7(at max)
	         
	         for(int i = 4; i<= sieve ; i++)
	         {
	             prime[i] = true  ; i++ ;
	            
	         }
	         
	         for(int p = 3; p*p <= sieve; p++) 
	         { 
	            if(prime[p] == false) 
	             { 
	                     for(int i = p*p; i <= sieve; i += p) 
	                     prime[i] = true; 
	             } 
	             
	             p++ ;
	         } 
	           
	     } 
	 public static void arrInpInt(int [] arr, int n) throws IOException
	 {
		 Reader reader = new Reader();
		 for(int i=0;i<n;i++)
	   		{
	   			arr[i]=reader.nextInt();	
	   		}
	 }
	 public static void arrInpLong(long [] arr, int n) throws IOException
	 {
		 Reader reader = new Reader();
		 for(int i=0;i<n;i++)
	   		{
	   			arr[i]=reader.nextLong();	
	   		}
	 }
	 public static void printArr(int[] arr)
	 {
		 for(int i=0;i<arr.length;i++)
		 {
			 System.out.print(arr[i]+" ");
		 }
		 System.out.println();
	 }
	 public static int[] decSort(int[] arr)
	 {
		  int[] arr1 = Arrays.stream(arr).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();	
		  return arr1;
	 }
	 
	
	//if present - return the first occurrence of the no
	//not present- return the index of next greater value 
	//if greater than all the values return N(taking high=N-1)
	//if smaller than all the values return 0(taking low =0)
	static int lower_bound(int arr[], int low,int high, int X)
	{

	 if (low > high) {
	     return low;
	 }
	 int mid = low + (high - low) / 2;
	 if (arr[mid] >= X) {
	     return lower_bound(arr, low,
	                        mid - 1, X);
	 }

	 return lower_bound(arr, mid + 1,
	                    high, X);
	}
	//if present - return the index of next greater value
	//not present- return the index of next greater value 
	//if greater than all the values return N(taking high=N-1)
	//if smaller than all the values return 0(taking low =0)\
	
	static int upper_bound(int arr[], int low, int high, int X)
{

if (low > high)
    return low;

int mid = low + (high - low) / 2;
if (arr[mid] <= X) {
    return upper_bound(arr, mid + 1,
                       high, X);
}

return upper_bound(arr, low,
                   mid - 1, X);
}
	
	
	 public static class Pair  {// comparator with class
		    int x;
		    int y;
		 public Pair(int x, int y)
		    {
		        this.x = x;
		        this.y = y;
		    }
		}
	
	 public static void sortbyColumn(int arr[][], int col)  // send 2d array and col no
	    {
	        Arrays.sort(arr, new Comparator<int[]>() {       
	          @Override              
	          public int compare(final int[] entry1, 
	                             final int[] entry2) {
	            if (entry1[col] > entry2[col])
	                return 1;
	            else if (entry1[col] < entry2[col])
	                return -1;
	              else return 0;
	          }
	        });
	    }
	 public static void sortbyColumn1(int arr[][], int col)  // send 2d array and col no
	    {
	        Arrays.sort(arr, new Comparator<int[]>() {       
	          @Override              
	          public int compare(final int[] entry1, 
	                             final int[] entry2) {
	            if (entry1[col] > entry2[col])
	                return 1;
	            else if (entry1[col] < entry2[col])
	                return -1;
	            else if(entry1[col] == entry2[col])
	            {
	            	if(entry1[col-1]>entry2[col-1])
	            		return -1;
	            	else if(entry1[col-1]<entry2[col-1])
	            		return 1;
	            	else return 0;
	            }
	              else return 0;
	          }
	        });
	    }
	 public static void print2D(int mat[][])
	    {
	        // Loop through all rows
	        for (int i = 0; i < mat.length; i++)
	 
	        {  // Loop through all elements of current row
	        {
	            for (int j = 0; j < mat[i].length; j++)
	                System.out.print(mat[i][j] + " ");
	        }
	            System.out.println();
	        }
	    }
	 public static int biggestFactor(int num) {
		  int  result = 1;
		  for(int  i=2; i*i <=num; i++){
		      if(num%i==0){
		          result = num/i;
		          break;
		      }
		  }
		  return result;
		}
	    public static class  p
	     {
	    	 int no;
	    	 int h;
	    	 public p(int no, long h)
	    	 {
	    		 this.no=no;
	    		 this.h=(int) h;
	    	 }
	     }
	    
	    
	  static    class com implements Comparator<p>{
	            public int compare(p s1, p s2) {
	                if (s1.h > s2.h)
	                    return -1;
	                else if (s1.h < s2.h)
	                    return 1;
	                else if(s1.h==s2.h)
	                {
	                	if(s1.no>s2.no)return -1;
	                	else return 1;
	                }
	                                return 0;
	                }
	        }
	  static long hcf(long a,long b)
	  {
	    while (b > 0)
	    {
	        long temp = b;
	        b = a % b; 
	        a = temp;
	    }
	    return a;
	   }
	  
	 static int lower_bound_arr(ArrayList<Integer> arr, int low,
	             int high, int X)
	{

	 if (low > high) {
	     return low;
	 }
	 int mid = low + (high - low) / 2;
	 if (arr.get(mid) >= X) {
	     return lower_bound_arr(arr, low,
	                        mid - 1, X);
	 }

	 return lower_bound_arr(arr, mid + 1,
	                    high, X);
	}
	
	 
 	public static void main(String args[]) throws NumberFormatException, IOException ,java.lang.Exception
	{
		
		Reader reader = new Reader();
 	
			
		//sieveOfEratosthenes();
		//Scanner reader=new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
//		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//		int cases=Integer.parseInt(br.readLine());
//		int cases=1;
		int cases=reader.nextInt();
		
   	while (cases-->0){
//   		long N=reader.nextLong();
   		//long M=reader.nextLong();
   		int N=reader.nextInt();
//   		int P=reader.nextInt();
	
   		
////   		
//   		String[] first=br.readLine().split(" ");
//   		long N=Long.parseLong(first[0]);
//   		long K=Long.parseLong(first[1]);
//   		long X=Long.parseLong(first[2]);
//   		String s2=br.readLine();
//   		String s3=br.readLine();
//   		char[]  s11=s2.toCharArray();
//	  	    char[]  s12=new char[s11.length];
   		
    	//int max=Integer.MIN_VALUE;
//   		int min=Integer.MAX_VALUE;
   		//int mod=1000000007;
 
//   		HashMap<Integer, TreeSet<Integer>> map=new HashMap<Integer,TreeSet<Integer>>();
   		
   		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
//		HashMap<Long,Long> map=new HashMap<Long,Long>();
//   		HashMap<String,Integer> map1=new HashMap<String,Integer>();
   		//HashMap<Character,Integer> path=new HashMap<Character,Integer>();
   		
   		//TreeMap<Integer,Integer> map=new TreeMap<Integer,Integer>(Collections.reverseOrder());
  		
//   		HashSet<Integer> set =new HashSet<Integer>();
//   		HashSet<Integer> right =new HashSet<Integer>();

   		//   		TreeSet<Integer> a =new TreeSet<Integer>();
   		//TreeSet<Long> b =new TreeSet<Long>();
//   		TreeSet<Integer> map=new TreeSet<Integer>();
   		
//   		long[] arr=new long[N];
//   		int[] odd=new int[100001];
   		
   		int[] sec=new int[N];
   		int[] pow=new int[N];
//   		int[][] arr=new int[N][P];
   		ArrayList<Long> list=new ArrayList<Long>();
//   		ArrayList<Long> list3=new ArrayList<Long>();
//   		ArrayList<Long> list1=new ArrayList<Long>();
//   		ArrayList<Long> bees=new ArrayList<Long>();
   		
//   		boolean[]arr1=new boolean[N];
//   
//   		for(int i=0;i<N;i++)
//   		{
//   	
   		
   		for(int i=0;i<N;i++)
   		
   		{
   			sec[i]=reader.nextInt();
   		}
   		for(int i=0;i<N;i++)
   		{
   			pow[i]=reader.nextInt();
   		}
   		int last=sec[N-1];
   		int ind=sec[N-1]-pow[N-1]+1;
   		long ans=0;
   		int i=N-2;
   		while(i>=0)
   		{
//   			System.out.println(last +" "+ind);
   			if(sec[i]>=ind)
   			{
   				if(sec[i]-ind+1<pow[i])
   				{
   					ind=ind-(pow[i]-sec[i]+ind-1);
   				}
   				i--;
   			}
   			else if(sec[i]<ind)
   			{
   				ans=ans+((long)(last-ind+1))*((long)(last-ind+2))/(long)(2);
   				last=sec[i];
   		   		ind=sec[i]-pow[i]+1;
   		   		i--;
   			}
   			
   				
   		}
   		ans=ans+((long)(last-ind+1))*((long)(last-ind+2))/(long)(2);
   		System.out.println(ans);
   		
   	}
//  output.flush(); 
   	
	}
 
}

   	