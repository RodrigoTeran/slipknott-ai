import java.io.BufferedReader;
import java.io.*;
import java.util.*;

public class josph {

static BufferedReader br;


static long mod = 1000000000 + 7;
static HashSet<Integer> p = new HashSet<>();
static boolean debug =true;
// Arrays.sort(time , (a1,a2) -> (a1[0]-a2[0])); 2d array sort lamda
public static void main(String[] args) throws Exception {
br = new BufferedReader(new InputStreamReader(System.in));
PrintWriter pr = new PrintWriter(System.out);
int tc = 1;
tc= cinI();
while(tc-->0){
int n =cinI();
String[] a= new String[n];

int[][] f =new int[10][n];

for(int i=0;i<n;i++){
a[i]=cin();
char[] x = a[i].toCharArray();

for(char c:x){
int index = c-'a';
f[index][i]+=1;
}
for(int j=0;j<10;j++){
int rem =x.length-f[j][i];
f[j][i]-=rem;
}
}
int max=0;
for(int j=0;j<10;j++){
Arrays.sort(f[j]);
int cnt=0;
int sum=0;
for(int i=n-1;i>=0;i--){
sum+=f[j][i];
if(sum>0){
cnt+=1;
}
else{
break;
}
}
max=max(max,cnt);
}
System.out.println(max);
}

}

public static <E> void print(String var ,E e){
if(debug==true){
System.out.println(var +" "+e);
}
}
private static long[] sort(long[] e){
ArrayList<Long> x=new ArrayList<>();
for(long c:e){
x.add(c);
}
Collections.sort(x);
long[] y = new long[e.length];
for(int i=0;i<x.size();i++){
y[i]=x.get(i);
}
return y;
}
public static void printDp(long[][] dp) {

int n = dp.length;
for (int i = 0; i < n; i++) {
for (int j = 0; j < dp[0].length; j++) {
System.out.print(dp[i][j] + " ");
}
System.out.println();
}
}






private static long gcd(long a, long b) {
if (a == 0)
return b;
if (b == 0)
return a;

// base case
if (a == b)
return a;

// a is greater
if (a > b)
return gcd(a % b, b);
return gcd(a, b % a);
}


public static long min(long a, long b) {
return Math.min(a, b);
}

public static int min(int a, int b) {
return Math.min(a, b);
}


public static void sieve() {
int[] pf = new int[100000000 + 1];
//0 prime //1 not prime
pf[0] = 1;
pf[1] = 1;
for (int j = 2; j <= 10000; j++) {

if (pf[j] == 0) {
p.add(j);
for (int k = j * j; k < pf.length; k += j) {
pf[k] = 1;
}
}
}

}


public static int[] readArray(int n, int x, int z) throws Exception {
int[] arr = new int[n];
String[] ar = cinA();
for (int i = x; i < n + x; i++) {
arr[i] = getI(ar[i - x]);
}
return arr;
}

public static long[] readArray(int n, int x) throws Exception {
long[] arr = new long[n];
String[] ar = cinA();
for (int i = x; i < n + x; i++) {
arr[i] = getL(ar[i - x]);
}
return arr;
}

public static void arrinit(String[] a, long[] b) throws Exception {
for (int i = 0; i < a.length; i++) {
b[i] = Long.parseLong(a[i]);
}
}

public static HashSet<Integer>[] Graph(int n, int edge, int directed) throws Exception {
HashSet<Integer>[] tree = new HashSet[n];

for (int j = 0; j < edge; j++) {

String[] uv = cinA();
int u = getI(uv[0]);
int v = getI(uv[1]);
if (directed == 0) {

tree[v].add(u);
}
tree[u].add(v);
}
return tree;
}

public static void arrinit(String[] a, int[] b) throws Exception {
for (int i = 0; i < a.length; i++) {
b[i] = Integer.parseInt(a[i]);
}
}


static double findRoots(int a, int b, int c) {
// If a is 0, then equation is not
//quadratic, but linear


int d = b * b - 4 * a * c;
double sqrt_val = Math.sqrt(Math.abs(d));


// System.out.println("Roots are real and different \n");

return Math.max((double) (-b + sqrt_val) / (2 * a),
(double) (-b - sqrt_val) / (2 * a));


}

public static String cin() throws Exception {
return br.readLine();
}

public static String[] cinA() throws Exception {
return br.readLine().split(" ");
}

public static String[] cinA(int x) throws Exception {
return br.readLine().split("");
}

public static String ToString(Long x) {
return Long.toBinaryString(x);
}

public static void cout(String s) {
System.out.println(s);
}

public static Integer cinI() throws Exception {
return Integer.parseInt(br.readLine());
}

public static int getI(String s) throws Exception {
return Integer.parseInt(s);
}

public static long getL(String s) throws Exception {
return Long.parseLong(s);
}

public static long max(long a, long b) {
return Math.max(a, b);
}

public static int max(int a, int b) {
return Math.max(a, b);
}

public static void coutI(int x) {
System.out.println(String.valueOf(x));
}

public static void coutI(long x) {
System.out.println(String.valueOf(x));
}

public static Long cinL() throws Exception {
return Long.parseLong(br.readLine());
}

public static void arrInit(String[] arr, int[] arr1) throws Exception {
for (int i = 0; i < arr.length; i++) {
arr1[i] = getI(arr[i]);
}

}
}