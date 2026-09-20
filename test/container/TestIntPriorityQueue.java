package container;

import java.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestIntPriorityQueue {

    @Test
    public void test_IntPriorityQueue() {
        IntPriorityQueue queue = new IntPriorityQueue(2);
        assertTrue(queue.isEmpty());
        assertEquals(0,queue.size());
    }

    @Test
    public void test_insertElement() {
        IntPriorityQueue queue = new IntPriorityQueue(1);
        assertTrue(queue.insertElement(2));
        assertTrue(queue.insertElement(1));
    }

    @Test
    public void test_popElement() {
        IntPriorityQueue queue = new IntPriorityQueue(10);
        queue.insertElement(1);
        queue.insertElement(3);
        queue.insertElement(2);
        assertEquals(3,queue.popElement());
        assertEquals(2,queue.popElement());
        assertEquals(1,queue.popElement());
    }

    @Test
    public void test_iterator() {
        IntPriorityQueue queue = new IntPriorityQueue(10);
        queue.insertElement(2);
        queue.insertElement(3);
        queue.insertElement(1);
        Iterator<Integer> it = queue.iterator();
        int i = 3;
        while (it.hasNext()) {
            assertEquals(i,it.next());
            i--;
        }
    }
}