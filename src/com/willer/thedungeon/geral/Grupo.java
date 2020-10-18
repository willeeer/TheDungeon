package com.willer.thedungeon.geral;

import com.willer.thedungeon.personagem.Personagem;

public class Grupo {

    private Personagem integranteUm;
    private Personagem integranteDois;
    private Personagem integranteTres;

    public Grupo(Personagem integranteUm, Personagem integranteDois, Personagem integranteTres) {
        this.integranteUm = integranteUm;
        this.integranteDois = integranteDois;
        this.integranteTres = integranteTres;
    }

    public Grupo() {
    }

    public Personagem getIntegranteUm() {
        return integranteUm;
    }

    public void setIntegranteUm(Personagem integranteUm) {
        this.integranteUm = integranteUm;
    }

    public Personagem getIntegranteDois() {
        return integranteDois;
    }

    public void setIntegranteDois(Personagem integranteDois) {
        this.integranteDois = integranteDois;
    }

    public Personagem getIntegranteTres() {
        return integranteTres;
    }

    public void setIntegranteTres(Personagem integranteTres) {
        this.integranteTres = integranteTres;
    }

    public String getDescricaoGrupo() {
        return "------------------------------------------" +
                integranteUm.getDescricaoPersonagem() +
                integranteDois.getDescricaoPersonagem() +
                integranteTres.getDescricaoPersonagem() +
                "------------------------------------------";

    }

    public Personagem getIntegranteEspecifico(Integer integrante) {
        switch (integrante) {
            case 1:
                return integranteUm;
            case 2:
                return integranteDois;
            case 3:
                return integranteTres;
            default:
                return null;
        }
    }

    public void adicionarPersonagem(Personagem p) {

        if (integranteUm == null) {
            integranteTres = p;
        } else {
            if (integranteDois == null) {
                integranteDois = p;
            } else {
                if (integranteTres == null) {
                    integranteTres = p;
                }
            }
        }
    }
}
