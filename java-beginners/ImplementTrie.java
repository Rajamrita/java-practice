public class ImplementTrie {

    // Trie Node
    static class TrieNode {

        TrieNode[] children = new TrieNode[26];

        boolean isEndOfWord = false;
    }

    // Root of Trie
    private TrieNode root;

    // Constructor
    public ImplementTrie() {
        root = new TrieNode();
    }

    // Insert a word
    public void insert(String word) {

        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {

            int index = word.charAt(i) - 'a';

            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            current = current.children[index];
        }

        current.isEndOfWord = true;
    }

    // Search complete word
    public boolean search(String word) {

        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {

            int index = word.charAt(i) - 'a';

            if (current.children[index] == null) {
                return false;
            }

            current = current.children[index];
        }

        return current.isEndOfWord;
    }

    // Check prefix
    public boolean startsWith(String prefix) {

        TrieNode current = root;

        for (int i = 0; i < prefix.length(); i++) {

            int index = prefix.charAt(i) - 'a';

            if (current.children[index] == null) {
                return false;
            }

            current = current.children[index];
        }

        return true;
    }

    // Main method for VS Code
    public static void main(String[] args) {

        ImplementTrie trie = new ImplementTrie();

        trie.insert("apple");

        System.out.println("Search apple: " + trie.search("apple"));

        System.out.println("Search app: " + trie.search("app"));

        System.out.println("Starts with app: " + trie.startsWith("app"));

        trie.insert("app");

        System.out.println("Search app after insert: " + trie.search("app"));
    }
}