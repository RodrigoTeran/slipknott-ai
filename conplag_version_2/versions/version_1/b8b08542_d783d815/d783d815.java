//package codeforce.div3.r734;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

import static java.lang.System.out;
import static java.util.stream.Collectors.joining;


public class C {
  static FastScanner sc = new FastScanner(System.in);

  public static void main(String[] args) {
    try (PrintWriter out = new PrintWriter(System.out)) {
      int T = sc.nextInt();
      for (int tt = 1; tt <= T; tt++) {
        int n = sc.nextInt();
        String[] strings = new String[n];
        PriorityQueue<Pair>[] frequencies = new PriorityQueue[5];
        for (int i = 0; i < 5; i++)
          frequencies[i] = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
          strings[i] = sc.next();
          int[] freq = new int[5];
          for (char c : strings[i].toCharArray())
            freq[c - 'a']++;
          for (int j = 0; j < 5; j++) {
            //if (freq[j] > 0)
            frequencies[j].add(new Pair(freq[j], strings[i].length()));
          }
        }
      /*  for (int i = 0; i < 5; i++) {
          while (!frequencies[i].isEmpty())
            System.out.print(frequencies[i].remove() + ", ");
          System.out.println();
        }*/

        int ans = 0;
        for (PriorityQueue<Pair> pq : frequencies) {
          long curlen = 0;
          long curfreq = 0;
          int cnt = 0;
          while (!pq.isEmpty()) {
            Pair pair = pq.remove();
            curfreq += pair.freq;
            curlen += pair.len;
            if (curfreq >= curlen / 2 + 1) {
              cnt++;
            } else {
              break;
            }
          }
          ans = Math.max(ans, cnt);
        }
        System.out.println(ans);
      }
    }

  }

  static class Pair implements Comparable<Pair> {
    int freq, len;

    public Pair(int freq, int len) {
      this.freq = freq;
      this.len = len;
    }

    @Override
    public int compareTo(Pair o) {
      /*if(freq == 0 && o.freq == 0)
        return len - o.len;
      if(freq == 0) 
        return len - (o.len - o.freq);
      if(o.freq == 0)
        return o.len - (len - freq);
      int diff1 = freq * o.len;
      int diff2 = o.freq * len;
      return diff2 - diff1;*/
      return -(o.len - 2*o.freq  - len + 2*freq);
    }

    @Override
    public String toString() {
      return freq + " " + len;
    }
  }
  /*
1  
5
cbdca
d
a
d
eb
   */

  static class FastScanner {
    BufferedReader br;
    StringTokenizer st;

    public FastScanner(File f) {
      try {
        br = new BufferedReader(new FileReader(f));
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }
    }

    public FastScanner(InputStream f) {
      br = new BufferedReader(new InputStreamReader(f), 32768);
    }

    String next() {
      while (st == null || !st.hasMoreTokens()) {
        String s = null;
        try {
          s = br.readLine();
        } catch (IOException e) {
          e.printStackTrace();
        }
        if (s == null)
          return null;
        st = new StringTokenizer(s);
      }
      return st.nextToken();
    }

    boolean hasMoreTokens() {
      while (st == null || !st.hasMoreTokens()) {
        String s = null;
        try {
          s = br.readLine();
        } catch (IOException e) {
          e.printStackTrace();
        }
        if (s == null)
          return false;
        st = new StringTokenizer(s);
      }
      return true;
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
  }
}
