package Math;


import java.util.*;

//质因数分解模板
public class Demo7 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("请输入一个整数");
        int n=scan.nextInt();
        if(n<1){
            System.out.println("请输入一个大于 1 的整数！");
            return ;
        }
        List<Integer> primeFactors=new ArrayList<>();
        System.out.println(n+"=");
        for(int i=0;i<primeFactors.size();i++){
            if(i>0) System.out.println("*");
            System.out.println(primeFactors.get(i));
        }
    }
    public List<Integer> getPrimeFactors1(int n){
        List<Integer> factors=new ArrayList<>();

        //处理2的因数
        while(n%2==0){//2 是最小的质因子
            factors.add(2);
            n/=2;
        }

        //处理奇数因数
        for(int i=3;i<=Math.sqrt(n);i+=2){
            while(n%i==0){
                factors.add(i);
                n/=i;
            }
        }

        //如果剩下的数大于2，它本身也是质数
        if(n>2){
            factors.add(n);
        }
        return factors;
    }
}
