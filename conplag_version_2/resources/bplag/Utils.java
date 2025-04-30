
import java.util.*;
import java.io.*;


public class Utils {
    public static void main(String[] args) {

    }
}


class SegmentTree {
    int size;
    private long[] max;
    private long[] min;
    private long[] sum;

    private long[] lazy;

    public SegmentTree(long[] array){
        size = array.length;
        max=new long[array.length*4];
        min=new long[array.length*4];
        sum=new long[array.length*4];
        lazy=new long[array.length*4];
        buildTree(array,1,0,size-1);
    }

    private void buildTree(long[] array, int position, int front, int end){
        //Basis case for returning the elements itself
        if(front==end){
            max[position]=array[front];
            min[position]=array[front];
            sum[position]=array[front];
            return;
        }
        //Building trees by dividing into two subtrees
        buildTree(array, position*2,front,(front+end)/2);
        buildTree(array, position*2+1,(front+end)/2+1,end);

        recalc(position,front,end);
    }

    private void recalc(int position, int front, int end) {
        max[position]=Math.max(getMax(position*2),getMax(position*2+1) );
        min[position]=Math.min(getMin(position*2), getMin(position*2+1));
        sum[position]=getSum(position*2,front,(front+end)/2)+getSum(position*2+1,(front+end)/2+1,end);
    }

    private long getMax(int position){
        return max[position]+lazy[position];
    }

    private long getMin(int position){
        return min[position]+lazy[position];
    }

    private long getSum(int position,int front,int end){
        return sum[position]+lazy[position]*(end-front+1);
    }

    public long queryMax(int queryFront, int queryEnd) {
        return queryMax(1,0,size-1,queryFront,queryEnd);
    }

    private long queryMax(int position,int front,int end, int queryFront, int queryEnd){
        //Case for entirely inclusive
        if(front>=queryFront&&queryEnd>=end){
            return getMax(position);
        }
        //Case for entirely exclusive
        if(end<queryFront||queryEnd<front){
            return Integer.MIN_VALUE;
        }
        propagate(position,front,end);
        long leftAns=queryMax(position*2,front,(front+end)/2,queryFront,queryEnd);
        long rightAns=queryMax(position*2+1,(front+end)/2+1,end,queryFront,queryEnd);
        return Math.max(leftAns, rightAns);
    }

    public long queryMin(int queryFront, int queryEnd) {
        return queryMin(1,0,size-1,queryFront,queryEnd);
    }

    private long queryMin(int position,int front,int end, int queryFront, int queryEnd){
        //Case for entirely inclusive
        if(front>=queryFront&&queryEnd>=end){
            return getMin(position);
        }
        //Case for entirely exclusive
        if(end<queryFront||queryEnd<front){
            return Integer.MAX_VALUE;
        }
        propagate(position,front,end);
        long leftAns=queryMin(position*2,front,(front+end)/2,queryFront,queryEnd);
        long rightAns=queryMin(position*2+1,(front+end)/2+1,end,queryFront,queryEnd);
        return Math.min(leftAns, rightAns);
    }
    public long querySum(int queryFront, int queryEnd) {
        return querySum(1,0,size-1,queryFront,queryEnd);
    }

    private long querySum(int position,int front,int end, int queryFront, int queryEnd){
        //Case for entirely inclusive
        if(front>=queryFront&&queryEnd>=end){
            return getSum(position,front,end);
        }
        //Case for entirely exclusive
        if(end<queryFront||queryEnd<front){
            return 0;
        }
        propagate(position,front,end);
        long leftAns=querySum(position*2,front,(front+end)/2,queryFront,queryEnd);
        long rightAns=querySum(position*2+1,(front+end)/2+1,end,queryFront,queryEnd);
        return leftAns+rightAns;
    }


    private void propagate(int position,int front, int end){
        lazy[position*2]+=lazy[position];
        lazy[position*2+1]+=lazy[position];
        max[position]=getMax(position);
        min[position]=getMin(position);
        sum[position]=getSum(position,front,end);
        lazy[position]=0;
        //Set the propagation to 0 so that it will not propagate the value again and again
    }

    public void update(int updateFront, int updateEnd, long value){
        update(1,0,size-1,updateFront,updateEnd,value);
    }

    private void update(int position, int front, int end, int updateFront,int updateEnd,long value){
        //Case for entirely inclusive
        if(front>=updateFront&&updateEnd>=end){
            lazy[position]+=value;
            return;
        }
        //Case for entirely exclusive
        if(end<updateFront||updateEnd<front){
            return;
        }
        propagate(position,front,end);
        update(position*2,front,(front+end)/2,updateFront,updateEnd,value);
        update(position*2+1,(front+end)/2+1,end,updateFront,updateEnd,value);
        recalc(position,front,end);
    }
}


class JS {
    public JS() {
    }

    public JS(String s) {
    }

    public JS(InputStream stream) {
    }

    public JS(OutputStream outputStream) {
    }

    private char getChar() {
        return 'a';
    }

    public String input() {
        return null;
    }

    public boolean hasNext() {
        return false;
    }

    public String next() {
        return null;
    }

    public String nextToken() {
        return null;
    }

    public int nextInt() {
        return 0;
    }

    public long nextLong() {
        return 0;
    }

    public double nextDouble() {
        return 0.0;
    }

    public float nextFloat() {
        return Float.parseFloat(next());
    }

    public byte nextByte() {
        return (byte) 0;
    }

    public long[] nextLongs(int N) {
        return new long[0];
    }

    public double[] nextDoubles(int N) {
        return new double[0];
    }

    public String nextLine() {
        return null;
    }

    public int ni() {
        return 0;
    }

    public int[] ni(int n) {
        return new int[0];
    }

    public String readLine() {
        return null;
    }

    public int[] nextInts(int N) {
        return new int[0];
    }

    public int nint() {
        return 0;
    }

    public int in() {
        return 0;
    }

    public int ri() {
        return 0;
    }

    public int[] ri(int n) {
        return new int[0];
    }

    public int[] rai(int n) {
        return new int[0];
    }

    public int[] rai() {
        return new int[0];
    }

    public double nd() {
        return 0.0;
    }

    public long nl() {
        return 0;
    }

    public int[] nia(int n) {
        return new int[0];
    }

    public long[] nla(int n) {
        return new long[0];
    }

    public int i() {
        return 0;
    }

    public int[] i(int n) {
        return new int[0];
    }

    public long l() {
        return 0;
    }

    public long[] l(int n) {
        return new long[0];
    }

    public double d() {
        return 0.0;
    }

    public int[] nextIntArray(int n) {
        return new int[0];
    }

    public long[] nextLongArray(int n) {
        return new long[0];
    }

    public String[] nextStringArray(int n) {
        return new String[0];
    }

    public long[] lreadArray(int n) {
        return new long[0];
    }

    public long[] readArrayLong(int n) {
        return new long[0];
    }

    public int readInt() {
        return 0;
    }

    public String read() {
        return null;
    }

    public String readString() {
        return null;
    }

    public int[] readArray(int n) {
        return new int[0];
    }

    public long[] readLongArray(int n) {
        return new long[0];
    }

    public long[] arrLong(int n) {
        return new long[0];
    }

    public int[][] graph(int N, int[][] edges) {
        return new int[0][];
    }

    public int[] intArray(int N, int mod) {
        return new int[0];
    }

    public long[] longArray(int N, long mod) {
        return new long[0];
    }

    public JS write(byte b) {
        return null;
    }

    public JS write(char c) {
        return null;
    }

    public JS write(char[] s) {
        return null;
    }

    public JS write(String s) {
        return null;
    }

    public JS write(int x) {
        return null;
    }

    public void print(Object s) {
    }

    public void print(Object... objects) {
    }

    public void println(Object s) {
    }

    public void println(int i) {
    }

    public void println() {
    }

    public void printLine(Object... objects) {
    }

    public void printArray(int[] a) {
    }
    
    public void printlnArray(int[] a) {
    }
    
    public void printArray(long[] a) {
    }
    
    public void printlnArray(long[] a) {
    }

    public void p(Object o) {
    }

    public void p() {
    }

    public void ps(Object o) {
    }

    public void ps() {
    }

    public void pl(Object o) {
    }

    public void pl() {
    }

    public void pn() {
    }

    public void pn(Object o) {
    }

    public void pln() {
    }

    public void pln (Object o) {
    }

    public void printLine() {
    }

    public void printLine(Object o) {
    }

    public void flush() {
    }

    public void close() {
    }

    public void exit() {
    }

    public boolean isSpace(int c) { return false; }

    public double readDouble() { return 0.0; }

    public int[] na(int n) {
        return new int[n];
    }

    public long[] nal(int n) {
        return new long[n];
    }

    public void iIA(int arr[]){
    }

    static int[] ari(int n)throws IOException
    {
        return new int[n];
    }
    static int[][] ari(int n,int m)throws IOException
    {
        return new int[n][m];
    }
    static long[] arl(int n)throws IOException
    {
        return new long[n];
    }
    static long[][] arl(int n,int m)throws IOException
    {
        return new long[n][m];
    }
    static String[] ars(int n)throws IOException
    {
        return new String[n];
    }
    static double[] ard(int n)throws IOException
    {
        return new double[n];
    }
    static double[][] ard(int n,int m)throws IOException
    {
        return new double[n][m];
    }
    static char[] arc(int n)throws IOException
    {
        return new char[n];
    }
    static char[][] arc(int n,int m)throws IOException
    {
        return new char[n][m];
    }
}
    

class CP {
    public CP() {
    }

    public CP(String s) {
    }

    public CP(InputStream stream) {
    }

    public CP(OutputStream outputStream) {
    }

    private char getChar() {
        return 'a';
    }

    public String input() {
        return null;
    }

    public boolean hasNext() {
        return false;
    }

    public String next() {
        return null;
    }

    public String nextToken() {
        return null;
    }

    public int nextInt() {
        return 0;
    }

    public long nextLong() {
        return 0;
    }

    public double nextDouble() {
        return 0.0;
    }

    public float nextFloat() {
        return Float.parseFloat(next());
    }

    public byte nextByte() {
        return (byte) 0;
    }

    public long[] nextLongs(int N) {
        return new long[0];
    }

    public double[] nextDoubles(int N) {
        return new double[0];
    }

    public String nextLine() {
        return null;
    }

    public int ni() {
        return 0;
    }

    public int[] ni(int n) {
        return new int[0];
    }

    public String readLine() {
        return null;
    }

    public int[] nextInts(int N) {
        return new int[0];
    }

    public int nint() {
        return 0;
    }

    public int in() {
        return 0;
    }

    public int ri() {
        return 0;
    }

    public int[] ri(int n) {
        return new int[0];
    }

    public int[] rai(int n) {
        return new int[0];
    }

    public int[] rai() {
        return new int[0];
    }

    public double nd() {
        return 0.0;
    }

    public long nl() {
        return 0;
    }

    public int[] nia(int n) {
        return new int[0];
    }

    public long[] nla(int n) {
        return new long[0];
    }

    public int i() {
        return 0;
    }

    public int[] i(int n) {
        return new int[0];
    }

    public long l() {
        return 0;
    }

    public long[] l(int n) {
        return new long[0];
    }

    public double d() {
        return 0.0;
    }

    public int[] nextIntArray(int n) {
        return new int[0];
    }

    public long[] nextLongArray(int n) {
        return new long[0];
    }

    public String[] nextStringArray(int n) {
        return new String[0];
    }

    public long[] lreadArray(int n) {
        return new long[0];
    }

    public long[] readArrayLong(int n) {
        return new long[0];
    }

    public int readInt() {
        return 0;
    }

    public String read() {
        return null;
    }

    public String readString() {
        return null;
    }

    public int[] readArray(int n) {
        return new int[0];
    }

    public long[] readLongArray(int n) {
        return new long[0];
    }

    public long[] arrLong(int n) {
        return new long[0];
    }

    public int[][] graph(int N, int[][] edges) {
        return new int[0][];
    }

    public int[] intArray(int N, int mod) {
        return new int[0];
    }

    public long[] longArray(int N, long mod) {
        return new long[0];
    }

    public CP write(byte b) {
        return null;
    }

    public CP write(char c) {
        return null;
    }

    public CP write(char[] s) {
        return null;
    }

    public CP write(String s) {
        return null;
    }

    public CP write(int x) {
        return null;
    }

    public void print(Object s) {
    }

    public void print(Object... objects) {
    }

    public void println(Object s) {
    }

    public void println(int i) {
    }

    public void println() {
    }

    public void printLine(Object... objects) {
    }

    public void printArray(int[] a) {
    }
    
    public void printlnArray(int[] a) {
    }
    
    public void printArray(long[] a) {
    }
    
    public void printlnArray(long[] a) {
    }

    public void p(Object o) {
    }

    public void p() {
    }

    public void ps(Object o) {
    }

    public void ps() {
    }

    public void pl(Object o) {
    }

    public void pl() {
    }

    public void pn() {
    }

    public void pn(Object o) {
    }

    public void pln() {
    }

    public void pln (Object o) {
    }

    public void printLine() {
    }

    public void printLine(Object o) {
    }

    public void flush() {
    }

    public void close() {
    }

    public void exit() {
    }

    public boolean isSpace(int c) { return false; }

    public double readDouble() { return 0.0; }

    public int[] na(int n) {
        return new int[n];
    }

    public long[] nal(int n) {
        return new long[n];
    }

    public void iIA(int arr[]){
    }

    static int[] ari(int n)throws IOException
    {
        return new int[n];
    }
    static int[][] ari(int n,int m)throws IOException
    {
        return new int[n][m];
    }
    static long[] arl(int n)throws IOException
    {
        return new long[n];
    }
    static long[][] arl(int n,int m)throws IOException
    {
        return new long[n][m];
    }
    static String[] ars(int n)throws IOException
    {
        return new String[n];
    }
    static double[] ard(int n)throws IOException
    {
        return new double[n];
    }
    static double[][] ard(int n,int m)throws IOException
    {
        return new double[n][m];
    }
    static char[] arc(int n)throws IOException
    {
        return new char[n];
    }
    static char[][] arc(int n,int m)throws IOException
    {
        return new char[n][m];
    }
}
    

class Print {
    public Print() {
    }

    public Print(String s) {
    }

    public Print(InputStream stream) {
    }

    public Print(OutputStream outputStream) {
    }

    private char getChar() {
        return 'a';
    }

    public String input() {
        return null;
    }

    public boolean hasNext() {
        return false;
    }

    public String next() {
        return null;
    }

    public String nextToken() {
        return null;
    }

    public int nextInt() {
        return 0;
    }

    public long nextLong() {
        return 0;
    }

    public double nextDouble() {
        return 0.0;
    }

    public float nextFloat() {
        return Float.parseFloat(next());
    }

    public byte nextByte() {
        return (byte) 0;
    }

    public long[] nextLongs(int N) {
        return new long[0];
    }

    public double[] nextDoubles(int N) {
        return new double[0];
    }

    public String nextLine() {
        return null;
    }

    public int ni() {
        return 0;
    }

    public int[] ni(int n) {
        return new int[0];
    }

    public String readLine() {
        return null;
    }

    public int[] nextInts(int N) {
        return new int[0];
    }

    public int nint() {
        return 0;
    }

    public int in() {
        return 0;
    }

    public int ri() {
        return 0;
    }

    public int[] ri(int n) {
        return new int[0];
    }

    public int[] rai(int n) {
        return new int[0];
    }

    public int[] rai() {
        return new int[0];
    }

    public double nd() {
        return 0.0;
    }

    public long nl() {
        return 0;
    }

    public int[] nia(int n) {
        return new int[0];
    }

    public long[] nla(int n) {
        return new long[0];
    }

    public int i() {
        return 0;
    }

    public int[] i(int n) {
        return new int[0];
    }

    public long l() {
        return 0;
    }

    public long[] l(int n) {
        return new long[0];
    }

    public double d() {
        return 0.0;
    }

    public int[] nextIntArray(int n) {
        return new int[0];
    }

    public long[] nextLongArray(int n) {
        return new long[0];
    }

    public String[] nextStringArray(int n) {
        return new String[0];
    }

    public long[] lreadArray(int n) {
        return new long[0];
    }

    public long[] readArrayLong(int n) {
        return new long[0];
    }

    public int readInt() {
        return 0;
    }

    public String read() {
        return null;
    }

    public String readString() {
        return null;
    }

    public int[] readArray(int n) {
        return new int[0];
    }

    public long[] readLongArray(int n) {
        return new long[0];
    }

    public long[] arrLong(int n) {
        return new long[0];
    }

    public int[][] graph(int N, int[][] edges) {
        return new int[0][];
    }

    public int[] intArray(int N, int mod) {
        return new int[0];
    }

    public long[] longArray(int N, long mod) {
        return new long[0];
    }

    public Print write(byte b) {
        return null;
    }

    public Print write(char c) {
        return null;
    }

    public Print write(char[] s) {
        return null;
    }

    public Print write(String s) {
        return null;
    }

    public Print write(int x) {
        return null;
    }

    public void print(Object s) {
    }

    public void print(Object... objects) {
    }

    public void println(Object s) {
    }

    public void println(int i) {
    }

    public void println() {
    }

    public void printLine(Object... objects) {
    }

    public void printArray(int[] a) {
    }
    
    public void printlnArray(int[] a) {
    }
    
    public void printArray(long[] a) {
    }
    
    public void printlnArray(long[] a) {
    }

    public void p(Object o) {
    }

    public void p() {
    }

    public void ps(Object o) {
    }

    public void ps() {
    }

    public void pl(Object o) {
    }

    public void pl() {
    }

    public void pn() {
    }

    public void pn(Object o) {
    }

    public void pln() {
    }

    public void pln (Object o) {
    }

    public void printLine() {
    }

    public void printLine(Object o) {
    }

    public void flush() {
    }

    public void close() {
    }

    public void exit() {
    }

    public boolean isSpace(int c) { return false; }

    public double readDouble() { return 0.0; }

    public int[] na(int n) {
        return new int[n];
    }

    public long[] nal(int n) {
        return new long[n];
    }

    public void iIA(int arr[]){
    }

    static int[] ari(int n)throws IOException
    {
        return new int[n];
    }
    static int[][] ari(int n,int m)throws IOException
    {
        return new int[n][m];
    }
    static long[] arl(int n)throws IOException
    {
        return new long[n];
    }
    static long[][] arl(int n,int m)throws IOException
    {
        return new long[n][m];
    }
    static String[] ars(int n)throws IOException
    {
        return new String[n];
    }
    static double[] ard(int n)throws IOException
    {
        return new double[n];
    }
    static double[][] ard(int n,int m)throws IOException
    {
        return new double[n][m];
    }
    static char[] arc(int n)throws IOException
    {
        return new char[n];
    }
    static char[][] arc(int n,int m)throws IOException
    {
        return new char[n][m];
    }
}
    

class FastIO {
    public FastIO() {
    }

    public FastIO(String s) {
    }

    public FastIO(InputStream stream) {
    }

    public FastIO(OutputStream outputStream) {
    }

    private char getChar() {
        return 'a';
    }

    public String input() {
        return null;
    }

    public boolean hasNext() {
        return false;
    }

    public String next() {
        return null;
    }

    public String nextToken() {
        return null;
    }

    public int nextInt() {
        return 0;
    }

    public long nextLong() {
        return 0;
    }

    public double nextDouble() {
        return 0.0;
    }

    public float nextFloat() {
        return Float.parseFloat(next());
    }

    public byte nextByte() {
        return (byte) 0;
    }

    public long[] nextLongs(int N) {
        return new long[0];
    }

    public double[] nextDoubles(int N) {
        return new double[0];
    }

    public String nextLine() {
        return null;
    }

    public int ni() {
        return 0;
    }

    public int[] ni(int n) {
        return new int[0];
    }

    public String readLine() {
        return null;
    }

    public int[] nextInts(int N) {
        return new int[0];
    }

    public int nint() {
        return 0;
    }

    public int in() {
        return 0;
    }

    public int ri() {
        return 0;
    }

    public int[] ri(int n) {
        return new int[0];
    }

    public int[] rai(int n) {
        return new int[0];
    }

    public int[] rai() {
        return new int[0];
    }

    public double nd() {
        return 0.0;
    }

    public long nl() {
        return 0;
    }

    public int[] nia(int n) {
        return new int[0];
    }

    public long[] nla(int n) {
        return new long[0];
    }

    public int i() {
        return 0;
    }

    public int[] i(int n) {
        return new int[0];
    }

    public long l() {
        return 0;
    }

    public long[] l(int n) {
        return new long[0];
    }

    public double d() {
        return 0.0;
    }

    public int[] nextIntArray(int n) {
        return new int[0];
    }

    public long[] nextLongArray(int n) {
        return new long[0];
    }

    public String[] nextStringArray(int n) {
        return new String[0];
    }

    public long[] lreadArray(int n) {
        return new long[0];
    }

