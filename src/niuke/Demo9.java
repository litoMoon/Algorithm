package niuke;

import java.util.Arrays;

public class Demo9 {
    public boolean IsContinuous (int[] numbers) {
        int begin = 0;//记录数组值初始不为 0 的那个值
        int count = 0;//记录零的数量
        int len = numbers.length;
        Arrays.sort(numbers);//先对数组进行排序
        for(int i = 0; i < len; i++){
            if(numbers[i] == 0){
                count++;
            }else{
                begin = i;
                break;
            }
        }


        return false;
    }
}
