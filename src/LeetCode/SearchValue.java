package LeetCode;

public class SearchValue {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                //横着的元素
                if (matrix[i][j] == target)
                    return true;
                else if (matrix[i][j] > target)
                    break;

            }
            for (int j = i; j < m; j++) {
                //竖着的元素
                if (matrix[j][i] == target)
                    return true;
                else if (matrix[j][i] > target)
                    break;

            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr=new int[][]{{-1},{-1}};
        int target=2;
        System.out.println(searchMatrix(arr, target));
    }
}
