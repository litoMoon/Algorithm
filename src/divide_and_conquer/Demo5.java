package divide_and_conquer;


import java.util.ArrayList;
import java.util.List;

//计算右侧小于当前元素的个数
public class Demo5 {
    public static void main(String[] args) {
        int[] arr=new int[]{26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41};
       for(int x:countSmaller(arr)){
           System.out.print(x+" ");
       }
    }
    static int []temp1;//记录数组元素
    static int []temp2;//记录元素值对应题目所求的个数
    static int []index;

    static int []ret;
    static List<Integer> list;
    public static List<Integer> countSmaller(int[] nums) {
        index=new int[nums.length];
        temp1=new int[nums.length];
        temp2=new int[nums.length];
        ret=new int[nums.length];
        list=new ArrayList<>();//生成一个 Arraylist 数组
        for(int i=0;i<nums.length;i++){
            index[i]=i;
        }
        mergeSort(nums,0,nums.length-1);

        for (int i = 0; i < nums.length; i++) {
            list.add(ret[i]);
        }
        return list;
    }
    public static void mergeSort(int []nums,int left,int right){
        if(left>=right) return;

        //取值将数组划分
        int mid=(left+right)/2;//取值

        //根据中间值将数组进行划分
        mergeSort(nums,left,mid);
        mergeSort(nums,mid+1,right);

        //将划分后的数组进行排序
        int cur1=left,cur2=mid+1,i=0;
        while(cur1<=mid && cur2<=right){
            if(nums[cur1]>nums[cur2]) {
                temp2[i]=cur1;//存储元素的下标
                ret[index[cur1]]+=right-cur2+1;//记录下大于的个数
                temp1[i++]=nums[cur1++];//存储元素
            }
            else {
                temp2[i]=cur2;
                temp1[i++]=nums[cur2++];
            }
        }

        //处理剩余的元素
        while(cur1<=mid) {
            temp2[i]=cur1;
            temp1[i++]=nums[cur1++];

        }
        while(cur2<=right) {
            temp2[i]=cur2;
            temp1[i++]=nums[cur2++];

        }

        //将元素放回原数组，这里移动的时候应该将对应的下标也移动走
        for (int k = left; k <=right; k++) {
            nums[k]=temp1[k-left];
            index[k]=temp2[k-left];
        }

    }
}
