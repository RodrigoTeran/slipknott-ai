
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class D {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int cases = fs.nextInt();
        while(cases-->0){
            int n = fs.nextInt(), k = fs.nextInt();
            int[] positions = fs.readArray(k), temps = fs.readArray(k);
            int[] forced = new int[n];
            Arrays.fill(forced, Integer.MAX_VALUE/2);
            for(int i=0; i<k; i++)
                forced[positions[i]-1] = temps[i];
            for(int i=1; i<n; i++)
                forced[i] = Math.min(forced[i],forced[i-1]+1);
            for(int i=n-2; i>=0; i--)
                forced[i] = Math.min(forced[i], forced[i+1]+1);
            for(int i=0; i<n; i++)
                System.out.print(forced[i] + " ");
            System.out.println();

        }
    }





    //----------------------------------------------------------------------------------//
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
        String next() {
            while (!st.hasMoreTokens())
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
        char nextChar(){
            return next().charAt(0);
        }
        int[] readArray(int n) {
            int[] a=new int[n];
            for (int i=0; i<n; i++) a[i]=nextInt();
            return a;
        }
        long nextLong() {
            return Long.parseLong(next());
        }
    }
    static class Debug{
        public static void debug(long a){
            System.out.println("--> "+a);
        }
        public static void debug(long a, long b){
            System.out.println("--> "+ a +" + " + b);
        }
        public static void debug(char a, char b){ System.out.println("--> "+ a +" + " + b); }
        public static void debug(int[] array){
            System.out.print("Array--> ");
            System.out.println(Arrays.toString(array));
        }
        public static void debug(char[] array){
            System.out.print("Array--> ");
            System.out.println(Arrays.toString(array));
        }
        public static void debug(HashMap<Integer,Integer> map){
            System.out.print("Map--> "+map.toString());
        }
    }
}
