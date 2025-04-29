package service;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

public class ServicioNumerosTest {

    // Instancia de ServicioNumeros
    ServicioNumeros servicio = new ServicioNumerosImpl();

    @Test
    public void testNumerosFaltantes() {
        List<Integer> entrada = Arrays.asList(1, 2, 5, 6);
        List<Integer> esperado = Arrays.asList(3, 4);
        assertEquals(esperado, servicio.numerosFaltantes(entrada));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testListaNoOrdenada() {
        List<Integer> entrada = Arrays.asList(5, 2, 6);
        servicio.numerosFaltantes(entrada);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testListaConRepetidos() {
        List<Integer> entrada = Arrays.asList(1, 2, 2, 4);
        servicio.numerosFaltantes(entrada);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testListaMuyCorta() {
        List<Integer> entrada = Arrays.asList(1);
        servicio.numerosFaltantes(entrada);
    }

    @Test
    public void testListaSinFaltantes() {
        List<Integer> entrada = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> esperado = Arrays.asList();
        assertEquals(esperado, servicio.numerosFaltantes(entrada));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNumerosFaltantesConListaNull() {
        // Usamos la variable de instancia "servicio"
        servicio.numerosFaltantes(null);
    }
}