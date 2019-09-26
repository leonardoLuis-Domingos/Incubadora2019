package br.com.model;

public class JogadorHumano extends Jogador {

    private String nome;

    public JogadorHumano(String nome){
        super();
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
