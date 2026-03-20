package br.com.fiap.dao;

import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.IdNaoEncontradoException;
import br.com.fiap.model.Funcionario;

public interface FuncionarioDao {

    void cadastrar(Funcionario funcionario);

    void atualizar(Funcionario funcionario) throws IdNaoEncontradoException;

    void remover(int id) throws IdNaoEncontradoException;

    Funcionario buscarPorId(int id) throws IdNaoEncontradoException;

    void commit() throws CommitException;

}
