package Stack;

public class Demo1 {
    public static String removeDuplicates2(String s) {
        //设定一个字符数组用来存储最终需要返回字符
        char[] ch=new char[s.length()+1];
        int j=1;
        for (int i = 0; i < s.length(); i++) {
             if(s.charAt(i)!=ch[j-1]){
                 ch[j++]=s.charAt(i);
              //  j--;
            }else if(s.charAt(i)==ch[j-1]){
                j--;
            }
        }
        return String.valueOf(ch,1,j-1);//将字符数组转化为字符串
    }

    //方法二：可以直接使用 StringBuffer 或者 StringBuilder
    public static String removeDuplicates(String _s) {
        //设定一个字符数组用来存储最终需要返回字符
        StringBuilder ret=new StringBuilder();
        char[] s=_s.toCharArray();
        for (char ch:s) {
            if(ret.length()>0 && ch==ret.charAt(ret.length()-1)){
                ret.deleteCharAt(ret.length()-1);//如果相等删除栈顶的元素
            }else{
                ret.append(ch);
            }
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        String str="abbacdfgr";
        removeDuplicates(str);
        System.out.println(removeDuplicates(str));

    }
}
