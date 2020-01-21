package L3_LinkedListAndBinaryTree;

import java.io.IOException;
import java.util.HashSet;
import java.util.TreeSet;



public class BiTree {



   static Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("jkhf");
        }
    });
  static   Thread thread1 = new Thread(thread);

    public static void main(String[] args) throws Error{

    }
}

class BITREE11 {


    protected class NODE {

        private class HHH{}

        private NODE left;
        private NODE right;
        private int value;

        public NODE(int value) {
            this.value = value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public void setRight(NODE right) {
            this.right = right;
        }

        public NODE getLeft() {
            return left;
        }

        public NODE getRight() {
            return right;
        }

        public int getValue() {
            return value;
        }
    }

    private static NODE root;

}
