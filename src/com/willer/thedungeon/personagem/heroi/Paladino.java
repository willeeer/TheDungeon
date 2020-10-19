package com.willer.thedungeon.personagem.heroi;

import com.willer.thedungeon.magias.Magia;
import com.willer.thedungeon.personagem.Personagem;

public class Paladino extends Personagem
{

   public Paladino(Integer id, String nome) {
      super(id, nome);
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
   }

   @Override
   public String getDescricaoPersonagem() {
      return "Paladino: " + getNome() + "\nNivel: " + getNivel();
   }
}
