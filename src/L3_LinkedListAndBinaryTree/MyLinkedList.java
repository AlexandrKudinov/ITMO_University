package L3_LinkedListAndBinaryTree;

/*
Задание:
Реализовать список, в виде отдельного класса, с возможностью вызывать, добавлять и удалять элементы.
*/

import java.util.NoSuchElementException;

public class MyLinkedList {
    public static void main(String[] args) {

        MyList list = new MyList();
        list.add(3.5);
        list.add(4.6);
        list.add(5.7);
        list.add(8.6);
        list.add(2.1);
        System.out.println(list.toString());
        System.out.println(list.getSize());
        System.out.println(list.get(3));
        list.remove(0);
        System.out.println(list.toString());
        System.out.println(list.getSize());
        list.remove(3);
        System.out.println(list.toString());
        System.out.println(list.getSize());


        List list1 = new List();
        list1.add(23);
        list1.add(22);
        list1.add(223);
        list1.add(123123);
        list1.add(1234);
        System.out.println(list1);
        System.out.println(list1.getSize());
        list1.remove(0);
        System.out.println(list1);
        System.out.println(list1.get(0));
        System.out.println(list1.getSize());
        list1.remove(list1.getSize()-1);
        System.out.println(list1);
        System.out.println(list1.getSize());
    }
}


class MyList {

    private static class Node {
        private double value;
        private Node nextNode;

        public Node(double value) {
            this.value = value;
        }

        public double getValue() {
            return value;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }
    }

    private static Node first;
    private static Node last;
    private static int size;

    public static void add(double value) {
        if (first == null) {
            first = new Node(value);
            last = first;
        } else {
            Node newLast = new Node(value);
            last.setNextNode(newLast);
            last = newLast;
        }
        size++;
    }

    private static Node getNode(int index) {
        if (index > size || index < 0) {
            throw new NoSuchElementException();
        } else {
            Node node = first;
            for (int i = 0; i < index; i++) {
                node = node.getNextNode();
            }
            return node;
        }
    }


    public static double get(int index) {
        return getNode(index).getValue();
    }


    public static void remove(int index) {
        if (index == 0) {
            first = first.getNextNode();
        } else {
            Node node = getNode(index - 1);
            node.setNextNode(getNode(index).getNextNode());
        }
        size--;
    }

    public static int getSize() {
        return size;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node node = first;
        while (node != null) {
            stringBuilder.append(node.getValue() + " , ");
            node = node.getNextNode();
        }
        return stringBuilder.delete(stringBuilder.length() - 3, stringBuilder.length() - 1).toString();
    }

}


class List {

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node node = first;
        while (node != null) {
            stringBuilder.append(node);
            stringBuilder.append(" ");
            node = node.getNextNode();
        }
        return stringBuilder.toString();
    }

    private class Node {
        private Node nextNode;
        private int value;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    private Node current;
    private Node first;
    private int size;

    public void add(int value) {
        if (first == null) {
            first = new Node(value);
            current = first;
        } else {
            Node node = new Node(value);
            current.setNextNode(node);
            current = current.getNextNode();
        }
        size++;
    }

    private Node getNode(int index) {
        int i = 0;
        Node node = first;
        while (i++ < index) {
            node = node.getNextNode();
        }
        return node;
    }

    public int get(int index) {
        return getNode(index).value;
    }

    public int getSize() {
        return size;
    }


    public void remove(int index) {
        if (index < 0 || index > size) {
            throw new NullPointerException();
        }
        if(index==0){
            first = first.getNextNode();
        }
        Node node = getNode(index - 1);
        Node node1 = getNode(index+1);
        node.setNextNode(node1);
        size--;
    }


}





