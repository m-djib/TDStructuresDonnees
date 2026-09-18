package container;

import java.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestIntFIFO {

    @Test
    public void test_IntFIFO() {
        IntFIFO queue = new IntFIFO(10);
        assertTrue(queue.isEmpty());
        assertEquals(0,queue.size());
    }

    @Test
    public void test_insertElement() {
        IntFIFO queue = new IntFIFO(1);
        assertTrue(queue.insertElement(2));
        assertTrue(queue.insertElement(1));
    }

    @Test
    public void test_popElement() {
        IntFIFO queue = new IntFIFO(10);
        queue.insertElement(1);
        queue.insertElement(2);
        queue.insertElement(3);
        assertEquals(1,queue.popElement());
        assertEquals(2,queue.popElement());
        assertEquals(3,queue.popElement());
    }

    @Test
    public void test_pop_AutoGrowth() {
        IntFIFO queue = new IntFIFO(3);
        queue.insertElement(1);
        queue.insertElement(2);
        queue.insertElement(3);
        assertEquals(1,queue.popElement());
        assertEquals(2,queue.popElement());
        queue.insertElement(4);
        queue.insertElement(5);
        assertEquals(3,queue.popElement());
        assertEquals(4,queue.popElement());
        queue.insertElement(6);
        assertEquals(5,queue.popElement());
        assertEquals(6,queue.popElement());
    }
}