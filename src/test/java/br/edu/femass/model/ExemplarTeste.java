package br.edu.femass.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class ExemplarTeste {
    @Test
    void testeExemplar(){
        Exemplar exemplar = new Exemplar();

        String esperado = "Código: 1\nData de aquisição: 2022-10-18";

        Assertions.assertEquals(esperado, exemplar.toString());
    }
}
