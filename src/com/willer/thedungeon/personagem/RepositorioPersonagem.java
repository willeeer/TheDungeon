package com.willer.thedungeon.personagem;

import java.util.ArrayList;
import java.util.List;

public class RepositorioPersonagem implements IRepositorioPersonagem
{

   private List<Personagem> listaPersonagens;

   public RepositorioPersonagem()
   {
      this.listaPersonagens = new ArrayList<>();
   }

   @Override
   public boolean inserir(Personagem p)
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
         return false;
      }
      else
      {
         this.listaPersonagens.add(p);
         return true;
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

   @Override
   public void listar() {
      for (Personagem p : this.listaPersonagens)
      {

         System.out.println(p.getDescricaoPersonagem());

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
