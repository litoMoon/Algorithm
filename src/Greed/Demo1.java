package Greed;

//贪心算法第一题柠檬找零问题
public class Demo1 {
    public static void main(String[] args) {

    }
    public boolean lemonadeChange(int[] bills) {
        //创建一个数组用来记录钱的信息
        int[] mon=new int[2];
        for(int i=0;i<bills.length;i++){
            if(bills[i]==5) mon[0]++;
            else if(bills[i]==10){
                if(mon[0]==0) return false;
                mon[0]--;
                mon[1]++;
            }else if(bills[i]==20){
                if(i==0) return false;
                if(mon[1]!=0 && mon[0]!=0) {
                    mon[1]--;
                    mon[0]--;
                }else if(mon[0]>=3){
                    mon[0]-=3;
                }else{
                    return false;
                }
            }
        }
        return true;

    }
}
