import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDequeTest {
    @Test
    public void testAddItems() {
        ArrayDeque<String> A = new ArrayDeque<>();
        A.addFirst("cats");
        A.addFirst("love");
        A.addLast("very");
        A.addFirst("i");
        A.addLast("much");

        assertEquals(5, A.size());
        assertEquals("i", A.get(0));
        assertEquals("love", A.get(1));
        assertEquals("cats", A.get(2));
        assertEquals("very", A.get(3));
        assertEquals("much", A.get(4));

    }

    @Test
    public void testRemoveItems() {
        ArrayDeque<String> A = new ArrayDeque<>();
        A.addFirst("cats");
        A.addFirst("love");
        A.addLast("very");
        A.addFirst("i");
        A.addLast("much");
        System.out.println("Printing out deque: ");
        A.printDeque();

        assertEquals("i", A.removeFirst());
        assertEquals("much", A.removeLast());
        assertEquals("love", A.removeFirst());
        assertEquals(2, A.size());
        assertEquals("cats", A.get(0));
        assertEquals("very", A.get(1));

        A.removeFirst();
        A.removeLast();
        assertEquals(0, A.size());
    }

    @Test
    public void testExpand() {
        ArrayDeque<Integer> A = new ArrayDeque<>();
        for (int i = 0; i < 100; i++) {
            A.addLast(i);
        }

        assertEquals(0, (int) A.get(0));
        assertEquals(50, (int) A.get(50));
        assertEquals(99, (int) A.get(99));

        A = new ArrayDeque<>();
        for (int i = 99; i >= 0; i--) {
            A.addFirst(i);
        }

        assertEquals(0, (int) A.get(0));
        assertEquals(50, (int) A.get(50));
        assertEquals(99, (int) A.get(99));
    }

    @Test
    public void testShrink() {
        ArrayDeque<Integer> A = new ArrayDeque<>();
        for (int i = 0; i < 10000; i++) {
            A.addLast(i);
        }

        for (int i = 0; i < 9000; i++) {
            A.removeLast();
        }

        assertEquals(0, (int) A.get(0));
        assertEquals(100, (int) A.get(100));
        assertEquals(999, (int) A.get(999));

        for (int i = 0; i < 750; i++) {
            A.removeFirst();
        }
        assertEquals(750, (int) A.get(0));
    }
}
