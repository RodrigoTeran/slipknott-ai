import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;


public class Cgr18A {


    public static void main(String[] args) {

        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader sc = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Solver solver = new Solver();
        int t = sc.nextInt();
//        int t = 1;
        while (t-- != 0) {
            solver.solve(sc, out);
        }
        out.close();

    }

    static class Solver {
        final int INF = (int) 1e9;
        public void solve(InputReader sc, PrintWriter out) {
            int n = sc.nextInt();
            char[] a = sc.next().toCharArray();
            char[] b = sc.next().toCharArray();
            boolean isAllZeroA = isAllZero(a);
            boolean isAllZeroB = isAllZero(b);
            if(isAllZeroA && isAllZeroB) {
                out.println(0);
                return;
            }
            if(isAllZeroA || isAllZeroB) {
                out.println(-1);
                return;
            }
            int eq = 0;
            for(int i = 0; i< n;i++) if(a[i]==b[i]) eq++;
            int eqHasOne = 0;
            int notEqHasOne = 0;
            int noteq = n-eq;
            for (int i = 0; i < n; i++) {
                if(a[i]==b[i] && a[i]=='1') eqHasOne++;
                if(a[i]!=b[i] && a[i]=='1') notEqHasOne++;
            }
            int l = solveIt(new int[] {eq,noteq},new int[] {eqHasOne,notEqHasOne},0);
            int r = solveIt(new int[] {eq,noteq},new int[] {eqHasOne,notEqHasOne},1);
            if(l==INF && r==INF) {
                out.println(-1);
            } else {
                out.println(Math.min(l,r));
            }
        }

        private boolean isAllZero(char[] a) {
            for(char c : a) if(c=='1') return false;
            return true;
        }

        private int solveIt(int[] arr,int[] hasOne, int minusPointer) {
            if(arr[0]==0 && arr[1]==0) throw new RuntimeException();
            int cnt = 0;
            int max = arr[0] + arr[1];
            while(arr[1]!=0) {
                int minus = minusPointer;
                int plus = 1-minus;
                if(hasOne[minusPointer]<1) return INF;
                int eqHasOne = hasOne[0];
                int notEqHasOne = hasOne[1];
                int eqHasZero = arr[0] - eqHasOne;
                int notEqHasZero = arr[1] - notEqHasOne;
                if(minusPointer==0) {
                    int newNotEqHasOne = eqHasZero;
                    int newEqHasOne = notEqHasZero + 1;
                    hasOne[0] = newEqHasOne;
                    hasOne[1] = newNotEqHasOne;
                } else {
                    int newEqHasOne = notEqHasZero;
                    int newNotEqHasOne = eqHasZero + 1;
                    hasOne[0] = newEqHasOne;
                    hasOne[1] = newNotEqHasOne;
                }
                int minusValue = arr[minus]-1;
                int plusValue = arr[plus]+1;
                arr[minus] = plusValue;
                arr[plus] = minusValue;
                minusPointer = 1-minusPointer;
                cnt++;
                if(cnt>max+10) break;
            }
            if(arr[1]!=0) return INF;
            return cnt;
        }
    }

    static void sort(int[] arr) {
        ArrayList<Integer> al = new ArrayList();
        for (int i : arr) al.add(i);
        Collections.sort(al);
        int idx = 0;
        for (int i : al) arr[idx++] = i;
    }

    static void sort(long[] arr) {
        ArrayList<Long> al = new ArrayList();
        for (long i : arr) al.add(i);
        Collections.sort(al);
        int idx = 0;
        for (long i : al) arr[idx++] = i;
    }

    static void sortDec(int[] arr) {
        ArrayList<Integer> al = new ArrayList();
        for (int i : arr) al.add(i);
        Collections.sort(al, Collections.reverseOrder());
        int idx = 0;
        for (int i : al) arr[idx++] = i;
    }

    static void sortDec(long[] arr) {
        ArrayList<Long> al = new ArrayList();
        for (long i : arr) al.add(i);
        Collections.sort(al, Collections.reverseOrder());
        int idx = 0;
        for (long i : al) arr[idx++] = i;
    }

    static class InputReader {
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
            public boolean isSpaceChar(int ch);
        }

        public int[] nextIntArray(int n) {
            int[] array = new int[n];
            for (int i = 0; i < n; ++i) array[i] = nextInt();
            return array;
        }

        public int[] nextSortedIntArray(int n) {
            int array[] = nextIntArray(n);
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
            long array[] = nextLongArray(n);
            Arrays.sort(array);
            return array;
        }
    }


}
