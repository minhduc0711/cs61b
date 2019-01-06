public class ArrayDeque<T> {
    private static final double EXPAND_FACTOR = 2;
    private static final double SHRINK_FACTOR = 0.5;

    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = nextFirst = 0;
        nextLast = 1;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printDeque() {
        int count = size;
        int index = nextFirst;
        while (count > 0) {
            index = Math.floorMod(index + 1, items.length);
            System.out.print(items[index] + " ");
            count--;
        }
        System.out.println();
    }

    public T get(int index) {
        return items[Math.floorMod(nextFirst + 1 + index, items.length)];
    }

    public void addFirst(T item) {
        checkArraySize();
        items[nextFirst] = item;
        nextFirst = Math.floorMod(nextFirst - 1, items.length);
        size++;
    }

    public void addLast(T item) {
        checkArraySize();
        items[nextLast] = item;
        nextLast = Math.floorMod(nextLast + 1, items.length);
        size++;
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        nextFirst = Math.floorMod(nextFirst + 1, items.length);
        T item = items[nextFirst];
        items[nextFirst] = null;
        size--;

        checkArraySize();
        return item;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        nextLast = Math.floorMod(nextLast - 1, items.length);
        T item = items[nextLast];
        items[nextLast] = null;
        size--;

        checkArraySize();
        return item;
    }

    private void checkArraySize() {
        if (size == items.length) {
            resize(EXPAND_FACTOR);
        }
        if (items.length >= 16) {
            float R = (float) size / items.length;
            if (R < 0.25) {
                resize(SHRINK_FACTOR);
            }
        }
    }

    private void resize(double factor) {
        T[] biggerItems = (T[]) new Object[(int) Math.round(items.length * factor)];
        int first = Math.floorMod(nextFirst + 1, items.length);
        int last = Math.floorMod(nextLast - 1, items.length);
        if (first < last)  {
            System.arraycopy(items, first, biggerItems, 0, last - first + 1);
        } else {
            System.arraycopy(items, first, biggerItems, 0, items.length - first);
            System.arraycopy(items, 0, biggerItems, items.length - first, last + 1);
        }
        items = biggerItems;
        nextFirst = biggerItems.length - 1;
        nextLast = size;
    }
}
