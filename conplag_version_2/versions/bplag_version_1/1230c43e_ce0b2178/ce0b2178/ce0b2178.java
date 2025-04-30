//package com.company;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static boolean[] primecheck = new boolean[1000002];

    public static void main(String[] args) throws IOException {
        OutputStream outputStream = System.out;
        FastReader in = new FastReader();
        PrintWriter out = new PrintWriter(outputStream);
        PROBLEM solver = new PROBLEM();
        int t = 1;
        t = in.nextInt();
        for (int i = 0; i < t; i++) {
            solver.solve(in, out);
        }
        out.close();
    }

    static class PROBLEM {

        public void solve(FastReader in, PrintWriter out) {

            int n = in.nextInt();
            int[] a = in.readArray(n);
            char[] c = in.nextLine().toCharArray();
            int cur = 1;

            ArrayList<Pair> p = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                p.add(new Pair(c[i], a[i]));
            }

            Collections.sort(p);
//            for (int i = 0; i < n; i++) {
//                out.println(p.get(i).x + " " + p.get(i).y);
//            }

            for (int i = 0; i < n; i++) {
                if(p.get(i).x == 'B' && p.get(i).y < i+1){
                    out.println("NO");
                    return;
                }
                if(p.get(i).x == 'R' && p.get(i).y > i+1){
                    out.println("NO");
                    return;
                }
            }

            out.println("YES");

//            int n = in.nextInt(), m = in.nextInt();
//            char[] s = in.nextLine().toCharArray();
//
//            int rl = 0, ud = 0, r = 0 , l = 0, rlf = 0, udf = 0;
//            int lmax = 0, rmax = 0, umax = 0, dmax = 0;
//
//            for (int i = 0; i < s.length; i++) {
//                if(s[i] == 'L'){
//                    if(rlf == 0) rlf = -1;
//                    rl--;
//                    l--;
//                    if(rl == 0) l = 0;
//                    if(rl < 0 && lmax+rmax <= m) lmax = Math.max(Math.abs(l), lmax);
//                }
//                if(s[i] == 'R'){
//                    if(rlf == 0) rlf = 1;
//                    rl++;
//                    r++;
//
//                    if(rl > 0 && lmax+rmax <= m) rmax = Math.max(r, rmax);
//                }
//                if(s[i] == 'U'){
//                    if(udf == 0) udf = 1;
//                    ud++;
//                    r = Math.max(Math.abs(ud), r);
//                    if(ud > 0 && umax+dmax <= n) umax = Math.max(Math.abs(ud), umax);
//                }
//                if(s[i] == 'D'){
//                    if(udf == 0) udf = -1;
//                    ud--;
//                    r = Math.max(Math.abs(ud), r);
//                    if(ud < 0 && umax+dmax <= n) dmax = Math.max(Math.abs(ud), dmax);
//                }
//            }
//
//            int ansc = 0, ansr = 0;
//
//            out.println(rlf + "  lmx = " + lmax + " rmax" + rmax);
//
//            if(rlf == 1) ansc = m-rmax;
//            else if(rlf == -1) ansc = 1+lmax;
//            else ansc = 1;
//
//            if(udf == 1) ansr = 1+umax;
//            else if(udf == -1) ansr = m-dmax;
//            else ansr = 1;
//
//            out.println(ansr + " " + ansc);

        }
    }

    static HashMap<Integer, Integer> initializeMap(int n){
        HashMap<Integer,Integer> hm = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            hm.put(i, 0);
        }
        return hm;
    }

    static boolean isRegular(char[] c){

        Stack<Character> s = new Stack<>();
        for (char value : c) {
            if (s.isEmpty() && value == ')') return false;

            if (value == '(') s.push(value);
            else s.pop();
        }

        return s.isEmpty();
    }

    static ArrayList<ArrayList<Integer>> createAdj(int n, int e){

        FastReader in = new FastReader();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {

            int a = in.nextInt(), b = in.nextInt();
            System.out.println(a);

            adj.get(a).add(b);
            adj.get(b).add(a);
        }


        return adj;
    }

    static int binarySearch(int[] a, int l, int r, int x){
        if(r>=l){
            int mid = l + (r-l)/2;

            if(a[mid] == x) return mid;

            if(a[mid] > x) return binarySearch(a, l, mid-1, x);
            else return binarySearch(a,mid+1, r, x);
        }
        return -1;
    }

    static boolean isPalindromeI(int n){

        int d = 0;
        int y = n;
        while(y>0){
            d++;
            y/=10;
        }

        int[] a = new int[d];
        for (int i = 0; i < d; i++) {
            a[i] = n%10;
            n/=10;
        }

        System.out.println(Arrays.toString(a));
        for (int i = 0; i < d / 2; i++) {
            if(a[i] != a[d-i-1]) return false;
        }
        return true;
    }

    static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    static long lcm(long a, long b)
    {
        return (a / gcd(a, b)) * b;
    }

    static boolean isSquare(double a) {
        boolean isSq = false;
        double b = Math.sqrt(a);
        double c = Math.sqrt(a) - Math.floor(b);

        if (c == 0) isSq = true;

        return isSq;
    }

    static int exponentMod(int A, int B, int C) {

        // Base cases
        if (A == 0)
            return 0;
        if (B == 0)
            return 1;

        // If B is even
        long y;
        if (B % 2 == 0) {
            y = exponentMod(A, B / 2, C);
            y = (y * y) % C;
        }

        // If B is odd
        else {
            y = A % C;
            y = (y * exponentMod(A, B - 1, C) % C) % C;
        }

        return (int) ((y + C) % C);
    }


    static class Pair implements Comparable<Pair>{

        char x;
        int y;

        Pair(char x, int y){
            this.x = x;
            this.y = y;
        }

        public int compareTo(Pair o){
            int ans = Integer.compare(x, o.x);
            if(o.x == x) ans = Integer.compare(y, o.y);

            return ans;
        }
    }

    static class Tuple implements Comparable<Tuple>{

        int x, y, id;

        Tuple(int x, int y, int id){
            this.x = x;
            this.y = y;
            this.id = id;
        }

        public int compareTo(Tuple o){
            int ans = Integer.compare(x, o.x);
            if(o.x == x) ans = Integer.compare(y, o.y);

            return ans;
        }
    }

