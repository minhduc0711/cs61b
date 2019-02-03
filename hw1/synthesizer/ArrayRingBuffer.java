 package synthesizer;

import java.util.Iterator;

//TODO: Make sure to make this class and all of its methods public
//TODO: Make sure to make this class extend AbstractBoundedQueue<t>
public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    private class ArbIterator implements Iterator<T>{
        int ptr;

        public ArbIterator() {
            ptr = first;
        }

        @Override
        public boolean hasNext() {
            return ptr != last;
        }

        @Override
        public T next() {
            T val = rb[ptr];
            ptr = (ptr + 1) % capacity;
            return val;
        }
    }

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        first = last = fillCount = 0;
        this.capacity = capacity;
        rb = (T[]) new Object[capacity];
    }

    @Override
    public Iterator<T> iterator() {
        return new ArbIterator();
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public void enqueue(T x) {
        if (isFull()) {
            throw new RuntimeException("The queue is full");
        }
        rb[last] = x;
        fillCount += 1;
        last = (last + 1) % capacity;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("The queue is empty");
        }
        T val = rb[first];
        rb[first] = null;
        fillCount -= 1;
        first = (first + 1) % capacity;
        return val;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        if (fillCount() == 0) {
            throw new RuntimeException("Queue is empty");
        }
        return rb[first];
    }

    // TODO: When you get to part 5, implement the needed code to support iteration.
}
