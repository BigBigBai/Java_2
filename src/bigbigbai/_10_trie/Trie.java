package bigbigbai._10_trie;

/**
 * Given n strings
 * 1. if exists the word with prefix "xxx"
 * 2. the occurrence of the word with prefix "xxx"
 * 3. the occurrence of the word end with "xxx"
 */
public class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public static class TrieNode {
        int path; // how many path reached this node
        int end;  // how many strings end with this node
        TrieNode[] nexts; // walkable path

        public TrieNode() {
            path = 0;
            end = 0;
            nexts = new TrieNode[26];// only support small letter
        }
    }

    public void add(String word) {
        if (word == null || word.isEmpty()) return;

        char[] chs = word.toCharArray();
        TrieNode node = root;
        int index = 0;
        for (int i = 0; i < chs.length; i++) {
            index = chs[i] - 'a';
            if (node.nexts[index] == null) {
                node.nexts[index] = new TrieNode();
            }

            node = node.nexts[index];
            node.path++;
        }
        node.end++;
    }

    public void delete(String word) {
        if (search(word) != 0) {
            char[] chs = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a'; 
                if (--node.nexts[index].path == 0) {// when meet 0, not need to traverse down, the rest string will be auto collect by JC
                    node.nexts[index] = null;
                    return;
                }

                node = node.nexts[index];
            }

            node.end--;
        }
    }

    // query the occurrence of a word
    public int search(String word) {
        if (word == null || word.isEmpty()) return 0;

        char[] chs = word.toCharArray();
        TrieNode node = root;
        int index = 0;
        for (int i = 0; i < chs.length; i++) {
            index = chs[i] - 'a';
            if (node.nexts[index] == null) {
                return 0;
            }
            node = node.nexts[index];
        }

        return node.end;
    }

    // query the occurrence of a prefix
    public int prefix(String word) {
        if (word == null || word.isEmpty()) return 0;

        char[] chs = word.toCharArray();
        TrieNode node = root;
        int index = 0;
        for (int i = 0; i < chs.length; i++) {
            index = chs[i] - 'a';
            if (node.nexts[index] == null) {
                return 0;
            }
            node = node.nexts[index];
        }

        return node.path;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.add("abc");
        trie.add("bce");
        trie.add("bef");
        trie.add("abd");
        trie.add("abcd");
        System.out.println(trie.prefix("abc"));
        System.out.println(trie.search("ab"));

        trie.delete("abc");
        System.out.println(trie.search("abc"));
    }
}
