import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Test12 {

    public static void main(String[] args) {
        // 请在Begin-End间编写代码
        /********** Begin **********/
        // 第一步：接收给定的字符串
        Scanner scan=new Scanner(System.in);
        String s=scan.nextLine();
        String[] strs=s.split(",");
        Set<String> list=new HashSet<>();
        for(String s1:strs){
            list.add(s1);
        }
        if(list.size()>4 ){
            if(!list.contains("hello"))
                list.add("hello");
            else{
                System.out.println("集合中已有该元素");

            }
        }else{
            System.out.println("元素个数小于4");
        }
        System.out.println(list);

        // 第二步：切割字符串

        // 第三步：创建集合

        // 第四步：将切割后的元素添加进集合

        // 第五步：判断集合中元素个数是否大于4

        // 第六步：当元素个数大于4，且元素中含有hello时，输出指定提示语

        // 第七步：当元素个数大于4，且元素中不含hello时，把hello添加进集合

        // 第八步：当元素个数小于4，输出指定提示语

        // 第九步：输出集合

        /********** End **********/
    }
}

