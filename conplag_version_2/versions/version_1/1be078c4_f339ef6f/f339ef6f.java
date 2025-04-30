import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
 
public class Main {
	static FastReader fr;
	static int arrForIndexSort[];
	static class FastReader {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader()
        {
            br = new BufferedReader(
                new InputStreamReader(System.in));
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt() { return Integer.parseInt(next()); }
 
        long nextLong() { return Long.parseLong(next()); }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
 
        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
	static class Pair{
		int first;
		int second;
		Pair(int first, int second){
			this.first = first;
			this.second = second;
		}
		@Override
		public boolean equals(Object b) {
			Pair a = (Pair)b;
			if(this.first == a.first && this.second==a.second) {
				return true;
			}
			return false;
		}
	}
	class PairSorter implements Comparator<Main.Pair>{
		public int compare(Pair a, Pair b) {
			if(a.first!=b.first) {
				return a.first-b.first;
			}
			return a.second-b.second; 
		}
	}
	class IndexSorter implements Comparator<Integer>{
		public int compare(Integer a, Integer b) {
			//desc
			if(arrForIndexSort[b]==arrForIndexSort[a]) {
				return b-a;
			}
			return arrForIndexSort[b]-arrForIndexSort[a];
		}
	}
	class ListSorter implements Comparator<List>{
		public int compare(List a, List b) {
			return b.size()-a.size(); 
		}
	}
	static class DisjointSet{
		int[] dsu;
		public DisjointSet(int n) {
			makeSet(n);
		}
		public void makeSet(int n) {
			dsu = new int[n+1];
			//*** 1 Based indexing ***
			for(int i=1;i<=n;i++) {
				dsu[i] = -1;
			}
		}
		public int find(int i) {
			while(dsu[i] > 0) {
				i = dsu[i];
			}
			return i;
		}
		public void union(int i, int j) {
			int iRep = find(i);
			int jRep = find(j);
			if(iRep == jRep) {
				return;
			}
			if(dsu[iRep]>dsu[jRep]) {
				dsu[jRep] += dsu[iRep];
				dsu[iRep] = jRep;
			}
			else {
				dsu[iRep] += dsu[jRep];
				dsu[jRep] = iRep;
			}
		}
	}
	public static void main(String[] args) {
		fr = new FastReader();
		int T = 1;
		T = fr.nextInt();
		int t1 = T;
		while (T-- > 0) {
			solve();
		}
	}
	public static void solve() {
		int n=fr.nextInt();
		int k=fr.nextInt();
		int[] a = new int[k];
		int[] map = new int[n];
		int[] temp = new int[n];
		Arrays.fill(temp, Integer.MAX_VALUE);
		Arrays.fill(map, Integer.MAX_VALUE);
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i=0;i<k;i++) {
			a[i] = fr.nextInt()-1;
			min = Math.min(a[i], min);
			max = Math.max(a[i], max);
		}
		for(int i=0;i<k;i++) {
			map[a[i]] = fr.nextInt();
		}
		int diff = 0;
		int curr = map[min];
		for(int i=min;i<n;i++) {
			int airConditioner = map[i];
			if(airConditioner<curr+diff) {
				temp[i] = airConditioner;
				diff = 1;
				curr = airConditioner;
			}
			else {
				temp[i] = curr+diff;
				diff++;
			}
			
		}
		diff = 0;
		curr = map[max];
		for(int i=max;i>=0;i--) {
			int airConditioner = map[i];
			if(airConditioner<curr+diff) {
				temp[i] = Math.min(temp[i], airConditioner);
				diff = 1;
				curr = airConditioner;
			}
			else {
				temp[i] =  Math.min(temp[i], curr+diff);
				diff++;
			}
			
		}
		System.out.println(Arrays.toString(temp).replaceAll(",|\\[|\\]",""));
		
	}

}