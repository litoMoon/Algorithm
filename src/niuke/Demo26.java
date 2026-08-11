package niuke;

import java.util.Arrays;
import java.util.Scanner;

public class Demo26 {
//空调遥控

//解法一: 排序 + 滑动窗口
public static void main1(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int p = in.nextInt();
    int left = 0, right = 0, max = 0;
    int[] nums = new int[n];
    for (int i = 0; i < n; i++) {
        nums[i] = in.nextInt();
    }
    Arrays.sort(nums);
    while (left <= right && right < n) {
        while (right < n && nums[right] - nums[left] <= 2 * p) {
            right++;
        }
        max = Math.max(max, right - left);
        left++;
    }
    System.out.println(max);
}

//解法二: 排序 + 滑动窗口（改）
public static void main2(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int p = in.nextInt();
    int left = 0, right = 0, max = 0;
    int[] nums = new int[n];
    for (int i = 0; i < n; i++) {
        nums[i] = in.nextInt();
    }
    Arrays.sort(nums);
    while (right < n) {
        while (nums[right] - nums[left] > 2 * p) {
            left++; //这里判断条件不用写 left < right || left < n，是因为当 left 和 right 相等的时候，此时差值为 0 了
        }
        max = Math.max(max, right - left + 1);
        right++;
    }
    System.out.println(max);
}

//排序 + 二分查找
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int p = in.nextInt();
        int left = 0, right = 0, max = 0;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        //排序完毕
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {

        }
        while (left <= right && right < n) {
            while (right < n && nums[right] - nums[left] <= 2 * p) {
                right++;
            }
            max = Math.max(max, right - left);
            left++;
        }
        System.out.println(max);
    }
}
