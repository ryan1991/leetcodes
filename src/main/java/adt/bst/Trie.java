package adt.bst;

import java.util.TreeMap;

/**
 *  字典树
 *
 *  性能与单词字符数有关O(logw)， 与单词数n 无关
 */
public class Trie {



    private class Node{
        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord){
            this.isWord = isWord;
            next = new TreeMap<>();

        }

        public Node(){
            this(false);
        }

    }

    private Node root;
    private int size;

    public Trie(){
        root = new Node();
        size = 0;
    }


    //获取Trie中存储的单词数量
    public int size(){
        return size;
    }

    //向Trie中添加一个新的单词word
    public void add(String word){
        Node cur = root;
        for (int i = 0; i <word.length() ; i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null)
                cur.next.put(c, new Node());

            cur = cur.next.get(c);

        }

        //注意 处理重复单词
        if (!cur.isWord) {
            cur.isWord = true;
            size ++;
        }
    }


    //查询单词word是否在Trie中
    public boolean contains(String word){
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);

        }

        return cur.isWord;

    }


    // 查询是否有单词以perfix 为前缀
    public boolean isPrefix(String prefix){
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);

        }

        return true;
    }

}
