package com.willer.thedungeon.facade;

import com.willer.thedungeon.exceptions.RepositorioException;
import com.willer.thedungeon.geral.personagem.Personagem;

import java.util.ArrayList;
import java.util.List;

public interface ITheDungeonFacade
{

   void inserirPersonagem(Personagem p) throws RepositorioException;

   void excluirPersonagem(int id) throws RepositorioException;

   Personagem buscarPersonagem(int id) throws RepositorioException;

   List<Personagem> recuperaTodosPersonagens();

}
