package LeetCode;

public class Exist {
    public static int[] xx = new int[] { 1, -1, 0, 0 };
    public static int[] yy = new int[] { 0, 0, -1, 1 };
    public static boolean[][] visit;

    public static boolean exist(char[][] board, String word) {
        visit=new boolean[board.length][board[0].length];
        boolean ans = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visit[i][j]=true;
                    ans = dfs(board, word, i, j, 1);
                    visit[i][j]=false;
                    if(ans) return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] b, String w, int m, int n, int pos) {

        for (int i = 0; i < 4; i++) {
            int x = xx[i] + m; //获取新的x
            int y = yy[i] + n; //获取新的y
            if (x < b.length && x >= 0 && y < b[0].length && y >= 0 && !visit[x][y]) {
                if (b[x][y] == w.charAt(pos)) {
                    visit[x][y]=true; pos+=1;
                    if(pos == w.length()) return true;
                    if(dfs(b, w, x, y, pos)) return true;
                    visit[x][y]=false;
                }
            }

        }
        return false;

    }

    public static void main(String[] args) {
        char[][] board=new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word="ABCCED";
        System.out.println(exist(board, word));
    }
}
