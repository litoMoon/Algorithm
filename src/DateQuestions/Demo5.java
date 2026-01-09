package DateQuestions;

import java.text.SimpleDateFormat;
import java.util.*;

public class Demo5 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String birth=scan.nextLine();
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        try{
            Date date1=df.parse(birth);//将字符串转化为Date类型
//            Calendar c=Calendar.getInstance();
//            c.set(2025,0,1);
            Date date2 = df.parse("2025-1-1");
            long diff=date2.getTime()-date1.getTime();
            long ans=diff/1000/60/60/24;
            System.out.println("出生了"+ans+"天");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }



    }
}
