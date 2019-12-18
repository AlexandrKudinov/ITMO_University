package L14_Threads.ShipsAndDocks;

enum MaxSize {
    SMALL(50), MEDIUM(100), LARGE(150);
    private int value;

    MaxSize(int value) {
        this.value = value;
    }

    public int getSize() {
        return value;
    }
}