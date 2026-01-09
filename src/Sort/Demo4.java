package Sort;
import java.util.*;
public class Demo4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //输入士兵数量和团购需要的总价钱
        int n=scan.nextInt();
        long s=scan.nextLong();
        //用sum来存储总值
        long sum=0L;
        //创建hash表用于存储值
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            int p=scan.nextInt();
            int c=scan.nextInt();
            //注意此时这里的第二次会覆盖第一次的值，因为HashMap的键是唯一的，重复添加相同键会更新其对应的值
            map.put(c,map.getOrDefault(c,0)+p);
            sum+=p;
        }
        //list用于存储训练的次数
        //keySet()方法是返回Map中所有键(key)组成的集合,如果说需要操作值就写map.values()，如果需要的是键值对就是map.entrySet();
        List<Integer> list=new ArrayList<>(map.keySet());//这个函数的原有
        //对list用于排序(默认是从小到大)
        Collections.sort(list);

        //ans用来记录最终需要的最少的金币数
        long ans=0L;
        //用来记录每次最少的次数
        long tmp=0L;
        for(int i=0;i<list.size();i++){
            ans+=(list.get(i)-tmp)*Math.min(s,sum);
            sum-=map.get(list.get(i));
            tmp=list.get(i);
        }
        scan.close();
        System.out.println(ans);
    }
}
