package com.willer.thedungeon.personagem.vilao;

import com.willer.thedungeon.personagem.Personagem;

public class Alquimista extends Personagem
{
   public Alquimista(Integer id, String nome) {
      super(id, nome);
   }

   @Override
   public void aumentarNivel()
   {
      setNivel(getNivel() + 1);
      setForca(getForca() + 3);
      setAgilidade(getAgilidade() + 2);
      setInteligencia(getInteligencia() + 5);
   }

   @Override
   public String getDescricaoPersonagem() {
      return "Alquimista: " + getNome() + "Nivel: " + getNivel();
   }

   @Override
   public Integer getAtributoPrincipal()
   {
      return getInteligencia();
   }
}
