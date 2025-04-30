
import java.util.*;

import java.io.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
	
public class Main {
		private static FS sc = new FS();
		
		private static class FS {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer("");
			String next() {
				while (!st.hasMoreTokens())
					try {
						st=new StringTokenizer(br.readLine());				               
		            } catch (IOException e) {}
				return st.nextToken();
			}
			
			int nextInt() {
				return Integer.parseInt(next());
			}
			long nextLong() {
				return Long.parseLong(next());
			}
		}
		
		private static class extra {
			
			static int[] intArr(int size) {
				int[] a = new int[size];
				for(int i = 0; i < size; i++) a[i] = sc.nextInt();
				return a;
			}
			
			static long[] longArr(int size) {
				Scanner scc = new Scanner(System.in);
				long[] a = new long[size];
				for(int i = 0; i < size; i++) a[i] = sc.nextLong();
				return a;
			}
			
			static long intSum(int[] a) {
				long sum = 0; 
				for(int i = 0; i < a.length; i++) {
					sum += a[i];
				}
				return sum;
			}
			
			static long longSum(long[] a) {
				long sum = 0; 
				for(int i = 0; i < a.length; i++) {
					sum += a[i];
				}
				return sum;
			}
			
			static LinkedList[] graphD(int vertices, int edges) {
				LinkedList<Integer>[] temp = new LinkedList[vertices+1];
				for(int i = 0; i <= vertices; i++) temp[i] = new LinkedList<>();
				for(int i = 0; i < edges; i++) {
					int x = sc.nextInt();
					int y = sc.nextInt();
					temp[x].add(y);
				}
				return temp;
			}
			
			static LinkedList[] graphUD(int vertices, int edges) {
				LinkedList<Integer>[] temp = new LinkedList[vertices+1];
				for(int i = 0; i <= vertices; i++) temp[i] = new LinkedList<>();
				for(int i = 0; i < edges; i++) {
					int x = sc.nextInt();
					int y = sc.nextInt();
					temp[x].add(y);
					temp[y].add(x);
				}
				return temp;
			}
			
			static void printG(LinkedList[] temp) { for(LinkedList<Integer> aa:temp) System.out.println(aa); }
			
			static long cal(long val, long pow, long mod) {
				if(pow == 0) return 1;
				long res = cal(val, pow/2, mod);
				
				long ret = (res*res)%mod;
				if(pow%2 == 0) return ret;
				return (val*ret)%mod;
			}
			
			static long gcd(long a, long b) { return b == 0 ? a:gcd(b, a%b); }
			
		}
		
		static int mod = (int) 1e9;
		
		static LinkedList<Integer>[] temp, idx;
		static long inf = (long) Long.MAX_VALUE;
//		static long inf = Long.MAX_VALUE;
//		static int max;
		
		public static void main(String[] args) { 
			int t = sc.nextInt();
//			int t = 1;
			StringBuilder ret = new StringBuilder();
			while(t-- > 0) {
				int n = sc.nextInt();
				String a = sc.next(), b = sc.next();
				int _00 = 0, _01 = 0, _10 = 0, _11 = 0;
				for(int i = 0; i < n; i++) {
					if(a.charAt(i) == '0' && b.charAt(i) == '0') _00++;
					if(a.charAt(i) == '0' && b.charAt(i) == '1') _01++;
					if(a.charAt(i) == '1' && b.charAt(i) == '0') _10++;
					if(a.charAt(i) == '1' && b.charAt(i) == '1') _11++;
				}
				int ans = Integer.MAX_VALUE;
				if(_10 == _01) ans = _01 + _10;
				if(_10 > 0) {
					int n00 = _10 - 1;
		            int n01 = _11;
		            int n10 = _00 + 1;
		            int n11 = _01;
		            if (n01 == n10) {
		                ans = Math.min(ans, 1 + n01 + n10);
		            }
				}
				if(_11 > 0) {
					int n00 = _10;
		            int n01 = _11 - 1;
		            int n10 = _00;
		            int n11 = _01 + 1;
		            if (n01 == n10) {
		                ans = Math.min(ans, 1 + n01 + n10);
		            }
				}
				ret.append(ans == Integer.MAX_VALUE ? -1 : ans);
				ret.append("\n");
			}
			System.out.println(ret);
		}

	}

	
	


	
	
	
