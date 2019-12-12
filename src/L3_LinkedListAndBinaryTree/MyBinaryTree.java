package L3_LinkedListAndBinaryTree;

/*
Задание:
Реализовать бинарное дерево поиска;
*/

import java.util.LinkedList;
import java.util.Queue;

public class MyBinaryTree {
    public static void main(String[] args) {

        MyBinTree binTree = new MyBinTree();
        binTree.add(6);
        binTree.add(4);
        binTree.add(8);
        binTree.add(3);
        binTree.add(5);
        binTree.add(7);
        binTree.add(9);
        binTree.remove(8);
        System.out.println(binTree.contain(8));
        binTree.breadthFirstFind();

        //  binTree.remove(1);
        //  binTree.depthPrint();
        // binTree.breadthThirstSearch();

    }
}

class MyBinTree {

    private static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getRight() {
            return right;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getLeft() {
            return left;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    private static Node root;

    private static Node addNode(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
        if (value > current.getValue()) {
            current.setRight(addNode(current.getRight(), value));
        } else if (value < current.getValue()) {
            current.setLeft(addNode(current.getLeft(), value));
        } else return current;

        return current;
    }

    public static void add(int value) {
        root = addNode(root, value);
    }


    private static boolean containNode(Node current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.getValue()) {
            return true;
        }

        return value > current.getValue()
                ? containNode(current.getRight(), value)
                : containNode(current.getLeft(), value);
    }

    public static boolean contain(int value) {
        return containNode(root, value);
    }


    private static int findSmallestValue(Node node) {
        if (node.getLeft() == null) {
            return node.getValue();
        }
        return findSmallestValue(node.getLeft());
    }

    private static Node removeNode(Node current, int value) {
        if (current == null) {
            return null;
        }
        if (value == current.getValue()) {

            if (current.getLeft() == null && current.getRight() == null) {
                return null;
            }
            if (current.getLeft() == null) {
                return current.getRight();
            }
            if (current.getRight() == null) {
                return current.getLeft();
            }
            int smallestValueInRightTree = findSmallestValue(current.getRight());
            current.setValue(smallestValueInRightTree);
            current.setRight(removeNode(current.getRight(), smallestValueInRightTree));
        } else if (value > current.getValue()) {
            current.setRight(removeNode(current.getRight(), value));
        } else current.setLeft(removeNode(current.getLeft(), value));
        return current;
    }

    public static void remove(int value) {
        root = removeNode(root, value);
    }

    private static void depthFistFindNode(Node node) {
        if (node != null) {
            System.out.print(node.getValue() + "  ");
            depthFistFindNode(node.getRight());
            depthFistFindNode(node.getLeft());
        }
    }

    public static void depthFirstFind() {
        depthFistFindNode(root);
    }

    public static void breadthFirstFind() {
        if (root == null) {
            return;
        }
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            Node node = nodes.remove();
            System.out.print(node.getValue() + "  ");

            if (node.getLeft() != null) {
                nodes.add(node.getLeft());
            }
            if (node.getRight() != null) {
                nodes.add(node.getRight());
            }
        }
    }

}


