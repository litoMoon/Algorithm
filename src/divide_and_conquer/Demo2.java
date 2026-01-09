package divide_and_conquer;

import java.util.Random;

public class Demo2 {
    public static void main1(String[] args) {
        int[] arr = new int[]{3,-1};
        sortArray(arr);
        for (int x:sortArray(arr)) {
            System.out.print(x+" ");
        }
    }

    //使用快速排序实现的数组的排序
    public static int[] sortArray1(int[] nums) {
        quicksort(nums, 0, nums.length-1);//第一次传递的下标

        return nums;

    }

    public static void quicksort(int[] nums, int l, int r) {
        if (l>=r) return;//此时说明现在的元素为一个或者没有
        //取left和right的随机值
        int left=l-1,right=r+1;
        Random rand = new Random();
        int mid = rand.nextInt(r- l+ 1);//生成的随机数在这个之间，是寻找的基准值的下标，左闭右开
        mid = mid % (r - l + 1 ) +l ;//求出基准值的下标
        int num=nums[mid];
        for (int i = l; i < right; ) {
            if (nums[i] < num) swap(nums, ++left, i++);
            else if (nums[i] == num) i++;
            else swap(nums, --right, i);
        }
        quicksort(nums,l, left);
        quicksort(nums, right,r);
    }

    //实现交换函数
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    static int []temp;

    public static void main(String[] args) {
        for (int x:sortArray(new int[]{5,1,3,2})) {
            System.out.print(x+" ");
        }
    }

    //使用归并排序来实现数组的排序
    public static int[] sortArray(int[] nums) {
        temp=new int[nums.length];
        mergeSort(nums,0,nums.length-1);
        return nums;
    }
    public static void mergeSort(int []nums,int left,int right){
        if(left>=right) return;//当数组中的元素只有一个或者没有时，直接返回，因为归并会无限次的对他进行划分

        //取中间的划分点
        int mid=(left+right)/2;

        //对数组进行划分
        mergeSort(nums,left,mid);
        mergeSort(nums,mid+1,right);

        //对数组进行排序
        int cur1=left,cur2=mid+1,i=0;
        while(cur1<=mid && cur2<=right){
            temp[i++]=nums[cur1]<=nums[cur2]?nums[cur1++]:nums[cur2++];
        }
        //处理剩余的数组元素
        while(cur1<=mid) temp[i++]=nums[cur1++];
        while(cur2<=right) temp[i++]=nums[cur2++];

        //将所有的元素还回元素组
        for (int j = left; j <=right ; j++) {
            nums[j]=temp[j-left];
        }
    }
}
