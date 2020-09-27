package com.willer.thedungeon.personagem.vilao;

import com.willer.thedungeon.personagem.Personagem;

public class Alquimista extends Personagem
{

   @Override
   public Integer getAtributoPrincipal()
   {
      return getInteligencia();
   }
}
