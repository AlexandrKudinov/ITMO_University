package L14_Threads;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


class Shape {
    public Shape() {
        System.out.println("aaaa");
    }

    public void doiii() {
        System.out.println("skdhf");
    }

    void doing(int a) {

    }
}

class Cylinder extends Shape {
    public Cylinder() {
        System.out.println("bbbbb");
    }

}

class Runnabl implements Runnable {
    public void run() {

        Thread thread = new Thread(new Runnabl());
        Thread thread1 = new Thread(new Runnabl());
        thread.start();
        System.out.println("first tread");
        thread1.start();
        System.out.println("second tread");
    }

}

class SmallCylinder extends Cylinder {
    public SmallCylinder() {
        System.out.println("cccccc");
    }

}


interface DO {
    void method();
}

interface DDKK {
    void eee();
}

interface eee extends DO, DDKK {
}


public class ShAnDo {

    public static void main(String[] args) {

        Thread generator = new Thread(new Generator());
        Thread cooffeeDock = new Thread(new Dock1(Type1.COFFEE));
        Thread bananaDock = new Thread(new Dock1(Type1.BANANA));
        Thread fishDock = new Thread(new Dock1(Type1.FISH));
        generator.start();
        cooffeeDock.start();
        bananaDock.start();
        fishDock.start();


    }
}

class Dock1 implements Runnable {
    Type1 type1;

    public Dock1(Type1 type1) {
        this.type1 = type1;
    }

    private Tunnel1 tunnel1 = Tunnel1.getInstance();

    @Override
    public void run() {
        while (true) {
            Ship1 ship1 = tunnel1.get(type1);
            System.out.println("Dock " + type1 + " took ship " + ship1);
            while (ship1.getCount() <= ship1.getSize1().getSize()) {
                ship1.add();
                System.out.println("Dock " + type1 + " added 25 to ship " + ship1);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


class Generator implements Runnable {
    private Tunnel1 tunnel1 = Tunnel1.getInstance();

    @Override
    public void run() {
        while (true) {
            Ship1 ship1 = new Ship1(randomType1(), randomSize1());
            tunnel1.add(ship1);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Type1 randomType1() {
        Random random = new Random();
        return Type1.values()[random.nextInt(Type1.values().length)];
    }

    private Size1 randomSize1() {
        Random random = new Random();
        return Size1.values()[random.nextInt(Size1.values().length)];
    }

}


class Tunnel1 {
    private static volatile Tunnel1 instance;

    private Tunnel1() {
    }

    public static Tunnel1 getInstance() {
        Tunnel1 tunnel1 = instance;
        if (tunnel1 == null) {
            synchronized (Tunnel1.class) {
                tunnel1 = instance;
                if (tunnel1 == null) {
                    tunnel1 = instance = new Tunnel1();
                }

            }
        }
        return tunnel1;
    }

    private List<Ship1> ship1s = new LinkedList<>();
    private int MAX = 5;

    public int getMAX() {
        return MAX;
    }

    public List<Ship1> getShip1s() {
        return ship1s;
    }

    public synchronized void add(Ship1 ship1) {
        if (ship1s.size() == MAX) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        ship1s.add(ship1);
        System.out.println("Ship " + ship1 + " added, size = " + ship1s.size());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notifyAll();
    }


    public synchronized Ship1 get(Type1 type1) {
        if (ship1s.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (Ship1 ship1 : ship1s) {
            if (ship1.getType1() == type1) {
                System.out.println("Ship " + ship1 + " taken, size " + ship1s.size());
                ship1s.remove(ship1);
                notifyAll();
                return ship1;
            }
        }
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return get(type1);
    }

}


class Ship1 {
    private Type1 type1;
    private Size1 size1;
    private int count;

    public Ship1(Type1 type1, Size1 size1) {
        this.type1 = type1;
        this.size1 = size1;
    }

    public void add() {
        count += 25;
    }

    public int getCount() {
        return count;
    }

    public Size1 getSize1() {
        return size1;
    }

    public Type1 getType1() {
        return type1;
    }

    @Override
    public String toString() {
        return type1 + " - " + size1;
    }
}


enum Size1 {
    SMALL(50), MEDIUM(100), LARGE(150);
    private int size;

    Size1(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}

enum Type1 {
    BANANA, COFFEE, FISH
}
