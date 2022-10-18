package br.edu.femass.model;

public class Autor {
    private String nome;
    private String sobreNome;
    private String nacionalidade;

    public Autor(){

    }
    public Autor(String nome, String sobreNome, String nacionalidade){
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.nacionalidade = nacionalidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
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
        return (getNome() + " " + getSobreNome() + " - " + getNacionalidade());
    }
}
