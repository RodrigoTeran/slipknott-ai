import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.io.PrintStream;
            //import java.util.*;

        public class Solution {

            public static final boolean LOCAL = System.getProperty("ONLINE_JUDGE")==null;

            static class FastScanner {

                    BufferedReader br;
                    StringTokenizer st ;

                    FastScanner(){
                        br =  new BufferedReader(new InputStreamReader(System.in));
                        st = new StringTokenizer("");
                    }

                    FastScanner(String file) {

                        try {
                            br =  new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                            st = new StringTokenizer("");
                        } catch (FileNotFoundException e) {
                            // TODO Auto-generated catch block
                            System.out.println("file not found");
                            e.printStackTrace();
                        }
                        
                    }
                    

                    String next() {
                        while (!st.hasMoreTokens())
                            try {
                                st = new StringTokenizer(br.readLine());
                            } catch (IOException e) {
                            }
                        return st.nextToken();
                    }

                    int nextInt() {
                        return Integer.parseInt(next());
                    }

                    long nextLong() {
                        return Long.parseLong(next());
                    }
                    String readLine() throws IOException{
                        return br.readLine();
                    }
                }
                                    
            static class Pair<T,X>{
                T first;
                X second;
                Pair(T first,X second){
                    this.first = first;
                    this.second = second;
                }

                @Override
                public int hashCode(){
                    return Objects.hash(first,second);
                }

                @Override
                public boolean equals(Object obj){
                    return obj.hashCode() == this.hashCode();
                }

            }

        
        public static void main(String[] args) throws Exception {
            
            FastScanner s = new FastScanner();

            PrintStream debug = null;
            
            if(LOCAL){
                s = new FastScanner("src/input.txt");
                PrintStream o = new PrintStream("src/sampleout.txt");
                debug = new PrintStream("src/debug.txt");
                System.setOut(o);
            }

            


            int tcr = s.nextInt();

            
            for(int tc=0;tc<tcr;tc++){
                int n = s.nextInt();

                long arr[] = new long[n];

                for(int i=0;i<n;i++){
                    arr[i] = s.nextLong();
                }

                long min1 = arr[0];
                long min2 = arr[1];
                long sum1 = arr[0];
                long sum2 = arr[1];

                int cnt1 = 1;
                int cnt2 = 1;

                long ans = arr[0]*(n) + arr[1]*(n);

                for(int i=2;i<n;i++){
                    if((i % 2) == 0){
                        min1 = Math.min(min1,arr[i]);
                        sum1 += arr[i];
                        cnt1++;
                    }else{
                        min2 = Math.min(min2,arr[i]);
                        sum2 += arr[i];
                        cnt2++;
                    }
                    long temp = min1*(n - cnt1 + 1) + (sum1 - min1) + (min2*(n- cnt2 + 1) + (sum2 - min2));
                    ans = Math.min(ans,temp);
                }

                println(ans);
            }                
        }

        static int len(long num){
            return Long.toString(num).length();
        }

        static long mulmod(long a, long b,long mod)
        {
            return ((a%mod) * (b%mod)) % mod;
        }


        public static void dbg(PrintStream ps,Object... o) throws Exception{
            if(ps == null){
                return;
            }
            Debug.dbg(ps,o);
        }

       
  

        public static long modpow(long num,long pow,long mod){

            long val = num;
            long ans = 1l;

            while(pow > 0l){
                
                long bit = pow & 1l;

                if(bit == 1){
                    ans = (ans * (val%mod))%mod;
                }

                val = (val * val) % mod;
                pow = pow >> 1;
            }

            return ans;

        }

        public static char get(int n){
            return (char)('a' + n);
        }

        public static long[] sort(long arr[]){
            List<Long> list = new ArrayList<>();
            for(long n : arr){list.add(n);}
            Collections.sort(list);
            for(int i=0;i<arr.length;i++){
                arr[i] = list.get(i);
            }
            return arr;
        }

        public static int[] sort(int arr[]){
            List<Integer> list = new ArrayList<>();
            for(int n : arr){list.add(n);}
            Collections.sort(list);
            for(int i=0;i<arr.length;i++){
                arr[i] = list.get(i);
            }
            return arr;
        }

        // return the (index + 1)
        // where index is the pos of just smaller element
        // i.e count of elemets strictly less than num
        public static int justSmaller(long arr[],long num){
            //  System.out.println(num+"@");
            int st = 0;
            int e = arr.length - 1;
    
            int ans = -1;
    
            while(st <= e){
    
                int mid = (st + e)/2;
    
                if(arr[mid] >= num){
                    e = mid - 1;
                }else{
                    ans = mid;
                    st = mid + 1;
                }
    
            }
    
    
            return ans + 1;
    
        }
        
        //return (index of just greater element)
        //count of elements smaller than or equal to num

        public static int justGreater(long arr[],long num){
            int st = 0;
            int e = arr.length - 1;
    
            int ans = arr.length;
    
            while(st <= e){
                
                int mid = (st + e)/2;
    
                if(arr[mid] <= num){
                    st = mid + 1;
                }else{
                    ans = mid;
                    e = mid - 1;
                }
            }
    
            return ans;
    
        }
    
        

        public static void println(Object obj){
            System.out.println(obj.toString());
        }

        public static void print(Object obj){
            System.out.print(obj.toString());
        }

        public static int gcd(int a,int b){
            if(b == 0){return a;}
            return gcd(b,a%b);
        }

        public static long gcd(long a,long b){
            if(b == 0l){
                return a;
            }

            return gcd(b,a%b);
        }

        public static int find(int parent[],int v){
            if(parent[v] == v){
                return v;
            }
            
            return parent[v] = find(parent, parent[v]);
        }

    

        public static List<Integer> sieve(){
        
            List<Integer> prime = new ArrayList<>();

            int arr[] = new int[100001];

            Arrays.fill(arr,1);

            arr[1] = 0;
            arr[2] = 1;

            for(int i=2;i<=100000;i++){
                
                if(arr[i] == 1){
                    
                    prime.add(i);

                    for(long j = (i*1l*i);j<100001;j+=i){
                        arr[(int)j] = 0;
                    }
                }
            }

            return prime;
        }

        static boolean isPower(long n,long a){
            
            long log = (long)(Math.log(n)/Math.log(a));

            long power = (long)Math.pow(a,log);

            if(power == n){return true;}

            return false;
        }


        private static int mergeAndCount(int[] arr, int l,int m, int r)
        {

            // Left subarray
            int[] left =  Arrays.copyOfRange(arr, l, m + 1);

            // Right subarray
            int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);

            int i = 0, j = 0, k = l, swaps = 0;

            while (i < left.length && j < right.length) {
                if (left[i] <= right[j])
                    arr[k++] = left[i++];
                else {
                    arr[k++] = right[j++];
                    swaps += (m + 1) - (l + i);
                }
            }
            while (i < left.length)
                arr[k++] = left[i++];
            while (j < right.length)
                arr[k++] = right[j++];
            return swaps;
        }

        // Merge sort function
        private static int mergeSortAndCount(int[] arr, int l,int r)
        {

            // Keeps track of the inversion count at a
            // particular node of the recursion tree
            int count = 0;

            if (l < r) {
                int m = (l + r) / 2;

                // Total inversion count = left subarray count
                // + right subarray count + merge count

                // Left subarray count
                count += mergeSortAndCount(arr, l, m);

                // Right subarray count
                count += mergeSortAndCount(arr, m + 1, r);

                // Merge count
                count += mergeAndCount(arr, l, m, r);
            }

            return count;
        }

        static class Debug{
            //change to System.getProperty("ONLINE_JUDGE")==null; for CodeForces
            public static final boolean LOCAL = System.getProperty("ONLINE_JUDGE")==null;

            

            private static <T> String ts(T t) {
                if(t==null) {
                    return "null";
                }
                try {
                    return ts((Iterable) t);
                }catch(ClassCastException e) {
                    if(t instanceof int[]) {
                        String s = Arrays.toString((int[]) t);
                        return "{"+s.substring(1, s.length()-1)+"}\n";
                    }else if(t instanceof long[]) {
                        String s = Arrays.toString((long[]) t);
                        return "{"+s.substring(1, s.length()-1)+"}\n";
                    }else if(t instanceof char[]) {
                        String s = Arrays.toString((char[]) t);
                        return "{"+s.substring(1, s.length()-1)+"}\n";
                    }else if(t instanceof double[]) {
                        String s = Arrays.toString((double[]) t);
                        return "{"+s.substring(1, s.length()-1)+"}\n";
                    }else if(t instanceof boolean[]) {
                        String s = Arrays.toString((boolean[]) t);
                        return "{"+s.substring(1, s.length()-1)+"}\n";
                    }
                    try {
                        return ts((Object[]) t);
                    }catch(ClassCastException e1) {
                        return t.toString();
                    }
                }
            }
            private static <T> String ts(T[] arr) {
                StringBuilder ret = new StringBuilder();
                ret.append("{");
                boolean first = true;
                for(T t: arr) {
                    if(!first) {
                        ret.append(", ");
                    }
                    first = false;
                    ret.append(ts(t));
                }
                ret.append("}");
                return ret.toString();
            }
            private static <T> String ts(Iterable<T> iter) {
                StringBuilder ret = new StringBuilder();
                ret.append("{");
                boolean first = true;
                for(T t: iter) {
                    if(!first) {
                        ret.append(", ");
                    }
                    first = false;
                    ret.append(ts(t));
                }
                ret.append("}");
                return ret.toString();
            }
            public static void dbg(PrintStream ps,Object... o) throws Exception {
                if(LOCAL) {
                    System.setErr(ps);
                    System.err.print("Line #"+Thread.currentThread().getStackTrace()[2].getLineNumber()+": [");
                    for(int i = 0; i<o.length; i++) {
                        if(i!=0) {
                            System.err.print(", ");
                        }
                        System.err.print(ts(o[i]));
                    }
                    System.err.println("]");
                }
            }
        }

}