    public long[] readArrayLong(int n) {
        return new long[0];
    }

    public int readInt() {
        return 0;
    }

    public String read() {
        return null;
    }

    public String readString() {
        return null;
    }

    public int[] readArray(int n) {
        return new int[0];
    }

    public long[] readLongArray(int n) {
        return new long[0];
    }

    public long[] arrLong(int n) {
        return new long[0];
    }

    public int[][] graph(int N, int[][] edges) {
        return new int[0][];
    }

    public int[] intArray(int N, int mod) {
        return new int[0];
    }

    public long[] longArray(int N, long mod) {
        return new long[0];
    }

    public FastIO write(byte b) {
        return null;
    }

    public FastIO write(char c) {
        return null;
    }

    public FastIO write(char[] s) {
        return null;
    }

    public FastIO write(String s) {
        return null;
    }

    public FastIO write(int x) {
        return null;
    }

    public void print(Object s) {
    }

    public void print(Object... objects) {
    }

    public void println(Object s) {
    }

    public void println(int i) {
    }

    public void println() {
    }

    public void printLine(Object... objects) {
    }

    public void printArray(int[] a) {
    }
    
    public void printlnArray(int[] a) {
    }
    
    public void printArray(long[] a) {
    }
    
    public void printlnArray(long[] a) {
    }

    public void p(Object o) {
    }

    public void p() {
    }

    public void ps(Object o) {
    }

    public void ps() {
    }

    public void pl(Object o) {
    }

    public void pl() {
    }

    public void pn() {
    }

    public void pn(Object o) {
    }

    public void pln() {
    }

    public void pln (Object o) {
    }

    public void printLine() {
    }

    public void printLine(Object o) {
    }

    public void flush() {
    }

    public void close() {
    }

    public void exit() {
    }

    public boolean isSpace(int c) { return false; }

    public double readDouble() { return 0.0; }

    public int[] na(int n) {
        return new int[n];
    }

    public long[] nal(int n) {
        return new long[n];
    }

    public void iIA(int arr[]){
    }

    static int[] ari(int n)throws IOException
    {
        return new int[n];
    }
    static int[][] ari(int n,int m)throws IOException
    {
        return new int[n][m];
    }
    static long[] arl(int n)throws IOException
    {
        return new long[n];
    }
    static long[][] arl(int n,int m)throws IOException
    {
        return new long[n][m];
    }
    static String[] ars(int n)throws IOException
    {
        return new String[n];
    }
    static double[] ard(int n)throws IOException
    {
        return new double[n];
    }
    static double[][] ard(int n,int m)throws IOException
    {
        return new double[n][m];
    }
    static char[] arc(int n)throws IOException
    {
        return new char[n];
    }
    static char[][] arc(int n,int m)throws IOException
    {
        return new char[n][m];
    }
}
    

class IO {
    public IO() {
    }

    public IO(String s) {
    }

    public IO(InputStream stream) {
    }

    public IO(OutputStream outputStream) {
    }

    private char getChar() {
        return 'a';
    }

    public String input() {
        return null;
    }

    public boolean hasNext() {
        return false;
    }

    public String next() {
        return null;
    }

    public String nextToken() {
        return null;
    }

    public int nextInt() {
        return 0;
    }

    public long nextLong() {
        return 0;
    }

    public double nextDouble() {
        return 0.0;
    }

    public float nextFloat() {
        return Float.parseFloat(next());
    }

    public byte nextByte() {
        return (byte) 0;
    }

    public long[] nextLongs(int N) {
        return new long[0];
    }

    public double[] nextDoubles(int N) {
        return new double[0];
    }

    public String nextLine() {
        return null;
    }

    public int ni() {
        return 0;
    }

    public int[] ni(int n) {
        return new int[0];
    }

    public String readLine() {
        return null;
    }

    public int[] nextInts(int N) {
        return new int[0];
    }

    public int nint() {
        return 0;
    }

    public int in() {
        return 0;
    }

    public int ri() {
        return 0;
    }

    public int[] ri(int n) {
        return new int[0];
    }

    public int[] rai(int n) {
        return new int[0];
    }

    public int[] rai() {
        return new int[0];
    }

    public double nd() {
        return 0.0;
    }

    public long nl() {
        return 0;
    }

    public int[] nia(int n) {
        return new int[0];
    }

    public long[] nla(int n) {
        return new long[0];
    }

    public int i() {
        return 0;
    }

    public int[] i(int n) {
        return new int[0];
    }

    public long l() {
        return 0;
    }

    public long[] l(int n) {
        return new long[0];
    }

    public double d() {
        return 0.0;
    }

    public int[] nextIntArray(int n) {
        return new int[0];
    }

    public long[] nextLongArray(int n) {
        return new long[0];
    }

    public String[] nextStringArray(int n) {
        return new String[0];
    }

    public long[] lreadArray(int n) {
        return new long[0];
    }

    public long[] readArrayLong(int n) {
        return new long[0];
    }

    public int readInt() {
        return 0;
    }

    public String read() {
        return null;
    }

    public String readString() {
        return null;
    }

    public int[] readArray(int n) {
        return new int[0];
    }

    public long[] readLongArray(int n) {
        return new long[0];
    }

    public long[] arrLong(int n) {
        return new long[0];
    }

    public int[][] graph(int N, int[][] edges) {
        return new int[0][];
    }

    public int[] intArray(int N, int mod) {
        return new int[0];
    }

    public long[] longArray(int N, long mod) {
        return new long[0];
    }

    public IO write(byte b) {
        return null;
    }

    public IO write(char c) {
        return null;
    }

    public IO write(char[] s) {
        return null;
    }

    public IO write(String s) {
        return null;
    }

    public IO write(int x) {
        return null;
    }

    public void print(Object s) {
    }

    public void print(Object... objects) {
    }

    public void println(Object s) {
    }

    public void println(int i) {
    }

    public void println() {
    }

    public void printLine(Object... objects) {
    }

    public void printArray(int[] a) {
    }
    
    public void printlnArray(int[] a) {
    }
    
    public void printArray(long[] a) {
    }
    
    public void printlnArray(long[] a) {
    }

    public void p(Object o) {
    }

    public void p() {
    }

    public void ps(Object o) {
    }

    public void ps() {
    }

    public void pl(Object o) {
    }

    public void pl() {
    }

    public void pn() {
    }

    public void pn(Object o) {
    }

    public void pln() {
    }

    public void pln (Object o) {
    }

    public void printLine() {
    }

    public void printLine(Object o) {
    }

    public void flush() {
    }

    public void close() {
    }

    public void exit() {
    }

    public boolean isSpace(int c) { return false; }

    public double readDouble() { return 0.0; }

    public int[] na(int n) {
        return new int[n];
    }

    public long[] nal(int n) {
        return new long[n];
    }

    public void iIA(int arr[]){
    }

    static int[] ari(int n)throws IOException
    {
        return new int[n];
    }
    static int[][] ari(int n,int m)throws IOException
    {
        return new int[n][m];
    }
    static long[] arl(int n)throws IOException
    {
        return new long[n];
    }
    static long[][] arl(int n,int m)throws IOException
    {
        return new long[n][m];
    }
    static String[] ars(int n)throws IOException
    {
        return new String[n];
    }
    static double[] ard(int n)throws IOException
    {
        return new double[n];
    }
    static double[][] ard(int n,int m)throws IOException
    {
        return new double[n][m];
    }
    static char[] arc(int n)throws IOException
    {
        return new char[n];
    }
    static char[][] arc(int n,int m)throws IOException
    {
        return new char[n][m];
    }
}
    

class Input {
    public Input() {
    }

    public Input(String s) {
    }

    public Input(InputStream stream) {
    }

    public Input(OutputStream outputStream) {
    }

    private char getChar() {
        return 'a';
    }

    public String input() {
        return null;
    }

    public boolean hasNext() {
        return false;
    }

    public String next() {
        return null;
    }

    public String nextToken() {
        return null;
    }

    public int nextInt() {
        return 0;
    }

    public long nextLong() {
        return 0;
    }

    public double nextDouble() {
        return 0.0;
    }

    public float nextFloat() {
        return Float.parseFloat(next());
    }

    public byte nextByte() {
        return (byte) 0;
    }

    public long[] nextLongs(int N) {
        return new long[0];
    }

    public double[] nextDoubles(int N) {
        return new double[0];
    }

    public String nextLine() {
        return null;
    }

    public int ni() {
        return 0;
    }

    public int[] ni(int n) {
        return new int[0];
    }

    public String readLine() {
        return null;
    }

    public int[] nextInts(int N) {
        return new int[0];
    }

    public int nint() {
        return 0;
    }

    public int in() {
        return 0;
    }

    public int ri() {
        return 0;
    }

    public int[] ri(int n) {
        return new int[0];
    }

    public int[] rai(int n) {
        return new int[0];
    }

    public int[] rai() {
        return new int[0];
    }

    public double nd() {
        return 0.0;
    }

    public long nl() {
        return 0;
    }

    public int[] nia(int n) {
        return new int[0];
    }

    public long[] nla(int n) {
        return new long[0];
    }

    public int i() {
        return 0;
    }

    public int[] i(int n) {
        return new int[0];
    }

    public long l() {
        return 0;
    }

    public long[] l(int n) {
        return new long[0];
    }

    public double d() {
        return 0.0;
    }

    public int[] nextIntArray(int n) {
        return new int[0];
    }

    public long[] nextLongArray(int n) {
        return new long[0];
    }

    public String[] nextStringArray(int n) {
        return new String[0];
    }

    public long[] lreadArray(int n) {
        return new long[0];
    }

    public long[] readArrayLong(int n) {
        return new long[0];
    }

    public int readInt() {
        return 0;
    }

    public String read() {
        return null;
    }

    public String readString() {
        return null;
    }

    public int[] readArray(int n) {
        return new int[0];
    }

    public long[] readLongArray(int n) {
        return new long[0];
    }

    public long[] arrLong(int n) {
        return new long[0];
    }

    public int[][] graph(int N, int[][] edges) {
        return new int[0][];
    }

    public int[] intArray(int N, int mod) {
        return new int[0];
    }

    public long[] longArray(int N, long mod) {
        return new long[0];
    }

    public Input write(byte b) {
        return null;
    }

    public Input write(char c) {
        return null;
    }

    public Input write(char[] s) {
        return null;
    }

    public Input write(String s) {
        return null;
    }

    public Input write(int x) {
        return null;
    }

    public void print(Object s) {
    }

    public void print(Object... objects) {
    }

    public void println(Object s) {
    }

    public void println(int i) {
    }

    public void println() {
    }

    public void printLine(Object... objects) {
    }

    public void printArray(int[] a) {
    }
    
    public void printlnArray(int[] a) {
    }
    
    public void printArray(long[] a) {
    }
    
    public void printlnArray(long[] a) {
    }

    public void p(Object o) {
    }

    public void p() {
    }

    public void ps(Object o) {
    }

    public void ps() {
    }

    public void pl(Object o) {
    }

    public void pl() {
    }

    public void pn() {
    }

    public void pn(Object o) {
    }

    public void pln() {
    }

    public void pln (Object o) {
    }

    public void printLine() {
    }

    public void printLine(Object o) {
    }

    public void flush() {
    }

    public void close() {
    }

    public void exit() {
    }

    public boolean isSpace(int c) { return false; }

    public double readDouble() { return 0.0; }

    public int[] na(int n) {
        return new int[n];
    }

    public long[] nal(int n) {
        return new long[n];
    }

    public void iIA(int arr[]){
    }

    static int[] ari(int n)throws IOException
    {
        return new int[n];
    }
    static int[][] ari(int n,int m)throws IOException
    {
        return new int[n][m];
    }
    static long[] arl(int n)throws IOException
    {
        return new long[n];
    }
    static long[][] arl(int n,int m)throws IOException
    {
        return new long[n][m];
    }
    static String[] ars(int n)throws IOException
    {
        return new String[n];
    }
    static double[] ard(int n)throws IOException
    {
        return new double[n];
    }
    static double[][] ard(int n,int m)throws IOException
    {
        return new double[n][m];
    }
    static char[] arc(int n)throws IOException
    {
        return new char[n];
    }
    static char[][] arc(int n,int m)throws IOException
    {
        return new char[n][m];
    }
}
    

class Output {
    public Output() {
    }

    public Output(String s) {
    }

    public Output(InputStream stream) {
    }

    public Output(OutputStream outputStream) {
    }

    private char getChar() {
        return 'a';
    }

    public String input() {
        return null;
    }

    public boolean hasNext() {
        return false;
    }

    public String next() {
        return null;
    }

    public String nextToken() {
        return null;
    }

    public int nextInt() {
        return 0;
    }

    public long nextLong() {
        return 0;
    }

    public double nextDouble() {
        return 0.0;
    }

    public float nextFloat() {
        return Float.parseFloat(next());
    }

    public byte nextByte() {
        return (byte) 0;
    }

    public long[] nextLongs(int N) {
        return new long[0];
    }

    public double[] nextDoubles(int N) {
        return new double[0];
    }

    public String nextLine() {
        return null;
    }

    public int ni() {
        return 0;
    }

    public int[] ni(int n) {
        return new int[0];
    }

    public String readLine() {
        return null;
    }

    public int[] nextInts(int N) {
        return new int[0];
    }

    public int nint() {
        return 0;
    }

    public int in() {
        return 0;
    }

    public int ri() {
        return 0;
    }

    public int[] ri(int n) {
        return new int[0];
    }

    public int[] rai(int n) {
        return new int[0];
    }

    public int[] rai() {
        return new int[0];
    }

    public double nd() {
        return 0.0;
    }

    public long nl() {
        return 0;
    }

    public int[] nia(int n) {
        return new int[0];
    }

    public long[] nla(int n) {
        return new long[0];
    }

    public int i() {
        return 0;
    }

    public int[] i(int n) {
        return new int[0];
    }

    public long l() {
        return 0;
    }

    public long[] l(int n) {
        return new long[0];
    }

    public double d() {
        return 0.0;
    }

    public int[] nextIntArray(int n) {
        return new int[0];
    }

    public long[] nextLongArray(int n) {
        return new long[0];
    }

    public String[] nextStringArray(int n) {
        return new String[0];
    }

    public long[] lreadArray(int n) {
        return new long[0];
    }

    public long[] readArrayLong(int n) {
        return new long[0];
    }

    public int readInt() {
        return 0;
    }

    public String read() {
        return null;
    }

    public String readString() {
        return null;
    }

    public int[] readArray(int n) {
        return new int[0];
    }

    public long[] readLongArray(int n) {
        return new long[0];
    }

    public long[] arrLong(int n) {
        return new long[0];
    }

    public int[][] graph(int N, int[][] edges) {
        return new int[0][];
    }

    public int[] intArray(int N, int mod) {
        return new int[0];
    }

    public long[] longArray(int N, long mod) {
        return new long[0];
    }

    public Output write(byte b) {
        return null;
    }

    public Output write(char c) {
        return null;
    }

    public Output write(char[] s) {
        return null;
    }

    public Output write(String s) {
        return null;
    }

    public Output write(int x) {
        return null;
    }

    public void print(Object s) {
    }

    public void print(Object... objects) {
    }

    public void println(Object s) {
    }

    public void println(int i) {
    }

    public void println() {
    }

    public void printLine(Object... objects) {
    }

    public void printArray(int[] a) {
    }
    
    public void printlnArray(int[] a) {
    }
    
    public void printArray(long[] a) {
    }
    
    public void printlnArray(long[] a) {
    }

    public void p(Object o) {
    }

    public void p() {
    }

    public void ps(Object o) {
    }

    public void ps() {
    }

    public void pl(Object o) {
    }

    public void pl() {
    }

    public void pn() {
    }

    public void pn(Object o) {
    }

    public void pln() {
    }

    public void pln (Object o) {
    }

    public void printLine() {
    }

    public void printLine(Object o) {
    }

    public void flush() {
    }

    public void close() {
    }

    public void exit() {
    }

    public boolean isSpace(int c) { return false; }

    public double readDouble() { return 0.0; }

    public int[] na(int n) {
        return new int[n];
    }

    public long[] nal(int n) {
        return new long[n];
    }

    public void iIA(int arr[]){
    }

    static int[] ari(int n)throws IOException
    {
        return new int[n];
    }
    static int[][] ari(int n,int m)throws IOException
    {
        return new int[n][m];
    }
    static long[] arl(int n)throws IOException
    {
        return new long[n];
    }
    static long[][] arl(int n,int m)throws IOException
    {
        return new long[n][m];
    }
    static String[] ars(int n)throws IOException
    {
        return new String[n];
    }
    static double[] ard(int n)throws IOException
    {
        return new double[n];
    }
    static double[][] ard(int n,int m)throws IOException
    {
        return new double[n][m];
    }
    static char[] arc(int n)throws IOException
    {
        return new char[n];
    }
    static char[][] arc(int n,int m)throws IOException
    {
        return new char[n][m];
    }
}
    

class FastInput {
    public FastInput() {
    }

    public FastInput(String s) {
    }

    public FastInput(InputStream stream) {
    }

    public FastInput(OutputStream outputStream) {
    }

    private char getChar() {
        return 'a';
    }

    public String input() {
        return null;
    }

    public boolean hasNext() {
        return false;
    }

    public String next() {
        return null;
    }

    public String nextToken() {
        return null;
    }

    public int nextInt() {
        return 0;
    }

    public long nextLong() {
        return 0;
    }

    public double nextDouble() {
        return 0.0;
    }

    public float nextFloat() {
        return Float.parseFloat(next());
    }

    public byte nextByte() {
        return (byte) 0;
    }

    public long[] nextLongs(int N) {
        return new long[0];
    }

    public double[] nextDoubles(int N) {
        return new double[0];
    }

    public String nextLine() {
        return null;
    }

    public int ni() {
        return 0;
    }

    public int[] ni(int n) {
        return new int[0];
    }

    public String readLine() {
        return null;
    }

    public int[] nextInts(int N) {
        return new int[0];
    }

    public int nint() {
        return 0;
    }

    public int in() {
        return 0;
    }

    public int ri() {
        return 0;
    }

    public int[] ri(int n) {
        return new int[0];
    }

    public int[] rai(int n) {
        return new int[0];
    }

    public int[] rai() {
        return new int[0];
    }

    public double nd() {
        return 0.0;
    }

    public long nl() {
        return 0;
    }

    public int[] nia(int n) {
        return new int[0];
    }

    public long[] nla(int n) {
        return new long[0];
    }

    public int i() {
        return 0;
    }

    public int[] i(int n) {
        return new int[0];
    }

    public long l() {
        return 0;
    }

    public long[] l(int n) {
        return new long[0];
    }

    public double d() {
        return 0.0;
    }

    public int[] nextIntArray(int n) {
        return new int[0];
    }

    public long[] nextLongArray(int n) {
        return new long[0];
    }

    public String[] nextStringArray(int n) {
        return new String[0];
    }

    public long[] lreadArray(int n) {
        return new long[0];
    }

    public long[] readArrayLong(int n) {
        return new long[0];
    }

    public int readInt() {
        return 0;
    }

    public String read() {
        return null;
    }

    public String readString() {
        return null;
    }

    public int[] readArray(int n) {
        return new int[0];
    }

    public long[] readLongArray(int n) {
        return new long[0];
    }

    public long[] arrLong(int n) {
        return new long[0];
    }

    public int[][] graph(int N, int[][] edges) {
        return new int[0][];
    }

    public int[] intArray(int N, int mod) {
        return new int[0];
    }

    public long[] longArray(int N, long mod) {
        return new long[0];
    }

    public FastInput write(byte b) {
        return null;
    }

    public FastInput write(char c) {
        return null;
    }

    public FastInput write(char[] s) {
        return null;
    }

    public FastInput write(String s) {
        return null;
    }

    public FastInput write(int x) {
        return null;
    }

    public void print(Object s) {
    }

    public void print(Object... objects) {
    }

    public void println(Object s) {
    }

    public void println(int i) {
    }

    public void println() {
    }

    public void printLine(Object... objects) {
    }

    public void printArray(int[] a) {
    }
    
    public void printlnArray(int[] a) {
    }
    
    public void printArray(long[] a) {
    }
    
    public void printlnArray(long[] a) {
    }

    public void p(Object o) {
    }

    public void p() {
    }

    public void ps(Object o) {
    }

    public void ps() {
    }

    public void pl(Object o) {
    }

    public void pl() {
    }

    public void pn() {
    }

    public void pn(Object o) {
    }

    public void pln() {
    }

    public void pln (Object o) {
    }

    public void printLine() {
    }

    public void printLine(Object o) {
    }

    public void flush() {
    }

    public void close() {
    }

    public void exit() {
    }

    public boolean isSpace(int c) { return false; }

    public double readDouble() { return 0.0; }

    public int[] na(int n) {
        return new int[n];
    }

    public long[] nal(int n) {
        return new long[n];
    }

    public void iIA(int arr[]){
    }

