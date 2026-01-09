package DateQuestions;

import java.time.LocalDate;

public class Demo4 {
    public static void main(String[] args) {
        int[] cont;
        long ans=0;
        LocalDate d=LocalDate.of(2023,1,1);
        while(d.isBefore(LocalDate.of(2024,1,1))){
            if(d.getDayOfWeek().getValue()==1) {
                ans+=5;
                d=d.plusDays(1);
                continue;
            }
            cont=new int[2];
            int flag=0;
            cont[0]=d.getMonth().getValue();
            cont[1]=d.getDayOfMonth();
            for (int x:cont) {
                if(check(x)) {
                    ans+=5;
                    flag=1;
                    break;
                }
            }
            if (flag==0) ans+=1;
            d=d.plusDays(1);
        }
        System.out.println(ans);
    }
    public static boolean check(int x){
        while(x!=0){
            if(x%10==1) return true;
            x/=10;
        }
        return false;
    }
}
