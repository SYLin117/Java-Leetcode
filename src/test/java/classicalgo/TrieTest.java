package classicalgo;

import classicaglo.Trie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class TrieTest {
    static Trie trie;

    @BeforeAll
    static void setup() {
        trie = new Trie();
        trie.insert("apple");
    }


    @Test
    void searchTest() {
        assert (trie.search("apple"));
    }
}
