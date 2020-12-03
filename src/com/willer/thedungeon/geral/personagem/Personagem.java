package com.willer.thedungeon.geral.personagem;

import com.willer.thedungeon.geral.IMagias;

public abstract class Personagem implements IMagias
{

   private int id;
   private String nome;
   private int nivel;
   private int forca;
   private int agilidade;
   private int inteligencia;
   private int vidaMaxima;
   private int vidaAtual;

   private static int ID_PERSONAGEM = 1;

   public Personagem(String nome)
   {
      this.id = ID_PERSONAGEM;
      this.nome = nome;
      this.nivel = 1;

      ID_PERSONAGEM++;
   }

   public abstract int getAtributoPrincipal();

   public abstract void aumentarNivel();

   public abstract String getDescricaoPersonagem();

   public int calculaAtaque()
   {
      return getAtributoPrincipal() * 2 + getNivel();
   }

   public int calculaDefesa()
   {
      return getForca() * 2 + getNivel();
   }

   public int getId()
   {
      return id;
   }

   public void setId(int id)
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

   public int getNivel()
   {
      return nivel;
   }

   public void setNivel(int nivel)
   {
      this.nivel = nivel;
   }

   public int getForca()
   {
      return forca;
   }

   public void setForca(int forca)
   {
      this.forca = forca;
   }

   public int getAgilidade()
   {
      return agilidade;
   }

   public void setAgilidade(int agilidade)
   {
      this.agilidade = agilidade;
   }

   public int getInteligencia()
   {
      return inteligencia;
   }

   public void setInteligencia(int inteligencia)
   {
      this.inteligencia = inteligencia;
   }

   public int getVidaMaxima()
   {
      return vidaMaxima;
   }

   public void setVidaMaxima(int vidaMaxima)
   {
      this.vidaMaxima = vidaMaxima;
   }

   public int getVidaAtual()
   {
      return vidaAtual;
   }

   public void setVidaAtual(int vidaAtual)
   {
      this.vidaAtual = vidaAtual;
   }

   public boolean isVivo()
   {
      //se vida Atual >0 o personagem está vivo, retorna true
      return vidaAtual > 0;
   }

   public String recuperaListaDeAtaques()
   {
      return "-------------------------\n" +
               "1- Ataque Normal \n" +
               "2- " + getNomeMagiaPrincipal() + "\n" +
               "3- " + getNomeMagiaEspecial() + "\n" +
               "-------------------------\n";
   }

   public static boolean isIndiceValidoDeAtaque(int indice)
   {
      return indice == 1 || indice == 2 || indice == 3;
   }

   public int getAtaqueMagiaEscolhida(int indice)
   {
      if (indice == 1)
      {
         return calculaAtaque();
      }
      else if (indice == 2)
      {
         return getForcaMagiaPrincipal();
      }
      else if (indice == 3)
      {
         return getForcaMagiaEspecial();
      }
      else
      {
         return 0;
      }
   }

   public String getNomeMagiaEscolhida(int indice)
   {
      if (indice == 1)
      {
         return "Ataque básico";
      }
      else if (indice == 2)
      {
         return getNomeMagiaPrincipal();
      }
      else if (indice == 3)
      {
         return getNomeMagiaEspecial();
      }
      else
      {
         return "";
      }
   }

}
