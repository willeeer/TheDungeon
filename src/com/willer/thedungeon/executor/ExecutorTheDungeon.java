package com.willer.thedungeon.executor;

import com.willer.thedungeon.personagem.Personagem;

public class ExecutorTheDungeon
{

   public static void main(String[] args)
   {

   }

   private static void realizarAtaque(Personagem p1, Personagem p2)
   {

      Integer danoCausado = p1.calculaAtaque() - p2.calculaDefesa();

      if (p2.getVidaAtual() > danoCausado)
      {
         p2.setVidaAtual(p2.getVidaAtual() - danoCausado);
      }
      else
      {
         p2.setVidaAtual(0);
      }
   }

}
