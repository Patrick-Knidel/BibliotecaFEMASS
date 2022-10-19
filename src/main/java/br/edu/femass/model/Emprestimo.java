package br.edu.femass.model;

import java.time.LocalDate;

public class Emprestimo {
    private LocalDate dataEmprestimo;
    private LocalDate dataPrevisaoDevolucao;
    private LocalDate dataDevolucao;
    private Leitor leitor;
    private Exemplar exemplar;

    public Emprestimo(){

    }

    public Emprestimo(Leitor leitor, Exemplar exemplar) {
        this.dataEmprestimo = LocalDate.now();
        this.dataPrevisaoDevolucao = dataPrevisaoDevolucao;
        this.dataDevolucao = dataDevolucao;
        this.leitor = leitor;
        this.exemplar = exemplar;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataPrevisaoDevolucao() {
        return dataPrevisaoDevolucao;
    }

    public void setDataPrevisaoDevolucao(LocalDate dataPrevisaoDevolucao) {
        this.dataPrevisaoDevolucao = dataPrevisaoDevolucao;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Exemplar getExemplar(){
        return exemplar;
    }

    @Override
    public String toString() {
        return (getDataEmprestimo().toString() + " : " + exemplar.toString());
    }
}
