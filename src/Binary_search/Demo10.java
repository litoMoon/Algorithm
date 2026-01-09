package Binary_search;

import java.util.Scanner;

//卡牌---2022蓝桥国赛题
public class Demo10 {
   static long m=0;
   static int n=0;
   static long[] a;
   static long[] b;
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        n=scan.nextInt();//输入总的卡牌的数量
        m=scan.nextLong();//输入卡牌操作数的上限
        a=new long[n];
        b=new long[n];

        //向数组中依次输入值
        for(int i=0;i<n;i++) a[i]=scan.nextInt();
        for(int i=0;i<n;i++) b[i]=scan.nextInt();
        long l=0,r=200020;//4e5是浮点数的表示单位
        while(l<r){
            long mid=(l+r+1)/2;
            if(check(mid)){
                l=mid;
            }else{
                r=mid-1;
            }

        }
        System.out.println((int)r);
    }
    public static boolean check(double x){//x是需要达到的卡牌数量
        long v=m;//每次进入check都是相同的检查方法
        for(int i=0;i<n;i++){
            if(a[i]>=x) continue;
            if(a[i]+b[i]<x) return false;
            if(a[i]+b[i]>=x && v>=x-a[i]){
                v-=x-a[i];
            }else{
                return false;
            }
        }
        return true;
    }

}
