package niuke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


//主持人调度

//解法1
public class Demo24 {
    public static boolean hostschedule1 (ArrayList<ArrayList<Integer>> sc) {
        int m = sc.size(), n = sc.get(0).size();
        int[] nums = new int[m];
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int cur1 = sc.get(i).get(0);
            int cur2 = sc.get(i).get(1);
            nums[i] = cur1;
            hash.put(cur1, cur2);
        }
        Arrays.sort(nums);
        for (int i = 1; i < m; i++) {
            if (nums[i] < hash.get(nums[i - 1])) return false;
        }
        return true;
    }

//解法2
public static boolean hostschedule (ArrayList<ArrayList<Integer>> sc) {
    int m = sc.size(), n = sc.get(0).size();
    int[][] nums = new int[m][n];
    for (int i = 0; i < m; i++) {
        int cur1 = sc.get(i).get(0);
        int cur2 = sc.get(i).get(1);
        nums[i][0] = cur1;
        nums[i][1] = cur2;
    }
    Arrays.sort(nums, (v1, v2) -> {
        return v1[0] - v2[0];
    } );
    for (int i = 0; i < m-1; i++) {
        if (nums[i][1] > nums[i+1][0]) return false;
    }
    return true;
}
//[[33,38],[90,92],[87,88],[98,100],[20,32],[11,12],[45,57],[2,4],[63,71],[73,75],[95,96],[13,19]]
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(33); list1.add(38); list.add(list1);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(20); list2.add(32); list.add(list2);
        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(2); list3.add(4); list.add(list3);
        System.out.println(hostschedule(list));
    }
}