    static int[] ari(int n)throws IOException
    {
        return new int[n];
    }
    static int[][] ari(int n,int m)throws IOException
    {
        return new int[n][m];
    }
    static long[] arl(int n)throws IOException
    {
        return new long[n];
    }
    static long[][] arl(int n,int m)throws IOException
    {
        return new long[n][m];
    }
    static String[] ars(int n)throws IOException
    {
        return new String[n];
    }
    static double[] ard(int n)throws IOException
    {
        return new double[n];
    }
    static double[][] ard(int n,int m)throws IOException
    {
        return new double[n][m];
    }
    static char[] arc(int n)throws IOException
    {
        return new char[n];
    }
    static char[][] arc(int n,int m)throws IOException
    {
        return new char[n][m];
    }
}
    

class FastOutput {
    public FastOutput() {
    }

    public FastOutput(String s) {
    }

    public FastOutput(InputStream stream) {
    }

    public FastOutput(OutputStream outputStream) {
    }

    private char getChar() {
        return 'a';
    }

    public String input() {
        return null;
    }

    public boolean hasNext() {
        return false;
    }

    public String next() {
        return null;
    }

    public String nextToken() {
        return null;
    }

    public int nextInt() {
        return 0;
    }

    public long nextLong() {
        return 0;
    }

    public double nextDouble() {
        return 0.0;
    }

    public float nextFloat() {
        return Float.parseFloat(next());
    }

    public byte nextByte() {
        return (byte) 0;
    }

    public long[] nextLongs(int N) {
        return new long[0];
    }

    public double[] nextDoubles(int N) {
        return new double[0];
    }

    public String nextLine() {
        return null;
    }

    public int ni() {
        return 0;
    }

    public int[] ni(int n) {
        return new int[0];
    }

    public String readLine() {
        return null;
    }

    public int[] nextInts(int N) {
        return new int[0];
    }

    public int nint() {
        return 0;
    }

    public int in() {
        return 0;
    }

    public int ri() {
        return 0;
    }

    public int[] ri(int n) {
        return new int[0];
    }

    public int[] rai(int n) {
        return new int[0];
    }

    public int[] rai() {
        return new int[0];
    }

    public double nd() {
        return 0.0;
    }

    public long nl() {
        return 0;
    }

    public int[] nia(int n) {
        return new int[0];
    }

    public long[] nla(int n) {
        return new long[0];
    }

    public int i() {
        return 0;
    }

    public int[] i(int n) {
        return new int[0];
    }

    public long l() {
        return 0;
    }

    public long[] l(int n) {
        return new long[0];
    }

    public double d() {
        return 0.0;
    }

    public int[] nextIntArray(int n) {
        return new int[0];
    }

    public long[] nextLongArray(int n) {
        return new long[0];
    }

    public String[] nextStringArray(int n) {
        return new String[0];
    }

    public long[] lreadArray(int n) {
        return new long[0];
    }

    public long[] readArrayLong(int n) {
        return new long[0];
    }

    public int readInt() {
        return 0;
    }

    public String read() {
        return null;
    }

    public String readString() {
        return null;
    }

    public int[] readArray(int n) {
        return new int[0];
    }

    public long[] readLongArray(int n) {
        return new long[0];
    }

    public long[] arrLong(int n) {
        return new long[0];
    }

    public int[][] graph(int N, int[][] edges) {
        return new int[0][];
    }

    public int[] intArray(int N, int mod) {
        return new int[0];
    }

    public long[] longArray(int N, long mod) {
        return new long[0];
    }

    public FastOutput write(byte b) {
        return null;
    }

    public FastOutput write(char c) {
        return null;
    }

    public FastOutput write(char[] s) {
        return null;
    }

    public FastOutput write(String s) {
        return null;
    }

    public FastOutput write(int x) {
        return null;
    }

    public void print(Object s) {
    }

    public void print(Object... objects) {
    }

    public void println(Object s) {
    }

    public void println(int i) {
    }

    public void println() {
    }

    public void printLine(Object... objects) {
    }

    public void printArray(int[] a) {
    }
    
    public void printlnArray(int[] a) {
    }
    
    public void printArray(long[] a) {
    }
    
    public void printlnArray(long[] a) {
    }

    public void p(Object o) {
    }

    public void p() {
    }

    public void ps(Object o) {
    }

    public void ps() {
    }

    public void pl(Object o) {
    }

    public void pl() {
    }

    public void pn() {
    }

    public void pn(Object o) {
    }

    public void pln() {
    }

    public void pln (Object o) {
    }

    public void printLine() {
    }

    public void printLine(Object o) {
    }

    public void flush() {
    }

    public void close() {
    }

    public void exit() {
    }

    public boolean isSpace(int c) { return false; }

    public double readDouble() { return 0.0; }

    public int[] na(int n) {
        return new int[n];
    }

    public long[] nal(int n) {
        return new long[n];
    }

    public void iIA(int arr[]){
    }

    static int[] ari(int n)throws IOException
    {
        return new int[n];
    }
    static int[][] ari(int n,int m)throws IOException
    {
        return new int[n][m];
    }
    static long[] arl(int n)throws IOException
    {
        return new long[n];
    }
    static long[][] arl(int n,int m)throws IOException
    {
        return new long[n][m];
    }
    static String[] ars(int n)throws IOException
    {
        return new String[n];
    }
    static double[] ard(int n)throws IOException
    {
        return new double[n];
    }
    static double[][] ard(int n,int m)throws IOException
    {
        return new double[n][m];
    }
    static char[] arc(int n)throws IOException
    {
        return new char[n];
    }
    static char[][] arc(int n,int m)throws IOException
    {
        return new char[n][m];
    }
}
    

class InputReader {
    public InputReader() {
    }

    public InputReader(String s) {
    }

    public InputReader(InputStream stream) {
    }

    public InputReader(OutputStream outputStream) {
    }

    private char getChar() {
        return 'a';
    }

    public String input() {
        return null;
    }

    public boolean hasNext() {
        return false;
    }

    public String next() {
        return null;
    }

    public String nextToken() {
        return null;
    }

    public int nextInt() {
        return 0;
    }

    public long nextLong() {
        return 0;
    }

    public double nextDouble() {
        return 0.0;
    }

    public float nextFloat() {
        return Float.parseFloat(next());
    }

    public byte nextByte() {
        return (byte) 0;
    }

    public long[] nextLongs(int N) {
        return new long[0];
    }

    public double[] nextDoubles(int N) {
        return new double[0];
    }

    public String nextLine() {
        return null;
    }

    public int ni() {
        return 0;
    }

    public int[] ni(int n) {
        return new int[0];
    }

    public String readLine() {
        return null;
    }

    public int[] nextInts(int N) {
        return new int[0];
    }

    public int nint() {
        return 0;
    }

    public int in() {
        return 0;
    }

    public int ri() {
        return 0;
    }

    public int[] ri(int n) {
        return new int[0];
    }

    public int[] rai(int n) {
        return new int[0];
    }

    public int[] rai() {
        return new int[0];
    }

    public double nd() {
        return 0.0;
    }

    public long nl() {
        return 0;
    }

    public int[] nia(int n) {
        return new int[0];
    }

    public long[] nla(int n) {
        return new long[0];
    }

    public int i() {
        return 0;
    }

    public int[] i(int n) {
        return new int[0];
    }

    public long l() {
        return 0;
    }

    public long[] l(int n) {
        return new long[0];
    }

    public double d() {
        return 0.0;
    }

    public int[] nextIntArray(int n) {
        return new int[0];
    }

    public long[] nextLongArray(int n) {
        return new long[0];
    }

    public String[] nextStringArray(int n) {
        return new String[0];
    }

    public long[] lreadArray(int n) {
        return new long[0];
    }

    public long[] readArrayLong(int n) {
        return new long[0];
    }

    public int readInt() {
        return 0;
    }

    public String read() {
        return null;
    }

    public String readString() {
        return null;
    }

    public int[] readArray(int n) {
        return new int[0];
    }

    public long[] readLongArray(int n) {
        return new long[0];
    }

    public long[] arrLong(int n) {
        return new long[0];
    }

    public int[][] graph(int N, int[][] edges) {
        return new int[0][];
    }

    public int[] intArray(int N, int mod) {
        return new int[0];
    }

    public long[] longArray(int N, long mod) {
        return new long[0];
    }

    public InputReader write(byte b) {
        return null;
    }

    public InputReader write(char c) {
        return null;
    }

    public InputReader write(char[] s) {
        return null;
    }

    public InputReader write(String s) {
        return null;
    }

    public InputReader write(int x) {
        return null;
    }

    public void print(Object s) {
    }

    public void print(Object... objects) {
    }

    public void println(Object s) {
    }

    public void println(int i) {
    }

    public void println() {
    }

    public void printLine(Object... objects) {
    }

    public void printArray(int[] a) {
    }
    
    public void printlnArray(int[] a) {
    }
    
    public void printArray(long[] a) {
    }
    
    public void printlnArray(long[] a) {
    }

    public void p(Object o) {
    }

    public void p() {
    }

    public void ps(Object o) {
    }

    public void ps() {
    }

    public void pl(Object o) {
    }

    public void pl() {
    }

    public void pn() {
    }

    public void pn(Object o) {
    }

    public void pln() {
    }

    public void pln (Object o) {
    }

    public void printLine() {
    }

    public void printLine(Object o) {
    }

    public void flush() {
    }

    public void close() {
    }

    public void exit() {
    }

    public boolean isSpace(int c) { return false; }

    public double readDouble() { return 0.0; }

    public int[] na(int n) {
        return new int[n];
    }

    public long[] nal(int n) {
        return new long[n];
    }

    public void iIA(int arr[]){
    }

    static int[] ari(int n)throws IOException
    {
        return new int[n];
    }
    static int[][] ari(int n,int m)throws IOException
    {
        return new int[n][m];
    }
    static long[] arl(int n)throws IOException
    {
        return new long[n];
    }
    static long[][] arl(int n,int m)throws IOException
    {
        return new long[n][m];
    }
    static String[] ars(int n)throws IOException
    {
        return new String[n];
    }
    static double[] ard(int n)throws IOException
    {
        return new double[n];
    }
    static double[][] ard(int n,int m)throws IOException
    {
        return new double[n][m];
    }
    static char[] arc(int n)throws IOException
    {
        return new char[n];
    }
    static char[][] arc(int n,int m)throws IOException
    {
        return new char[n][m];
    }
}
    

class Reader {
    public Reader() {
    }

    public Reader(String s) {
    }

    public Reader(InputStream stream) {
    }

    public Reader(OutputStream outputStream) {
    }

    private char getChar() {
        return 'a';
    }

    public String input() {
        return null;
    }

    public boolean hasNext() {
        return false;
    }

    public String next() {
        return null;
    }

    public String nextToken() {
        return null;
    }

    public int nextInt() {
        return 0;
    }

    public long nextLong() {
        return 0;
    }

    public double nextDouble() {
        return 0.0;
    }

    public float nextFloat() {
        return Float.parseFloat(next());
    }

    public byte nextByte() {
        return (byte) 0;
    }

    public long[] nextLongs(int N) {
        return new long[0];
    }

    public double[] nextDoubles(int N) {
        return new double[0];
    }

    public String nextLine() {
        return null;
    }

    public int ni() {
        return 0;
    }

    public int[] ni(int n) {
        return new int[0];
    }

    public String readLine() {
        return null;
    }

    public int[] nextInts(int N) {
        return new int[0];
    }

    public int nint() {
        return 0;
    }

    public int in() {
        return 0;
    }

    public int ri() {
        return 0;
    }

    public int[] ri(int n) {
        return new int[0];
    }

    public int[] rai(int n) {
        return new int[0];
    }

    public int[] rai() {
        return new int[0];
    }

    public double nd() {
        return 0.0;
    }

    public long nl() {
        return 0;
    }

    public int[] nia(int n) {
        return new int[0];
    }

    public long[] nla(int n) {
        return new long[0];
    }

    public int i() {
        return 0;
    }

    public int[] i(int n) {
        return new int[0];
    }

    public long l() {
        return 0;
    }

    public long[] l(int n) {
        return new long[0];
    }

    public double d() {
        return 0.0;
    }

    public int[] nextIntArray(int n) {
        return new int[0];
    }

    public long[] nextLongArray(int n) {
        return new long[0];
    }

    public String[] nextStringArray(int n) {
        return new String[0];
    }

    public long[] lreadArray(int n) {
        return new long[0];
    }

    public long[] readArrayLong(int n) {
        return new long[0];
    }

    public int readInt() {
        return 0;
    }

    public String read() {
        return null;
    }

    public String readString() {
        return null;
    }

    public int[] readArray(int n) {
        return new int[0];
    }

    public long[] readLongArray(int n) {
        return new long[0];
    }

    public long[] arrLong(int n) {
        return new long[0];
    }

    public int[][] graph(int N, int[][] edges) {
        return new int[0][];
    }

    public int[] intArray(int N, int mod) {
        return new int[0];
    }

    public long[] longArray(int N, long mod) {
        return new long[0];
    }

    public Reader write(byte b) {
        return null;
    }

    public Reader write(char c) {
        return null;
    }

    public Reader write(char[] s) {
        return null;
    }

    public Reader write(String s) {
        return null;
    }

    public Reader write(int x) {
        return null;
    }

    public void print(Object s) {
    }

    public void print(Object... objects) {
    }

    public void println(Object s) {
    }

    public void println(int i) {
    }

    public void println() {
    }

    public void printLine(Object... objects) {
    }

    public void printArray(int[] a) {
    }
    
    public void printlnArray(int[] a) {
    }
    
    public void printArray(long[] a) {
    }
    
    public void printlnArray(long[] a) {
    }

    public void p(Object o) {
    }

    public void p() {
    }

    public void ps(Object o) {
    }

    public void ps() {
    }

    public void pl(Object o) {
    }

    public void pl() {
    }

    public void pn() {
    }

    public void pn(Object o) {
    }

    public void pln() {
    }

    public void pln (Object o) {
    }

    public void printLine() {
    }

    public void printLine(Object o) {
    }

    public void flush() {
    }

    public void close() {
    }

    public void exit() {
    }

    public boolean isSpace(int c) { return false; }

    public double readDouble() { return 0.0; }

    public int[] na(int n) {
        return new int[n];
    }

    public long[] nal(int n) {
        return new long[n];
    }

    public void iIA(int arr[]){
    }

    static int[] ari(int n)throws IOException
    {
        return new int[n];
    }
    static int[][] ari(int n,int m)throws IOException
    {
        return new int[n][m];
    }
    static long[] arl(int n)throws IOException
    {
        return new long[n];
    }
    static long[][] arl(int n,int m)throws IOException
    {
        return new long[n][m];
    }
    static String[] ars(int n)throws IOException
    {
        return new String[n];
    }
    static double[] ard(int n)throws IOException
    {
        return new double[n];
    }
    static double[][] ard(int n,int m)throws IOException
    {
        return new double[n][m];
    }
    static char[] arc(int n)throws IOException
    {
        return new char[n];
    }
    static char[][] arc(int n,int m)throws IOException
    {
        return new char[n][m];
    }
}
    

class Writer {
    public Writer() {
    }

    public Writer(String s) {
    }

    public Writer(InputStream stream) {
    }

    public Writer(OutputStream outputStream) {
    }

    private char getChar() {
        return 'a';
    }

    public String input() {
        return null;
    }

    public boolean hasNext() {
        return false;
    }

    public String next() {
        return null;
    }

    public String nextToken() {
        return null;
    }

    public int nextInt() {
        return 0;
    }

    public long nextLong() {
        return 0;
    }

    public double nextDouble() {
        return 0.0;
    }

    public float nextFloat() {
        return Float.parseFloat(next());
    }

    public byte nextByte() {
        return (byte) 0;
    }

    public long[] nextLongs(int N) {
        return new long[0];
    }

    public double[] nextDoubles(int N) {
        return new double[0];
    }

    public String nextLine() {
        return null;
    }

    public int ni() {
        return 0;
    }

    public int[] ni(int n) {
        return new int[0];
    }

    public String readLine() {
        return null;
    }

    public int[] nextInts(int N) {
        return new int[0];
    }

    public int nint() {
        return 0;
    }

    public int in() {
        return 0;
    }

    public int ri() {
        return 0;
    }

    public int[] ri(int n) {
        return new int[0];
    }

    public int[] rai(int n) {
        return new int[0];
    }

    public int[] rai() {
        return new int[0];
    }

    public double nd() {
        return 0.0;
    }

    public long nl() {
        return 0;
    }

    public int[] nia(int n) {
        return new int[0];
    }

    public long[] nla(int n) {
        return new long[0];
    }

    public int i() {
        return 0;
    }

    public int[] i(int n) {
        return new int[0];
    }

    public long l() {
        return 0;
    }

    public long[] l(int n) {
        return new long[0];
    }

    public double d() {
        return 0.0;
    }

    public int[] nextIntArray(int n) {
        return new int[0];
    }

    public long[] nextLongArray(int n) {
        return new long[0];
    }

    public String[] nextStringArray(int n) {
        return new String[0];
    }

    public long[] lreadArray(int n) {
        return new long[0];
    }

    public long[] readArrayLong(int n) {
        return new long[0];
    }

    public int readInt() {
        return 0;
    }

    public String read() {
        return null;
    }

    public String readString() {
        return null;
    }

    public int[] readArray(int n) {
        return new int[0];
    }

    public long[] readLongArray(int n) {
        return new long[0];
    }

    public long[] arrLong(int n) {
        return new long[0];
    }

    public int[][] graph(int N, int[][] edges) {
        return new int[0][];
    }

    public int[] intArray(int N, int mod) {
        return new int[0];
    }

    public long[] longArray(int N, long mod) {
        return new long[0];
    }

    public Writer write(byte b) {
        return null;
    }

    public Writer write(char c) {
        return null;
    }

    public Writer write(char[] s) {
        return null;
    }

    public Writer write(String s) {
        return null;
    }

    public Writer write(int x) {
        return null;
    }

    public void print(Object s) {
    }

    public void print(Object... objects) {
    }

    public void println(Object s) {
    }

    public void println(int i) {
    }

    public void println() {
    }

    public void printLine(Object... objects) {
    }

    public void printArray(int[] a) {
    }
    
    public void printlnArray(int[] a) {
    }
    
    public void printArray(long[] a) {
    }
    
    public void printlnArray(long[] a) {
    }

    public void p(Object o) {
    }

    public void p() {
    }

    public void ps(Object o) {
    }

    public void ps() {
    }

    public void pl(Object o) {
    }

    public void pl() {
    }

    public void pn() {
    }

    public void pn(Object o) {
    }

    public void pln() {
    }

    public void pln (Object o) {
    }

    public void printLine() {
    }

    public void printLine(Object o) {
    }

    public void flush() {
    }

    public void close() {
    }

    public void exit() {
    }

    public boolean isSpace(int c) { return false; }

    public double readDouble() { return 0.0; }

    public int[] na(int n) {
        return new int[n];
    }

    public long[] nal(int n) {
        return new long[n];
    }

    public void iIA(int arr[]){
    }

    static int[] ari(int n)throws IOException
    {
        return new int[n];
    }
    static int[][] ari(int n,int m)throws IOException
    {
        return new int[n][m];
    }
    static long[] arl(int n)throws IOException
    {
        return new long[n];
    }
    static long[][] arl(int n,int m)throws IOException
    {
        return new long[n][m];
    }
    static String[] ars(int n)throws IOException
    {
        return new String[n];
    }
    static double[] ard(int n)throws IOException
    {
        return new double[n];
    }
    static double[][] ard(int n,int m)throws IOException
    {
        return new double[n][m];
    }
    static char[] arc(int n)throws IOException
    {
        return new char[n];
    }
    static char[][] arc(int n,int m)throws IOException
    {
        return new char[n][m];
    }
}
    

class AnotherReader {
    public AnotherReader() {
    }

    public AnotherReader(String s) {
    }

    public AnotherReader(InputStream stream) {
    }

    public AnotherReader(OutputStream outputStream) {
    }

    private char getChar() {
        return 'a';
    }

    public String input() {
        return null;
    }

    public boolean hasNext() {
        return false;
    }

    public String next() {
        return null;
    }

    public String nextToken() {
        return null;
    }

    public int nextInt() {
        return 0;
    }

    public long nextLong() {
        return 0;
    }

    public double nextDouble() {
        return 0.0;
    }

    public float nextFloat() {
        return Float.parseFloat(next());
    }

    public byte nextByte() {
        return (byte) 0;
    }

    public long[] nextLongs(int N) {
        return new long[0];
    }

    public double[] nextDoubles(int N) {
        return new double[0];
    }

    public String nextLine() {
        return null;
    }

    public int ni() {
        return 0;
    }

    public int[] ni(int n) {
        return new int[0];
    }

    public String readLine() {
        return null;
    }

    public int[] nextInts(int N) {
        return new int[0];
    }

    public int nint() {
        return 0;
    }

