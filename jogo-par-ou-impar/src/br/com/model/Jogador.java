package br.com.model;

public abstract class Jogador {

    protected Integer pontos;
    protected TipoDeJogador tipoDeJogador;
    protected String nome;

    public Jogador(){
        this.pontos = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getPontos() {
        return pontos;
    }

    public void setPontos(Integer pontos) {
        this.pontos = pontos;
    }

    public TipoDeJogador getTipoDeJogador() {
        return tipoDeJogador;
    }

    public void setTipoDeJogador(TipoDeJogador tipoDeJogador) {
        this.tipoDeJogador = tipoDeJogador;
    }

    public void incrementaPontoDoJogador(){
        pontos++;
    }
}
