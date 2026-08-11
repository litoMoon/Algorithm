package niuke;

import java.util.Scanner;

public class Demo3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        long k = in.nextInt();//循环次数
        int aim = 0;
        long result = 0;
        long arr[] = new long[a];
        for (int i = 0; i < a; i++) {
            arr[i] = in.nextInt();
        }
        while(k-- > 0){
            long max = 0;
            int flag = 0;
            for(int i = 0; i < a; i++){
                if(arr[i] >= max && arr[i]%2 == 0) {
                    max = arr[i];
                    aim = i;
                    flag = 1;
                }
            }
            if(flag == 1) arr[aim] = max/2;
        }
        for(int i = 0; i < a; i++){
            result += arr[i];
        }
        System.out.println(result);
    }
}
