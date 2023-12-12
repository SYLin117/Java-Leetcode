package classicaglo.bst;

class Node {
    int key;
    Node left;
    Node right;

    Node parent;
    int height;

    Node(int key) {
        this.key = key;
        this.height = 1;
    }
}