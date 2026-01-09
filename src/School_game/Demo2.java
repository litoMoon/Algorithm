package School_game;

import java.util.*;

//统计合数的个数
public class Demo2 {
    public static int countOfCompositeNumber(int n,int m){
        int ret=0;
        for (int i = n; i <=m ; i++) {
            if(i%2==0) continue;//需要的是非偶数
            for(int p=2;p<=Math.sqrt(i);p++){
                if(i%p==0) {
                    ret++;
                    break;//查找到了就没有必要继续在找了就可以直接退出去了
                }
            }
        }
          return ret;
    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int m=scan.nextInt();
        System.out.println(countOfCompositeNumber(n, m));
    }
}
