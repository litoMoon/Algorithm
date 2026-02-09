package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//实现Trie（前缀树）方法一
/*class Trie {
     Set<String> set;
    public Trie() {
        set=new HashSet<>();
    }

    public void insert(String word) {
        set.add(word);
    }

    public boolean search(String word) {
        return set.contains(word);
    }

    public boolean startsWith(String prefix) {
        for (String s:set) {
            if(s.indexOf(prefix)==0) return true;
        }
        return false;
    }
}*/

//实现Trie（前缀树）方法二
class Trie {
    private Trie[] children=null;
    private boolean isEnd;
    public Trie() {
        children=new Trie[26]; //长度为26的Trie类型的数组
        isEnd=false;
    }

    public void insert(String word) {
        Trie node=this;
        for (char c:word.toCharArray()) {
            int index=c-'a';
            if(node.children[index]==null){
                node.children[index]=new Trie();
            }
            node=node.children[index];//往下一层走
        }
        node.isEnd=true;
    }

    public boolean search(String word) {
        Trie node=searchWord(word);
        return node!=null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchWord(prefix)!=null;
    }
    public Trie searchWord(String word){
        Trie node=this;
        for (char c:word.toCharArray()) {
            int index=c-'a';
            if(node.children[index]==null) return null;
            node=node.children[index];
        }
        return node;
    }
}



