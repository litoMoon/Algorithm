package Binary_search;

public class Demo5 {
    public static int peakIndexInMountainArray(int[] arr) {
        int left=0,right=arr.length-1;
        while(left<right){
            int mid=left+(right-left+1)/2;
            if(arr[mid]>arr[mid-1]) left=mid;
            else right=mid-1;
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(peakIndexInMountainArray(new int[]{0, 1, 2, 3, 2, 1, 0}));
    }
}
