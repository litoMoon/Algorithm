package niuke;

import java.util.PriorityQueue;
import java.util.Scanner;


//字符编码 -- 哈夫曼编码
public class Demo46 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            char[] chs = str.toCharArray();
            int[] ch = new int[128];

            for (int i = 0; i < chs.length; i++) {
                ch[chs[i]]++; //统计数量
            }

            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for (int i = 0; i < 128; i++) {
                if (ch[i] != 0) {
                    queue.offer(ch[i]);
                }
            }

            int ret = 0;
            while (queue.size() > 1) {
                int cur1 = queue.poll();
                int cur2 = queue.poll();
                ret += cur1 + cur2;
                queue.offer(cur1 + cur2);
            }

            System.out.println(ret);
        }

    }
}
