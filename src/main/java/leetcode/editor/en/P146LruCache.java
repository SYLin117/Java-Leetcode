//Design a data structure that follows the constraints of a Least Recently Used 
//(LRU) cache. 
//
// Implement the LRUCache class: 
//
// 
// LRUCache(int capacity) Initialize the LRU cache with positive size capacity. 
//
// int get(int key) Return the value of the key if the key exists, otherwise 
//return -1. 
// void put(int key, int value) Update the value of the key if the key exists. 
//Otherwise, add the key-value pair to the cache. If the number of keys exceeds 
//the capacity from this operation, evict the least recently used key. 
// 
//
// The functions get and put must each run in O(1) average time complexity. 
//
// 
// Example 1: 
//
// 
//Input
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//Output
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//Explanation
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // cache is {1=1}
//lRUCache.put(2, 2); // cache is {1=1, 2=2}
//lRUCache.get(1);    // return 1
//lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
//lRUCache.get(2);    // returns -1 (not found)
//lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
//lRUCache.get(1);    // return -1 (not found)
//lRUCache.get(3);    // return 3
//lRUCache.get(4);    // return 4
// 
//
// 
// Constraints: 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 10⁴ 
// 0 <= value <= 10⁵ 
// At most 2 * 10⁵ calls will be made to get and put. 
// 
//
// Related Topics Hash Table Linked List Design Doubly-Linked List 👍 19538 👎 8
//86

package leetcode.editor.en;

import java.util.*;

class P146LruCache {
    public static void main(String[] args) {
        LRUCache lruCache = new P146LruCache().new LRUCache(10);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {
        // store keys of cache
        private Deque<Integer> linkedList;

        // store references of key in cache
        private HashMap<Integer, Integer> hashMap;

        // maximum capacity of cache
        private final int CACHE_SIZE;

        LRUCache(int capacity) {
            linkedList = new LinkedList<>();
            hashMap = new HashMap<>();
            CACHE_SIZE = capacity;
        }

        private void moveToRecent(int key) {
            // oldest element is the last (cuz we put new element in front)
            linkedList.remove(key);
            linkedList.addFirst(key);
        }

        public int get(int key) {
            if (hashMap.containsKey(key)) {
                moveToRecent(key);
                return hashMap.get(key);
            }
            return -1;
        }

        public void put(int key, int value) {
            if (hashMap.containsKey(key)) {
                hashMap.put(key, value);
                moveToRecent(key);
            } else {
                hashMap.put(key, value);
                linkedList.addFirst(key);
                if (linkedList.size() > CACHE_SIZE) {
                    int last = linkedList.removeLast();
                    hashMap.remove(last);
                }
            }
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}