import java.io.*;
import java.util.*;
 
public class cf {
 
    public static void main(String[] args){
 
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while(t-- > 0){
 			
 			int n=sc.nextInt();
            int arr[]=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            int ans[]=new int[n];
            if(n%2==0){
                for(int i=0;i<n;i=i+2){
                    ans[i]=-arr[i+1];
                    ans[i+1]=arr[i];
                }
            }
            else{
                if(arr[0]+arr[1]!=0){
                    ans[0]=-arr[2];
                    ans[1]=-arr[2];
                    ans[2]=arr[0]+arr[1];
                }
                else{
                    if(arr[1]+arr[2]!=0){
                        ans[1]=-arr[0];
                        ans[2]=-arr[0];
                        ans[0]=arr[1]+arr[2];
                    }
                    else{
                        ans[0]=-arr[1];
                        ans[2]=-arr[1];
                        ans[1]=arr[0]+arr[2];
                    }
                }
                for(int i=3;i<n;i=i+2){
                    ans[i]=-arr[i+1];
                    ans[i+1]=arr[i];
                }
            }
            for(int j=0;j<n;j++){
                System.out.print(ans[j]+" ");
            }
            System.out.println();
            

            
            

            

            
           
 			

        }	        	
        	
 			
    }
 
    
    
    
 
}

//////////////////////////////////////////////////////////////
// LCM AND GCD
/*
	public static int gcd(int a,int b){
		if(b == 0){
			return a;
		}
		return gcd(b,a%b);
	}
 
	public static int lcm(int a,int b){
		 return (a / gcd(a, b)) * b;
	}*/


///////////////////////////////////////////////////////////////////////////////////

//Iterator



/*Iterator iterator = object.iterator();
 
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }*/
///////////////////////////////////////////////////////////////////////////////////


class FastScanner
{
    //I don't understand how this works lmao
    private int BS = 1 << 16;
    private char NC = (char) 0;
    private byte[] buf = new byte[BS];
    private int bId = 0, size = 0;
    private char c = NC;
    private double cnt = 1;
    private BufferedInputStream in;
 
    public FastScanner() {
        in = new BufferedInputStream(System.in, BS);
    }
 
    public FastScanner(String s) {
        try {
            in = new BufferedInputStream(new FileInputStream(new File(s)), BS);
        } catch (Exception e) {
            in = new BufferedInputStream(System.in, BS);
        }
    }
 
    public char getChar() {
        while (bId == size) {
            try {
                size = in.read(buf);
            } catch (Exception e) {
                return NC;
            }
            if (size == -1) return NC;
            bId = 0;
        }
        return (char) buf[bId++];
    }
 
    public int nextInt() {
        return (int) nextLong();
    }
 
    public int[] nextInts(int N) {
        int[] res = new int[N];
        for (int i = 0; i < N; i++) {
            res[i] = (int) nextLong();
        }
        return res;
    }
 
    public long[] nextLongs(int N) {
        long[] res = new long[N];
        for (int i = 0; i < N; i++) {
            res[i] = nextLong();
        }
        return res;
    }
 
    public long nextLong() {
        cnt = 1;
        boolean neg = false;
        if (c == NC) c = getChar();
        for (; (c < '0' || c > '9'); c = getChar()) {
            if (c == '-') neg = true;
        }
        long res = 0;
        for (; c >= '0' && c <= '9'; c = getChar()) {
            res = (res << 3) + (res << 1) + c - '0';
            cnt *= 10;
        }
        return neg ? -res : res;
    }
 
    public double nextDouble() {
        double cur = nextLong();
        return c != '.' ? cur : cur + nextLong() / cnt;
    }
 
    public double[] nextDoubles(int N) {
        double[] res = new double[N];
        for (int i = 0; i < N; i++) {
            res[i] = nextDouble();
        }
        return res;
    }
 
    public String next() {
        StringBuilder res = new StringBuilder();
        while (c <= 32) c = getChar();
        while (c > 32) {
            res.append(c);
            c = getChar();
        }
        return res.toString();
    }
 
    public String nextLine() {
        StringBuilder res = new StringBuilder();
        while (c <= 32) c = getChar();
        while (c != '\n') {
            res.append(c);
            c = getChar();
        }
        return res.toString();
    }
 
    public boolean hasNext() {
        if (c > 32) return true;
        while (true) {
            c = getChar();
            if (c == NC) return false;
            else if (c > 32) return true;
        }
    }
}

