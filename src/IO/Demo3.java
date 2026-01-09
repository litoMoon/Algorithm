package IO;

import java.io.*;
import java.util.*;

public class Demo3 {
    //快读写出模板
    static PrintWriter out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    static Read3 in = new Read3();

    public static void main(String[] args) {

        out.close();//或者 out.flush();
    }

}

class Read3 {
    StringTokenizer st = new StringTokenizer("");
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    String next() throws IOException {
        while (!st.hasMoreTokens()) {
            st = new StringTokenizer(bf.readLine());
        }
        return st.nextToken();
    }
    int nextInt() throws IOException{
        return Integer.parseInt(next());
    }
    String nextLine() throws IOException{
        return bf.readLine();
    }
    long nextLong() throws IOException{
        return Long.parseLong(next());
    }
    double nextDouble() throws IOException{
        return Double.parseDouble(next());
    }

}