package com.willer.thedungeon.geral.personagem.heroi;

import com.willer.thedungeon.geral.personagem.Personagem;

public class Arcanista extends Personagem
{

   public Arcanista(String nome)
   {
      super(nome);
      setForca(8);
      setAgilidade(7);
      setInteligencia(23);
      setVidaAtual(100);
      setVidaMaxima(100);
   }

   @Override
   public int getAtributoPrincipal()
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
      setVidaMaxima(getVidaMaxima() + getAtributoPrincipal() * 2);
      setVidaAtual(getVidaMaxima());
   }

   @Override
   public String getDescricaoPersonagem()
   {
      return "-------------------------\n"
               + "Arcanista: " + getNome() + "\n"
               + "Nivel: " + getNivel() + "\n"
               + "ID: " + getId() + "\n"
               + "-------------------------\n";
   }

   @Override
   public String getNomeMagiaPrincipal()
   {
      return "Raio Gélido";
   }

   @Override
   public int getForcaMagiaPrincipal()
   {
      return calculaAtaque() + getAtributoPrincipal();
   }

   @Override
   public String getNomeMagiaEspecial()
   {
      return "Torrente Arcana";
   }

   @Override
   public int getForcaMagiaEspecial()
   {
      return calculaAtaque() + getAtributoPrincipal() * 2;
   }
}
