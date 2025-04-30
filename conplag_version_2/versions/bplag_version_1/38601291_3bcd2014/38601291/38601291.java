import java.io.*;
import java.util.*;

import javax.sound.midi.MidiChannel;

public class Main {
    static PrintWriter out;
    static Kioken sc;

    public static void main(String[] args) throws FileNotFoundException {
        boolean t = true;
        boolean f = false;
        if (f) {
            out = new PrintWriter("output.txt");
            sc = new Kioken("input.txt");
        } else {
            out = new PrintWriter((System.out));
            sc = new Kioken();
        }

        int tt = 1;
        tt = sc.nextInt();
        while (tt-- > 0) {
            solve();
        }
        out.flush();
        out.close();
    }

    static boolean bs(int[] arr, int a){
    
      // out.println(" mid1 "  + Arrays.toString(arr) + " " + a);

      int[] curr = Arrays.copyOf(arr, arr.length);
     for(int i = arr.length - 1; i >= 2; i--){
       if(arr[i] < a){
         return false;
       }
       int min = Math.min(arr[i] - a, curr[i]);
       min = min/3;
       arr[i] -= 3*min;
       arr[i - 1] += min;
       arr[i-2] += 2*min;
     }

      for(int i: arr){
        if(i < a){
          return false;
        }
      }
      return true;
    }
    public static void solve() {
       int n = sc.nextInt();
       int[] arr = new int[n];
       int max = Integer.MIN_VALUE;
       for(int i = 0; i < n; i++){
         arr[i] = sc.nextInt();
         max = Math.max(max, arr[i]);
       }

       int l = 0, r = max, ans = 0;
       while(l <= r){
         int mid = (l+r)/2;
        //  out.println(" l r " + l + " " + r);
         int[] aa = Arrays.copyOf(arr, arr.length);
         if(bs(aa, mid)){
          // out.println(Arrays.toString(arr) + " " + Arrays.toString(aa) + " mid "  + mid );
            ans = mid;
            l = mid+1;
         }else{
           r = mid-1;
         }
       }
       out.println(ans);
    }

    public static long leftShift(long a) {
        return (long) Math.pow(2, a);
    }

    public static void reverse(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = temp;
        }
        return;
    }

    public static int lower_bound(ArrayList<Integer> ar, int k) {
        int s = 0, e = ar.size();
        while (s != e) {
            int mid = s + e >> 1;
            if (ar.get(mid) <= k) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }
        return Math.abs(s) - 1;
    }

    public static int upper_bound(ArrayList<Integer> ar, int k) {
        int s = 0;
        int e = ar.size();
        while (s != e) {
            int mid = s + e >> 1;
            if (ar.get(mid) < k) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }
        if (s == ar.size()) {
            return -1;
        }
        return s;
    }

    static class Kioken {
        // FileInputStream br = new FileInputStream("input.txt");

        BufferedReader br;
        StringTokenizer st;

        Kioken(String filename) {
            try {
                FileReader fr = new FileReader(filename);
                br = new BufferedReader(fr);
                st = new StringTokenizer("");

            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }

        Kioken() {
            try {
                br = new BufferedReader(new InputStreamReader(System.in));
                st = new StringTokenizer("");

            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }

        public String next() {
            while (!st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            try {
                return br.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        public boolean hasNext() {
            String next = null;
            try {
                next = br.readLine();
            } catch (Exception e) {
            }
            if (next == null || next.length() == 0) {
                return false;
            }
            st = new StringTokenizer(next);
            return true;
        }
    }
}