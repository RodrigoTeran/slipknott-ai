import java.io.*;
import java.util.*;


public class C {//Any Class Name
	
	static class Code {
		
		private void solve(InputReader in, OutputWriter out) throws IOException {
			
			ArrayOpn o= new ArrayOpn();
			int t = in.readInt();
			while(t -- > 0) {
			
				int n=in.readInt();
				
				
				int[][] freq= new int[5][n];
				
				for(int i=0; i<n; i++) {
					char s[]= in.readString().toCharArray();
					
					
					for(char e: s) {
						if(e=='a') {
							freq[0][i]++;
						}
						else {
							freq[0][i]--;
						}
						if(e=='b') {
							freq[1][i]++;
						}
						else {
							freq[1][i]--;
						}
						
						if(e=='c') {
							freq[2][i]++;
						}
						else {
							freq[2][i]--;
						}
						if(e=='d') {
							freq[3][i]++;
						}
						else {
							freq[3][i]--;
						}
						if(e=='e') {
							freq[4][i]++;
						}
						else {
							freq[4][i]--;
						}
							
					}
				}
				
				
				for(int i=0; i<5; i++) {
					Arrays.sort(freq[i]);
				}
				
				int ans=0;
				for(int i=0; i<5; i++) {
					int temp=0, count=0;
					for(int j=n-1; j>=0; j--) {
						temp+=freq[i][j];
						if(temp<=0) {
							break;
						}
						count++;
					}
					ans=Math.max(ans, count);
				}
				
				out.printLine(ans);
				
			}
			out.close();
		}
	}
	
	static class ArrayOpn{
		private int[] aI(InputReader in, int n) {
			int A[]= new int[n];
			for(int i=0; i<n; i++) {
				A[i]=in.readInt();
			}
			return A;
		}
		
		static final Random random = new Random();
		
		private void sort(int A[]) {
			int n = A.length;
			for(int i=0; i<n; i++)
			{
				int j = random.nextInt(n),temp = A[j];
				A[j] = A[i];
				A[i] = temp;
			}
			Arrays.sort(A);
//            return A;
		}
		
