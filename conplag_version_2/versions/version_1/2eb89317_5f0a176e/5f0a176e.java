
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class a729 {

	public static void main(String[] args) throws IOException {
   
		
//		try {
			
		BufferedWriter out = new BufferedWriter(
	            new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(
		        new InputStreamReader(System.in));
		PrintWriter pt = new PrintWriter(System.out);
		FastReader sc = new FastReader();
		int t = sc.nextInt();
	
for(int o = 0 ; o<t;o++){

	int n = sc.nextInt();
	String s1 = sc.next();
	String s2 = sc.next();
	if(s1.equals(s2)) {
		System.out.println(0);
		continue;
	}
	int f = 0;
	for(int i = 0 ; i<n;i++) {
		if(s1.charAt(i) == '1') {
			f = 1;
			break;
		}
	}
if(f == 0) {
	System.out.println(-1);
continue;
}
int c = 0;
int c1 = 0;
int c2 = 0;
int c3 = 0;
int c4 = 0;
for(int i = 0; i<n;i++) {
	if(s1.charAt(i)!=s2.charAt(i)) {
		c++;
	if(s1.charAt(i) == '1') {
		c1++;
	}else {
		c2++;
	}
	}else {
		if(s1.charAt(i) == '1') {
			c3++;
		}else {
			c4++;
		}
	}
}

int g = 0;
int h = 0;

int v1 = Integer.MAX_VALUE;
int v2 = Integer.MAX_VALUE;
if(c%2==1) {
g = 1;
}

int e = n-c;
if(e%2==0) {
h = 1;
}
//System.out.println(Math.min(v1, v2));
if(c2!=c/2){
	g = 1;
}
if(c4!=e/2){
	h = 1;
}
if(g == 0){
	v1 = c;
}
if(h == 0){
	v2 = e;
}

int ans = Math.min(v1, v2);

if(ans == Integer.MAX_VALUE) {
	System.out.println(-1);
}else {
	System.out.println(ans);
}
}

//     }catch(Exception e) {
//    	 return;
//     }
    	
	
	
	
	}
     
     
//------------------------------------------------------------------------------------------------------------------------------------------------

	
	public static boolean check(int[][] arr , int m , int n , int val){
		HashSet<Integer>set = new HashSet<Integer>();
		int f = 0;
		int id = 0;
		ArrayList<Integer> al = new ArrayList<Integer>();
		for(int i = 0 ; i<m;i++) {
			for(int j = 0 ; j<n;j++) {
				if(arr[i][j]>=val) {
//					System.out.println(arr[i][j] + " " + i + " " + j);
					set.add(j);
					al.add(arr[i][j]);
				}
			}
			id = i;
		if(set.size()>=2) {
			f = 1;
			break;
		}else {
			set.clear();
		}
		}
		if(f == 0) {
			return false;
		}
//		System.out.println(set);
//		System.out.println(al);
//		int g = 1;
		for(int i = 0 ; i<n;i++) {
			if(set.contains(i)) {
				continue;
			}
			int h= 0;
			for(int j = 0 ; j<m;j++) {
				if(j == id) {
				continue;	
				}
				if(arr[j][i]>=val) {
					h = 1;
					break;
				}
			}
		if(h == 0) {
			return false;
		}
		}
	return true;
	}
	
	
static int cntDivisors(int n){
        int cnt = 0;
		for (int i=1; i<=Math.sqrt(n); i++)
        {
            if (n%i==0)
            {
                if (n/i == i)
                	cnt++;
                	
                else 
                	cnt+=2;
            }
        }
    
    return cnt;
    }
	
	
	
	public static long findgcd(long[] arr,int v) {
		int n = arr.length;
		long g = arr[v];
		for(int i = v ; i<n;i+=2) {
			g = gcd(g, arr[i]);
		}
		return g;
	}
	
	

	public static long ncr(long[] fac, int n , int r , long m) {
		return fac[n]*(modInverse(fac[r], m))%m *(modInverse(fac[n-r], m))%m; 
	}
	
	
	public static void build(int [][] seg,char []arr,int idx, int lo , int hi) {
	if(lo == hi) {
//		seg[idx] = arr[lo];
		seg[idx][(int)arr[lo]-'a'] = 1;
		
		return;
	}
	int mid = (lo + hi)/2;
build(seg,arr,2*idx+1, lo, mid);
build(seg,arr,idx*2+2, mid +1, hi);
//seg[idx] = Math.min(seg[2*idx+1],seg[2*idx+2]);
for(int i = 0 ; i<27;i++) {
	seg[idx][i] = seg[2*idx+1][i] + seg[2*idx + 2][i];
}
	}
//for f/inding minimum in range 
public static void query(int[][]seg,int[]ans,int idx , int lo , int hi , int l , int r) {
	if(lo>=l && hi<=r) {
		for(int i = 0 ; i<27;i++) {
			ans[i]+= seg[idx][i];
		}
		return ;
	}
if(hi<l || lo>r) {
	return;
}
int mid = (lo + hi)/2;
query(seg,ans,idx*2 +1, lo, mid, l, r);
query(seg,ans,idx*2 + 2, mid + 1, hi, l, r);
//return Math.min(left, right);
}
//// for sum
//
public static void update(int[][]seg,char[]arr,int idx, int lo , int hi , int node , char val) {
if(lo == hi) {
//	seg[idx] += val;
seg[idx][val-'a']++;
seg[idx][arr[node]-'a']--;

}else {
int mid = (lo + hi )/2;
if(node<=mid && node>=lo) {
update(seg,arr, idx * 2 +1, lo, mid, node, val);
}else {
update(seg,arr, idx*2 + 2, mid + 1, hi, node, val);
}
//seg[idx] = seg[idx*2 + 1] + seg[idx*2 + 2];
for(int i = 0 ; i<27;i++) {
	seg[idx][i] = seg[2*idx+1][i] + seg[2*idx + 2][i];
}
}

}
	
	
	
	
	
	
	public static int lower_bound(int array[], int low, int high, int key){
	// Base Case
	if (low > high) {
	return low;
	}

	// Find the middle index
	int mid = low + (high - low) / 2;

	// If key is lesser than or equal to
	// array[mid] , then search
	// in left subarray
	if (key <= array[mid]) {

	return lower_bound(array, low,
	            mid - 1, key);
	}

	// If key is greater than array[mid],
	// then find in right subarray
	return lower_bound(array, mid + 1, high,
	        key);
	}
	
	public static int upper_bound(int arr[], int low,
            int high, int key){
// Base Case
if (low > high || low == arr.length)
return low;

// Find the value of middle index
int mid = low + (high - low) / 2;

// If key is greater than or equal
// to array[mid], then find in
// right subarray
if (key >= arr[mid]) {
return upper_bound(arr, mid + 1, high,
                key);
}

// If key is less than array[mid],
// then find in left subarray
return upper_bound(arr, low, mid - 1,
            key);
}

//	-----------------------------------------------------------------------------------------------------------------------------------------------
	public static long gcd(long a, long b){
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
//--------------------------------------------------------------------------------------------------------------------------------------------------------
	public static long modInverse(long a, long m){
        long m0 = m;
        long y = 0, x = 1;
 
        if (m == 1)
            return 0;
 
        while (a > 1) {
            // q is quotient
            long q = a / m;
 
            long t = m;
 
            // m is remainder now, process
            // same as Euclid's algo
            m = a % m;
            a = t;
            t = y;
 
            // Update x and y
            y = x - q * y;
            x = t;
        }
 
        // Make x positive
        if (x < 0)
            x += m0;
 
        return x;
    }

		

//-----------------------------------------------------------------------------------------------------------------------------------

	//segment tree
	//for finding minimum in range 
//	public static void build(int [] seg,int []arr,int idx, int lo , int hi) {
//		if(lo == hi) {
//			seg[idx] = arr[lo];
//			return;
//		}
//		int mid = (lo + hi)/2;
//	build(seg,arr,2*idx+1, lo, mid);
//	build(seg,arr,idx*2+2, mid +1, hi);
//	seg[idx] = Math.min(seg[2*idx+1],seg[2*idx+2]);
//	}
////for finding minimum in range 
//public static int query(int[]seg,int idx , int lo , int hi , int l , int r) {
//		if(lo>=l && hi<=r) {
//			return seg[idx];
//		}
//	if(hi<l || lo>r) {
//		return Integer.MAX_VALUE;
//	}
//	int mid = (lo + hi)/2;
//	int left = query(seg,idx*2 +1, lo, mid, l, r);
//	int right = query(seg,idx*2 + 2, mid + 1, hi, l, r);
//	return Math.min(left, right);
//}
//	// for sum
//
//public static void update(int[]seg,int idx, int lo , int hi , int node , int val) {
//	if(lo == hi) {
//		seg[idx] += val;
//	}else {
//int mid = (lo + hi )/2;
//if(node<=mid && node>=lo) {
//	update(seg, idx * 2 +1, lo, mid, node, val);
//}else {
//	update(seg, idx*2 + 2, mid + 1, hi, node, val);
//}
//seg[idx] = seg[idx*2 + 1] + seg[idx*2 + 2];
//
//}

//}
//---------------------------------------------------------------------------------------------------------------------------------------


	static void shuffleArray(long[] ar)
	  {
	    // If running on Java 6 or older, use `new Random()` on RHS here
	    Random rnd = ThreadLocalRandom.current();
	    for (int i = ar.length - 1; i > 0; i--)
	    {
	      int index = rnd.nextInt(i + 1);
	      // Simple swap
	      long a = ar[index];
	      ar[index] = ar[i];
	      ar[i] = a;
	    }
	  }
//-----------------------------------------------------------------------------------------------------------------------------------------------------------

}


class FastReader {
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
//------------------------------------------------------------------------------------------------------------------------------------------------------------
class SegmentTree{
	
int n;
	public SegmentTree(int[] arr,int n) {
		this.arr = arr;
		this.n = n;
	}
	int[] arr = new int[n];
//	int n = arr.length;
	int[] seg = new int[4*n];
	void build(int idx, int lo , int hi) {
		if(lo == hi) {
			seg[idx] = arr[lo];
			return;
		}
		int mid = (lo + hi)/2;
	build(2*idx+1, lo, mid);
	build(idx*2+2, mid +1, hi);
	seg[idx] = Math.min(seg[2*idx+1],seg[2*idx+2]);
	}
	int query(int idx , int lo , int hi , int l , int r) {
		if(lo<=l && hi>=r) {
			return seg[idx];
		}
	if(hi<l || lo>r) {
		return Integer.MAX_VALUE;
	}
	int mid = (lo + hi)/2;
	int left = query(idx*2 +1, lo, mid, l, r);
	int right = query(idx*2 + 2, mid + 1, hi, l, r);
	return Math.min(left, right);
	}
	
	
}
//-----------------------------------------------------------------------------------------------------------------------------------------------------------
class coup{
	char a; 
	int b;
	public coup(char a , int b) {
		this.a = a;
		this.b = b;
	}
}

class trip{
	int a , b, c;
	public trip(int a , int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
}
//---------------------------------------------------------------------------------------------------------------------------------------------------------------
