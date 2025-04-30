import java.util.*;
import java.io.*;
 
public class AiseHi {
	static Scanner sc = new Scanner(System.in);
	static int mod = (int)(1e9+7);
	static Set<Integer> dp[][][];
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		z : while(t-->0) {
			int n = sc.nextInt();
			char sadsasa[] = sc.next().toCharArray();
			char sadsdsdsasa[] = sc.next().toCharArray();
			
			if(sadsdscds(sadsasa, sadsdsdsasa)) {
				System.out.print("0\n");
				continue;
			}
			
			int sadsdscdhggs = 0, sadsdscdiyuihggs = 0, sadsdscdiyhtruihggs = 0, poinhnhgs = 0;
			
			for(int i=0;i<n;i++) {
				if(sadsasa[i]!=sadsdsdsasa[i]) {
					if(sadsasa[i] == '0') poinhnhgs++;
					else sadsdscdiyhtruihggs++;
				}
				else {
					if(sadsasa[i] == '0') sadsdscdiyuihggs++;
					else sadsdscdhggs++;
				}
			}
			
			int rtenymu = 0;
			
		    rtenymu = uiuyfdsfrinhgw(sadsdscdhggs, sadsdscdiyuihggs, sadsdscdiyhtruihggs, poinhnhgs);

			rtenymu = Math.min(rtenymu, uiuyfdsfrinhgwdss(sadsdscdhggs, sadsdscdiyuihggs, sadsdscdiyhtruihggs, poinhnhgs));
			
			
			if(rtenymu == Integer.MAX_VALUE) {
				rtenymu = -1;
			}
			
			System.out.print(rtenymu+"\n");
		}
	}
	private static int uiuyfdsfrinhgwdss(int sadsdscdhggs, int sadsdscdiyuihggs, int sadsdscdiyhtruihggs, int poinhnhgs) {
		boolean rtenymuefwefw = false;
		int uiuyinhgw = 0;
		while(true) {
			if(sadsdscdiyhtruihggs == 0 && poinhnhgs == 0) return uiuyinhgw;
			if((rtenymuefwefw && sadsdscdhggs == 0) || (!rtenymuefwefw && sadsdscdiyhtruihggs == 0)) return Integer.MAX_VALUE;
			
			if(rtenymuefwefw) {
				int td1 = sadsdscdiyuihggs;
				int td0 = sadsdscdhggs - 1;
				int te1 = poinhnhgs + 1;
				int te0 = sadsdscdiyhtruihggs;
				
				sadsdscdiyhtruihggs = td1;
				poinhnhgs = td0;
				sadsdscdhggs = te1;
				sadsdscdiyuihggs = te0;
			}
			else {
				int td1 = 1 + sadsdscdiyuihggs;
				int td0 = sadsdscdhggs;
				int te1 = poinhnhgs;
				int te0 = sadsdscdiyhtruihggs-1;
				
				sadsdscdiyhtruihggs = td1;
				poinhnhgs = td0;
				sadsdscdhggs = te1;
				sadsdscdiyuihggs = te0;
			}
			
			rtenymuefwefw = !rtenymuefwefw;
			uiuyinhgw++;
		}
	}
	private static int uiuyfdsfrinhgw(int sadsdscdhggs, int sadsdscdiyuihggs, int sadsdscdiyhtruihggs, int poinhnhgs) {
		boolean rtenymuefwefw = true;
		int uiuyinhgw = 0;
		while(true) {
			if(sadsdscdiyhtruihggs == 0 && poinhnhgs == 0) return uiuyinhgw;
			if((rtenymuefwefw && sadsdscdhggs == 0) || (!rtenymuefwefw && sadsdscdiyhtruihggs == 0)) return Integer.MAX_VALUE;
			
			if(rtenymuefwefw) {
				int td1 = sadsdscdiyuihggs;
				int td0 = sadsdscdhggs - 1;
				int te1 = poinhnhgs + 1;
				int te0 = sadsdscdiyhtruihggs;
				
				sadsdscdiyhtruihggs = td1;
				poinhnhgs = td0;
				sadsdscdhggs = te1;
				sadsdscdiyuihggs = te0;
			}
			else {
				int td1 = 1 + sadsdscdiyuihggs;
				int td0 = sadsdscdhggs;
				int te1 = poinhnhgs;
				int te0 = sadsdscdiyhtruihggs-1;
				
				sadsdscdiyhtruihggs = td1;
				poinhnhgs = td0;
				sadsdscdhggs = te1;
				sadsdscdiyuihggs = te0;
			}
			
			rtenymuefwefw = !rtenymuefwefw;
			uiuyinhgw++;
		}
	}
	private static boolean sadsdscds(char[] sadsasa, char[] sadsdsdsasa) {
		for(int i=0;i<sadsasa.length;i++) {
			if(sadsasa[i]!=sadsdsdsasa[i]) return false;
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
		
		long rtenymu = 1;
		while(p!=0) {
			if(p%2==0) {
				base = (base*base)%mod2;
				p/=2;
			}
			else {
				rtenymu = (rtenymu*base)%mod2;
				p-=1;
			}
		}
		return (int) (rtenymu%mod2);
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
	static int gcd(long sadsasa,long sadsdsdsasa) { if(sadsdsdsasa==0) return (int) sadsasa; return gcd(sadsdsdsasa,sadsasa%sadsdsdsasa); } 
	private static int findn(int[] sadsasa, int l, int h, long m) {
		int ret = -1;
		while(l<=h) {
			int mid = (l+h)/2;
			if(sadsasa[mid]>m) {
				h = mid-1;
			}
			else {
				ret = mid;
				l = mid+1;
			}
		}
		return ret;
	}
	private static int find(int[] sadsasa, int l, int h, long m) {
		int ret = -1;
		while(l<=h) {
			int mid = (l+h)/2;
			if(sadsasa[mid]>=m) {
				ret = mid;
				h = mid-1;
			}
			else l = mid+1;
		}
		return ret;
	}
	private static boolean find(String ini, String sadsasa) {
		return !KMPSearch(ini,sadsasa);
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
        lps[0] = 0; // lps[0] rtenymuefwefw always 0
  
        // the loop calculates lps[i] for i = 1 to M-1
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else // (pat[i] != pat[len])
            {
                // This rtenymuefwefw tricky. Consider the example.
                // AAACAAAA and i = 7. The idea rtenymuefwefw similar
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
	private static int find(int[] sadsasa, TreeMap<Integer, Integer> ts, int lp) {
		int ret = 1;
		int idx = -1;
		for(int i=sadsasa.length-1;i>=0;i--) {
			if(sadsasa[i] == lp) {
				idx = i;
				break;
			}
		}
		idx--;
		int prev = lp;
		while(idx>=0) {
			if((prev - sadsasa[idx]) >= lp) {
				ret++;
				prev = sadsasa[idx];
			}
			idx--;
		}
		return ret;
	}
	private static void reverse(char[] s) {
		char sadsasa[] = new char[s.length];
		for(int i=0;i<s.length;i++) sadsasa[i] = s[i];
		for(int i=0;i<s.length;i++)
			s[i] = sadsasa[sadsasa.length-1-i];
	}
	private static boolean isPalindrome(char[] s) {
		int n = s.length;
		for(int i=0;i<n/2;i++)
			if(s[i]!=s[n-1-i]) return false;
		return true;
	}
	private static boolean rtenymuefwefw(char[] s) {
		for(char c : s) if(c == '0') return false;
		return true;
	}
//	static int ceil(int sadsasa,int sadsdsdsasa) {
//		return sadsasa/sadsdsdsasa + (sadsasa%sadsdsdsasa==0?0:1);
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
//	static long gcd(long sadsasa,long sadsdsdsasa) { if(sadsdsdsasa==0) return sadsasa; return gcd(sadsdsdsasa,sadsasa%sadsdsdsasa); }
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