//    public static class Pair<U extends Comparable<U>, V extends Comparable<V>> implements Comparable<Pair<U, V>> {
//        public U x;
//        public V y;
//
//        public Pair(U x, V y) {
//            this.x = x;
//            this.y = y;
//        }
//
//        public int hashCode() {
//            return (x == null ? 0 : x.hashCode() * 31) + (y == null ? 0 : y.hashCode());
//        }
//
//        public boolean equals(Object o) {
//            if (this == o)
//                return true;
//            if (o == null || getClass() != o.getClass())
//                return false;
//            Pair<U, V> p = (Pair<U, V>) o;
//            return (x == null ? p.x == null : x.equals(p.x)) && (y == null ? p.y == null : y.equals(p.y));
//        }
//
//        public int compareTo(Pair<U, V> b) {
//            int cmpU = x.compareTo(b.x);
//            return cmpU != 0 ? cmpU : y.compareTo(b.y);
//        }
//
//        public int compareToY(Pair<U, V> b) {
//            int cmpU = y.compareTo(b.y);
//            return cmpU != 0 ? cmpU : x.compareTo(b.x);
//        }
//
//        public String toString() {
//            return String.format("(%s, %s)", x.toString(), y.toString());
//        }
//
//    }

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

        char nextChar() {
            return next().charAt(0);
        }

        boolean nextBoolean() {
            return !(nextInt() == 0);
        }
        // boolean nextBoolean(){return Boolean.parseBoolean(next());}

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        public int[] readArray(int size) {
            int[] array = new int[size];
            for (int i = 0; i < size; i++) array[i] = nextInt();
            return array;
        }

    }

    private static int[] mergeSort(int[] array) {

        //array.length replaced with ctr
        int ctr = array.length;
        if (ctr <= 1) {
            return array;
        }

        int midpoint = ctr / 2;

        int[] left = new int[midpoint];
        int[] right;

        if (ctr % 2 == 0) {
            right = new int[midpoint];
        } else {
            right = new int[midpoint + 1];
        }

        for (int i = 0; i < left.length; i++) {
            left[i] = array[i];
        }

        for (int i = 0; i < right.length; i++) {
            right[i] = array[i + midpoint];
        }

        int[] result = new int[array.length];

        left = mergeSort(left);
        right = mergeSort(right);

        result = merge(left, right);

        return result;
    }

    private static int[] merge(int[] left, int[] right) {

        int[] result = new int[left.length + right.length];
        int leftPointer = 0, rightPointer = 0, resultPointer = 0;

        while (leftPointer < left.length || rightPointer < right.length) {

            if (leftPointer < left.length && rightPointer < right.length) {

                if (left[leftPointer] < right[rightPointer]) {
                    result[resultPointer++] = left[leftPointer++];
                } else {
                    result[resultPointer++] = right[rightPointer++];
                }
            } else if (leftPointer < left.length) {
                result[resultPointer++] = left[leftPointer++];
            } else {
                result[resultPointer++] = right[rightPointer++];
            }
        }
        return result;
    }

    public static void Sieve(int n) {

        Arrays.fill(primecheck, true);
        primecheck[0] = false;
        primecheck[1] = false;

        for (int i = 2; i * i < n + 1; i++) {
            if (primecheck[i]) {
                for (int j = i * 2; j < n + 1; j += i) {
                    primecheck[j] = false;
                }
            }
        }
    }
}


