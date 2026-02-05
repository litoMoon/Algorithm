package LeetCode;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
       String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> list= groupAnagrams(strs);
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);
            String cur = new String(ch);
            map.computeIfAbsent(cur, k -> new LinkedList<>());
            List<String> list=map.get(cur);
            list.add(strs[i]);
            map.put(cur,list);
        }
        return new ArrayList<>(map.values());
    }
}
