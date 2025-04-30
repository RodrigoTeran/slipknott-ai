import java.io.*;
import java.util.*;


public class ComdeFormces {
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		FastReader sc=new FastReader();
		BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
		int t=sc.nextInt();
		while(t--!=0) {
			int n=sc.nextInt();
//			int m=sc.nextInt();
		    ArrayList<ArrayList<pair>> ar=new ArrayList<>();
		    ArrayList<pair> arr=new ArrayList<>();
		    int c[]=new int[n];
		    for(int i=0;i<=n;i++) {
		    	ar.add(new ArrayList<>());
		    }
		    for(int i=0;i<n-1;i++) {
		    	int a=sc.nextInt();
		    	int b=sc.nextInt();
		    	ar.get(a).add(new pair(b,i));
		    	ar.get(b).add(new pair(a,i));
		    	
		    }
		    boolean ans=true;
		    for(int i=0;i<=n;i++) {
		     if(ar.get(i).size()>2) {
		    	 ans=false;
		    	 break;
		     }  	
		    }
		    if(ans) {
		    
		       for(int i=1;i<=n;i++) {
		    	   if(ar.get(i).size()==1) {
		    		   boolean vis[]=new boolean[n+1];
		    		   dfs(ar,2,i,vis,c);
		    		   break;
		    	   }
		       }
		       for(int i=0;i<n;i++) {
		    	   if(c[i]!=0)log.write(c[i]+" ");
		       }
		    }
		    else log.write("-1");
		    
		     log.write("\n");
		     log.flush();
			}
		}
	
		
static void dfs(ArrayList<ArrayList<pair>>ar ,int val,int src,boolean vis[],int c[]) {
	if(vis[src])return;
	vis[src]=true;
	for(int i=0;i<ar.get(src).size();i++) {
		if(!vis[ar.get(src).get(i).a]) {
			c[ar.get(src).get(i).b]=val;
			if(val==2) {
				dfs(ar,3,ar.get(src).get(i).a,vis,c);
			}
			else {
				dfs(ar,2,ar.get(src).get(i).a,vis,c);
			}
		}
	}
}	
	
	
	
		

		
		
