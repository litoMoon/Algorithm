package niuke;

import java.util.HashMap;
import java.util.Map;

public class Demo16 {
    public static int maxLength (int[] arr) {
        int max = 0, left = 0, right = 0;//记录最长子数组的序列
        Map<Integer, Integer> map = new HashMap<>();//前一个数字是数字，后一个是下标
        for (; right < arr.length; right++) {
            if (map.containsKey(arr[right])) {
                left = Math.max(left, map.get(arr[right]) + 1);
            }
            map.put(arr[right], right);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,2,1};
        System.out.println(maxLength(arr));
    }
}
