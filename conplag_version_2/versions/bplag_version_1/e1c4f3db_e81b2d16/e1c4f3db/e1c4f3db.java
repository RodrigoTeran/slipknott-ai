import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class fastTemp {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() { return Long.parseLong(next()); }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static int n;
    static int arr[];
    public static void main(String[] args)
    {
        FastReader fs = new FastReader();
        int t = fs.nextInt();
        while(t-- >0){
               n = fs.nextInt();
               arr = new int[n];
              int max = Integer.MIN_VALUE;
              for(int i=0;i<n;i++){
                arr[i] = fs.nextInt();
                  if(max<arr[i]){
                      max =arr[i];
                  }
              }
              int l=1;
              int r = max;
              int ans = 0;
              while(l<r){
                  int mid = l + (r-l+1)/2;
                  if(check(mid)){
                  l = mid;
                  }else{
                      r = mid-1;
                  }
              }
            System.out.println(l);
        }

    }
static int min = Integer.MAX_VALUE;
    public static boolean check(int x){

        int ar[] = new int[n];
        for(int i=0;i<n;i++){
            ar[i] = arr[i];
        }

       // Collections.copy(curr,arr);

        for(int i=n-1;i>=2;i--){
           if(ar[i]<x){
               return false;
           }
           int d = (Math.min(arr[i],ar[i]-x))/3;
          ar[i-1] += d;
          ar[i-2] += 2*d;
        }

        return ar[0]>=x && ar[1]>=x;
    }


}