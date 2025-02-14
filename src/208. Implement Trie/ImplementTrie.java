import java.util.HashMap;
import java.util.Map;

class Trie {


    /*
     * First try, brute force, why not? brrrr
     * (after some optimizations)
     * Runtime: 35ms Beats 66.53% 
     * Memory: 55.17MB Beats 90.86%
     */
    Map<Character, Trie> next = new HashMap<>();
    boolean end; // this means a word ends here
    int deep = 0; // how deep we are

    public Trie() {
        this.end = false;
    }

    public Trie(int deep) {
        this.deep = deep;
    }

    public void insert(String word) {
        if (deep == word.length()) {
            end = true;
            return;
        }

        char first = word.charAt(this.deep);

        Trie node = next.get(first);
        if (node == null) {
            node = new Trie(deep + 1);
            next.put(first, node);
        }
        
        node.insert(word);

    }

    public boolean search(String word) {
        if (deep == word.length()) return end;

        boolean check = true;
        char first = word.charAt(this.deep);
        Trie node = next.get(first);

        return node != null && node.search(word);

    }

    public boolean startsWith(String prefix) {
        if (deep == prefix.length()) return true;

        char first = prefix.charAt(this.deep);
        Trie node = next.get(first);

        return node != null && node.startsWith(prefix);
    }

}

