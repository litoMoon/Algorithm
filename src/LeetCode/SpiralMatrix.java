package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result=new ArrayList<>();
        int left=0,right=matrix[0].length-1,top=0,bottom=matrix.length-1;
        while(left<=right && top<=bottom){
            for(int i=left;i<=right;i++){
                result.add(matrix[top][i]);
            }
            top++;  if(top>bottom) break;
            for(int i=top;i<=bottom;i++){
                result.add(matrix[i][right]);
            }
            right--; if(right<left) break;
            for(int i=right;i>=left;i--){
                result.add(matrix[bottom][i]);
            }
            bottom--; if(bottom<top) break;
            for(int i=bottom;i>=top;i--){
                result.add(matrix[i][left]);
            }
            left++; if(left>right) break;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] arr=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> list = spiralOrder(arr);
        System.out.println(list);
    }
}

