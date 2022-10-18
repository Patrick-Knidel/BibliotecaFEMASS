package br.edu.femass.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AlunoTeste {
    @Test
    void testeAluno(){
        Aluno aluno = new Aluno("Patrick", "Elisio Dias Curvelo","22998312631","2001230027");

        String esperado = ("Nome: Patrick"  + "\n" +
                           "Endereço: Elisio Dias Curvelo" + "\n" +
                           "Telefone: 22998312631" + "\n" +
                           "Prazo máximo de devolução: 15" + "\n" +
                           "Matrícula: 2001230027" + "\n");

        Assertions.assertEquals(esperado,aluno.testeAluno());
    }
}
