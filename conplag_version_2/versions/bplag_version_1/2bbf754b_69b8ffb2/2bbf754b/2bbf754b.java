import java.util.*;

//CODE FORCES

public class anshulvmc {

    
    public static void sort(int[] a) {
		ArrayList<Integer> l=new ArrayList<>();
		for (int i:a) l.add(i);
		Collections.sort(l);
		for (int i=0; i<a.length; i++) a[i]=l.get(i);
	}
    
    
    
    
    public static int gcd(int a, int b) {
		if (b==0) return a;
		return gcd(b, a%b);
	}
    
    public static void google(int t) {
    	System.out.println("Case #"+t+": ");
    }
    
    
//    public static void gt(int[][] arr,int k) {
//    	int n = arr.length+1;
//    	k = Math.min(k,n+1);
//    	
//    	Node[] nodes = new Node[n];
//    	for(int i=0;i<n;i++) nodes[i] = new Node();
//    	for(int i=0;i<n-1;i++) {
//    		int a = arr[i][0];
//    		int b = arr[i][1];
//    		System.out.println(a+" "+b);
//    		nodes[a].adj.add(nodes[b]);
//    		nodes[b].adj.add(nodes[a]);
//    	}
//    	
//    	ArrayDeque<Node> bfs = new ArrayDeque<>();
//    	for(Node nn:nodes) {
//    		if(nn.adj.size()<2) {
//    			bfs.addLast(nn);
//    			nn.dist=0;
//    		}
//    	}
//    	
//    	while(bfs.size()>0) {
//    		Node nn = bfs.removeFirst();
//    		for(Node a : nn.adj) {
//    			if(a.dist!=-1) continue;
//    			a.usedDegree++;
//    			if(a.adj.size() - a.usedDegree <= 1) {
//    				a.dist = nn.dist+1;
//    				bfs.addLast(a);
//    			}
//    		}
//    	}
//    	
//    	int[] cs = new int[n+1];
//    	for(Node nn:nodes) {
//    		cs[nn.dist]++;
//    	}
//    	for(int i=1;i<cs.length;i++) cs[i]+=cs[i-1];
//    	System.out.println(n-cs[k-1]);
//    }
    
    public static class Node{
    	ArrayList<Node> adj = new ArrayList<>();
    	int dist = -1;
    	int usedDegree = 0;
    }
    
    
    public static void cat_mice(int dest,int[] arr) {
    	sort(arr);
    	int time = dest;
		int timeleft = dest-1;
		int counter=0;
		for(int i=arr.length-1;i>=0;i--) {
			int val = arr[i];
			int takes = time - val;
			if(takes <= timeleft) {
				timeleft -= takes;
				counter++;
			}
		}
    	System.out.println(counter);
    }
    
    
    public static void minex(int n,int[] arr) {
    	sort(arr);
    	int ans=arr[0];
    	for(int i=0;i<arr.length-1;i++) {
    		ans = Math.max(ans,arr[i+1] - arr[i]);
    	}
    	System.out.println(ans);
    }
	
    
    public static void func(long start,long n) {
    	long x = start;
    	if(n==0){
    	       System.out.println(x);
    	       return;
    	   }
    	   long k=n-1;
    	   long c=k/4;
    	   long rem=k%4;
    	   long ans=x;
    	   if(x%2 == 0) {
       		ans -= 1;
       		ans -= (c * 4);
       		if(rem == 1) {
       			ans += n;
       		}
       		else if(rem == 2) {
       			ans += n + n-1;
       		}
       		else if(rem == 3){
       			ans += (n-2) + (n-1) - n;
       		}
       	}
       	else {
       		ans += 1;
       		ans += (c * 4);
       		if(rem == 1) {
       			ans -= n;
       		}
       		else if(rem == 2) {
       			ans -= n + n-1;
       		}
       		else if(rem == 3) {
       			ans -= n-2 + n-1 - n;
       		}
       	}
    	   System.out.println(ans);
    	   
    	
    }
    
	public static boolean redblue(int[] num, String chnum) {
    	ArrayList<Integer> blue = new ArrayList<>();
    	ArrayList<Integer> red = new ArrayList<>();
    	for(int i=0;i<chnum.length();i++) {
    		char ch = chnum.charAt(i);
    		if(ch == 'B') {
    			blue.add(num[i]);
    		}
    		else {
    			red.add(num[i]);
    		}
    	}
    	Collections.sort(blue);
    	Collections.sort(red);
//    	System.out.println(blue);
//    	System.out.println(red);
    	for(int i=0;i<blue.size();i++) {
    		if(blue.get(i) >= i+1) {
    			
    		}
    		else {
    			return false;
    		}
    	}
    	for(int i=0;i<red.size();i++) {
    		if(red.get(i) > i+1 + blue.size()) {
//    			System.out.println(red.get(i)+" "+(i+1 + blue.size()));
    			return false;
    		}
    	}
    	return true;
    }
    
    public static void main(String args[])
    
    
    {	
    	Scanner scn = new Scanner(System.in);
    	int test = scn.nextInt();
    	for(int i=0;i<test;i++) {
    		int size = scn.nextInt();
    		int[] arr = new int[size];
    		for(int j=0;j<size;j++) {
    			arr[j] = scn.nextInt();
    		}
    		String str = scn.next();
    		boolean f = redblue(arr,str);
    		if(f) {
    			System.out.println("YES");
    		}
    		else {
    			System.out.println("NO");
    		}
    	}
//    	int n = 1;
//    	int[] dp = new int[2];
//    	System.out.println(fact(n,dp));
    			
    }

}