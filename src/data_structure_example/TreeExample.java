package data_structure_example;

public class TreeExample {
    static class Node {
        int value;
        Node left, right;

        public Node(int item) {
            value = item;
            left = right = null;
        }
    }

    static class BinaryTree {
        Node root;

        BinaryTree() {
            root = null;
        }

        void insert(int value) {
            root = insertRec(root, value);
        }

        Node insertRec(Node root, int value) {
            if (root == null) {
                root = new Node(value);
                return root;
            }

            if (value < root.value) {
                root.left = insertRec(root.left, value);
            } else if (value > root.value) {
                root.right = insertRec(root.right, value);
            }

            return root;
        }

        void printInorder(Node node) {
            if (node == null)
                return;

            printInorder(node.left);
            System.out.print(node.value + " ");
            printInorder(node.right);
        }

        void printInorder() {
            printInorder(root);
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(1);
        binaryTree.insert(2);
        binaryTree.insert(3);
        binaryTree.insert(6);
        binaryTree.insert(4);
        binaryTree.insert(5);
        binaryTree.printInorder(); //1 2 3 4 5 6
    }
}
