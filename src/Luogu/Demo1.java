package Luogu;

import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        long sum=0;
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scan.nextInt();
            sum+=arr[i];
        }
        long ret=0;
        for(int i=0;i<n;i++){
            sum-=arr[i];
            ret+=sum*arr[i];
        }
        System.out.println(ret);
    }
}
