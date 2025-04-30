import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class CodeForces {

    public static void main(String[] args) throws IOException {
        reader input = new reader();
        PrintWriter output = new PrintWriter(System.out);
        //BufferedReader bf = new BufferedReader(new FileReader("input.txt"));
        //PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
        //StringTokenizer stk = new StringTokenizer(bf.readLine());
        //int n=Integer.parseInt(stk.nextToken());
        int n=input.nextInt();
        ArrayList<Integer>seated=new ArrayList<>();
        ArrayList<Integer>empty=new ArrayList<>();
        for(int i=0;i<n;i++){
            int x=input.nextInt();
            if(x==1)
                seated.add(i);
            else
                empty.add(i);
        }
        if(seated.size()==0)
            output.println(0);
        else{
            output.println(helper(seated,empty));
        }
        output.close();
    }
    public static long helper(ArrayList<Integer>seated,ArrayList<Integer>empty){
        long dp[][]=new long[seated.size()+1][empty.size()+1];
        for(int i=1;i<= seated.size();i++){
            dp[i][i]=dp[i-1][i-1]+Math.abs(seated.get(i-1)-empty.get(i-1));
            for(int j=i+1;j<= empty.size();j++){
                dp[i][j]=Math.min(dp[i][j-1],dp[i-1][j-1]+Math.abs(seated.get(i-1)-empty.get(j-1)));
            }
        }
        return dp[seated.size()][empty.size()];

    }

    public static int GCD(int a,int b){
        if(a==0)
            return b;
        else
            return GCD(b%a,a);
    }

    public static boolean isPrime(long num){
        if(num==1)
            return false;
        else if(num==2||num==3)
            return true;
        else if(num%2==0||num%3==0)
            return false;
        else{
            for(long i=5;i*i<=num;i+=6){
                if(num%i==0||num%(i+2)==0)
                    return false;
            }
        }
        return true;
    }

    public static void mergesort(long arr[],int start,int end){//start and end must be indexes
        if(start<end) {
            int mid=(start+end)/2;
            mergesort(arr,start,mid);
            mergesort(arr, mid+1, end);
            merge(arr, start,mid,end);
        }
    }
    public static void merge(long arr[],int start,int mid,int end){
        int lsize=mid-start+1,rsize=end-mid;
        long l[]=new long[lsize],r[]=new long[rsize];
        for(int i=start;i<=mid;i++){
            l[i-start]=arr[i];
        }
        for(int i=mid+1;i<=end;i++){
            r[i-mid-1]=arr[i];
        }
        int i=0,j=0,k=start;
        while(i<lsize&&j<rsize){
            if(l[i]<=r[j]){
                arr[k++]=l[i++];
            }else{
                arr[k++]=r[j++];
            }
        }
        while(i<lsize)
            arr[k++]=l[i++];
        while(j<rsize)
            arr[k++]=r[j++];
    }
}

class Pair{
    int a,b;
    Pair(int a,int b){
        this.a=a;
        this.b=b;
    }
}

class Edge{
    int src,dest,weight;
    Edge(int src,int dest,int weight){
        this.src=src;
        this.dest=dest;
        this.weight=weight;
    }
}

class TempEdge{
    int vertex;
    long distance;
    TempEdge(int vertex,long distance){
        this.vertex=vertex;
        this.distance=distance;
    }
}

