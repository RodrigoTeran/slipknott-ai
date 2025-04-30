import java.io.*;
import java.util.*;
public class A734C {
    public static void main(String[] args) {
        JS scan = new JS();
        int t = scan.nextInt();
        loop:while(t-->0){
            int n = scan.nextInt();
            String[] arr= new String[n];
            Integer[][] counts = new Integer[5][n];
            for(int i = 0;i<5;i++){
                for(int j = 0;j<n;j++){
                    counts[i][j] = 0;
                }
            }
            for(int i =0;i<n;i++){
                arr[i] = scan.next();
                int[] freq =new int[5];
                for(int j = 0;j<arr[i].length();j++){
                    freq[arr[i].charAt(j)-'a']++;
                }
                for(int j = 0;j<5;j++){
                    counts[j][i] = freq[j]-(arr[i].length()-freq[j]);
                }
            }
            int best = 0;
            for(int i = 0;i<5;i++){
                Arrays.sort(counts[i]);
                int curr = 0;
                int extra = 0;
                for(int j = n-1;j>=0;j--){
                    extra+=counts[i][j];
                    if(extra>0)curr++;
                }
                best = Math.max(best,curr);
            }
            System.out.println(best);

        }
    }
    static class JS {
        public int BS = 1 << 16;
        public char NC = (char) 0;
        byte[] buf = new byte[BS];
        int bId = 0, size = 0;
        char c = NC;
        double num = 1;
        BufferedInputStream in;

        public JS() {
            in = new BufferedInputStream(System.in, BS);
        }

        public JS(String s) throws FileNotFoundException {
            in = new BufferedInputStream(new FileInputStream(new File(s)), BS);
        }

        public char nextChar() {
            while (bId == size) {
                try {
                    size = in.read(buf);
                } catch (Exception e) {
                    return NC;
                }
                if (size == -1) return NC;
                bId = 0;
            }
            return (char) buf[bId++];
        }

        public int nextInt() {
            return (int) nextLong();
        }

        public long nextLong() {
            num = 1;
            boolean neg = false;
            if (c == NC) c = nextChar();
            for (; (c < '0' || c > '9'); c = nextChar()) {
                if (c == '-') neg = true;
            }
            long res = 0;
            for (; c >= '0' && c <= '9'; c = nextChar()) {
                res = (res << 3) + (res << 1) + c - '0';
                num *= 10;
            }
            return neg ? -res : res;
        }

        public double nextDouble() {
            double cur = nextLong();
            return c != '.' ? cur : cur + nextLong() / num;
        }

        public String next() {
            StringBuilder res = new StringBuilder();
            while (c <= 32) c = nextChar();
            while (c > 32) {
                res.append(c);
                c = nextChar();
            }
            return res.toString();
        }

        public String nextLine() {
            StringBuilder res = new StringBuilder();
            while (c <= 32) c = nextChar();
            while (c != '\n') {
                res.append(c);
                c = nextChar();
            }
            return res.toString();
        }

        public boolean hasNext() {
            if (c > 32) return true;
            while (true) {
                c = nextChar();
                if (c == NC) return false;
                else if (c > 32) return true;
            }
        }
    }
}
