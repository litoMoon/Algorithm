package BFS_shortestPath;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;

public class Demo2 {
    public static void main(String[] args) {
//start = "AACCGGTT", end = "AACCGGTA", bank = ["AACCGGTA"]
        String s1="AAAACCCC";
        String s2="CCCCCCCC";
        String []b=new String[]{"AAAACCCA","AAACCCCA","AACCCCCA","AACCCCCC","ACCCCCCC","CCCCCCCC","AAACCCCC","AACCCCCC"};
        System.out.println(minMutation(s1, s2, b));
    }
    public static int minMutation(String startGene, String endGene, String[] bank) {
        int count=0;
        char[] ch=new char[]{'A','C','G','T'};
        Queue<String> q=new ArrayDeque<>();
        //先将有的丢进hash表中
        HashSet<String> set1=new HashSet<>();
        HashSet<String> set2=new HashSet<>();
        for (String s:bank) {
            set1.add(s);//Collections.addAll()
        }
        q.offer(startGene);
        set2.add(startGene);
        while(!q.isEmpty()){
            int size=q.size();
            count++;
            for (int i = 0; i < size; i++) {
                String cur=q.poll();
                String curN=cur;
                for (int j = 0; j < curN.length(); j++) {
                    char[] chs=cur.toCharArray();
                    for (int k = 0; k < 4; k++) {
                        chs[j]=ch[k];
                        String r=new String(chs);
                        if(!set2.contains(r) && set1.contains(r)){
                            if(r.equals(endGene)) return count;//返回最终的结果
                            q.offer(r);
                            set2.add(r);
                        }
                    }
                    cur=curN;

                }
            }
            }

         return -1;
    }
}
