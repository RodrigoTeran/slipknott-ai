
/*
                                      بسم الله الرحمن الرحيم
 
    /$$$$$  /$$$$$$  /$$    /$$  /$$$$$$                                                                  
   |__  $$ /$$__  $$ |$$    |$$ /$$__  $$                                                                 
          | $$| $$  \ $$|    $$|$$| $$  \ $$                                                                 
          | $$| $$$$$$$$|  $$ / $$/| $$$$$$$$                                                                 
/ $$  | $$| $$__  $$ \  $$ $$/ | $$__  $$                                                                 
| $$  | $$| $$  | $$  \  $$$/  | $$  | $$                                                                 
|  $$$$$$/| $$  | $$   \  $/   | $$  | $$                                                                 
 \______/ |__/  |__/    \_/    |__/  |__/    
 
/$$$$$$$  /$$$$$$$   /$$$$$$   /$$$$$$  /$$$$$$$   /$$$$$$  /$$      /$$ /$$      /$$ /$$$$$$$$ /$$$$$$$ 
| $$__  $$| $$__  $$ /$$__  $$ /$$__  $$| $$__  $$ /$$__  $$| $$$    /$$$| $$$    /$$$| $$_____/| $$__  $$
| $$  \ $$| $$  \ $$| $$  \ $$| $$  \__/| $$  \ $$| $$  \ $$| $$$$  /$$$$| $$$$  /$$$$| $$      | $$  \ $$
| $$$$$$$/| $$$$$$$/| $$  | $$| $$ /$$$$| $$$$$$$/| $$$$$$$$| $$ $$/$$ $$| $$ $$/$$ $$| $$$$$   | $$$$$$$/
| $$____/ | $$__  $$| $$  | $$| $$|_  $$| $$__  $$| $$__  $$| $$  $$$| $$| $$  $$$| $$| $$__/   | $$__  $$
| $$      | $$  \ $$| $$  | $$| $$  \ $$| $$  \ $$| $$  | $$| $$\  $ | $$| $$\  $ | $$| $$      | $$  \ $$
| $$      | $$  | $$|  $$$$$$/|  $$$$$$/| $$  | $$| $$  | $$| $$ \/  | $$| $$ \/  | $$| $$$$$$$$| $$  | $$
|__/      |__/  |__/ \______/  \______/ |__/  |__/|__/  |__/|__/     |__/|__/     |__/|________/|__/  |__/
                                                                                                                                                                                                                
                                                                                                                                                                                                                
 
*/

import java.util.*;
import java.lang.*;
import java.io.*;

public class D753 {
    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        try {
            // Scanner sc=new Scanner(System.in);
            FastReader sc = new FastReader();
            int t = sc.nextInt();
            while (t-- > 0) {
                int n=sc.nextInt();
                int[] arr=new int[n];
                for(int i=0;i<n;i++){
                    arr[i]=sc.nextInt();
                }
                
                char[] color=sc.next().toCharArray();
                ArrayList<Integer> b=new ArrayList<>();
                ArrayList<Integer> r=new ArrayList<>();
                for(int i=0;i<n;i++){
                    if(color[i]=='B')b.add(arr[i]);
                    else r.add(arr[i]);
                }
                Collections.sort(b);
                Collections.sort(r);
                boolean ok=true;
                int cur=1;
                for(int i:b){
                    if(i>=cur)cur++;
                    else{
                        ok=false;
                        break;
                    }
                    //cur++;
                }
                for(int i:r){
                    if(i<=cur)cur++;
                    else{
                        ok=false;
                        break;
                    }
                }
                if(ok)System.out.println("YES");
                else System.out.println("NO");
            }
        } catch (Exception e) {
            return;
        }

    }
    public static int lowerbound(long[] ar,int k)
{
    int s=0;
    int e=ar.length;
    while (s !=e)
    {
        int mid = s+e>>1;
        if (ar[mid] <k)
        {
            s=mid+1;
        }
        else
        {
            e=mid;
        }
    }
    if(s==ar.length)
    {
        return -1;
    }
    return s;
}

    public static class pair {
        int ff;
        char ss;

        pair(int ff, char ss) {
            this.ff = ff;
            this.ss = ss;
        }
    }

    static int BS(int[] arr, int l, int r, int element) {
        int low = l;
        int high = r;
        while (high - low > 1) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < element) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        if (arr[low] == element) {
            return low;
        } else if (arr[high] == element) {
            return high;
        }
        return -1;
    }

    static int lower_bound(int[] arr, int l, int r, int element) {
        int low = l;
        int high = r;
        while (high - low > 1) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < element) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        if (arr[low] >= element) {
            return low;
        } else if (arr[high] >= element) {
            return high;
        }
        return -1;
    }

    static int upper_bound(int[] arr, int l, int r, int element) {
        int low = l;
        int high = r;
        while (high - low > 1) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= element) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        if (arr[low] > element) {
            return low;
        } else if (arr[high] > element) {
            return high;
        }
        return -1;
    }

    public static int upperbound(long[] arr, int k) {
        int s = 0;
        int e = arr.length;
        while (s != e) {
            int mid = s + e >> 1;
            if (arr[mid] <= k) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }
        if (s == arr.length) {
            return -1;
        }
        return s;
    }
    public static long pow(long x,long y,long mod){
        if(x==0)return 0l;
        if(y==0)return 1l;
        //(x^y)%mod
        if(y%2l==1l){
            return ((x%mod)*(pow(x,y-1l,mod)%mod))%mod;
        }
        return pow(((x%mod)*(x%mod))%mod,y/2l,mod);
    }

    public static long gcd_long(long a, long b) {
        // a/b,a-> dividant b-> divisor
        if (b == 0)
            return a;
        return gcd_long(b, a % b);
    }

    public static int gcd_int(int a, int b) {
        // a/b,a-> dividant b-> divisor
        if (b == 0)
            return a;
        return gcd_int(b, a % b);
    }

    public static int lcm(int a, int b) {
        int gcd = gcd_int(a, b);
        return (a * b) / gcd;
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        String nextLine() {
            String s = "";
            try {
                s = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return s;
        }

        Long nextLong() {
            return Long.parseLong(next());
        }
    }
}

/*
 * public static boolean lie(int n,int m,int k){ if(n==1 && m==1 && k==0){
 * return true; } if(n<1 || m<1 || k<0){ return false; } boolean
 * tc=lie(n-1,m,k-m); boolean lc=lie(n,m-1,k-n); if(tc || lc){ return true; }
 * return false; }
 */
