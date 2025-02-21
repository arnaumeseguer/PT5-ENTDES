package org.entdes.todolist;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
        
        try{
        id = gestor.afegirTasca(null, null, null, null);
        numTasques = gestor.llistarTasques().size();
        assertEquals(1, numTasques);
        
        gestor.obtenirTasca(id);
        } catch (Exception e){
        assertEquals("La descripció no pot estar buida.", e.getMessage());
        }        
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

        gestor.afegirTasca("nova tasca2", null, null, null);
        try{
            gestor.eliminarTasca(9999);
        } catch (Exception e){
            assertEquals("La tasca no existeix", e.getMessage());
        }
        
    }


    @Test
    void testMarcarCompletada() throws Exception {
        int id = gestor.afegirTasca("nova tasca", null, null, null);
        gestor.marcarCompletada(id);
        Tasca tasca = gestor.obtenirTasca(id);
        assertEquals(true, tasca.isCompletada());

        gestor.afegirTasca("nova tasca2", null, null, null);
        try{
        gestor.marcarCompletada(10);
        }catch (Exception e){
            assertEquals("La tasca no existeix",e.getMessage());
        }
        
    }


    @Test
    void testModificarTasca() throws Exception{
        int id = gestor.afegirTasca("nova tasca", null, null, null);
        try{
            gestor.modificarTasca(id, "tasca modificada", true, null, null, null);
        } catch (Exception e){
            assertEquals("La descripció no pot estar buida.", e.getMessage());
        }

        id = gestor.afegirTasca("nova tasca2", null, null, null);
        try{
            gestor.modificarTasca(id, null, true, null, null, id);
        } catch (Exception e){
            assertEquals("La descripció no pot estar buida.", e.getMessage());
        }

        id = gestor.afegirTasca("nova tasca3", null, null, null);
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

        try{
        gestor.obtenirTasca(9999);
        } catch (Exception e){
            assertEquals("La tasca no existeix", e.getMessage());
        }
        
    }

    @Test
    void testObtenirTascaInexistent() throws Exception{
     try{
        gestor.obtenirTasca(9999);
     } catch (Exception e){
         assertEquals("La tasca no existeix", e.getMessage());
     }

    }


    @Test
    void testLlistarTasques() throws Exception {
        gestor.afegirTasca("nova tasca", null, null, null);
        

        
    }


    @Test
    void testLlistarTasquesPerDescripcio()throws Exception {
        gestor.afegirTasca("nova tasca", null, null, null);
        List<Tasca> llista = gestor.llistarTasquesPerDescripcio("nova");
        assertEquals(1, llista.size());
        
        gestor.afegirTasca("nova tasca 2", null, null, null);
        llista = gestor.llistarTasquesPerDescripcio("hola");
        assertEquals(0, llista.size()); //1, ja que es mante la tasca afegida anteriorment
    }


    @Test
    void testGetNombreTasques() throws Exception{
        gestor.afegirTasca("nova tasca", null, null, null);
        gestor.afegirTasca("nova tasca 2", null, null, null);
        gestor.afegirTasca("nova tasca 3", null, null, null);
        assertEquals(3, gestor.getNombreTasques());
        

        
    }

    @Test
    void testValidarSiExisteixTasca() throws Exception{
        try{
            gestor.afegirTasca("nova tasca", LocalDate.of(2126, 1, 1), LocalDate.of(2125, 12, 31), null);
        } catch (Exception e){
            assertEquals("La data d'inici no pot ser posterior a la data fi prevista.", e.getMessage());
        }

        try{
            gestor.afegirTasca("nova tasca 2", null, LocalDate.of(2125, 12, 31), null);
        } catch (Exception e){
            assertEquals("La data d'inici no pot ser posterior a la data fi prevista.", e.getMessage());
        }
        
        int id = gestor.afegirTasca("tasca", null, null, null);
        try{
            gestor.modificarTasca(id, null, null, null, null, null);
        } catch (Exception e){
            assertEquals("La descripció no pot estar buida.", e.getMessage());
        }
    
        try{
        gestor.afegirTasca("nova tasca3", LocalDate.of(2124, 1, 1),LocalDate.of(2125, 1, 1), null);
        } catch (Exception e) {
            assertEquals("La data d'inici no pot ser anterior a la data actual.", e.getMessage());
        }

       
    
            
        gestor.validarSiExisteixTasca(9999,"test");
        
        gestor.afegirTasca("nova tasca 4", null, null, null);
        try {
        gestor.validarSiExisteixTasca(30, "nova tasca 4");
        } catch(Exception e){
            assertEquals("Ja existeix una tasca amb la mateixa descripció", e.getMessage());
        }

        id = gestor.afegirTasca("nova tasca 5", null, null, null);
        try{
        gestor.modificarTasca(id, "tasca 5 modificada", null, LocalDate.of(2125, 3, 1), null, null);
        } catch (Exception e){
            assertEquals("La data d'inici no pot ser posterior a la data fi prevista.", e.getMessage());
        }

        id = gestor.afegirTasca("nova tasca 6", null, null, null);
        try{
            gestor.modificarTasca(id, "tasca 6 modificada", null, LocalDate.of(2125, 3, 1), LocalDate.of(2126, 1, 1), 6);
            
        
        
        
        } catch (Exception e){
            assertEquals("La prioritat ha de ser un valor entre 1 i 5", e.getMessage());
        }

        gestor.modificarTasca(id, "tasca 6 modificada", null, null, null, null);

        
    }


    @Test
    void testLlistarTasquesPerComplecio() throws Exception {
        int id = gestor.afegirTasca("nova tasca", null, null, null);
        gestor.marcarCompletada(id);
        gestor.afegirTasca("nova tasca 2", null, null, null);
        gestor.llistarTasquesPerComplecio(true);
        gestor.llistarTasquesPerComplecio(false);
    }


   
    

}