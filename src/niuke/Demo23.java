package niuke;

import java.util.*;

public class Demo23 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] nums1 = new int[n];
        int[] nums2 = new int[m];
        int[] cur = new int[m + n];
        int left = 0, right = 0, pos = 0;
        for (int i = 0; i < n; i++) {
            nums1[i] = in.nextInt();
        }
        for (int i = 0; i < m; i++) {
            nums2[i] = in.nextInt();
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while (left < n && right < m) {
            if (nums1[left] < nums2[right]) {
                cur[pos++] = nums1[left];
                left++;
            } else if (nums1[left] == nums2[right]){
                cur[pos++] = nums2[right];
                right++; left++;
            } else {
                cur[pos++] = nums2[right];
                right++;
            }
        }
        if (left != n) {
            for (int i = left; i < n ;i++) {
                cur[pos++] = nums1[left];
            }
        }
        if (right != m) {
            for (int i = right; i < m ;i++) {
                cur[pos++] = nums2[right];
            }
        }
        System.out.print(cur[0]);
        for (int i = 1; i < pos; i++) {
            System.out.print(" " + cur[i]);
        }
    }
}
