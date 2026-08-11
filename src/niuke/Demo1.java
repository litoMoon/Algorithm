package niuke;

import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str=in.nextLine();
        StringBuilder sbu=new StringBuilder();
        //按照空格分割字符串
        String[] arr=str.split(" ");
        //遍历字符串，取首字符
        for (String s:arr) {
            char s1=s.charAt(0);
            if(s1>='a' && s1<='z'){
                s1-=32;
            }
            sbu.append(s1);
        }
        System.out.println(sbu.toString());
    }
}
