package niuke;

import java.util.*;
import java.io.*;

public class Demo43 {
    public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static Read in = new Read();

    public static void setRow() {
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int cur = nums[i][j];
                nums[i][j] = nums[n - 1 - i][j];
                nums[n - 1 - i][j] = cur;
            }
        }
    }
    public static void setCol() {
        //列交换
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int cur = nums[i][j];
                nums[i][j] = nums[i][n - 1 - j];
                nums[i][n - 1 - j] = cur;
            }
        }
    }
    public static int n;
    public static int[][] nums;
    public static void main(String[] args) throws IOException{
//         Scanner in = new Scanner(System.in);
        n = in.nextInt();
        nums = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = in.nextInt();
            }
        }
        int q = in.nextInt();
        int row = 0, col = 0;
        //统计 1 和 2 的个数
        while (q-- > 0) {
            int x = in.nextInt();
            if (x == 1) {
                row++; col++;
            } else {
                row++;
            }
        }

        row %= 2; col %= 2;
        // %2 之后的值只有 0 或者 1，这里判断了不是 0，那么就会是 1
        if (row != 0) setRow();
        if (col != 0) setCol();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                out.print(nums[i][j] + " ");
            }
            out.println();
        }

        out.close();
    }
}
class Read // ⾃定义快速读⼊
{
    StringTokenizer st = new StringTokenizer("");
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String next() throws IOException {
        while(!st.hasMoreTokens()){
            st = new StringTokenizer(bf.readLine());
        }
        return st.nextToken();
    }

    String nextLine() throws IOException {
        return bf.readLine();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
}