public class LinkedListDeque<T> {
    private class ItemNode {
        T item;
        ItemNode prev;
        ItemNode next;

        private ItemNode(T item, ItemNode prev, ItemNode next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }

        private ItemNode(T item) {
            this.item = item;
        }
    }

    private ItemNode sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new ItemNode(null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T get(int index) {
        if ((index >= size) || (index < 0)) {
            return null;
        }
        ItemNode current = sentinel.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.item;
    }

    public T getRecursive(int index) {
        if ((index >= size) || (index < 0)) {
            return null;
        }
        return getRecursiveHelper(sentinel.next, index);
    }

    private T getRecursiveHelper(ItemNode current, int index) {
        if (index == 0) {
            return current.item;
        }
        return getRecursiveHelper(current.next, index - 1);
    }

    public void printDeque() {
        ItemNode current = sentinel.next;
        while (current != sentinel) {
            System.out.print(current.item + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void addFirst(T item) {
        ItemNode itemNode = new ItemNode(item, sentinel, sentinel.next);
        sentinel.next.prev = itemNode;
        sentinel.next = itemNode;
        size++;
    }

    public void addLast(T item) {
        ItemNode itemNode = new ItemNode(item, sentinel.prev, sentinel);
        sentinel.prev.next = itemNode;
        sentinel.prev = itemNode;
        size++;
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        ItemNode first = sentinel.next;
        T val = first.item;
        sentinel.next = first.next;
        first.next.prev = sentinel;
        size--;
        return val;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        ItemNode last = sentinel.prev;
        T val = last.item;
        sentinel.prev = last.prev;
        last.prev.next = sentinel;
        size--;
        return val;
    }
}
