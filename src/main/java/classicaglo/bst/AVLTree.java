package classicaglo.bst;


//    基本上，AVL樹的加入先以BST(二元搜尋樹)的方式加入，
//    加入之後，重新計算BF(平衡因子)，當大於2時，則需要進行旋轉，
//    共有四種旋轉方式：LL、RR、LR、RL。
//    注意旋轉前與旋轉後的樹，需要保持它們的 in-order traversal 不變
//    在介紹各種型態的旋轉方式之前，我們先來討論如何計算BF。
class AVLTree {

    Node root;

    private int height(Node node) {

        if (node == null)
            return 0;
        return node.height;
    }

    // return max
    private int max(int a, int b) {
        return Math.max(a, b);
    }

    // get node BF (left tree height - right tree height)
    private int getBalanceFactor(Node node) {
        if (node == null)
            return 0;
        // calculate BF (it can only be left.height - right.height)
        return height(node.left) - height(node.right);
    }


    //    y
    //   / \
    //  x   α
    // / \
    //γ   β
    private Node rotateRight(Node y) {
        Node x = y.left; // y is bigger, x is y's left child
        Node beta = x.right;

        y.left = beta;
        x.right = y;


        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        return x;
    }

    //       x
    //      / \
    //     α   y
    //        / \
    //       β   γ
    private Node rotateLeft(Node x) {
        Node y = x.right;
        Node beta = y.left;

        y.left = x;
        x.right = beta;

        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        return y;
    }

    private Node insert(Node node, int data) {
        if (node == null)
            return new Node(data);

        // IMPORTANT AVL  tree 也是 binary search tree
        if (data < node.key)
            node.left = insert(node.left, data);
        else if (data > node.key)
            node.right = insert(node.right, data);
        else
            return node; // Duplicate data not allowed

        node.height = 1 + max(height(node.left), height(node.right));

        int balance = getBalanceFactor(node);

        if (balance > 1) { // left tree taller
            //節點的balance factor大於 1
            //左子樹的高度比較高
            //進行右旋轉或左右旋轉
            //如果要插入的元素小於左小孩，進行右旋轉
            //否則進行左右旋轉(先將子傑點左旋轉，在右旋轉該節點)
            if (data < node.left.key) {
                return rotateRight(node);
            } else {
                node.left = rotateLeft(node.left);
                return rotateRight(node);
            }
        }

        if (balance < -1) { // right tree taller
            if (data > node.right.key) {
                return rotateLeft(node);
            } else {
                node.right = rotateRight(node.right);
                return rotateLeft(node);
            }
        }

        return node;
    }

    public void insert(int data) {
        root = insert(root, data);
    }

    void preOrderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(25);

        System.out.println("Preorder Traversal of AVL tree:");
        tree.preOrderTraversal(tree.root);
    }
}
