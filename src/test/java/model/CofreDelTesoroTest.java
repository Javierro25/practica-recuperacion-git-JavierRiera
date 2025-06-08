package model;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CofreDelTesoroTest {

    private CofreDelTesoro cofre;

    @BeforeEach
    void setUp() {
        cofre = new CofreDelTesoro("ABC123", 3);
    }

    @Test
    @DisplayName("Debe iniciar cerrado")
    void cofreDebeEstarCerradoAlInicio() {
        assertTrue(cofre.estaCerrado());
    }

    @Test
    @DisplayName("No permite agregar tesoro si está cerrado")
    void noAgregarTesoroCerrado() {
        assertFalse(cofre.agregarTesoro("Diamante"));
    }

    @Test
    @DisplayName("Agregar tesoro válido cuando está abierto")
    void agregarTesoroValido() {
        cofre.abrir();
        assertTrue(cofre.agregarTesoro("Esmeralda"));
        assertEquals(1, cofre.contarTesoros());
    }

    @Test
    @DisplayName("Debe lanzar excepción si se crea con código nulo")
    void constructorInvalidoLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> new CofreDelTesoro(null, 2));
    }

    @Test
    @DisplayName("Vaciar cofre abierto debe eliminar todos los tesoros")
    void vaciarCofreAbierto() {
        cofre.abrir();
        cofre.agregarTesoro("Rubí");
        cofre.vaciar();
        assertEquals(0, cofre.contarTesoros());
    }

    @Test
    @DisplayName("getTesoros debe retornar lista no nula")
    void listaTesorosNoDebeSerNula() {
        assertNotNull(cofre.getTesoros());
    }

    @Test
    @Disabled("Prueba deshabilitada temporalmente")
    @DisplayName("Eliminar tesoro debería funcionar")
    void pruebaDeshabilitadaEliminarTesoro() {
        cofre.abrir();
        cofre.agregarTesoro("Perla");
        assertTrue(cofre.quitarTesoro("Perla"));
    }
}