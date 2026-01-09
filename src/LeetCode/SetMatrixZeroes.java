package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class SetMatrixZeroes {
    public static void setZeroes(int[][] matrix) {
//        HashMap<Integer,List<Integer>> map=new HashMap<Integer, List<Integer>>();
//        for (int i = 0; i < matrix.length; i++) {//行
//            for (int j = 0; j < matrix[0].length; j++) {//列
//                if(matrix[i][j]==0){
//                    map.put(i,map.getOrDefault(i,new ArrayList<>()));
//                    map.get(i).add(j);
//                }
//            }
//        }
//        for(int i:map.keySet()){
//            for(int j=0;j<matrix[0].length;j++){
//                matrix[i][j]=0;//将行置零
//            }
//            List<Integer> list=map.get(i);
//            for (int j:list) {
//                for (int k = 0; k < matrix.length; k++) {
//                    matrix[k][j]=0;
//                }
//            }
//        }
        int n = matrix.length;
        int m = matrix[0].length;
        boolean flag_l = false,flag_r = false;
        //遍历第一列,若为0，记录 flag_l=true
        for(int i = 0 ;i < n; i++){
            if(matrix[i][0] == 0){
                flag_l = true;
                break;
            }
        }
        //遍历第一行,若为0,记录 flag_r=true
        for(int i = 0; i < m; i++){
            if(matrix[0][i] == 0){
                flag_r = true;
                break;
            }
        }

        //从（1，1）,开始遍历，若自己为0,行首，列首都为0
        for(int i = 1;i < n;i ++){
            for(int j = 1;j < m;j ++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // 从(1,1)再次遍历，根据 行首，列首 判断每个元素是否该置0
        for(int i = 1;i < n;i ++){
            for(int j = 1;j < m;j ++){
                if(matrix[i][j] == 0){
                    continue;
                }
                else if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }


        //判断flag_r=true,第一行全置为0；flag_l=true，第一列全置为0
        if(flag_r){
            for(int i = 0; i < m; i++){
                matrix[0][i] = 0;
            }
        }
        if(flag_l){
            for(int i = 0; i < n; i++){
                matrix[i][0] = 0;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] arr=new int[][]{{1,1,1},{1,0,1},{1,1,1}};
        setZeroes(arr);
    }
}
