package com.willer.thedungeon.magias;

public class Magia {

    public String nome;
    public Integer poderDeAtaque;
    //talvez adicionar atributo e fazer uma logica tipo agua > fogo > folha > agua


    public Magia(String nome, Integer poderDeAtaque) {
        this.nome = nome;
        this.poderDeAtaque = poderDeAtaque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getPoderDeAtaque() {
        return poderDeAtaque;
    }

    public void setPoderDeAtaque(Integer poderDeAtaque) {
        this.poderDeAtaque = poderDeAtaque;
    }
}
