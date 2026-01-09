package Recursion;
//解独数
public class Demo10 {
   static boolean[][] row,col;
   static boolean[][][] grid;
    public static void solveSudoku(char[][] board) {
        row=new boolean[9][10];//9行，但是数字的范围是从1-9
        col=new boolean[9][10];
        grid=new boolean[3][3][10];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!=' '){
                    int num=board[i][j]-'0';
                    row[i][num]=col[j][num]=grid[i/3][j/3][num]=true;
                }
            }
        }
        dfs(0,board);//表示行

    }
    public static void dfs(int x,char[][] board){
        if(x==board.length+1) return;
        //表示列
        for(int i=0;i<9;i++) {
            if(board[x][i]==' '){
                int num=i+1;
                if(!row[x][num] && !col[i][num] && !grid[x/3][i/3][num]){
                    board[x][i]=(char)(num+'0');
                    row[x][num]=col[i][num]=grid[x/3][i/3][num]=true;
                    dfs(x+1,board);
                    row[x][num]=col[i][num]=grid[x/3][i/3][num]=false;
                    board[x][i]=' ';
                }
            }
        }

    }

    public static void main(String[] args) {
        char[][] b=new char[][]{};
        solveSudoku(b);

    }


}
