package container;

import java.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IntFIFOTest {

    @Test
    public void insertElement() {
        IntFIFO queue = new IntFIFO(1);
        assertTrue(queue.isEmpty());
        assertEquals(0,queue.size());
        assertTrue(queue.insertElement(2));
        assertTrue(queue.insertElement(1));
    }

    @Test
    public void popElement() {
        IntFIFO queue = new IntFIFO(10);
        queue.insertElement(1);
        queue.insertElement(2);
        queue.insertElement(3);
        assertEquals(1,queue.popElement());
        assertEquals(2,queue.popElement());
        assertEquals(3,queue.popElement());
    }
}