package Lesson3;/*
Задание:
Реализовать список(Lesson3.List), в виде отдельного класса, с возможностью вызывать, добавлять и удалять элементы.
*/

public class Lesson3_Task1 {
    public static void main(String[] args) {
        List list1 = new List();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        System.out.println(list1.get(0));
        System.out.println(list1.get(1));
        System.out.println(list1.get(2));
        System.out.println(list1.get(3));
        System.out.println(list1.get(4));
        System.out.println(list1.getSize());
        // System.out.println(list1.get(5));
        list1.remove(0);
        list1.remove(2);
        System.out.println(list1.get(0));
        System.out.println(list1.get(1));
        System.out.println(list1.get(2));
        System.out.println(list1.getSize());
        // System.out.println(list1.get(3));


    }

}

class Node {
    private double value;
    private Node nextNode;

    public Node(double value) {
        this.value = value;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public double getValue() {
        return value;
    }

    public Node getNextNode() {
        return nextNode;
    }
}

class List {
    int size;
    Node first;
    Node last;

    public void add(double value) {
        if (first == null) {
            first = new Node(value);
            last = first;
        } else {
            Node NextLast = new Node(value);
            last.setNextNode(NextLast);
            last = NextLast;
        }
        size++;
    }





    public Node getNode(int index) {
        Node last = first;
        for (int i = 0; i < index; i++) {
            last = last.getNextNode();
        }
        return last;
    }



    public double get(int index) {
        return getNode(index).getValue();
    }

    public void remove(int index) {
        if (index == 0) {
            first = first.getNextNode();
        } else {
            Node node = getNode(index-1);
            node.setNextNode(getNode(index).getNextNode());
        }
        size--;
    }


    public int getSize(){
        return size;
    }



}






