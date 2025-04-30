//(￣﹏￣；)
//(* ￣︿￣)	

import java.util.*;
import java.io.*;
	
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
			
			static void printG(LinkedList[] temp) {
				for(LinkedList<Integer> aa:temp) System.out.println(aa);
			}
			
			static long cal(long val, long pow, long mod) {
				if(pow == 0) return 1;
				long res = cal(val, pow/2, mod);
				
				long ret = (res*res)%mod;
				if(pow%2 == 0) return ret;
				return (val*ret)%mod;
			}
			
			static long gcd(long a, long b) { return b == 0 ? a:gcd(b, a%b); }
			
		}
		
		static int mod = (int) 1e9 + 7;
		
		static LinkedList<String>[] temp, temp2;
		static int inf = (int) 1e9;
//		static long inf = Long.MAX_VALUE;
		
		public static void main(String[] args) {	
			int t = sc.nextInt();
//			int t = 1;
			StringBuilder ret = new StringBuilder();
			while(t-- > 0) {
				int n = sc.nextInt();
				int[] a = extra.intArr(n);
				String s = sc.next();
				ArrayList<Integer> red = new ArrayList<>(), blue = new ArrayList<>();
				for(int i = 0; i < n; i++) {
					if(s.charAt(i) == 'R') red.add(a[i]);
					else blue.add(a[i]);
				}
				Collections.sort(red);
				Collections.sort(blue);
				int start = 1, flag = 0;
				for(int aa:blue) {
					if(start > aa) {
						flag = 1;
						break;
					}
					start++;
				}
				for(int aa:red) {
					if(start < aa) {
						flag = 1;
						break;
					}
					start++;
				}
				if(flag == 1) ret.append("NO\n");
				else ret.append("YES\n");
			}
			System.out.println(ret);
		}
		
	}
	


	
	
	