//Undirected Graph
class UGraph{
    ArrayList<ArrayList<Edge>>graph;
    int vertex;
    UGraph(int vertex){
        this.vertex=vertex;
        graph=new ArrayList<>();
        for(int i=0;i<vertex;i++){
            graph.add(new ArrayList<>());
        }
    }
    void addEdge(int u,int v){
        graph.get(u).add(new Edge(u,v,0));
        graph.get(v).add(new Edge(v,u,0));
    }
    void addEdge(int u,int v,int weight){
        graph.get(u).add(new Edge(u,v,weight));
        graph.get(v).add(new Edge(v,u,weight));
    }
    ArrayList<Integer> BFS(int source){
        boolean visited[]=new boolean[vertex];
        ArrayList<Integer>ans=new ArrayList<>();
        LinkedList<Integer>q=new LinkedList<>();
        q.add(source);
        visited[source]=true;
        while(!q.isEmpty()){
            int x=q.removeFirst();
            ans.add(x);
            for(Edge i:graph.get(x)){
                if(!visited[i.dest]){
                    q.add(i.dest);
                    visited[i.dest]=true;
                }
            }
        }
        return ans;
    }
    ArrayList<Integer> BFS(){//O(V+E)
        boolean visited[]=new boolean[vertex];
        ArrayList<Integer>ans=new ArrayList<>();
        for(int i=0;i<vertex;i++){
            if(!visited[i]){
                ArrayList<Integer>temp=BFS(i);
                for(int j:temp)
                    ans.add(j);
            }
        }
        return ans;
    }
    int connectedComponentsBFS(){
        boolean visited[]=new boolean[vertex];
        int count=0;
        for(int i=0;i<vertex;i++){
            if(!visited[i]){
                count++;
                BFS(i);
            }
        }
        return count;
    }
    void DFS(int source){
        boolean visited[]=new boolean[vertex];
        DFSHelper(source,visited);
        System.out.println();
    }
    void DFS(){//O(V+E)
        boolean visited[]=new boolean[vertex];
        for(int i=0;i<vertex;i++){
            if(!visited[i]){
                DFSHelper(i,visited);
                System.out.println();
            }
        }
    }
    void DFSHelper(int source,boolean visited[]){
        visited[source]=true;
        System.out.print(source+" ");
        for(Edge i:graph.get(source)){
            if(!visited[i.dest]){
                DFSHelper(i.dest,visited);
            }
        }
    }
    boolean detectCycleDFS(){//O(V+E)
        boolean visited[]=new boolean[vertex];
        for (int i=0;i<vertex;i++){
            if(!visited[i]){
                if(detectCycleDFSHelper(i,-1,visited))
                    return true;
            }
        }
        return false;
    }
    boolean detectCycleDFSHelper(int source,int parent,boolean visited[]){
        visited[source]=true;
        for(Edge i:graph.get(source)){
            if(!visited[i.dest]){
                if(detectCycleDFSHelper(i.dest,source,visited))
                    return true;
            }
            if(i.dest!=parent)
                return true;
        }
        return false;
    }
    boolean detectCycleBFS(){//O(V+E)
        boolean visited[]=new boolean[vertex];
        for (int i=0;i<vertex;i++){
            if(!visited[i]){
                if(detectCycleBFSHelper(i,visited))
                    return true;
            }
        }
        return false;
    }
    boolean detectCycleBFSHelper(int source,boolean visited[]){
        int parent[]=new int[vertex];
        Arrays.fill(parent,-1);
        LinkedList<Integer>q=new LinkedList<>();
        q.add(source);
        visited[source]=true;
        while(!q.isEmpty()){
            int x=q.removeFirst();
            for(Edge i:graph.get(x)){
                if(!visited[i.dest]){
                    q.add(i.dest);
                    visited[i.dest]=true;
                    parent[i.dest]=x;
                }
                else{
                    if(parent[x]!=i.dest)
                        return true;
                }
            }
        }
        return false;
    }
    int primsMST(){
        boolean MST[]=new boolean[vertex];
        TempEdge distarr[]=new TempEdge[vertex];//MST edge stores least distance of a vertex to the MST
        for(int i=0;i<vertex;i++) {
            distarr[i] = new TempEdge(i, Integer.MAX_VALUE);
        }
        distarr[0].distance=0;
        // Use TreeSet instead of PriorityQueue as the remove function of the PQ is O(n) in java
        TreeSet<TempEdge>q=new TreeSet<>((a,b)->(int)(a.distance-b.distance));
        for(int i=0;i<vertex;i++) {
            q.add(distarr[i]);
        }
        int ans=0;
        while(!q.isEmpty()){
            TempEdge x=q.pollFirst();
            ans+=x.distance;
            MST[x.vertex]=true;//Adding in MST
            for(Edge i:graph.get(x.vertex)){
                if(!MST[i.dest]){//Vertex not present in MST
                    if(distarr[i.dest].distance>i.weight){//Updating smallest distance from MST vertices to i.dest
                        q.remove(distarr[i.dest]);
                        distarr[i.dest].distance=i.weight;
                        q.add(distarr[i.dest]);
                    }
                }
            }
        }
        return ans;
    }
    long [] dikstra(int source){
        long ans[]=new long[vertex];
        boolean visited[]=new boolean[vertex];
        Arrays.fill(ans,Integer.MAX_VALUE);
        ans[source]=0;
        //TreeSet may be used as done in prims if removal is required
        PriorityQueue<TempEdge>pq=new PriorityQueue<>((a,b)-> (int) (a.distance-b.distance));
        int count=0;
        pq.add(new TempEdge(source,ans[source]));
        while(count!=vertex-1){//On doing vertex-1 times, last vertex is automatically finalised
            TempEdge x= pq.poll();
            if(!visited[x.vertex]){
                visited[x.vertex]=true;
                count++;
                for(Edge i:graph.get(x.vertex)){
                    /*Checking visited is not necessary as the won't affect the distance in any case
                    but will affect the heap*/
                    if(!visited[i.dest] && ans[i.dest]>ans[x.vertex]+i.weight){
                        ans[i.dest]=ans[x.vertex]+i.weight;
                        pq.add(new TempEdge(i.dest,ans[i.dest]));
                    }
                }
            }
        }
        return ans;
    }
    long[] bellmanford(int source){
        long ans[]=new long[vertex];
        ans[source]=0;
        for(int i=0;i<vertex-1;i++){//Considering paths of length 1 to paths of length (v-1) from source
            for(int j=0;j<vertex;j++){
                for(Edge k:graph.get(j)){
                    if(ans[k.dest]>ans[k.src]+ans[k.weight])
                        ans[k.dest]=ans[k.src]+ans[k.weight];
                }
            }
        }
        return ans;
    }
}

