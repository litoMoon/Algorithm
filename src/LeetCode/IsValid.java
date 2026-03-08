package LeetCode;

public class IsValid {
        public boolean isValid(String s) {
            int len=s.length();
            int [] result=new int[len];
            int size=0;
            for(int i=0;i<len;i++){
                char ch=s.charAt(i);
                if(ch=='(' || ch=='{' || ch=='[') result[size++]=ch;
                else{
                    if(ch==']' && size>0 && result[size-1]=='[') size--;
                    else if(ch=='}' && size>0 && result[size-1]=='{') size--;
                    else if(ch==')' && size>0 && result[size-1]=='(') size--;
                    else return false;
                }
            }
            if(size==0) return true;
            else return false;
        }
}
