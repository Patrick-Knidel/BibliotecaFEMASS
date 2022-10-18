package br.edu.femass.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeitorTeste {
    @Test
    void testeLeitor(){
        Leitor leitor = new Leitor("Patrick", "Elisio Dias Curvelo", "22998312631");

        String esperado = ("Código: " + "1" + "\n" +
                "Nome: " + "Patrick" + "\n" +
                "Endereço: " + "Elisio Dias Curvelo" + "\n" +
                "Telefone: " + "22998312631" + "\n");

        Assertions.assertEquals(esperado, leitor.toString());
    }
}
