package School_game;

public class Demo8 {
    public static void main(String[] args) {
        String s1="hello java";
        String s2=new String("hello java");
        String s3=new String("hello java");
        System.out.println(s1.compareTo(s2));
        System.out.println(s1.equals(s2));
        System.out.println(s1==s2);
        System.out.println(s2.equals(s3));
        System.out.println(s2==s3);
        System.out.println(s1.equals(s3));
        System.out.println(s2.compareTo(s3));
    }
}
