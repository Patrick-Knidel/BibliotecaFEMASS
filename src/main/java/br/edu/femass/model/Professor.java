package br.edu.femass.model;

import java.util.List;

public class Professor extends Leitor{
    private String disciplina;
    private Long codigo;
    private static Long proximoCodigo = 1L;
    public Professor(){

    }

    public Professor(String nome, String endereco, String telefone, String disciplina) {
        super(nome, endereco, telefone);
        this.codigo = proximoCodigo;
        proximoCodigo++;
        this.disciplina = disciplina;
        setPrazoMaximoDevolucao(30);

    }

    public Long getCodigo() {
        return codigo;
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
        return (getCodigo() + " - " + getNome() + " - " + getTelefone() + " - " + getDisciplina() + " - " + getPrazoMaximoDevolucao());
    }

    public static void atualizarProximoNumero(List<Professor> professores){
        for(Professor professor: professores){
            if(professor.getCodigo() > proximoCodigo){
                proximoCodigo = professor.getCodigo()+1;
            }
        }
    }
}
