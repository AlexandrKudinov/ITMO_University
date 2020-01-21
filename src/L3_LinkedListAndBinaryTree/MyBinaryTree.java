package L3_LinkedListAndBinaryTree;

/*
Задание:
Реализовать бинарное дерево поиска;
*/

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public class MyBinaryTree {
    public static void main(String[] args) {
        BinarioTree bt = new BinarioTree();
        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);
        bt.firstDeepFind();
        System.out.println();
        bt.firstDepthFind();
        System.out.println();
        System.out.println(bt.contain(6));
        bt.remove(6);
        System.out.println();
        bt.firstDeepFind();
        System.out.println();
        bt.firstDepthFind();
        System.out.println(bt.contain(6));





/*
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


 */
    }
}


class BinarioTree {
    private static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
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

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    private static Node root;

    private static Node addNode(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
        if (current.value == value) {
            return current;
        }
        if (value > current.getValue()) {
            current.setRight(addNode(current.getRight(), value));
        } else {
            current.setLeft(addNode(current.getLeft(), value));
        }
        return current;
    }

    public static void add(int value) {
        root = addNode(root, value);
    }

    private static boolean containNode(Node current, int value) {
        if (current == null) {
            return false;
        }
        if (current.getValue() == value) {
            return true;
        }
        return value > current.getValue()
                ? containNode(current.getRight(), value)
                : containNode(current.getLeft(), value);
    }

    public static boolean contain(int value) {
        return containNode(root, value);
    }


    private static int findSmallest(Node current) {
        if (current.getLeft() == null) {
            return current.getValue();
        }
        return findSmallest(current.getLeft());
    }


    private static Node removeNode(Node current, int value) {
        if (current == null) {
            return null;
        }
        if (current.getValue() == value) {
            if (current.getLeft() == null && current.getRight() == null) {
                return null;
            }

            if (current.getRight() == null) {
                return current.getLeft();

            }
            if (current.getLeft() == null) {
                return current.getRight();
            }
            int smallestInRight = findSmallest(current.getRight());
            current.setValue(smallestInRight);
            current.setRight(removeNode(current.getRight(), smallestInRight));
        } else if (value > current.getValue()) {
            current.setRight(removeNode(current.getRight(), value));
        } else {
            current.setLeft(removeNode(current.getLeft(), value));
        }

        return current;
    }

    public static void remove(int value) {
        root = removeNode(root, value);
    }


    private static void firstDeepFindNode(Node current) {
        System.out.print(current.getValue() + "  ");
        if (current.getLeft() != null) {
            firstDeepFindNode(current.getLeft());
        }
        if (current.getRight() != null) {
            firstDeepFindNode(current.getRight());
        }
    }

    public static void firstDeepFind() {
        firstDeepFindNode(root);
    }

    public static void firstDepthFind() {
        if (root == null) {
            return;
        }
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            Node node = nodes.remove();
            System.out.print(node + "  ");
            if (node.getLeft() != null) {
                nodes.add(node.getLeft());
            }
            if (node.getRight() != null) {
                nodes.add(node.getRight());
            }
        }

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


class BT {
    private static class Node {
        private Node left;
        private Node right;
        private int value;

        public Node(int value) {
            this.value = value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }
    }

    private static Node root;


    private static Node addNode(Node current, int value) {
        if (current == null) {
            return current = new Node(value);
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

        if (current.getValue() == value) {
            return true;
        }


        return (value > current.getValue())
                ? containNode(current.getRight(), value)
                : containNode(current.getLeft(), value);
    }

    public static boolean contain(int value) {
        return containNode(root, value);
    }


    private static int findSmallestValue(Node current) {
        if (current.getLeft() == null) {
            return current.getValue();
        }
        return findSmallestValue(current.getLeft());
    }

    private static Node remove(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (current.getValue() == value) {
            if (current.getLeft() == null && current.getRight() == null) {
                return null;
            }

            if (current.getLeft() == null) {
                return current.getRight();
            }

            if (current.getRight() == null) {
                return current.getLeft();
            }

            int smallestInRight = findSmallestValue(current.getRight());
            current.setValue(smallestInRight);
            current.setRight(remove(current.getRight(), smallestInRight));
        } else if (value > current.getValue()) {
            current.setRight(remove(current.getRight(), value));
        } else current.setLeft(remove(current.getLeft(), value));
        return current;
    }


 /*

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








  */


    public static void remove(int value) {
        root = remove(root, value);
    }

    private static void depthFirstFinfNode(Node current) {
        if (current != null) {
            System.out.print(current.getValue() + "    ");
            depthFirstFinfNode(current.getLeft());
            depthFirstFinfNode(current.getRight());
        }
    }

    public static void depthFirstFind() {
        depthFirstFinfNode(root);
    }

    public static void breadthFirstFind() {
        if (root == null) {
            return;
        }
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            Node node = nodes.remove();
            System.out.print(node.getValue() + "   ");
            if (node.getLeft() != null) {
                nodes.add(node.getLeft());
            }
            if (node.getRight() != null) {
                nodes.add(node.getRight());
            }

        }
    }


}


class BTree {
    private static class Node {
        private Node left;
        private Node right;
        private int value;

