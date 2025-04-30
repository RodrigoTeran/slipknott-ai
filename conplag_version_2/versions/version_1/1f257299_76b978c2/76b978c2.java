import java.io.*;
import java.util.*;
public class check1  {

//    public static void find(int n,int arr[])
//    {
//
//    }
//    2,1,3,4
    public static void main(String[] args) throws IOException{

        Reader sc=new Reader();
//        PrintWriter out = new PrintWriter(System.out);

        int t=sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt();
            int p[]=new int[n];
            System.out.println("? 1");
            System.out.flush();
            int t1 = sc.nextInt();

            Set<Integer> hs = new HashSet<>();
            int i=1;
            int prev=1;
            int cnt=1;
            while(i<n && cnt<2*n)
            { 
                if(p[prev-1]!=0)
                {
                    i++;
                    if(i>=n || cnt>=2*n) break;
                    System.out.println("? "+i);
                    System.out.flush();
                    cnt++;

                    int t2 = sc.nextInt();
                    prev=t2;
                    continue;
                }
                String s1 = "? "+i;
                System.out.println(s1);
                System.out.flush();
                int tt = sc.nextInt();
                
                cnt++;                
                p[prev-1]=tt;
                prev=tt;
            }
            long sum=0;
            int ind=-1;
            for(i=0;i<n;i++)
            {
                sum+=p[i];
                if(p[i]==0) ind=i;
            }
            long diff = n*(n+1)-sum*2;
            if(diff>0)
            {
                p[ind]=(int)(diff/2);
            }
            System.out.print("!");
            for(i=0;i<n;i++)
            {
                System.out.print(" "+p[i]);
            }

//            out.println(Arrays.toString(p));
            System.out.println();
            System.out.flush();
        }
        System.out.flush();
    }

    public static long power(long x,long power)
    {
        if(power==0) return 1;

        long ans1 = power(x,power/2);
        ans1=ans1*ans1;

        if(power%2==0) return ans1;
        return x*ans1;
    }

    //    (a*a_inverse) = 1(mod m)
//    finding a_inverse
    public static long modInverse(long a,long m)
    {
//        works only when m is prime
        long g=gcd(a,m);
        if(g==1) return power(a,m-2,m);
        else return -1;
    }

    //    (x^power)mod(m)
    public static long power(long x,long power,long m)
    {
        if(power==0) return 1;

        long p = power(x,power/2,m)%m;
        p = (p*p)%m;

        if(power%2==0) return p;
        return (x*p)%m;
    }
    public static long gcd(long small,long large)
    {
        if(small==0) return large;
        return gcd(large % small,small);
    }

    public static boolean isprime(long no)
    {
        if(no<=1) return false;
        if(no<=3) return true;
        if(no%2==0 || no%3==0) return false;
        // 6k+1 6k+5 can be prime
        for(long i=5;i*i<=no;i+=6)
        {
            if(no%(i)==0 || no%(i+2)==0)
                return false;
        }
        return true;
    }

    //    prime no smaller than or equal to n
    public static boolean[] prime_nos_till_no(int no)
    {
        boolean prime[]=new boolean[no+1];
//        prime[i]== true means prime
//        prime[i]== false means not a prime
//        initialize prime array as true

        Arrays.fill(prime,true);
        prime[0]=false;
        for(int i=2;i*i<=no;i++)
        {
            if(prime[i]==true)
            {
                for(int j=i*i;j<=no;j+=i)
                {
                    prime[j]=false;
                }
            }
        }
        return prime;

    }
    public static void shufflearray(long arr[])
    {


        int n=arr.length;
        Random rand=new Random();
        for(int i=0;i<n;i++)
        {
            long temp=arr[i];
            int randomPos=i+rand.nextInt(n-i);
            arr[i]=arr[randomPos];
            arr[randomPos]=temp;
        }
    }
    //       Arrays.sort(arr, new Comparator<pair>() {
//        //@Override
//        public int compare(pair o1, pair o2) {
//            long l1=o1.a-o2.a;
//            if(l1<0L) return -1;
//            if(l1==0) return 0;
//            return 1;
//        }
//    });
    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String nextLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }
        public boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() throws IOException{
            int c = read();
            while (isSpaceChar(c)) c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }


        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }

    }

}