import java.io.*;
import java.util.*;
 
 
public class Mainnn{
    // static final File ip = new File("input.txt");
    // static final File op = new File("output.txt");
    // static {
    //     try {
    //         System.setOut(new PrintStream(op));
    //         System.setIn(new FileInputStream(ip));
    //     } catch (Exception e) {
    //     }

    //     // in = new InputReader(System.in);
    // }



   public static void main(String[] args) {
      MyScanner sc = new MyScanner();
      out = new PrintWriter(new BufferedOutputStream(System.out));
      
      //out.println(result);                    // print via PrintWriter
      /////////////////////////////////////////////

        int test = sc.nextInt();
        while(test-- != 0)
        {
            int n = sc.nextInt();
            String[] info = new String[n];
            for (int i = 0; i < n; i++) {
                info[i] = sc.next();
            }
            int ans = 0;
            for (int i = 0; i < 5; i++) {
                char cur = (char) (i+'a');
                int[] map = new int[n];
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < info[j].length(); k++) {
                        if(info[j].charAt(k)==cur)map[j]++;
                        else map[j]--;
                    }
                }
                Arrays.sort(map);
                int sum = 0;
                for(int j = n-1; j >= 0; j--) {
                    sum += map[j];
                    if(sum<=0){
                        break;
                    }
                    ans = Math.max(ans,n-j);
                }
            }
            System.out.println(ans);
        }





      /////////////////////////////////////////////
      // Stop writing your solution here. -------------------------------------
      out.close();
   }
   
   static void shuffleArrayL(long[] arr) {
    int n = arr.length;
    Random rnd = new Random();
    for (int i = 0; i < n; ++i) {
        long tmp = arr[i];
        int randomPos = i + rnd.nextInt(n - i);
        arr[i] = arr[randomPos];
        arr[randomPos] = tmp;
    }
}

   //-----------PrintWriter for faster output---------------------------------
   public static PrintWriter out;
      
   //-----------MyScanner class for faster input----------
   public static class MyScanner {
      BufferedReader br;
      StringTokenizer st;
 
      public MyScanner() {
         br = new BufferedReader(new InputStreamReader(System.in));
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
 
      String nextLine(){
          String str = "";
	  try {
	     str = br.readLine();
	  } catch (IOException e) {
	     e.printStackTrace();
	  }
	  return str;
      }

   }
   //--------------------------------------------------------
}