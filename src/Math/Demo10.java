package Math;

import java.util.Scanner;

public class Demo10 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x1=scan.nextInt();
        int y1=scan.nextInt();
        int x2=scan.nextInt();
        int y2=scan.nextInt();
        int x3=scan.nextInt();
        int y3=scan.nextInt();
        int x4=scan.nextInt();
        int y4=scan.nextInt();
        long area=1L*(y2-y1)*(x2-x1)+1L*(y4-y3)*(x4-x3);//先将1L写在前面也是可以的
        long area1=(long)(y2-y1)*(x2-x1)+(long)(y4-y3)*(x4-x3);
        //long area=(y2-y1)*(x2-x1)*1L+(y4-y3)*(x4-x3)*1L 这里*1L仍是先计算前面的int类型的相乘后才计算1L，这样还是会有溢出的风险
        //解决上面这个问题的正确做法是在计算前就将操作数转化为long
        int overWidth=Math.max(0,Math.min(x2,x4)-Math.max(x1,x3));
        int overHeight=Math.max(0,Math.min(y2,y4)-Math.max(y1,y3));
        area-=(long)overHeight*overWidth;
        System.out.println(area);
        scan.close();
    }
}