    public int in() {
        return 0;
    }

    public int ri() {
        return 0;
    }

    public int[] ri(int n) {
        return new int[0];
    }

    public int[] rai(int n) {
        return new int[0];
    }

    public int[] rai() {
        return new int[0];
    }

    public double nd() {
        return 0.0;
    }

    public long nl() {
        return 0;
    }

    public int[] nia(int n) {
        return new int[0];
    }

    public long[] nla(int n) {
        return new long[0];
    }

    public int i() {
        return 0;
    }

    public int[] i(int n) {
        return new int[0];
    }

    public long l() {
        return 0;
    }

    public long[] l(int n) {
        return new long[0];
    }

    public double d() {
        return 0.0;
    }

    public int[] nextIntArray(int n) {
        return new int[0];
    }

    public long[] nextLongArray(int n) {
        return new long[0];
    }

    public String[] nextStringArray(int n) {
        return new String[0];
    }

    public long[] lreadArray(int n) {
        return new long[0];
    }

    public long[] readArrayLong(int n) {
        return new long[0];
    }

    public int readInt() {
        return 0;
    }

    public String read() {
        return null;
    }

    public String readString() {
        return null;
    }

    public int[] readArray(int n) {
        return new int[0];
    }

    public long[] readLongArray(int n) {
        return new long[0];
    }

    public long[] arrLong(int n) {
        return new long[0];
    }

    public int[][] graph(int N, int[][] edges) {
        return new int[0][];
    }

    public int[] intArray(int N, int mod) {
        return new int[0];
    }

    public long[] longArray(int N, long mod) {
        return new long[0];
    }

    public AnotherReader write(byte b) {
        return null;
    }

    public AnotherReader write(char c) {
        return null;
    }

    public AnotherReader write(char[] s) {
        return null;
    }

    public AnotherReader write(String s) {
        return null;
    }

    public AnotherReader write(int x) {
        return null;
    }

    public void print(Object s) {
    }

    public void print(Object... objects) {
    }

    public void println(Object s) {
    }

    public void println(int i) {
    }

    public void println() {
    }

    public void printLine(Object... objects) {
    }

    public void printArray(int[] a) {
    }
    
    public void printlnArray(int[] a) {
    }
    
    public void printArray(long[] a) {
    }
    
    public void printlnArray(long[] a) {
    }

    public void p(Object o) {
    }

    public void p() {
    }

    public void ps(Object o) {
    }

    public void ps() {
    }

    public void pl(Object o) {
    }

    public void pl() {
    }

    public void pn() {
    }

    public void pn(Object o) {
    }

    public void pln() {
    }

    public void pln (Object o) {
    }

    public void printLine() {
    }

    public void printLine(Object o) {
    }

    public void flush() {
    }

    public void close() {
    }

    public void exit() {
    }

    public boolean isSpace(int c) { return false; }

    public double readDouble() { return 0.0; }

    public int[] na(int n) {
        return new int[n];
    }

    public long[] nal(int n) {
        return new long[n];
    }

    public void iIA(int arr[]){
    }

    static int[] ari(int n)throws IOException
    {
        return new int[n];
    }
    static int[][] ari(int n,int m)throws IOException
    {
        return new int[n][m];
    }
    static long[] arl(int n)throws IOException
    {
        return new long[n];
    }
    static long[][] arl(int n,int m)throws IOException
    {
        return new long[n][m];
    }
    static String[] ars(int n)throws IOException
    {
        return new String[n];
    }
    static double[] ard(int n)throws IOException
    {
        return new double[n];
    }
    static double[][] ard(int n,int m)throws IOException
    {
        return new double[n][m];
    }
    static char[] arc(int n)throws IOException
    {
        return new char[n];
    }
    static char[][] arc(int n,int m)throws IOException
    {
        return new char[n][m];
    }
}
    

class MyFastReaderPC3C {
    public MyFastReaderPC3C() {
    }

    public MyFastReaderPC3C(String s) {
    }

    public MyFastReaderPC3C(InputStream stream) {
    }

    public MyFastReaderPC3C(OutputStream outputStream) {
    }

    private char getChar() {
        return 'a';
    }

    public String input() {
        return null;
    }

    public boolean hasNext() {
        return false;
    }

    public String next() {
        return null;
    }

    public String nextToken() {
        return null;
    }

    public int nextInt() {
        return 0;
    }

    public long nextLong() {
        return 0;
    }

    public double nextDouble() {
        return 0.0;
    }

    public float nextFloat() {
        return Float.parseFloat(next());
    }

    public byte nextByte() {
        return (byte) 0;
    }

    public long[] nextLongs(int N) {
        return new long[0];
    }

    public double[] nextDoubles(int N) {
        return new double[0];
    }

    public String nextLine() {
        return null;
    }

    public int ni() {
        return 0;
    }

    public int[] ni(int n) {
        return new int[0];
    }

    public String readLine() {
        return null;
    }

    public int[] nextInts(int N) {
        return new int[0];
    }

    public int nint() {
        return 0;
    }

    public int in() {
        return 0;
    }

    public int ri() {
        return 0;
    }

    public int[] ri(int n) {
        return new int[0];
    }

    public int[] rai(int n) {
        return new int[0];
    }

    public int[] rai() {
        return new int[0];
    }

    public double nd() {
        return 0.0;
    }

    public long nl() {
        return 0;
    }

    public int[] nia(int n) {
        return new int[0];
    }

    public long[] nla(int n) {
        return new long[0];
    }

    public int i() {
        return 0;
    }

    public int[] i(int n) {
        return new int[0];
    }

    public long l() {
        return 0;
    }

    public long[] l(int n) {
        return new long[0];
    }

    public double d() {
        return 0.0;
    }

    public int[] nextIntArray(int n) {
        return new int[0];
    }

    public long[] nextLongArray(int n) {
        return new long[0];
    }

    public String[] nextStringArray(int n) {
        return new String[0];
    }

    public long[] lreadArray(int n) {
        return new long[0];
    }

    public long[] readArrayLong(int n) {
        return new long[0];
    }

    public int readInt() {
        return 0;
    }

    public String read() {
        return null;
    }

    public String readString() {
        return null;
    }

    public int[] readArray(int n) {
        return new int[0];
    }

    public long[] readLongArray(int n) {
        return new long[0];
    }

    public long[] arrLong(int n) {
        return new long[0];
    }

    public int[][] graph(int N, int[][] edges) {
        return new int[0][];
    }

    public int[] intArray(int N, int mod) {
        return new int[0];
    }

    public long[] longArray(int N, long mod) {
        return new long[0];
    }

    public MyFastReaderPC3C write(byte b) {
        return null;
    }

    public MyFastReaderPC3C write(char c) {
        return null;
    }

    public MyFastReaderPC3C write(char[] s) {
        return null;
    }

    public MyFastReaderPC3C write(String s) {
        return null;
    }

    public MyFastReaderPC3C write(int x) {
        return null;
    }

    public void print(Object s) {
    }

    public void print(Object... objects) {
    }

    public void println(Object s) {
    }

    public void println(int i) {
    }

    public void println() {
    }

    public void printLine(Object... objects) {
    }

    public void printArray(int[] a) {
    }
    
    public void printlnArray(int[] a) {
    }
    
    public void printArray(long[] a) {
    }
    
    public void printlnArray(long[] a) {
    }

    public void p(Object o) {
    }

    public void p() {
    }

    public void ps(Object o) {
    }

    public void ps() {
    }

    public void pl(Object o) {
    }

    public void pl() {
    }

    public void pn() {
    }

    public void pn(Object o) {
    }

    public void pln() {
    }

    public void pln (Object o) {
    }

    public void printLine() {
    }

    public void printLine(Object o) {
    }

    public void flush() {
    }

    public void close() {
    }

    public void exit() {
    }

    public boolean isSpace(int c) { return false; }

    public double readDouble() { return 0.0; }

    public int[] na(int n) {
        return new int[n];
    }

    public long[] nal(int n) {
        return new long[n];
    }

    public void iIA(int arr[]){
    }

    static int[] ari(int n)throws IOException
    {
        return new int[n];
    }
    static int[][] ari(int n,int m)throws IOException
    {
        return new int[n][m];
    }
    static long[] arl(int n)throws IOException
    {
        return new long[n];
    }
    static long[][] arl(int n,int m)throws IOException
    {
        return new long[n][m];
    }
    static String[] ars(int n)throws IOException
    {
        return new String[n];
    }
    static double[] ard(int n)throws IOException
    {
        return new double[n];
    }
    static double[][] ard(int n,int m)throws IOException
    {
        return new double[n][m];
    }
    static char[] arc(int n)throws IOException
    {
        return new char[n];
    }
    static char[][] arc(int n,int m)throws IOException
    {
        return new char[n][m];
    }
}
    

class ScanReader {
    public ScanReader() {
    }

    public ScanReader(String s) {
    }

    public ScanReader(InputStream stream) {
    }

    public ScanReader(OutputStream outputStream) {
    }

    private char getChar() {
        return 'a';
    }

    public String input() {
        return null;
    }

    public boolean hasNext() {
        return false;
    }

    public String next() {
        return null;
    }

    public String nextToken() {
        return null;
    }

    public int nextInt() {
        return 0;
    }

    public long nextLong() {
        return 0;
    }

    public double nextDouble() {
        return 0.0;
    }

    public float nextFloat() {
        return Float.parseFloat(next());
    }

    public byte nextByte() {
        return (byte) 0;
    }

    public long[] nextLongs(int N) {
        return new long[0];
    }

    public double[] nextDoubles(int N) {
        return new double[0];
    }

    public String nextLine() {
        return null;
    }

    public int ni() {
        return 0;
    }

    public int[] ni(int n) {
        return new int[0];
    }

    public String readLine() {
        return null;
    }

    public int[] nextInts(int N) {
        return new int[0];
    }

    public int nint() {
        return 0;
    }

    public int in() {
        return 0;
    }

    public int ri() {
        return 0;
    }

    public int[] ri(int n) {
        return new int[0];
    }

    public int[] rai(int n) {
        return new int[0];
    }

    public int[] rai() {
        return new int[0];
    }

    public double nd() {
        return 0.0;
    }

    public long nl() {
        return 0;
    }

    public int[] nia(int n) {
        return new int[0];
    }

    public long[] nla(int n) {
        return new long[0];
    }

    public int i() {
        return 0;
    }

    public int[] i(int n) {
        return new int[0];
    }

    public long l() {
        return 0;
    }

    public long[] l(int n) {
        return new long[0];
    }

    public double d() {
        return 0.0;
    }

    public int[] nextIntArray(int n) {
        return new int[0];
    }

    public long[] nextLongArray(int n) {
        return new long[0];
    }

    public String[] nextStringArray(int n) {
        return new String[0];
    }

    public long[] lreadArray(int n) {
        return new long[0];
    }

    public long[] readArrayLong(int n) {
        return new long[0];
    }

    public int readInt() {
        return 0;
    }

    public String read() {
        return null;
    }

    public String readString() {
        return null;
    }

    public int[] readArray(int n) {
        return new int[0];
    }

    public long[] readLongArray(int n) {
        return new long[0];
    }

    public long[] arrLong(int n) {
        return new long[0];
    }

    public int[][] graph(int N, int[][] edges) {
        return new int[0][];
    }

    public int[] intArray(int N, int mod) {
        return new int[0];
    }

    public long[] longArray(int N, long mod) {
        return new long[0];
    }

    public ScanReader write(byte b) {
        return null;
    }

    public ScanReader write(char c) {
        return null;
    }

    public ScanReader write(char[] s) {
        return null;
    }

    public ScanReader write(String s) {
        return null;
    }

    public ScanReader write(int x) {
        return null;
    }

    public void print(Object s) {
    }

    public void print(Object... objects) {
    }

    public void println(Object s) {
    }

    public void println(int i) {
    }

    public void println() {
    }

    public void printLine(Object... objects) {
    }

    public void printArray(int[] a) {
    }
    
    public void printlnArray(int[] a) {
    }
    
    public void printArray(long[] a) {
    }
    
    public void printlnArray(long[] a) {
    }

    public void p(Object o) {
    }

    public void p() {
    }

    public void ps(Object o) {
    }

    public void ps() {
    }

    public void pl(Object o) {
    }

    public void pl() {
    }

    public void pn() {
    }

    public void pn(Object o) {
    }

    public void pln() {
    }

    public void pln (Object o) {
    }

    public void printLine() {
    }

    public void printLine(Object o) {
    }

    public void flush() {
    }

    public void close() {
    }

    public void exit() {
    }

    public boolean isSpace(int c) { return false; }

    public double readDouble() { return 0.0; }

    public int[] na(int n) {
        return new int[n];
    }

    public long[] nal(int n) {
        return new long[n];
    }

    public void iIA(int arr[]){
    }

    static int[] ari(int n)throws IOException
    {
        return new int[n];
    }
    static int[][] ari(int n,int m)throws IOException
    {
        return new int[n][m];
    }
    static long[] arl(int n)throws IOException
    {
        return new long[n];
    }
    static long[][] arl(int n,int m)throws IOException
    {
        return new long[n][m];
    }
    static String[] ars(int n)throws IOException
    {
        return new String[n];
    }
    static double[] ard(int n)throws IOException
    {
        return new double[n];
    }
    static double[][] ard(int n,int m)throws IOException
    {
        return new double[n][m];
    }
    static char[] arc(int n)throws IOException
    {
        return new char[n];
    }
    static char[][] arc(int n,int m)throws IOException
    {
        return new char[n][m];
    }
}
    

class FR {
    public FR() {
    }

    public FR(String s) {
    }

    public FR(InputStream stream) {
    }

    public FR(OutputStream outputStream) {
    }

    private char getChar() {
        return 'a';
    }

    public String input() {
        return null;
    }

    public boolean hasNext() {
        return false;
    }

    public String next() {
        return null;
    }

    public String nextToken() {
        return null;
    }

    public int nextInt() {
        return 0;
    }

    public long nextLong() {
        return 0;
    }

    public double nextDouble() {
        return 0.0;
    }

    public float nextFloat() {
        return Float.parseFloat(next());
    }

    public byte nextByte() {
        return (byte) 0;
    }

    public long[] nextLongs(int N) {
        return new long[0];
    }

    public double[] nextDoubles(int N) {
        return new double[0];
    }

    public String nextLine() {
        return null;
    }

    public int ni() {
        return 0;
    }

    public int[] ni(int n) {
        return new int[0];
    }

    public String readLine() {
        return null;
    }

    public int[] nextInts(int N) {
        return new int[0];
    }

    public int nint() {
        return 0;
    }

    public int in() {
        return 0;
    }

    public int ri() {
        return 0;
    }

    public int[] ri(int n) {
        return new int[0];
    }

    public int[] rai(int n) {
        return new int[0];
    }

    public int[] rai() {
        return new int[0];
    }

    public double nd() {
        return 0.0;
    }

    public long nl() {
        return 0;
    }

    public int[] nia(int n) {
        return new int[0];
    }

    public long[] nla(int n) {
        return new long[0];
    }

    public int i() {
        return 0;
    }

    public int[] i(int n) {
        return new int[0];
    }

    public long l() {
        return 0;
    }

    public long[] l(int n) {
        return new long[0];
    }

    public double d() {
        return 0.0;
    }

    public int[] nextIntArray(int n) {
        return new int[0];
    }

    public long[] nextLongArray(int n) {
        return new long[0];
    }

    public String[] nextStringArray(int n) {
        return new String[0];
    }

    public long[] lreadArray(int n) {
        return new long[0];
    }

    public long[] readArrayLong(int n) {
        return new long[0];
    }

    public int readInt() {
        return 0;
    }

    public String read() {
        return null;
    }

    public String readString() {
        return null;
    }

    public int[] readArray(int n) {
        return new int[0];
    }

    public long[] readLongArray(int n) {
        return new long[0];
    }

    public long[] arrLong(int n) {
        return new long[0];
    }

    public int[][] graph(int N, int[][] edges) {
        return new int[0][];
    }

    public int[] intArray(int N, int mod) {
        return new int[0];
    }

    public long[] longArray(int N, long mod) {
        return new long[0];
    }

    public FR write(byte b) {
        return null;
    }

    public FR write(char c) {
        return null;
    }

    public FR write(char[] s) {
        return null;
    }

    public FR write(String s) {
        return null;
    }

    public FR write(int x) {
        return null;
    }

    public void print(Object s) {
    }

    public void print(Object... objects) {
    }

    public void println(Object s) {
    }

    public void println(int i) {
    }

    public void println() {
    }

    public void printLine(Object... objects) {
    }

    public void printArray(int[] a) {
    }
    
    public void printlnArray(int[] a) {
    }
    
    public void printArray(long[] a) {
    }
    
    public void printlnArray(long[] a) {
    }

    public void p(Object o) {
    }

    public void p() {
    }

    public void ps(Object o) {
    }

    public void ps() {
    }

    public void pl(Object o) {
    }

    public void pl() {
    }

    public void pn() {
    }

    public void pn(Object o) {
    }

    public void pln() {
    }

    public void pln (Object o) {
    }

    public void printLine() {
    }

    public void printLine(Object o) {
    }

    public void flush() {
    }

    public void close() {
    }

    public void exit() {
    }

    public boolean isSpace(int c) { return false; }

    public double readDouble() { return 0.0; }

    public int[] na(int n) {
        return new int[n];
    }

    public long[] nal(int n) {
        return new long[n];
    }

    public void iIA(int arr[]){
    }

    static int[] ari(int n)throws IOException
    {
        return new int[n];
    }
    static int[][] ari(int n,int m)throws IOException
    {
        return new int[n][m];
    }
    static long[] arl(int n)throws IOException
    {
        return new long[n];
    }
    static long[][] arl(int n,int m)throws IOException
    {
        return new long[n][m];
    }
    static String[] ars(int n)throws IOException
    {
        return new String[n];
    }
    static double[] ard(int n)throws IOException
    {
        return new double[n];
    }
    static double[][] ard(int n,int m)throws IOException
    {
        return new double[n][m];
    }
    static char[] arc(int n)throws IOException
    {
        return new char[n];
    }
    static char[][] arc(int n,int m)throws IOException
    {
        return new char[n][m];
    }
}
    

class FS {
    public FS() {
    }

    public FS(String s) {
    }

    public FS(InputStream stream) {
    }

    public FS(OutputStream outputStream) {
    }

    private char getChar() {
        return 'a';
    }

    public String input() {
        return null;
    }

    public boolean hasNext() {
        return false;
    }

    public String next() {
        return null;
    }

    public String nextToken() {
        return null;
    }

    public int nextInt() {
        return 0;
    }

    public long nextLong() {
        return 0;
    }

    public double nextDouble() {
        return 0.0;
    }

    public float nextFloat() {
        return Float.parseFloat(next());
    }

    public byte nextByte() {
        return (byte) 0;
    }

    public long[] nextLongs(int N) {
        return new long[0];
    }

    public double[] nextDoubles(int N) {
        return new double[0];
    }

    public String nextLine() {
        return null;
    }

    public int ni() {
        return 0;
    }

    public int[] ni(int n) {
        return new int[0];
    }

    public String readLine() {
        return null;
    }

    public int[] nextInts(int N) {
        return new int[0];
    }

    public int nint() {
        return 0;
    }

    public int in() {
        return 0;
    }

    public int ri() {
        return 0;
    }

    public int[] ri(int n) {
        return new int[0];
    }

    public int[] rai(int n) {
        return new int[0];
    }

    public int[] rai() {
        return new int[0];
    }

    public double nd() {
        return 0.0;
    }

    public long nl() {
        return 0;
    }

    public int[] nia(int n) {
        return new int[0];
    }

    public long[] nla(int n) {
        return new long[0];
    }

    public int i() {
        return 0;
    }

    public int[] i(int n) {
        return new int[0];
    }

    public long l() {
        return 0;
    }

    public long[] l(int n) {
        return new long[0];
    }

    public double d() {
        return 0.0;
    }

    public int[] nextIntArray(int n) {
        return new int[0];
    }

    public long[] nextLongArray(int n) {
        return new long[0];
    }

    public String[] nextStringArray(int n) {
        return new String[0];
    }

    public long[] lreadArray(int n) {
        return new long[0];
    }

    public long[] readArrayLong(int n) {
        return new long[0];
    }

    public int readInt() {
        return 0;
    }

    public String read() {
        return null;
    }

    public String readString() {
        return null;
    }

    public int[] readArray(int n) {
        return new int[0];
    }

    public long[] readLongArray(int n) {
        return new long[0];
    }

    public long[] arrLong(int n) {
        return new long[0];
    }

    public int[][] graph(int N, int[][] edges) {
        return new int[0][];
    }

    public int[] intArray(int N, int mod) {
        return new int[0];
    }

    public long[] longArray(int N, long mod) {
        return new long[0];
    }

    public FS write(byte b) {
        return null;
    }

    public FS write(char c) {
        return null;
    }

