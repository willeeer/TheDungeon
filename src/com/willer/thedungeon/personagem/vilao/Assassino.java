package com.willer.thedungeon.personagem.vilao;

import com.willer.thedungeon.personagem.Personagem;

public class Assassino extends Personagem {


    public Assassino(Integer id, String nome) {
        super(id, nome);
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
        return "Assassino: " + getNome() + "Nivel: " + getNivel();
    }
}
