package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] s = new int[n + 1];
        for (int i = 0; i < n; i++) {
            s[i + 1] = s[i] + nums[i];
        }

        Map<Integer, Integer> cnt = new HashMap<>(n + 1, 1); // 预分配空间
        int ans = 0;
        for (int sj : s) {
            ans += cnt.getOrDefault(sj - k, 0);
            cnt.merge(sj, 1, Integer::sum); // cnt[sj]++
        }
        return ans;
    }
}
