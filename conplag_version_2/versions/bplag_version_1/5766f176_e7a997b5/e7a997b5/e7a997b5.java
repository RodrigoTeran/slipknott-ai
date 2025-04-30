import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        boolean readFromLocal = true;
        //readFromLocal = false;
        String filepath = "src/input.txt";
        //FileInputStrviseam fileInputStream = new FileInputStream(filepath);
        InputReader inputReader = new InputReader(System.in);
        Solve s = new Solve();
        s.solve(inputReader);
    }
}

class Solve {

    public void solve(InputReader inputReader) {
        int t,n;
        t = inputReader.nextInt();
        while (t>0) {
            t--;
            n = inputReader.nextInt();
            Graph g = new Graph(n);
            g.res = new int[n-1];
            for(int i=1;i<n;i++){
                g.addEdge(inputReader.nextInt(), inputReader.nextInt(),i-1,true);
            }
            if (g.hasDegreeMoreThanTwo()){
                System.out.println(-1);
            }else {
                int minDegree = 2,node = 1;
                for(int i=1;i<=n;i++){
                    if (g.adj[i].size()<minDegree){
                        node = i;
                        minDegree = g.adj[i].size();
                    }
                }
                g.dfs(node,-1,2);
                for(int i=0;i<n-1;i++){
                    System.out.print(g.res[i] + " ");
                }
                System.out.println();
            }
        }
    }
}
class PairComp implements Comparator<Pair> {

    @Override
    public int compare(Pair o1, Pair o2) {
        return (int) (o1.first - o2.first);
    }
}

class InputReader {
    private boolean finished = false;

    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    private SpaceCharFilter filter;

    public InputReader(InputStream stream) {
        this.stream = stream;
    }

    public int read() {
        if (numChars == -1) {
            throw new InputMismatchException();
        }
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0) {
                return -1;
            }
        }
        return buf[curChar++];
    }

    public int peek() {
        if (numChars == -1) {
            return -1;
        }
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                return -1;
            }
            if (numChars <= 0) {
                return -1;
            }
        }
        return buf[curChar];
    }

    public int nextInt() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public long nextLong() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        long res = 0;
        do {
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public String nextString() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        StringBuilder res = new StringBuilder();
        do {
            if (Character.isValidCodePoint(c)) {
                res.appendCodePoint(c);
            }
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }

    public boolean isSpaceChar(int c) {
        if (filter != null) {
            return filter.isSpaceChar(c);
        }
        return isWhitespace(c);
    }

    public static boolean isWhitespace(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    private String readLine0() {
        StringBuilder buf = new StringBuilder();
        int c = read();
        while (c != '\n' && c != -1) {
            if (c != '\r') {
                buf.appendCodePoint(c);
            }
            c = read();
        }
        return buf.toString();
    }

    public String readLine() {
        String s = readLine0();
        while (s.trim().length() == 0) {
            s = readLine0();
        }
        return s;
    }

    public String readLine(boolean ignoreEmptyLines) {
        if (ignoreEmptyLines) {
            return readLine();
        } else {
            return readLine0();
        }
    }

    public BigInteger readBigInteger() {
        try {
            return new BigInteger(nextString());
        } catch (NumberFormatException e) {
            throw new InputMismatchException();
        }
    }

    public char nextCharacter() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        return (char) c;
    }

    public double nextDouble() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        double res = 0;
        while (!isSpaceChar(c) && c != '.') {
            if (c == 'e' || c == 'E') {
                return res * Math.pow(10, nextInt());
            }
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            res *= 10;
            res += c - '0';
            c = read();
        }
        if (c == '.') {
            c = read();
            double m = 1;
            while (!isSpaceChar(c)) {
                if (c == 'e' || c == 'E') {
                    return res * Math.pow(10, nextInt());
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                m /= 10;
                res += (c - '0') * m;
                c = read();
            }
        }
        return res * sgn;
    }

    public boolean isExhausted() {
        int value;
        while (isSpaceChar(value = peek()) && value != -1) {
            read();
        }
        return value == -1;
    }

    public String next() {
        return nextString();
    }

    public SpaceCharFilter getFilter() {
        return filter;
    }

    public void setFilter(SpaceCharFilter filter) {
        this.filter = filter;
    }

    public interface SpaceCharFilter {
        boolean isSpaceChar(int ch);
    }

    public int[] nextIntArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; ++i) array[i] = nextInt();
        return array;
    }

    public int[] nextSortedIntArray(int n) {
        int[] array = nextIntArray(n);
        Arrays.sort(array);
        return array;
    }

    public int[] nextSumIntArray(int n) {
        int[] array = new int[n];
        array[0] = nextInt();
        for (int i = 1; i < n; ++i) array[i] = array[i - 1] + nextInt();
        return array;
    }

    public long[] nextLongArray(int n) {
        long[] array = new long[n];
        for (int i = 0; i < n; ++i) array[i] = nextLong();
        return array;
    }

    public long[] nextSumLongArray(int n) {
        long[] array = new long[n];
        array[0] = nextInt();
        for (int i = 1; i < n; ++i) array[i] = array[i - 1] + nextInt();
        return array;
    }

    public long[] nextSortedLongArray(int n) {
        long[] array = nextLongArray(n);
        Arrays.sort(array);
        return array;
    }
}

class Pair implements Comparable<Pair> {
    long first, second;

    public Pair(long first, long second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public int compareTo(Pair o) {
        return (int) (this.second - o.second);
    }
}

class Utils {
    static void swap(int[] res, int i, int j) {
        int temp = res[i];
        res[i] = res[j];
        res[j] = temp;
    }

    static long pow(long num, int n, long mod) {
        long res = num % mod;
        while (n > 0) {
            if ((n & 1) != 0) {
                res = (res * num) % mod;
            }
            num = (num * num) % mod;
            n >>= 1;
        }
        return res;
    }

}

class Graph {
    public ArrayList<int[]>[] adj;
    int size;
    boolean[] vis;
    public int [] res;
    Graph(int n){
        this.size = n;
        this.adj = new ArrayList[n+1];
        this.vis = new boolean[n+1];
        for (int i = 0; i <=n; i++) {
            adj[i] = new ArrayList<>();
        }
    }
    public void addEdge(int a, int b, int edge,boolean biDirectional){
        adj[a].add(new int[]{b, edge});
        if (biDirectional) {
            adj[b].add(new int[]{a, edge});
        }
    }

    public void dfs(int node,int parent,int prime){
        for (int[] nodePair: adj[node]) {
            if (nodePair[0]!=parent){
                res[nodePair[1]] = prime;
                dfs(nodePair[0],node,prime^1);
            }
        }
    }
    boolean hasDegreeMoreThanTwo() {
        for (int i = 0; i <= size; i++) {
            if (adj[i].size()>2){
                return true;
            }
        }
        return false;
    }

}
