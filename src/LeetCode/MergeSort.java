package LeetCode;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr=new int[]{10,6,7,1,3,9,4,2};
        int mid=arr.length;
        arr=mergeSort(arr,0,mid-1);
        System.out.println(Arrays.toString(arr));
    }

    private static int[] mergeSort(int[]arr,int begin, int end) {
        if(begin>=end) return new int[]{arr[begin]};
        int mid=(begin+end)/2;
        int[] cur1=mergeSort(arr,begin,mid);
        int[] cur2=mergeSort(arr,mid+1,end);
        return sort(cur1,cur2);
    }

    private static int[] sort(int[] cur1, int[] cur2) {
        int[] res=new int[cur1.length+cur2.length];
        int left=0,right=0,i=0;
        while(left<cur1.length && right<cur2.length){
            if(cur1[left]<cur2[right]){
                res[i++]=cur1[left++];
            }else{
                res[i++]=cur2[right++];
            }
        }
        if(left<cur1.length){
            while(left<cur1.length){
                res[i++]=cur1[left++];
            }
        }
        if(right< cur2.length){
            while(right<cur2.length){
                res[i++]=cur2[right++];
            }
        }
        return res;
    }
}
