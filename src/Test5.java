import java.util.*;


public class Test5 {
    int[] arr;
    public static void main(String[] args) {
        int[]arr=new int[3];
        for (int x:arr) {
            System.out.print(x);//注意此时输出的结果为0 0 0
        }
    }
    public static void main2(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        List<Integer> list1=new ArrayList<>();
        list1.add(5);
        list1.add(6);
        list1.add(7);
        list1.add(8);
        List<List<Integer>> lists=new ArrayList<>();
        lists.add(list);
        lists.add(list1);






    }
    public static void main1(String[] args) {
        PriorityQueue<Integer> heap=new PriorityQueue<>((a,b)->b-a);
        heap.add(4);
        heap.add(2);
        heap.add(3);
        heap.add(1);
     while(!heap.isEmpty()){
         System.out.print(heap.poll()+" ");//这里是元素的弹出，元素的每次弹出会重新进行堆的调整然后再次弹出
     }
    }
}