    public FS write(char[] s) {
        return null;
    }

    public FS write(String s) {
        return null;
    }

    public FS write(int x) {
        return null;
    }

    public void print(Object s) {
    }

    public void print(Object... objects) {
    }

    public void println(Object s) {
    }

    public void println(int i) {
    }

    public void println() {
    }

    public void printLine(Object... objects) {
    }

    public void printArray(int[] a) {
    }
    
    public void printlnArray(int[] a) {
    }
    
    public void printArray(long[] a) {
    }
    
    public void printlnArray(long[] a) {
    }

    public void p(Object o) {
    }

    public void p() {
    }

    public void ps(Object o) {
    }

    public void ps() {
    }

    public void pl(Object o) {
    }

    public void pl() {
    }

    public void pn() {
    }

    public void pn(Object o) {
    }

    public void pln() {
    }

    public void pln (Object o) {
    }

    public void printLine() {
    }

    public void printLine(Object o) {
    }

    public void flush() {
    }

    public void close() {
    }

    public void exit() {
    }

    public boolean isSpace(int c) { return false; }

    public double readDouble() { return 0.0; }

    public int[] na(int n) {
        return new int[n];
    }

    public long[] nal(int n) {
        return new long[n];
    }

    public void iIA(int arr[]){
    }

    static int[] ari(int n)throws IOException
    {
        return new int[n];
    }
    static int[][] ari(int n,int m)throws IOException
    {
        return new int[n][m];
    }
    static long[] arl(int n)throws IOException
    {
        return new long[n];
    }
    static long[][] arl(int n,int m)throws IOException
    {
        return new long[n][m];
    }
    static String[] ars(int n)throws IOException
    {
        return new String[n];
    }
    static double[] ard(int n)throws IOException
    {
        return new double[n];
    }
    static double[][] ard(int n,int m)throws IOException
    {
        return new double[n][m];
    }
    static char[] arc(int n)throws IOException
    {
        return new char[n];
    }
    static char[][] arc(int n,int m)throws IOException
    {
        return new char[n][m];
    }
}
    

class SC {
    public SC() {
    }

    public SC(String s) {
    }

    public SC(InputStream stream) {
    }

    public SC(OutputStream outputStream) {
    }

    private char getChar() {
        return 'a';
    }

    public String input() {
        return null;
    }

    public boolean hasNext() {
        return false;
    }

    public String next() {
        return null;
    }

    public String nextToken() {
        return null;
    }

    public int nextInt() {
        return 0;
    }

    public long nextLong() {
        return 0;
    }

    public double nextDouble() {
        return 0.0;
    }

    public float nextFloat() {
        return Float.parseFloat(next());
    }

    public byte nextByte() {
        return (byte) 0;
    }

    public long[] nextLongs(int N) {
        return new long[0];
    }

    public double[] nextDoubles(int N) {
        return new double[0];
    }

    public String nextLine() {
        return null;
    }

    public int ni() {
        return 0;
    }

    public int[] ni(int n) {
        return new int[0];
    }

    public String readLine() {
        return null;
    }

    public int[] nextInts(int N) {
        return new int[0];
    }

    public int nint() {
        return 0;
    }

    public int in() {
        return 0;
    }

    public int ri() {
        return 0;
    }

    public int[] ri(int n) {
        return new int[0];
    }

    public int[] rai(int n) {
        return new int[0];
    }

    public int[] rai() {
        return new int[0];
    }

    public double nd() {
        return 0.0;
    }

    public long nl() {
        return 0;
    }

    public int[] nia(int n) {
        return new int[0];
    }

    public long[] nla(int n) {
        return new long[0];
    }

    public int i() {
        return 0;
    }

    public int[] i(int n) {
        return new int[0];
    }

    public long l() {
        return 0;
    }

    public long[] l(int n) {
        return new long[0];
    }

    public double d() {
        return 0.0;
    }

    public int[] nextIntArray(int n) {
        return new int[0];
    }

    public long[] nextLongArray(int n) {
        return new long[0];
    }

    public String[] nextStringArray(int n) {
        return new String[0];
    }

    public long[] lreadArray(int n) {
        return new long[0];
    }

    public long[] readArrayLong(int n) {
        return new long[0];
    }

    public int readInt() {
        return 0;
    }

    public String read() {
        return null;
    }

    public String readString() {
        return null;
    }

    public int[] readArray(int n) {
        return new int[0];
    }

    public long[] readLongArray(int n) {
        return new long[0];
    }

    public long[] arrLong(int n) {
        return new long[0];
    }

    public int[][] graph(int N, int[][] edges) {
        return new int[0][];
    }

    public int[] intArray(int N, int mod) {
        return new int[0];
    }

    public long[] longArray(int N, long mod) {
        return new long[0];
    }

    public SC write(byte b) {
        return null;
    }

    public SC write(char c) {
        return null;
    }

    public SC write(char[] s) {
        return null;
    }

    public SC write(String s) {
        return null;
    }

    public SC write(int x) {
        return null;
    }

    public void print(Object s) {
    }

    public void print(Object... objects) {
    }

    public void println(Object s) {
    }

    public void println(int i) {
    }

    public void println() {
    }

    public void printLine(Object... objects) {
    }

    public void printArray(int[] a) {
    }
    
    public void printlnArray(int[] a) {
    }
    
    public void printArray(long[] a) {
    }
    
    public void printlnArray(long[] a) {
    }

    public void p(Object o) {
    }

    public void p() {
    }

    public void ps(Object o) {
    }

    public void ps() {
    }

    public void pl(Object o) {
    }

    public void pl() {
    }

    public void pn() {
    }

    public void pn(Object o) {
    }

    public void pln() {
    }

    public void pln (Object o) {
    }

    public void printLine() {
    }

    public void printLine(Object o) {
    }

    public void flush() {
    }

    public void close() {
    }

    public void exit() {
    }

    public boolean isSpace(int c) { return false; }

    public double readDouble() { return 0.0; }

    public int[] na(int n) {
        return new int[n];
    }

    public long[] nal(int n) {
        return new long[n];
    }

    public void iIA(int arr[]){
    }

    static int[] ari(int n)throws IOException
    {
        return new int[n];
    }
    static int[][] ari(int n,int m)throws IOException
    {
        return new int[n][m];
    }
    static long[] arl(int n)throws IOException
    {
        return new long[n];
    }
    static long[][] arl(int n,int m)throws IOException
    {
        return new long[n][m];
    }
    static String[] ars(int n)throws IOException
    {
        return new String[n];
    }
    static double[] ard(int n)throws IOException
    {
        return new double[n];
    }
    static double[][] ard(int n,int m)throws IOException
    {
        return new double[n][m];
    }
    static char[] arc(int n)throws IOException
    {
        return new char[n];
    }
    static char[][] arc(int n,int m)throws IOException
    {
        return new char[n][m];
    }
}
    

class FasterScanner {
    public FasterScanner() {
    }

    public FasterScanner(String s) {
    }

    public FasterScanner(InputStream stream) {
    }

    public FasterScanner(OutputStream outputStream) {
    }

    private char getChar() {
        return 'a';
    }

    public String input() {
        return null;
    }

    public boolean hasNext() {
        return false;
    }

    public String next() {
        return null;
    }

    public String nextToken() {
        return null;
    }

    public int nextInt() {
        return 0;
    }

    public long nextLong() {
        return 0;
    }

    public double nextDouble() {
        return 0.0;
    }

    public float nextFloat() {
        return Float.parseFloat(next());
    }

    public byte nextByte() {
        return (byte) 0;
    }

    public long[] nextLongs(int N) {
        return new long[0];
    }

    public double[] nextDoubles(int N) {
        return new double[0];
    }

    public String nextLine() {
        return null;
    }

    public int ni() {
        return 0;
    }

    public int[] ni(int n) {
        return new int[0];
    }

    public String readLine() {
        return null;
    }

    public int[] nextInts(int N) {
        return new int[0];
    }

    public int nint() {
        return 0;
    }

    public int in() {
        return 0;
    }

    public int ri() {
        return 0;
    }

    public int[] ri(int n) {
        return new int[0];
    }

    public int[] rai(int n) {
        return new int[0];
    }

    public int[] rai() {
        return new int[0];
    }

    public double nd() {
        return 0.0;
    }

    public long nl() {
        return 0;
    }

    public int[] nia(int n) {
        return new int[0];
    }

    public long[] nla(int n) {
        return new long[0];
    }

    public int i() {
        return 0;
    }

    public int[] i(int n) {
        return new int[0];
    }

    public long l() {
        return 0;
    }

    public long[] l(int n) {
        return new long[0];
    }

    public double d() {
        return 0.0;
    }

    public int[] nextIntArray(int n) {
        return new int[0];
    }

    public long[] nextLongArray(int n) {
        return new long[0];
    }

    public String[] nextStringArray(int n) {
        return new String[0];
    }

    public long[] lreadArray(int n) {
        return new long[0];
    }

    public long[] readArrayLong(int n) {
        return new long[0];
    }

    public int readInt() {
        return 0;
    }

    public String read() {
        return null;
    }

    public String readString() {
        return null;
    }

    public int[] readArray(int n) {
        return new int[0];
    }

    public long[] readLongArray(int n) {
        return new long[0];
    }

    public long[] arrLong(int n) {
        return new long[0];
    }

    public int[][] graph(int N, int[][] edges) {
        return new int[0][];
    }

    public int[] intArray(int N, int mod) {
        return new int[0];
    }

    public long[] longArray(int N, long mod) {
        return new long[0];
    }

    public FasterScanner write(byte b) {
        return null;
    }

    public FasterScanner write(char c) {
        return null;
    }

    public FasterScanner write(char[] s) {
        return null;
    }

    public FasterScanner write(String s) {
        return null;
    }

    public FasterScanner write(int x) {
        return null;
    }

    public void print(Object s) {
    }

    public void print(Object... objects) {
    }

    public void println(Object s) {
    }

    public void println(int i) {
    }

    public void println() {
    }

    public void printLine(Object... objects) {
    }

    public void printArray(int[] a) {
    }
    
    public void printlnArray(int[] a) {
    }
    
    public void printArray(long[] a) {
    }
    
    public void printlnArray(long[] a) {
    }

    public void p(Object o) {
    }

    public void p() {
    }

    public void ps(Object o) {
    }

    public void ps() {
    }

    public void pl(Object o) {
    }

    public void pl() {
    }

    public void pn() {
    }

    public void pn(Object o) {
    }

    public void pln() {
    }

    public void pln (Object o) {
    }

    public void printLine() {
    }

    public void printLine(Object o) {
    }

    public void flush() {
    }

    public void close() {
    }

    public void exit() {
    }

    public boolean isSpace(int c) { return false; }

    public double readDouble() { return 0.0; }

    public int[] na(int n) {
        return new int[n];
    }

    public long[] nal(int n) {
        return new long[n];
    }

    public void iIA(int arr[]){
    }

    static int[] ari(int n)throws IOException
    {
        return new int[n];
    }
    static int[][] ari(int n,int m)throws IOException
    {
        return new int[n][m];
    }
    static long[] arl(int n)throws IOException
    {
        return new long[n];
    }
    static long[][] arl(int n,int m)throws IOException
    {
        return new long[n][m];
    }
    static String[] ars(int n)throws IOException
    {
        return new String[n];
    }
    static double[] ard(int n)throws IOException
    {
        return new double[n];
    }
    static double[][] ard(int n,int m)throws IOException
    {
        return new double[n][m];
    }
    static char[] arc(int n)throws IOException
    {
        return new char[n];
    }
    static char[][] arc(int n,int m)throws IOException
    {
        return new char[n][m];
    }
}
    

class FastScanner58 {
    public FastScanner58() {
    }

    public FastScanner58(String s) {
    }

    public FastScanner58(InputStream stream) {
    }

    public FastScanner58(OutputStream outputStream) {
    }

    private char getChar() {
        return 'a';
    }

    public String input() {
        return null;
    }

    public boolean hasNext() {
        return false;
    }

    public String next() {
        return null;
    }

    public String nextToken() {
        return null;
    }

    public int nextInt() {
        return 0;
    }

    public long nextLong() {
        return 0;
    }

    public double nextDouble() {
        return 0.0;
    }

    public float nextFloat() {
        return Float.parseFloat(next());
    }

    public byte nextByte() {
        return (byte) 0;
    }

    public long[] nextLongs(int N) {
        return new long[0];
    }

    public double[] nextDoubles(int N) {
        return new double[0];
    }

    public String nextLine() {
        return null;
    }

    public int ni() {
        return 0;
    }

    public int[] ni(int n) {
        return new int[0];
    }

    public String readLine() {
        return null;
    }

    public int[] nextInts(int N) {
        return new int[0];
    }

    public int nint() {
        return 0;
    }

    public int in() {
        return 0;
    }

    public int ri() {
        return 0;
    }

    public int[] ri(int n) {
        return new int[0];
    }

    public int[] rai(int n) {
        return new int[0];
    }

    public int[] rai() {
        return new int[0];
    }

    public double nd() {
        return 0.0;
    }

    public long nl() {
        return 0;
    }

    public int[] nia(int n) {
        return new int[0];
    }

    public long[] nla(int n) {
        return new long[0];
    }

    public int i() {
        return 0;
    }

    public int[] i(int n) {
        return new int[0];
    }

    public long l() {
        return 0;
    }

    public long[] l(int n) {
        return new long[0];
    }

    public double d() {
        return 0.0;
    }

    public int[] nextIntArray(int n) {
        return new int[0];
    }

    public long[] nextLongArray(int n) {
        return new long[0];
    }

    public String[] nextStringArray(int n) {
        return new String[0];
    }

    public long[] lreadArray(int n) {
        return new long[0];
    }

    public long[] readArrayLong(int n) {
        return new long[0];
    }

    public int readInt() {
        return 0;
    }

    public String read() {
        return null;
    }

    public String readString() {
        return null;
    }

    public int[] readArray(int n) {
        return new int[0];
    }

    public long[] readLongArray(int n) {
        return new long[0];
    }

    public long[] arrLong(int n) {
        return new long[0];
    }

    public int[][] graph(int N, int[][] edges) {
        return new int[0][];
    }

    public int[] intArray(int N, int mod) {
        return new int[0];
    }

    public long[] longArray(int N, long mod) {
        return new long[0];
    }

    public FastScanner58 write(byte b) {
        return null;
    }

    public FastScanner58 write(char c) {
        return null;
    }

    public FastScanner58 write(char[] s) {
        return null;
    }

    public FastScanner58 write(String s) {
        return null;
    }

    public FastScanner58 write(int x) {
        return null;
    }

    public void print(Object s) {
    }

    public void print(Object... objects) {
    }

    public void println(Object s) {
    }

    public void println(int i) {
    }

    public void println() {
    }

    public void printLine(Object... objects) {
    }

    public void printArray(int[] a) {
    }
    
    public void printlnArray(int[] a) {
    }
    
    public void printArray(long[] a) {
    }
    
    public void printlnArray(long[] a) {
    }

    public void p(Object o) {
    }

    public void p() {
    }

    public void ps(Object o) {
    }

    public void ps() {
    }

    public void pl(Object o) {
    }

    public void pl() {
    }

    public void pn() {
    }

    public void pn(Object o) {
    }

    public void pln() {
    }

    public void pln (Object o) {
    }

    public void printLine() {
    }

    public void printLine(Object o) {
    }

    public void flush() {
    }

    public void close() {
    }

    public void exit() {
    }

    public boolean isSpace(int c) { return false; }

    public double readDouble() { return 0.0; }

    public int[] na(int n) {
        return new int[n];
    }

    public long[] nal(int n) {
        return new long[n];
    }

    public void iIA(int arr[]){
    }

    static int[] ari(int n)throws IOException
    {
        return new int[n];
    }
    static int[][] ari(int n,int m)throws IOException
    {
        return new int[n][m];
    }
    static long[] arl(int n)throws IOException
    {
        return new long[n];
    }
    static long[][] arl(int n,int m)throws IOException
    {
        return new long[n][m];
    }
    static String[] ars(int n)throws IOException
    {
        return new String[n];
    }
    static double[] ard(int n)throws IOException
    {
        return new double[n];
    }
    static double[][] ard(int n,int m)throws IOException
    {
        return new double[n][m];
    }
    static char[] arc(int n)throws IOException
    {
        return new char[n];
    }
    static char[][] arc(int n,int m)throws IOException
    {
        return new char[n][m];
    }
}
    

class FastScanner57 {
    public FastScanner57() {
    }

    public FastScanner57(String s) {
    }

    public FastScanner57(InputStream stream) {
    }

    public FastScanner57(OutputStream outputStream) {
    }

    private char getChar() {
        return 'a';
    }

    public String input() {
        return null;
    }

    public boolean hasNext() {
        return false;
    }

    public String next() {
        return null;
    }

    public String nextToken() {
        return null;
    }

    public int nextInt() {
        return 0;
    }

    public long nextLong() {
        return 0;
    }

    public double nextDouble() {
        return 0.0;
    }

    public float nextFloat() {
        return Float.parseFloat(next());
    }

    public byte nextByte() {
        return (byte) 0;
    }

    public long[] nextLongs(int N) {
        return new long[0];
    }

    public double[] nextDoubles(int N) {
        return new double[0];
    }

    public String nextLine() {
        return null;
    }

    public int ni() {
        return 0;
    }

    public int[] ni(int n) {
        return new int[0];
    }

    public String readLine() {
        return null;
    }

    public int[] nextInts(int N) {
        return new int[0];
    }

    public int nint() {
        return 0;
    }

    public int in() {
        return 0;
    }

    public int ri() {
        return 0;
    }

    public int[] ri(int n) {
        return new int[0];
    }

    public int[] rai(int n) {
        return new int[0];
    }

    public int[] rai() {
        return new int[0];
    }

    public double nd() {
        return 0.0;
    }

    public long nl() {
        return 0;
    }

    public int[] nia(int n) {
        return new int[0];
    }

    public long[] nla(int n) {
        return new long[0];
    }

    public int i() {
        return 0;
    }

    public int[] i(int n) {
        return new int[0];
    }

    public long l() {
        return 0;
    }

    public long[] l(int n) {
        return new long[0];
    }

    public double d() {
        return 0.0;
    }

    public int[] nextIntArray(int n) {
        return new int[0];
    }

    public long[] nextLongArray(int n) {
        return new long[0];
    }

    public String[] nextStringArray(int n) {
        return new String[0];
    }

    public long[] lreadArray(int n) {
        return new long[0];
    }

    public long[] readArrayLong(int n) {
        return new long[0];
    }

    public int readInt() {
        return 0;
    }

    public String read() {
        return null;
    }

    public String readString() {
        return null;
    }

    public int[] readArray(int n) {
        return new int[0];
    }

    public long[] readLongArray(int n) {
        return new long[0];
    }

    public long[] arrLong(int n) {
        return new long[0];
    }

    public int[][] graph(int N, int[][] edges) {
        return new int[0][];
    }

    public int[] intArray(int N, int mod) {
        return new int[0];
    }

    public long[] longArray(int N, long mod) {
        return new long[0];
    }

    public FastScanner57 write(byte b) {
        return null;
    }

    public FastScanner57 write(char c) {
        return null;
    }

    public FastScanner57 write(char[] s) {
        return null;
    }

    public FastScanner57 write(String s) {
        return null;
    }

    public FastScanner57 write(int x) {
        return null;
    }

    public void print(Object s) {
    }

    public void print(Object... objects) {
    }

    public void println(Object s) {
    }

    public void println(int i) {
    }

    public void println() {
    }

    public void printLine(Object... objects) {
    }

    public void printArray(int[] a) {
    }
    
    public void printlnArray(int[] a) {
    }
    
    public void printArray(long[] a) {
    }
    
    public void printlnArray(long[] a) {
    }

    public void p(Object o) {
    }

    public void p() {
    }

    public void ps(Object o) {
    }

    public void ps() {
    }

    public void pl(Object o) {
    }

    public void pl() {
    }

    public void pn() {
    }

    public void pn(Object o) {
    }

    public void pln() {
    }

    public void pln (Object o) {
    }

    public void printLine() {
    }

    public void printLine(Object o) {
    }

    public void flush() {
    }

    public void close() {
    }

    public void exit() {
    }

    public boolean isSpace(int c) { return false; }

    public double readDouble() { return 0.0; }

    public int[] na(int n) {
        return new int[n];
    }

    public long[] nal(int n) {
        return new long[n];
    }

    public void iIA(int arr[]){
    }

    static int[] ari(int n)throws IOException
    {
        return new int[n];
    }
    static int[][] ari(int n,int m)throws IOException
    {
        return new int[n][m];
    }
    static long[] arl(int n)throws IOException
    {
        return new long[n];
    }
    static long[][] arl(int n,int m)throws IOException
    {
        return new long[n][m];
    }
    static String[] ars(int n)throws IOException
    {
        return new String[n];
    }
    static double[] ard(int n)throws IOException
    {
        return new double[n];
    }
    static double[][] ard(int n,int m)throws IOException
    {
        return new double[n][m];
    }
    static char[] arc(int n)throws IOException
    {
        return new char[n];
    }
    static char[][] arc(int n,int m)throws IOException
    {
        return new char[n][m];
    }
}
    

