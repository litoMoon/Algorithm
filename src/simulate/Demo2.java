package simulate;

public class Demo2 {
    public static void main(String[] args) {
//        int []nums=new int[]{1,3,4,5,9,12,15};
       int ret= findPoisonedDuration(new int[]{1,3,4,5,9,12,15},3);
        System.out.println(ret);
    }
    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        int ret=0;//记录返回值
        for(int i=1;i<timeSeries.length;i++){
            int sub=timeSeries[i]-timeSeries[i-1];
            if((sub)>=duration) ret+=duration;
            else ret+=sub;
        }
        ret+=duration;
        return ret;
    }
}
