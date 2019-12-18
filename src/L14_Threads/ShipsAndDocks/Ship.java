package L14_Threads.ShipsAndDocks;


class Ship {
    private MaxSize maxSize;
    private Type type;
    private int currentSize;

    public Ship(MaxSize size, Type type) {
        this.maxSize = size;
        this.type = type;
    }


    public void add(int value) {
        currentSize += value;
    }

    public boolean countCheck() {
        if (currentSize >= maxSize.getSize()) {
            return false;
        }
        return true;
    }
    public boolean currentSizeCheck() {
        return currentSize > maxSize.getSize() ? true : false;
    }


    public int getCurrentSize() {
        return currentSize;
    }

    public MaxSize getSize() {
        return maxSize;
    }

    public Type getType() {
        return type;
    }


}