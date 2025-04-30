import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class D {
	
	public static void main(String[] args) throws IOException {
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int t = fs.nextInt();
		for (int tc = 0; tc < t; tc++) {
			int n = fs.nextInt();
			int[] a = fs.readArray(n);
			String s = fs.nextLine();
			
			// let all blue to be 1 -> blueCount
			ArrayList<Integer> blues = new ArrayList<Integer>();
			ArrayList<Integer> reds = new ArrayList<Integer>();
			
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == 'B') {
					blues.add(a[i]);
				} else {
					reds.add(a[i]);
				}
			}
			
			Collections.sort(blues);
			Collections.sort(reds);
			
			boolean ok = true;
			
			for (int i = 1; i <= blues.size(); i++) {
				if (blues.get(i - 1) < i) {
					ok = false;
					break;
				}
			}
			
			for (int i = blues.size() + 1; i <= n; i++) {
				if (reds.get(i - blues.size() - 1) > i) {
					ok = false;
					break;
				}
			}
			
			if (ok) {
				out.println("YES");
			} else {
				out.println("NO");
			}
		}
		
		out.close();
	}
	
	static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
        
        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }
        
        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
        
        String nextLine() throws IOException {
        	return br.readLine();
        }
    }
}

