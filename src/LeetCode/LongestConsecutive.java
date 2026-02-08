package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {

    public static int longestConsecutive(int[] nums) {

        Set<Integer> st = new HashSet<>();
        for (int num : nums) {
            st.add(num); // 把 nums 转成哈希集合
        }

        int ans = 0;
        for (int x : st) { // 遍历哈希集合
            if (st.contains(x - 1)) { // 如果 x 不是序列的起点，直接跳过
                continue;
            }
            // x 是序列的起点
            int y = x + 1;
            while (st.contains(y)) { // 不断查找下一个数是否在哈希集合中
                y++;
            }
            // 循环结束后，y-1 是最后一个在哈希集合中的数
            ans = Math.max(ans, y - x); // 从 x 到 y-1 一共 y-x 个数
        }

        return ans;

    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }

}
