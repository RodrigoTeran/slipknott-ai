import java.util.*;
import java.io.*;

public class Solution
{
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
    
   
  static int parent(int a , int p[])
  {
      if(a == p[a])
      return a;
      
      return p[a] = parent(p[a],p);
  }
  
  static void union(int a , int b , int p[] , int size[])
  {
      a = parent(a,p);
      b = parent(b,p);
      
      if(a == b)
      return;
      
      if(size[a] < size[b])
      {
          int temp = a;
          a = b;
          b = temp;
      }
      
      p[b] = a;
      size[a] += size[b];
  }
  
  
  static long dp[][];
  static long f(int n , int m)
  {
      if(m == 0)
      return 1;
      
      if(dp[n][m] != -1)
      return dp[n][m];
      
      if(n < 9)
      dp[n][m] = f(n+1,m-1);
      
      else
      dp[n][m] = f(0,m-1)+f(1,m-1);
      
      dp[n][m] %= 1000000007;
      
      return dp[n][m];
  }
  
 static long getSum(int index , long BITree[])
    {
        long sum = 0; // Iniialize result
      
        // index in BITree[] is 1 more than
        // the index in arr[]
       // index = index + 1;
      
        // Traverse ancestors of BITree[index]
        while(index>0)
        {
            // Add current element of BITree 
            // to sum
            sum += BITree[index];
      
            // Move index to parent node in 
            // getSum View
            index -= index & (-index);
        }
        return sum;
    }
  
    // Updates a node in Binary Index Tree (BITree)
    // at given index in BITree. The given value 
    // 'val' is added to BITree[i] and all of 
    // its ancestors in tree.
    public static void updateBIT(int n, int index, 
                                        long val , long BITree[])
    {
        // index in BITree[] is 1 more than 
        // the index in arr[]
      //  index = index + 1;
      
        // Traverse all ancestors and add 'val'
        while(index <= n)
        {
        // Add 'val' to current node of BIT Tree
        BITree[index] += val;
      
        // Update index to that of parent 
        // in update View
        index += index & (-index);
        }
    }
    
    
   static int gcd(int a, int b)
{
    if (a == 0)
        return b;
    return gcd(b % a, a);
}
    public static void main(String []args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
       // sc.nextLine();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            sc.nextLine();
            //String s = sc.nextLine();
            int arr[][] = new int[26][n];
            for(int i = 0 ; i < n ; i++)
            {
                String s = sc.nextLine();
                
                for(int j = 0 ; j < 26 ; j++)
                {
                    int cnt = 0;
                    for(int k = 0 ; k < s.length() ; k++)
                    {
                        if(s.charAt(k)-'a' == j)
                        cnt++;
                    }
                    arr[j][i] = 2*cnt-s.length();
                }
            }
            
            int ans = 0;
            for(int i = 0 ; i < 26 ; i++)
            {
             Arrays.sort(arr[i]);   
             int tot = 0;
             for(int j = n-1 ; j >= 0 ;j--)
             {
                 tot += arr[i][j];
                 if(tot <= 0)
                 break;
                 
                 ans = Math.max(ans,n-j);
             }
            }
            System.out.println(ans);
        }
    }
}