package Sort;

import java.util.*;
import java.io.*;

//数位排序
public class Demo1 {

    static PrintWriter out=new PrintWriter(new OutputStreamWriter(System.out));
    //快速读入模板---搞清楚！！！！
    static BufferedReader in=new BufferedReader(new InputStreamReader(System.in));

    public static void main1(String[] args) throws IOException{
        int ret=0;
        int m=Integer.parseInt(in.readLine());
        int n=Integer.parseInt(in.readLine());
        List<List<Integer>> list=new ArrayList<>();
        for(int i=1;i<=m;i++) {
            if(i>=9) ret=change(i);
            else ret=i;
            if(ret<list.size()){
                list.get(ret-1).add(i);
            }else{
                List<Integer> list1=new ArrayList<>();
                list1.add(i);
                list.add(list1);
            }
        }
        for(List<Integer> cur:list){
            int num=cur.size();
            if(num<n) n-=num;
            else {
                //Collections.sort(cur);
                System.out.println(cur.get(n - 1));
                out.flush();//刷新之后再进行输出
                return ;
            }
        }

    }
    public static int change(int x){
        int sum=0;
        while(x!=0){
            sum+=x%10;
            x/=10;
        }
        return sum;
    }

    public static void main(String[] args) throws IOException{
        int m=Integer.parseInt(in.readLine());//表示数组长度
        int n=Integer.parseInt(in.readLine());
        Integer[] arr=new Integer[m];
        for(int i=0;i<m;i++) {
          arr[i]=i+1;
        }
        Arrays.sort(arr,new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                int s1=0,s2=0;
                int cur=o1;
                int cur2=o2;
                while(cur!=0){
                    s1+=cur%10;
                    cur/=10;
                }
                while(cur2!=0){
                    s2+=cur2%10;
                    cur2/=10;
                }
                if(s1!=s2) return s1-s2;
                else return o1-o2;
            }
        });
        System.out.println(arr[n-1]);

    }

    public static void main2(String[] args) {
        int[] arr=new int[]{3,6,1};
        Arrays.sort(arr);
    }



}
