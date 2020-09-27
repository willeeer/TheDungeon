package com.willer.thedungeon.personagem.vilao;

import com.willer.thedungeon.personagem.Personagem;

public class DungeonMaster extends Personagem
{

   @Override public Integer getAtributoPrincipal()
   {
      return getForca();
   }
}
