package bitManipulation;

//统计位 1 的个数
public class Demo1 {
    public static int hammingWeight(int n) {
        int ret=0;
        while(n!=0){
            n&=n-1;
            ret++;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(7));
    }
}
