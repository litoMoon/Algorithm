package niuke;

import java.util.Scanner;

public class Demo10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int []arr = new int[n];
        int pri = 0;
        int cur = 0;
        int dev = 0;
        for(int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }
        for(int i = 1; i < n; i++){
            dev = arr[i] - arr[cur];
            pri = Math.max(dev,pri);
            if(dev < 0) cur = i;
        }

        System.out.println(pri);

    }
}
