package eg.edu.alexu.csd.datastructure.queue.cs73;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedBaseTest {

    @Test
    void enqueue() {
        LinkedBase m = new LinkedBase();
         m.enqueue(3);
         m.enqueue(2);
         m.enqueue(1);
    }

    @Test
    void dequeue() {
        LinkedBase m = new LinkedBase();
        m.enqueue(3);
        m.enqueue(2);
        m.enqueue(1);
        assertEquals(3,m.dequeue());
        assertEquals(2,m.dequeue());
        assertEquals(1,m.dequeue());
        assertThrows(RuntimeException.class,()->m.dequeue());
    }

    @Test
    void isEmpty() {
        LinkedBase m = new LinkedBase();
        assertEquals(true,m.isEmpty());
        m.enqueue("nm");
        assertEquals(false,m.isEmpty());
        m.dequeue();
        assertEquals(true,m.isEmpty());
    }

    @Test
    void size() {
        LinkedBase m = new LinkedBase();
        m.enqueue(3);
        m.enqueue(2);
        m.enqueue(1);
        assertEquals(3,m.size());
        m.dequeue();
        assertEquals(2,m.size());
        m.dequeue();
        assertEquals(1,m.size());
        m.dequeue();
        assertEquals(0,m.size());
    }
}