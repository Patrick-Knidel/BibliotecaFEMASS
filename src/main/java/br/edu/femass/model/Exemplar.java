package br.edu.femass.model;

import java.time.LocalDate;
import java.util.List;

public class Exemplar {
    private Long codigo;
    private LocalDate dataAquisicao;
    private static Long proximoCodigo = 1L;

    public Exemplar(){
        this.codigo = proximoCodigo;
        proximoCodigo++;
        this.dataAquisicao = LocalDate.now();
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public LocalDate getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(LocalDate dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    public String toString(){
        return ("Código: " + getCodigo() + "\n" +
                "Data de aquisição: " + getDataAquisicao());
    }

    public static void atualizarProximoNumero(List<Exemplar> exemplares){
        for(Exemplar exemplar: exemplares){
            if(exemplar.getCodigo() > proximoCodigo){
                proximoCodigo = exemplar.getCodigo()+1;
            }
        }
    }
}
