package LeetCode;

public class RotateImage {
    public static void rotate(int[][] matrix) {
        //交换正对角线的数据
        int len_row=matrix.length;//行数
        int len_col=matrix[0].length;//列数
        for(int i=0;i<len_row;i++){
            for(int j=i+1;j<len_col;j++){
                //交换对应元素
                int cur=matrix[j][i];
                matrix[j][i]=matrix[i][j];
                matrix[i][j]=cur;
            }
        }
        //交换左右的元素
        for(int i=0;i<len_row;i++){
            int left=0;
            int right=len_col-1;
            while(left<right){
                int cur=matrix[i][left];
                matrix[i][left++]=matrix[i][right];
                matrix[i][right--]=cur;
            }
        }
        for(int i=0;i<len_row;i++){
            for(int j=0;j<len_col;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int [][]arr=new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        RotateImage.rotate(arr);
    }
}
