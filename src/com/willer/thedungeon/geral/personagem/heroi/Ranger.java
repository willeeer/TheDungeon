package com.willer.thedungeon.geral.personagem.heroi;

import com.willer.thedungeon.geral.personagem.Personagem;

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
   public int getAtributoPrincipal()
   {
      return getAgilidade();
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
      return "Raio Lunar";
   }

   @Override
   public int getForcaMagiaPrincipal()
   {
      return calculaAtaque() + getAtributoPrincipal();
   }

   @Override
   public String getNomeMagiaEspecial()
   {
      return "Onda Trovejante";
   }

   @Override
   public int getForcaMagiaEspecial()
   {
      return calculaAtaque() + (getAtributoPrincipal() * 2) - 5 * getNivel();
   }
}
