package com.willer.thedungeon.controller;

import com.willer.thedungeon.dados.RepositorioPersonagem;
import com.willer.thedungeon.exceptions.RepositorioException;
import com.willer.thedungeon.geral.personagem.Personagem;

import java.util.List;

public class PersonagemController
{

   private static PersonagemController instance;
   private static RepositorioPersonagem instanceRepoPersonagem;

   public static synchronized PersonagemController getInstance()
   {
      if (instance == null)
      {
         instance = new PersonagemController();
         instanceRepoPersonagem = RepositorioPersonagem.getInstance();
      }
      return instance;
   }

   public void inserir(Personagem p) throws RepositorioException
   {
      boolean jaExiste = false;
      if (p != null)
      {

         for (Personagem busca : instanceRepoPersonagem.getListaPersonagens())
         {
            if (p.getId() == (busca.getId()))
            {
               jaExiste = true;
               break;
            }
         }
      }
      else
      {
         throw new RepositorioException("Valor não permitido (null)");
      }

      if (jaExiste)
      {
         throw new RepositorioException("Este personagem já está inserido");
      }
      else
      {
         RepositorioPersonagem.getInstance().getListaPersonagens().add(p);
      }
   }

   public Personagem buscarPorId(int id) throws RepositorioException
   {
      Personagem p = instanceRepoPersonagem.buscarPorId(id);
      if (p == null)
      {
         throw new RepositorioException("Personagem não encontrado.");
      }
      return p;
   }

   public void excluir(int id) throws RepositorioException
   {
      if (this.buscarPorId(id) != null)
      {
         instanceRepoPersonagem.excluir(id);
      }
      else
      {
         throw new RepositorioException("Personagem não encontrado.");
      }
   }

   public List<Personagem> obtemListaPersonagens()
   {
      return instanceRepoPersonagem.getListaPersonagens();
   }

}
