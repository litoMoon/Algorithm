import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
public class Test7 {
    public static void main1(String[] args) {
        int sum=0;
        for(int i=1;i<=16;i++){
            sum+=i;
        }
        System.out.println(sum);
        System.out.println(16+8*15);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str=scan.nextLine();
        int []l=new int[100000];
        int []n=new int[100000];
        int count_l=0,count_n=0;
        long sum=0;
        char[] ch=str.toCharArray();//转化为字符数组
        for(int i=0;i<ch.length;i++){
            if(ch[i]=='l') count_l++;
            l[i]=count_l;
        }
        for(int i=ch.length-1;i>=0;i--){
            if(ch[i]=='n') count_n++;
            n[i]=count_n;
        }
        for(int i=0;i<ch.length;i++){
           if(ch[i]=='a'){
               sum+=l[i-1]*n[i+1];
            }
        }
        System.out.println(sum);

        scan.close();

    }

    public static void main2(String[] args) {
                // 原始int数组
                int[] intArray = {5, 2, 9, 1, 5, 6};
int[]arr=new int[]{1,3,9,57,8};
                // 将int数组转换为Integer数组
                Integer[] integerArray = Arrays.stream(arr).boxed().toArray(Integer[]::new);

                // 使用Arrays.sort和Collections.reverseOrder进行降序排序
                Arrays.sort(integerArray, Collections.reverseOrder());

                // 如果需要，将排序后的Integer数组转换回int数组
                int[] sortedIntArray = Arrays.stream(integerArray).mapToInt(Integer::intValue).toArray();

                // 输出排序后的int数组
                System.out.println("Sorted array (descending order): " + Arrays.toString(sortedIntArray));
            }
        }

