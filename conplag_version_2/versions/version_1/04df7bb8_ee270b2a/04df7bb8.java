										import java.math.BigInteger;
										import java.sql.Array;
									    import java.util.ArrayList;
										import java.util.Arrays;
										import java.util.Collection;
										import java.util.Collections;
										import java.util.Comparator;
										import java.util.Deque;
										import java.util.HashMap;
										import java.util.HashSet;
										import java.util.InputMismatchException;
										import java.util.LinkedList;
										import java.util.PriorityQueue;
										import java.util.Queue;
										import java.util.Scanner;
										import java.util.Set;
										import java.util.Stack;
										import java.io.BufferedReader;
										import java.io.IOException;
										import java.io.InputStream;
										import java.io.InputStreamReader;
										import java.util.Scanner;
										import java.util.StringTokenizer;
										import java.util.TreeMap;
										import java.util.TreeSet;
										
											
											
											
											
											
											public class Main {
							
												
												static HashMap<Integer,Boolean>map;
												
											static long dp[][];
											static 	boolean flag;
										static	HashSet<Long>hs;
											static long mod=(long)(1e9+7);
												public static void main(String[] args) {
												StringBuilder ans=new StringBuilder();
												FastReader sc=new FastReader();
													
												
												int t=sc.nextInt();
												
												
												while(t-->0) {
													
													int n=sc.nextInt();
													
													
													//int n=sb.length();
													
													
													
													int k=sc.nextInt();
													
													
													long L[]=new long[n];
													long R[]=new long[n];
													int a[]=new int[k];
													int temp[]=new int[k];
													
													for(int i=0;i<k;i++)
														a[i]=sc.nextInt();
													
													for(int i=0;i<k;i++)
														temp[i]=sc.nextInt();
													
													int c[]=new int [n];
													Arrays.fill(c, Integer.MAX_VALUE);
													for(int i=0;i<k;i++)
														c[a[i]-1]=temp[i];
												
													long p=Integer.MAX_VALUE;
													
													for(int i=0;i<n;i++)
													{
														p=Math.min(p+1, c[i]);
														
														L[i]=p;
														
														
													}
													p=Integer.MAX_VALUE;
													for(int i=n-1;i>=0;i--)
													{
														p=Math.min(p+1, c[i]);
														
														R[i]=p;
														
														
													}
													
													for(int i=0;i<n;i++)
													{
														ans.append(Math.min(L[i], R[i])+" ");
													}
											ans.append("\n");
													
												}
												System.out.println(ans);
												
												}
													
											static class Sparse{
												int log[];
												long sparse[][];
												Sparse(int n){
													
												log=new int [n+1];
												
												
												for(int i=1;i<n+1;i++)
													
												{
													log[i]=log[i/2]+1;
												}
												sparse=new long[n][18];
												
												
												
												}
												
												
			
												
												
												
												
											}
													


												
												
							
												
												
												
												
												
												
												
												
											static	long solve(String X,String Y,int n,int m,int M){
												    
													if(m==0&&n==0)return 0;
													
													//	if(m==1&&X.charAt(n-1)!='u')return Integer.MIN_VALUE;
													if(n==0||m==0)return Integer.MIN_VALUE;
											        
											        if(dp[n][m]!=-1)return dp[n][m]; 
												    
												    
												    
												    if(Y.charAt(m-1)==X.charAt(n-1))
												    {
												 //   else if(n==1)return Integer.MAX_VALUE;
												    	return dp[n][m]=1+ Math.max(solve (X,Y,n-1,m,M),solve (X,Y,n-1,m-1,M));
												    }
												    else{
												        
												        return dp[n][m]= solve(X,Y,n-1,m,M);
												        
												    }
												}
												
												static long solve(long [][]g,int n,int m,boolean visited [][]) {
													
													if(n==0||m==0)return 0;
													
													visited[n][m]=true;
													long ans=g[n-1][m-1]+Math.max(solve(g, n, m-1, visited),solve(g, n-1, m, visited));
													
													
													visited[n][m]=false;
													
													return ans;
													
													
													
												}
												
												
												
												
												static boolean isP(long x,long n,long m) {
													
													return (x^n)<=m;
													
												}
												
												
												
												
												
												static class pair{
													int n;int i;
													
													pair(int n,int i){
														this.n=n;
														this.i=i;
													}
												}
													
													
												
												
												
												
												
												static long	 solve(char g[][],int n,int m) {
													if(n==0||m==0)return 0;
													if(n==1&&m==1)return 1;
													if(g[n-1][m-1]=='#')return 0;
													
													if(dp[n][m]!=-1)return dp[n][m];
													
													return dp[n][m]= (solve(g, n-1, m)%mod+solve(g, n, m-1)%mod)%mod;
														
													
												}
												
												
												
												
												
												
												
												
												
									static	int  solve	(int v,ArrayList<ArrayList<Integer>>adj,int d[],boolean visited[]) {
											
											
											visited[v]=true;
											for(int u:adj.get(v)) {
												
												if(!visited[u])
												{
												solve(u, adj, d, visited);
												
												}
												d[v]=Math.max(1+d[u], d[v]);
											}
											
											
											return d[v];
											
											
										}
												
												
											
												
										static class colors{
											
											int c;int n;
											public colors(int c,int n) {
												// TODO Auto-generated constructor stub
												this.c=c;
												this.n=n;
											}
											
										}
												
												
												
												
												static int CeilIndex(long A[], int l, int r, long key)
											    {
											        while (r - l > 1) {
											            int m = l + (r - l) / 2;
											            if (A[m] >= key)
											                r = m;
											            else
											                l = m;
											        }
											 
											        return r;
											    }
											 
												static int CeilIndexd(long A[], int l, int r, long key)
											    {
											        while (r - l > 1) {
											            int m = l + (r - l) / 2;
											            if (-1*A[m] >= key)
											                r = m;
											            else
											                l = m;
											        }
											 
											        return r;
											    }
											 
												
												
												
											
												
											static void solve(ArrayList<Long>A,long bd) {
											
												if(bd>(long)1e9)return;
											//	if(hs.contains(bd))return;
												//A.add(bd);
												hs.add(bd);
												A.add(bd*10);
												A.add(bd*10+1);
											//	hs.add(bd*10);
												//hs.add(bd*10+1);
											
												solve(A,bd*10);
												solve(A,bd*10+1);
												
												
											}
												
												
												
												
												
												 static boolean isPrime(int n)
												    {
												        // Corner cases
												        if (n <= 1)
												            return false;
												        if (n <= 3)
												            return true;
												  
												        // This is checked so that we can skip
												        // middle five numbers in below loop
												        if (n % 2 == 0 || n % 3 == 0)
												            return false;
												  
												        for (int i = 5; i * i <= n; i = i + 6)
												            if (n % i == 0 || n % (i + 2) == 0)
												                return false;
												  
												        return true;
												    }
												  
												static long lcm(long a, long b)
											    {
											        return ((a / gcd(a, b))%mod * b%mod)%mod;
											    }
												   static long gcd(long a,long b)
												    {
												        if (a == 0)
												            return b%mod; 
												        return (gcd(b % a, a))%mod; 
												    }
												
									
												//System.out.println(count);
												
											
												
												
												static void dfs(int v,boolean visited[],ArrayList<ArrayList<Integer>>adj,int div[],int t)
												{
													visited[v]=true;
													
													div[v]=t+1;
													for(int u:adj.get(v)) {
														
														
														
														if(!visited[u]) {
															dfs(u,visited,adj,div,(t+1)%2);
														}
														
													}
													
													
												}
												
												
												static class Helper{
													
													int a;int b;int t;
													public Helper(int a,int b) {
														// TODO Auto-generated constructor stub
														
														this.a=a;
														this.b=b;
											
														
													
													}
													
													
												}
										
										
												
										
												
												
												
												
												//	System.out.println(max);
										
												
											
												
											
									
				//System.out.println(ans.toString());
				//main(						
											
							
					
				static void solvedfs(ArrayList<ArrayList<Integer>>adj,int n,int v,int subt[],int subtAns[],boolean []visited) {
							
							
							int count=1;
							int ans=0;
							visited[v]=true;
							for(int u:adj.get(v)) {
								
								
								if(!visited[u])
								{
									//System.out.println(v+" "+subt[v]+" "+n);
									subtAns[u]=Math.max(subtAns[u], subt[v]-subtAns[u]);
									
								solvedfs(adj, n, u, subt, subtAns, visited);			
								
								}
							}
							
						
							
							
							
							
							
						}
						
												
												
												
								static int dfs(ArrayList<ArrayList<Integer>>adj,int v,int subt[],int subtAns[],boolean []visited) {
								
									
									int count=0;
									int ans=0;
									visited[v]=true;
									for(int u:adj.get(v)) {
										
										
										if(!visited[u])
										{
											count+=ans;
											ans=Math.max(dfs(adj,u,subt,subtAns,visited),ans);
										}
									}
										subt[v]=count;
										subtAns[v]=ans;
										return ans+1;
										
									
									
									
									
									
								}
												
								
												
												
								static	int solve(ArrayList<ArrayList<Integer>>adj,int node,ArrayList<Integer>A)			
									{
										if(adj.get(node).size()==0)return 1;
										
										int count=0;
										for(int v:adj.get(node)) {
											
											count+=solve(adj,v,A);
											
										}
										
										A.set(node,count);
										return count+1;
										
										
										
									}
												
												
												
												
												
												
												
									static void dfs(String[]building,int i,int j,int n,int m, boolean visited[][]) {
										
										
										visited[i][j]=true;
										
										if(isValid(building,i+1,j,n,m,visited))
										{	visited[i+1][j]=true;
											dfs(building,i+1,j,n,m,visited);
										
										}
											if(isValid(building,i-1,j,n,m,visited))
										{
											visited[i-1][j]=true;
											dfs(building,i-1,j,n,m,visited);
										}
										 if(isValid(building,i,j+1,n,m,visited))
										{visited[i][j+1]=true;
											dfs(building,i,j+1,n,m,visited);
										}
												if(isValid(building,i,j-1,n,m,visited))
										{visited[i][j-1]=true;
											dfs(building,i,j-1,n,m,visited);
										}
										
										
										
										
									}
									static boolean isValid(String[]building,int i,int j,int n,int m, boolean visited[][])		
									{
										if(i==-1||j==-1||i==n||j==m||visited[i][j]||building[i].charAt(j)=='#')
											return false;
									return true;
									}
												
												
												
												
								static	void compute(boolean sieve[],int n) {
										
										for(int i=2;i<=n;i++) {
											if(sieve[i])continue;
											
											for(int j=2*i;j<n;j+=i)
											{
												sieve[j]=true;
											}
											
										}
											
										
										
									}
								
								static	void computeHs(boolean sieve[]) {
									int n=(int)(1e9-1e7+1);
									for(int i=1;i<n;i++) {
										if(sieve[i])continue;
										
										for(int j=2*i;j<n;j+=i)
										{
											sieve[j]=true;
										}
										
									}
									
								}
							
								
									
												
												
												static boolean isValid(StringBuilder s,int w) {
													if(w>s.length())return false;
													HashSet<Character>hs=new HashSet<Character>();
													int a[]=new int[3];
													
													for(int i=0;i<w;i++) {
													
														++a[s.charAt(i)-49];
														
													}
													
													if(a[0]>0&&a[1]>0&&a[2]>0)return true;
												
													int start=0;
													int end=w;
													
													while(end!=s.length()) {
														--a[s.charAt(start)-49];
														
															++a[s.charAt(end)-49];
														
																	start++;
																		end++;
																		if(a[0]>0&&a[1]>0&&a[2]>0)return true;
																				
													}
													return false;
													
													
													
												}
								
												
												
												
									
							
												
									static int find(int parent[],int i) {
										
										if(parent[i]==-1)return i;
										
										return parent[i]=find(parent,parent[i]);
										
									}
									static void union(int parent[],int rank[],int s1,int s2) {
										
										if(rank[s1]>=rank[s2]) {
											
											parent[s2]=s1;
											rank[s1]+=rank[s2];
										}
										
										else {
											
											parent[s1]=s2;
											rank[s2]+=rank[s1];
										}
										
										
									}
												
												
												
												
												
												
												
												
												
												
												
									static	int solve(String S,int K) {
											
											if(K<=0)return 0;
											if(S.charAt(K-1)!=S.charAt(K))
											return 1+solve(S,K-1);
											else return solve(S,K-1);
										}
										
										
										
										
				
				
					
				static	boolean isValid(int g[][],int r,int c,int n,int m,boolean visited[][],int s) {
						if(r==-1||r==n||c==-1||c==m||visited[r][c]||g[r][c]!=s)return false;
						return true;
					}
				
										
											
																					
											
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
									 
										
											}
											
											
											
											
											    