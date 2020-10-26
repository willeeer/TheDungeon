package com.willer.thedungeon.executor;

import com.willer.thedungeon.geral.Grupo;
import com.willer.thedungeon.personagem.Personagem;
import com.willer.thedungeon.personagem.RepositorioPersonagem;
import com.willer.thedungeon.personagem.heroi.Arcanista;
import com.willer.thedungeon.personagem.heroi.Paladino;
import com.willer.thedungeon.personagem.heroi.Ranger;
import com.willer.thedungeon.personagem.vilao.Alquimista;
import com.willer.thedungeon.personagem.vilao.Assassino;
import com.willer.thedungeon.personagem.vilao.DungeonMaster;
import com.willer.thedungeon.personagem.vilao.Vilao;

import java.util.List;
import java.util.Scanner;

public class ExecutorTheDungeon
{

   private static final Scanner scan = new Scanner(System.in);
   private static final RepositorioPersonagem repoPersonagem = new RepositorioPersonagem();

   private static Grupo grupoPrincipal;
   private static DungeonMaster dungeonMaster;
   private static Assassino assassino;
   private static Alquimista alquimista;

   public static void main(String[] args)
   {

      System.out.println("Bem vindo ao TheDungeon");

      inicializaDadosJogo();

      //Este pedaço de código é só para adiantar os testes
      grupoPrincipal = new Grupo();
      grupoPrincipal.adicionarPersonagem(new Arcanista("ArcTeste"));
      grupoPrincipal.adicionarPersonagem(new Ranger("RangerTest"));
      grupoPrincipal.adicionarPersonagem(new Paladino("PalaTeste"));
      //Este pedaço de código é só para adiantar os testes

      int escolhaMenu;

      do
      {

         System.out.println("---> Cadastrar Heroi - 1\n"
                  + "---> Lista Herois - 2\n"
                  + "---> Montar grupo - 3\n"
                  + "---> Inicar aventura! - 4\n"
                  + "---> Sair - 0");

         escolhaMenu = lervalorInteiroTeclado();

         switch (escolhaMenu)
         {
            case 1:
               cadastrarPersonagem();
               break;
            case 2:
               listarPersonagens();
               break;
            case 3:
               montarGrupo();
               break;
            case 4:
               inicarJogo();
               break;
            case 0:
               System.out.println("Saindo...");
               break;
            default:
               System.out.println("valor invalido");
               break;
         }

      }
      while (escolhaMenu != 0);

   }

   private static void inicarJogo()
   {
      if (executarFaseUm())
      {
         System.out.println("Fase Um concluida! \n Iniciando fase dois!\n");
         if (executarFaseDois())
         {
            System.out.println("Fase Dois concluida! \n Iniciando fase FINAL!\n");
            if (executarFaseFinal())
            {
               System.out.println("VITORIA!\n");
            }
            else
            {
               System.out.println("GAME OVER!\n");
            }

         }
         else
         {
            System.out.println("GAME OVER!\n");
         }
      }
      else
      {
         System.out.println("GAME OVER!\n");
      }
   }

   private static void inicializaDadosJogo()
   {
      repoPersonagem.inserir(new Arcanista("Bruxo"));
      repoPersonagem.inserir(new Arcanista("Gandalf"));
      repoPersonagem.inserir(new Arcanista("Mr m"));

      repoPersonagem.inserir(new Ranger("Arqueiro vesgo"));
      repoPersonagem.inserir(new Ranger("Legolas"));
      repoPersonagem.inserir(new Ranger("Qq coisa"));

      repoPersonagem.inserir(new Paladino("Paladino desnutrido"));
      repoPersonagem.inserir(new Paladino("ZZZZZZZZZZ"));
      repoPersonagem.inserir(new Paladino("QQ coisa 2"));

      //fase 1
      assassino = new Assassino("Kalec");
      assassino.aumentarNivel();

      //fase 2
      alquimista = new Alquimista("Albion");
      for (int i = 0; i < 2; i++)
      {
         alquimista.aumentarNivel();
      }

      //Fase final
      dungeonMaster = new DungeonMaster("Atos");
      for (int i = 0; i < 4; i++)
      {
         dungeonMaster.aumentarNivel();
      }
   }