		private int[][] mI(InputReader in, int n, int m){
			int A[][]= new int[n][m];
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					A[i][j]=in.readInt();
				}
			}
			return A;
		}
		
		private int minEl(int A[]) {
			int min=Integer.MAX_VALUE;
			for(int e: A) {
				min=Math.min(e, min);
			}
			return min;
		}
		private int maxEl(int A[]) {
			int max=Integer.MIN_VALUE;
			for(int e: A) {
				max=Math.max(e, max);
			}
			return max;
		}
		
		private int occurence(int A[], int e) {
			int c=0;
			for(int k: A) {
				if(k==e) {
					c++;
				}
			}
			return c;
		}
		
		public int linears(int A[], int e) {
			
			for(int i=0; i<A.length; i++) {
				if(A[i]==e) {
					return i;
				}
			}
			return -1;
		}
		
		public int binarys(int A[], int e) {
			int low=0, high=A.length-1;
			while(low<=high) {
				int mid=(low+high)/2;
				if(A[mid]==e) {
					return mid;
				}
				else if(A[mid]<e) {
					low=mid+1;
				}
				else {
					high=mid-1;
				}
			}
			return -1;
		}
		
		public void printAr(OutputWriter out, int A[]) {
			for(int e: A) {
				out.print(e+" ");
			}
		}
	}
	
	static class Pair<F, S>{
		private final F first; //first member of pair
		private final S second; //second member of pair
		
		private Pair(F first, S second) {
			this.first = first;
			this.second = second;
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) {
				return true;
			}
			
			if (o == null || getClass() != o.getClass())
				return false;
			
			Pair<? , ?> pair = (Pair<?, ?>) o;
			if(!first.equals(pair.first))
				return false;
			return second.equals(pair.second);
		}
		
		@Override
		public int hashCode() {
			return 31 * first.hashCode() + second.hashCode();
		}
		
		@Override
		public String toString() {
			return "(" + first +", "+ second +")";
		}
		
		
		public static <F,S> Pair<F,S> of(F a, S b) {
			return new Pair<>(a,b);
		}
		public F getFirst() {
			return first;
		}
		
		public S getSecond() {
			return second;
		}
	}
	
	// Comparator for using in Sorting On integers
	static class PairCompare implements Comparator<Pair<Integer, Integer>> {
		@Override
		public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
			int diff = Integer.compare(p1.first, p2.first);
			if(diff == 0) {
				return Integer.compare(p1.second, p2.second);
			}
			else return diff;
		}
	}
	
	
	
	public static void main(String[] args) throws IOException {
		//initialize
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		OutputWriter out = new OutputWriter(outputStream);
		Code solver = new Code();
		solver.solve(in, out);
		out.flush();
		out.close();
	}
	
	
	static class InputReader {
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;
		private SpaceCharFilter filter;
		
		private InputReader(InputStream stream) {
			this.stream = stream;
		}
		
		private int read() {
			if (numChars == -1)
				throw new InputMismatchException();
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}
		
		private String readString() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				if (Character.isValidCodePoint(c))
					res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}
		
		private int readInt() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}
		
		private long readLong() {
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
		
		private double readDouble() {
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
					return res * Math.pow(10, readInt());
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
						return res * Math.pow(10, readInt());
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
		
		private boolean isSpaceChar(int c) {
			if (filter != null)
				return filter.isSpaceChar(c);
			return isWhitespace(c);
		}
		
		public String next() {
			return readString();
		}
		
		
		private static boolean isWhitespace(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}
		
		private char readCharacter() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			return (char) c;
		}
		
		public interface SpaceCharFilter {
			boolean isSpaceChar(int ch);
		}
	}
	
	static class OutputWriter {
		private final PrintWriter writer;
		
		private OutputWriter(OutputStream outputStream) {
			writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
					outputStream)));
		}
		
		private OutputWriter(Writer writer) {
			this.writer = new PrintWriter(writer);
		}
		
		private void print(Object... objects) {
			for (int i = 0; i < objects.length; i++) {
				if (i != 0) {
					writer.print(' ');
				}
				writer.print(objects[i]);
			}
			writer.flush();
		}
		
		private void printLine(Object... objects) {
			print(objects);
			writer.println();
			writer.flush();
		}
		
		private void printLine(int i) {
			writer.println(i);
		}
		
		
		private void close() {
			writer.close();
		}
		
		private void flush() {
			writer.flush();
		}
		
		
	}
	
	static class IOUtils {
		
		private static int[] readIntArray(InputReader in, int size) {
			int[] array = new int[size];
			for (int i = 0; i < size; i++)
				array[i] = in.readInt();
			return array;
		}
		
		private static long[] readLongArray(InputReader in, int size) {
			long[] array = new long[size];
			for (int i = 0; i < size; i++)
				array[i] = in.readLong();
			return array;
		}
		
		private static char[] readCharArray(InputReader in, int size) {
			char[] array = new char[size];
			for (int i = 0; i < size; i++)
				array[i] = in.readCharacter();
			return array;
		}
		
		private static char[][] readTable(InputReader in, int rowCount,
				int columnCount) {
			char[][] table = new char[rowCount][];
			for (int i = 0; i < rowCount; i++)
				table[i] = readCharArray(in, columnCount);
			return table;
		}
		
	}
	
	static class ArrayUtils {
		
		private static void fill(int[][] array, int value) {
			for (int[] row : array)
				Arrays.fill(row, value);
		}
		
	}
	
	static class MiscUtils {
		private static final int[] DX4 = {1, 0, -1, 0};
		private static final int[] DY4 = {0, -1, 0, 1};
		
		private static boolean isValidCell(int row, int column, int rowCount,
				int columnCount) {
			return row >= 0 && row < rowCount && column >= 0
					&& column < columnCount;
		}
		
	}
}