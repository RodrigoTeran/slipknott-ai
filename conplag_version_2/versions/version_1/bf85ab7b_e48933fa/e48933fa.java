import java.io.*;




import java.util.*;
/*
 


 */





 
 
 
 
 public class C {
    static FastReader sc=null;
   
	public static void main(String[] args) {
		sc=new FastReader();
		int t=sc.nextInt();
		while(t-->0) {
			int n=sc.nextInt();
			Node nodes[]=new Node[n];
			for(int i=0;i<n;i++)nodes[i]=new Node(i,sc.nextInt(),sc.nextInt());
			for(int i=0;i+1<n;i++) {
				int v=sc.nextInt()-1,w=sc.nextInt()-1;
				nodes[v].adj.add(nodes[w]);
				nodes[w].adj.add(nodes[v]);
			}
			
			dfs(nodes[0],null);
			System.out.println(Math.max(nodes[0].right,nodes[0].left));
		}
		
		
		
	}
	static void dfs(Node v,Node par) {
		for(Node nn:v.adj) {
			if(nn!=par) {
				dfs(nn,v);
				v.right+=Math.max(nn.right+Math.abs(v.r-nn.r), 
						nn.left+Math.abs(v.r-nn.l));
				v.left+=Math.max(nn.right+Math.abs(v.l-nn.r), 
						nn.left+Math.abs(v.l-nn.l));
			}
		}
	}
	static class Node{
		int id;
		long right=0,left=0;
		int l,r;
		ArrayList<Node> adj=new ArrayList<>();
		
		Node(int id,int l,int r){
			this.id=id;
			this.l=l;
			this.r=r;
		}
	}
	
	
	
    static void ruffleSort(int a[]) {
    	ArrayList<Integer> al=new ArrayList<>();
    	for(int i:a)al.add(i);
    	Collections.sort(al);
    	for(int i=0;i<a.length;i++)a[i]=al.get(i);
    }
    
    
    static int[] reverseSort(int a[]) {
        ArrayList<Integer> al=new ArrayList<>();
        for(int i:a)al.add(i);
        Collections.sort(al,Collections.reverseOrder());
        for(int i=0;i<a.length;i++)a[i]=al.get(i);
        return a;
    }
    
    static void reverse(char a[]) {
		int n=a.length;
		char b[]=new char[n];
		for(int i=0;i<n;i++)b[i]=a[n-1-i];
		for(int i=0;i<n;i++)a[i]=b[i];
	}
   
 
    static int gcd(int a,int b) {
		if(b==0)return a;
		else return gcd(b,a%b);
	}  
    static long gcd(long a,long b) {
		if(b==0)return a;
		else return gcd(b,a%b);
	}  
        
 
    
    
    
    static void print(long a[]) {
        for(long e:a) {
            System.out.print(e+" ");
        }
        System.out.println();
    }
    static void print(char a[]) {
        for(char e:a) {
            System.out.print(e);
        }
        System.out.println();
    }
    
    
    static void print(int a[]) {
        for(int e:a) {
            System.out.print(e+" ");
        }
        System.out.println();
    }
    
    
    static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
        int[] readArray(int n) {
            int a[]=new int [n];
            for(int i=0;i<n;i++) {
                a[i]=sc.nextInt();
            }
            return a;
        }
        long[] readArrayL(int n) {
            long a[]=new long [n];
            for(int i=0;i<n;i++) {
                a[i]=sc.nextLong();
            }
            return a;
        }
    } 
}