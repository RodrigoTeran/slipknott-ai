import java.util.*;
import java.io.*;

public class Main {
    static FastScanner sc = new FastScanner(System.in);
    static PrintWriter pw = new PrintWriter(System.out);
    static StringBuilder sb = new StringBuilder();
    static long mod = (long) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) solve();
        pw.flush();
    }

    public static void solve() {
        int n = sc.nextInt();
        char[] a = sc.next().toCharArray();
        char[] b = sc.next().toCharArray();
        boolean isFirst = false;
        boolean allOk = true;
        int a1 = 0;
        int a0 = 0;
        int b1 = 0;
        int b0 = 0;
        int[][] cnt1 = new int[2][2];
        for(int i = 0; i < n; i++){
            if(a[i] != b[i]){
                allOk = false;
            }
            if(a[i] == '1'){
                a1++;
                isFirst = true;
            }else{
                a0++;
            }
            if(b[i] == '1'){
                b1++;
            }else{
                b0++;
            }
            cnt1[a[i]-'0'][b[i]-'0']++;
        }
        if(allOk){
            pw.println(0);
            return;
        }else if(!isFirst){
            pw.println(-1);
            return;
        }else if(a1 != b1 && (a0+1) != b1){
            pw.println(-1);
            return;
        }else{
            int same = cnt1[1][1] - cnt1[0][0] == 1 ? cnt1[1][1] + cnt1[0][0] : Integer.MAX_VALUE;
            int odd = cnt1[1][0] - cnt1[0][1] == 0 ? cnt1[1][0] + cnt1[0][1] : Integer.MAX_VALUE;
            int min = Math.min(same,odd);
            pw.println(min == Integer.MAX_VALUE ? -1 : min);
        }
    }
    

    static class GeekInteger {
        public static void save_sort(int[] array) {
            shuffle(array);
            Arrays.sort(array);
        }

        public static int[] shuffle(int[] array) {
            int n = array.length;
            Random random = new Random();
            for (int i = 0, j; i < n; i++) {
                j = i + random.nextInt(n - i);
                int randomElement = array[j];
                array[j] = array[i];
                array[i] = randomElement;
            }
            return array;
        }

        public static void save_sort(long[] array) {
            shuffle(array);
            Arrays.sort(array);
        }

        public static long[] shuffle(long[] array) {
            int n = array.length;
            Random random = new Random();
            for (int i = 0, j; i < n; i++) {
                j = i + random.nextInt(n - i);
                long randomElement = array[j];
                array[j] = array[i];
                array[i] = randomElement;
            }
            return array;
        }

    }
}

class FastScanner {
    private BufferedReader reader = null;
    private StringTokenizer tokenizer = null;

    public FastScanner(InputStream in) {
        reader = new BufferedReader(new InputStreamReader(in));
        tokenizer = null;
    }

    public FastScanner(FileReader in) {
        reader = new BufferedReader(in);
        tokenizer = null;
    }

    public String next() {
        if (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public String nextLine() {
        if (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken("\n");
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public String[] nextArray(int n) {
        String[] a = new String[n];
        for (int i = 0; i < n; i++)
            a[i] = next();
        return a;
    }

    public int[] nextIntArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = nextInt();
        return a;
    }

    public long[] nextLongArray(int n) {
        long[] a = new long[n];
        for (int i = 0; i < n; i++)
            a[i] = nextLong();
        return a;
    }
}
