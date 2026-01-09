package DateQuestions;

import java.time.LocalDate;

public class Demo3 {
    public static void main(String[] args) {
        LocalDate d=LocalDate.of(1901,1,1);
        LocalDate m=LocalDate.of(2001,1,1);
        long ans=0;
        while(d.isBefore(m)){
            if(d.getDayOfMonth()==1 && d.getDayOfWeek().getValue()==7){
                ans++;
            }
            //表示从当前日期起，之后每一个日期加一
            d=d.plusMonths(1);
        }
        System.out.println(ans);
    }
}
