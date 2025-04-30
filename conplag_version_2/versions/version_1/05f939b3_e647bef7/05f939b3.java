
//package cf;
import java.io.*;
import java.util.*;
public class D_668 {
    static int p=1000000007;
    static  int dia=Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(java.io.FileDescriptor.out), "ASCII"), 512);
        FastReader sc=new FastReader();
        int t=sc.nextInt();
       StringBuilder sb=new StringBuilder();
        while(t-->0)
        {
            int n=sc.nextInt();
            int a=sc.nextInt();
            int b=sc.nextInt();
            int da=sc.nextInt();
            int db=sc.nextInt();
            dia=Integer.MIN_VALUE;
            int dp[]=new int[(int) n+1];
            List<Integer> adj[]=new ArrayList[n+1];
            for(int i=0;i<=n;i++)
            {
                adj[i]=new ArrayList<>();
            }
            Set<Integer> s=new HashSet<>();
            for(int i=1;i<n;i++)
            {
                int u=sc.nextInt();
                int v=sc.nextInt();
                adj[u].add(v);
                adj[v].add(u);
            }
            dfs(dp,adj,a,-1,0);
           // System.out.println(dia+" "+dp[b]);
            if(2*da>=db||2*da>=dia||da>=dp[b])
                sb.append("Alice\n");
            else
                sb.append("Bob\n");

        }
        System.out.println(sb.toString());
        out.flush();
    }
    public static int dfs(int dp[],List<Integer> adj[],int i,int p,int d)
    {
        dp[i]=d;
        int last_max=0;
        for(int v:adj[i])
        {
            if(p!=v&&dp[v]==0)
            {
                int max=1+dfs(dp,adj,v,i,d+1);
                dia=Math.max(dia,max+last_max);
                last_max=Math.max(last_max,max);
            }
        }
        return last_max;
    }
    public static int binary_Search_upper(int ar[],int x)
    {
        int res=-1;
        int l=0;int r=ar.length-1;
        while(l<=r)
        {
            int mid=(l+r)>>1;
            if(ar[mid]==x)
            {
                res=mid;
                l=mid+1;
            }
            else if(ar[mid]>x)
            {
                r=mid-1;
            }
            else
            {
                l=mid+1;
            }
        }
        return res;
    }
    public static int binary_Search_lower(int ar[],int x)
    {
        int res=-1;
        int l=0;int r=ar.length-1;
        while(l<=r)
        {
            int mid=(l+r)>>1;
            if(ar[mid]==x)
            {
                res=mid;
                r=mid-1;
            }
            else if(ar[mid]>x)
            {
                r=mid-1;
            }
            else
            {
                l=mid+1;
            }
        }
        return res;
    }
    int bit[]=new int[(int)1e6];
    public void update(int n,int val,int i)
    {
        i++;
        while(i<n)
        {
            bit[i]+=val;
            i+=(i)&(-i);
        }

    }
    public long query(int n,int i)
    {
        i++;
        long sum=0;
        while(i>0)
        {
            sum+=bit[i];
            i-=(i)&(-i);
        }
        return sum;
    }


    ///////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////
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
                } catch (IOException e) {
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

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }


}