   private static void montarGrupo()
   {
      grupoPrincipal = new Grupo();

      System.out.println("Montando grupo");
      System.out.println("O grupo é composto por 3 integrantes");
      System.out.println("Escolha os nomes dos personagens do seu grupo!");

      int escolha;
      int personagensAdicionados = 0;
      int idEscolhido;

      do
      {
         System.out.println("--> Listar Personagens - 1");
         System.out.println("--> Adicionar ao Grupo - 2");
         System.out.println("--> Sair - 0");

         escolha = lervalorInteiroTeclado();

         switch (escolha)
         {
            case 1:
               listarPersonagens();
               break;
            case 2:
               System.out.println("Digite o Id do personagem que deseja incluir no grupo.");
               idEscolhido = lervalorInteiroTeclado();

               Personagem p = repoPersonagem.buscarPorId(idEscolhido);
               if (p != null)
               {
                  grupoPrincipal.adicionarPersonagem(p);
                  System.out.printf("%s adicionado ao grupo com sucesso!\n", p.getNome());
                  personagensAdicionados++;
               }
               break;
            case 0:
               System.out.println("saindo");
               break;
            default:
               System.out.println("Valor invalido");
               break;
         }

      }
      while (personagensAdicionados < 3 && escolha != 0);

      System.out.println("Montagem de grupo concluida com sucesso!");
   }

   private static void listarPersonagens()
   {

      List<Personagem> listaPersonagens = repoPersonagem.getListaPersonagens();

      if (!listaPersonagens.isEmpty())
      {
         for (Personagem p : listaPersonagens)
         {

            System.out.println(p.getDescricaoPersonagem());

         }
      }
      else
      {
         System.out.println("Nenhum Personagem cadastrado.");
      }

   }

   private static void cadastrarPersonagem()
   {

      Personagem cadastro = null;

      System.out.println("Qual heroi deseja cadsatrar?");
      System.out.println("1- Arcanista, 2- Paladino, 3- Ranger");
      int tipoPersonagem = lervalorInteiroTeclado();

      System.out.println("Digite o nome do personagem");
      String nomePersongem = scan.nextLine();

      if (tipoPersonagem == 1)
      {

         cadastro = new Arcanista(nomePersongem);

      }
      else if (tipoPersonagem == 2)
      {
         cadastro = new Paladino(nomePersongem);

      }
      else if (tipoPersonagem == 3)
      {
         cadastro = new Ranger(nomePersongem);

      }
      else
      {
         System.out.println("Valor invalido.");
      }

      if (cadastro != null)
      {
         repoPersonagem.inserir(cadastro);
      }
   }

   public static Integer converteStringParaInteger(String texto)
   {

      try
      {
         return Integer.parseInt(texto);
      }
      catch (NumberFormatException exception)
      {
         System.out.println("ERRO: O texto passado nao equivale a um numero");
      }

      return null;
   }

   public static int lervalorInteiroTeclado()
   {

      Integer valorInteiro = null;

      while (valorInteiro == null)
      {
         String texto = scan.nextLine();

         valorInteiro = converteStringParaInteger(texto);

         if (valorInteiro == null)
         {
            System.out.println("Digite uma entrada valida(numeros)");
         }
      }

      return valorInteiro;
   }

   public static boolean executarFaseUm()
   {
      System.out.println("--------------------- Iniciando fase 1 ----------------------");
      System.out.println("----------- Iniciando batalha contra o Assassino! -----------\n");

      return executarBatalha(grupoPrincipal, assassino);
   }

   public static boolean executarFaseDois()
   {
      System.out.println("--------------------- Iniciando fase 2 -----------------------");
      System.out.println("----------- Iniciando batalha contra o Alquimista! -----------\n");

      return executarBatalha(grupoPrincipal, alquimista);
   }

