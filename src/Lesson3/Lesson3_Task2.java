package Lesson3;

public class Lesson3_Task2 {
    public static void main(String[] args) {


    }
}

class Top {
    int value;
    Top left;
    Top right;

    public Top(int value) {
        this.value = value;
    }

}

class BinTree {
    private Top root;

    private Top addTop(Top current, int value) {
        if (current == null) {
            return new Top(value);
        }
        if (current.value > value) {
            current.left = addTop(current.left, value);
        } else if (current.value < value) {
            current.right = addTop(current.right, value);
        }
        return current;
    }

    public void add(int value) {
        root = addTop(root, value);
    }

    private boolean containTop(Top current, int value) {
        if (current == null) {
            return false;
        }
        if (current.value > value) {
            return containTop(current.left, value);
        } else if (current.value < value) {
            return containTop(current.right, value);
        } else return true;
    }

    public boolean contain(int value) {
        return containTop(root, value);
    }

    private Top deleteRecursive(Top current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.value) {

            if (current.left == null && current.right == null) {
                return null;
            }
            if (current.right == null) {
                return current.left;
            }
            if (current.left == null) {
                return current.right;
            }
            int smallestValue = findSmallestValue(current.right);
            current.value = smallestValue;
            current.right = deleteRecursive(current.right, smallestValue);
            return current;

        }
        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }else {
        current.right = deleteRecursive(current.right, value);
        return current;
    }
    }

    private int findSmallestValue(Top root) {
        if (root.left == null) {
            return root.value;
        } else {
            return findSmallestValue(root.left);
        }

    }


}





