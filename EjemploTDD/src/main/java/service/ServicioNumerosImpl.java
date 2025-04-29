package service;

import java.util.ArrayList;
import java.util.List;

public class ServicioNumerosImpl implements ServicioNumeros {

    @Override
    public List<Integer> numerosFaltantes(List<Integer> numeros) {
        if (numeros == null || numeros.size() < 2) {
            throw new IllegalArgumentException("La lista debe tener al menos dos elementos.");
        }

        for (int i = 1; i < numeros.size(); i++) {
            if (numeros.get(i) <= numeros.get(i - 1)) {
                throw new IllegalArgumentException("La lista debe estar ordenada y sin repetidos.");
            }
        }

        List<Integer> faltantes = new ArrayList<>();
        int inicio = numeros.get(0);
        int fin = numeros.get(numeros.size() - 1);

        for (int i = inicio + 1; i < fin; i++) {
            if (!numeros.contains(i)) {
                faltantes.add(i);
            }
        }

        return faltantes;
    }
}
