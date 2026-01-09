package Stack;

import java.util.Stack;

public class Demo4 {
    public static void main(String[] args) {
        System.out.println(decodeString("100[leetcode]"));

    }
    public static String decodeString(String _s) {
        char []s=_s.toCharArray();
        Stack<Integer> stackInt=new Stack<>();
        Stack<String> stackString=new Stack<>();
        stackString.push("");
        int i=0,len=_s.length();
        while(i<len){
            if(s[i]>='1' && s[i]<='9') {
                int tmp=0;
                while(i<len && s[i]>='0' && s[i]<='9'){
                   tmp=tmp*10+(s[i]-'0');
                    i++;
                }
                stackInt.push(tmp);
            }
            else if(s[i]=='['){
                StringBuffer sbu=new StringBuffer();
              //  sbu.append(stackString.pop());
                i++;
                while(i<len && s[i]>='a' && s[i]<='z'){
                    sbu.append(s[i]);
                    i++;
                }
                stackString.push(sbu.toString());//将其转化为字符串扔进去
            }else if(s[i]==']'){
                StringBuffer sbu=new StringBuffer();
                String str=stackString.pop();
                sbu.append(stackString.pop());
                int num=stackInt.pop();
                while(num>0){
                    sbu.append(str);
                    num--;
                }
                stackString.push(sbu.toString());
                i++;
            }else{
                StringBuffer sbu=new StringBuffer();
                sbu.append(stackString.pop());
                while(i<len && s[i]>='a' && s[i]<='z'){
                    sbu.append(s[i]);
                    i++;
                }
                stackString.push(sbu.toString());
            }

        }

        return stackString.pop();
    }
}
