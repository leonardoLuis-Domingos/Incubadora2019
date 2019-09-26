package aplicacao;
import entidades.Pessoa;
import entidades.Time;
import servicos.Arquivo;

import java.util.Scanner;

public class Tela {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Sistema De cadastro");
        menuPrincipal();
    }

    public static void menuPrincipal(){
        Scanner sc = new Scanner(System.in);
        int menuPrincipal;
        do{
            System.out.println("Menu");
            System.out.println("Digite 1- Time");
            System.out.println("Digite 2- Pessoa");
            System.out.println("Digite 3- Sair");
            menuPrincipal = sc.nextInt();

            switch (menuPrincipal){

                case 1:
                    menuTime();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opção invalida");
            }
        }while (menuPrincipal != 3);
    }

    public static void menuTime(){

        Scanner sc = new Scanner(System.in);
        Time  time = new Time();
        int menuTime;
        do{
            System.out.println("Menu");
            System.out.println("Digite 1- Cadastrar");
            System.out.println("Digite 2- Listar");
            System.out.println("Digite 3- Remover");
            System.out.println("Digite 4- Alterar");
            System.out.println("Digite 5- Voltar Para O Menu Principal");
            menuTime = sc.nextInt();
            sc.nextLine();

            switch (menuTime){

                case 1:
                    System.out.println("Digite o Nome do Time");
                    String nomeTime = sc.nextLine();
                    time = new Time(nomeTime);
                    time.salvaTime();
                    break;
                case 2:
                    time.listaTime();
                    break;
                case 3:
                    time.removeTime();
                    break;
                case 4:
                    time.alteraTime();
                    break;
                case 5:
                    menuPrincipal();
                    break;
                default:
                    System.out.println("Opção invalida");
            }
        }while (menuTime != 3);
    }

    public static void menuPessoa(){

        Scanner sc = new Scanner(System.in);
        Pessoa pessoa = new Pessoa();
        int menuPessoa;
        do{
            System.out.println("Menu");
            System.out.println("Digite 1- Cadastrar");
            System.out.println("Digite 2- Listar");
            System.out.println("Digite 3- Remover");
            System.out.println("Digite 4- Alterar");
            System.out.println("Digite 5- Voltar Para O Menu Principal");
            menuPessoa = sc.nextInt();
            sc.nextLine();

            switch (menuPessoa){

                case 1:
                    System.out.println("Digite o Nome da Pessoa ");
                    String nomePessoa = sc.nextLine();
                    System.out.println("Digite o Nome do Time ");
                    String nomeTime = sc.nextLine();
                    pessoa = new Pessoa(nomePessoa,nomeTime);
                    pessoa.salvarPessoa();
                    break;
                case 2:
                    pessoa.listaPessoa();
                    break;
                case 3:
                    pessoa.removePessoa();
                    break;
                case 4:
                    break;
                case 5:
                    menuPrincipal();
                    break;
                default:
                    System.out.println("Opção invalida");
            }
        }while (menuPessoa!= 3);
    }


}
