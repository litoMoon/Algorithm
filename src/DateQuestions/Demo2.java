package DateQuestions;

import java.time.*;

public class Demo2 {
    public static void main1(String[] args) {
        //不可以用来实例化，直接使用of初始化，会生成一个指定日期的日期
        LocalDate d=LocalDate.of(2022,1,1);
        d.getYear();
        LocalDate m=LocalDate.of(2023,1,1);
        long ans=0;
        while(d.isBefore(m)){
            if(d.getDayOfWeek().getValue()==6 ||
                    d.getDayOfWeek().getValue()==7 ||
                    d.getDayOfMonth()==1 ||
                    d.getDayOfMonth()==11 ||
                    d.getDayOfMonth()==21 ||
                    d.getDayOfMonth()==31
            )  ans++;
            d=d.plusDays(1);
        }
        System.out.println(ans);
    }
    public static void main(String[] args) {
        //不加 getValue()这个方法获取到的是英文的表示比如 MARCH ，加了之后输出的是数字
//        System.out.println(LocalDate.of(2025,3,11).getMonth().getValue());
        int n=LocalDate.of(2025, 1, 2).getDayOfWeek().getValue();
//        System.out.println(LocalDate.of(2000, 2, 29).getDayOfWeek().getValue());
    }
}
