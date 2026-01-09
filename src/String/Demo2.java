package String;

//求最长的回文子串
public class Demo2 {
    public static String longestPalindrome(String s) {
        if(s.length()==0) return null;
     //   if(s.length()==1) return s;
        int mid=0,maxlen=0,ret=0;
        while(mid<s.length()){
            // left 和 right 同时往两边走
            int left=mid,right=mid;
            while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
                if((right-left+1)>maxlen){
                    ret=left;
                    maxlen=right-left+1;
                }
                left--;
                right++;

            }


            //计算偶数的可能
            left=mid; right=mid+1;
            while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
                if((right-left+1)>maxlen){
                    ret=left;
                    maxlen=right-left+1;
                }
                left--;
                right++;

            }

            mid++;
        }
        return s.substring(ret,ret+maxlen);
    }

    public static void main(String[] args) {
      //  longestPalindrome("b");
        System.out.println(longestPalindrome("b"));
    }

}
