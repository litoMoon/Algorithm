package divide_and_conquer;

//使用分治的方法来实现逆序对个数的问题
public class Demo4 {
    public static void main(String[] args) {
        int []arr=new int[]{7,5,6,4};
        System.out.println(reversePairs(arr));
    }
    static int []temp;
    static int ret=0;
    public static int reversePairs(int[] record) {
        temp=new int[record.length];
       return mergeSort(record,0,record.length-1);
    }
    public static int mergeSort(int[] nums,int left,int right){
        if(left>=right) return 0;
        //取中间值将数组划分为多个小块
        int mid=(left+right)/2;

        //根据中间值将数组划分
        mergeSort(nums,left,mid);
        mergeSort(nums,mid+1,right);

        //对值进行排序并统计最后的结果
        int cur1=left,cur2=mid+1,i=0;
        while(cur1<=mid && cur2<=right) {
            if(nums[cur2]<nums[cur1]){
                temp[i++]=nums[cur2++];
                ret+=mid-cur1+1;//统计个数
            }else{
                temp[i++]=nums[cur1++];
            }
        }
        while(cur1<=mid) temp[i++]=nums[cur1++];
        while(cur2<=right) temp[i++]=nums[cur2++];

        //将temp中的数组元素填回原数组中
        for (int j = left; j <=right ; j++) {
            nums[j]=temp[j-left];
        }
        return ret;
    }
}
