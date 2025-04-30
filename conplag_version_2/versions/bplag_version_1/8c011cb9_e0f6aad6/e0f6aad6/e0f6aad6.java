
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static  ArrayList<Integer> primeupton(int n)
    {
        ArrayList<Integer> ans= new ArrayList<>();
        boolean prime[] = new boolean[n + 1];
        for (int i = 0; i <= n; i++)
            prime[i] = true;

        for (int p = 2; p * p <= n; p++)
        {

            if (prime[p] == true)
            {

                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
            }
        }

        // Print all prime numbers
        for (int i = 2; i <= n; i++)
        {
            if (prime[i] == true)
                ans.add(i);
        }

        return ans;
    }

    public static Map<Integer,Integer> primeFactors(int n)
    {
        HashMap<Integer,Integer> map= new HashMap<>();
        int count=0;
        while (n%2==0)
        {
            count++;
            n /= 2;
        }
        map.put(2,count);
        for (int i = 3; i <= Math.sqrt(n); i+= 2)
        {
            count=0;
            while (n%i == 0)
            {
                count++;
                n /= i;
            }
            map.put(i,count);
        }
        if (n > 2)
            map.put(n,1);

        return map;
    }
    public static String toBinary(int decimal){
        StringBuilder ans= new StringBuilder();

        while(decimal > 0){
            ans.append(decimal%2) ;
            decimal = decimal/2;
        }

        return ans.reverse().toString();
    }
    private static LinkedList[] adj;
    static class Sortbyroll implements Comparator<Pair> {
        @Override
        public int compare(Pair o1, Pair o2) {
            return o1.b-o2.b;
        }

        // Method
        // Sorting in ascending order of roll number




    }
    static class Pair {
        int a;
        int b;


        Pair(int a, int b) {
            this.a = a;
            this.b = b;

        }
        public int getB(){
            return b;
        }
    }
    static int gcd(int a, int b)
    {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
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
    static int sum (int n){
        return n*(n+1)/2;
    }
    public static void main(String[] args) throws Exception {
        // your code goes here
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Set<String> list1= new HashSet<>();
            Set<String> list2= new HashSet<>();
            Set<String> list3= new HashSet<>();
            int flag=0;
            for(int i=0;i<n;i++) {
                String s = sc.next();
                if (flag == 1) {
                   list1.add(s);
                }
                else
                {
                    if (s.length() == 1) {
                        flag = 1;
                    } else if (s.length() == 2) {
                        list2.add(s);
                        StringBuilder x = new StringBuilder();
                        x.append(s.charAt(1));
                        x.append(s.charAt(0));
                        if (list3.contains(x.toString()) || list2.contains(x.toString())) {
                            flag = 1;
                        }
                    } else {
                        list1.add(s);
                        list3.add(s.substring(0, 2));
                        StringBuilder x = new StringBuilder();
                        x.append(s.charAt(2));
                        x.append(s.charAt(1));
                        x.append(s.charAt(0));

                        if (list1.contains(x.toString())) flag = 1;
                        StringBuilder y = new StringBuilder();
                        y.append(s.charAt(2));
                        y.append(s.charAt(1));
                        if (list2.contains(y.toString())) flag = 1;

                    }


                }
            }

            if(flag!=1){
                System.out.println("NO");
            } else
                System.out.println("YES");
        }
    }

}