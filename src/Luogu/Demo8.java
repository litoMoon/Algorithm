package Luogu;

import java.util.*;
public class Demo8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        List<int[]> blocks = new ArrayList<>();
        int currentVal = a[0];
        int count = 1;

        for (int k= 1; k < n; k++) {
            if (a[k] == currentVal) {
                count++;
            } else {
                blocks.add(new int[]{currentVal, count});
                currentVal = a[k];
                count = 1;
            }
        }
            blocks.add(new int[]{currentVal, count});

        int maxScore = 0;
        for (int[] block : blocks) {
            maxScore = Math.max(maxScore, block[0] * block[1]);
        }

        int blocksSize = blocks.size();
        for (int i = 0; i < blocksSize; i++) {
            for (int j = i+1; j < blocksSize; j++) {

                int leftVal = blocks.get(j)[0];
                int leftLen = blocks.get(j)[1];
                if (i > 0 && blocks.get(i - 1)[0] == leftVal) {
                    leftLen += blocks.get(i - 1)[1];
                }

                int rightVal = blocks.get(i)[0];
                int rightLen = blocks.get(i)[1];
                if (j + 1 < blocksSize && blocks.get(j + 1)[0] == rightVal) {
                    rightLen += blocks.get(j + 1)[1];
                }

                maxScore = Math.max(maxScore, leftVal * leftLen);
                maxScore = Math.max(maxScore, rightVal * rightLen);
            }
        }

        System.out.println(maxScore);
    }
}
