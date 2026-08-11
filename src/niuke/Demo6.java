package niuke;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Demo6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();//获取到字符串
        StringBuilder sbu=new StringBuilder();
        Map<Integer,String> map=new HashMap<>();
        int res = -1;//找到最长的数字串
        int left = 0;
        int right = 0;
        int len = str.length();
//        while(right < len){
//            int cur = (str.charAt(right) - '0');
//            if(cur >= 0 && cur <= 9){
//                left = right;
//                while(right < len && (str.charAt(right) - '0') >= 0 && (str.charAt(right) - '0') <= 9){
//                    sbu.append(str.charAt(right));
//                    right++;
//                }
//                res = Math.max(res,(right-left));
//                map.put(res, sbu.toString());
//                sbu = new StringBuilder();
//            }
//            right++;
//
//        }


            while(right < len){
                while(right < len && str.charAt(right) <= '0' || str.charAt(right) >= '9'){
                    right++;//全是除开数字的
                }
                //现在为 0 ~ 9
                left = right;
                while(right < len && str.charAt(right) >= '0' && str.charAt(right) <= '9'){
                    sbu.append(str.charAt(right));
                    right++;
                }
                //此时又为除开数字的字符
                res = Math.max(res,(right-left));
                map.put(res, sbu.toString());
                sbu = new StringBuilder();

        }

        System.out.println(map.get(res));

    }
}
