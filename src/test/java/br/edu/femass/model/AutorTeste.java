package br.edu.femass.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;

public class AutorTeste {
    @Test
    void testeAutor(){
        Autor autor = new Autor("Patrick", "Knidel","Alemão");

        String esperado = ("Nome: Patrick\n" +
                           "Sobrenome: Knidel\n" +
                           "Nacionalidade: Alemão");

        Assertions.assertEquals(esperado, autor.testeAutor());
    }
}
