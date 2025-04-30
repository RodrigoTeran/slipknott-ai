import java.util.function.Consumer;
import java.util.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.io.*;
import java.lang.Math.*;
 public class KickStart2020{
	static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){br = new BufferedReader(
           new InputStreamReader(System.in));}
        String next(){
            while (st == null || !st.hasMoreElements()) {
                try { st = new StringTokenizer(br.readLine()); }
                catch (IOException e) {e.printStackTrace();}}
            return st.nextToken();}
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next());}
        float nextFloat() {return Float.parseFloat(next());}
        String nextLine() {
            String str = "";
            try {str = br.readLine();}
            catch (IOException e) { e.printStackTrace();}
            return str; }}
	static boolean isBracketSequence(String s, int a, int b) {
		Stack<Character> ss = new Stack<>();
		boolean hachu = true;
		for(int i = a; i <= b; i++) {
			if(s.charAt(i) == ')' && ss.isEmpty()) {hachu = false; break;}
			if(s.charAt(i) == '(') ss.add('(');
			else ss.pop();
		}
		return ss.empty() && hachu;
	}
	static String reverseOfString(String a) {
		StringBuilder ssd = new StringBuilder();
		for(int i = a.length() - 1; i >= 0; i--) {
			ssd.append(a.charAt(i));
		}
		return ssd.toString();
	}
	static char[] reverseOfChar(char a[]) {
		char b[] = new char[a.length];
		int j = 0;
		for(int i = a.length - 1; i >= 0; i--) {
			b[i] = a[j];
			j++;
		}
		return b;
	}
	static boolean isPalindrome(char a[]) {
		boolean hachu = true;
		for(int i = 0; i <= a.length / 2; i++) {
			if(a[i] != a[a.length - 1 - i]) {
				hachu = false;
				break;
			}
		}
		return hachu;
	} 
	static long gcd(long a, long b)
	{
	    if (b == 0)
	        return a;
	    return gcd(b, a % b);
	     
	}
	static long powermod(long x, long y, long mod){
	    long ans = 1;
	    x = x % mod; 
	    if (x == 0)
	      return 0; 
	    int i = 1;
	    while (y > 0){
	      if ((y & 1) != 0)
	        ans = (ans * x) % mod;
	      y = y >> 1; 
	      x = (x * x) % mod;
	    }
	    return ans;
	  }
	static long power(long x, long y){
	    long ans = 1;
	    if (x == 0)
	      return 0; 
	    int i = 1;
	    while (y > 0){
	      if ((y & 1) != 0)
	        ans = (ans * x);
	      y = y >> 1; 
	      x = (x * x);
	    }
	    return ans;
	  }
	static boolean check(String a) {
		boolean hachu = true;
		for(int i = 0; i < a.length(); i++) {
			if(a.charAt(0) != a.charAt(i)) {hachu = false; break;}
		}
		return hachu;
	}
	 public static class Pair implements Comparable<Pair> {
	        public  int index;
	        public  int value;
	 
	        public Pair(int index, int value) {
	            this.index = index;
	            this.value = value;
	        }
	        @Override
	        public int compareTo(Pair other) {
	            return   -1 * Integer.valueOf(this.value).compareTo(other.value);
	        }
	 }
	 static boolean equalString(int i, int j, int arr[], String b) {
		 int brr[] = new int[26];
		 for(int k = i; k <= j; k++) brr[b.charAt(k) - 'a']++;
		 for(int k = 0; k < 26; k++) {
			 if(arr[k] != brr[k]) return false;
		 }
		 return true;
	 }
	 static boolean cequalArray(String a, String b) {
		  int count[] = new int[26];
		  int count1[] = new int[26];
		  for(int i = 0; i < a.length(); i++) count[a.charAt(i) - 'a']++;
		  for(int i = 0; i < a.length(); i++) count1[b.charAt(i) - 'a']++;
		  for(int i = 0; i < 26; i++) if(count[i] != count1[i]) return false;
		  return true;
	 }
	 static boolean isPrime(long d) {
		 if(d == 1) return true;
		 for(int i = 2; i <= (long)Math.sqrt(d); i++) {
			 if(d % i == 0) return false;
		 }
		 return true;
	 }
		public static void main(String[] args) throws Exception{
			FastReader sc = new FastReader();
			PrintWriter out = new PrintWriter(System.out);
          int t = sc.nextInt();
          while(t-- > 0) {
           int n = sc.nextInt();
           int k = sc.nextInt();
           int arr[] = new int[k];
           int temp[] = new int[k];
           for(int i = 0; i < k; i++) arr[i] = sc.nextInt();
           for(int i = 0; i < k; i++) temp[i] = sc.nextInt();
           long brr[] = new long[n];
           Arrays.fill(brr, Integer.MAX_VALUE);
           for(int i = 0; i < k; i++) brr[arr[i] - 1] = temp[i];
           for(int i = 1; i < n; i++) {
        	   brr[i] = Math.min(brr[i], brr[i - 1] + 1);
           }
           for(int i = n - 2; i >= 0; i--) {
        	   brr[i] = Math.min(brr[i], brr[i + 1] + 1);
           }
           for(long e: brr) out.print(e + " ");
           out.println();
             
          }
                 out.close();
			}
		}