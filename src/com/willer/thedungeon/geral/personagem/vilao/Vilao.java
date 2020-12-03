package com.willer.thedungeon.geral.personagem.vilao;

import com.willer.thedungeon.geral.personagem.Personagem;

import java.util.Random;

public abstract class Vilao extends Personagem
{

   private static final Random random = new Random();

   public Vilao(String nome)
   {
      super(nome);
   }

   public int escolheAtaqueAleatorio()
   {
      return random.nextInt(3) + 1;
   }

   public int escolhePersonagemAleatorioParaAtacar()
   {
      return random.nextInt(3) + 1;

   }
}
