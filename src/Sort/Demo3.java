package Sort;

import java.io.*;
import java.util.*;

public class Demo3 {
   /* //快速读入模板
    static BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
    //快速输出模板
    static PrintWriter out=new PrintWriter(new OutputStreamWriter(System.out));*/
   public static void main(String[] args) {
       Scanner scan=new Scanner(System.in);
       int n=scan.nextInt();//输入整数值
       scan.nextLine();
       int rep=0,diu=0;
       List<Integer> list=new ArrayList<>();
       for (int i = 0; i < n; i++) {
           for (String s : scan.nextLine().split(" ")) {
               list.add(Integer.valueOf(s));
           }
       }
       Collections.sort(list);
       int[] arr=new int[list.size()];
       arr[0]=list.get(0);
       for(int i=1;i<list.size();i++) {
           int cur=list.get(i);
            if(cur==arr[i-1]) rep=cur;
            else if(cur!=arr[i-1]+1) diu=cur-1;
            arr[i]=cur;
       }

       System.out.println(diu+" "+rep);

   }

}
