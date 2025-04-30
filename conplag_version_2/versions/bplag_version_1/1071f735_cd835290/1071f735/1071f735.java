import java.util.*;

public class CP {
    public static int[] swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }


    static int isPowerOfTwo(int n)
    {
        if(n == 0 )
        return 0;
        while(n != 1)
        {
            if(n % 2 != 0)
            return 0;
            n = n / 2;    
        }
        return 1;
    }

    public static void printArr(int[] a){
        for(int i=0; i<a.length; i++){
            System.out.print(a[i]+1+" ");
        }
        System.out.println();
    }

    public static class Pair implements Comparable<Pair> {
        int val;
        int idx;

        Pair(int a, int b){
            this.val = a;
            this.idx = b;
        }

        public int compareTo(Pair o){
            return this.val - o.val;
        }
    }


    public static void main(String[] args) {
        // CF1
        // Scanner sc = new Scanner(System.in);
        // int t = sc.nextInt();
        // for (int i = 0; i < t; i++) {
        //     int n = sc.nextInt();
        //     int x = sc.nextInt();
        //     int[] arr = new int[n];
        //     int sum = 0;
        //     for (int j = 0; j < n; j++) {
        //         arr[j] = sc.nextInt();
        //         sum += arr[j];
        //     }
        //     if (x == sum) {
        //         System.out.println("NO");
        //     } else if (x > sum) {
        //         System.out.println("YES");
        //         for (int j = 0; j < n; j++) {
        //             System.out.print(arr[j] + " ");
        //         }
        //         System.out.println();
        //     } else {// x<sum
        //         Arrays.sort(arr);
        //         int curr = 0;
        //         int k = 0;
        //         while ((curr != x) && (k < n)) {
        //             curr += arr[k];
        //             k++;
        //         }
        //         if(k==n) {
        //             System.out.println("YES");
        //             for (int j = 0; j < n; j++) {
        //                 System.out.print(arr[j] + " ");
        //             }
        //             System.out.println();
        //         }
        //         else if (curr == x) {
                    
        //             arr = swap(arr, k-1, n - 1);
        //             System.out.println("YES");
        //             for (int j = 0; j < n; j++) {
        //                 System.out.print(arr[j] + " ");
        //             }
        //             System.out.println();
                
        //         }else{
        //             System.out.println("NO");
        //         }

        //     }

        // }



        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int x = sc.nextInt();
            int[] arr = new int[n];
            int[] ans = new int[n];
            for (int j = 0; j < n; j++) {
                        arr[j] = sc.nextInt();
            }
            PriorityQueue<Pair> pq=new PriorityQueue<>();
            for (int j = 0; j < m; j++) {
                pq.add(new Pair(arr[j],j));
                ans[j]=j;
    }
    for (int j = m; j < n; j++) {
        Pair p=pq.remove();
        pq.add(new Pair(p.val+arr[j],p.idx));
        ans[j]=p.idx;
        }
        System.out.println("YES");
        printArr(ans); 

    }
}
}