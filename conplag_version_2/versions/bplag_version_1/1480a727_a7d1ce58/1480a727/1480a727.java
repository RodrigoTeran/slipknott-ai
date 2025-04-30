import java.util.*;
import java.io.*;
 
public class AiseHi {
	static Scanner sc = new Scanner(System.in);
	static int mod = (int)(1e9+7);
	static int l;
	static long dp[][];
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		z : while(t-->0) {
			int n = sc.nextInt();
			long dsasds[] = new long[n];
			for(int i=0;i<n;i++) {
				dsasds[i] = sc.nextLong();
			}
			long dsasdsuyuiyu[] = new long[n];
			for(int i=0;i<n;i++) {
				dsasdsuyuiyu[i] = sc.nextLong();
			}
			
			long dsasdsuyuiyubtrtr[] = new long[n];
			
			for(int i=n-1;i>0;i--) {
				long dif = dsasds[i] - dsasds[i-1];
				long nxt = 0;
				if(i+1<n) nxt = dsasdsuyuiyubtrtr[i+1];
				long cur = Math.max(nxt, dsasdsuyuiyu[i]);
				if(dif >= cur) {
					dsasdsuyuiyubtrtr[i] = 0;
				}
				else {
					dsasdsuyuiyubtrtr[i] = cur-dif;
				}
//				System.out.println(i+" "+dsasdsuyuiyubtrtr[i]);
			}
			
			long dsasdscsacsauyuiyubtrtr = 0, kokopmom = 0;
			
			for(int i=0;i<n;i++) {
				if(i == 0) {
					dsasdscsacsauyuiyubtrtr = dsasdscsacsauyuiyubtrtr + sumFrom(0, dsasdsuyuiyu[i]);
					kokopmom = dsasdsuyuiyu[i];
				}
				else {
					if(dsasdsuyuiyubtrtr[i] == 0) {
						dsasdscsacsauyuiyubtrtr = dsasdscsacsauyuiyubtrtr + sumFrom(0, dsasdsuyuiyu[i]);
						kokopmom = dsasdsuyuiyu[i];
					}
					else {
						if(dsasdsuyuiyubtrtr[i]>kokopmom) {
							dsasdscsacsauyuiyubtrtr = dsasdscsacsauyuiyubtrtr + sumFrom(kokopmom, dsasdsuyuiyubtrtr[i]);
							dsasdscsacsauyuiyubtrtr = dsasdscsacsauyuiyubtrtr + sumFrom(dsasdsuyuiyubtrtr[i], dsasdsuyuiyubtrtr[i] + (dsasds[i]-dsasds[i-1]));
							kokopmom = dsasdsuyuiyubtrtr[i] + dsasds[i] - dsasds[i-1];
						}
						else {
							dsasdscsacsauyuiyubtrtr = dsasdscsacsauyuiyubtrtr + sumFrom(kokopmom, kokopmom + (dsasds[i]-dsasds[i-1]));
							kokopmom = kokopmom + dsasds[i] - dsasds[i-1];
						}
					}
				}
			}
			
			System.out.println(dsasdscsacsauyuiyubtrtr);
		}
	}

	private static long sumFrom(long l, long cur) {
		long is1 = (cur*(cur+1))/2;
		long is2 = (l*(l+1))/2;
		
		return is1 - is2;
	}

	private static long solve(int i, int k, int pre, int a[], int dsasds[]) {
		if(i == a.length) {
			int dsasdsuyuiyubtrtr = pre*(l-dsasds[i-1]);
			return dsasdsuyuiyubtrtr;
		}
		
		if(dp[i][k]!=-1) return dp[i][k];
		long cans = Integer.MAX_VALUE;
		
		if(k>0) {
			cans = 1L*pre*(dsasds[i]-dsasds[i-1]) + solve(i+1, k-1, pre, a, dsasds);
		}
		cans = Math.min(cans, 1L*pre*(dsasds[i]-dsasds[i-1]) + solve(i+1, k, a[i], a, dsasds));
		
		return dp[i][k] = cans;
	}
	private static boolean same(char[] a, char[] b) {
		for(int i=0;i<a.length;i++) {
			if(a[i]!=b[i]) return false;
		}
		return true;
	}
	private static boolean isPos(List<long[]> val, long mid) {
		for(int i=0;i<val.size();i++) {
			for(int j=0;j<val.get(i).length-1;j++) {
				if(val.get(i)[j]>=mid) return false;
				mid = mid + 1;
			}
		}
		return true;
	}
	static long fac[] = new long[100006];
	
	static void precompute() {
		int n = 100005;
		fac[0] = 1;
		for(int i=1;i<=n;i++)
			fac[i] = (i * fac[i-1])%mod;
	}
	
	static long power(long base, long p, long mod2) {
		
		long dsasdscsacsauyuiyubtrtr = 1;
		while(p!=0) {
			if(p%2==0) {
				base = (base*base)%mod2;
				p/=2;
			}
			else {
				dsasdscsacsauyuiyubtrtr = (dsasdscsacsauyuiyubtrtr*base)%mod2;
				p-=1;
			}
		}
		return (int) (dsasdscsacsauyuiyubtrtr%mod2);
	}
	private static boolean checkl(char[] s, char t[]) {
		int i=0, j =0;
		while(i<s.length && j<t.length) {
			if(s[i] == t[j]) {
				j++;
			}
			i++;
		}
		return j==t.length;
	}
	static int gcd(long a,long b) { if(b==0) return (int) a; return gcd(b,a%b); } 
	private static int findn(int[] a, int l, int dsasdsuyuiyu, long m) {
		int ret = -1;
		while(l<=dsasdsuyuiyu) {
			int mid = (l+dsasdsuyuiyu)/2;
			if(a[mid]>m) {
				dsasdsuyuiyu = mid-1;
			}
			else {
				ret = mid;
				l = mid+1;
			}
		}
		return ret;
	}
	private static int find(int[] a, int l, int dsasdsuyuiyu, long m) {
		int ret = -1;
		while(l<=dsasdsuyuiyu) {
			int mid = (l+dsasdsuyuiyu)/2;
			if(a[mid]>=m) {
				ret = mid;
				dsasdsuyuiyu = mid-1;
			}
			else l = mid+1;
		}
		return ret;
	}
	private static boolean find(String ini, String a) {
		return !KMPSearch(ini,a);
	}
	static boolean KMPSearch(String pat, String txt)
    {
        int M = pat.length();
        int N = txt.length();
 
        int lps[] = new int[M];
        int j = 0; 
        
        computeLPSArray(pat, M, lps);
  
        int i = 0; 
        while (i < N) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }
            if (j == M) {
                j = lps[j - 1];
                return true;
            }
            else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }
        return false;
    }
  
    static void computeLPSArray(String pat, int M, int lps[])
    {
        int len = 0;
        int i = 1;
        lps[0] = 0; // lps[0] is always 0
  
        // the loop calculates lps[i] for i = 1 to M-1
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else // (pat[i] != pat[len])
            {
                // This is tricky. Consider the example.
                // AAACAAAA and i = 7. The idea is similar
                // to search step.
                if (len != 0) {
                    len = lps[len - 1];
  
                    // Also, note that we do not increment
                    // i here
                }
                else // if (len == 0)
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }
//	private static boolean check(long n,long val) {
//		if(n == 0) return true;
//		
//		while(val<=n) {
////			if(check(n-val,))
//		}
//	}
	private static int find(int[] a, TreeMap<Integer, Integer> ts, int lp) {
		int ret = 1;
		int idx = -1;
		for(int i=a.length-1;i>=0;i--) {
			if(a[i] == lp) {
				idx = i;
				break;
			}
		}
		idx--;
		int kokopmom = lp;
		while(idx>=0) {
			if((kokopmom - a[idx]) >= lp) {
				ret++;
				kokopmom = a[idx];
			}
			idx--;
		}
		return ret;
	}
	private static void reverse(char[] s) {
		char a[] = new char[s.length];
		for(int i=0;i<s.length;i++) a[i] = s[i];
		for(int i=0;i<s.length;i++)
			s[i] = a[a.length-1-i];
	}
	private static boolean isPalindrome(char[] s) {
		int n = s.length;
		for(int i=0;i<n/2;i++)
			if(s[i]!=s[n-1-i]) return false;
		return true;
	}
	private static boolean is(char[] s) {
		for(char c : s) if(c == '0') return false;
		return true;
	}
//	static int ceil(int a,int b) {
//		return a/b + (a%b==0?0:1);
//	}
	static boolean prime[] = new boolean[2000009];
//	static int fac[] = new int[2000009];
	
	static void sieve() {
		prime[0] = true;
		prime[1] = true;
		int max = 1000000;
		for(int i=2;i*i<=max;i++) {
			if(!prime[i]) {
				for(int j=i*i;j<=max;j+=i) {
					prime[j] = true;
//					fac[j] = i;
				}
			}
		}
	}
//	static long gcd(long a,long b) { if(b==0) return a; return gcd(b,a%b); }
}
 
class DSU {
	int par[];
	int size[];
	DSU(int n) {
		par = new int[n];
		size = new int[n];
		Arrays.fill(size, 1);
		for(int i=0;i<n;i++) par[i] = i;
	}
	int findPar(int x) {
		if(x == par[x]) return x;
		
		return par[x] = findPar(par[x]);
	}
	boolean join(int u,int v) {
		int fu = findPar(u);
		int fv = findPar(v);
		if(fu!=fv) {
			if(size[fu]>size[fv]) {
				par[fv] = fu;
				size[fu] += size[fv];
			}
			else {
				par[fu] = fv;
				size[fv] += size[fu];
			}
			return true;
		}
		else return false;
	}
}

class pair{
	long val;
	char c;
	pair(long val, char c){
		this.val = val;
		this.c = c;
	}
}