static ArrayList<Integer> divisors(int n){
	
	ArrayList<Integer> ar=new ArrayList<>();
     for (int i=2; i<=Math.sqrt(n); i++){
	        if (n%i == 0){
	            if (n/i == i) {
	            	ar.add(i);
	            }
	            else {
	               ar.add(i);
	               ar.add(n/i);
	            }
	         }
       }
	return ar;
}
static int primeDivisor(int n){
	ArrayList<Integer> ar=new ArrayList<>();
	int cnt=0;
	boolean pr=false;
	while(n%2==0) {
		pr=true;
		n/=2;
		
	}
	if(pr)ar.add(2);
	for(int i=3;i*i<=n;i+=2) {
		pr=false;
		while(n%i==0) {
			n/=i;
			pr=true;
		}
		if(pr)ar.add(i);
	}
	if(n>2) ar.add(n);
	return ar.size();
	
}
static int mdlg(int num, int base) {
	
	int val=((int)(Math.ceil(Math.log(num)/Math.log(base))));
	int val2=(int)Math.pow(base,val);
//	System.out.println(num+" "+Math.pow(base,val));
   if(num/val2==0)return val;
    return val+1;
//	return val;
}	
static String rev(String s) {
	char temp[]=s.toCharArray();
	for(int i=0;i<temp.length/2;i++) {
		char tp=temp[i];
		temp[i]=temp[temp.length-1-i];
		temp[temp.length-1-i]=tp;
		
	}
	return String.valueOf(temp);
}	
static long bsv(long a[],long min,long max) {
	long ans=-1;
	while(min<=max) {
		long mid=min+(max-min)/2;
		long an=solvess(a,mid);
//	    System.out.println("an="+an+"mid="+mid);
		if(an==mid) {
			ans=Math.max(ans,an);
			min=mid+1;
		}
		else if(an>mid)min=mid+1;
		else if(an<mid)max=mid-1;
		
	}
	return ans;
}		
static long solvess(long aa[],long el) {
	long a[]=new long[aa.length];
	long min=Long.MAX_VALUE;
	for(int i=0;i<a.length;i++ ) {
		a[i]=aa[i];
		min=Math.min(min, aa[i]);
	}
	boolean ans=true;
	long val[]=new long[a.length];
	for(int i=a.length-1;i>=2;i--) {
		if(a[i]+val[i]>el) {
			if(val[i]>=el) {
			long df=a[i];
			a[i]-=df;
			val[i-1]+=(df/3);
			val[i-2]+=2*(df/3);
			a[i]+=df%3;
			}
			else {
			 	long df=a[i]+val[i]-el;
			 	val[i-1]+=(df/3);
				val[i-2]+=2*(df/3);
				a[i]-=df;
				a[i]+=df%3;
			}
		}
		
	}
	for(int i=0;i<a.length;i++) {
		a[i]+=val[i];
	}
	
	long min2=Long.MAX_VALUE;
	for(int i=0;i<a.length;i++) {
		min2=Math.min(min2, a[i]);
	}
	return min2;
	

	
}	
static int bsd(ArrayList<LinkedList<Integer>> arr, int val,int el) {
	
		int s=0;
	    int e=arr.size()-1;
	    int ptr=0;
	    if(val==1)ptr=1;
	    while(s<=e) {
	    	int m=s+(e-s)/2;
	    	if(arr.get(m).get(ptr)==el)return m;
	    	else if(arr.get(m).get(ptr)<el)s=m+1;
	    	else e=m-1;
	    }
	    return -1;
	
	
}
static int bs(ArrayList<pair> arr,int el) {
	int start=0;
	int end=arr.size()-1;
	while(start<=end) {
		int mid=start+(end-start)/2;
		if(arr.get(mid).a==el)return mid;
		else if(arr.get(mid).a<el)start=mid+1;
		else end=mid-1;
	}
   if(start>arr.size()-1)return -2;
   return -1;
}	
static String eval(String s, long bs, long be,long k) {
	String ans="";
	for(int i=s.length()-1;i>=0;i--) {
		if(s.charAt(i)=='a') {
			ans="a"+ans;
		}
		else if(be>0){
			
			if(be>k) {
				for(int j=0;j<k;j++)ans="b"+ans;
				be-=k;
			}
			else {
				for(int j=0;j<be;j++)ans="b"+ans;
				be=0;
			} 
			
		}
	}
	for(int i=0;i<bs;i++)ans="b"+ans;
	return ans;
	
}	
static int[][] slv() {
	int r=200001;
	int bits=(int)(Math.log(r)/Math.log(2))+1;
	int cnt[][]=new int[r+1][bits];
	for(int i=1;i<=r;i++) {
		int temp=i;
		int j=0;
		int min=Integer.MAX_VALUE;
		while(j<bits) {
			int tval=1&temp;
			temp>>=1;
	        if(tval==0)cnt[i][j]=cnt[i-1][j]+1;
	        else {
	        	 cnt[i][j]=cnt[i-1][j];
	        }
	        j++;
		}
	}
	return cnt;
	
}	
static long find(int s,long a[]) {
	if(s>=a.length)return -1;
	long num=a[s];
	for(int i=s;i<a.length;i+=2) {
		num=gcd(num,a[i]);
		if(num==1 || num==0)return -1;
	}
	return  num;
}	
static long gcd(long a,long b) {
	if(b==0)return a;
	else return gcd(b,a%b);
}	
static long factmod(long n,long mod,long img) {
	if(n==0)return 1;
	long ans=1;
	long temp=1;
	while(n--!=0) {
		if(temp!=img) {
		ans=((ans%mod)*((temp)%mod))%mod;
		}
		temp++;
	}
	return ans%mod;
}	
static long eval(ArrayList<Integer> a, int k) {
	if(a.size()<1 )return 0;
	int i=a.size()-1;
	long ans=0;
	while(i>=0) {
		int temp=k;
		int prev=0;
		while(temp--!=0 && i>=0) {
			ans+=Math.abs(a.get(i)-prev);
			if(temp==0 || i==0)ans+=a.get(i);
			prev=a.get(i);
			i--;
		}
	}
	return ans;
}	
static int bs(long a[] ,long num) {
	int start=0;
	int end=a.length-1;
    while(start<=end) {
    	int mid=start+(end-start)/2;
    	if(a[mid]==num) {
    		return mid;
    	}
    	else if(a[mid]<num)start=mid+1;
    	else end=mid-1;
    
    }
    return start;
}	
	
	
//utils
static int ncr(int n, int r){
    if(r>n-r)r=n-r;
    int ans=1;
    for(int i=0;i<r;i++){
          ans*=(n-i);
          ans/=(i+1);
    }
    return ans;
} 
 
