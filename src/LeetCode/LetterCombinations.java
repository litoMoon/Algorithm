package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {
    private String []str=new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    private List<String> ret;
    private StringBuilder path;
    public List<String> letterCombinations(String digits) {
        ret=new ArrayList<>();
        path=new StringBuilder();
        dfs(digits,0);
        return ret;
    }

    private void dfs(String digits,int n) {
        if(path.length()==digits.length()) {
            ret.add(path.toString());
            return ;
        }
        int num=digits.charAt(n)-'0';//转化为数字
        for(int j=0;j<str[num].length();j++){
            path.append(str[num].charAt(j));
            dfs(digits,n+1);
            path.deleteCharAt(path.length()-1);//恢复现场
        }
    }

}

