package School_game;

import java.util.Scanner;

//判断是否为回文字符串
public class Demo5 {
    public static void main(String []args){
        Scanner scan=new Scanner(System.in);
        String str=scan.next();
        int left=0,right=str.length()-1;
        while(left<=right){
            if(str.charAt(left)!=str.charAt(right)) {
                System.out.println("N");
                return ;
            }
            left++;
            right--;
        }
        System.out.println("Y");
    }
}
