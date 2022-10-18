package br.edu.femass.model;

import java.util.List;

public class Professor extends Leitor{
    private String disciplina;
    public Professor(){

    }

    public Professor(String nome, String endereco, String telefone, String disciplina) {
        super(nome, endereco, telefone);
        this.disciplina = disciplina;
        setPrazoMaximoDevolucao(30);
    }
    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }


    public String testeProfessor(){
        return ("Nome: " + getNome() + "\n" +
                "Endereço: " + getEndereco() + "\n" +
                "Telefone: "+ getTelefone() + "\n" +
                "Prazo máximo de devolução: " + getPrazoMaximoDevolucao() + "\n" +
                "Disciplina: " + getDisciplina() + "\n");
    }

    public String toString(){
        return (getNome() + " - " + getTelefone() + " - " + getDisciplina() + " - " + getPrazoMaximoDevolucao());
    }
}
