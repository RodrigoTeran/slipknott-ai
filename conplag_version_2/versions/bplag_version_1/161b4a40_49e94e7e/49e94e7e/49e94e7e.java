import java.util.*;
import java.io.*;

public class Main{
    static final Random random=new Random();
    static long mod=1000000007L;
    static HashMap<String,Integer>map=new HashMap<>();

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br=new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st==null || !st.hasMoreTokens()){
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
        long nextLong(){
            return Long.parseLong(next());
        }
        double nextDouble(){
            return Double.parseDouble(next());
        }
        String nextLine(){
            String str="";
            try {
                str=br.readLine().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
        int[] readIntArray(int n){
            int[] res=new int[n];
            for(int i=0;i<n;i++)res[i]=nextInt();
            return res;
        }
    }
    static class FastWriter {
		private final BufferedWriter bw;

		public FastWriter() {
			this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
		}

		public void print(Object object) throws IOException {
			bw.append("" + object);
		}

		public void println(Object object) throws IOException {
			print(object);
			bw.append("\n");
		}

		public void close() throws IOException {
			bw.close();
		}
	}
    public static void main(String[] args) {
        try {
            FastReader in=new FastReader();
            FastWriter out = new FastWriter();
            int testCases=in.nextInt();
            //int testCases=1;
            while(testCases-- > 0){
                solve(in);
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
    public static void solve( FastReader in){
        int n=in.nextInt();
        String s=in.next();
        String t=in.next();
        //int k=in.nextInt();
        //long y=in.nextInt();
        //long n=in.nextLong();
        //int k=in.nextInt();
        //long k=in.nextLong();
        StringBuilder res=new StringBuilder();
        char[] s1=s.toCharArray();
        char[] t1=t.toCharArray();
        int ans=n+2;
        int[] cnt={0,0};
        for(int i=0;i<n;i++){
            if(s1[i]=='0' && t1[i]=='1'){
                cnt[0]++;
            }
            if(s1[i]=='1' && t1[i]=='0'){
                cnt[1]++;
            }
        }
        if(cnt[0]==cnt[1])ans=Math.min(ans,cnt[0]+cnt[1]);
        cnt[0]=cnt[1]=0;
        for(int i=0;i<n;i++){
            if(s1[i]=='0' && t1[i]=='0'){
                cnt[0]++;
            }
            if(s1[i]=='1' && t1[i]=='1'){
                cnt[1]++;
            }
        }
        if(cnt[1]==cnt[0]+1){
            ans=Math.min(ans,cnt[0]+cnt[1]);
        }
        if(ans>n){
            res.append("-1");
        }
        else{
            res.append(""+ans);
        }
        //int ans=x.size()+y.size();
        //res.append(""+"Yes");
        //res.append(""+"");
        System.out.println(res.toString());
    }
    
    static int gcd(int a,int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }

    static void sort(int[] arr)
    {
        
        ArrayList<Integer> ls = new ArrayList<Integer>();
        for(int x: arr)
            ls.add(x);
        Collections.sort(ls);
        for(int i=0; i < arr.length; i++)
            arr[i] = ls.get(i);
    }
    static void reversesort(int[] arr)
    {
        
        ArrayList<Integer> ls = new ArrayList<Integer>();
        for(int x: arr)
            ls.add(x);
        Collections.sort(ls);
        Collections.reverse(ls);
        for(int i=0; i < arr.length; i++)
            arr[i] = ls.get(i);
    }

    static int lcm(int a, int b)
    {
        return (a / gcd(a, b)) * b;
    }

    static void debug(String x){
        System.out.println(x);
    }
    static < E > void print(E res)
    {
        System.out.println(res);
    }
    static String rString(String s){
        StringBuilder sb=new StringBuilder();
        sb.append(s);
        return sb.reverse().toString();
    }
}