import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class D {
    static class Pair{
        int val;
        char c;
        Pair(int a,char b){
            this.val=a;
            this.c=b;
        }
    }
    public static void main(String[] args)
    {
        FastScanner sc=new FastScanner();
        int t=sc.nextInt();
        PrintWriter pw=new PrintWriter(System.out);
        while(t-->0) {
            int n=sc.nextInt();
            int[] a=sc.readArray(n);
            char[] s=sc.next().toCharArray();
            boolean ok=true;
            ArrayList<Integer> blues=new ArrayList<>();
            ArrayList<Integer> reds=new ArrayList<>();
            for(int i=0;i<n;i++){
                if(s[i]=='B'){
                    blues.add(a[i]);
                } else {
                    reds.add(a[i]);
                }
            }
            Collections.sort(blues);
            Collections.sort(reds);
            for(int i=0;i<blues.size();i++){
                if(blues.get(i)<(i+1)){
                    ok=false;
                    break;
                }
            }
            int start=blues.size()+1;
            for(int i=0;i<reds.size();i++){
                if(reds.get(i)>(start++)){
                    ok=false;
                    break;
                }
            }
            if(ok){
               pw.println("YES");
            } else {
                pw.println("NO");
            }
        }
        pw.flush();
    }

    static class FastScanner {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer("");
        String next() {
            while (!st.hasMoreTokens())
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
        int[] readArray(int n) {
            int[] a=new int[n];
            for (int i=0; i<n; i++) a[i]=nextInt();
            return a;
        }
        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
