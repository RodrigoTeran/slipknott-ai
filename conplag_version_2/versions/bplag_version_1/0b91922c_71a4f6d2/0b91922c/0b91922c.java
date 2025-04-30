
import java.util.*;
import java.lang.*;
import java.io.*;   
import java.math.*;
public class Prac{     
    static class InputReader { 
        private final InputStream stream;
        private final byte[] buf = new byte[8192];
        private int curChar, snumChars;
        public InputReader(InputStream st) {
            this.stream = st;
        } 
        public int read() {
            if (snumChars == -1)
                throw new InputMismatchException();
            if (curChar >= snumChars) {
                curChar = 0;
                try {
                    snumChars = stream.read(buf);
                } 
                catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (snumChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }
        public int ni() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        } 
        public long nl() {
            int c = read();
            while (isSpaceChar(c)) {
            c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        } 
        public int[] nia(int n) {
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = ni();
            }
            return a;
        } 
        public int[] nia1(int n) {
            int a[] = new int[n+1];
            for (int i = 1; i <=n; i++) {
                a[i] = ni();
            }
            return a;
        } 
        public long[] nla(int n) {
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = nl();
            }
            return a;
        } 
        public long[] nla1(int n) {
            long a[] = new long[n+1];
            for (int i = 1; i <= n; i++) {
                a[i] = nl();
            }
            return a;
        } 
        public Long[] nLa(int n) {
            Long a[] = new Long[n];
            for (int i = 0; i < n; i++) {
                a[i] = nl();
            }
            return a;
        } 
        public Long[] nLa1(int n) {
            Long a[] = new Long[n+1];
            for (int i = 1; i <= n; i++) {
                a[i] = nl();
            }
            return a;
        } 
        public Integer[] nIa(int n) {
            Integer a[] = new Integer[n];
            for (int i = 0; i < n; i++) {
                a[i] = ni();
            }
            return a;
        } 
        public Integer[] nIa1(int n) {
            Integer a[] = new Integer[n+1];
            for (int i = 1; i <= n; i++) {
                a[i] = ni();
            }
            return a;
        } 
        public String rs() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                    c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }
        public String nextLine() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndOfLine(c));
            return res.toString();
        } 
        public boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        } 
    }
    public static class Key {
        private final int x, y;
        public Key(int x, int y) {
            this.x = x; this.y = y;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Key)) return false;
            Key key = (Key) o;
            return x == key.x && y == key.y;
        }
        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
    static class Pair{
            int x,y;
            Pair(int a,int b){
                    x=a;y=b;
            }
//            @Override
//            public int compareTo(Pair p) {
//                    if(x==p.x) return y-p.y;
//                    return x-p.x;
//            }
    }
    static void shuffleArray(long temp[]){
        int n = temp.length;
        Random rnd = new Random();
        for(int i=0; i<n; ++i){
            long tmp = temp[i];
            int randomPos = i + rnd.nextInt(n-i);
            temp[i] = temp[randomPos];
            temp[randomPos] = tmp;
        }   
    }
    static int gcd(int a,int b){ return b==0?a:gcd(b,a%b);}
    //static long lcm(long a,long b){return (a/gcd(a,b))*b;}
    static PrintWriter w = new PrintWriter(System.out);
    static long mod1=998244353L,mod=1000000007;
    //static int r[]={0,1,0,-1}, c[]={1,0,-1,0};
    static int[] nextG(int arr[]){
        int n = arr.length;
        Stack<Integer> s = new Stack<>();
        int ng[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            while(!s.isEmpty() && arr[s.peek()] <= arr[i]){
                ng[s.pop()] = i;
            }
            s.add(i);
        }
        while(!s.isEmpty()){
            ng[s.pop()] = n;
        }
        return ng;
    }
    static int[] nextS(int arr[]){
        int n = arr.length;
        Stack<Integer> s = new Stack<>();
        int ns[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                ns[s.pop()] = i;
            }
            s.add(i);
        }
        while(!s.isEmpty()){
            ns[s.pop()] = n;
        }
        return ns;
    }
    static int[] prevG(int arr[]){
        int n = arr.length;
        Stack<Integer> s = new Stack<>();
        int pg[] = new int[n];
        for(int i = n-1 ; i >= 0 ; i--){
            while(!s.isEmpty() && arr[s.peek()] <= arr[i]){
                pg[s.pop()] = i;
            }
            s.add(i);
        }
        while(!s.isEmpty()){
            pg[s.pop()] = -1;
        }
        return pg;
    }
    static int[] prevS(int arr[]){
        int n = arr.length;
        Stack<Integer> s = new Stack<>();
        int ps[] = new int[n];
        for(int i = n-1 ; i >= 0 ; i--){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                ps[s.pop()] = i;
            }
            s.add(i);
        }
        while(!s.isEmpty()){
            ps[s.pop()] = -1;
        }
        return ps;
    }
    public static void main(String [] args){
        InputReader sc=new InputReader(System.in); 
        
        int n = sc.ni();
        int arr [] = sc.nia(n);
        int ng[] = nextG(arr);
        int ns [] = nextS(arr);
        int pg[] = prevG(arr);
        int ps[] = prevS(arr);
        int ans[]=new int[n];
        
        Arrays.fill(ans,10000000);
        ans[n-1] = 0;
        for(int i = n -1 ; i >= 0 ; i --){
            if(ns[i] != n){
                ans[i] = Math.min(ans[i] , ans[ns[i]]+1);
            }
            if(ng[i] != n){
                ans[i] = Math.min(ans[i] , ans[ng[i]]+1);
            }
            if(pg[i] != -1){
                ans[pg[i]] = Math.min(ans[pg[i]] , ans[i]+1);
            }
            if(ps[i] != -1){
                ans[ps[i]] = Math.min(ans[ps[i]] , ans[i]+1);
            }
        }
        
        w.println(ans[0]);
        w.close();
    }
}