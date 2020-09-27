package com.willer.thedungeon.personagem.heroi;

import com.willer.thedungeon.personagem.IMagias;
import com.willer.thedungeon.personagem.Personagem;

public class Arcanista extends Personagem implements IMagias
{

   @Override
   public Integer getAtributoPrincipal()
   {
      return getInteligencia();
   }

   @Override
   public void aumentarNivel()
   {
      setNivel(getNivel() + 1);
      setForca(getForca() + 3);
      setAgilidade(getAgilidade() + 2);
      setInteligencia(getInteligencia() + 5);
   }
}
