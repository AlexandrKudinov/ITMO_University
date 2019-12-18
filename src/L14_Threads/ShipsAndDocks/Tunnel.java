package L14_Threads.ShipsAndDocks;

import java.util.LinkedList;
import java.util.Queue;

public class Tunnel {
    Queue<Ship> ships = new LinkedList<>();
    int MaxShipsInQueue = 5;

    public synchronized boolean add(Ship ship) {
        try {
            if (ships.size() < MaxShipsInQueue) {
                notifyAll();
                ships.add(ship);
                String info = String.format("%s + New ship in the tunnel: %s %s %s",
                        ships.size(),
                        ship.getType(),
                        ship.getSize(),
                        Thread.currentThread().getName());
                System.out.println(info);
            } else {
                System.out.println(ships.size() + "> There is no place for a ship in the tunnel: " + Thread.currentThread().getName());
                wait();
                return false;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }


    public synchronized Ship get(Type shipType) {
        try {
            if (ships.size() != 0) {
                for (Ship ship : ships) {
                    if (ship.getType() == shipType) {
                        ships.remove(ship);
                        System.out.println(ships.size() + "- The ship is taken from the tunnel: " + Thread.currentThread().getName());
                        return ship;
                    }
                }
            }

            System.out.println("0 < There are no ships in the tunnel");
            wait();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }


}
