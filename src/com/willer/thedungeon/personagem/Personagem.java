package com.willer.thedungeon.personagem;

import com.willer.thedungeon.magias.IMagias;

public abstract class Personagem
{

   private Integer id;
   private String nome;
   private Integer nivel;
   private Integer forca;
   private Integer agilidade;
   private Integer inteligencia;
   private Integer vidaMaxima;
   private Integer vidaAtual;

   public Personagem() {
   }

   public Personagem(Integer id, String nome) {
      this.id = id;
      this.nome = nome;
      this.nivel = 1;
   }

   public abstract Integer getAtributoPrincipal();
   public abstract void aumentarNivel();
   public abstract String getDescricaoPersonagem();


   public Integer calculaAtaque()
   {
      return getAtributoPrincipal() * 2 + getNivel();
   }

   public Integer calculaDefesa()
   {
      return getForca() * 2 + getNivel();
   }

   public Integer getId()
   {
      return id;
   }

   public void setId(Integer id)
   {
      this.id = id;
   }

   public String getNome()
   {
      return nome;
   }

   public void setNome(String nome)
   {
      this.nome = nome;
   }

   public Integer getNivel()
   {
      return nivel;
   }

   public void setNivel(Integer nivel)
   {
      this.nivel = nivel;
   }

   public Integer getForca()
   {
      return forca;
   }

   public void setForca(Integer forca)
   {
      this.forca = forca;
   }

   public Integer getAgilidade()
   {
      return agilidade;
   }

   public void setAgilidade(Integer agilidade)
   {
      this.agilidade = agilidade;
   }

   public Integer getInteligencia()
   {
      return inteligencia;
   }

   public void setInteligencia(Integer inteligencia)
   {
      this.inteligencia = inteligencia;
   }

   public Integer getVidaMaxima()
   {
      return vidaMaxima;
   }

   public void setVidaMaxima(Integer vidaMaxima)
   {
      this.vidaMaxima = vidaMaxima;
   }

   public Integer getVidaAtual()
   {
      return vidaAtual;
   }

   public void setVidaAtual(Integer vidaAtual)
   {
      this.vidaAtual = vidaAtual;
   }

}
