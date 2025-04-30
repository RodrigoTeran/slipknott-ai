import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C {

    static class scanner {
        static BufferedReader reader;
        static StringTokenizer tokenizer;
        static void init(InputStream input) {
            reader = new BufferedReader(new InputStreamReader(input));
            tokenizer = new StringTokenizer("");
        }
        static String next() throws IOException {
            while (!tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }
        static int nextInt() throws IOException {return Integer.parseInt(next());}
        static double nextDouble() throws IOException {return Double.parseDouble(next());}
        static long nextLong() throws IOException {return Long.parseLong(next());}
    }
    static long min(long a, long b) {return Math.min(a, b);}
    static long min(long a, long b, long c) {return min(a, min(b, c));}
    static int min(int a, int b) {return Math.min(a, b);}
    static int min(int a, int b, int c) {return min(a, min(b, c));}
    static long max(long a, long b) {return Math.max(a, b);}
    static long max(long a, long b, long c) {return max(a, max(b, c));}
    static int max(int a, int b) {return Math.max(a, b);}
    static int max(int a, int b, int c) {return max(a, max(b, c));}
    static int abs(int x) {return Math.abs(x);}
    static long abs(long x) {return Math.abs(x);}
    static long ceil(double x) {return (long) Math.ceil(x);}
    static long floor(double x) {return (long) Math.floor(x);}
    static int ceil(int x) {return (int) Math.ceil(x);}
    static int floor(int x) {return (int) Math.floor(x);}
    static double sqrt(double x) {return Math.sqrt(x);}
    static double cbrt(double x) {return Math.cbrt(x);}
    static long sqrt(long x) {return (long) Math.sqrt(x);}
    static long cbrt(long x) {return (long) Math.cbrt(x);}
    static int gcd(int a, int b) {if(b == 0)return a;return gcd(b, a % b);}
    static long gcd(long a, long b) {if(b == 0)return a;return gcd(b, a % b);}
    static double pow(double n, double power) {return Math.pow(n, power);}
    static long pow(long n, double power) {return (long) Math.pow(n, power);}
    static class Pair {int first, second;public Pair(int first, int second) {this.first = first;this.second = second;}}
    
    public static void main(String[] args) throws IOException {
        scanner.init(System.in);
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
    
    static void solve() throws IOException {
        int n = scanner.nextInt();
        List<List<Pair>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 0; i < n-1; i++) {
            int u = scanner.nextInt()-1;
            int v = scanner.nextInt()-1;
            tree.get(u).add(new Pair(v, i));
            tree.get(v).add(new Pair(u, i));
        }
        int start = -1;
        for (int i = 0; i < n; i++) {
            if(tree.get(i).size() > 2) {
                System.out.println(-1);
                return;
            }
            else if(tree.get(i).size() == 1) {
                start = i;
            }
        }
        int[] res = new int[n-1];

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        int weight =  2, prev = -1;
        while (!q.isEmpty()) {
            int u = q.poll();
            for(Pair v : tree.get(u)) {
                if(v.first != prev) {
                    q.add(v.first);
                    res[v.second] = weight;
                    weight = 5 - weight;
                }
            }
            prev = u;
        }

        for(int i : res) {
            System.out.print(i + " ");
        }
        System.out.println();

    }

   
}


