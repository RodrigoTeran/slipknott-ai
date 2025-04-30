
import java.math.BigInteger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class mathcomp {
	public static int gcd(int a,int b)
	{
		BigInteger b1=BigInteger.valueOf(a);
		BigInteger b2=BigInteger.valueOf(b);
		BigInteger gcd=b1.gcd(b2);
		return gcd.intValue();
	}
	public static long gcd(long a,long b)
	{
		BigInteger b1=BigInteger.valueOf(a);
		BigInteger b2=BigInteger.valueOf(b);
		BigInteger gcd=b1.gcd(b2);
		return gcd.longValue();
	}
	public static void main(String []args)
	{
		FastScanner fs=new FastScanner();
		int T=fs.nextInt();
		PrintWriter out=new PrintWriter(System.out);
		for(int tt=0;tt<T;tt++)
		{
			int n=fs.nextInt();
			int aStart=fs.nextInt()-1;
			int bStart=fs.nextInt()-1;
			int adist=fs.nextInt();int bdist=fs.nextInt();
			Node[] nodes=new Node[n];
			for(int i=0;i<n;i++) nodes[i]=new Node();
			for(int i=1;i<n;i++)
			{
				int a=fs.nextInt()-1,b=fs.nextInt()-1;
				nodes[a].adj.add(nodes[b]);nodes[b].adj.add(nodes[a]);
			}
			bfs(nodes,nodes[bStart]);
			if(nodes[aStart].dist<=adist)
			{
				out.println("Alice");
				continue;
			}
			Node farthest=farthest(nodes);
			bfs(nodes,farthest);
			farthest=farthest(nodes);
			int diam=farthest.dist;
			if(2*adist>=diam)
			{
				out.println("Alice");
				continue;
			}
			if(bdist>2*adist)
			{
				out.println("Bob");
			}
			else
			{
				out.println("Alice");
			}
		}
		out.close();
	}
	static Node farthest(Node[] nodes)
	{
		Node ans=nodes[0];
		for(Node nn:nodes) if(nn.dist>ans.dist) ans=nn;
		return ans;
	}
	static void bfs(Node[] nodes,Node from)
	{
		for(Node nn:nodes) nn.dist=-1;
		ArrayDeque<Node> bfs=new ArrayDeque<>();
		bfs.add(from);
		from.dist=0;
		while(!bfs.isEmpty())
		{
			Node nn=bfs.remove();
			for(Node adj:nn.adj)
			{
				if(adj.dist==-1)
				{
					adj.dist=nn.dist+1;
					bfs.add(adj);
				}
			}
		}
	}
	static class Node{
		ArrayList<Node> adj=new ArrayList<>();
		int dist=-1;
	}
	static class FastScanner
	{
		BufferedReader  br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
		String next()
		{
			while(!st.hasMoreTokens())
			{
				try {
					st=new StringTokenizer(br.readLine());
				} catch(IOException e)
				{
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		int nextInt()
		{
			return Integer.parseInt(next());
		}
		int[] readArray(int n)
		{
			int[] a=new int[n];
			for(int i=0;i<n;i++) a[i]=nextInt();
			return a;
		}
		long nextLong()
		{
			return Long.parseLong(next());
		}
	}
}
