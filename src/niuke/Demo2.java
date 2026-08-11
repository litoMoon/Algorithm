package niuke;

import java.util.Arrays;
import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();//数组长度
        int aim = in.nextInt();
        int sum=0;
        int arr[] = new int[len+1];
        int compare = 100000000;//比较长度大小
        int result = 0;
        int left = 1,right = 2;
        for (int i = 1; i <= len; i++) {
            arr[i] = in.nextInt();//将数组存储
        }
        if(arr[left] >= aim) {
            System.out.println("1 1");
            return ;
        }
        sum += arr[left];
        while(left <= right && right <= len){
            sum += arr[right];
            while(sum >= aim && (right-left+1)<compare){
                result=left;
                sum-=arr[left];
                compare=right-left+1;
                left++;
            }
            right++;
        }
        System.out.println(result+" "+(result+compare-1));
    }
}
