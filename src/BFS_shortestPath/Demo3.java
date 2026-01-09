package BFS_shortestPath;


import java.util.*;


//为高尔夫比赛砍树
public class Demo3 {
    public static void main(String[] args) {
//        54581641,64080174,24346381,69107959
        List<Integer> list=new ArrayList<>();
        list.add(54581641);
        list.add(64080174);
        list.add(24346381);
        list.add(69107959);
//        86374198,61363882,68783324,79706116
        List<Integer> list1=new ArrayList<>();
        list1.add(86374198);
        list1.add(61363882);
        list1.add(68783324);
        list1.add(79706116);
        List<Integer> list2=new ArrayList<>();
//        668150,92178815,89819108,94701471
        list2.add(668150);
        list2.add(92178815);
        list2.add(89819108);
        list2.add(94701471);
        List<Integer> list3=new ArrayList<>();
//       83920491,22724204,46281641,47531096
        list3.add(83920491);
        list3.add(22724204);
        list3.add(46281641);
        list3.add(47531096);
        List<Integer> list4=new ArrayList<>();
//       89078499,18904913,25462145,60813308
        list4.add(89078499);
        list4.add(18904913);
        list4.add(25462145);
        list4.add(60813308);
        List<Integer> list5=new ArrayList<>();
        list5.add(2);
        list5.add(3);
        list5.add(4);
        List<Integer> list6=new ArrayList<>();
        list6.add(0);
        list6.add(0);
        list6.add(5);
        List<Integer> list7=new ArrayList<>();
        list7.add(8);
        list7.add(7);
        list7.add(6);
        List<Integer> list8=new ArrayList<>();
        list8.add(0);
        list8.add(0);
        list8.add(3);

        List<List<Integer>> lists=new ArrayList<>();
        lists.add(list);
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        lists.add(list4);
//        lists.add(list5);
//        lists.add(list6);
//        lists.add(list7);
//          lists.add(list8);
        System.out.println(cutOffTree(lists));
        HashMap<Integer,int[]>hashMap=new HashMap<>();//用来存储下标
        //把元素扔进一维数组，后对元素进行排序

    }
    static int[] dx=new int[]{-1,1,0,0};
    static int[] dy=new int[]{0,0,-1,1};
  //  static int count=0;
    static HashMap<Integer,int[]> map=new HashMap<>();
    static int k=0;
    //static Queue<int[]> q=new ArrayDeque<>();
    public static int cutOffTree(List<List<Integer>> forest) {
        int sum=0,rowCount=forest.size(),colCount=forest.get(0).size(),ret=-1,cnt=0;
        int[] arr=new int[rowCount*colCount];
        //将list转化为二维数组并且此时也初始化好了一维数组
        int[][] f= convertTo2DArray(forest,arr);
        Arrays.sort(arr,0,k);//给数组进行排序
        for (int i = 0; i < k-1; i++) {
            if(arr[i+1]!=0)
           ret=findCount(map.get(arr[i]),map.get(arr[i+1]),f);
            if(ret==-1) return -1;
            sum+=ret;

        }
        int[] num=map.get(arr[0]);
        if(num[0]==0 && num[1]!=0) cnt=num[1];
        else if(num[0]!=0 && num[1]==0) cnt=num[0];
        else if(num[0]!=0 && num[1]!=0) cnt=num[0]+num[1];

        return sum==0?-1:sum+cnt;
    }
    public static int[][] convertTo2DArray(List<List<Integer>> list,int[] arr){

        if(list==null || list.isEmpty()) return new int[0][0];
        int rowCount=list.size();// row 表示横
        if(rowCount==0) return new int[0][0];
        int colCount=list.get(0).size();// col 表示纵，list.get(0)取得是第一行的一个list组
        int[][] array=new int[rowCount][colCount];

        //接下来执行将元素放入二维数组
        for (int i = 0; i < rowCount; i++) {
            List<Integer> cur=list.get(i);
            for (int j = 0; j < colCount; j++) {
                array[i][j]=cur.get(j);
                map.put(array[i][j],new int[]{i,j});
                if(array[i][j]!=0)
                arr[k++]=array[i][j];
            }
        }
        return array;

    }
    public static int findCount(int []cur1,int[] cur2,int [][]arr) {
        Queue<int[]> q=new ArrayDeque<>();
        int m=arr.length;
        int n=arr[0].length;
        boolean[][]bool=new boolean[m][n];
        q.offer(new int[]{cur1[0],cur1[1]});
        bool[cur1[0]][cur1[1]]=true;
        int count = 0;
        while (!q.isEmpty()) {
            count++;
            int size = q.size();
            for (int k = 0; k < size; k++) {
                int[] cur = q.poll();
                for (int j = 0; j < 4; j++) {
                    int x = dx[j] + cur[0];
                    int y = dy[j] + cur[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && arr[x][y] != 0 && !bool[x][y]) {
                        if(x==cur2[0] && y==cur2[1]) return count;
                        q.offer(new int[]{x,y});
                        bool[x][y]=true;
                    }
                }
            }
        }
        return -1;
    }
}
