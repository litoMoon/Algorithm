package School_game;

import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int num=scan.nextInt();//输入一个数字
//         while(true) {
//             long cur=num;
//             StringBuilder sbu=new StringBuilder();
//             while(cur!=0){
//                 sbu.append(cur%10);//依次取后面的数
//                 cur/=10;
//             }
//             String s=sbu.toString();
//             long num1=Long.parseLong(s);//将字符串转化为 long
//            if(Math.abs(num1-num)<=200000 && Math.abs(num1-num)>=100000){
//                System.out.println(num);
//                break;
//            }
//            num++;
//
        findNumber(num);
    }
    public static void findNumber(int num){
        for (int j= num;  ; j++) {
            //先将 num 转化为字符串
            String s=j+"";
            //将数组逆序
            StringBuilder sb=new StringBuilder();
            for (int i = s.length()-1; i >=0 ; i--) {
                sb.append(s.charAt(i));//将字符串拼接
            }
            String cur=sb.toString();
            long end=Long.parseLong(cur);

            //判断是否符合最终的条件
            if(Math.abs(end-j)>=100000 && Math.abs(end-j)<=200000) {
                System.out.println(j);
                break;
            }
        }

    }
}
