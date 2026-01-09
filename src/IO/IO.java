package IO;

import java.io.*;
import java.util.*;

public class IO {
   static PrintWriter out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
   static  Read1 in=new Read1();
    public static void main(String[] args) {

    }
}
class Read1{
    StringTokenizer st=new StringTokenizer("");//传入空字符串，但是这个类的本质是会按照字符串的特点对内容进行分割
    BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));

    String next() throws IOException{
        while(!st.hasMoreTokens()){
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
    double nextDouble() throws IOException{
        return Double.parseDouble(next());
    }
}
