package servicos;

import dao.ContaDao;
import entidades.Conta;
import exceptions.SaldoInsuficienteException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class ContaService {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("incubadora");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();

    private static ContaService uniqueInstance;

    private ContaService(){}

    //Padrao de projeto SINGLETON
    public static ContaService getIntance(){
        if (uniqueInstance == null){
            uniqueInstance = new ContaService();
        }

        return uniqueInstance;
    }

    public void sacar(Long contaId, double saque) throws SaldoInsuficienteException{

        ContaDao contaDao = new ContaDao(entityManager);

        Conta conta = contaDao.buscarPorId(contaId);

        conta.sacar(saque);

        contaDao.update(conta);
    }

    public void depositar(Long contaId, double deposito) throws SaldoInsuficienteException{

        ContaDao contaDao = new ContaDao(entityManager);

        Conta conta = contaDao.buscarPorId(contaId);

        conta.depositar(deposito);

        contaDao.update(conta);
    }

    public void print(Long contaId) {

        ContaDao contaDao = new ContaDao(entityManager);

        Conta conta = contaDao.buscarPorId(contaId);

        System.out.println(conta.toString());
    }

    public void deletar(Long contaId){

        ContaDao contaDao = new ContaDao(entityManager);

        contaDao.deleteById(contaId);
    }

    public void alterarConta(long id) throws SaldoInsuficienteException{
        ContaDao contaDao = new ContaDao(entityManager);
        Conta conta = contaDao.buscarPorId(id);

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o novo nome da pessoa");
        String novoNome = sc.nextLine();
        System.out.println("Digite o novo numero da conta");
        int novoNumero = sc.nextInt();

        conta.getPessoa().setNome(novoNome);
        conta.setNumero(novoNumero);
        contaDao.update(conta);
    }


}
