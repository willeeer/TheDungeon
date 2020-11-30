package com.willer.thedungeon.geral.personagem.heroi;

import com.willer.thedungeon.geral.personagem.Personagem;

public class Paladino extends Personagem
{

   public Paladino(String nome)
   {
      super(nome);
      setForca(20);
      setAgilidade(7);
      setInteligencia(4);
      setVidaAtual(150);
      setVidaMaxima(150);
   }

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
      setVidaMaxima(getVidaMaxima() + getAtributoPrincipal() * 2);
      setVidaAtual(getVidaMaxima());
   }

   @Override
   public String getDescricaoPersonagem()
   {
      return "-------------------------\n"
               + "Paladino: " + getNome() + "\n"
               + "Nivel: " + getNivel() + "\n"
               + "ID: " + getId() + "\n"
               + "-------------------------\n";
   }

   @Override
   public String getNomeMagiaPrincipal()
   {
      return "Chicote de Espinhos";
   }

   @Override
   public Integer getForcaMagiaPrincipal()
   {
      return calculaAtaque() + getAtributoPrincipal();
   }

   @Override
   public String getNomeMagiaEspecial()
   {
      return "Chama Sagrada";
   }

   @Override
   public Integer getForcaMagiaEspecial()
   {
      return calculaAtaque() + (getAtributoPrincipal() * 2) - 10 * getNivel();
   }
}
