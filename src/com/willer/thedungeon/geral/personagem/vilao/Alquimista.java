package com.willer.thedungeon.geral.personagem.vilao;

public class Alquimista extends Vilao
{

   public Alquimista(String nome)
   {
      super(nome);
      setForca(10);
      setAgilidade(7);
      setInteligencia(15);
      setVidaAtual(100);
      setVidaMaxima(100);
   }

   @Override
   public void aumentarNivel()
   {
      setNivel(getNivel() + 1);
      setForca(getForca() + 3);
      setAgilidade(getAgilidade() + 2);
      setInteligencia(getInteligencia() + 5);
      setVidaMaxima(getVidaMaxima() + getAtributoPrincipal()*2);
      setVidaAtual(getVidaMaxima());
   }

   @Override
   public String getDescricaoPersonagem()
   {
      return "-------------------------\n"
               + "Alquimista: " + getNome() + "\n"
               + "Nivel: " + getNivel() + "\n"
               + "ID: " + getId() + "\n"
               + "-------------------------\n";
   }

   @Override
   public Integer getAtributoPrincipal()
   {
      return getInteligencia();
   }

   @Override
   public String getNomeMagiaPrincipal()
   {
      return "Poção aterrorizante.";
   }

   @Override
   public Integer getForcaMagiaPrincipal()
   {
      return calculaAtaque() + getInteligencia();
   }

   @Override
   public String getNomeMagiaEspecial()
   {
      return "Veneno Mortal";
   }

   @Override
   public Integer getForcaMagiaEspecial()
   {
      return calculaAtaque() + getInteligencia() * 2;
   }

}
