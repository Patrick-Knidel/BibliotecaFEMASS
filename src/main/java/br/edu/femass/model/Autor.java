package br.edu.femass.model;

import java.util.List;

public class Autor {
    private String nome;
    private String sobrenome;
    private String nacionalidade;
    private Long codigo;

    private static Long proximoCodigo = 1L;

    public Autor(){

    }
    public Autor(String nome, String sobrenome, String nacionalidade){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.nacionalidade = nacionalidade;
        this.codigo = proximoCodigo;
        proximoCodigo++;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobrenome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobrenome = sobreNome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }


    public String testeAutor(){
        return ("Nome: " + getNome() + "\n" +
                "Sobrenome: " + getSobreNome() + "\n" +
                "Nacionalidade: " + getNacionalidade());
    }

    @Override
    public String toString(){
        return (getCodigo() + " : " + getNome() + " " + getSobreNome() + " - " + getNacionalidade());
    }

    public static void atualizarProximoNumero(List<Autor> autores){
        for(Autor autor: autores){
            if(autor.getCodigo() > proximoCodigo){
                proximoCodigo = autor.getCodigo()+1;
            }
        }
    }
}
