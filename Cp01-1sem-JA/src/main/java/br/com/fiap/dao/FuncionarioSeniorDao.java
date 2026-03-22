package br.com.fiap.dao;

import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.IdNaoEncontradoException;
import br.com.fiap.model.FuncionarioSenior;

public interface FuncionarioSeniorDao {

    void cadastrar(FuncionarioSenior funcionarioSenior);

    void atualizar(FuncionarioSenior funcionarioSenior) throws IdNaoEncontradoException;

    void remover(int id) throws IdNaoEncontradoException;

    FuncionarioSenior buscarPorId(int id) throws IdNaoEncontradoException;

    void commit() throws CommitException;
}
