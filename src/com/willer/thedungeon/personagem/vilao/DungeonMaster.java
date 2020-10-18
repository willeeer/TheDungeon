package com.willer.thedungeon.personagem.vilao;

import com.willer.thedungeon.personagem.Personagem;

public class DungeonMaster extends Personagem
{

   public DungeonMaster(Integer id, String nome) {
      super(id, nome);
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
   }

   @Override
   public String getDescricaoPersonagem() {
      return "DungeonMaster: " + getNome() + "Nivel: " + getNivel();
   }
}