class FastWriter {
    public FastWriter() {
    }

    public FastWriter(String s) {
    }

    public FastWriter(InputStream stream) {
    }

    public FastWriter(OutputStream outputStream) {
    }

    private char getChar() {
        return 'a';
    }

    public String input() {
        return null;
    }

    public boolean hasNext() {
        return false;
    }

    public String next() {
        return null;
    }

    public String nextToken() {
        return null;
    }

    public int nextInt() {
        return 0;
    }

    public long nextLong() {
        return 0;
    }

    public double nextDouble() {
        return 0.0;
    }

    public float nextFloat() {
        return Float.parseFloat(next());
    }

    public byte nextByte() {
        return (byte) 0;
    }

    public long[] nextLongs(int N) {
        return new long[0];
    }

    public double[] nextDoubles(int N) {
        return new double[0];
    }

    public String nextLine() {
        return null;
    }

    public int ni() {
        return 0;
    }

    public int[] ni(int n) {
        return new int[0];
    }

    public String readLine() {
        return null;
    }

    public int[] nextInts(int N) {
        return new int[0];
    }

    public int nint() {
        return 0;
    }

    public int in() {
        return 0;
    }

    public int ri() {
        return 0;
    }

    public int[] ri(int n) {
        return new int[0];
    }

    public int[] rai(int n) {
        return new int[0];
    }

    public int[] rai() {
        return new int[0];
    }

    public double nd() {
        return 0.0;
    }

    public long nl() {
        return 0;
    }

    public int[] nia(int n) {
        return new int[0];
    }

    public long[] nla(int n) {
        return new long[0];
    }

    public int i() {
        return 0;
    }

    public int[] i(int n) {
        return new int[0];
    }

    public long l() {
        return 0;
    }

    public long[] l(int n) {
        return new long[0];
    }

    public double d() {
        return 0.0;
    }

    public int[] nextIntArray(int n) {
        return new int[0];
    }

    public long[] nextLongArray(int n) {
        return new long[0];
    }

    public String[] nextStringArray(int n) {
        return new String[0];
    }

    public long[] lreadArray(int n) {
        return new long[0];
    }

    public long[] readArrayLong(int n) {
        return new long[0];
    }

    public int readInt() {
        return 0;
    }

    public String read() {
        return null;
    }

    public String readString() {
        return null;
    }

    public int[] readArray(int n) {
        return new int[0];
    }

    public long[] readLongArray(int n) {
        return new long[0];
    }

    public long[] arrLong(int n) {
        return new long[0];
    }

    public int[][] graph(int N, int[][] edges) {
        return new int[0][];
    }

    public int[] intArray(int N, int mod) {
        return new int[0];
    }

    public long[] longArray(int N, long mod) {
        return new long[0];
    }

    public FastWriter write(byte b) {
        return null;
    }

    public FastWriter write(char c) {
        return null;
    }

    public FastWriter write(char[] s) {
        return null;
    }

    public FastWriter write(String s) {
        return null;
    }

    public FastWriter write(int x) {
        return null;
    }

    public void print(Object s) {
    }

    public void print(Object... objects) {
    }

    public void println(Object s) {
    }

    public void println(int i) {
    }

    public void println() {
    }

    public void printLine(Object... objects) {
    }

    public void printArray(int[] a) {
    }
    
    public void printlnArray(int[] a) {
    }
    
    public void printArray(long[] a) {
    }
    
    public void printlnArray(long[] a) {
    }

    public void p(Object o) {
    }

    public void p() {
    }

    public void ps(Object o) {
    }

    public void ps() {
    }

    public void pl(Object o) {
    }

    public void pl() {
    }

    public void pn() {
    }

    public void pn(Object o) {
    }

    public void pln() {
    }

    public void pln (Object o) {
    }

    public void printLine() {
    }

    public void printLine(Object o) {
    }

    public void flush() {
    }

    public void close() {
    }

    public void exit() {
    }

    public boolean isSpace(int c) { return false; }

    public double readDouble() { return 0.0; }

    public int[] na(int n) {
        return new int[n];
    }

    public long[] nal(int n) {
        return new long[n];
    }

    public void iIA(int arr[]){
    }

    static int[] ari(int n)throws IOException
    {
        return new int[n];
    }
    static int[][] ari(int n,int m)throws IOException
    {
        return new int[n][m];
    }
    static long[] arl(int n)throws IOException
    {
        return new long[n];
    }
    static long[][] arl(int n,int m)throws IOException
    {
        return new long[n][m];
    }
    static String[] ars(int n)throws IOException
    {
        return new String[n];
    }
    static double[] ard(int n)throws IOException
    {
        return new double[n];
    }
    static double[][] ard(int n,int m)throws IOException
    {
        return new double[n][m];
    }
    static char[] arc(int n)throws IOException
    {
        return new char[n];
    }
    static char[][] arc(int n,int m)throws IOException
    {
        return new char[n][m];
    }
}
    

class MScanner {
    public MScanner() {
    }

    public MScanner(String s) {
    }

    public MScanner(InputStream stream) {
    }

    public MScanner(OutputStream outputStream) {
    }

    private char getChar() {
        return 'a';
    }

    public String input() {
        return null;
    }

    public boolean hasNext() {
        return false;
    }

    public String next() {
        return null;
    }

    public String nextToken() {
        return null;
    }

    public int nextInt() {
        return 0;
    }

    public long nextLong() {
        return 0;
    }

    public double nextDouble() {
        return 0.0;
    }

    public float nextFloat() {
        return Float.parseFloat(next());
    }

    public byte nextByte() {
        return (byte) 0;
    }

    public long[] nextLongs(int N) {
        return new long[0];
    }

    public double[] nextDoubles(int N) {
        return new double[0];
    }

    public String nextLine() {
        return null;
    }

    public int ni() {
        return 0;
    }

    public int[] ni(int n) {
        return new int[0];
    }

    public String readLine() {
        return null;
    }

    public int[] nextInts(int N) {
        return new int[0];
    }

    public int nint() {
        return 0;
    }

    public int in() {
        return 0;
    }

    public int ri() {
        return 0;
    }

    public int[] ri(int n) {
        return new int[0];
    }

    public int[] rai(int n) {
        return new int[0];
    }

    public int[] rai() {
        return new int[0];
    }

    public double nd() {
        return 0.0;
    }

    public long nl() {
        return 0;
    }

    public int[] nia(int n) {
        return new int[0];
    }

    public long[] nla(int n) {
        return new long[0];
    }

    public int i() {
        return 0;
    }

    public int[] i(int n) {
        return new int[0];
    }

    public long l() {
        return 0;
    }

    public long[] l(int n) {
        return new long[0];
    }

    public double d() {
        return 0.0;
    }

    public int[] nextIntArray(int n) {
        return new int[0];
    }

    public long[] nextLongArray(int n) {
        return new long[0];
    }

    public String[] nextStringArray(int n) {
        return new String[0];
    }

    public long[] lreadArray(int n) {
        return new long[0];
    }

    public long[] readArrayLong(int n) {
        return new long[0];
    }

    public int readInt() {
        return 0;
    }

    public String read() {
        return null;
    }

    public String readString() {
        return null;
    }

    public int[] readArray(int n) {
        return new int[0];
    }

    public long[] readLongArray(int n) {
        return new long[0];
    }

    public long[] arrLong(int n) {
        return new long[0];
    }

    public int[][] graph(int N, int[][] edges) {
        return new int[0][];
    }

    public int[] intArray(int N, int mod) {
        return new int[0];
    }

    public long[] longArray(int N, long mod) {
        return new long[0];
    }

    public MScanner write(byte b) {
        return null;
    }

    public MScanner write(char c) {
        return null;
    }

    public MScanner write(char[] s) {
        return null;
    }

    public MScanner write(String s) {
        return null;
    }

    public MScanner write(int x) {
        return null;
    }

    public void print(Object s) {
    }

    public void print(Object... objects) {
    }

    public void println(Object s) {
    }

    public void println(int i) {
    }

    public void println() {
    }

    public void printLine(Object... objects) {
    }

    public void printArray(int[] a) {
    }
    
    public void printlnArray(int[] a) {
    }
    
    public void printArray(long[] a) {
    }
    
    public void printlnArray(long[] a) {
    }

    public void p(Object o) {
    }

    public void p() {
    }

    public void ps(Object o) {
    }

    public void ps() {
    }

    public void pl(Object o) {
    }

    public void pl() {
    }

    public void pn() {
    }

    public void pn(Object o) {
    }

    public void pln() {
    }

    public void pln (Object o) {
    }

    public void printLine() {
    }

    public void printLine(Object o) {
    }

    public void flush() {
    }

    public void close() {
    }

    public void exit() {
    }

    public boolean isSpace(int c) { return false; }

    public double readDouble() { return 0.0; }

    public int[] na(int n) {
        return new int[n];
    }

    public long[] nal(int n) {
        return new long[n];
    }

    public void iIA(int arr[]){
    }

    static int[] ari(int n)throws IOException
    {
        return new int[n];
    }
    static int[][] ari(int n,int m)throws IOException
    {
        return new int[n][m];
    }
    static long[] arl(int n)throws IOException
    {
        return new long[n];
    }
    static long[][] arl(int n,int m)throws IOException
    {
        return new long[n][m];
    }
    static String[] ars(int n)throws IOException
    {
        return new String[n];
    }
    static double[] ard(int n)throws IOException
    {
        return new double[n];
    }
    static double[][] ard(int n,int m)throws IOException
    {
        return new double[n][m];
    }
    static char[] arc(int n)throws IOException
    {
        return new char[n];
    }
    static char[][] arc(int n,int m)throws IOException
    {
        return new char[n][m];
    }
}
    

class fastReader {
    public fastReader() {
    }

    public fastReader(String s) {
    }

    public fastReader(InputStream stream) {
    }

    public fastReader(OutputStream outputStream) {
    }

    private char getChar() {
        return 'a';
    }

    public String input() {
        return null;
    }

    public boolean hasNext() {
        return false;
    }

    public String next() {
        return null;
    }

    public String nextToken() {
        return null;
    }

    public int nextInt() {
        return 0;
    }

    public long nextLong() {
        return 0;
    }

    public double nextDouble() {
        return 0.0;
    }

    public float nextFloat() {
        return Float.parseFloat(next());
    }

    public byte nextByte() {
        return (byte) 0;
    }

    public long[] nextLongs(int N) {
        return new long[0];
    }

    public double[] nextDoubles(int N) {
        return new double[0];
    }

    public String nextLine() {
        return null;
    }

    public int ni() {
        return 0;
    }

    public int[] ni(int n) {
        return new int[0];
    }

    public String readLine() {
        return null;
    }

    public int[] nextInts(int N) {
        return new int[0];
    }

    public int nint() {
        return 0;
    }

    public int in() {
        return 0;
    }

    public int ri() {
        return 0;
    }

    public int[] ri(int n) {
        return new int[0];
    }

    public int[] rai(int n) {
        return new int[0];
    }

    public int[] rai() {
        return new int[0];
    }

    public double nd() {
        return 0.0;
    }

    public long nl() {
        return 0;
    }

    public int[] nia(int n) {
        return new int[0];
    }

    public long[] nla(int n) {
        return new long[0];
    }

    public int i() {
        return 0;
    }

    public int[] i(int n) {
        return new int[0];
    }

    public long l() {
        return 0;
    }

    public long[] l(int n) {
        return new long[0];
    }

    public double d() {
        return 0.0;
    }

    public int[] nextIntArray(int n) {
        return new int[0];
    }

    public long[] nextLongArray(int n) {
        return new long[0];
    }

    public String[] nextStringArray(int n) {
        return new String[0];
    }

    public long[] lreadArray(int n) {
        return new long[0];
    }

    public long[] readArrayLong(int n) {
        return new long[0];
    }

    public int readInt() {
        return 0;
    }

    public String read() {
        return null;
    }

    public String readString() {
        return null;
    }

    public int[] readArray(int n) {
        return new int[0];
    }

    public long[] readLongArray(int n) {
        return new long[0];
    }

    public long[] arrLong(int n) {
        return new long[0];
    }

    public int[][] graph(int N, int[][] edges) {
        return new int[0][];
    }

    public int[] intArray(int N, int mod) {
        return new int[0];
    }

    public long[] longArray(int N, long mod) {
        return new long[0];
    }

    public fastReader write(byte b) {
        return null;
    }

    public fastReader write(char c) {
        return null;
    }

    public fastReader write(char[] s) {
        return null;
    }

    public fastReader write(String s) {
        return null;
    }

    public fastReader write(int x) {
        return null;
    }

    public void print(Object s) {
    }

    public void print(Object... objects) {
    }

    public void println(Object s) {
    }

    public void println(int i) {
    }

    public void println() {
    }

    public void printLine(Object... objects) {
    }

    public void printArray(int[] a) {
    }
    
    public void printlnArray(int[] a) {
    }
    
    public void printArray(long[] a) {
    }
    
    public void printlnArray(long[] a) {
    }

    public void p(Object o) {
    }

    public void p() {
    }

    public void ps(Object o) {
    }

    public void ps() {
    }

    public void pl(Object o) {
    }

    public void pl() {
    }

    public void pn() {
    }

    public void pn(Object o) {
    }

    public void pln() {
    }

    public void pln (Object o) {
    }

    public void printLine() {
    }

    public void printLine(Object o) {
    }

    public void flush() {
    }

    public void close() {
    }

    public void exit() {
    }

    public boolean isSpace(int c) { return false; }

    public double readDouble() { return 0.0; }

    public int[] na(int n) {
        return new int[n];
    }

    public long[] nal(int n) {
        return new long[n];
    }

    public void iIA(int arr[]){
    }

    static int[] ari(int n)throws IOException
    {
        return new int[n];
    }
    static int[][] ari(int n,int m)throws IOException
    {
        return new int[n][m];
    }
    static long[] arl(int n)throws IOException
    {
        return new long[n];
    }
    static long[][] arl(int n,int m)throws IOException
    {
        return new long[n][m];
    }
    static String[] ars(int n)throws IOException
    {
        return new String[n];
    }
    static double[] ard(int n)throws IOException
    {
        return new double[n];
    }
    static double[][] ard(int n,int m)throws IOException
    {
        return new double[n][m];
    }
    static char[] arc(int n)throws IOException
    {
        return new char[n];
    }
    static char[][] arc(int n,int m)throws IOException
    {
        return new char[n][m];
    }
}
    

class FastReader {
    public FastReader() {
    }

    public FastReader(String s) {
    }

    public FastReader(InputStream stream) {
    }

    public FastReader(OutputStream outputStream) {
    }

    private char getChar() {
        return 'a';
    }

    public String input() {
        return null;
    }

    public boolean hasNext() {
        return false;
    }

    public String next() {
        return null;
    }

    public String nextToken() {
        return null;
    }

    public int nextInt() {
        return 0;
    }

    public long nextLong() {
        return 0;
    }

    public double nextDouble() {
        return 0.0;
    }

    public float nextFloat() {
        return Float.parseFloat(next());
    }

    public byte nextByte() {
        return (byte) 0;
    }

    public long[] nextLongs(int N) {
        return new long[0];
    }

    public double[] nextDoubles(int N) {
        return new double[0];
    }

    public String nextLine() {
        return null;
    }

    public int ni() {
        return 0;
    }

    public int[] ni(int n) {
        return new int[0];
    }

    public String readLine() {
        return null;
    }

    public int[] nextInts(int N) {
        return new int[0];
    }

    public int nint() {
        return 0;
    }

    public int in() {
        return 0;
    }

    public int ri() {
        return 0;
    }

    public int[] ri(int n) {
        return new int[0];
    }

    public int[] rai(int n) {
        return new int[0];
    }

    public int[] rai() {
        return new int[0];
    }

    public double nd() {
        return 0.0;
    }

    public long nl() {
        return 0;
    }

    public int[] nia(int n) {
        return new int[0];
    }

    public long[] nla(int n) {
        return new long[0];
    }

    public int i() {
        return 0;
    }

    public int[] i(int n) {
        return new int[0];
    }

    public long l() {
        return 0;
    }

    public long[] l(int n) {
        return new long[0];
    }

    public double d() {
        return 0.0;
    }

    public int[] nextIntArray(int n) {
        return new int[0];
    }

    public long[] nextLongArray(int n) {
        return new long[0];
    }

    public String[] nextStringArray(int n) {
        return new String[0];
    }

    public long[] lreadArray(int n) {
        return new long[0];
    }

    public long[] readArrayLong(int n) {
        return new long[0];
    }

    public int readInt() {
        return 0;
    }

    public String read() {
        return null;
    }

    public String readString() {
        return null;
    }

    public int[] readArray(int n) {
        return new int[0];
    }

    public long[] readLongArray(int n) {
        return new long[0];
    }

    public long[] arrLong(int n) {
        return new long[0];
    }

    public int[][] graph(int N, int[][] edges) {
        return new int[0][];
    }

    public int[] intArray(int N, int mod) {
        return new int[0];
    }

    public long[] longArray(int N, long mod) {
        return new long[0];
    }

    public FastReader write(byte b) {
        return null;
    }

    public FastReader write(char c) {
        return null;
    }

    public FastReader write(char[] s) {
        return null;
    }

    public FastReader write(String s) {
        return null;
    }

    public FastReader write(int x) {
        return null;
    }

    public void print(Object s) {
    }

    public void print(Object... objects) {
    }

    public void println(Object s) {
    }

    public void println(int i) {
    }

    public void println() {
    }

    public void printLine(Object... objects) {
    }

    public void printArray(int[] a) {
    }
    
    public void printlnArray(int[] a) {
    }
    
    public void printArray(long[] a) {
    }
    
    public void printlnArray(long[] a) {
    }

    public void p(Object o) {
    }

    public void p() {
    }

    public void ps(Object o) {
    }

    public void ps() {
    }

    public void pl(Object o) {
    }

    public void pl() {
    }

    public void pn() {
    }

    public void pn(Object o) {
    }

    public void pln() {
    }

    public void pln (Object o) {
    }

    public void printLine() {
    }

    public void printLine(Object o) {
    }

    public void flush() {
    }

    public void close() {
    }

    public void exit() {
    }

    public boolean isSpace(int c) { return false; }

    public double readDouble() { return 0.0; }

    public int[] na(int n) {
        return new int[n];
    }

    public long[] nal(int n) {
        return new long[n];
    }

    public void iIA(int arr[]){
    }

    static int[] ari(int n)throws IOException
    {
        return new int[n];
    }
    static int[][] ari(int n,int m)throws IOException
    {
        return new int[n][m];
    }
    static long[] arl(int n)throws IOException
    {
        return new long[n];
    }
    static long[][] arl(int n,int m)throws IOException
    {
        return new long[n][m];
    }
    static String[] ars(int n)throws IOException
    {
        return new String[n];
    }
    static double[] ard(int n)throws IOException
    {
        return new double[n];
    }
    static double[][] ard(int n,int m)throws IOException
    {
        return new double[n][m];
    }
    static char[] arc(int n)throws IOException
    {
        return new char[n];
    }
    static char[][] arc(int n,int m)throws IOException
    {
        return new char[n][m];
    }
}
    

class SwapScanner {
    public SwapScanner() {
    }

    public SwapScanner(String s) {
    }

    public SwapScanner(InputStream stream) {
    }

    public SwapScanner(OutputStream outputStream) {
    }

    private char getChar() {
        return 'a';
    }

    public String input() {
        return null;
    }

    public boolean hasNext() {
        return false;
    }

    public String next() {
        return null;
    }

    public String nextToken() {
        return null;
    }

    public int nextInt() {
        return 0;
    }

    public long nextLong() {
        return 0;
    }

    public double nextDouble() {
        return 0.0;
    }

    public float nextFloat() {
        return Float.parseFloat(next());
    }

    public byte nextByte() {
        return (byte) 0;
    }

    public long[] nextLongs(int N) {
        return new long[0];
    }

    public double[] nextDoubles(int N) {
        return new double[0];
    }

    public String nextLine() {
        return null;
    }

    public int ni() {
        return 0;
    }

    public int[] ni(int n) {
        return new int[0];
    }

    public String readLine() {
        return null;
    }

    public int[] nextInts(int N) {
        return new int[0];
    }

    public int nint() {
        return 0;
    }

    public int in() {
        return 0;
    }

    public int ri() {
        return 0;
    }

    public int[] ri(int n) {
        return new int[0];
    }

    public int[] rai(int n) {
        return new int[0];
    }

    public int[] rai() {
        return new int[0];
    }

    public double nd() {
        return 0.0;
    }

    public long nl() {
        return 0;
    }

