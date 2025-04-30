import java.util.*;
import java.io.*;
public class C{
    static class InputReader {

        private final InputStream stream;
        private final byte[] buf = new byte[8192];
        private int curChar, snumChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int snext() {
            if (snumChars == -1)
                throw new InputMismatchException();
            if (curChar >= snumChars) {
                curChar = 0;
                try {
                    snumChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (snumChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public long nextLong() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int[] nextIntArray(int n) {
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }

        public String readString() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public String nextLine() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isEndOfLine(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }

    }
    static class OutputWriter {
		private final PrintWriter writer;
 
		public OutputWriter(OutputStream outputStream) {
			writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
		}
 
		public OutputWriter(Writer writer) {
			this.writer = new PrintWriter(writer);
		}
 
		public void print(Object...objects) {
			for (int i = 0; i < objects.length; i++) {
				if (i != 0)
					writer.print(' ');
				writer.print(objects[i]);
			}
		}
 
		public void printLine(Object...objects) {
			print(objects);
			writer.println();
		}
 
		public void close() {
			writer.close();
		}
 
		public void flush() {
			writer.flush();
		}
 
		}
    static int gcd(int a, int b) 
    { 
        if (a == 0) 
            return b; 
        return gcd(b % a, a); 
    } 
    static int mod = (int)(1e9+7);
    public static long pow(long a,long b)
    {
        long ans = 1;
        while(b> 0)
        {
            if((b & 1)==1){
                ans = (ans*a) % mod; 
            }
            a = (a*a) % mod;
            b = b>>1;
        }
        return ans;
    }
    static void sort(int[] a) {
		ArrayList<Integer> l=new ArrayList<>();
		for (int i:a) l.add(i);
		Collections.sort(l);
		for (int i=0; i<a.length; i++) a[i]=l.get(i);
    }
    static void flip(char[][] arr,int i,int j)
    {
        if(arr[i][j]=='1')
            arr[i][j] = '0';
        else
            arr[i][j] = '1';
    }
    static void add2s(StringBuilder sb,int n,int m)
    {
        sb.append((n) +" " + (m-1) + " "  +(n-1) + " " + (m) + " "  +(n) + " " + (m)+"\n");
        sb.append((n-1) +" " + (m-1) + " "  +(n-1) + " " + (m) + " "  +(n) + " " + (m)+"\n");
    }
    static void add3s(StringBuilder sb,int n,int m)
    {
        sb.append((n) +" " + (m-1) + " "  +(n-1) + " " + (m-1) + " "  +(n) + " " + (m)+"\n");
        sb.append((n-1) +" " + (m-1) + " "  +(n) + " " + (m-1) + " "  +(n-1) + " " + (m)+"\n");
    }
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        int t = in.nextInt();
        while(t-- >0)
        {
            // out.printLine("UAShd");
            int n = in.nextInt(),m = in.nextInt();
            char[][] arr = new char[n][m];
            for(int i=0;i<n;i++)
                arr[i] = in.nextLine().toCharArray();
            // boolean[][] flip = new boolean[n][m];
            int nops = 0;
            StringBuilder res = new StringBuilder();
            //do till row n-1
            for(int i=0;i<n-1;i++)
            {
                for(int j=0;j<m;j++)
                {
                    if(arr[i][j]=='1')
                    {
                        nops++;
                        if(j==m-1)
                        {
                            res.append((i+1) + " " + (j+1) + " " + (i+2) + " " + (j+1) + " " + (i+2) + " " + (j) + "\n");
                            flip(arr,i,j);
                            flip(arr,i+1,j);
                            flip(arr,i+1,j-1);
                        }
                        else
                        {
                            res.append((i+1) + " " + (j+1) + " " + (i+2) + " " + (j+1) + " " + (i+2) + " " + (j+2) + "\n");
                            flip(arr,i,j);
                            flip(arr,i+1,j);
                            flip(arr,i+1,j+1);
                        }
                    }
                }
            }
            // out.printLine(nops);
            int i = n-2;
            for(int j=0;j<m-1;j++)
            {
                char a = arr[i][j],b = arr[i+1][j];
                if(a=='0' && b=='0')
                {
                    continue;
                }
                else if(a=='0' && b=='1')
                {
                    nops++;
                    res.append((i+2) + " " + (j+1) + " " + (i+1) + " " + (j+2) + " " + (i+2) + " " + (j+2) + "\n");
                    flip(arr,i+1,j);
                    flip(arr,i,j+1);
                    flip(arr,i+1,j+1);
                }
                else if(a=='1' && b=='0')
                {
                    nops++;
                    res.append((i+1) + " " + (j+1) + " " + (i+1) + " " + (j+2) + " " + (i+2) + " " + (j+2) + "\n");
                    flip(arr,i,j);
                    flip(arr,i,j+1);
                    flip(arr,i+1,j+1);
                }
                else
                {
                    nops++;
                    res.append((i+2) + " " + (j+1) + " " + (i+1) + " " + (j+1) + " " + (i+2) + " " + (j+2) + "\n");
                    flip(arr,i+1,j);
                    flip(arr,i,j);
                    flip(arr,i+1,j+1);
                }
            }
            // out.printLine(nops);
            char a = arr[n-2][m-1];
            char b = arr[n-1][m-1];
            if(a=='0' && b=='0')
            {

            }
            else if(a=='1' && b=='0')
            {
                nops+=3;
                res.append((n-1) + " " + (m) + " " + (n-1) + " " + (m-1) + " " + (n) + " " + (m-1)+"\n");
                add2s(res,n,m);
            }
            else if(a=='0' && b=='1')
            {
                nops+=3;
                res.append((n) + " " + (m) + " " + (n-1) + " " + (m-1) + " " + (n) + " " + (m-1)+"\n");
                add2s(res,n,m);
            }
            else
            {
                nops+=2;
                add3s(res,n,m);
            }
            // out.printLine("UAShd");
            // for(i=0;i<n;i++)
                // out.printLine(new String(arr[i]));
            // if(nops>0)
                // res.deleteCharAt(res.length()-1);
            out.printLine(nops);
            if(nops>0)
                out.print(res);
        }
        out.flush();
        out.close();
    }
}