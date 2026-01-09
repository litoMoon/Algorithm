package Luogu;

import java.util.Scanner;

public class Demo2 {
    static int []days=new int[]{0,31,28,31,30,31,30,31,31,30,31,30,31};
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();//输入一个八位数的数字
        int flag=0;
        for(int i=n+1; ;i++){
//判断数字是否合法
            if(is_num(i)){
                String s=String.valueOf(i);
//判断是否为回文数字
                if(is_palindrome(s) && flag==0){
                    System.out.println(i);
                    flag=1;
                }
//判断是否为AB型的回文数
                if(is_palindrome_AB(s)){
                    System.out.println(i);
                    break;
                }
            }
        }

    }
    public static boolean is_num(int n){
        int year=n/10000;
        int month=n%10000/100;
        int day=n%100;
        if(year<1000 || year>9220) return false;
        if(day<=0 || month<=0 || month>12) return false;//月份不对
        if(month!=2 && day>days[month]) return false;//天数不符合要求
        if((year%4==0 && year%100!=0) || year%400==0){
            if(day>29) return false;
            else return true;
        }
        return true;
    }

    public static boolean is_palindrome(String s){
        int left=0,right=s.length()-1;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static boolean is_palindrome_AB(String s){
        if(is_palindrome(s)){
            if(s.charAt(0)==s.charAt(2) && s.charAt(1)==s.charAt(3)){
                return true;
            }
        }
        return false;
    }
}
