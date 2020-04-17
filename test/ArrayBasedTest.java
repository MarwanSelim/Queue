package eg.edu.alexu.csd.datastructure.queue.cs73;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayBasedTest {

    @Test
    void enqueue() {
        ArrayBased m=new ArrayBased(3);
        m.enqueue(1);
        m.enqueue(2);
        m.enqueue(3);
        assertThrows(RuntimeException.class,()->m.enqueue(4));
    }

    @Test
    void dequeue() {
        ArrayBased m=new ArrayBased(3);
        m.enqueue(1);
        m.enqueue(2);
        m.enqueue(3);
        assertEquals(1,m.dequeue());
        assertEquals(2,m.dequeue());
        assertEquals(3,m.dequeue());
        assertThrows(RuntimeException.class,()->m.dequeue());
        m.enqueue(3);
        m.enqueue(6);
        assertEquals(3,m.dequeue());
        assertEquals(6,m.dequeue());
    }

    @Test
    void isEmpty() {
        ArrayBased m =new ArrayBased(3);
        assertEquals(true,m.isEmpty());
        m.enqueue(6);
        assertEquals(false,m.isEmpty());
        m.dequeue();
        assertEquals(true,m.isEmpty());
    }

    @Test
    void size() {
        ArrayBased m =new ArrayBased(3);
        assertEquals(0,m.size());
        m.enqueue(3);
        m.enqueue(7);
        assertEquals(2,m.size());
        m.dequeue();
        assertEquals(1,m.size());
        m.dequeue();
        assertEquals(0,m.size());
    }
}