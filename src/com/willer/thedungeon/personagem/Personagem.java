package com.willer.thedungeon.personagem;

import com.willer.thedungeon.magias.IMagias;

public abstract class Personagem implements IMagias
{

   private Integer id;
   private String nome;
   private Integer nivel;
   private Integer forca;
   private Integer agilidade;
   private Integer inteligencia;
   private Integer vidaMaxima;
   private Integer vidaAtual;

   private static Integer ID_PERSONAGEM = 1;

   public Personagem(String nome)
   {
      this.id = ID_PERSONAGEM;
      this.nome = nome;
      this.nivel = 1;

      ID_PERSONAGEM++;
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

   public static boolean isIndiceValidoDeAtaque(Integer indice)
   {
      return indice == 1 || indice == 2 || indice == 3;
   }

   public Integer getAtaqueMagiaEscolhida(Integer indice)
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

   public String getNomeMagiaEscolhida(Integer indice)
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
