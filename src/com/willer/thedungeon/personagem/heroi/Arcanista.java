package com.willer.thedungeon.personagem.heroi;

import com.willer.thedungeon.personagem.Personagem;

public class Arcanista extends Personagem
{

   public Arcanista(Integer id, String nome) {
      super(id, nome);
      setForca(10);
      setAgilidade(7);
      setInteligencia(15);
      setVidaAtual(100);
      setVidaMaxima(100);
   }

   @Override
   public Integer getAtributoPrincipal()
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
   }

   @Override
   public String getDescricaoPersonagem() {
      return "Arcanista: " + getNome() + "\nNivel: " + getNivel();
   }
}
