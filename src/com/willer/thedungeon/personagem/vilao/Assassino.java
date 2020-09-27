package com.willer.thedungeon.personagem.vilao;

import com.willer.thedungeon.personagem.Personagem;

public class Assassino extends Personagem
{

   @Override
   public Integer getAtributoPrincipal()
   {
      return getAgilidade();
   }
}
