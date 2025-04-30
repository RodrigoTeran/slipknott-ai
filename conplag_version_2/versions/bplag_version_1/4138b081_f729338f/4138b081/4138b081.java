import java.io.*;
import java.util.*;
 
public class Contest1627C
{
    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;
        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }
        String next() { // reads in the next string
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }
        public int nextInt() { // reads in the next int
            return Integer.parseInt(next());
        }
        public long nextLong() { // reads in the next long
            return Long.parseLong(next());
        }
        public double nextDouble() { // reads in the next double
            return Double.parseDouble(next());
            }
        }
    static InputReader r = new InputReader(System.in);
    static PrintWriter pw = new PrintWriter(System.out);
    static long mod = 1000000007; static ArrayList<Integer>[] adj; static ArrayList<Integer>[] num; static int[] ans;
    public static void main(String[] args)
    {
    	int t = r.nextInt();
    	while (t > 0)
    	{
    		t--;
    		int n = r.nextInt();
    		adj = new ArrayList[n];
    		num = new ArrayList[n];
    		for (int i = 0; i < n; i ++)
    		{
    			adj[i] = new ArrayList<Integer>();
    			num[i] = new ArrayList<Integer>();
    		}
    		int[] deg = new int[n];
    		boolean flag = false;
    		for (int i = 0; i < n - 1; i ++)
    		{
    			int a = r.nextInt()-1;
    			int b = r.nextInt()-1;
    			adj[a].add(b);
    			adj[b].add(a);
    			num[a].add(i);
    			num[b].add(i);
    			deg[a] ++;
    			deg[b] ++;
    			if (deg[a] > 2 || deg[b] > 2)
    			{
    				flag = true;
    			}
    		}
    		if (flag)
    		{
    			pw.println(-1);
    			continue;
    		}
    		ans = new int[n];
    		for (int i = 0; i < n; i ++)
    		{
    			if (deg[i] == 1)
    			{
    				dfs(i,3,-1);
    			}
    		}
    		for (int i = 0; i < n - 1; i ++)
    		{
    			pw.println(ans[i]);
    		}
    	}
        pw.close();
    }
    static void dfs(int node, int x, int p)
    {
    	for (int j = 0; j < adj[node].size(); j ++)
    	{
    		int i = adj[node].get(j);
    		if (i == p)
    		{
    			continue;
    		}
    		ans[num[node].get(j)] = x;
    		dfs(i,5-x,node);
    	}
    }
}