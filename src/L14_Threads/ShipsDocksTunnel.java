package L14_Threads;

import java.awt.*;
import java.util.*;
import java.util.List;

public class ShipsDocksTunnel {
    public static void main(String[] args) {
        Tunnel tunnel = Tunnel.getInstance();
        Thread generator = new Thread(new ShipGenerate());
        Thread apple = new Thread(new Dock(Type.APPLE));
        Thread orange = new Thread(new Dock(Type.ORANGE));
        Thread banana = new Thread(new Dock(Type.BANANA));

        generator.start();
        apple.start();
        orange.start();
        banana.start();
    }


}


class Dock implements Runnable {
    private Type type;
    Tunnel tunnel = Tunnel.getInstance();

    public Dock(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    @Override
    public void run() {
        while (true) {
            Ship ship = tunnel.get(type);
            while (ship.getCount() != ship.getSize().value) {
                System.out.println("Tunnel " + type + " work " + ship + " 25 added, current count: " + ship.getCount());
                ship.setCount(ship.getCount() + 25);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Tunnel " + type + " work " + ship + " is filled " + ship.getCount());
        }
    }
}


class ShipGenerate implements Runnable {
    Tunnel tunnel = Tunnel.getInstance();

    @Override
    public void run() {
        while (true) {
            try {
                tunnel.add(new Ship(randomType(), randomSize()));
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Size randomSize() {
        Random random = new Random();
        return Size.values()[random.nextInt(Type.values().length)];
    }

    private Type randomType() {
        Random random = new Random();
        return Type.values()[random.nextInt(Type.values().length)];
    }
}


class Tunnel {
    private static volatile Tunnel INSTANCE;

    private Tunnel() {
    }

    public static Tunnel getInstance() {
        Tunnel tunnel = INSTANCE;
        if (tunnel == null) {
            synchronized (Tunnel.class) {
                tunnel = INSTANCE;
                if (tunnel == null) {
                    tunnel = INSTANCE = new Tunnel();
                }
            }
        }
        return tunnel;
    }


    private List<Ship> ships = new LinkedList<>();
    private int MAX_SIZE = 5;


    public List<Ship> getShips() {
        return ships;
    }

    public synchronized void add(Ship ship) throws InterruptedException {
        if (ships.size() == 5) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ships.add(ship);
        System.out.println("Ship: " + ship + " added, tunnel size: " + ships.size());
        Thread.sleep(1000);
        notifyAll();
    }


    public synchronized Ship get(Type type) {
        if (ships.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < ships.size(); i++) {
            if (ships.get(i).getType() == type) {
                Ship ship = ships.remove(i);
                System.out.println("Ship: " + ship + " taken, tunnel,size: " + ships.size());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                notifyAll();
                return ship;
            }
        }
        try {

            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return get(type);
    }


}


class Ship {
    private Type type;
    private Size size;
    private int count;

    public Ship(Type type, Size size) {
        this.type = type;
        this.size = size;
    }

    public Size getSize() {
        return size;
    }

    public Type getType() {
        return type;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return type + " , " + size;
    }
}


enum Type {
    APPLE, ORANGE, BANANA;
}

enum Size {
    SMALL(50), MEDIUM(50), LARGE(50);
    int value;

    Size(int value) {
        this.value = value;
    }
}
