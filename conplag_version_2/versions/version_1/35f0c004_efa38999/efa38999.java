import java.util.*;
import java.io.*;

public class Main {
    // For fast input output
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            try {
                br = new BufferedReader(
                        new FileReader("input.txt"));
                PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
                System.setOut(out);
            } catch (Exception e) {
                br = new BufferedReader(new InputStreamReader(System.in));
            }
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

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    // end of fast i/o code
    public static void main(String[] args) {
        FastReader reader = new FastReader();
        StringBuilder sb = new StringBuilder("");

        int t = reader.nextInt();
        int ans = 0;
        while (t-- > 0) {
            int n = reader.nextInt();
            String a = reader.nextLine();
            String b = reader.nextLine();
            ans  = -1;

            int even_demand = 0;
            int odd_demand = 0;
            int same_ones = 0, same_zeros = 0;
            int diff_ones = 0, diff_zeros = 0;
            for(int i=0; i<n; i++){
                if(a.charAt(i)==b.charAt(i)){
                    even_demand++;
                    if(a.charAt(i)=='1'){
                        same_ones++;
                    }else{
                        same_zeros++;
                    }
                }else{
                    odd_demand++;
                    if(a.charAt(i)=='1'){
                        diff_ones++;
                    }else{
                        diff_zeros++;
                    }
                }
            }

            // System.out.println(even_demand+" "+same_ones+" "+same_zeros+" "+odd_demand+" "+diff_ones+" "+diff_zeros);
            if(even_demand%2==1 && same_ones==same_zeros+1){
                ans = even_demand;
            }
            if(odd_demand%2==0 && diff_ones==diff_zeros){
                if(ans==-1){
                    ans = odd_demand;
                }else{
                    ans = Math.min(ans, odd_demand);
                }
            }
            sb.append(ans + "\n");
        }
        System.out.println(sb);
    }
}