import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        MyScanner scan = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        int t = scan.nextInt();
        for (int i = 0; i < t; i++) {
            int num = scan.nextInt();
            int[] sequence = new int[num];
            for (int j = 0; j < num; j++) {
                sequence[j] = scan.nextInt();
            }

            int[] setSum = new int[(int) Math.pow(3, num)];

            for (int k = 0; k < num; k++) {
                int pot =(int)Math.pow(3, k);
                
                for (int j = 1; j < setSum.length; j++) {
                    if(j % (pot*3) >= pot ){
                        if(j % (pot*3) >= pot){
                            if(j % (pot*3) >= pot*2){
                                setSum[j] += sequence[k];
                            }else{
                                setSum[j] -= sequence[k];
                            }
                        }

                    }
                }
            }
            String output = "NO";
            for (int j = 1; j < setSum.length; j++) {
                if(setSum[j] == 0){
                    output = "YES";
                    break;
                }
            }
            out.println(output);
        }
        out.close();
    }

    public static PrintWriter out;
    public static class MyScanner { BufferedReader br; StringTokenizer st;

        public MyScanner() {
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

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine(){
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}