    public int[] nia(int n) {
        return new int[0];
    }

    public long[] nla(int n) {
        return new long[0];
    }

    public int i() {
        return 0;
    }

    public int[] i(int n) {
        return new int[0];
    }

    public long l() {
        return 0;
    }

    public long[] l(int n) {
        return new long[0];
    }

    public double d() {
        return 0.0;
    }

    public int[] nextIntArray(int n) {
        return new int[0];
    }

    public long[] nextLongArray(int n) {
        return new long[0];
    }

    public String[] nextStringArray(int n) {
        return new String[0];
    }

    public long[] lreadArray(int n) {
        return new long[0];
    }

    public long[] readArrayLong(int n) {
        return new long[0];
    }

    public int readInt() {
        return 0;
    }

    public String read() {
        return null;
    }

    public String readString() {
        return null;
    }

    public int[] readArray(int n) {
        return new int[0];
    }

    public long[] readLongArray(int n) {
        return new long[0];
    }

    public long[] arrLong(int n) {
        return new long[0];
    }

    public int[][] graph(int N, int[][] edges) {
        return new int[0][];
    }

    public int[] intArray(int N, int mod) {
        return new int[0];
    }

    public long[] longArray(int N, long mod) {
        return new long[0];
    }

    public SwapScanner write(byte b) {
        return null;
    }

    public SwapScanner write(char c) {
        return null;
    }

    public SwapScanner write(char[] s) {
        return null;
    }

    public SwapScanner write(String s) {
        return null;
    }

    public SwapScanner write(int x) {
        return null;
    }

    public void print(Object s) {
    }

    public void print(Object... objects) {
    }

    public void println(Object s) {
    }

    public void println(int i) {
    }

    public void println() {
    }

    public void printLine(Object... objects) {
    }

    public void printArray(int[] a) {
    }
    
    public void printlnArray(int[] a) {
    }
    
    public void printArray(long[] a) {
    }
    
    public void printlnArray(long[] a) {
    }

    public void p(Object o) {
    }

    public void p() {
    }

    public void ps(Object o) {
    }

    public void ps() {
    }

    public void pl(Object o) {
    }

    public void pl() {
    }

    public void pn() {
    }

    public void pn(Object o) {
    }

    public void pln() {
    }

    public void pln (Object o) {
    }

    public void printLine() {
    }

    public void printLine(Object o) {
    }

    public void flush() {
    }

    public void close() {
    }

    public void exit() {
    }

    public boolean isSpace(int c) { return false; }

    public double readDouble() { return 0.0; }

    public int[] na(int n) {
        return new int[n];
    }

    public long[] nal(int n) {
        return new long[n];
    }

    public void iIA(int arr[]){
    }

    static int[] ari(int n)throws IOException
    {
        return new int[n];
    }
    static int[][] ari(int n,int m)throws IOException
    {
        return new int[n][m];
    }
    static long[] arl(int n)throws IOException
    {
        return new long[n];
    }
    static long[][] arl(int n,int m)throws IOException
    {
        return new long[n][m];
    }
    static String[] ars(int n)throws IOException
    {
        return new String[n];
    }
    static double[] ard(int n)throws IOException
    {
        return new double[n];
    }
    static double[][] ard(int n,int m)throws IOException
    {
        return new double[n][m];
    }
    static char[] arc(int n)throws IOException
    {
        return new char[n];
    }
    static char[][] arc(int n,int m)throws IOException
    {
        return new char[n][m];
    }
}
    

class Scanner {
    public Scanner() {
    }

    public Scanner(String s) {
    }

    public Scanner(InputStream stream) {
    }

    public Scanner(OutputStream outputStream) {
    }

    private char getChar() {
        return 'a';
    }

    public String input() {
        return null;
    }

    public boolean hasNext() {
        return false;
    }

    public String next() {
        return null;
    }

    public String nextToken() {
        return null;
    }

    public int nextInt() {
        return 0;
    }

    public long nextLong() {
        return 0;
    }

    public double nextDouble() {
        return 0.0;
    }

    public float nextFloat() {
        return Float.parseFloat(next());
    }

    public byte nextByte() {
        return (byte) 0;
    }

    public long[] nextLongs(int N) {
        return new long[0];
    }

    public double[] nextDoubles(int N) {
        return new double[0];
    }

    public String nextLine() {
        return null;
    }

    public int ni() {
        return 0;
    }

    public int[] ni(int n) {
        return new int[0];
    }

    public String readLine() {
        return null;
    }

    public int[] nextInts(int N) {
        return new int[0];
    }

    public int nint() {
        return 0;
    }

    public int in() {
        return 0;
    }

    public int ri() {
        return 0;
    }

    public int[] ri(int n) {
        return new int[0];
    }

    public int[] rai(int n) {
        return new int[0];
    }

    public int[] rai() {
        return new int[0];
    }

    public double nd() {
        return 0.0;
    }

    public long nl() {
        return 0;
    }

    public int[] nia(int n) {
        return new int[0];
    }

    public long[] nla(int n) {
        return new long[0];
    }

    public int i() {
        return 0;
    }

    public int[] i(int n) {
        return new int[0];
    }

    public long l() {
        return 0;
    }

    public long[] l(int n) {
        return new long[0];
    }

    public double d() {
        return 0.0;
    }

    public int[] nextIntArray(int n) {
        return new int[0];
    }

    public long[] nextLongArray(int n) {
        return new long[0];
    }

    public String[] nextStringArray(int n) {
        return new String[0];
    }

    public long[] lreadArray(int n) {
        return new long[0];
    }

    public long[] readArrayLong(int n) {
        return new long[0];
    }

    public int readInt() {
        return 0;
    }

    public String read() {
        return null;
    }

    public String readString() {
        return null;
    }

    public int[] readArray(int n) {
        return new int[0];
    }

    public long[] readLongArray(int n) {
        return new long[0];
    }

    public long[] arrLong(int n) {
        return new long[0];
    }

    public int[][] graph(int N, int[][] edges) {
        return new int[0][];
    }

    public int[] intArray(int N, int mod) {
        return new int[0];
    }

    public long[] longArray(int N, long mod) {
        return new long[0];
    }

    public Scanner write(byte b) {
        return null;
    }

    public Scanner write(char c) {
        return null;
    }

    public Scanner write(char[] s) {
        return null;
    }

    public Scanner write(String s) {
        return null;
    }

    public Scanner write(int x) {
        return null;
    }

    public void print(Object s) {
    }

    public void print(Object... objects) {
    }

    public void println(Object s) {
    }

    public void println(int i) {
    }

    public void println() {
    }

    public void printLine(Object... objects) {
    }

    public void printArray(int[] a) {
    }
    
    public void printlnArray(int[] a) {
    }
    
    public void printArray(long[] a) {
    }
    
    public void printlnArray(long[] a) {
    }

    public void p(Object o) {
    }

    public void p() {
    }

    public void ps(Object o) {
    }

    public void ps() {
    }

    public void pl(Object o) {
    }

    public void pl() {
    }

    public void pn() {
    }

    public void pn(Object o) {
    }

    public void pln() {
    }

    public void pln (Object o) {
    }

    public void printLine() {
    }

    public void printLine(Object o) {
    }

    public void flush() {
    }

    public void close() {
    }

    public void exit() {
    }

    public boolean isSpace(int c) { return false; }

    public double readDouble() { return 0.0; }

    public int[] na(int n) {
        return new int[n];
    }

    public long[] nal(int n) {
        return new long[n];
    }

    public void iIA(int arr[]){
    }

    static int[] ari(int n)throws IOException
    {
        return new int[n];
    }
    static int[][] ari(int n,int m)throws IOException
    {
        return new int[n][m];
    }
    static long[] arl(int n)throws IOException
    {
        return new long[n];
    }
    static long[][] arl(int n,int m)throws IOException
    {
        return new long[n][m];
    }
    static String[] ars(int n)throws IOException
    {
        return new String[n];
    }
    static double[] ard(int n)throws IOException
    {
        return new double[n];
    }
    static double[][] ard(int n,int m)throws IOException
    {
        return new double[n][m];
    }
    static char[] arc(int n)throws IOException
    {
        return new char[n];
    }
    static char[][] arc(int n,int m)throws IOException
    {
        return new char[n][m];
    }
}
    

class FastScanner {
    public FastScanner() {
    }

    public FastScanner(String s) {
    }

    public FastScanner(InputStream stream) {
    }

    public FastScanner(OutputStream outputStream) {
    }

    private char getChar() {
        return 'a';
    }

    public String input() {
        return null;
    }

    public boolean hasNext() {
        return false;
    }

    public String next() {
        return null;
    }

    public String nextToken() {
        return null;
    }

    public int nextInt() {
        return 0;
    }

    public long nextLong() {
        return 0;
    }

    public double nextDouble() {
        return 0.0;
    }

    public float nextFloat() {
        return Float.parseFloat(next());
    }

    public byte nextByte() {
        return (byte) 0;
    }

    public long[] nextLongs(int N) {
        return new long[0];
    }

    public double[] nextDoubles(int N) {
        return new double[0];
    }

    public String nextLine() {
        return null;
    }

    public int ni() {
        return 0;
    }

    public int[] ni(int n) {
        return new int[0];
    }

    public String readLine() {
        return null;
    }

    public int[] nextInts(int N) {
        return new int[0];
    }

    public int nint() {
        return 0;
    }

    public int in() {
        return 0;
    }

    public int ri() {
        return 0;
    }

    public int[] ri(int n) {
        return new int[0];
    }

    public int[] rai(int n) {
        return new int[0];
    }

    public int[] rai() {
        return new int[0];
    }

    public double nd() {
        return 0.0;
    }

    public long nl() {
        return 0;
    }

    public int[] nia(int n) {
        return new int[0];
    }

    public long[] nla(int n) {
        return new long[0];
    }

    public int i() {
        return 0;
    }

    public int[] i(int n) {
        return new int[0];
    }

    public long l() {
        return 0;
    }

    public long[] l(int n) {
        return new long[0];
    }

    public double d() {
        return 0.0;
    }

    public int[] nextIntArray(int n) {
        return new int[0];
    }

    public long[] nextLongArray(int n) {
        return new long[0];
    }

    public String[] nextStringArray(int n) {
        return new String[0];
    }

    public long[] lreadArray(int n) {
        return new long[0];
    }

    public long[] readArrayLong(int n) {
        return new long[0];
    }

    public int readInt() {
        return 0;
    }

    public String read() {
        return null;
    }

    public String readString() {
        return null;
    }

    public int[] readArray(int n) {
        return new int[0];
    }

    public long[] readLongArray(int n) {
        return new long[0];
    }

    public long[] arrLong(int n) {
        return new long[0];
    }

    public int[][] graph(int N, int[][] edges) {
        return new int[0][];
    }

    public int[] intArray(int N, int mod) {
        return new int[0];
    }

    public long[] longArray(int N, long mod) {
        return new long[0];
    }

    public FastScanner write(byte b) {
        return null;
    }

    public FastScanner write(char c) {
        return null;
    }

    public FastScanner write(char[] s) {
        return null;
    }

    public FastScanner write(String s) {
        return null;
    }

    public FastScanner write(int x) {
        return null;
    }

    public void print(Object s) {
    }

    public void print(Object... objects) {
    }

    public void println(Object s) {
    }

    public void println(int i) {
    }

    public void println() {
    }

    public void printLine(Object... objects) {
    }

    public void printArray(int[] a) {
    }
    
    public void printlnArray(int[] a) {
    }
    
    public void printArray(long[] a) {
    }
    
    public void printlnArray(long[] a) {
    }

    public void p(Object o) {
    }

    public void p() {
    }

    public void ps(Object o) {
    }

    public void ps() {
    }

    public void pl(Object o) {
    }

    public void pl() {
    }

    public void pn() {
    }

    public void pn(Object o) {
    }

    public void pln() {
    }

    public void pln (Object o) {
    }

    public void printLine() {
    }

    public void printLine(Object o) {
    }

    public void flush() {
    }

    public void close() {
    }

    public void exit() {
    }

    public boolean isSpace(int c) { return false; }

    public double readDouble() { return 0.0; }

    public int[] na(int n) {
        return new int[n];
    }

    public long[] nal(int n) {
        return new long[n];
    }

    public void iIA(int arr[]){
    }

    static int[] ari(int n)throws IOException
    {
        return new int[n];
    }
    static int[][] ari(int n,int m)throws IOException
    {
        return new int[n][m];
    }
    static long[] arl(int n)throws IOException
    {
        return new long[n];
    }
    static long[][] arl(int n,int m)throws IOException
    {
        return new long[n][m];
    }
    static String[] ars(int n)throws IOException
    {
        return new String[n];
    }
    static double[] ard(int n)throws IOException
    {
        return new double[n];
    }
    static double[][] ard(int n,int m)throws IOException
    {
        return new double[n][m];
    }
    static char[] arc(int n)throws IOException
    {
        return new char[n];
    }
    static char[][] arc(int n,int m)throws IOException
    {
        return new char[n][m];
    }
}
    

class OutputWriter {
    public OutputWriter() {
    }

    public OutputWriter(String s) {
    }

    public OutputWriter(InputStream stream) {
    }

    public OutputWriter(OutputStream outputStream) {
    }

    private char getChar() {
        return 'a';
    }

    public String input() {
        return null;
    }

    public boolean hasNext() {
        return false;
    }

    public String next() {
        return null;
    }

    public String nextToken() {
        return null;
    }

    public int nextInt() {
        return 0;
    }

    public long nextLong() {
        return 0;
    }

    public double nextDouble() {
        return 0.0;
    }

    public float nextFloat() {
        return Float.parseFloat(next());
    }

    public byte nextByte() {
        return (byte) 0;
    }

    public long[] nextLongs(int N) {
        return new long[0];
    }

    public double[] nextDoubles(int N) {
        return new double[0];
    }

    public String nextLine() {
        return null;
    }

    public int ni() {
        return 0;
    }

    public int[] ni(int n) {
        return new int[0];
    }

    public String readLine() {
        return null;
    }

    public int[] nextInts(int N) {
        return new int[0];
    }

    public int nint() {
        return 0;
    }

    public int in() {
        return 0;
    }

    public int ri() {
        return 0;
    }

    public int[] ri(int n) {
        return new int[0];
    }

    public int[] rai(int n) {
        return new int[0];
    }

    public int[] rai() {
        return new int[0];
    }

    public double nd() {
        return 0.0;
    }

    public long nl() {
        return 0;
    }

    public int[] nia(int n) {
        return new int[0];
    }

    public long[] nla(int n) {
        return new long[0];
    }

    public int i() {
        return 0;
    }

    public int[] i(int n) {
        return new int[0];
    }

    public long l() {
        return 0;
    }

    public long[] l(int n) {
        return new long[0];
    }

    public double d() {
        return 0.0;
    }

    public int[] nextIntArray(int n) {
        return new int[0];
    }

    public long[] nextLongArray(int n) {
        return new long[0];
    }

    public String[] nextStringArray(int n) {
        return new String[0];
    }

    public long[] lreadArray(int n) {
        return new long[0];
    }

    public long[] readArrayLong(int n) {
        return new long[0];
    }

    public int readInt() {
        return 0;
    }

    public String read() {
        return null;
    }

    public String readString() {
        return null;
    }

    public int[] readArray(int n) {
        return new int[0];
    }

    public long[] readLongArray(int n) {
        return new long[0];
    }

    public long[] arrLong(int n) {
        return new long[0];
    }

    public int[][] graph(int N, int[][] edges) {
        return new int[0][];
    }

    public int[] intArray(int N, int mod) {
        return new int[0];
    }

    public long[] longArray(int N, long mod) {
        return new long[0];
    }

    public OutputWriter write(byte b) {
        return null;
    }

    public OutputWriter write(char c) {
        return null;
    }

    public OutputWriter write(char[] s) {
        return null;
    }

    public OutputWriter write(String s) {
        return null;
    }

    public OutputWriter write(int x) {
        return null;
    }

    public void print(Object s) {
    }

    public void print(Object... objects) {
    }

    public void println(Object s) {
    }

    public void println(int i) {
    }

    public void println() {
    }

    public void printLine(Object... objects) {
    }

    public void printArray(int[] a) {
    }
    
    public void printlnArray(int[] a) {
    }
    
    public void printArray(long[] a) {
    }
    
    public void printlnArray(long[] a) {
    }

    public void p(Object o) {
    }

    public void p() {
    }

    public void ps(Object o) {
    }

    public void ps() {
    }

    public void pl(Object o) {
    }

    public void pl() {
    }

    public void pn() {
    }

    public void pn(Object o) {
    }

    public void pln() {
    }

    public void pln (Object o) {
    }

    public void printLine() {
    }

    public void printLine(Object o) {
    }

    public void flush() {
    }

    public void close() {
    }

    public void exit() {
    }

    public boolean isSpace(int c) { return false; }

    public double readDouble() { return 0.0; }

    public int[] na(int n) {
        return new int[n];
    }

    public long[] nal(int n) {
        return new long[n];
    }

    public void iIA(int arr[]){
    }

    static int[] ari(int n)throws IOException
    {
        return new int[n];
    }
    static int[][] ari(int n,int m)throws IOException
    {
        return new int[n][m];
    }
    static long[] arl(int n)throws IOException
    {
        return new long[n];
    }
    static long[][] arl(int n,int m)throws IOException
    {
        return new long[n][m];
    }
    static String[] ars(int n)throws IOException
    {
        return new String[n];
    }
    static double[] ard(int n)throws IOException
    {
        return new double[n];
    }
    static double[][] ard(int n,int m)throws IOException
    {
        return new double[n][m];
    }
    static char[] arc(int n)throws IOException
    {
        return new char[n];
    }
    static char[][] arc(int n,int m)throws IOException
    {
        return new char[n][m];
    }
}
    

class FastestReader {
    public FastestReader() {
    }

    public FastestReader(String s) {
    }

    public FastestReader(InputStream stream) {
    }

    public FastestReader(OutputStream outputStream) {
    }

    private char getChar() {
        return 'a';
    }

    public String input() {
        return null;
    }

    public boolean hasNext() {
        return false;
    }

    public String next() {
        return null;
    }

    public String nextToken() {
        return null;
    }

    public int nextInt() {
        return 0;
    }

    public long nextLong() {
        return 0;
    }

    public double nextDouble() {
        return 0.0;
    }

    public float nextFloat() {
        return Float.parseFloat(next());
    }

    public byte nextByte() {
        return (byte) 0;
    }

    public long[] nextLongs(int N) {
        return new long[0];
    }

    public double[] nextDoubles(int N) {
        return new double[0];
    }

    public String nextLine() {
        return null;
    }

    public int ni() {
        return 0;
    }

    public int[] ni(int n) {
        return new int[0];
    }

    public String readLine() {
        return null;
    }

    public int[] nextInts(int N) {
        return new int[0];
    }

    public int nint() {
        return 0;
    }

    public int in() {
        return 0;
    }

    public int ri() {
        return 0;
    }

    public int[] ri(int n) {
        return new int[0];
    }

    public int[] rai(int n) {
        return new int[0];
    }

    public int[] rai() {
        return new int[0];
    }

    public double nd() {
        return 0.0;
    }

    public long nl() {
        return 0;
    }

    public int[] nia(int n) {
        return new int[0];
    }

    public long[] nla(int n) {
        return new long[0];
    }

    public int i() {
        return 0;
    }

    public int[] i(int n) {
        return new int[0];
    }

    public long l() {
        return 0;
    }

    public long[] l(int n) {
        return new long[0];
    }

    public double d() {
        return 0.0;
    }

    public int[] nextIntArray(int n) {
        return new int[0];
    }

    public long[] nextLongArray(int n) {
        return new long[0];
    }

    public String[] nextStringArray(int n) {
        return new String[0];
    }

    public long[] lreadArray(int n) {
        return new long[0];
    }

    public long[] readArrayLong(int n) {
        return new long[0];
    }

    public int readInt() {
        return 0;
    }

    public String read() {
        return null;
    }

    public String readString() {
        return null;
    }

    public int[] readArray(int n) {
        return new int[0];
    }

    public long[] readLongArray(int n) {
        return new long[0];
    }

    public long[] arrLong(int n) {
        return new long[0];
    }

    public int[][] graph(int N, int[][] edges) {
        return new int[0][];
    }

    public int[] intArray(int N, int mod) {
        return new int[0];
    }

    public long[] longArray(int N, long mod) {
        return new long[0];
    }

    public FastestReader write(byte b) {
        return null;
    }

    public FastestReader write(char c) {
        return null;
    }

    public FastestReader write(char[] s) {
        return null;
    }

    public FastestReader write(String s) {
        return null;
    }

    public FastestReader write(int x) {
        return null;
    }

    public void print(Object s) {
    }

    public void print(Object... objects) {
    }

    public void println(Object s) {
    }

    public void println(int i) {
    }

    public void println() {
    }

    public void printLine(Object... objects) {
    }

