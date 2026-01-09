package DEF_hanota;

import java.util.List;

public class Demo1 {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        int n=A.size();
        def(A,B,C,n);
    }
    public void def(List<Integer> x,List<Integer> y,List<Integer> z,int n){
        if(n==1) {
            z.add(x.remove(x.size()-1));
            return ;
        }
        def(x,z,y,n-1);
        z.add(x.remove(x.size()-1));
        def(y,x,z,n-1);
    }
}
