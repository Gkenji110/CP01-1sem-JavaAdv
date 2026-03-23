package br.com.fiap.dao;

import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.IdNaoEncontradoException;
import br.com.fiap.model.Funcionario;
import jakarta.persistence.EntityManager;

import java.util.List;

public class FuncionarioDaoImpl implements FuncionarioDao {

    private final EntityManager em;

    public FuncionarioDaoImpl(EntityManager em){
        this.em = em;
    }

    public void cadastrar(Funcionario funcionario) {
        em.persist(funcionario);
    }

    public void atualizar(Funcionario funcionario) {
        em.merge(funcionario);
    }

    public void remover(int id) throws IdNaoEncontradoException {
        Funcionario funcionario = buscarPorId(id);
        em.remove(funcionario);
    }

    public Funcionario buscarPorId(int id) throws IdNaoEncontradoException {
        Funcionario funcionario = em.find(Funcionario.class, id);
        if (funcionario == null)
            throw new IdNaoEncontradoException("Cliente nao encontrado");
        return funcionario;
    }

    public List<Funcionario> buscarTodos() {
        return em.createQuery("FROM Funcionario", Funcionario.class)
                .getResultList();
    }

    public void commit() throws CommitException {
        try {
            if (!em.getTransaction().isActive()) {
                em.getTransaction().begin();
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new CommitException();
        }
    }



}
