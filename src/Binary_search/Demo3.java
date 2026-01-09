package Binary_search;

//这里需要注意的问题有，如果x是一个非常大的数，即使mid最初取了一半，但是在后面会计算 mid*mid
public class Demo3 {
    public static int mySqrt(int x) {
       long left=1,right=x;
       while(left<right){
           long mid=left+(right-left+1)/2;
           if(mid*mid>x) right=mid-1;
           else {
               left=mid;
           }
       }
        return (int)left;
    }
    public static void main(String[] args) {
        System.out.println(mySqrt(0));
    }
}
