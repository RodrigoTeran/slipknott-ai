
import java.io.*;
import java.util.*;


public class CODECHEF {
    static class FastReader {
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
            for (c = scan(); c <= 32; c = scan())
                ;
            StringBuilder sb = new StringBuilder();
            for (; c > 32; c = scan()) {
                sb.append((char) c);
            }
            return sb.toString();
        }

        String nextLine() throws IOException {
            int c;
            for (c = scan(); c <= 32; c = scan())
                ;
            StringBuilder sb = new StringBuilder();
            for (; c != 10 && c != 13; c = scan()) {
                sb.append((char) c);
            }
            return sb.toString();
        }

        char nextChar() throws IOException {
            int c;
            for (c = scan(); c <= 32; c = scan())
                ;
            return (char) c;
        }

        int nextInt() throws IOException {
            int c, val = 0;
            for (c = scan(); c <= 32; c = scan())
                ;
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
            for (c = scan(); c <= 32; c = scan())
                ;
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
    static long MOD=1000000000;
    static class Pair{
        long a;
        int b;
        Pair(long i,int j){
            a=i;
            b=j;
        }
    }
    static long[] solve(int[] pos,long[] arr,int n,int k){
        long[] ans=new long[n];
        long[] left=new long[n];
        long[] right=new long[n];
        long min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            min=Math.min(min+1,arr[i]);
            left[i]=min;
        }
        min=Integer.MAX_VALUE;
        for(int i=n-1;i>=0;i--){
            min=Math.min(min+1,arr[i]);
            right[i]=min;
        }
        for(int i=0;i<n;i++){
            ans[i]=Math.min(left[i],right[i]);
        }
        return ans;


    }


    public static void main(String[] args) throws java.lang.Exception {
         FastReader fs=new FastReader(System.in);
//       StringBuilder sb=new StringBuilder();
//       PrintWriter out=new PrintWriter(System.out);
         int t=fs.nextInt();
         while (t-->0){
            int n=fs.nextInt();
            int k=fs.nextInt();
            int[] pos=new int[k];
            for(int i=0;i<k;i++)
                pos[i]=fs.nextInt()-1;
            long[] temp=new long[n];
            int ptr=0;
            Arrays.fill(temp,Integer.MAX_VALUE);
             for(int i=0;i<k;i++)
                 temp[pos[ptr++]]=fs.nextLong();
             long[] ans=solve(pos,temp,n,k);
             for(int i=0;i<n;i++)
                 System.out.print(ans[i]+" ");
             System.out.println();

         }
        //out.close;
    }
}
