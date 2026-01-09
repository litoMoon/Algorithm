package Math;

public class Demo4 {
    /*public static void main(String[] args) {
        int ans=0;
        int i=2;
        for(;i<=Integer.MAX_VALUE;++i) {
            if(check(i)) ans++;
            if(ans==100002) break;
        }
        System.out.println(i);
    }
    static boolean check(int n) {
        for(int i=2;i<=n/i;++i) {
            if(n%i==0) return false;
        }
        return true;

    }*/

    //判断一个数是否时素数
    public static void main(String[] args) {

        //质因数的排列具有对称性
        int ans=0;
        int i=2;
        for (; i <=Integer.MAX_VALUE ; i++) {
            if(check(i)) ans++;
            if(ans==100002) break;
        }
        System.out.println(i);
    }
    public static boolean check(int n){
        for (int i = 2; i <=Math.sqrt(n) ; i++) {
            if(n%i==0) return false;
        }
        return true;
    }
}
