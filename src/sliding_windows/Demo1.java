package sliding_windows;

import java.util.ArrayList;
import java.util.List;

public class Demo1 {
    public static List<Integer> findAnagrams(String s, String p) {
        int lens = s.length(), lenp = p.length(), left = 0, right = 0, count = 0;
        int[] hash1 = new int[26];
        int[] hash2 = new int[26];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < lenp; i++) {
            hash2[p.charAt(i) - 'a']++;
        }
        while (right < lens) {
            int out = s.charAt(right) - 'a';
            hash1[out]++;
            if (hash1[out] <= hash2[out])
                count++;
            if ((right - left + 1) > lenp) {
                hash1[s.charAt(left) - 'a']--;
                if (hash1[s.charAt(left) - 'a'] < hash2[s.charAt(left) - 'a'])
                    count--;
                left++;
            }
            // 判断检查 hash1 和 hash2 是否相等
            if (count == lenp)
                list.add(left);
            right++;
        }
        return list;

    }

    public static void main(String[] args) {
        for (int x :findAnagrams("abab","ab")) {
            System.out.print(x+" ");
        }
    }
}
