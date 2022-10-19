package br.edu.femass.model;

import java.util.List;

public class Aluno extends Leitor{
    private String matricula;
    private Long codigo;
    private static Long proximoCodigo = 1L;

    public Aluno(){

    }

    public Aluno(String nome, String endereco, String telefone, String matricula) {
        super(nome, endereco, telefone);
        this.matricula = matricula;
        this.codigo = proximoCodigo;
        proximoCodigo++;
        setPrazoMaximoDevolucao(15);
    }

    public Long getCodigo() {
        return codigo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String testeAluno(){
        return ("Nome: " + getNome() + "\n" +
                "Endereço: " + getEndereco() + "\n" +
                "Telefone: "+ getTelefone() + "\n" +
                "Prazo máximo de devolução: " + getPrazoMaximoDevolucao() + "\n" +
                "Matrícula: " + getMatricula() + "\n");
    }

    @Override
    public String toString(){
        return (getCodigo() + ": " + getNome()  +" - " + getMatricula() + " - " + getTelefone() + " - " + getPrazoMaximoDevolucao());
    }

    public static void atualizarProximoNumero(List<Aluno> alunos){
        for(Aluno aluno: alunos){
            if(aluno.getCodigo() > proximoCodigo){
                proximoCodigo = aluno.getCodigo()+1;
            }
        }
    }
}