   public static boolean executarFaseFinal()
   {
      System.out.println("--------------------- Iniciando fase FINAL -----------------------");
      System.out.println("----------- Iniciando batalha contra o Dungeon Master! -----------\n");

      return executarBatalha(grupoPrincipal, dungeonMaster);
   }

   public static boolean executarBatalha(Grupo grupo, Vilao vilao)
   {
      System.out.println("************************ INICIANDO BATALHA ************************\n");
      int turno = 0;
      int escolhaPesonagem;
      int escolhaAtaque;
      int escolhaDeAtaqueDoVilao;

      while (grupo.isGrupoVivo() && vilao.isVivo())
      {
         if (turno == 0)
         {

            System.out.println("Seu turno de atacar!");
            System.out.println("Atacar com qual pesonagem?");
            System.out.println(grupo.recuperaOpcoesDePesonagem());
            escolhaPesonagem = lervalorInteiroTeclado();

            if (grupo.isPersonagemEspecificoVivo(escolhaPesonagem))
            {
               do
               {
                  System.out.println("Escolha o ataque um ataque!");
                  System.out.println(grupo.recuperaAtaquesPersonagemEspecifico(escolhaPesonagem));
                  escolhaAtaque = lervalorInteiroTeclado();
               }
               while (!Personagem.isIndiceValidoDeAtaque(escolhaAtaque));

               realizarAtaque(grupo.getIntegranteEspecifico(escolhaPesonagem), vilao, escolhaAtaque);
               turno = 1;

            }
            else
            {
               System.out.println("O valor escolhido nao corresponde a um Personagem do grupo ou o Personagem escolhido está morto");
            }

         }
         else
         {
            System.out.println("Vez do inimigo atacar!");
            System.out.printf("O %s esta atacando!\n", vilao.getNome());
            do
            {
               escolhaDeAtaqueDoVilao = vilao.escolhePersonagemAleatorioParaAtacar();

            }
            while (!grupo.isPersonagemEspecificoVivo(escolhaDeAtaqueDoVilao));

            realizarAtaque(vilao, grupo.getIntegranteEspecifico(escolhaDeAtaqueDoVilao), vilao.escolheAtaqueAleatorio());

            turno = 0;
         }

         System.out.println(grupo.recuperaStatusGrupo());

         sleep();

      }

      System.out.println("************************ FIM DE BATALHA ************************\n");

      if (grupo.isGrupoVivo())
      {
         grupo.evoluir();
         return true;
      }
      else
      {
         return false;
      }

   }

   private static void sleep()
   {
      try
      {
         System.out.print("\n.");
         Thread.sleep(800);
         System.out.print(".");
         Thread.sleep(800);
         System.out.print(".");
         Thread.sleep(800);
         System.out.println("\n");
      }
      catch (InterruptedException e)
      {
         e.printStackTrace();
      }
   }

   private static void realizarAtaque(Personagem atacante, Personagem atacado, Integer indiceMagia)
   {
      System.out.println("--------------------------------");
      System.out.printf("O %s usou %s contra o %s!\n", atacante.getNome(), atacante.getNomeMagiaEscolhida(indiceMagia), atacado.getNome());
      Integer danoCausado = atacante.getAtaqueMagiaEscolhida(indiceMagia) - atacado.calculaDefesa();

      if (danoCausado < 0)
      {
         danoCausado = 0;
      }

      System.out.printf("Dano causado: %d\n", danoCausado);
      sleep();

      if (atacado.getVidaAtual() > danoCausado)
      {
         atacado.setVidaAtual(atacado.getVidaAtual() - danoCausado);
         System.out.printf("%s possui %d pontos de vida restantes\n", atacado.getNome(), atacado.getVidaAtual());
      }
      else
      {
         System.out.printf("%s morreu!\n", atacado.getNome());
         atacado.setVidaAtual(0);
      }
      sleep();
   }

}
