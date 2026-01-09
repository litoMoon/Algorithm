package Binary_search;

import java.util.Scanner;

public class Demo14 {
    public static void main1(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        long left=0,right=1000000020,answer=0;
        while(left<right) {
            long mid=left+(right-left)/2;//求出中间值
            long sum=mid*mid+mid;
            if(sum>=2*n) {
                answer=mid;
                right=mid;
            }else {
                left=mid+1;
            }
        }
        System.out.println(answer);

    }


    //题解---方法二
        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            int n = scan.nextInt();
            //下面这个式子是由2a分之-b正负根号 德尔塔 得到的值
            double ans = (Math.sqrt((long)n*8+1)-1)/2;
            System.out.println((int)Math.ceil(ans));
        }


}
