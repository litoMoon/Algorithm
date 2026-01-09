package BFS_shortestPath;

import java.util.*;


public class Demo4 {
    public static void main(String[] args) {

    }
   static int m,n;
   static int []dx=new int[]{-1,1,0,0};
   static int []dy=new int[]{0,0,-1,1};
    public int cutOffTree(List<List<Integer>> f) {
        m=f.size(); n=f.get(0).size();
        //前期准备:确定砍树顺序，一个List，其中存储的元素为数组
        List<int[]> trees=new ArrayList<>();
        for (int i = 0; i < f.size(); i++) {
            for (int j = 0; j < f.get(0).size(); j++) {
                if(f.get(i).get(j)>1)
                trees.add(new int[]{i,j});
            }
        }
        Collections.sort(trees,(a,b)->{
            return f.get(a[0]).get(a[1])-f.get(b[0]).get(b[1]);
        });

        int ret=0;
        int bx=0,by=0;//初始都是从(0,0)开始
        //按照顺序砍树
        for (int []cur:trees) {
            int x=cur[0];
            int y=cur[1];
            int step=bfs(f,bx,by,x,y);
            if(step==-1) return -1;
            ret+=step;
            bx=x;
            by=y;
        }
        return ret;
    }
    public static int bfs(List<List<Integer>> f,int bx,int by,int ex,int ey){
        if(bx==ex && by==ex) return 0;
        int count=0;
        Queue<int[]> q=new ArrayDeque<>();
        boolean[][] bool=new boolean[m][n];
        q.offer(new int[]{bx,by});
        bool[bx][by]=true;
        while(!q.isEmpty()){
            int size=q.size();
            count++;
            while(size-- >0){
                int []cur=q.poll();
                for (int i = 0; i < 4; i++) {
                    int x=dx[i]+cur[0];
                    int y=dy[i]+cur[1];
                    if(x>=0 && x<m && y>=0 && y<n && !bool[x][y] && f.get(cur[0]).get(cur[1])!=0){
                        if(x==ex && y==ey) return count;
                        q.offer(new int[]{x,y});
                        bool[x][y]=true;
                    }
                }
            }
        }
        return -1;
    }

}
