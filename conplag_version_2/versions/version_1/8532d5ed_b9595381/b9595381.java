import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main{
    
static int dest1;
static int dest2;
public static void main(String args[]){
       	FastScanner in = new FastScanner();
		int test=in.nextInt();
                while(test-->0){
                    int n=in.nextInt();
                    int count[][]=new int[n][5];
                    int total[]=new int[n];
                    String words[]=new String[n];
                    for(int i=0;i<n;i++){
                        words[i]=in.next();
                        for(int j=0;j<words[i].length();j++)
                            count[i][words[i].charAt(j)-'a']++;
                        
                        total[i]=words[i].length();
                    }
                    int max=Integer.MIN_VALUE;
                   for(int i=0;i<5;i++){
                       
                      Integer ans[]=new Integer[n];
                      for(int j=0;j<n;j++){
                          ans[j]=count[j][i]-(total[j]-count[j][i]);
                      }
                      Arrays.sort(ans,Collections.reverseOrder());
                      int j=0;
                      int r=0;
                      while(j<n && r+ans[j]>0){
                          r+=ans[j];
                          j++;
                      }
                      max=Math.max(j,max);
                      
                   }
                   System.out.println(max);
                   
                    
                }
}
public static int solve(int start[], int end[], int n)
    {
        int distance[][]=new int[n][n];
        int r=n;
        int c=n;
        boolean visited[][]=new boolean[n][n];
        int startx=start[0];
        int starty=start[1];
        int endx=end[0];
        int endy=end[1];
        Pair tmp=new Pair(startx,starty);
		Queue<Pair> q=new LinkedList<>();
		q.add(tmp);
		visited[startx][starty]=true;
		distance[startx][starty]=0;
		int dx[]={-2,-1,1,2,2,1,-1,-2};
		int dy[]={1,2,2,1,-1,-2,-2,-1};
		while(!q.isEmpty())
		{
			Pair cell=q.poll();
			int x=cell.x;
			int y=cell.y;
			int d=distance[x][y];
			for(int i=0;i<8;i++)
			{
				int childx=x+dx[i];
				int childy=y+dy[i];
				if(valid(childx,childy,r,c,visited))
				{
					visited[childx][childy]=true;
					distance[childx][childy]=d+1;
					q.add(new Pair(childx,childy));
				}
			}
		}
		return distance[endx][endy];
    }
       
public static boolean valid(int x,int y,int r,int c,boolean visited[][])
	{
		if(x<0||y<0||x>=r||y>=c)
			return false;
		if(visited[x][y])
			return false;
		return true;
	}
public static int knight(int i,int j){
    if(i==dest1 && j==dest2)
        return 0;
    
    if(i<1 || j<1)
        return 0;
    if(i>8 || j>8)
        return 0;
    
    if(i<1 || j>8)
        return 0;
    
    if(i>8 || j<1)
        return 0;
    
    int min=0;
    if(i-1>=1 && j-2>=1)
        min+=1+knight(i-1,j-2);
    if(i-1>=1 && j+2<=8)
        min+=1+knight(i-1,j+2);
    if(i-2>=1 && j-1>=1)
        min+=1+knight(i-2,j-1);
    if(i-2>=1 && j+1<=8)
        min+=1+knight(i-2,j+1);
     if(i+1<=8 && j-2>=1)
        min+=1+knight(i+1,j-2);
    if(i+1<=8 && j+2<=8)
        min+=1+knight(i+1,j+2);
    if(i+2<=8 && j-1>=1)
        min+=1+knight(i+2,j-1);
    if(i+2<=8 && j+1<=8)
        min+=1+knight(i+2,j+1);
    
    return min;
}

}
class FastScanner {
		java.io.BufferedReader br = new java.io.BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
 
		String next() {
			while (!st.hasMoreTokens())
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}
 
		int nextInt() {
			return Integer.parseInt(next());
		}
 
		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}
 
		long nextLong() {
			return Long.parseLong(next());
		}
	}
class Pair
    {
    	int x;
    	int y;
    	Pair(int i,int j)
    	{
    		x=i;
    		y=j;
    	}
    }
 
      



