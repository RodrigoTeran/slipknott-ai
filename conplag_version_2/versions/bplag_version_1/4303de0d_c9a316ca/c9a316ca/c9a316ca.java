
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



import static javax.swing.UIManager.get;
import static javax.swing.UIManager.getString;


public class Main {


    static class Pair implements Comparable<Pair> {
        int x = 0;
        int y = 0;

        public Pair(int x1, int y1) {
            x = x1;
            y = y1;
        }


        @Override
        public int compareTo(Pair o) {
            return this.x - o.x;
        }
    }

    static boolean checkPallindrome(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        while (n > 0) {
            list.add(n % 10);
            n /= 10;
        }
        int low = 0, high = list.size() - 1;
        while (low <= high) {
            if (list.get(low) != list.get(high))
                return false;
            low++;
            high--;
        }
        return true;
    }


    static boolean check(String s) {

        int low = 0, high = s.length() - 1;
        while (low <= high) {
            if (s.charAt(low) != s.charAt(high))
                return false;
            low++;
            high--;
        }
        return true;
    }

    class Node implements Comparable<Node> {
        int x = 0, y = 0, z = 0;

        @Override
        public int compareTo(Node o) {
            return this.y - o.y;
        }
    }

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
//(1)very very important**(never take the first problem for granted, always check the test cases) take 5 minutes more and check the edge cases
        // 5 minutes will not decreases rating as much as a wrong submission does it is easy u just think with an open mind and u will surely get the answer
        //(2)let ur brain consume the problem don't just jump to the solution. after reading the problem take a pause 1 minute
        //(3)go through the example test cases and also at least two of ur own test cases.Think of testcases which are difficult(edge cases).dry run ur concept
 //(4) sometimes if else condition is not required but due to if else you miss some points and get wrong answer


        int t = sc.nextInt();
        while (t-- > 0) {

            int n =sc.nextInt();
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            for(int i=0;i<n;i++)
                list.add(new ArrayList<Integer>());

            ArrayList<Pair> list1 = new ArrayList<>();

            for(int i=0;i<n;i++)
            list1.add(new Pair(sc.nextInt(),sc.nextInt()));

            for(int i=0;i<n-1;i++)
            {
                int a =sc.nextInt()-1,b=sc.nextInt()-1;
                list.get(a).add(b);
                list.get(b).add(a);
            }

            long[][] dp = new long[2][n];

            dfs(0,-1,dp,list,list1);


System.out.println(Math.max(dp[0][0],dp[1][0]));
        }



}

static void dfs(int u,int p,long[][] dp,ArrayList<ArrayList<Integer>> list,ArrayList<Pair> list1)
{
    for(int v:list.get(u))
    {  if(v==p)
        continue;
        dfs(v,u,dp,list,list1);
        dp[1][u]+= Math.max(Math.abs(list1.get(u).y-list1.get(v).x)+dp[0][v],Math.abs(list1.get(u).y-list1.get(v).y)+dp[1][v]);
        dp[0][u]+=Math.max(Math.abs(list1.get(u).x-list1.get(v).x)+dp[0][v],Math.abs(list1.get(u).x-list1.get(v).y)+dp[1][v]);

    }

}


//static int lcs( int[] X, int[] Y, int m, int n )
//{
//    int L[][] = new int[m+1][n+1];
//
//    /* Following steps build L[m+1][n+1] in bottom up fashion. Note
//        that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
//    for (int i=0; i<=m; i++)
//    {
//        for (int j=0; j<=n; j++)
//        {
//            if (i == 0 || j == 0)
//                L[i][j] = 0;
//            else if (X[i-1] == Y[j-1])
//                L[i][j] = L[i-1][j-1] + 1;
//            else
//                L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
//        }
//    }
//    return L[m][n];
//}























// syntax of conditional operator y=(x==1)?1:0;
//Things to check when u r getting wrong answer
// 1-  check the flow of the code
//2- If ur stuck read the problem once again
//3- before submitting always check the output format of ur code
//4- don't check standings until problem B is done
//5- if u r thinking ur concept is correct but still u r getting wrong answer try to implement it in another way
//6- By default, java interpret all numeral literals as 32-bit integer values.
// If you want to explicitely specify that this is something bigger then 32-bit integer you should use suffix L for long values.    example   long a = 600851475143L

//All the functions




    long pow(long a,long b,long m)
    {
        a%=m;
        long res=1L;
        while(b>0)
        {
            long temp=b&1;
            if(temp==1)
                res=(res*a)%m;
            a=(a*a)%m;
            b>>=1;
        }
        return res;
    }

    static class DisjointUnionSets {
        int[] rank, parent;
        int n;

        // Constructor
        public DisjointUnionSets(int n)
        {
            rank = new int[n];
            parent = new int[n];
            this.n = n;
            makeSet();
        }

        // Creates n sets with single item in each
        void makeSet()
        {
            for (int i = 0; i < n; i++) {
                // Initially, all elements are in
                // their own set.
                parent[i] = i;
            }
        }

        // Returns representative of x's set
        int find(int x)
        {
            // Finds the representative of the set
            // that x is an element of
            if (parent[x] != x) {
                // if x is not the parent of itself
                // Then x is not the representative of
                // his set,
                parent[x] = find(parent[x]);

                // so we recursively call Find on its parent
                // and move i's node directly under the
                // representative of this set
            }

            return parent[x];
        }

        // Unites the set that includes x and the set
        // that includes x
        void union(int x, int y)
        {
            // Find representatives of two sets
            int xRoot = find(x), yRoot = find(y);

            // Elements are in the same set, no need
            // to unite anything.
            if (xRoot == yRoot)
                return;

            // If x's rank is less than y's rank
            if (rank[xRoot] < rank[yRoot])

                // Then move x under y  so that depth
                // of tree remains less
                parent[xRoot] = yRoot;

                // Else if y's rank is less than x's rank
            else if (rank[yRoot] < rank[xRoot])

                // Then move y under x so that depth of
                // tree remains less
                parent[yRoot] = xRoot;

            else // if ranks are the same
            {
                // Then move y under x (doesn't matter
                // which one goes where)
                parent[yRoot] = xRoot;

                // And increment the result tree's
                // rank by 1
                rank[xRoot] = rank[xRoot] + 1;
            }
        }
    }










    static void debug(String s)
    { System.out.println(s);

    }

    //collections.sort use merge sort instead of quick sort but arrays.sort use quicksort whose worst time complexity is O(n^2)
    static int[] sort(int[] a)
    {         ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<a.length;i++)
            list.add(a[i]);

        Collections.sort(list);
        int ind=0;
        for(int x:list)
            a[ind++]=x;
        return a;

    }

    //function to print an array for debugging
    static void print(int[] a) {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    static void printc(char[] a) {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }


    //normal gcd function, always put the greater number as a and the smaller number as b
    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);

    }

    static int lcm(int a,int b)
    {
        return (a*b)/gcd(a,b);
    }


    //to find gcd and lcm for numbers of long data type
    static long gcdl(long a, long b) {
        if (b == 0)
            return a;
        return gcdl(b, a % b);

    }

    static long lcml(long a,long b)
    {
        return (a*b)/gcdl(a,b);
    }


    //Input Reader to read faster input
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }


        int[] readArray(int n)
        {  int[] a = new int[n];
            for(int i=0;i<n;i++)
                a[i]=nextInt();

            return a;
        }
    }



}

































































