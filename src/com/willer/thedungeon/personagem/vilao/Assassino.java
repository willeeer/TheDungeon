package com.willer.thedungeon.personagem.vilao;

import com.willer.thedungeon.personagem.Personagem;

public class Assassino extends Personagem {


    public Assassino(Integer id, String nome) {
        super(id, nome);
        setForca(7);
        setAgilidade(15);
        setInteligencia(10);
        setVidaAtual(100);
        setVidaMaxima(100);
    }

    @Override
    public Integer getAtributoPrincipal() {
        return getAgilidade();
    }

    @Override
    public void aumentarNivel()
    {
        setNivel(getNivel() + 1);
        setForca(getForca() + 3);
        setAgilidade(getAgilidade() + 5);
        setInteligencia(getInteligencia() + 2);
    }

    @Override
    public String getDescricaoPersonagem() {
        return "Assassino: " + getNome() + "\nNivel: " + getNivel();
    }
}
