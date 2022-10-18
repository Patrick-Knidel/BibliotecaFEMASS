package br.edu.femass.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProfessorTeste {
    @Test
    void testeProfessor(){
        Professor professor = new Professor("Patrick", "Elisio Dias Curvelo","22998312631","Prog III");

        String esperado = ("Nome: Patrick"  + "\n" +
                           "Endereço: Elisio Dias Curvelo" + "\n" +
                           "Telefone: 22998312631" + "\n" +
                           "Prazo máximo de devolução: 30" + "\n" +
                           "Disciplina: Prog III" + "\n");

        Assertions.assertEquals(esperado,professor.testeProfessor());
    }
}