//Directed non-weighted Graph
class DGraph{
    ArrayList<ArrayList<Edge>>graph;
    int vertex;
    DGraph(int vertex){
        this.vertex=vertex;
        graph=new ArrayList<>();
        for(int i=0;i<vertex;i++){
            graph.add(new ArrayList<>());
        }
    }
    void addEdge(int src,int dest){
        graph.get(src).add(new Edge(src,dest,0));
    }
    void addEdge(int src,int dest,int weight){
        graph.get(src).add(new Edge(src,dest,weight));
    }

    boolean detectCycleDFS(){
        boolean visited[]=new boolean[vertex];
        boolean recst[]=new boolean[vertex];
        for(int i=0;i<vertex;i++){
            if(!visited[i]){
                if(detectCycleDFSHelper(i,visited,recst))
                    return true;
            }
        }
        return false;
    }
    boolean detectCycleDFSHelper(int index,boolean visited[],boolean recst[]){
        visited[index]=true;
        recst[index]=true;
        for(Edge i:graph.get(index)){
            if(!visited[i.dest]){
                if(detectCycleDFSHelper(i.dest,visited,recst))
                    return true;
            }else{
                if(recst[i.dest])//Back edge present
                    return true;
            }
        }
        recst[index]=false;
        return false;
    }
    ArrayList<Integer> topologicalSortingBFS(){//Kahn's Algorithm which is valid only for directed acyclic graphs
        ArrayList<Integer>ans=new ArrayList<>();
        int indegree[]=new int[vertex];
        for(int i=0;i<vertex;i++){
            for(Edge j:graph.get(i)){
                indegree[j.dest]++;
            }
        }
        LinkedList<Integer>q=new LinkedList<>();
        for(int i=0;i<vertex;i++){
            if(indegree[i]==0)
                q.add(i);
        }
        while(!q.isEmpty()){
            int i=q.removeFirst();
            ans.add(i);
            for(Edge x:graph.get(i)){
                if(--indegree[x.dest]==0){
                    q.add(x.dest);
                }
            }
        }
        return ans;
    }
    boolean detectCycleTopologicalSort(){
        int count=0;
        int indegree[]=new int[vertex];
        for(int i=0;i<vertex;i++){
            for(Edge j:graph.get(i)){
                indegree[j.dest]++;
            }
        }
        LinkedList<Integer>q=new LinkedList<>();
        for(int i=0;i<vertex;i++){
            if(indegree[i]==0)
                q.add(i);
        }
        while(!q.isEmpty()){
            int i=q.removeFirst();
            count++;
            for(Edge x:graph.get(i)){
                if(--indegree[x.dest]==0){
                    q.add(x.dest);
                }
            }
        }
        return (count!=vertex);
    }
    ArrayList<Integer> topologicalSortingDFS(){
        boolean visited[]=new boolean[vertex];
        ArrayDeque<Integer>recst=new ArrayDeque<>();
        for(int i=0;i<vertex;i++){
            if(!visited[i]){
                topologicalSortingDFSHelper(i,visited,recst);
            }
        }
        ArrayList<Integer>ans=new ArrayList<>();
        while(!recst.isEmpty())
            ans.add(recst.pop());
        return ans;
    }
    void topologicalSortingDFSHelper(int index,boolean visited[],ArrayDeque<Integer>recst){
        visited[index]=true;
        for(Edge i:graph.get(index)){
            if(!visited[i.dest])
                topologicalSortingDFSHelper(i.dest,visited,recst);
        }
        recst.push(index);
    }
    ArrayList<ArrayList<Integer>> stronglyConnectedComponentsKosaraju(){
        ArrayList<Integer>sortedbyendtime=topologicalSortingDFS();
        ArrayList<ArrayList<Edge>>transposegraph=new ArrayList<>();
        for(int i=0;i<vertex;i++){
            transposegraph.add(new ArrayList<>());
        }
        for(int i=0;i<vertex;i++){
            for(Edge j:graph.get(i)){
                transposegraph.get(j.dest).add(new Edge(j.dest,j.src, j.weight));
            }
        }
        ArrayList<ArrayList<Integer>>ans=new ArrayList<>();
        boolean visited[]=new boolean[vertex];
        for(int i:sortedbyendtime){
            if(!visited[i]){
                ArrayList<Integer>curr=DFSTopologicalSort(i,transposegraph,visited);
                ans.add(curr);
            }
        }
        return ans;
    }
    ArrayList<Integer> DFSTopologicalSort(int source,ArrayList<ArrayList<Edge>>graph,boolean visited[]){
        ArrayList<Integer> ans=new ArrayList<>();
        DFSTopologicalSortHelper(source,graph,visited,ans);
        return ans;
    }
    void DFSTopologicalSortHelper(int source,ArrayList<ArrayList<Edge>>graph,boolean visited[],ArrayList<Integer> ans) {
        visited[source]=true;
        ans.add(source);
        for(Edge i:graph.get(source)){
            if(!visited[i.dest])
                DFSTopologicalSortHelper(i.dest,graph,visited,ans);
        }
    }
    long[] bellmanford(int source){
        long ans[]=new long[vertex];
        ans[source]=0;
        for(int i=0;i<vertex-1;i++){//Considering paths of length 1 to paths of length (v-1) from source
            for(int j=0;j<vertex;j++){
                for(Edge k:graph.get(j)){
                    if(ans[k.dest]>ans[k.src]+ans[k.weight])
                        ans[k.dest]=ans[k.src]+ans[k.weight];
                }
            }
        }
        return ans;
    }
}

class reader {
    BufferedReader br;
    StringTokenizer st;
    public reader() {
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
    public int[] nextIntArray(int arraySize) {
        int array[] = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array[i] = nextInt();
        }
        return array;
    }
    public long[] nextLongArray(int arraySize) {
        long array[] = new long[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array[i] = nextLong();
        }
        return array;
    }
}