import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {
    @Test
    public void testDeque() {
        StringBuilder errorMessage = new StringBuilder();
        StudentArrayDeque<Integer> studentArrayDeque = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> arrayDequeSolution = new ArrayDequeSolution<>();
        for (int i = 0; i < 1000; i += 1) {
            double randomNumber = StdRandom.uniform();
            assertEquals(arrayDequeSolution.size(), studentArrayDeque.size());
            if (arrayDequeSolution.isEmpty()) {
                if (randomNumber < 0.5) {
                    studentArrayDeque.addLast(i);
                    arrayDequeSolution.addLast(i);
                    errorMessage.append("addLast(").append(i).append(")\n");
                } else if (randomNumber > 0.5) {
                    studentArrayDeque.addFirst(i);
                    arrayDequeSolution.addFirst(i);
                    errorMessage.append("addFirst(").append(i).append(")\n");
                }
            } else {
                if (randomNumber < 0.25) {
                    studentArrayDeque.addLast(i);
                    arrayDequeSolution.addLast(i);
                    errorMessage.append("addLast(").append(i).append(")\n");
                } else if (randomNumber < 0.5) {
                    studentArrayDeque.addFirst(i);
                    arrayDequeSolution.addFirst(i);
                    errorMessage.append("addFirst(").append(i).append(")\n");
                } else if (randomNumber < 0.75) {
                    errorMessage.append("removeLast()\n");
                    assertEquals(errorMessage.toString().substring(0, errorMessage.length()-1), arrayDequeSolution.removeLast(), studentArrayDeque.removeLast());
                } else {
                    errorMessage.append("removeFirst()\n");
                    assertEquals(errorMessage.toString().substring(0, errorMessage.length()-1), arrayDequeSolution.removeFirst(), studentArrayDeque.removeFirst());
                }
            }
        }
    }
}
