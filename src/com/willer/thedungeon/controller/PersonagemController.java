package com.willer.thedungeon.controller;

import com.willer.thedungeon.dados.RepositorioPersonagem;
import com.willer.thedungeon.exceptions.RepositorioException;
import com.willer.thedungeon.geral.personagem.Personagem;

public class PersonagemController
{
    private static PersonagemController instance;

    public static synchronized PersonagemController getInstance()
    {
        if (instance == null)
        {
            instance = new PersonagemController();
        }
        return instance;
    }

    public void inserir(Personagem p) throws RepositorioException {
        boolean jaExiste = false;
        if (p != null) {

            for (Personagem busca : RepositorioPersonagem.getInstance().getListaPersonagens()) {
                if (p.getId() == (busca.getId())) {
                    jaExiste = true;
                    break;
                }
            }
        } else{
            throw new RepositorioException("Valor não permitido (null)");
        }

        if (jaExiste) {
            throw new RepositorioException("Este personagem j� est� inserido");
        } else {
            RepositorioPersonagem.getInstance().getListaPersonagens().add(p);
        }
    }

    public Personagem buscarPorId(int id) throws RepositorioException{
        Personagem p = RepositorioPersonagem.getInstance().buscarPorId(id);
        if(p == null){
            throw new RepositorioException("Personagem não encontrado.");
        }
        return p;
    }

    public void excluir(int id) throws RepositorioException{
        if(this.buscarPorId(id) != null){
            RepositorioPersonagem.getInstance().excluir(id);
        }
        else{
            throw new RepositorioException("Personagem não encontrado.");
        }
    }

}