public static class trip{
	int a,b,c;
	public trip(int a,int b,int c) {
		this.a=a;
		this.b=b;
		this.c=c;
	}
	public int compareTo(trip q) {
		return this.c-q.c;
	}
}	
	static int mergesort(int[] a,int start,int end) {
		if(start>=end)return a[end];
		int mid=start+(end-start)/2;
		int min1=mergesort(a,start,mid);
		int min2=mergesort(a,mid+1,end);
		merge(a,start,mid,end);
		return Math.min(min1, min2);
	}
	static void merge(int []a, int start,int mid,int end) {
		int ptr1=start;
		int ptr2=mid+1;
		int b[]=new int[end-start+1];
		int i=0;
		while(ptr1<=mid && ptr2<=end) {
			if(a[ptr1]<=a[ptr2]) {
				b[i]=a[ptr1];
				ptr1++;
				i++;
			}
			else {
				b[i]=a[ptr2];
				ptr2++;
				i++;
			}
		}
		while(ptr1<=mid) {
			b[i]=a[ptr1];
			ptr1++;
			i++;
		}
		while(ptr2<=end) {
			b[i]=a[ptr2];
			ptr2++;
			i++;
		}
		for(int j=start;j<=end;j++) {
			a[j]=b[j-start];
		}
	}
	public static class FastReader {

		BufferedReader b;
		StringTokenizer s;
		public FastReader() {
			b=new BufferedReader(new InputStreamReader(System.in));
		}
		String next() {
			while(s==null ||!s.hasMoreElements()) {
				try {
					s=new StringTokenizer(b.readLine());
				}
				catch(IOException e) {
					e.printStackTrace();
				}
			}
			return s.nextToken();
		}
		public int nextInt() {
			return Integer.parseInt(next());
		}
		public long nextLong() {
			return Long.parseLong(next());
		}
		public double nextDouble() {
			return Double.parseDouble(next());
		}
		String nextLine() {
			String str="";
			try {
				str=b.readLine();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
		boolean hasNext() {
		    if (s != null && s.hasMoreTokens()) {
		        return true;
		    }
		    String tmp;
		    try {
		        b.mark(1000);
		        tmp = b.readLine();
		        if (tmp == null) {
		            return false;
		        }
		        b.reset();
		    } catch (IOException e) {
		        return false;
		    }
		    return true;
		}
}
public static class pair{
	int a;
	int b;
	public pair(int a,int b) {
		this.a=a;
		this.b=b;
	}
	public int compareTo(pair b) {
		return b.b-this.b;
	}
	public int compareToo(pair b) {
		if(this.a!=b.a)return this.a-b.a;
		else {
			return b.b-this.b;
		}
	}
}	
static long pow(long a, long pw) {
	long temp;
	if(pw==0)return 1;
	temp=pow(a,pw/2);
	if(pw%2==0)return temp*temp;
	return a*temp*temp;
	
}
static int pow(int a, int pw) {
	int temp;
	if(pw==0)return 1;
	temp=pow(a,pw/2);
	if(pw%2==0)return temp*temp;
	return a*temp*temp;
	
}
}
