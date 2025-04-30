import java.io.*;
import java.util.*;
 
public class _1615c {
    FastScanner scn;
    PrintWriter w;
    PrintStream fs;

    long MOD = 1000000007;
    int MAX = 200005;
    long mul(long x, long y) {long res = x * y; return (res >= MOD ? res % MOD : res);}
    long power(long x, long y) {if (y < 0) return 1; long res = 1; x %= MOD; while (y!=0) {if ((y & 1)==1)res = mul(res, x); y >>= 1; x = mul(x, x);} return res;}
    void ruffleSort(int[] a) {int n=a.length;Random r=new Random();for (int i=0; i<a.length; i++) {int oi=r.nextInt(n), temp=a[i];a[i]=a[oi];a[oi]=temp;}Arrays.sort(a);}
    void reverseSort(int[] arr){List<Integer> list = new ArrayList<>();for (int i=0; i<arr.length; i++){list.add(arr[i]);}Collections.sort(list, Collections.reverseOrder());for (int i = 0; i < arr.length; i++){arr[i] = list.get(i);}}
    boolean LOCAL;
    void debug(Object... o){if(LOCAL)System.err.println(Arrays.deepToString(o));}
    //SUFFICIENT DRY RUN????LOGIC VERIFIED FOR ALL TEST CASES???
    
    void solve(){
        
        int t=scn.nextInt();
            while(t-->0)
            {
                int n=scn.nextInt();
                String s1= scn.next();
                String s2 = scn.next();

                int op1=0,op0=0,one=0,zr=0;
                for(int i=0;i<n;i++){
                    char ch1 = s1.charAt(i);
                    char ch2 = s2.charAt(i);
                    
                    if(ch1=='1'&&ch2=='0'){
                        op1++;
                    }else if(ch1=='0'&&ch2=='1'){
                        op0++;
                    }else if(ch1==ch2){
                        if(ch1=='0'){
                            zr++;
                        }else{
                            one++;
                        }
                    }
                }
                
                if((one-zr)==1&&op1==op0){
                    w.println(Math.min(2*op1,one+zr));
                }else if((one-zr)==1){
                    w.println(one+zr);
                }else if(op1==op0){
                    w.println(2*op1);
                }else{
                    w.println(-1);
                }
            
            
            }
        
    }
 
    void run() {
        try {
            long ct = System.currentTimeMillis();
            scn = new FastScanner(new File("input.txt"));
            w = new PrintWriter(new File("output.txt"));
            fs=new PrintStream("error.txt");
            System.setErr(fs);
            LOCAL=true;
 
            solve();
 
            w.close();
            System.err.println(System.currentTimeMillis() - ct);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
 
    void runIO() {
 
        scn = new FastScanner(System.in);
        w = new PrintWriter(System.out);
        LOCAL=false;
 
        solve();
 
        w.close();
    }
 
    class FastScanner {
        BufferedReader br;
        StringTokenizer st;
 
        public FastScanner(File f) {
            try {
                br = new BufferedReader(new FileReader(f));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
 
        public FastScanner(InputStream f) {
            br = new BufferedReader(new InputStreamReader(f));
        }
 
        String next() {
            while (st == null || !st.hasMoreTokens()) {
                String s = null;
                try {
                    s = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (s == null)
                    return null;
                st = new StringTokenizer(s);
            }
            return st.nextToken();
        }
 
        boolean hasMoreTokens() {
            while (st == null || !st.hasMoreTokens()) {
                String s = null;
                try {
                    s = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (s == null)
                    return false;
                st = new StringTokenizer(s);
            }
            return true;
        }
 
        int nextInt() {
            return Integer.parseInt(next());
        }
        
        int[] nextIntArray(int n) {
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }

        long[] nextLongArray(int n) {
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextLong();
            }
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
 
        double nextDouble() {
            return Double.parseDouble(next());
        }
    }
 
    int lowerBound(int[] arr, int x){int n = arr.length, si = 0, ei = n - 1;while(si <= ei){int mid = si + (ei - si)/2;if(arr[mid] == x){if(mid-1 >= 0 && arr[mid-1] == arr[mid]){ei = mid-1;}else{return mid;}}else if(arr[mid] > x){ei = mid - 1; }else{si = mid+1;}}return si; }
    int upperBound(int[] arr, int x){int n = arr.length, si = 0, ei = n - 1;while(si <= ei){int mid = si + (ei - si)/2;if(arr[mid] == x){if(mid+1 < n && arr[mid+1] == arr[mid]){si = mid+1;}else{return mid + 1;}}else if(arr[mid] > x){ei = mid - 1; }else{si = mid+1;}}return si; }
    int upperBound(ArrayList<Integer> list, int x){int n = list.size(), si = 0, ei = n - 1;while(si <= ei){int mid = si + (ei - si)/2;if(list.get(mid) == x){if(mid+1 < n && list.get(mid+1) == list.get(mid)){si = mid+1;}else{return mid + 1;}}else if(list.get(mid) > x){ei = mid - 1; }else{si = mid+1;}}return si; }
    void swap(int[] arr, int i, int j){int temp = arr[i];arr[i] = arr[j];arr[j] = temp;}
    long nextPowerOf2(long v){if (v == 0) return 1;v--;v |= v >> 1;v |= v >> 2;v |= v >> 4;v |= v >> 8;v |= v >> 16;v |= v >> 32;v++;return v;}
    int gcd(int a, int b) {if(a == 0){return b;}return gcd(b%a, a);} // TC- O(logmax(a,b))
    boolean nextPermutation(int[] arr) {if(arr == null || arr.length <= 1){return false;}int last = arr.length-2;while(last >= 0){if(arr[last] < arr[last+1]){break;}last--;}if (last < 0){return false;}if(last >= 0){int nextGreater = arr.length-1;for(int i=arr.length-1; i>last; i--){if(arr[i] > arr[last]){nextGreater = i;break;}}swap(arr, last, nextGreater);}int i = last + 1, j = arr.length - 1;while(i < j){swap(arr, i++, j--);}return true;}
 
    public static void main(String[] args) {
        new _1615c().runIO();
    }
}

