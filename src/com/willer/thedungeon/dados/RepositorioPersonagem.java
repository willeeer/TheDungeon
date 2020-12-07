package com.willer.thedungeon.dados;

import java.util.ArrayList;
import java.util.List;

import com.willer.thedungeon.exceptions.RepositorioException;
import com.willer.thedungeon.geral.personagem.Personagem;

public class RepositorioPersonagem implements IRepositorioPersonagem
{

   private static RepositorioPersonagem instance;

   private List<Personagem> listaPersonagens;

   private RepositorioPersonagem()
   {
      this.listaPersonagens = new ArrayList<>();
   }

   public static synchronized RepositorioPersonagem getInstance()
   {
      if (instance == null)
      {
         instance = new RepositorioPersonagem();
      }
      return instance;
   }

   @Override
   public void inserir(Personagem p) throws RepositorioException
   {
         this.listaPersonagens.add(p);
   }

   @Override
   public Personagem buscarPorId(int id)
   {
      for (Personagem p : this.listaPersonagens)
      {
         if (p.getId() == (id))
         {
            return p;
         }
      }
      return null;
   }

   @Override
   public void excluir(int id)
   {
      listaPersonagens.remove(buscarPorId(id));
   }

   public List<Personagem> getListaPersonagens()
   {
      return listaPersonagens;
   }

   public void setListaPersonagens(List<Personagem> listaPersonagens)
   {
      this.listaPersonagens = listaPersonagens;
   }

}
