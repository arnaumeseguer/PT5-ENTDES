package org.entdes.todolist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

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

        Tasca tasca2 = new Tasca("nova tasca");
        tasca2.setCompletada(true);
        assertEquals("nova tasca: Completada", tasca2.toString());
        
    }
    @Test
    void testGetDataFiPrevista() {
        Tasca tasca1 = new Tasca("nova tasca");
        tasca1.setDataFiPrevista(LocalDate.of(2026, 1, 1));
        assertEquals(LocalDate.of(2026,1,1), tasca1.getDataFiPrevista());
        
    }
    @Test
    void testGetDataFiReal() {
        Tasca tasca1 = new Tasca("nova tasca");
        tasca1.setDataFiReal(LocalDate.of(2026, 1, 1));
        assertEquals(LocalDate.of(2026, 1, 1), tasca1.getDataFiReal());
    }
    @Test
    void testGetDataInici() {
        Tasca tasca1 = new Tasca("nova tasca");
        tasca1.setDataInici(LocalDate.of(2026, 1, 1));
        assertEquals(LocalDate.of(2026,1,1), tasca1.getDataInici());
    }
    @Test
    void testGetPrioritat() {
        Tasca tasca1 = new Tasca("nova tasca");
        tasca1.setPrioritat(3);
        assertEquals(3, tasca1.getPrioritat());
    }
   

    
}

