package com.willer.thedungeon.executor;

import com.sun.xml.internal.bind.v2.model.core.ID;
import com.willer.thedungeon.geral.Grupo;
import com.willer.thedungeon.personagem.Personagem;
import com.willer.thedungeon.personagem.RepositorioPersonagem;
import com.willer.thedungeon.personagem.heroi.Arcanista;
import com.willer.thedungeon.personagem.heroi.Paladino;
import com.willer.thedungeon.personagem.heroi.Ranger;
import com.willer.thedungeon.personagem.vilao.Alquimista;
import com.willer.thedungeon.personagem.vilao.Assassino;
import com.willer.thedungeon.personagem.vilao.DungeonMaster;

import java.util.Scanner;

public class ExecutorTheDungeon {
    private static Scanner scan = new Scanner(System.in);
    private static int ID_PERSONAGEM = 1;
    private static final RepositorioPersonagem repoPersonagem = new RepositorioPersonagem();
    private static Grupo grupoPrincipal = new Grupo();

    private static DungeonMaster dungeonMaster;
    private static Assassino assassino;
    private static Alquimista alquimista;


    public static void main(String[] args) {



        System.out.println("Bem vindo ao TheDungeon");
        System.out.println("Escolha os nomes dos personagens do seu grupo!");

        iniciaDadosJogo();


        int escolhaMenu = 0;

        do {

            System.out.println("---> Cadastrar Heroi - 1");
            System.out.println("---> Lista Herois - 2");
            System.out.println("---> Montar grupo - 3");
            System.out.println("---> Inicar aventura! - 4");

            escolhaMenu = lervalorInteiroTeclado();

            switch (escolhaMenu) {
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
                case 0:
                    System.out.println("Saindo...");
                default:
                    System.out.println("valor invalido");
            }

        } while (escolhaMenu != 0);


    }

    private static void inicarJogo() {
    }

    private static void iniciaDadosJogo() {

        //fase 1
        assassino = new Assassino(ID_PERSONAGEM, "Kalec");
        assassino.aumentarNivel();

        //fase 2
        alquimista = new Alquimista(ID_PERSONAGEM, "Albion");
        for(int i=0; i< 4;i++){
            alquimista.aumentarNivel();
        }

        //Fase final
        dungeonMaster = new DungeonMaster(ID_PERSONAGEM, "Atos");
        for(int i=0; i< 7;i++){
            dungeonMaster.aumentarNivel();
        }
    }

    private static void montarGrupo() {
        System.out.println("Montando grupo");
        System.out.println("O grupo é composto por 3 integrantes");
        int idPersonagem ;
        int escolha;
        int persoNagensAdd = 0;
        int idEscolhido;

        do{
            System.out.println("--> Listar Personagens - 1");
            System.out.println("--> Adicionar ao Grupo - 2");
            System.out.println("--> Sair - 0");

            escolha = lervalorInteiroTeclado();

            switch (escolha){
                case 1:
                    listarPersonagens();
                    break;
                case 2:
                    System.out.println("Digite o Id do personagem que deseja incluir no grupo.");
                    idEscolhido = lervalorInteiroTeclado();

                    Personagem p = repoPersonagem.buscarPorId(idEscolhido);
                    if(p!= null){
                        grupoPrincipal.adicionarPersonagem(p);
                        persoNagensAdd++;
                    }
                    break;
                case 0:
                    System.out.println("saindo");
                    break;
                default:
                    System.out.println("Valor invalido");
                    break;
            }

        }while(persoNagensAdd < 3 || escolha != 0);
    }

    private static void listarPersonagens() {
        repoPersonagem.listar();
    }

    private static void cadastrarPersonagem() {

        Personagem cadastro = null;

        System.out.println("Qual heroi deseja cadsatrar?");
        System.out.println("1- Arcanista, 2- Paladino, 3- Ranger");
        int tipoPersonagem = lervalorInteiroTeclado();

        System.out.println("Digite o nome do personagem");
        String nomePersongem = scan.nextLine();

        if (tipoPersonagem == 1) {

            cadastro = new Arcanista(ID_PERSONAGEM, nomePersongem);

        } else if (tipoPersonagem == 2) {
            cadastro = new Paladino(ID_PERSONAGEM, nomePersongem);

        } else if (tipoPersonagem == 3) {
            cadastro = new Ranger(ID_PERSONAGEM, nomePersongem);

        } else {
            System.out.println("Valor invalido.");
        }

        if(cadastro != null) {
            repoPersonagem.inserir(cadastro);
            ID_PERSONAGEM++;
        }
    }

    private static void realizarAtaque(Personagem p1, Personagem p2) {

        Integer danoCausado = p1.calculaAtaque() - p2.calculaDefesa();

        if (p2.getVidaAtual() > danoCausado) {
            p2.setVidaAtual(p2.getVidaAtual() - danoCausado);
        } else {
            p2.setVidaAtual(0);
        }
    }


    public static Integer converteStringParaInteger(String texto) {

        try {
            return Integer.parseInt(texto);
        } catch (NumberFormatException exception) {
            System.out.println("ERRO: O texto passado nao equivale a um numero");
        }

        return null;
    }

    public static int lervalorInteiroTeclado() {

        Integer valorInteiro = null;

        while (valorInteiro == null) {
            String texto = scan.nextLine();

            valorInteiro = converteStringParaInteger(texto);

            if (valorInteiro == null) {
                System.out.println("Digite uma entrada valida(numeros)");
            }
        }

        return valorInteiro;
    }

    public static boolean executarFaseUm(){
        return false;
    }

    public static boolean executarFaseDois(){
        return false;
    }

    public static boolean executarFaseFinal(){
        return false;
    }

}
