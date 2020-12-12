package com.willer.thedungeon.facade;

import com.willer.thedungeon.controller.PersonagemController;
import com.willer.thedungeon.exceptions.RepositorioException;
import com.willer.thedungeon.geral.personagem.Personagem;

import java.util.ArrayList;
import java.util.List;

public class TheDungeonFacade implements ITheDungeonFacade
{

   private static final PersonagemController personagemController = PersonagemController.getInstance();

   public void inserirPersonagem(Personagem p) throws RepositorioException
   {
      personagemController.inserir(p);
   }

   public void excluirPersonagem(int id) throws RepositorioException
   {
      personagemController.excluir(id);
   }

   public Personagem buscarPersonagem(int id) throws RepositorioException
   {
      return personagemController.buscarPorId(id);
   }

   @Override public List<Personagem> recuperaTodosPersonagens()
   {
      return personagemController.obtemListaPersonagens();
   }

}
