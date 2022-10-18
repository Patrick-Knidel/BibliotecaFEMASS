package br.edu.femass.model;

import java.util.List;

public class Livro {
    private Long codigo;
    private String titulo;
    private Autor autor;
    private String ano;
    private static Long proximoCodigo = 1L;

    public Livro(){

    }

    public Livro(String titulo, Autor autor, String ano){
        this.codigo = proximoCodigo;
        proximoCodigo++;
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
    }


    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public Autor getAutor() {
        return autor;
    };
    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String testeLivro(){
        return ("Código: " + getCodigo() + "\n" +
                "Título: " + getTitulo() + "\n" +
                "Autor: " + getAutor() + "\n" +
                "Ano: " + getAno());
    }

    public String toString(){
        return (getCodigo() + " - " + getTitulo() + " - " + getAutor() + " - " + getAno());
    }

    public static void atualizarProximoNumero(List<Livro> livros){
        for(Livro livro: livros){
            if(livro.getCodigo() > proximoCodigo){
                proximoCodigo = livro.getCodigo()+1;
            }
        }
    }
}
