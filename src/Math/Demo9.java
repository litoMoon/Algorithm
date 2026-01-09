package Math;

//蓝桥真题---幸运数字
public class Demo9 {
   static int[]h=new int[]{10,11,12,13,14,15};
    public static void main(String[] args) {
        //将一个十进制数转化为任意进制数的方法为----Integer.toString(int n,int radix)
        //String hex=Integer.toString(126,16);
        //System.out.println(hex);
        int ans=10, i=127;
        for(;i<=Integer.MAX_VALUE;i++){
            if(Bin(i) && Oct(i) &&  Dec(i) && Hex(i)){
                ans++;
                if(ans==2023)break;
            }
        }
        System.out.println(i);
    }
    public static boolean Bin(int x){
        int ans=0;
        char[] ch=Integer.toString(x,2).toCharArray();
        for (char cur:ch) {
            cur-='0';
            ans+=cur;
        }
        return x%ans==0;
    }
    public static boolean Oct(int x){
        int ans=0;
        char[] ch=Integer.toString(x,8).toCharArray();
        for (char cur:ch) {
            cur-='0';
            ans+=cur;
        }
        return x%ans==0;
    }
    public static boolean Dec(int x){
        int ans=0,cur=x;
        while(x!=0){
            ans+=x%10;
            x/=10;
        }
       return cur%ans==0;
    }
    public static boolean Hex(int x){
        int ans=0;
        char[] ch=Integer.toString(x,16).toCharArray();
        for (char cur:ch) {
           if(cur>='0' && cur<='9') {
               cur-='0';
               ans+=cur;
           }
           else{
               cur-='a';
               ans+=h[cur];
           }

        }
        return x%ans==0;
    }
}
