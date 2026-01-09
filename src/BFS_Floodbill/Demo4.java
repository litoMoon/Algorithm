package BFS_Floodbill;

import java.util.ArrayDeque;
import java.util.Queue;

public class Demo4 {
    public static void main(String[] args) {
        char [][]grid1=new char[][]{{'O','O','O','O','O'},{'O','O','O','O','O'},{'O','O','O','O','O'}};//创建初始的岛屿
        char [][]grid=new char[][]{{'O','O','O'},{'O','O','O'},{'O','O','O'}};//创建初始的岛屿
        solve(grid);
    }
    static int[] x=new int[]{-1,1,0,0};
    static int[] y=new int[]{0,0,-1,1};
    public static void solve(char[][] board) {
        int lenOfH=board.length;
        int lenOfZ=board[0].length;
        Queue<int []> q=new ArrayDeque<>();//创建堆结构用于存储数据
        for (int i = 0; i < lenOfZ; i++) {
            if(board[0][i]=='O'){
                q.offer(new int[]{0,i});//先处理第一行
                board[0][i]='Q';
                while(!q.isEmpty()){
                    int []cur=q.poll();//将元素弹出来
                    for (int j = 0; j < 4; j++) {
                        int m=cur[0]+x[j];
                        int n=cur[1]+y[j];
                        if(m>=0 && m<lenOfH && n>=0 && n<lenOfZ && board[m][n]=='O'){
                            board[m][n]='Q';
                            q.offer(new int[]{m,n});
                        }
                    }
                }
            }

        }
        for (int i = 0; i < lenOfZ; i++) {
            if(board[lenOfH-1][i]=='O') { //处理的为最后一行
                q.offer(new int[]{lenOfH - 1, i});
                board[lenOfH - 1][i] = 'Q';
                while (!q.isEmpty()) {
                    int[] cur = q.poll();//将元素弹出来
                    for (int j = 0; j < 4; j++) {
                        int m = cur[0] + x[j];
                        int n = cur[1] + y[j];
                        if (m >= 0 && m < lenOfH && n >= 0 && n < lenOfZ && board[m][n] == 'O') {
                            board[m][n] = 'Q';
                            q.offer(new int[]{m, n});

                        }
                    }
                }
            }
        }
        for (int i = 0; i < lenOfH; i++) {
            if(board[i][0]=='O') { //处理的为第一行
                q.offer(new int[]{i, 0});
                board[i][0] = 'Q';
                while (!q.isEmpty()) {
                    int[] cur = q.poll();//将元素弹出来
                    for (int j = 0; j < 4; j++) {
                        int m = cur[0] + x[j];
                        int n = cur[1] + y[j];
                        if (m >= 0 && m < lenOfH && n >= 0 && n < lenOfZ && board[m][n] == 'O') {
                            board[m][n] = 'Q';
                            q.offer(new int[]{m, n});

                        }
                    }
                }
            }
        }
        for (int i = 0; i < lenOfH; i++) {
            if(board[i][lenOfZ-1]=='O') {//处理的为第一行
                q.offer(new int[]{i, lenOfZ - 1});//先处理第一排
                board[i][lenOfZ - 1] = 'Q';
                while (!q.isEmpty()) {
                    int[] cur = q.poll();//将元素弹出来
                    if (board[cur[0]][cur[1]] == 'O') //处理的为第一行
                        board[cur[0]][cur[1]] = 'Q';
                    for (int j = 0; j < 4; j++) {
                        int m = cur[0] + x[j];
                        int n = cur[1] + y[j];
                        if (m >= 0 && m < lenOfH && n >= 0 && n < lenOfZ && board[m][n] == 'O') {
                            board[m][n] = 'Q';
                            q.offer(new int[]{m, n});

                        }
                    }
                }
            }
        }
//        for (int i = 1; i < lenOfH-1; i++) {
//            for (int j = 1; j < lenOfZ-1; j++) {
//                if(board[i][j]=='O'){
//                    board[i][j]='X';
//                    q.offer(new int[]{i,j});
//                }
//                while(!q.isEmpty()){
//                    int[] cur=q.poll();
//                    for (int k = 0; k < 4; k++) {
//                        int m=cur[0]+x[k];
//                        int n=cur[1]+y[k];
//                        if(m>=0 && m<lenOfH && n>=0 && n<lenOfZ && board[m][n]=='O'){
//                            board[m][n]='X';
//                        }
//                    }
//                }
//            }
//        }
        for(int i=0;i<lenOfH;i++){
            for(int j=0;j<lenOfZ;j++){
                if(board[i][j]=='Q') board[i][j]='O';
                else if(board[i][j]=='O') board[i][j]='X';
            }
        }
    }
}
