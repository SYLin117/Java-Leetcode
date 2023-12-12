//A trie (pronounced as "try") or prefix tree is a tree data structure used to 
//efficiently store and retrieve keys in a dataset of strings. There are various 
//applications of this data structure, such as autocomplete and spellchecker. 
//
// Implement the Trie class: 
//
// 
// Trie() Initializes the trie object. 
// void insert(String word) Inserts the string word into the trie. 
// boolean search(String word) Returns true if the string word is in the trie (
//i.e., was inserted before), and false otherwise. 
// boolean startsWith(String prefix) Returns true if there is a previously 
//inserted string word that has the prefix prefix, and false otherwise. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
//[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
//Output
//[null, null, true, false, true, null, true]
//
//Explanation
//Trie trie = new Trie();
//trie.insert("apple");
//trie.search("apple");   // return True
//trie.search("app");     // return False
//trie.startsWith("app"); // return True
//trie.insert("app");
//trie.search("app");     // return True
// 
//
// 
// Constraints: 
//
// 
// 1 <= word.length, prefix.length <= 2000 
// word and prefix consist only of lowercase English letters. 
// At most 3 * 10⁴ calls in total will be made to insert, search, and 
//startsWith. 
// 
//
// Related Topics Hash Table String Design Trie 👍 11079 👎 123

package leetcode.editor.en;

import classicaglo.Trie;

class P208ImplementTriePrefixTree {
    public static void main(String[] args) {
        // Solution solution = new P208 Solution();
        Trie trie = new P208ImplementTriePrefixTree().new Trie();
        trie.insert("apple");
//        System.out.println(trie.search("apple"));
//        System.out.println(trie.startsWith("apple"));
        System.out.println(trie.startsWith("app"));
    }

    class Trie {

        class TrieNode {
            TrieNode[] children = new TrieNode[26];
            boolean isWord = false;
            String word = "";

            public TrieNode() {

            }

            public TrieNode(TrieNode[] children, boolean isWord, String word) {
                this.children = children;
                this.isWord = isWord;
                this.word = word;
            }
        }

        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                if (node.children[word.charAt(i) - 'a'] == null) {
                    node.children[word.charAt(i) - 'a'] = new TrieNode();
                }
                node = node.children[word.charAt(i) - 'a'];
            }
            node.isWord = true;
            node.word = word;
        }

        public boolean search(String word) {
            boolean result = false;
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                if (node.children[word.charAt(i) - 'a'] == null) break;
                node = node.children[word.charAt(i) - 'a'];
            }
            if (node.word.equals(word)) result = true;
            return result;
        }

        public boolean startsWith(String prefix) {
            boolean result = false;
            TrieNode node = root;
            for (int i = 0; i < prefix.length(); i++) {
                if (node.children[prefix.charAt(i) - 'a'] == null) break;
                node = node.children[prefix.charAt(i) - 'a'];
                if (i == prefix.length() - 1) result = true;
            }
            return result;
        }
    }
}