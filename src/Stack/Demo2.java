package Stack;

public class Demo2 {
    public static void main(String[] args) {
        backspaceCompare("y#fo##f", "y#f#o##f");
        System.out.println(backspaceCompare("y#fo##f", "y#f#o##f"));

    }
    public static boolean backspaceCompare(String s, String t) {
        char[] chs=new char[s.length()];//字符数组
        char[] cht=new char[t.length()];//字符数组
        int j=0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='#') {
                if(j==0) continue;
                j--;
            }
            else chs[j++]=s.charAt(i);
        }
        int k=0;
        for (int i = 0; i < t.length(); i++) {
            if(t.charAt(i)=='#') {
                if(k==0) continue;
                k--;
            }
            else cht[k++]=t.charAt(i);
        }
        String retS=String.valueOf(chs,0,j);
        String retT=String.valueOf(cht,0,k);

        return retS.equals(retT);
    }
    public static boolean backspaceCompare2(String s, String t) {
        char[] chs=new char[s.length()+1];//字符数组
        char[] cht=new char[t.length()+1];//字符数组
        int j=1;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)!='#') chs[j++]=s.charAt(i);
            else j--;
        }
        int k=1;
        for (int i = 0; i < t.length(); i++) {
            if(t.charAt(i)!='#') cht[k++]=t.charAt(i);
            else k--;
        }
        String retS=String.valueOf(chs,1,j);
        String retT=String.valueOf(cht,1,k);

          return retS.equals(retT);
    }
}
