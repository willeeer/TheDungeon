package com.willer.thedungeon.personagem.heroi;

import com.willer.thedungeon.personagem.IMagias;
import com.willer.thedungeon.personagem.Personagem;

public class Paladino extends Personagem implements IMagias
{

   @Override
   public Integer getAtributoPrincipal()
   {
      return getForca();
   }

   @Override
   public Integer calculaAtaque()
   {
      return getAtributoPrincipal() * 2 + getNivel();
   }

   @Override
   public Integer calculaDefesa()
   {
      return getForca() * 2 + getNivel();
   }

   @Override
   public void aumentarNivel()
   {
      setNivel(getNivel() + 1);
      setForca(getForca() + 5);
      setAgilidade(getAgilidade() + 2);
      setInteligencia(getInteligencia() + 2);

   }
}
