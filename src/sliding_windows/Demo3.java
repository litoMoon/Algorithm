package sliding_windows;

public class Demo3 {
    //方法一
    public static String minWindow(String s, String t) {
        int left=0,right=0,ret=Integer.MAX_VALUE,len=Integer.MAX_VALUE;
        int hash1 []=new int[64];
        int hash2 []=new int[64];

        //将 t 中的元素放入 hash1 中
        for (int i=0;i<t.length();i++) {
            char in=t.charAt(i);
            hash1[in-'A']++;
        }

        while(right<s.length()){
        //进入窗口
            hash2[s.charAt(right)-'A']++;
            //判断条件
            while(check(hash1,hash2,t)){
                if(right-left+1 <len){
                    ret=left;
                    len=right-left+1;
                }
                hash2[s.charAt(left)-'A']--;
                left++;
            }
            right++;
        }

        return ret==Integer.MAX_VALUE?s.substring(0,0):s.substring(ret,ret+len);
    }
    public static boolean check(int [] hash1,int []hash2,String t){
        for (int i = 0; i < t.length(); i++) {
            char out=t.charAt(i);
            if(hash1[out-'A']>hash2[out-'A']) return false;
        }
        return true;
    }

    //方法一的优化之后的版本
    public static String minWindowPlus(String ss, String tt) {
        int left=0,right=0,kinds=0,count=0,ret=-1,len=Integer.MAX_VALUE;
        char[] s=ss.toCharArray();
        char[] t=tt.toCharArray();
        int[] hash1=new int[128];
        int[] hash2=new int[128];
        for (char x:t) {
            if(hash1[x]++==0) kinds++; //记录种类
        }
        while(right<s.length){
            int in=s[right];
            if(++hash2[in]==hash1[in]) count++; // 记录s中的种类
            while(kinds==count){
                //更新结果
                if(right-left+1<len){
                    ret=left;
                    len=right-left+1;
                }
                int out=s[left++];
                if(hash2[out]--==hash1[out]) count--;
            }
            right++;

        }

        if(ret==-1) return new String("");
        return ss.substring(ret,ret+len);

    }
    public static void main(String[] args) {
        String s="ADOBECODEBANC";
        String s1="ABC";
        System.out.println(minWindowPlus(s, s1));
        System.out.println(minWindowPlus(s,s1));
    }


}
