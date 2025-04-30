import java.util.*;
import java.io.*;

public class Codeforces {
    final static long mod = 1000000007;

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while(t-->0){
           int n=sc.nextInt();
           int m=sc.nextInt();
           int x=sc.nextInt();
           
           Pair a[]=new Pair[n];
           
           for(int i=0;i<n;i++){
               a[i]=new Pair(sc.nextInt(), i+1);
           }
           
           Arrays.sort(a);
           
           int b[]=new int[n+1];
           int k=m;
           
           for(int i=n-1;i>=0;i--){
               b[a[i].y]=k;
               k--;
               if(k==0)
                k=m;
           }
           
           System.out.println("YES");
           for(int i=1;i<=n;i++){
               System.out.print(b[i]+" ");
           }
           System.out.println();
           
        }
    }
    
    static long modulo(long a,long b){
        //Modulo function takes case of modulus work if the remainder comes out to be negative in some case
        long c=a%b;
        return c<0?c+b:c; 
    }
    static class FastReader {

        BufferedReader br;
        StringTokenizer st; // StringTokenizer() is used to read long strings

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

    static class Pair implements Comparable<Pair> {
        public final int x;
        public final int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        
        @Override
		public int compareTo(Pair o) {
			if(this.x>o.x)
				return 1;
			else if(this.x<o.x)
				return -1;
			else {
				if(this.y>o.y)
					return 1;
				else if(this.y<o.y)
					return -1;
				else
					return 0;
			}
		}
    }

    static String reverseString(String str) {
        StringBuilder input = new StringBuilder();
        return input.append(str).reverse().toString();
    }

    static long factorial(int n, int b) {
        if (n == b)
            return 1;

        return n * factorial(n - 1, b);
    }

    static int lcm(int ch, int b) {
        return ch * b / gcd(ch, b);
    }

    static int gcd(int ch, int b) {
        return b == 0 ? ch : gcd(b, ch % b);
    }

    static double ceil(double n, double k) {
        return Math.ceil(n / k);
    }

    static int sqrt(double n) {
        return (int) Math.sqrt(n);
    }

}