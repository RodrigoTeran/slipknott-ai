import java.util.*;
import java.lang.*;
import java.io.*;
public class MyAnswer {
     public static void main(String[] args)throws IOException{
          FastScanner scan = new FastScanner();
          //SuperFastScanner scan = new SuperFastScanner();
          PrintWriter out = new PrintWriter(System.out);
          StringBuilder result = new StringBuilder();
     
          int t = scan.nextInt();
          while (t-- > 0){
               int n = scan.nextInt();
               int arr[] = scan.nextIntArray(n);
               if(n%2==0){
                    int j = n/2;
                    for(int i = j;i<n;i++){
                         int val = arr[i] * -1;
                         result.append(val + " ");
                    }
                    for(int i = 0;i<j;i++){
                         int val = arr[i] ;
                         result.append(val + " ");
                    }
               }else{
                    int j = (n-3)/2;
                    for(int i = j;i<n-3;i++){
                         int val = arr[i] * -1;
                         result.append(val + " ");
                    }
                    for(int i = 0;i<j;i++){
                         int val = arr[i] ;
                         result.append(val + " ");
                    }
                    
                    if(arr[n-3]+arr[n-2] !=0 ){
                         int sum = arr[n-3] + arr[n-2];
                         sum *=-1;
                         result.append(arr[n-1] + " ");
                         result.append(arr[n-1] + " ");
                         result.append(sum+ " ");
                         
                    }else if(arr[n-1]+arr[n-2] !=0 ){
                         int sum = arr[n-1] + arr[n-2];
                         sum *=-1;
                         result.append(sum+ " ");
                         result.append(arr[n-3] + " ");
                         result.append(arr[n-3]+" ");
                         
                    }else{
                         int sum = arr[n-1] + arr[n-3];
                         sum *=-1;
                         result.append(arr[n-2] + " ");
                         result.append(sum+ " ");
                         result.append(arr[n-2]+ " ");
                    }
                         
               }
               result.append("\n");
               
          }
          out.println(result);
          out.flush();
     }
     public static int solve(String str,char ch){
          int ans = 0;
          int l = str.length();
          int i = 0,j = l-1;
          while(i<=j){
               char a = str.charAt(i);
               char b = str.charAt(j);
               if(a==b){
                    i++;
                    j--;
               }else{
                    if(a==ch){
                         i++;
                         ans++;
                    }else if(b==ch){
                         j--;
                         ans++;
                    }else{
                         return 10000000;
                    }
               }
          }
          return ans;
     }

     static class FastScanner{ //10^5 -- .15 sec && 4*10^6 ---> .86 sec

          BufferedReader br;
          StringTokenizer st;
          
          public FastScanner(){
               br = new BufferedReader(new InputStreamReader(System.in));
          }
          public String next(){
               while (st == null || !st.hasMoreElements()){
               try{
                    st = new StringTokenizer(br.readLine());
               }catch (IOException  e){
                    e.printStackTrace();
               }
               }
               return st.nextToken();
          }
          public int nextInt(){
               return Integer.parseInt(next());
          }
          public long nextLong(){
               return Long.parseLong(next());
          }
          public double nextDouble(){
               return Double.parseDouble(next());
          }
          public String nextLine(){
               String str = "";
               try{
                    str = br.readLine();
               }catch (IOException e){
                    e.printStackTrace();
               }
               return str;
          }
          public int[] nextIntArray(int n){
               int arr[] = new int[n];
               for(int i = 0;i<n;i++){
                    arr[i] = nextInt();
               }
               return arr;
          }
          public long[] nextLongArray(int n){
               long arr[] = new long[n];
               for(int i = 0;i<n;i++){
                    arr[i] = nextLong();
               }
               return arr;
          }
          public double[] nextDoubleArray(int n){
               double arr[] = new double[n];
               for(int i = 0;i<n;i++){
                    arr[i] = nextDouble();
               }
               return arr;
          }
          public String[] nextStringArray(int n){
               String arr[] = new String[n];
               for(int i = 0;i<n;i++){
                    arr[i] = next();
               }
               return arr;
          }
    }
     

}
