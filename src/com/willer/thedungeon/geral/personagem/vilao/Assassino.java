package com.willer.thedungeon.geral.personagem.vilao;

public class Assassino extends Vilao
{

   public Assassino(String nome)
   {
      super(nome);
      setForca(7);
      setAgilidade(15);
      setInteligencia(10);
      setVidaAtual(100);
      setVidaMaxima(100);
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
               + "Assassino: " + getNome() + "\n"
               + "Nivel: " + getNivel() + "\n"
               + "ID: " + getId() + "\n"
               + "-------------------------\n";
   }

   @Override
   public String getNomeMagiaPrincipal()
   {
      return "Golpe Rápido";
   }

   @Override
   public int getForcaMagiaPrincipal()
   {
      return calculaAtaque() + getAtributoPrincipal();
   }

   @Override
   public String getNomeMagiaEspecial()
   {
      return "Adaga venenosa.";
   }

   @Override
   public int getForcaMagiaEspecial()
   {
      return calculaAtaque() + getAtributoPrincipal()*2;
   }
}
