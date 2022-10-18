package br.edu.femass.model;

public class Aluno extends Leitor{
    private String matricula;

    public Aluno(){

    }

    public Aluno(String nome, String endereco, String telefone, String matricula) {
        super(nome, endereco, telefone);
        this.matricula = matricula;
        setPrazoMaximoDevolucao(15);
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
        return (getNome()  +" - " + getMatricula() + " - " + getTelefone() + " - " + getPrazoMaximoDevolucao());
    }
}
