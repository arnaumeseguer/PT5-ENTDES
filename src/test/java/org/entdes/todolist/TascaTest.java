package org.entdes.todolist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class TascaTest {
    @Test
    void testGetDescripcio() {

        Tasca tasca1 = new Tasca("nova tasca");
        assertEquals("nova tasca", tasca1.getDescripcio());

    }
    @Test
    void testCompletarTasca() {

        Tasca tasca1 = new Tasca("nova tasca");
        tasca1.setCompletada(true);
        assertTrue(tasca1.isCompletada());
    }

    @Test
    void testDescompletarTasca() {

        Tasca tasca1 = new Tasca("nova tasca");
        tasca1.setCompletada(true);
        tasca1.setCompletada(false);
        assertFalse(tasca1.isCompletada());
    }

    @Test
    void setDescripcio() {

        Tasca tasca1 = new Tasca("nova tasca");
        tasca1.setDescripcio("nova descripcio");
        assertEquals("nova descripcio", tasca1.getDescripcio());
    }
    @Test
    void testToStringPendent() {
        Tasca tasca1 = new Tasca("nova tasca");
        assertEquals("nova tasca: Pendent", tasca1.toString());
        
    }

    
}

