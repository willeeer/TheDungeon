package com.willer.thedungeon.geral;

import com.willer.thedungeon.geral.personagem.Personagem;

import java.util.Arrays;
import java.util.List;

public class Grupo
{

   private Personagem integranteUm;
   private Personagem integranteDois;
   private Personagem integranteTres;

   private static final List<Integer> inidicesValidos = Arrays.asList(1, 2, 3);

   public Grupo(Personagem integranteUm, Personagem integranteDois, Personagem integranteTres)
   {
      this.integranteUm = integranteUm;
      this.integranteDois = integranteDois;
      this.integranteTres = integranteTres;
   }

   public Grupo()
   {
   }

   public Personagem getIntegranteUm()
   {
      return integranteUm;
   }

   public void setIntegranteUm(Personagem integranteUm)
   {
      this.integranteUm = integranteUm;
   }

   public Personagem getIntegranteDois()
   {
      return integranteDois;
   }

   public void setIntegranteDois(Personagem integranteDois)
   {
      this.integranteDois = integranteDois;
   }

   public Personagem getIntegranteTres()
   {
      return integranteTres;
   }

   public void setIntegranteTres(Personagem integranteTres)
   {
      this.integranteTres = integranteTres;
   }

   public String getDescricaoGrupo()
   {
      return "------------------------------------------" +
               integranteUm.getDescricaoPersonagem() +
               integranteDois.getDescricaoPersonagem() +
               integranteTres.getDescricaoPersonagem() +
               "------------------------------------------";

   }

   public Personagem getIntegranteEspecifico(int integrante)
   {
      switch (integrante)
      {
         case 1:
            return integranteUm;
         case 2:
            return integranteDois;
         case 3:
            return integranteTres;
         default:
            return null;
      }
   }

   public void adicionarPersonagem(Personagem p)
   {

      if (integranteUm == null)
      {
         integranteUm = p;
      }
      else
      {
         if (integranteDois == null)
         {
            integranteDois = p;
         }
         else
         {
            if (integranteTres == null)
            {
               integranteTres = p;
            }
         }
      }
   }

   public boolean isGrupoVivo()
   {
      //Se ao menos um personagem estiver vivo, o grupo ainda esta vivo
      return integranteUm.isVivo() || integranteDois.isVivo() || integranteTres.isVivo();
   }

   public String recuperaOpcoesDePesonagem()
   {
      String opcoes = "";

      if (isGrupoVivo())
      {
         if (integranteUm.isVivo())
         {
            opcoes = opcoes + "1- " + integranteUm.getNome() + "\n";
         }

         if (integranteDois.isVivo())
         {
            opcoes = opcoes + "2- " + integranteDois.getNome() + "\n";
         }

         if (integranteTres.isVivo())
         {
            opcoes = opcoes + "3- " + integranteTres.getNome() + "\n";
         }
      }
      else
      {
         opcoes = opcoes + "Nenhum personagem vivo";
      }

      return opcoes;
   }

   public boolean isPersonagemEspecificoVivo(int indice)
   {

      if (inidicesValidos.contains(indice))
      {

         if (indice == 1)
         {
            return integranteUm.isVivo();
         }
         else if (indice == 2)
         {
            return integranteDois.isVivo();

         }
         else if (indice == 3)
         {
            return integranteTres.isVivo();

         }
         else
         {
            return false;
         }
      }
      else
      {
         return false;
      }
   }

   public String recuperaAtaquesPersonagemEspecifico(int indice)
   {
      if (inidicesValidos.contains(indice))
      {

         if (indice == 1)
         {
            return integranteUm.recuperaListaDeAtaques();
         }
         else if (indice == 2)
         {
            return integranteDois.recuperaListaDeAtaques();

         }
         else if (indice == 3)
         {
            return integranteTres.recuperaListaDeAtaques();

         }
         else
         {
            return "";
         }
      }
      else
      {
         return "";
      }
   }

   public void evoluir()
   {
      integranteUm.aumentarNivel();
      integranteDois.aumentarNivel();
      integranteTres.aumentarNivel();
   }

   public String recuperaStatusGrupo()
   {
      return "----- Status do Grupo ------\n" +
               "1- " + integranteUm.getNome() + "\n" +
               "Vida - " + integranteUm.getVidaAtual() + "\n" +
               "2- " + integranteDois.getNome() + "\n" +
               "Vida - " + integranteDois.getVidaAtual() + "\n" +
               "3- " + integranteTres.getNome() + "\n" +
               "Vida - " + integranteTres.getVidaAtual() + "\n" +
               "----------------------------";
   }
}
