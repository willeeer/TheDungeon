package com.willer.thedungeon.personagem.vilao;

import com.willer.thedungeon.personagem.Personagem;

import java.util.Random;

public abstract class Vilao extends Personagem
{

   private static Random random = new Random();

   public Vilao(String nome)
   {
      super(nome);
   }

   public Integer escolheAtaqueAleatorio()
   {
      return random.nextInt(3) + 1;
   }

   public Integer escolhePersonagemAleatorioParaAtacar()
   {
      return random.nextInt(3) + 1;

   }
}