        public Node(int value) {
            this.value = value;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getLeft() {
            return left;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getRight() {
            return right;
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
            current = new Node(value);
            return current;
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
        if (current.getValue() == value) {
            return true;
        }
        return value > current.getValue()
                ? containNode(current.getRight(), value)
                : containNode(current.getLeft(), value);
    }

    public static boolean contain(int value) {
        return containNode(root, value);
    }

    private static int getSmallestInRight(Node current) {
        if (current.getLeft() != null) {
            return getSmallestInRight(current.getLeft());
        }
        return current.getValue();
    }


    private static Node removeNode(Node current, int value) {
        if (current == null) {
            return null;
        }
        if (current.getValue() == value) {
            if (current.getLeft() == null && current.getRight() == null) {
                return null;
            }
            if (current.getLeft() == null) {
                return current.getRight();
            }
            if (current.getRight() == null) {
                return current.getLeft();
            }

            int smallestInRight = getSmallestInRight(current.getRight());
            current.setRight(removeNode(current.getRight(), smallestInRight));
            current.setValue(smallestInRight);
        } else if (value > current.getValue()) {
            current.setRight(removeNode(current.getRight(), value));
        } else {
            current.setLeft(removeNode(current.getLeft(), value));
        }
        return current;
    }

    public static void remove(int value) {
        root = removeNode(root, value);
    }

    private static void findInDeepNode(Node current) {
        if (current != null) {
            System.out.print(current.getValue() + "   ");
        }
        if (current.getLeft() != null) {
            findInDeepNode(current.getLeft());
        }
        if (current.getRight() != null) {
            findInDeepNode(current.getRight());
        }
    }

    public static void findInDeepNode() {
        findInDeepNode(root);
    }

    public static void findInBreadth() {
        if (root == null) {
            return;
        }
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            Node node = nodes.remove();
            System.out.print(node.getValue() + "   ");

            if (node.getRight() != null) {
                nodes.add(node.getRight());
            }
            if (node.getLeft() != null) {
                nodes.add(node.getLeft());
            }
        }

    }


}


class BinarioTrio {
    private static class Node {
        private Node left;
        private Node right;
        private int value;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getRight() {
            return right;
        }

        public Node getLeft() {
            return left;
        }

        public void setValue(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    private static Node root;

    private static Node addNode(Node current, int value) {
        if (current == null) {
            current = new Node(value);
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
        if (current.getValue() == value) {
            return true;
        }

        return value > current.getValue()
                ? containNode(current.getRight(), value)
                : containNode(current.getLeft(), value);
    }

    public static boolean contain(int value) {
        return containNode(root, value);
    }


    private static int findSmallestValue(Node current) {
        if (current.getLeft() != null) {
            return findSmallestValue(current.getLeft());
        }
        return current.getValue();
    }

    private static Node removeNode(Node current, int value) {
        if (current == null) {
            return null;
        }
        if (current.getValue() == value) {
            if (current.getLeft() == null && current.getRight() == null) {
                return null;
            }
            if (current.getLeft() == null) {
                return current.getRight();
            }
            if (current.getRight() == null) {
                return current.getLeft();
            }
            int smallestInRight = findSmallestValue(current.getRight());
            current.setValue(smallestInRight);
            current.setRight(removeNode(current.getRight(), smallestInRight));
        } else if (value > current.getValue()) {
            current.setRight(removeNode(current.getRight(), value));
        } else current.setLeft(removeNode(current.getLeft(), value));
        return current;
    }

    public static void remove(int value) {
        root = removeNode(root, value);
    }

    private static void findInDeepNode(Node current) {
        if (current != null) {
            System.out.print(current.getValue() + "   ,    ");
            findInDeepNode(current.getLeft());
            findInDeepNode(current.getRight());
        }
    }

    public static void findInDeep() {
        findInDeepNode(root);
    }


    public static void findInBreadth() {
        if (root == null) {
            return;
        }
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            Node node = nodes.remove();
            System.out.print(node.getValue() + "  ,   ");

            if (node.getLeft() != null) {
                nodes.add(node.getLeft());
            }
            if (node.getRight() != null) {
                nodes.add(node.getRight());
            }
        }

    }


}


