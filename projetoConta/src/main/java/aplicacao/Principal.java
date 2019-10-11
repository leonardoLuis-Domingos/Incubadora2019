package aplicacao;

import dao.ContaDao;
import dao.PessoaDao;
import entidades.Conta;
import entidades.Pessoa;
import exceptions.SaldoInsuficienteException;
import servicos.ContaService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.text.ParseException;
import java.util.Scanner;

public class Principal {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcao = 0;
        do{
            System.out.println("Digite 1 para abrir uma conta");
            System.out.println("Digite 2 para listar conta");
            System.out.println("Digite 3 para Alterar conta");
            System.out.println("Digite 4 para fechar conta");
            System.out.println("Digite 5 para sacar");
            System.out.println("digite 6 para depositar");
            System.out.println("Digite 0 para sair");
            opcao = sc.nextInt();

            switch (opcao){

                case 1:
                    cadastro();
                    break;
                case 2:
                    exibir();
                    break;
                case 3:
                    alterar();
                    break;
                case 4:
                    System.out.println("Informe o número da id:");
                    Long idDeletar = sc.nextLong();

                    ContaService contaService = ContaService.getIntance();
                    contaService.deletar(idDeletar);
                    break;
                case 5:
                    sacar();
                    break;
                case 6:
                    depositar();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Valor digitado é invalida");
            }
        }while (opcao !=0);
    }

    public static void cadastro(){
        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("incubadora");
        final EntityManager entityManager = entityManagerFactory.createEntityManager();

        Scanner sc = new Scanner(System.in);

        System.out.println("Informe o nome:");
        String nome = sc.nextLine();
        String cpf;
        Boolean verifica = true;
            do{

                System.out.println("Informe o cpf:");
                cpf = sc.nextLine();
                verifica = Pessoa.valida(cpf);
                if(verifica == true){
                    System.out.println("sucesso");
                }else{

                    System.out.println("seu cpf é falso fdp");
                    verifica = false;
                }
            }while (verifica != true);


        System.out.println("Informe o saldo:");
        String saldoString = sc.nextLine();

        System.out.println("Informe o numero da conta:");
        Integer numero = sc.nextInt();

        try{
            Pessoa pessoa = new Pessoa(nome,cpf);
            PessoaDao pessoaDao = new PessoaDao(entityManager);
            pessoaDao.insert(pessoa);

            Conta conta = new Conta(numero, Double.parseDouble(saldoString),pessoa);
            ContaDao contaDao = new ContaDao(entityManager);
            contaDao.insert(conta);
        }catch (NumberFormatException e){
            System.out.println("Dados informados incorretamente");
        }catch (Exception e){
            System.out.println("Houve um erro ao cadastrar");
        }

    }

    public static void sacar(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe o valor do saque:");
        String saqueString = sc.nextLine();

        System.out.println("Informe o número da id:");
        Long idConta = sc.nextLong();

        ContaService contaService = ContaService.getIntance();

        try{
            contaService.sacar(idConta, Double.parseDouble(saqueString));
        }catch (SaldoInsuficienteException saldoInsuficienteException){
            System.out.println("A soma do Saldo e Limite é menor que o valor de saque desejado.");
        }catch (NumberFormatException e){
            System.out.println("O saldo foi informado incorretamente.");
        }

    }

    public static void depositar(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe o valor do deposito:");
        String depositoString = sc.nextLine();

        System.out.println("Informe o número da id:");
        Long idConta = sc.nextLong();

        ContaService contaService = ContaService.getIntance();

        try{
            contaService.depositar(idConta, Double.parseDouble(depositoString));
        }catch (NumberFormatException e){
            System.out.println("O saldo foi informado incorretamente.");
        }
    }

    public static void exibir(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe o número da id:");
        Long idPrintar = sc.nextLong();

        ContaService contaService = ContaService.getIntance();
        contaService.print(idPrintar);
    }

    public static void alterar(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe o número da id da conta que deseja alterar:");
        Long idAlterar = sc.nextLong();

        ContaService contaService = ContaService.getIntance();
        contaService.alterarConta(idAlterar);

    }



}
