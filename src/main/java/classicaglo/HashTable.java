package classicaglo;

import java.util.LinkedList;

class HashTable {
    private static final int DEFAULT_CAPACITY = 16;
    private int[] keys;
    private String[] values;
    private int size;

    public HashTable() {
        this(DEFAULT_CAPACITY);
    }

    public HashTable(int capacity) {
        keys = new int[capacity];
        values = new String[capacity];
        size = 0;
    }

    public void put(int key, String value) {
        if (size >= keys.length) {
            // Handle resizing if necessary
            resize();
        }

        int index = hash(key);
        while (keys[index] != 0) {
            if (keys[index] == key) {
                values[index] = value;
                return;
            }
            index = (index + 1) % keys.length; // Linear probing
        }

        keys[index] = key;
        values[index] = value;
        size++;
    }

    public String get(int key) {
        int index = hash(key);
        while (keys[index] != 0) {
            if (keys[index] == key) {
                return values[index];
            }
            index = (index + 1) % keys.length; // Linear probing
        }
        return null;
    }

    public void remove(int key) {
        int index = hash(key);
        while (keys[index] != 0) {
            if (keys[index] == key) {
                keys[index] = 0;
                values[index] = null;
                size--;
                return;
            }
            index = (index + 1) % keys.length; // Linear probing
        }
    }

    private int hash(int key) {
        return key % keys.length;
    }

    private void resize() {
        int newCapacity = keys.length * 2;
        int[] newKeys = new int[newCapacity];
        String[] newValues = new String[newCapacity];

        for (int i = 0; i < keys.length; i++) {
            if (keys[i] != 0) {
                int index = hash(keys[i]);
                while (newKeys[index] != 0) {
                    index = (index + 1) % newKeys.length;
                }
                newKeys[index] = keys[i];
                newValues[index] = values[i];
            }
        }

        keys = newKeys;
        values = newValues;
    }
}
