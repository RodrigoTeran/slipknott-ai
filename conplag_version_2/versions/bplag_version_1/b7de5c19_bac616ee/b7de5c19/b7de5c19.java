import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class NotAssigning {
	
	static class FastReader {
		
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader() {
        	
            br = new BufferedReader(new InputStreamReader(System.in));
            
        }
 
        String next() {
        	
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
            
        }
 
        int nextInt() {
        	
        	return Integer.parseInt(next());
        	
        }
 
        long nextLong() {
        	
        	return Long.parseLong(next());
        	
        }
        
        double nextFloat() {
        	
        	return Float.parseFloat(next());
        
        }
 
        double nextDouble() {
        	
        	return Double.parseDouble(next());
        	
        }
 
        String nextLine() {
        	
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
            
        }
        
        int[] nextArray(int n) {
        	
        	int[] a = new int[n];
        	for (int i=0; i<n; i++) {
        		a[i] = this.nextInt();
        	}
        	return a;
        	
        }
        
        long[] nextArrayLong(int n) {
        	
        	long[] a = new long[n];
        	for (int i=0; i<n; i++) {
        		a[i] = this.nextLong();
        	}
        	return a;
        	
        }
        
    }
	
	static class Pair {
		
		int a, b;

		public Pair(int a, int b) {
			
			this.a = a;
			this.b = b;
			
		}

	}
	
	static boolean vis[];
	public static void dfs(ArrayList<ArrayList<Pair>> t, int cur, boolean mode, int[] w) {
		vis[cur] = true;
		for (Pair p : t.get(cur)) {
			if (!vis[p.a]) {
				if (mode) {
					w[p.b] = 3;
				}
				else {
					w[p.b] = 2;
				}
				dfs(t, p.a, !mode, w);
			}
		}
	}
	
	public static void solve(int n, int[] u, int[] v) {
		
		ArrayList<ArrayList<Pair>> t = new ArrayList<ArrayList<Pair>>(n);
		for (int i=0; i<n; i++) {
			t.add(new ArrayList<Pair>());
		}
		for (int i=0; i<n-1; i++) {
			t.get(u[i]).add(new Pair(v[i], i));
			t.get(v[i]).add(new Pair(u[i], i));
		}
		int start = 0;
		for (int i=0; i<n; i++) {
			if (t.get(i).size() > 2) {
				System.out.println("-1");
				return;
			}
			if (t.get(i).size() == 1) {
				start = i;
			}
		}
		vis = new boolean[n];
		int[] w = new int[n-1];
		dfs(t, start, false, w);
		StringBuilder ans = new StringBuilder();
		for (int i=0; i<n-1; i++) {
			ans.append(w[i]).append(" ");
		}
		System.out.println(ans);
		
	}

	public static void main(String[] args) {
		
		FastReader in = new FastReader();
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			int[] u = new int[n-1];
			int[] v = new int[n-1];
			for (int i=0; i<n-1; i++) {
				u[i] = in.nextInt()-1;
				v[i] = in.nextInt()-1;
			}
			solve(n, u, v);
		}

	}

}
