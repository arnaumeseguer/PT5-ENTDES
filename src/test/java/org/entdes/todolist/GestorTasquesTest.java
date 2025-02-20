package org.entdes.todolist;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class GestorTasquesTest {

    GestorTasques gestor;

    @BeforeEach
    void setUp(){
        gestor = new GestorTasques();
    }


    @Test
    void testAfegirTasca() throws Exception {

        
        int id = gestor.afegirTasca("nova tasca", null, null, null);
        
        int numTasques = gestor.llistarTasques().size();
        assertEquals(1, numTasques);
        Tasca tasca1 = gestor.obtenirTasca(id);
        assertEquals("nova tasca", tasca1.getDescripcio());
        

    }


    @Test
    void testAfegirTasca2() throws Exception {

    
        int id = gestor.afegirTasca("nova tasca 2", null, null, null);
        int numTasques = gestor.llistarTasques().size();
        assertEquals(1, numTasques);
        Tasca tasca1 = gestor.obtenirTasca(id);
        assertEquals("nova tasca 2", tasca1.getDescripcio());
    

    }

    @Test
    void testAfegirTascaExistent() throws Exception {
        gestor.afegirTasca("nova tasca", null, null, null);
        //Exception ex = assertThrows(Exception.class, ()-> gestor.afegirTasca("nova tasca"));
        
    
        }


    @Test
    void testEliminarTasca() throws Exception {
        int id = gestor.afegirTasca("nova tasca", null, null, null);
        gestor.eliminarTasca(id);
        int numTasques = gestor.llistarTasques().size();
        assertEquals(0, numTasques);
        
    }
/* 
    @Test
    void testEliminarTasca2() throws Exception {
        gestor.eliminarTasca(999);
        exception
        assertThrows(Exception., executable)(0, numTasques);
        
    }
*/

    @Test
    void testMarcarCompletada() throws Exception {
        int id = gestor.afegirTasca("nova tasca", null, null, null);
        gestor.marcarCompletada(id);
        Tasca tasca = gestor.obtenirTasca(id);
        assertEquals(true, tasca.isCompletada());
        
    }


    @Test
    void testModificarTasca() throws Exception{
        int id = gestor.afegirTasca("nova tasca", null, null, null);
        gestor.modificarTasca(id, "tasca modificada", false, null, null, null);
        Tasca tasca = gestor.obtenirTasca(id);
        try{
            gestor.modificarTasca(id, "", true, null, null, id);
        } catch (Exception e){
            assertEquals("La descripció no pot estar buida.", e.getMessage());
        }

        id = gestor.afegirTasca("null", null, null, null);
        gestor.modificarTasca(id, "tasca modificada 2", false, null, null, null);
        Tasca tasca2 = gestor.obtenirTasca(id);
        try{
            gestor.modificarTasca(id, "", true, null, null, id);
        } catch (Exception e){
            assertEquals("La descripció no pot estar buida.", e.getMessage());
        }

        id = gestor.afegirTasca("", null, null, null);
        gestor.modificarTasca(id, "tasca modificada 3", false, null, null, null);
        Tasca tasca3 = gestor.obtenirTasca(id);
        try{
            gestor.modificarTasca(id, "", true, null, null, id);
        } catch (Exception e){
            assertEquals("La descripció no pot estar buida.", e.getMessage());
        }
        
    }


    @Test
    void testObtenirTasca() throws Exception{
        int id = gestor.afegirTasca("nova tasca", null, null, null);
        Tasca tasca = gestor.obtenirTasca(id);
        assertEquals("nova tasca", tasca.getDescripcio());
        
    }

    @Test
    void testObtenirTascaInexistent() throws Exception{
        assertThrows(Exception.class , ()-> gestor.obtenirTasca(999));
        
    }


    @Test
    void testLlistarTasques() throws Exception {
        int id = gestor.afegirTasca("nova tasca", null, null, null);
        

        
    }


    @Test
    void testLlistarTasquesPerDescripcio()throws Exception {
        int id = gestor.afegirTasca("nova tasca", null, null, null);
        List<Tasca> llista = gestor.llistarTasquesPerDescripcio("nova");
        assertEquals(1, llista.size());
        assertEquals("nova tasca", llista.get(0).getDescripcio(), "La descripció de la tasca filtrada no és la correcta");
        
    }


    @Test
    void testGetNombreTasques() throws Exception{
        gestor.afegirTasca("nova tasca", null, null, null);
        gestor.afegirTasca("nova tasca 2", null, null, null);
        gestor.afegirTasca("nova tasca 3", null, null, null);
        assertEquals(3, gestor.getNombreTasques());
        

        
    }


}