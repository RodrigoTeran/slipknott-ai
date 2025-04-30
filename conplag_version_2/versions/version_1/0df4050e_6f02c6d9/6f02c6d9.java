
import java.io.*;
import java.util.*;

public class Main {


    static long mod = 1000000007;

    static long inv(long a, long b) {
        return 1 < a ? b - inv(b % a, a) * b / a : 1;
    }

    static long mi(long a) {
        return inv(a, mod);
    }

    static InputReader sc = new InputReader(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {

        int t = sc.nextInt();
        while (t-- > 0) {

            int n = sc.nextInt();
            int[] A = new int[n];

            for (int i = 0; i < A.length; i++) {
                A[i] = sc.nextInt();
            }
            String word = sc.next();
            ArrayList<Integer> blue = new ArrayList<>();
            ArrayList<Integer> red = new ArrayList<>();

            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == 'R') {
                    red.add(A[i]);
                } else {
                    blue.add(A[i]);
                }
            }
            Collections.sort(blue);
            Collections.sort(red);

            boolean possible = true;

            int a = 1;
            for (int i = 0; i < blue.size(); i++, a++) {
                if (blue.get(i) < a) {
                    possible = false;
                    break;
                }
            }

            for (int i = 0; i < red.size(); i++, a++) {
                if (red.get(i) > a) {
                    possible = false;
                    break;
                }
            }

            if (possible) out.println("YES");
            else out.println("NO");


        }
        out.flush();
        out.close();
    }

    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }


        String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
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
                str = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return str;
        }
    }

    public static void shuffle(int[] a) {
        Random get = new Random();
        for (int i = 0; i < a.length; i++) {
            int r = get.nextInt(a.length);
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    public static void shuffle(long[] a) {
        Random get = new Random();
        for (int i = 0; i < a.length; i++) {
            int r = get.nextInt(a.length);
            long temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

}
