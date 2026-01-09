package Recursion;

public class Demo11 {
    public static void main(String[] args) {
       char[][] board=new char[][]{{'A','A','A','A'},{'A','A','A','A'},{'A','A','A','A'}};
        //char[][] board=new char[][]{{'A','B'},{'C','D'}};
        String word="AAAAAAAAAAAB";
        exist(board, word);
        System.out.println(exist(board, word));

    }
   static boolean[][] visit;
    static int[] row=new int[]{0,0,1,-1};
    static int[] col=new int[]{-1,1,0,0};
    public static boolean exist(char[][] board, String word) {
        visit=new boolean[board.length][board[0].length];
        char ch=word.charAt(0);//先提取到第一个字符
        int x=0,y=0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==ch) {
                    x=i; y=j;//记录下第一个字符的位置
                    visit[i][j]=true;
                   if(dfs(board,x,y,word,1) ==true) return true;
                   visit[i][j]=false;
                }
            }
        }
       return  false;
    }
    public static boolean dfs(char[][] b,int x,int y,String s,int pos){
        for(int i=0;i< 4;i++){
                int m=x+row[i],n=y+col[i];
                if(m< b.length && m>=0 && n<b[0].length && n>=0 && b[m][n]==s.charAt(pos) && visit[m][n]==false){
                    if(pos==s.length()-1) return true;//意味着找到了最后一个位置
                    visit[m][n]=true;
                    if(dfs(b,m,n,s,pos+1)==true) return true;
                    visit[m][n]=false;
                }

        }
        return false;//将上下左右找遍了都没有找到值，此时返回false
    }
}
