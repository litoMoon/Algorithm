package Luogu;
import java.util.*;
public class Demo5 {
  //  static char[]chars=new char[]{'A','B','C','D','E','F','G','H'};
  public static void main(String [] args){
      Scanner scan=new Scanner(System.in);
      int m=scan.nextInt();
      for(int i=1;i<m;i++){
          for(int j=1;j<=i;j++){
              if(i>=10) System.out.print((char)('A'+i-10)+"*");
              else System.out.print(i+"*");
              if(j>=10) System.out.print((char)('A'+j-10)+"=");
              else System.out.print(j+"=");
              int sum=i*j;
              StringBuilder sbu=new StringBuilder();
              while(sum!=0){
                  int ret=sum%m;
                  if(ret>=10) sbu.append((char)('A'+ret-10));
                  else sbu.append(ret);
                  sum/=m;
              }
                  System.out.print(sbu.reverse()+" ");
          }
          System.out.println();
      }
  }
}
