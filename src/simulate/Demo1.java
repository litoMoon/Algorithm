package simulate;

import java.util.Arrays;

public class Demo1 {
    public static void main(String[] args) {
        System.out.println(modifyString("ab?hc"));
    }
    public static String modifyString(String ss) {
        char[] array= ss.toCharArray();//将字符串转变为字符数组
        for (int i=0;i<array.length;i++) {
            if(array[i]=='?' ){
                    for (char ch = 'a'; ch!= 'z'; ch++) {
                        if((i==0 || ch!=array[i-1])&&(i==array.length-1 || ch!=array[i+1])){ //左边判断和前面的字符
                           array[i]=ch;//说明此时找到了
                           break;
                        }
                    }

            }
        }

        return String.valueOf(array);
    }


}
