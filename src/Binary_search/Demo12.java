package Binary_search;

import java.io.*;
import java.util.*;

public class Demo12 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] L = new int[n];
        st = new StringTokenizer(br.readLine());
        int maxL = 0;
        for (int i = 0; i < n; i++) {
            L[i] = Integer.parseInt(st.nextToken());
            maxL = Math.max(maxL, L[i]);
        }

        int left = 1;
        int right = maxL;
        while (left < right) {
            int mid = (left + right) >>> 1; // 防止溢出
            long cutCount = 0;
            for (int len : L) {
                cutCount += (len - 1) / mid;
            }
            if (cutCount <= m) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left);
    }
}
