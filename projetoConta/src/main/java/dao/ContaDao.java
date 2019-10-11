package dao;

import entidades.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ContaDao {

    private EntityManager entityManager;

    public ContaDao(){

    }

    public ContaDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void insert(Conta conta){
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(conta);
        transaction.commit();
    }

    public Conta buscarPorId(long id){
        return entityManager.find(Conta.class, id);
    }

    public void update(Conta conta) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(conta);
        transaction.commit();
    }

    public void deleteById(Long id) {
        final EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        Conta conta = buscarPorId(id);
        entityManager.remove(conta);
        transaction.commit();
    }


}
