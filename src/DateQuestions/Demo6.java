package DateQuestions;

import java.util.*;
import java.text.*;

public class Demo6 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String date=scan.nextLine();
        int n=scan.nextInt();
        Calendar c=Calendar.getInstance();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date1=sdf.parse(date);
            c.setTime(date1);
            int num=0;
            while(num<n){
                int day=c.get(Calendar.DAY_OF_WEEK);
                if(day!=Calendar.SATURDAY && day!=Calendar.SUNDAY){
                    num++;
                }
                if(num<=n){
                    c.add(Calendar.DAY_OF_MONTH,1);
                }

            }
            System.out.println("第"+n+"个工作日是："+c.get(Calendar.YEAR)+"-"+(c.get(Calendar.MONTH)+1)+"-"+c.get(Calendar.DATE));
        }catch (Exception e){
            System.out.println("日期格式错误或输入无效！");
        }


    }
}
