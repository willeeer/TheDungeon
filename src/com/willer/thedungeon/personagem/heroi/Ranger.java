package com.willer.thedungeon.personagem.heroi;

import com.willer.thedungeon.personagem.Personagem;

public class Ranger extends Personagem
{

   public Ranger(String nome)
   {
      super(nome);
      setForca(10);
      setAgilidade(20);
      setInteligencia(10);
      setVidaAtual(120);
      setVidaMaxima(120);
   }

   @Override
   public Integer getAtributoPrincipal()
   {
      return getAgilidade();
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
      setForca(getForca() + 3);
      setAgilidade(getAgilidade() + 5);
      setInteligencia(getInteligencia() + 2);
      setVidaMaxima(getVidaMaxima() + getAtributoPrincipal()*2);
      setVidaAtual(getVidaMaxima());
   }

   @Override
   public String getDescricaoPersonagem()
   {
      return "-------------------------\n"
               + "Ranger: " + getNome() + "\n"
               + "Nivel: " + getNivel() + "\n"
               + "ID: " + getId() + "\n"
               + "-------------------------\n";
   }

   @Override
   public String getNomeMagiaPrincipal()
   {
      return "Magia Principal Ranger";
   }

   @Override
   public Integer getForcaMagiaPrincipal()
   {
      return calculaAtaque() + getAtributoPrincipal();
   }

   @Override
   public String getNomeMagiaEspecial()
   {
      return "Magia Especial Paladino";
   }

   @Override
   public Integer getForcaMagiaEspecial()
   {
      return calculaAtaque() + (getAtributoPrincipal() * 2) - 5 * getNivel();
   }
}
