package niuke;

import java.util.Arrays;
import java.util.Scanner;

public class Demo35 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt(), maxCount = 0;
//        int[][] nums = new int[n][2];
//        //输入值
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < 2; j++) {
//                nums[i][j] = in.nextInt();
//            }
//        }
//
//        //针对二维数组进行排序处理
//        Arrays.sort(nums, (v1, v2) -> {
//            if (v1[0] == v2[0]) return Integer.compare(v1[1], v2[1]);
//            return Integer.compare(v1[0], v2[0]);
//        });
//
//        for (int i = 0; i < n; i++) {
//            int cur = nums[i][1], count = 1;
//            for (int j = i + 1; j < n; j++) {
//                if (nums[j][0] >= cur) {
//                    count++;
//                    cur = nums[j][1];
//                }
//            }
//            maxCount = Math.max(maxCount, count);
//        }
//        System.out.println(maxCount);
//    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), maxCount = 1;
        int[][] nums = new int[n][2];
        //输入值
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                nums[i][j] = in.nextInt();
            }
        }
        //针对二维数组进行排序处理
        Arrays.sort(nums, (v1, v2) -> {
            if (v1[0] == v2[0]) return Integer.compare(v1[1], v2[1]);
            return Integer.compare(v1[0], v2[0]);
        });

        int pre = nums[0][1];
        for (int i = 1; i < n; i++) {
            if (nums[i][0] < pre) pre = Math.min(nums[i][1], pre);
            else {
                pre = nums[i][1];
                maxCount++;
            }
        }
        System.out.println(maxCount);
    }
}
