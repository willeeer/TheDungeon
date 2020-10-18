package com.willer.thedungeon.personagem.heroi;

import com.willer.thedungeon.personagem.Personagem;

public class Ranger extends Personagem
{

   public Ranger(Integer id, String nome) {
      super(id, nome);
      setForca(7);
      setAgilidade(15);
      setInteligencia(10);
      setVidaAtual(100);
      setVidaMaxima(100);
   }

   @Override public Integer getAtributoPrincipal()
   {
      return getAgilidade();
   }

   @Override public Integer calculaAtaque()
   {
      return getAtributoPrincipal() * 2 + getNivel();
   }

   @Override public Integer calculaDefesa()
   {
      return getForca() * 2 + getNivel();
   }

   @Override public void aumentarNivel()
   {
      setNivel(getNivel() + 1);
      setForca(getForca() + 3);
      setAgilidade(getAgilidade() + 5);
      setInteligencia(getInteligencia() + 2);
   }

   @Override
   public String getDescricaoPersonagem() {
      return "Ranger: " + getNome() + "Nivel: " + getNivel();
   }
}
