import java.util.HashSet;
import java.util.Set;

public class Test8 {
    public static void main1(String[] args) {
        long f1=1,f2=1,ans=2;
        while(f2<=20211001){
            long tmp=f1+f2;
            f1=f2;
            f2=tmp;
            ans++;
        }
        System.out.println(ans+1);
    }

    public static void main(String[] args) {
        Set<Integer> set=new HashSet<>();
        set.add(1);
        set.add(1);
        System.out.println(set.size());
    }
}
