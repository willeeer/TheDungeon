package com.willer.thedungeon.factory;

import com.willer.thedungeon.exceptions.MenuException;
import com.willer.thedungeon.geral.personagem.Personagem;
import com.willer.thedungeon.geral.personagem.heroi.Arcanista;
import com.willer.thedungeon.geral.personagem.heroi.Paladino;
import com.willer.thedungeon.geral.personagem.heroi.Ranger;
import com.willer.thedungeon.geral.personagem.vilao.Alquimista;
import com.willer.thedungeon.geral.personagem.vilao.Assassino;
import com.willer.thedungeon.geral.personagem.vilao.DungeonMaster;

public class PersonagemFactory
{

   private static final String INTELIGENCIA = "INT";
   private static final String FORCA = "STR";
   private static final String AGILIDADE = "AGI";

   public Personagem getNewPersonagem(boolean isHeroi, String atributoPrincipal, String nome) throws MenuException
   {
      Personagem p = null;

      if (isHeroi)
      {
         if (atributoPrincipal.compareTo(INTELIGENCIA) == 0)
         {
            p = new Arcanista(nome);
         }
         else if (atributoPrincipal.compareTo(FORCA) == 0)
         {
            p = new Paladino(nome);
         }
         else if (atributoPrincipal.compareTo(AGILIDADE) == 0)
         {
            p = new Ranger(nome);
         }
         else
         {
            throw new MenuException("Tipo de atributo inválido");
         }
      }
      else
      {
         if (atributoPrincipal.compareTo(INTELIGENCIA) == 0)
         {
            p = new Alquimista(nome);
         }
         else if (atributoPrincipal.compareTo(FORCA) == 0)
         {
            p = new DungeonMaster(nome);
         }
         else if (atributoPrincipal.compareTo(AGILIDADE) == 0)
         {
            p = new Assassino(nome);
         }
         else
         {
            throw new MenuException("Tipo de atributo inválido");
         }

      }

      return p;
   }

}
