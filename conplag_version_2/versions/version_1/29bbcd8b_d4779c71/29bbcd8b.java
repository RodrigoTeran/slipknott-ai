
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class D {

   private static final String INPUT_FILE_PATH = "";

   void solve() {
      int n = in.nextInt();
      int[] h = new int[n];
      for (int i = 0; i < n; i++) h[i] = in.nextInt();

      Stack<Integer> increasing = new Stack();
      Stack<Integer> increasingIndices = new Stack();
      Stack<Integer> decreasing = new Stack();
      Stack<Integer> decreasingIndices = new Stack();
      increasing.push(h[0]);
      increasingIndices.push(0);
      decreasing.push(h[0]);
      decreasingIndices.push(0);

      int[] dp = new int[n];
      dp[0] = 0;

      for (int i = 1; i < n; i++) {
         dp[i] = dp[i - 1] + 1;

         while (!increasing.isEmpty() && increasing.peek() > h[i]) {
            dp[i] = Math.min(dp[i], 1 + dp[increasingIndices.peek()]);

            increasing.pop();
            increasingIndices.pop();
         }
         while (!decreasing.isEmpty() && decreasing.peek() < h[i]) {
            dp[i] = Math.min(dp[i], 1 + dp[decreasingIndices.peek()]);

            decreasing.pop();
            decreasingIndices.pop();
         }

         if (!increasing.isEmpty()) {
            dp[i] = Math.min(dp[i], 1 + dp[increasingIndices.peek()]);
         }
         if (!decreasing.isEmpty()) {
            dp[i] = Math.min(dp[i], 1 + dp[decreasingIndices.peek()]);
         }

         if (!increasing.isEmpty() && increasing.peek() == h[i]) {
            increasing.pop();
            increasingIndices.pop();
         }
         if (!decreasing.isEmpty() && decreasing.peek() == h[i]) {
            decreasing.pop();
            decreasingIndices.pop();
         }

         increasing.push(h[i]);
         increasingIndices.push(i);
         decreasing.push(h[i]);
         decreasingIndices.push(i);
      }
      out.println(dp[n - 1]);
   }

   private final InputReader in;
   private final PrintWriter out;

   private D(InputReader in, PrintWriter out) {
      this.in = in;
      this.out = out;
   }

   private static class InputReader {
      private BufferedReader br;
      private StringTokenizer st;

      public InputReader(InputStream inputStream) {
         this.br = new BufferedReader(new InputStreamReader(inputStream), 32768);
         this.st = null;
      }

      public String nextToken() {
         while (st == null || !st.hasMoreTokens()) {
            try {
               st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
               throw new RuntimeException(e);
            }
         }
         return st.nextToken();
      }

      public int nextInt() {
         return Integer.parseInt(nextToken());
      }

      public long nextLong() {
         return Long.parseLong(nextToken());
      }

      public double nextDouble() {
         return Double.parseDouble(nextToken());
      }
   }

   public static void main(String[] args) throws Exception {
      InputStream inputStream = INPUT_FILE_PATH.isEmpty()
         ? System.in
         : new FileInputStream(new File(INPUT_FILE_PATH));
      OutputStream outputStream = System.out;

      InputReader inputReader = new InputReader(inputStream);
      PrintWriter printWriter = new PrintWriter(outputStream);

      new D(inputReader, printWriter).solve();

      printWriter.close();
   }

}
