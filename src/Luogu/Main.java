package Luogu;

import java.io.*;
import java.util.*;
public class Main {
    static PrintWriter out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static Read in=new Read();
    public static void main(String[] args) throws IOException{
        int n=in.nextInt();
        long []a=new long[n];
        long maxScore=0;
        Map<Long,Long> map=new HashMap<>();
        for(int i=0;i<n;i++) {
            a[i]=in.nextInt();//快读
            map.put(a[i],map.getOrDefault(a[i], (long)0)+1);
            maxScore=Math.max(maxScore,map.get(a[i])*a[i]);//再怎么至少都会有一个
        }
        for(int i=0;i<n;i+=map.get(a[i])) {
            for(int j=i+1;j<map.size();j++) {
                long leftVal=a[j];
                long leftLen=map.get(a[j]);
                if(i>0 && map.get(a[i-1])==leftVal) {
                    leftLen+=map.get(a[i-1]);
                    maxScore=Math.max(maxScore,1L*leftVal*leftLen);
                }
                long rightVal=a[i];
                long rightLen=map.get(a[i]);
                if(j+1<map.size() && map.get(a[j+1])==rightVal) {
                    rightLen+=map.get(a[i-1]);
                    maxScore=Math.max(maxScore,1L*rightVal*rightLen);
                }

            }

        }
        System.out.println(maxScore);


    }

}
class Read{
    StringTokenizer st=new StringTokenizer("");
    BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
    String next() throws IOException{
        while(!st.hasMoreTokens()) {
            st=new StringTokenizer(bf.readLine());
        }
        return st.nextToken();
    }
    String nextLine() throws IOException{
        return bf.readLine();
    }
    int nextInt() throws IOException{
        return Integer.parseInt(next());
    }
    long nextLong() throws IOException{
        return Long.parseLong(next());
    }
}

