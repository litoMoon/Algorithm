package niuke;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Demo5 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param grid int整型ArrayList<ArrayList<>>
     * @return int整型
     */
    static int[] x1=new int[]{0,0,1,-1};
    static int[] y1=new int[]{1,-1,0,0};
    public static int rotApple (ArrayList<ArrayList<Integer>> grid) {
        int row = grid.size();
        int col = grid.get(0).size();
        int[][] arr = new int[row][col];
        boolean[][] bool=new boolean[row][col];
        Queue<int[]> que=new ArrayDeque<>();//队列存储被污染苹果的坐标
        int app = 0;
        int res=0;
        for(int i = 0;i < row;i++){
            for(int j = 0;j < col;j++){
                arr[i][j] = grid.get(i).get(j);
                if(arr[i][j] == 1){
                    app++; //记录好苹果的数量
                }
                if(arr[i][j] == 2){
                    que.add(new int[]{i,j});//存储腐烂苹果的坐标
                }
            }
        }
        while(!que.isEmpty()){
            int size = que.size();
            res++;
            while(size-->0){
                int[] cur = que.poll();
                int x0 = cur[0];
                int y0 = cur[1];
                arr[x0][y0]=0;
                for(int i = 0;i < 4;i++){
                   int x = x0 + x1[i];
                   int y = y0 + y1[i];
                   if(x >= 0 && x<row && y >= 0 && y < col && arr[x][y] == 1 && !bool[x][y]){
                       que.add(new int[]{x , y});
                       bool[x][y]=true;
                       app--;
                   }
                }

            }
        }
        if(app == 0){
            return res-1;
        }else{
            return -1;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr1=new ArrayList<>();
        arr1.add(2);
        arr1.add(1);
        arr1.add(0);
        ArrayList<Integer> arr2=new ArrayList<>();
        arr2.add(1);
        arr2.add(0);
        arr2.add(1);
        ArrayList<Integer> arr3=new ArrayList<>();
        arr3.add(0);
        arr3.add(0);
        arr3.add(0);
        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
        arr.add(arr1);
        arr.add(arr2);
        arr.add(arr3);
        System.out.println(rotApple(arr));
    }
}
