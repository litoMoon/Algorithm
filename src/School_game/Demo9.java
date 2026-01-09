package School_game;

import java.util.Scanner;

public class Demo9 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // 在此输入您的代码...
        int x1 = scan.nextInt(), y1 = scan.nextInt();
        int x2 = scan.nextInt(), y2 = scan.nextInt();
        int x3 = scan.nextInt(), y3 = scan.nextInt();
        int x4 = scan.nextInt(), y4 = scan.nextInt();
        // 计算面积并且减去重叠部分的面积
        long area = (long) (x2 - x1) * (y2 - y1) + (long) (x4 - x3) * (y4 - y3);
        int overlapWidth = Math.max(0, Math.min(x2, x4) - Math.max(x1, x3)); // 重叠部分宽度
        int overlapHeight = Math.max(0, Math.min(y2, y4) - Math.max(y1, y3)); // 重叠部分高度
        if (overlapWidth > 0 && overlapHeight > 0) { // 存在重叠部分
            area -= (long) overlapWidth * overlapHeight;
        }
        System.out.println(area);

    }
}
