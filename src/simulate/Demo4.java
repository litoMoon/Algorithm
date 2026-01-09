package simulate;

//外观数列
public class Demo4 {
    public static String countAndSay(int n) {
        String str="1";
        for(int i=1;i<n;i++){
            int left=0,right=0,len=str.length();
            StringBuilder sbu=new StringBuilder();
            while(right<len){
                while(right<str.length() && str.charAt(left)==str.charAt(right))  right++;
                sbu.append(Integer.toString(right-left));
                sbu.append(str.charAt(left));
                left=right;
            }
            str=sbu.toString();
        }
    return str;
    }

    public static void main(String[] args) {
        countAndSay(1);
        System.out.println(countAndSay(4));

    }
    public static String countAndSay1(int n) {
        String str="1";
        while(n>1){
            int left=0,right=0;
            StringBuilder sbu=new StringBuilder();
            while(right<str.length()){
                int count=0;
                while(right<str.length() && str.charAt(left)==str.charAt(right)){
                    count++;
                    right++;
                }
                String s=count+""+str.charAt(left);
                left=right;
                right=right;
                sbu.append(s);
            }
            str=sbu.toString();
            n--;
        }
        return str;
    }
}
