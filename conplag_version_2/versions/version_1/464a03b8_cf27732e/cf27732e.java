import java.util.*;



import java.io.*;

public class code  {
	// remember long, to reformat ctrl + shift +f
	static Scanner sc = new Scanner(System.in);
	static PrintWriter pw = new PrintWriter(System.out);
 
	  
 
	public static void main(String[] args) throws Exception {

		int t=sc.nextInt();
		while(t-->0) {
            int n=sc.nextInt();
            int []vals=new int[n];
            boolean numLine[]=new boolean[n+1];

            for(int i=0;i<n;i++)vals[i]=sc.nextInt();
            String s=sc.nextLine();
            ArrayList<Integer>b=new ArrayList<Integer>();
            ArrayList<Integer>r=new ArrayList<Integer>();
            for(int i=0;i<n;i++) {
            	if(s.charAt(i)=='B' && vals[i]>0 )b.add(vals[i]);
            	else if( s.charAt(i)=='R' && vals[i]<=n)r.add(vals[i]);
            }
          Collections.sort(b);
          Collections.sort(r);
          int small=1;
          for(int i=0;i<b.size();i++) {
        	  
        	  int y=b.get(i);
        	  if(y<small)continue;
        	  numLine[small]=true;
        	  small++;
          }
         // pw.println(Arrays.toString(numLine));
          int large=n;
          for(int i=r.size()-1;i>=0;i--) {
        	  
        	  int y=r.get(i);
        	  if(y>large)continue;
        	 // y=Math.max(large, y);
        	  numLine[large]=true;
        	  large--;
          }
          //pw.print(Arrays.toString(numLine));
          boolean can=true;
          for(int i=1;i<=n;i++) {
        	  if(numLine[i]==false) {
        		  pw.println("no");
        		  can=false;
        		  break;
        	  }
        	  
          }
          if(can)pw.println("yes");
          
           
            	
            	
            

			
		}
		
	 pw.close();

	}

	// --------------------stuff ----------------------
	static class pair implements Comparable<pair> {
		int v;
		int w;
        
		public pair(int v,int  w) {
			this.v = v;
			this.w = w;
			
		}

		public int compareTo(pair p) {
			return this.w- p.w;// increasing order!!
		
			//return Double.compare(v*w, p.w*p.v);
		
		}
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public Scanner(FileReader r) {
			br = new BufferedReader(r);
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public double nextDouble() throws IOException {
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if (x.charAt(0) == '-') {
				neg = true;
				start++;
			}
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.') {
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else {
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}

		public long[] nextlongArray(int n) throws IOException {
			long[] a = new long[n];
			for (int i = 0; i < n; i++)
				a[i] = nextLong();
			return a;
		}

		public Long[] nextLongArray(int n) throws IOException {
			Long[] a = new Long[n];
			for (int i = 0; i < n; i++)
				a[i] = nextLong();
			return a;
		}

		public int[] nextIntArray(int n) throws IOException {
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}

		public Integer[] nextIntegerArray(int n) throws IOException {
			Integer[] a = new Integer[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}

		public boolean ready() throws IOException {
			return br.ready();
		}
	}

}