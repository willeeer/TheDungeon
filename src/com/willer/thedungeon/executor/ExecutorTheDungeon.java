package com.willer.thedungeon.executor;

import com.willer.thedungeon.controller.PersonagemController;
import com.willer.thedungeon.dados.RepositorioPersonagem;
import com.willer.thedungeon.exceptions.MenuException;
import com.willer.thedungeon.exceptions.RepositorioException;
import com.willer.thedungeon.geral.Grupo;
import com.willer.thedungeon.geral.personagem.Personagem;
import com.willer.thedungeon.geral.personagem.heroi.Arcanista;
import com.willer.thedungeon.geral.personagem.heroi.Paladino;
import com.willer.thedungeon.geral.personagem.heroi.Ranger;
import com.willer.thedungeon.geral.personagem.vilao.Alquimista;
import com.willer.thedungeon.geral.personagem.vilao.Assassino;
import com.willer.thedungeon.geral.personagem.vilao.DungeonMaster;
import com.willer.thedungeon.geral.personagem.vilao.Vilao;

import java.util.List;
import java.util.Scanner;

public class ExecutorTheDungeon
{

   private static final Scanner scan = new Scanner(System.in);
   private static final RepositorioPersonagem repoPersonagem = RepositorioPersonagem.getInstance();
   private static final PersonagemController personagemController = PersonagemController.getInstance();

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
                  + "---> Excluir Heroi - 4\n"
                  + "---> Inicar aventura! - 5\n"
                  + "---> Sair - 0");

         escolhaMenu = lervalorInteiroTeclado();

         try
         {
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
                  excluirPersonagem();
                  break;
               case 5:
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
         catch (MenuException e)
         {
            System.out.println(e.getMessage());

         }
         catch (RepositorioException e)
         {
            System.out.println(e.getMessage());
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
      try
      {
         personagemController.inserir(new Arcanista("Bruxo"));
         personagemController.inserir(new Arcanista("Gandalf"));
         personagemController.inserir(new Arcanista("Mr.M"));

         personagemController.inserir(new Ranger("Arqueiro vesgo"));
         personagemController.inserir(new Ranger("Legolas"));
         personagemController.inserir(new Ranger("Mago Clérigo"));

         personagemController.inserir(new Paladino("Paladino desnutrido"));
         personagemController.inserir(new Paladino("Paladino de baixo orçamento"));
         personagemController.inserir(new Paladino("Mago Gladiador"));
      }
      catch (RepositorioException e)
      {
         System.out.println(e.getMessage());
      }
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

   private static void montarGrupo() throws MenuException
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
               try
               {
                  listarPersonagens();
               }
               catch (RepositorioException e)
               {
                  System.out.println(e.getMessage());
               }
               break;
            case 2:
               System.out.println("Digite o Id do personagem que deseja incluir no grupo.");
               idEscolhido = lervalorInteiroTeclado();

               try {
                  Personagem p = personagemController.buscarPorId(idEscolhido);

                  if (p != null)
                  {
                     grupoPrincipal.adicionarPersonagem(p);
                     System.out.printf("%s adicionado ao grupo com sucesso!\n", p.getNome());
                     personagensAdicionados++;
                  }
                  }
               catch (RepositorioException e){
                  System.out.println(e.getMessage());
               }
               break;
            case 0:
               System.out.println("saindo");
               break;
            default:
               throw new MenuException("Valor inv�lido");
         }

      }
      while (personagensAdicionados < 3 && escolha != 0);

      System.out.println("Montagem de grupo concluida com sucesso!");
   }

   private static void listarPersonagens() throws RepositorioException
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
         throw new RepositorioException("Nenhum Personagem cadastrado.");
      }

   }

   private static void cadastrarPersonagem() throws MenuException
   {

      Personagem cadastro = null;

      System.out.println("Qual heroi deseja cadsatrar?");
      System.out.println("1- Arcanista, 2- Paladino, 3- Ranger");
      int tipoPersonagem = lervalorInteiroTeclado();

      System.out.println("Digite o nome do personagem");

      String nomePersongem = scan.nextLine();
      //nomePersongem = null;
      if (tipoPersonagem == 1)
      {
         if (nomePersongem == null)
         {
            cadastro = new Arcanista("O sem nome");
         }
         else
         {
            cadastro = new Arcanista(nomePersongem);
         }

      }
      else if (tipoPersonagem == 2)
      {
         if (nomePersongem == null)
         {
            cadastro = new Paladino("Não identificado");
         }
         else
         {
            cadastro = new Paladino(nomePersongem);
         }

      }
      else if (tipoPersonagem == 3)
      {

         if (nomePersongem == null)
         {
            cadastro = new Ranger("Tão brabo que não tem nome");
         }
         else
         {
            cadastro = new Ranger(nomePersongem);
         }

      }
      else
      {
         throw new MenuException("Valor Inválido");
      }

      if (cadastro != null)
      {
         try
         {
            personagemController.inserir(cadastro);
         }
         catch (RepositorioException e)
         {
            System.out.println(e.getMessage());
         }
      }
   }

   private static void excluirPersonagem() throws RepositorioException{
      try {
         System.out.println("Insira o id do personagem a ser excluido: ");
         int id = lervalorInteiroTeclado();
         personagemController.excluir(id);
         System.out.printf("Personagem de ID %d excluido com sucesso.\n", id);
      }
      catch(RepositorioException e){
         System.out.println(e.getMessage());
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
                  System.out.println("Escolha um ataque!");
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

   private static void realizarAtaque(Personagem atacante, Personagem atacado, int indiceMagia)
   {
      System.out.println("--------------------------------");
      System.out.printf("O %s usou %s contra o %s!\n", atacante.getNome(), atacante.getNomeMagiaEscolhida(indiceMagia), atacado.getNome());
      int danoCausado = atacante.getAtaqueMagiaEscolhida(indiceMagia) - atacado.calculaDefesa();

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
