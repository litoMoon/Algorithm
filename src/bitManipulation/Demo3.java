package bitManipulation;

public class Demo3 {
    public static int hammingDistance(int x, int y) {
        int count=0;
        x=x^y;
        while(x!=0){
            x&=x-1;
            count++;
        }
        return count;

    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
    }
}
