package br.com.fiap.view;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import br.com.fiap.dao.FuncionarioDao;
import br.com.fiap.dao.FuncionarioDaoImpl;
import br.com.fiap.model.Funcionario;
import br.com.fiap.exception.IdNaoEncontradoException;
import br.com.fiap.exception.CommitException;

public class TesteDao {

    //Implementar o CRUD com o DAO
    public static void main(String[] args) {
        //Criar a fabrica
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");

        //Criar o Entity manager
        EntityManager em = fabrica.createEntityManager();

        //Instanciar o DAO
        FuncionarioDao dao = new FuncionarioDaoImpl(em);

        //Cadastrar um Funcionário (CREATE -> INSERT)
        Funcionario funcionario = new Funcionario("Geraldo", 160.0, 50.0);

        try {
            dao.cadastrar(funcionario);
            dao.commit();
            System.out.println("Funcionário cadastrado!");
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        //Pesquisar um Funcionário (READ -> SELECT)
        try {
            Funcionario busca = dao.buscarPorId(5);
            System.out.println(busca.getNome());
            busca.imprimirInformacao();
        } catch (IdNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }

        //Atualizar um Funcionário (UPDATE -> UPDATE)
        try {
            funcionario.setNome("Alex");
            funcionario.setHorasTrabalhadas(200.0);
            dao.atualizar(funcionario);
            dao.commit();
            System.out.println("Funcionário atualizado!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Remover um Funcionário (DELETE -> DELETE)
        try {
            dao.remover(63);
            dao.commit();
            System.out.println("Funcionário removido!");
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}