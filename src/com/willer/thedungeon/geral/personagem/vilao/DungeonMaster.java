package com.willer.thedungeon.geral.personagem.vilao;

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
   public int getAtributoPrincipal()
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
      return "-------------------------\n"
               + "DungeonMaster: " + getNome() + "\n"
               + "Nivel: " + getNivel() + "\n"
               + "ID: " + getId() + "\n"
               + "-------------------------\n";
   }

   @Override
   public String getNomeMagiaPrincipal()
   {
      return "Chamas Negras";
   }

   @Override
   public int getForcaMagiaPrincipal()
   {
      return calculaAtaque() + getAtributoPrincipal();
   }

   @Override
   public String getNomeMagiaEspecial()
   {
      return "Obliteração";
   }

   @Override
   public int getForcaMagiaEspecial()
   {
      return calculaAtaque() + getAtributoPrincipal() * 3;
   }
}
