package classicaglo.bst;

import java.util.ArrayList;
import java.util.List;

class BTreePrinter {

    public static <T extends Comparable<?>> void printNode(Node root) {
        int maxLevel = BTreePrinter.maxLevel(root);

        printNodeInternal(List.of(root), 1, maxLevel);
    }

    private static <T extends Comparable<?>> void printNodeInternal(List<Node> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BTreePrinter.printWhitespaces(firstSpaces);

        List<Node> newNodes = new ArrayList<Node>();
        for (Node node : nodes) {
            if (node != null) {
                System.out.print(node.key);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            BTreePrinter.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                BTreePrinter.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(Node node) {
        if (node == null)
            return 0;

        return Math.max(BTreePrinter.maxLevel(node.left), BTreePrinter.maxLevel(node.right)) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

}

public class BinarySearchTree {
    Node root;

    BinarySearchTree() {
        root = null;
    }

    // Insert a new key into the BST
    public void insert(int key) {
        root = insertRec(root, key);
    }

    // A recursive function to insert a new key into the BST
    private Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key) {
            root.left = insertRec(root.left, key);
            root.left.parent = root;
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
            root.right.parent = root;
        }

        return root;
    }

    // Inorder traversal of the BST (prints the keys in sorted order)
    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    // Search for a key in the BST
    public boolean search(int key) {
        return searchRec(root, key);
    }

    // A recursive function to search for a key in the BST
    private boolean searchRec(Node root, int key) {
        if (root == null) {
            return false;
        }

        if (root.key == key) {
            return true;
        }

        if (key < root.key) {
            return searchRec(root.left, key);
        } else {
            return searchRec(root.right, key);
        }
    }

    public Node getNode(int key) {
        return getNodeRec(root, key);
    }

    private Node getNodeRec(Node node, int key) {
        if (node == null) {
            return null;
        }

        if (node.key == key) {
            return node;
        }

        if (key < node.key) {
            return getNodeRec(node.left, key);
        } else {
            return getNodeRec(node.right, key);
        }
    }

    // Delete a node with a given key
    void delete(int key) {
        root = deleteRec(root, key);
    }

    private Node deleteRec(Node root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.key) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.key) {
            root.right = deleteRec(root.right, key);
        } else {
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node with two children: get the in-order successor (smallest in the right subtree)
            root.key = minValue(root.right);

            // Delete the in-order successor
            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    private int minValue(Node root) {
        // find min value in current tree
        int minValue = root.key;
        while (root.left != null) {
            minValue = root.left.key;
            root = root.left;
        }
        return minValue;
    }

    private int maxValue(Node root) {
        int maxValue = root.key;
        while (root.right != null) {
            maxValue = root.right.key;
            root = root.right;
        }
        return maxValue;
    }

    /**
     * find node predecessor(inorder中node的前一個節點(bst的inorder會按照小到大排序))
     *
     * @param node
     * @return
     */
    public int findPredecessor(Node node) {
        if (node == null) return -1;
        // node有左子樹,找左子樹中最大點
        if (node.left != null) return maxValue(node.left);
            // 沒有左子樹,但有左父節點
        else if (node.parent != null && node.parent.right == node) return node.parent.key;
        else {
            Node p = node.parent;
            Node curr = node;
            // 找到第一個節點且該節點的右子樹包含node
            while (p != null && p.left == curr) {
                curr = p;
                p = p.parent;
            }
            return (p != null) ? p.key : -1;
        }
    }

    public int findAccessor(Node node) {
        if (node == null) return -1;
        if (node.right != null) return minValue(node.right);
        else if (node.parent != null && node.parent.left == node) return node.parent.key;
        else {
            Node p = node.parent;
            Node curr = node;
            // find first node that left tree contain the node
            while (p != null && p.right == curr) {
                curr = p;
                p = p.parent;
            }
            return (p != null) ? p.key : -1;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(40);

        bst.insert(4);
        bst.insert(34);
        bst.insert(14);
        bst.insert(13);
        bst.insert(15);

        bst.insert(45);
        bst.insert(55);
        bst.insert(48);
        bst.insert(47);
        bst.insert(49);

//        BTreePrinter.printNode(bst.root);

//        System.out.println("Inorder traversal of the BST:");
//        bst.inorder();
//        bst.delete(40);
//
//        int keyToSearch = 40;
//        if (bst.search(keyToSearch)) {
//            System.out.println("\n" + keyToSearch + " is present in the BST.");
//        } else {
//            System.out.println("\n" + keyToSearch + " is not present in the BST.");
//        }

        Node node15 = bst.getNode(15);
        System.out.println(bst.findAccessor(node15));
    }
}
