import java.io.*;
import java.util.*;
import static java.lang.Math.*;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Codeforces {
    public static void main(String[] args) throws IOException {
        // InputStream inputStream = new FileInputStream("input.txt");
        // OutputStream outputStream = new FileOutputStream("output.txt");
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA solver = new TaskA();
        solver.solve(in.nextInt(), in, out);
        out.close();
    }
    static class TaskA {
        long mod = (long)(1000000007);
        long fact[];
        int depth[];
        int parentTable[][];
        int degree[];
        ArrayList<Integer> leaves;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int diam = 0;

        public void solve(int testNumber, InputReader in, PrintWriter out) throws IOException {
            while(testNumber-->0){
                int n = in.nextInt();
                int a = in.nextInt();
                int b = in.nextInt();
                int na = in.nextInt();
                int nb = in.nextInt();

                ArrayList<ArrayList<Integer>> g = new ArrayList<>();
                for(int i=0;i<=n;i++)
                    g.add(new ArrayList<>());
                for(int i=1;i<n;i++){
                    int u = in.nextInt();
                    int v = in.nextInt();
                    g.get(u).add(v);
                    g.get(v).add(u);
                }

                if(2*na>=nb){
                    out.println("Alice");
                    continue;
                }

                // parentTable = new int[n+1][31];
                depth = new int[n+1];
                diam = 0;
                dfs(g , a , 0);

                int distance = depth[b];
                // out.println(distance);

                if(distance <= na){
                    out.println("Alice");
                    continue;
                }

                if(2*na >= min(nb , diam))
                    out.println("Alice");
                else
                    out.println("Bob");

                // max = Integer.MIN_VALUE;
                // int diameter = diameter(g , 1 , 0);
                // int height = 0;
                // for(int i=1;i<=n;i++)
                //     height = max(height , depth[i]);

                // // out.println("diameter" + diameter);
                // // out.println("height" + height);
                // // out.println("max" + max);

                // diameter = max(diameter-1 , height-1);
                // // diameter = max(diameter , max-1);

                // nb = min(nb , diameter);

                // na = min(na , diameter);


                // if(na*2 >= nb)
                //     out.println("Alice");
                // else
                //     out.println("Bob");


            }
        }

 
        int dfs(ArrayList<ArrayList<Integer>> a , int x, int p) {
            int len = 0;
            for(int y : a.get(x)) {
                if(y != p) {
                    depth[y] = depth[x] + 1;
                    int cur = 1 + dfs(a , y, x);
                    diam = max(diam, cur + len);
                    len = max(len, cur);
                }
            }
            return len;
        }

        public int diameter(ArrayList<ArrayList<Integer>> a , int index , int parent){
            if(index == parent)
                return 0;
            // if(a.get(index).size() == 1 && a.get(index).get(0) == parent)
            //     return 1;
            ArrayList<Integer> x = new ArrayList<>();
            x.add(0);
            x.add(0);
            for(int i=0;i<a.get(index).size();i++){
                if(a.get(index).get(i) == parent)
                    continue;
                x.add(diameter(a , a.get(index).get(i) , index));
            }

            Collections.sort(x);
            if(x.size() >= 4){
                int n = x.size();
                max = max(max , 1+x.get(n-1) + x.get(n-2));
            }

            return 1 + x.get(x.size()-1);

        }

        // public void dfs(ArrayList<ArrayList<Integer>> a , int index , int parent){
        //     parentTable[index][0] = parent;
        //     for(int i=1;i<31;i++)
        //         parentTable[index][i] = parentTable[parentTable[parent][i-1]][i-1];

        //     depth[index] = 1+depth[parent];

        //     int l = a.get(index).size();
        //     for(int i=0;i<l;i++){
        //         if(a.get(index).get(i) == parent)
        //             continue;
        //         dfs(a , a.get(index).get(i) , index);
        //     }

        // }

        public int distance(ArrayList<ArrayList<Integer>> a , int u , int v){
            return depth[u]+depth[v] - 2*depth[lca(a , u , v)];
        }

        public int lca(ArrayList<ArrayList<Integer>> a , int u , int v){
            if(depth[v]<depth[u]){
                int x = u;
                u = v;
                v = x;
            }
            int diff = depth[v] - depth[u];
            for(int i=0;i<parentTable[v].length;i++){
                // checking whether the ith bit is set in the diff variable
                if(((diff>>i)&1) == 1)
                    v = parentTable[v][i];
            }
            if(v == u)
                return v;
            for(int i=parentTable[v].length-1;i>=0;i--){
                if(parentTable[u][i] != parentTable[v][i]){
                    v = parentTable[v][i];
                    u = parentTable[u][i];
                }
            }
            return parentTable[u][0];
        }

        class Pair{
            int start;
            int end;
            int index;
            public Pair(int a , int b , int c){
                start = a;
                end = b;
                end = c;
            }
        }


        class Node{
            char value;
            Node left;
            Node right;
            public Node(char value){
                this.value = value;
                left = null;
                right = null;
            }
        }
        

        public int[][] multiply(int a[][] , int b[][]){
            int c[][] = new int[a.length][b[0].length];
            for(int i=0;i<a.length;i++){
                for(int j=0;j<b[0].length;j++){
                    for(int k=0;k<b.length;k++)
                        c[i][j] += a[i][k]*b[k][j];
                }
            }
            return c;
        }

        public int[][] multiply(int a[][] , int b[][] , int mod){
            int c[][] = new int[a.length][b[0].length];
            for(int i=0;i<a.length;i++){
                for(int j=0;j<b[0].length;j++){
                    for(int k=0;k<b.length;k++){
                        c[i][j] += a[i][k]*b[k][j];
                        c[i][j]%=mod;
                    }
                }
            }
            return c;
        }

        public int[][] pow(int a[][] , long b){
            int res[][] = new int[a.length][a[0].length];
            for(int i=0;i<a.length;i++)
                res[i][i] = 1;
            while(b>0){
                if((b&1) == 1)
                    res = multiply(res , a , 10);
                a = multiply(a , a , 10);
                b>>=1;
            }
            return res;
        }

        

        // for the min max problems
        public void build(int lookup[][] , int arr[], int n) { 
            for (int i = 0; i < n; i++) 
                lookup[i][0] = arr[i]; 
            for (int j = 1; (1 << j) <= n; j++) { 
                for (int i = 0; (i + (1 << j) - 1) < n; i++) { 
                    if (lookup[i][j - 1] > lookup[i + (1 << (j - 1))][j - 1]) 
                        lookup[i][j] = lookup[i][j - 1]; 
                    else
                        lookup[i][j] = lookup[i + (1 << (j - 1))][j - 1]; 
                } 
            } 
        }
        public int query(int lookup[][] , int L, int R) { 
            int j = (int)(Math.log(R - L + 1)/Math.log(2)); 
            if (lookup[L][j] >= lookup[R - (1 << j) + 1][j]) 
                return lookup[L][j]; 
            else
                return lookup[R - (1 << j) + 1][j]; 
        }

        // for printing purposes
        public void print1d(int a[] , PrintWriter out){
            for(int i=0;i<a.length;i++)
                out.print(a[i] + " ");
            out.println();
        }
        public void print1d(long a[] , PrintWriter out){
            for(int i=0;i<a.length;i++)
                out.print(a[i] + " ");
            out.println();
        }
        public void print2d(int a[][] , PrintWriter out){
            for(int i=0;i<a.length;i++){
                for(int j=0;j<a[i].length;j++)
                    out.print(a[i][j] + " ");
                out.println();
            }
            // out.println();
        }
        public void print2d(long a[][] , PrintWriter out){
            for(int i=0;i<a.length;i++){
                for(int j=0;j<a[i].length;j++)
                    out.print(a[i][j] + " ");
                out.println();
            }
            // out.println();
        }


        public void sieve(int a[]){
            a[0] = a[1] = 1;
            int i;
            for(i=2;i*i<=a.length;i++){
                if(a[i] != 0)
                    continue;
                a[i] = i;
                for(int k = (i)*(i);k<a.length;k+=i){
                    if(a[k] != 0)
                        continue;
                    a[k] = i;
                }
            }
        }

        public long nCrPFermet(int n , int r , long p){
            if(r==0)
                return 1l;
            // long fact[] = new long[n+1];
            // fact[0] = 1;
            // for(int i=1;i<=n;i++)
            //     fact[i] = (i*fact[i-1])%p;
            long modInverseR = pow(fact[r] , p-2 , p);
            long modInverseNR = pow(fact[n-r] , p-2 , p);
            long w = (((fact[n]*modInverseR)%p)*modInverseNR)%p;
            return w;
        }
        public long pow(long a, long b, long m) {
            a %= m;
            long res = 1;
            while (b > 0) {
                long x = b&1;
                if (x == 1)
                    res = res * a % m;
                a = a * a % m;
                b >>= 1;
            }
            return res;
        }
        public long pow(long a, long b) {
            long res = 1;
            while (b > 0) {
                long x = b&1;
                if (x == 1)
                    res = res * a;
                a = a * a;
                b >>= 1;
            }
            return res;
        }
        public void sortedArrayToBST(TreeSet<Integer> a , int start, int end) { 
            if (start > end) {
                return;
            }
            int mid = (start + end) / 2;
            a.add(mid);
            sortedArrayToBST(a, start, mid - 1);
            sortedArrayToBST(a, mid + 1, end); 
        }
        class Combine{
            int value;
            int delete;
            Combine(int val , int delete){
                this.value = val;
                this.delete = delete;
            }
        }
        class Sort2 implements Comparator<Combine>{
            public int compare(Combine a , Combine b){
                if(a.value > b.value)
                    return 1;
                else if(a.value == b.value && a.delete>b.delete)
                    return 1;
                else if(a.value == b.value && a.delete == b.delete)
                    return 0;
                return -1;
            }
        }
        public int lowerLastBound(ArrayList<Integer> a , int x){
            int l = 0;
            int r = a.size()-1;
            if(a.get(l)>=x)
                return -1;
            if(a.get(r)<x)
                return r;
            int mid = -1;
            while(l<=r){
                mid = (l+r)/2;
                if(a.get(mid) == x && a.get(mid-1)<x)
                    return mid-1;
                else if(a.get(mid)>=x)
                    r = mid-1;
                else if(a.get(mid)<x && a.get(mid+1)>=x)
                    return mid;
                else if(a.get(mid)<x && a.get(mid+1)<x)
                    l = mid+1;
            }
            return mid;
        }
        public int upperFirstBound(ArrayList<Integer> a , Integer x){
            int l = 0;
            int r = a.size()-1;
            if(a.get(l)>x)
                return l;
            if(a.get(r)<=x)
                return r+1;
            int mid = -1;
            while(l<=r){
                mid = (l+r)/2;
                if(a.get(mid) == x && a.get(mid+1)>x)
                    return mid+1;
                else if(a.get(mid)<=x)
                    l = mid+1;
                else if(a.get(mid)>x && a.get(mid-1)<=x)
                    return mid;
                else if(a.get(mid)>x && a.get(mid-1)>x)
                    r = mid-1;
            }
            return mid;
        }
        public int lowerLastBound(int a[] , int x){
            int l = 0;
            int r = a.length-1;
            if(a[l]>=x)
                return -1;
            if(a[r]<x)
                return r;
            int mid = -1;
            while(l<=r){
                mid = (l+r)/2;
                if(a[mid] == x && a[mid-1]<x)
                    return mid-1;
                else if(a[mid]>=x)
                    r = mid-1;
                else if(a[mid]<x && a[mid+1]>=x)
                    return mid;
                else if(a[mid]<x && a[mid+1]<x)
                    l = mid+1;
            }
            return mid;
        }
        public int upperFirstBound(long a[] , long x){
            int l = 0;
            int r = a.length-1;
            if(a[l]>x)
                return l;
            if(a[r]<=x)
                return r+1;
            int mid = -1;
            while(l<=r){
                mid = (l+r)/2;
                if(a[mid] == x && a[mid+1]>x)
                    return mid+1;
                else if(a[mid]<=x)
                    l = mid+1;
                else if(a[mid]>x && a[mid-1]<=x)
                    return mid;
                else if(a[mid]>x && a[mid-1]>x)
                    r = mid-1;
            }
            return mid;
        }
        public long log(float number , int base){
            return (long) Math.ceil((Math.log(number) / Math.log(base)) + 1e-9);
        }
        public long gcd(long a , long b){
            if(a<b){
                long c = b;
                b = a;
                a = c;
            }
            while(b!=0){
                long c = a;
                a = b;
                b = c%a;
            }
            return a;
        }
        public long[] gcdEx(long p, long q) {
            if (q == 0)
                return new long[] { p, 1, 0 };
            long[] vals = gcdEx(q, p % q);
            long d = vals[0];
            long a = vals[2];
            long b = vals[1] - (p / q) * vals[2];
            // 0->gcd 1->xValue 2->yValue
            return new long[] { d, a, b };
        }
        public void sievePhi(int a[]){
            a[0] = 0;
            a[1] = 1;
            for(int i=2;i<a.length;i++)
                a[i] = i-1;
            for(int i=2;i<a.length;i++)
                for(int j = 2*i;j<a.length;j+=i)
                    a[j] -= a[i];
        }
        public void lcmSum(long a[]){
            int sievePhi[] = new int[(int)1e6 + 1];
            sievePhi(sievePhi);
            a[0] = 0;
            for(int i=1;i<a.length;i++)
                for(int j = i;j<a.length;j+=i)
                    a[j] += (long)i*sievePhi[i];
        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

    }
}