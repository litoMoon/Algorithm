package DateQuestions;

import java.time.*;
import java.util.*;
public class Demo1 {

/*
LocalDate.of()这个方法是用来创建对象的，创建的对象是LocalDate类型的
* */
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int year=0,month=0,day=0;
        for(int i=0;;i++){
            year=scan.nextInt();
            month=scan.nextInt();
            day=scan.nextInt();
            if(year==0 && month==0 && day==0) {
                return;
            }
            System.out.println(LocalDate.of(year,month,day).getDayOfYear());
        }

//        while (!scan.hasNext()){//判断是否还有下一个元素的加入
//            year=scan.nextInt();
//            month=scan.nextInt();
//            day=scan.nextInt();
//            if(year==0 && month==0 && day==0){
//                return ;
//            }
//            System.out.println(LocalDate.of(year,month,day).getDayOfYear());
//        }
    }
}
