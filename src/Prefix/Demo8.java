package Prefix;

//矩阵区域和
public class Demo8 {
    public static int[][] matrixBlockSum(int[][] mat, int k) {
        int [][] ret=new int[mat.length][mat[0].length]; // 返回的数组
        int[][]dp=new int[mat.length+1][mat[0].length+1];// 创建 dp 表
        //计算前缀和
        for(int i=1;i<dp.length;i++){
            for (int j = 1; j <dp[0].length ; j++) {
                dp[i][j]=dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1]+mat[i-1][j-1]; //计算前缀和
            }
        }

        //计算返回后的数组
        for (int i = 0; i < mat.length ; i++) {
            for (int j = 0; j <mat[0].length ; j++) {
                int x1=Math.max(0,i-k)+1;
                int y1=Math.max(0,j-k)+1;
                int x2=Math.min(i+k,mat.length-1)+1;
                int y2=Math.min(j+k,mat[0].length-1)+1;
                ret[i][j]=dp[x2][y2]-dp[x2][y1-1]-dp[x1-1][y2]+dp[x1-1][y1-1];
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int [][]num=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int [][] ret=matrixBlockSum(num, 1);
        for (int i = 0; i < ret.length; i++) {
            for (int j = 0; j < ret[0].length; j++) {
                System.out.print(ret[i][j]+"  ");
            }
            System.out.println();
        }
    }
}
