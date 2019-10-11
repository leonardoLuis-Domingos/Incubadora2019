package dao;

import entidades.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PessoaDao {

    private EntityManager entityManager;

    public PessoaDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void insert(Pessoa pessoa){
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(pessoa);
        transaction.commit();
    }

    public Pessoa buscarPorId(long id){
        return entityManager.find(Pessoa.class, id);
    }

    public void update(Pessoa pessoa) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(pessoa);
        transaction.commit();
    }

    public void deleteById(Long id) {
        final EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        Pessoa pessoa = buscarPorId(id);
        entityManager.remove(pessoa);
        transaction.commit();
    }

}
