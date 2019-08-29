package adt;

public class TrieTest {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 =new String("abc");
        System.out.println(s1 == s2);


        String[] source = { "dog", "tiger","category"};
        System.out.println(source);
        Trie trie = new Trie();

        for (String s: source){
            trie.add(s);
        }


        System.out.println("contains:" + trie.contains("cat"));
        System.out.println("prefix:" + trie.isPrefix("cat"));
    }

}
