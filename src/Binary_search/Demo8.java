package Binary_search;

public class Demo8 {
    public static int missingNumber(int []arr){
        // 解法五
        /*
        int left=0,right=arr.length-1;
        while(left<right){
            int mid=(left+right)/2;
            if(arr[mid]==mid) left=mid+1;
            else right=mid;
        }
        return arr[left]==left?left+1:left;

         */

        // 解法一
        int []nums=new int[arr.length+1];
        for (int i=0;i<arr.length;i++) {
            nums[arr[i]]++;
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0) return i;
        }
        return nums.length;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{0,1,2,3}));
    }
}
