import java.util.*;

public class Test10 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        Map<Integer,Integer> map=new HashMap<>();
        long ans=0;
        for(int i=0;i<n;i++) {
            int m=scan.nextInt();
            map.put(m,map.getOrDefault(m,0)+1);
            map.put(m-1,map.getOrDefault(m-1,0)+1);
            map.put(m+1,map.getOrDefault(m+1,0)+1);
        }
        for(int x:map.values()){
            ans=Math.max(x,ans);
        }
        //ans记录的最终结果是个数
        System.out.println(ans);
        System.out.printf("");//直接输入 souf+回车可获得


    }
}
