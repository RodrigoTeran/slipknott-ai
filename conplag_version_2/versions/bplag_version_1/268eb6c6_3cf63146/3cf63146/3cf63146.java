import java.util.*;
import java.io.*;

public class Test {
  // Fast IO class
  static class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
      boolean env = System.getProperty("ONLINE_JUDGE") != null;
      // env=true;
      if (!env) {
        try {
          br = new BufferedReader(new FileReader("src/input.txt"));
        } catch (FileNotFoundException e) {
          e.printStackTrace();
        }
      } else br = new BufferedReader(new InputStreamReader(System.in));
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
  }

  static FastReader sc = new FastReader();
  static PrintWriter out = new PrintWriter(System.out);

  public static void main(String[] args) {
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] a = new int[k];
      int[] temp = new int[n];
      for (int i = 0; i < k; i++) a[i] = sc.nextInt();
      for (int i = 0; i < k; i++) temp[a[i] - 1] = sc.nextInt();
      int[] left = new int[n];
      int[] right = new int[n];
      Arrays.fill(left, Integer.MAX_VALUE - 1);
      Arrays.fill(right, Integer.MAX_VALUE - 1);
      if (temp[0] > 0) left[0] = temp[0];
      for (int i = 1; i < n; i++) {
        left[i] = Math.min(left[i - 1] + 1, left[i]);
        if (temp[i] > 0) left[i] = Math.min(left[i], temp[i]);
      }
      if (temp[n - 1] > 0) right[n - 1] = temp[n - 1];
      for (int i = n - 2; i >= 0; i--) {
        right[i] = Math.min(right[i + 1] + 1, right[i]);
        if (temp[i] > 0) right[i] = Math.min(right[i], temp[i]);
      }
      for (int i = 0; i < n; i++) out.print(Math.min(left[i], right[i]) + " ");
      out.println();
    }
    out.flush();
    out.close();
  }
}
