package com.willer.thedungeon.personagem;

import java.util.ArrayList;
import java.util.List;

import com.willer.thedungeon.exceptions.RepositorioException;

public class RepositorioPersonagem implements IRepositorioPersonagem
{

   private List<Personagem> listaPersonagens;

   public RepositorioPersonagem()
   {
      this.listaPersonagens = new ArrayList<>();
   }

   @Override
   public void inserir(Personagem p) throws RepositorioException
   {
      boolean jaExiste = false;
      if (p != null)
      {

         for (Personagem busca : this.listaPersonagens)
         {
            if (p.getId().equals(busca.getId()))
            {
               jaExiste = true;
               break;
            }
         }
      }

      if (jaExiste)
      {
    	 throw new RepositorioException("Este personagem já está inserido");
      }
      else
      {
         this.listaPersonagens.add(p);
      }

   }

   @Override
   public Personagem buscarPorId(Integer id)
   {
      for (Personagem p : this.listaPersonagens)
      {
         if (p.getId().equals(id))
         {
            return p;
         }
      }

      return null;
   }

   @Override
   public void excluir(Integer id)
   {
      for (Personagem p : this.listaPersonagens)
      {
         if (p.getId().equals(id))
         {
            listaPersonagens.remove(p);
            break;
         }
      }

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
