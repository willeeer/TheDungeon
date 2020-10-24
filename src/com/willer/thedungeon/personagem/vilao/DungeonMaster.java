package com.willer.thedungeon.personagem.vilao;

public class DungeonMaster extends Vilao
{

   public DungeonMaster(String nome)
   {
      super(nome);
      setForca(15);
      setAgilidade(7);
      setInteligencia(7);
      setVidaAtual(100);
      setVidaMaxima(100);
   }

   @Override
   public Integer getAtributoPrincipal()
   {
      return getForca();
   }

   @Override
   public void aumentarNivel()
   {
      setNivel(getNivel() + 1);
      setForca(getForca() + 5);
      setAgilidade(getAgilidade() + 2);
      setInteligencia(getInteligencia() + 2);
      setVidaMaxima(getVidaMaxima() + getAtributoPrincipal()*2);
      setVidaAtual(getVidaMaxima());
   }

   @Override
   public String getDescricaoPersonagem()
   {
      return "DungeonMaster: " + getNome() + "\nNivel: " + getNivel();
   }

   @Override
   public String getNomeMagiaPrincipal()
   {
      return "Magia Principal Arcanista";
   }

   @Override
   public Integer getForcaMagiaPrincipal()
   {
      return calculaAtaque() + getAtributoPrincipal();
   }

   @Override
   public String getNomeMagiaEspecial()
   {
      return "Magia Especial Arcanista";
   }

   @Override
   public Integer getForcaMagiaEspecial()
   {
      return calculaAtaque() + getAtributoPrincipal() * 3;
   }
}
