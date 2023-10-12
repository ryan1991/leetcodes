package adt;

public class TrieTest {
    public static void main(String[] args) {
        String[] source = { "dog", "tiger","category"};
        Trie trie = new Trie();
        for (String s: source){
            trie.add(s);
        }

        System.out.println("contains:" + trie.contains("cat"));
        System.out.println("prefix:" + trie.isPrefix("cat"));
    }

}
