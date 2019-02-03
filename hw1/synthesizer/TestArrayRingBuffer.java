package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(10);
        arb.enqueue(13);
        arb.enqueue(24);
        assertEquals(13, (int) arb.peek());
        arb.enqueue(53);
        assertEquals(3, arb.fillCount());
        assertEquals(13, (int) arb.dequeue());
        assertEquals(2, arb.fillCount());
    }

    @Test
    public void testIterable() {
        ArrayRingBuffer<String> arb = new ArrayRingBuffer<>(10);
        arb.enqueue("whats");
        arb.enqueue("up");
        arb.enqueue("dude");
        for (String s : arb) {
            System.out.println(s);
        }
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