    public void printArray(int[] a) {
    }
    
    public void printlnArray(int[] a) {
    }
    
    public void printArray(long[] a) {
    }
    
    public void printlnArray(long[] a) {
    }

    public void p(Object o) {
    }

    public void p() {
    }

    public void ps(Object o) {
    }

    public void ps() {
    }

    public void pl(Object o) {
    }

    public void pl() {
    }

    public void pn() {
    }

    public void pn(Object o) {
    }

    public void pln() {
    }

    public void pln (Object o) {
    }

    public void printLine() {
    }

    public void printLine(Object o) {
    }

    public void flush() {
    }

    public void close() {
    }

    public void exit() {
    }

    public boolean isSpace(int c) { return false; }

    public double readDouble() { return 0.0; }

    public int[] na(int n) {
        return new int[n];
    }

    public long[] nal(int n) {
        return new long[n];
    }

    public void iIA(int arr[]){
    }

    static int[] ari(int n)throws IOException
    {
        return new int[n];
    }
    static int[][] ari(int n,int m)throws IOException
    {
        return new int[n][m];
    }
    static long[] arl(int n)throws IOException
    {
        return new long[n];
    }
    static long[][] arl(int n,int m)throws IOException
    {
        return new long[n][m];
    }
    static String[] ars(int n)throws IOException
    {
        return new String[n];
    }
    static double[] ard(int n)throws IOException
    {
        return new double[n];
    }
    static double[][] ard(int n,int m)throws IOException
    {
        return new double[n][m];
    }
    static char[] arc(int n)throws IOException
    {
        return new char[n];
    }
    static char[][] arc(int n,int m)throws IOException
    {
        return new char[n][m];
    }
}
    

class HritikScanner {
    public HritikScanner() {
    }

    public HritikScanner(String s) {
    }

    public HritikScanner(InputStream stream) {
    }

    public HritikScanner(OutputStream outputStream) {
    }

    private char getChar() {
        return 'a';
    }

    public String input() {
        return null;
    }

    public boolean hasNext() {
        return false;
    }

    public String next() {
        return null;
    }

    public String nextToken() {
        return null;
    }

    public int nextInt() {
        return 0;
    }

    public long nextLong() {
        return 0;
    }

    public double nextDouble() {
        return 0.0;
    }

    public float nextFloat() {
        return Float.parseFloat(next());
    }

    public byte nextByte() {
        return (byte) 0;
    }

    public long[] nextLongs(int N) {
        return new long[0];
    }

    public double[] nextDoubles(int N) {
        return new double[0];
    }

    public String nextLine() {
        return null;
    }

    public int ni() {
        return 0;
    }

    public int[] ni(int n) {
        return new int[0];
    }

    public String readLine() {
        return null;
    }

    public int[] nextInts(int N) {
        return new int[0];
    }

    public int nint() {
        return 0;
    }

    public int in() {
        return 0;
    }

    public int ri() {
        return 0;
    }

    public int[] ri(int n) {
        return new int[0];
    }

    public int[] rai(int n) {
        return new int[0];
    }

    public int[] rai() {
        return new int[0];
    }

    public double nd() {
        return 0.0;
    }

    public long nl() {
        return 0;
    }

    public int[] nia(int n) {
        return new int[0];
    }

    public long[] nla(int n) {
        return new long[0];
    }

    public int i() {
        return 0;
    }

    public int[] i(int n) {
        return new int[0];
    }

    public long l() {
        return 0;
    }

    public long[] l(int n) {
        return new long[0];
    }

    public double d() {
        return 0.0;
    }

    public int[] nextIntArray(int n) {
        return new int[0];
    }

    public long[] nextLongArray(int n) {
        return new long[0];
    }

    public String[] nextStringArray(int n) {
        return new String[0];
    }

    public long[] lreadArray(int n) {
        return new long[0];
    }

    public long[] readArrayLong(int n) {
        return new long[0];
    }

    public int readInt() {
        return 0;
    }

    public String read() {
        return null;
    }

    public String readString() {
        return null;
    }

    public int[] readArray(int n) {
        return new int[0];
    }

    public long[] readLongArray(int n) {
        return new long[0];
    }

    public long[] arrLong(int n) {
        return new long[0];
    }

    public int[][] graph(int N, int[][] edges) {
        return new int[0][];
    }

    public int[] intArray(int N, int mod) {
        return new int[0];
    }

    public long[] longArray(int N, long mod) {
        return new long[0];
    }

    public HritikScanner write(byte b) {
        return null;
    }

    public HritikScanner write(char c) {
        return null;
    }

    public HritikScanner write(char[] s) {
        return null;
    }

    public HritikScanner write(String s) {
        return null;
    }

    public HritikScanner write(int x) {
        return null;
    }

    public void print(Object s) {
    }

    public void print(Object... objects) {
    }

    public void println(Object s) {
    }

    public void println(int i) {
    }

    public void println() {
    }

    public void printLine(Object... objects) {
    }

    public void printArray(int[] a) {
    }
    
    public void printlnArray(int[] a) {
    }
    
    public void printArray(long[] a) {
    }
    
    public void printlnArray(long[] a) {
    }

    public void p(Object o) {
    }

    public void p() {
    }

    public void ps(Object o) {
    }

    public void ps() {
    }

    public void pl(Object o) {
    }

    public void pl() {
    }

    public void pn() {
    }

    public void pn(Object o) {
    }

    public void pln() {
    }

    public void pln (Object o) {
    }

    public void printLine() {
    }

    public void printLine(Object o) {
    }

    public void flush() {
    }

    public void close() {
    }

    public void exit() {
    }

    public boolean isSpace(int c) { return false; }

    public double readDouble() { return 0.0; }

    public int[] na(int n) {
        return new int[n];
    }

    public long[] nal(int n) {
        return new long[n];
    }

    public void iIA(int arr[]){
    }

    static int[] ari(int n)throws IOException
    {
        return new int[n];
    }
    static int[][] ari(int n,int m)throws IOException
    {
        return new int[n][m];
    }
    static long[] arl(int n)throws IOException
    {
        return new long[n];
    }
    static long[][] arl(int n,int m)throws IOException
    {
        return new long[n][m];
    }
    static String[] ars(int n)throws IOException
    {
        return new String[n];
    }
    static double[] ard(int n)throws IOException
    {
        return new double[n];
    }
    static double[][] ard(int n,int m)throws IOException
    {
        return new double[n][m];
    }
    static char[] arc(int n)throws IOException
    {
        return new char[n];
    }
    static char[][] arc(int n,int m)throws IOException
    {
        return new char[n][m];
    }
}
    

class FScanner {
    public FScanner() {
    }

    public FScanner(String s) {
    }

    public FScanner(InputStream stream) {
    }

    public FScanner(OutputStream outputStream) {
    }

    private char getChar() {
        return 'a';
    }

    public String input() {
        return null;
    }

    public boolean hasNext() {
        return false;
    }

    public String next() {
        return null;
    }

    public String nextToken() {
        return null;
    }

    public int nextInt() {
        return 0;
    }

    public long nextLong() {
        return 0;
    }

    public double nextDouble() {
        return 0.0;
    }

    public float nextFloat() {
        return Float.parseFloat(next());
    }

    public byte nextByte() {
        return (byte) 0;
    }

    public long[] nextLongs(int N) {
        return new long[0];
    }

    public double[] nextDoubles(int N) {
        return new double[0];
    }

    public String nextLine() {
        return null;
    }

    public int ni() {
        return 0;
    }

    public int[] ni(int n) {
        return new int[0];
    }

    public String readLine() {
        return null;
    }

    public int[] nextInts(int N) {
        return new int[0];
    }

    public int nint() {
        return 0;
    }

    public int in() {
        return 0;
    }

    public int ri() {
        return 0;
    }

    public int[] ri(int n) {
        return new int[0];
    }

    public int[] rai(int n) {
        return new int[0];
    }

    public int[] rai() {
        return new int[0];
    }

    public double nd() {
        return 0.0;
    }

    public long nl() {
        return 0;
    }

    public int[] nia(int n) {
        return new int[0];
    }

    public long[] nla(int n) {
        return new long[0];
    }

    public int i() {
        return 0;
    }

    public int[] i(int n) {
        return new int[0];
    }

    public long l() {
        return 0;
    }

    public long[] l(int n) {
        return new long[0];
    }

    public double d() {
        return 0.0;
    }

    public int[] nextIntArray(int n) {
        return new int[0];
    }

    public long[] nextLongArray(int n) {
        return new long[0];
    }

    public String[] nextStringArray(int n) {
        return new String[0];
    }

    public long[] lreadArray(int n) {
        return new long[0];
    }

    public long[] readArrayLong(int n) {
        return new long[0];
    }

    public int readInt() {
        return 0;
    }

    public String read() {
        return null;
    }

    public String readString() {
        return null;
    }

    public int[] readArray(int n) {
        return new int[0];
    }

    public long[] readLongArray(int n) {
        return new long[0];
    }

    public long[] arrLong(int n) {
        return new long[0];
    }

    public int[][] graph(int N, int[][] edges) {
        return new int[0][];
    }

    public int[] intArray(int N, int mod) {
        return new int[0];
    }

    public long[] longArray(int N, long mod) {
        return new long[0];
    }

    public FScanner write(byte b) {
        return null;
    }

    public FScanner write(char c) {
        return null;
    }

    public FScanner write(char[] s) {
        return null;
    }

    public FScanner write(String s) {
        return null;
    }

    public FScanner write(int x) {
        return null;
    }

    public void print(Object s) {
    }

    public void print(Object... objects) {
    }

    public void println(Object s) {
    }

    public void println(int i) {
    }

    public void println() {
    }

    public void printLine(Object... objects) {
    }

    public void printArray(int[] a) {
    }
    
    public void printlnArray(int[] a) {
    }
    
    public void printArray(long[] a) {
    }
    
    public void printlnArray(long[] a) {
    }

    public void p(Object o) {
    }

    public void p() {
    }

    public void ps(Object o) {
    }

    public void ps() {
    }

    public void pl(Object o) {
    }

    public void pl() {
    }

    public void pn() {
    }

    public void pn(Object o) {
    }

    public void pln() {
    }

    public void pln (Object o) {
    }

    public void printLine() {
    }

    public void printLine(Object o) {
    }

    public void flush() {
    }

    public void close() {
    }

    public void exit() {
    }

    public boolean isSpace(int c) { return false; }

    public double readDouble() { return 0.0; }

    public int[] na(int n) {
        return new int[n];
    }

    public long[] nal(int n) {
        return new long[n];
    }

    public void iIA(int arr[]){
    }

    static int[] ari(int n)throws IOException
    {
        return new int[n];
    }
    static int[][] ari(int n,int m)throws IOException
    {
        return new int[n][m];
    }
    static long[] arl(int n)throws IOException
    {
        return new long[n];
    }
    static long[][] arl(int n,int m)throws IOException
    {
        return new long[n][m];
    }
    static String[] ars(int n)throws IOException
    {
        return new String[n];
    }
    static double[] ard(int n)throws IOException
    {
        return new double[n];
    }
    static double[][] ard(int n,int m)throws IOException
    {
        return new double[n][m];
    }
    static char[] arc(int n)throws IOException
    {
        return new char[n];
    }
    static char[][] arc(int n,int m)throws IOException
    {
        return new char[n][m];
    }
}
    

class MyScanner {
    public MyScanner() {
    }

    public MyScanner(String s) {
    }

    public MyScanner(InputStream stream) {
    }

    public MyScanner(OutputStream outputStream) {
    }

    private char getChar() {
        return 'a';
    }

    public String input() {
        return null;
    }

    public boolean hasNext() {
        return false;
    }

    public String next() {
        return null;
    }

    public String nextToken() {
        return null;
    }

    public int nextInt() {
        return 0;
    }

    public long nextLong() {
        return 0;
    }

    public double nextDouble() {
        return 0.0;
    }

    public float nextFloat() {
        return Float.parseFloat(next());
    }

    public byte nextByte() {
        return (byte) 0;
    }

    public long[] nextLongs(int N) {
        return new long[0];
    }

    public double[] nextDoubles(int N) {
        return new double[0];
    }

    public String nextLine() {
        return null;
    }

    public int ni() {
        return 0;
    }

    public int[] ni(int n) {
        return new int[0];
    }

    public String readLine() {
        return null;
    }

    public int[] nextInts(int N) {
        return new int[0];
    }

    public int nint() {
        return 0;
    }

    public int in() {
        return 0;
    }

    public int ri() {
        return 0;
    }

    public int[] ri(int n) {
        return new int[0];
    }

    public int[] rai(int n) {
        return new int[0];
    }

    public int[] rai() {
        return new int[0];
    }

    public double nd() {
        return 0.0;
    }

    public long nl() {
        return 0;
    }

    public int[] nia(int n) {
        return new int[0];
    }

    public long[] nla(int n) {
        return new long[0];
    }

    public int i() {
        return 0;
    }

    public int[] i(int n) {
        return new int[0];
    }

    public long l() {
        return 0;
    }

    public long[] l(int n) {
        return new long[0];
    }

    public double d() {
        return 0.0;
    }

    public int[] nextIntArray(int n) {
        return new int[0];
    }

    public long[] nextLongArray(int n) {
        return new long[0];
    }

    public String[] nextStringArray(int n) {
        return new String[0];
    }

    public long[] lreadArray(int n) {
        return new long[0];
    }

    public long[] readArrayLong(int n) {
        return new long[0];
    }

    public int readInt() {
        return 0;
    }

    public String read() {
        return null;
    }

    public String readString() {
        return null;
    }

    public int[] readArray(int n) {
        return new int[0];
    }

    public long[] readLongArray(int n) {
        return new long[0];
    }

    public long[] arrLong(int n) {
        return new long[0];
    }

    public int[][] graph(int N, int[][] edges) {
        return new int[0][];
    }

    public int[] intArray(int N, int mod) {
        return new int[0];
    }

    public long[] longArray(int N, long mod) {
        return new long[0];
    }

    public MyScanner write(byte b) {
        return null;
    }

    public MyScanner write(char c) {
        return null;
    }

    public MyScanner write(char[] s) {
        return null;
    }

    public MyScanner write(String s) {
        return null;
    }

    public MyScanner write(int x) {
        return null;
    }

    public void print(Object s) {
    }

    public void print(Object... objects) {
    }

    public void println(Object s) {
    }

    public void println(int i) {
    }

    public void println() {
    }

    public void printLine(Object... objects) {
    }

    public void printArray(int[] a) {
    }
    
    public void printlnArray(int[] a) {
    }
    
    public void printArray(long[] a) {
    }
    
    public void printlnArray(long[] a) {
    }

    public void p(Object o) {
    }

    public void p() {
    }

    public void ps(Object o) {
    }

    public void ps() {
    }

    public void pl(Object o) {
    }

    public void pl() {
    }

    public void pn() {
    }

    public void pn(Object o) {
    }

    public void pln() {
    }

    public void pln (Object o) {
    }

    public void printLine() {
    }

    public void printLine(Object o) {
    }

    public void flush() {
    }

    public void close() {
    }

    public void exit() {
    }

    public boolean isSpace(int c) { return false; }

    public double readDouble() { return 0.0; }

    public int[] na(int n) {
        return new int[n];
    }

    public long[] nal(int n) {
        return new long[n];
    }

    public void iIA(int arr[]){
    }

    static int[] ari(int n)throws IOException
    {
        return new int[n];
    }
    static int[][] ari(int n,int m)throws IOException
    {
        return new int[n][m];
    }
    static long[] arl(int n)throws IOException
    {
        return new long[n];
    }
    static long[][] arl(int n,int m)throws IOException
    {
        return new long[n][m];
    }
    static String[] ars(int n)throws IOException
    {
        return new String[n];
    }
    static double[] ard(int n)throws IOException
    {
        return new double[n];
    }
    static double[][] ard(int n,int m)throws IOException
    {
        return new double[n][m];
    }
    static char[] arc(int n)throws IOException
    {
        return new char[n];
    }
    static char[][] arc(int n,int m)throws IOException
    {
        return new char[n][m];
    }
}
    

class SpeedScanner {
    public SpeedScanner() {
    }

    public SpeedScanner(String s) {
    }

    public SpeedScanner(InputStream stream) {
    }

    public SpeedScanner(OutputStream outputStream) {
    }

    private char getChar() {
        return 'a';
    }

    public String input() {
        return null;
    }

    public boolean hasNext() {
        return false;
    }

    public String next() {
        return null;
    }

    public String nextToken() {
        return null;
    }

    public int nextInt() {
        return 0;
    }

    public long nextLong() {
        return 0;
    }

    public double nextDouble() {
        return 0.0;
    }

    public float nextFloat() {
        return Float.parseFloat(next());
    }

    public byte nextByte() {
        return (byte) 0;
    }

    public long[] nextLongs(int N) {
        return new long[0];
    }

    public double[] nextDoubles(int N) {
        return new double[0];
    }

    public String nextLine() {
        return null;
    }

    public int ni() {
        return 0;
    }

    public int[] ni(int n) {
        return new int[0];
    }

    public String readLine() {
        return null;
    }

    public int[] nextInts(int N) {
        return new int[0];
    }

    public int nint() {
        return 0;
    }

    public int in() {
        return 0;
    }

    public int ri() {
        return 0;
    }

    public int[] ri(int n) {
        return new int[0];
    }

    public int[] rai(int n) {
        return new int[0];
    }

    public int[] rai() {
        return new int[0];
    }

    public double nd() {
        return 0.0;
    }

    public long nl() {
        return 0;
    }

    public int[] nia(int n) {
        return new int[0];
    }

    public long[] nla(int n) {
        return new long[0];
    }

    public int i() {
        return 0;
    }

    public int[] i(int n) {
        return new int[0];
    }

    public long l() {
        return 0;
    }

    public long[] l(int n) {
        return new long[0];
    }

    public double d() {
        return 0.0;
    }

    public int[] nextIntArray(int n) {
        return new int[0];
    }

    public long[] nextLongArray(int n) {
        return new long[0];
    }

    public String[] nextStringArray(int n) {
        return new String[0];
    }

    public long[] lreadArray(int n) {
        return new long[0];
    }

    public long[] readArrayLong(int n) {
        return new long[0];
    }

    public int readInt() {
        return 0;
    }

    public String read() {
        return null;
    }

    public String readString() {
        return null;
    }

    public int[] readArray(int n) {
        return new int[0];
    }

    public long[] readLongArray(int n) {
        return new long[0];
    }

    public long[] arrLong(int n) {
        return new long[0];
    }

    public int[][] graph(int N, int[][] edges) {
        return new int[0][];
    }

    public int[] intArray(int N, int mod) {
        return new int[0];
    }

    public long[] longArray(int N, long mod) {
        return new long[0];
    }

    public SpeedScanner write(byte b) {
        return null;
    }

    public SpeedScanner write(char c) {
        return null;
    }

    public SpeedScanner write(char[] s) {
        return null;
    }

    public SpeedScanner write(String s) {
        return null;
    }

    public SpeedScanner write(int x) {
        return null;
    }

    public void print(Object s) {
    }

    public void print(Object... objects) {
    }

    public void println(Object s) {
    }

    public void println(int i) {
    }

    public void println() {
    }

    public void printLine(Object... objects) {
    }

    public void printArray(int[] a) {
    }
    
    public void printlnArray(int[] a) {
    }
    
    public void printArray(long[] a) {
    }
    
    public void printlnArray(long[] a) {
    }

    public void p(Object o) {
    }

    public void p() {
    }

    public void ps(Object o) {
    }

    public void ps() {
    }

    public void pl(Object o) {
    }

    public void pl() {
    }

    public void pn() {
    }

    public void pn(Object o) {
    }

    public void pln() {
    }

    public void pln (Object o) {
    }

    public void printLine() {
    }

    public void printLine(Object o) {
    }

    public void flush() {
    }

    public void close() {
    }

    public void exit() {
    }

    public boolean isSpace(int c) { return false; }

    public double readDouble() { return 0.0; }

    public int[] na(int n) {
        return new int[n];
    }

    public long[] nal(int n) {
        return new long[n];
    }

    public void iIA(int arr[]){
    }

    static int[] ari(int n)throws IOException
    {
        return new int[n];
    }
    static int[][] ari(int n,int m)throws IOException
    {
        return new int[n][m];
    }
    static long[] arl(int n)throws IOException
    {
        return new long[n];
    }
    static long[][] arl(int n,int m)throws IOException
    {
        return new long[n][m];
    }
    static String[] ars(int n)throws IOException
    {
        return new String[n];
    }
    static double[] ard(int n)throws IOException
    {
        return new double[n];
    }
    static double[][] ard(int n,int m)throws IOException
    {
        return new double[n][m];
    }
    static char[] arc(int n)throws IOException
    {
        return new char[n];
    }
    static char[][] arc(int n,int m)throws IOException
    {
        return new char[n][m];
    }
}
    

