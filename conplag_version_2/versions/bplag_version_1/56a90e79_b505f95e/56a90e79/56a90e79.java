import java.util.*;
import java.io.*;

public class E {
    public static void main(String[] args) throws IOException {
        setIO();

        int INF = 2000000000;

        int Q = ni();
        while (Q-- > 0) {
        	rl();
        	st = nl();
        	int N = ni(st), K = ni(st);
        	int[] P = nia(K);
        	int[] T = nia(K);
        	int[] A = new int[N];
        	Arrays.fill(A, INF);
        	for (int i = 0; i < K; i++) {
        		A[P[i]-1] = T[i];
			}

        	int[] R = new int[N];
        	R[N-1] = A[N-1];
        	for (int i = N-2; i >= 0; i--) {
				R[i] = Math.min(R[i+1] + 1, A[i]);
			}

        	int[] L = new int[N];
        	L[0] = A[0];
        	for (int i = 1; i < N; i++) {
        		L[i] = Math.min(L[i-1] + 1, A[i]);
			}

        	for (int i = 0; i < N; i++) {
        		out.print(Math.min(L[i], R[i]) + " ");
			}
        	out.println();
		}

        f.close();
        out.close();
    }

    static BufferedReader f;
    static PrintWriter out;
    static StringTokenizer st;

    static String rl() throws IOException {
        return f.readLine();
    }

    static int ni(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

    static long nlg(StringTokenizer st) {
        return Long.parseLong(st.nextToken());
    }

    static int ni() throws IOException {
        return Integer.parseInt(rl());
    }

    static long nlg() throws IOException {
        return Long.parseLong(rl());
    }

    static StringTokenizer nl() throws IOException {
        return new StringTokenizer(rl());
    }

    static int[] nia(int N) throws IOException {
        StringTokenizer st = nl();
        int[] A = new int[N];
        for (int i = 0; i < N; i++)
            A[i] = ni(st);
        return A;
    }

    static void setIn(String s) throws IOException {
        f = new BufferedReader(new FileReader(s));
    }

    static void setOut(String s) throws IOException {
        out = new PrintWriter(new FileWriter(s));
    }

    static void setIn() {
        f = new BufferedReader(new InputStreamReader(System.in));
    }

    static void setOut() {
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    }

    static void setIO(String s) throws IOException {
        setIn(s + ".in");
        setOut(s + ".out");
    }

    static void setTextIO(String s) throws IOException {
        setIn(s + ".txt");
        setOut(s + "_out.txt");
    }

    static void setIO() {
        setIn();
        setOut();
    }
}