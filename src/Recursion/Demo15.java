package Recursion;

public class Demo15 {
    public static void main(String[] args) {
        long sum=0,ans=1;
        for (int i = 1; i <=45; i++) {
            ans*=i*1L;
            sum+=ans*1L;
            ans%=1e9;
            sum%=1e9;
            System.out.println(sum);
        }
    }
}
