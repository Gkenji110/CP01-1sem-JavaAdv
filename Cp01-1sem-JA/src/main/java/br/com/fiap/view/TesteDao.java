package br.com.fiap.view;

import br.com.fiap.dao.FuncionarioDao;
import br.com.fiap.dao.FuncionarioDaoImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import br.com.fiap.model.FuncionarioJunior;
import br.com.fiap.model.FuncionarioPleno;
import br.com.fiap.model.FuncionarioSenior;
import br.com.fiap.exception.IdNaoEncontradoException;
import br.com.fiap.exception.CommitException;
import br.com.fiap.reflection.GeradorSQL;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteDao {

    private static FuncionarioDao dao;
    private static GeradorSQL gerador;

    public static void main(String[] args) {
        configurarLogsHibernate();
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
        EntityManager em = fabrica.createEntityManager();
        dao = new FuncionarioDaoImpl(em);
        gerador = new GeradorSQL();
        
        try {
            testarFuncionarioJunior();
            testarFuncionarioPleno();
            testarFuncionarioSenior();
            
            imprimirFinal();
        } catch (Exception e) {
            System.err.println("Erro durante os testes: " + e.getMessage());
        } finally {
            if (em != null) em.close();
            fabrica.close();
        }
    }

    private static void configurarLogsHibernate() {
        Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
        Logger.getLogger("org.jboss").setLevel(Level.SEVERE);
    }

    // ============================================================================
    // TESTES FUNCIONÁRIO JUNIOR
    // ============================================================================

    private static void testarFuncionarioJunior() throws IdNaoEncontradoException, CommitException {
        imprimirSeparador("TESTE FUNCIONARIO JUNIOR");
        
        FuncionarioJunior junior = criarJunior();
        Integer idJunior = inserirJunior(junior);
        buscarJunior(idJunior);
        atualizarJunior(junior);
        deletarJunior(idJunior);
    }

    private static FuncionarioJunior criarJunior() {
        return new FuncionarioJunior("Ana Silva", 160.0, 35.0, "Desenvolvedor Júnior", 200.0);
    }

    private static Integer inserirJunior(FuncionarioJunior junior) throws CommitException {
        System.out.println("\n[INSERT] Registrando FuncionarioJunior");
        System.out.println(gerador.gerarInsert(junior));
        dao.cadastrar(junior);
        dao.commit();
        System.out.println("[OK] Inserido com sucesso! ID: " + junior.getId());
        return junior.getId();
    }

    private static void buscarJunior(Integer id) throws IdNaoEncontradoException {
        System.out.println("\n[SELECT] Buscando FuncionarioJunior");
        FuncionarioJunior funcionario = (FuncionarioJunior) dao.buscarPorId(id);
        System.out.println(gerador.gerarSelect(funcionario));
        System.out.println("[OK] Encontrado!");
        funcionario.imprimirInformacao();
        double salario = funcionario.calcularSalario();
        System.out.println("Salário final: R$ " + String.format("%.2f", salario));
    }

    private static void atualizarJunior(FuncionarioJunior junior) throws CommitException {
        System.out.println("\n[UPDATE] Atualizando horas do FuncionarioJunior");
        junior.setHorasTrabalhadas(200.0);
        System.out.println(gerador.gerarUpdate(junior, "ID_FUNCIONARIO = " + junior.getId()));
        dao.atualizar(junior);
        dao.commit();
        System.out.println("[OK] Atualizado! Novas horas: " + junior.getHorasTrabalhadas());
        junior.imprimirInformacao();
        double salario = junior.calcularSalario();
        System.out.println("Salário final: R$ " + String.format("%.2f", salario));
    }

    private static void deletarJunior(Integer id) throws IdNaoEncontradoException, CommitException {
        System.out.println("\n[DELETE] Removendo FuncionarioJunior");
        FuncionarioJunior temp = new FuncionarioJunior();
        temp.setId(id);
        System.out.println(gerador.gerarDelete(temp, "ID_FUNCIONARIO = " + id));
        dao.remover(id);
        dao.commit();
        System.out.println("[OK] Deletado com sucesso!");
    }

    // ============================================================================
    // TESTES FUNCIONÁRIO PLENO
    // ============================================================================

    private static void testarFuncionarioPleno() throws IdNaoEncontradoException, CommitException {
        imprimirSeparador("TESTE FUNCIONARIO PLENO");
        
        FuncionarioPleno pleno = criarPleno();
        Integer idPleno = inserirPleno(pleno);
        buscarPleno(idPleno);
        atualizarPleno(pleno);
        deletarPleno(idPleno);
    }

    private static FuncionarioPleno criarPleno() {
        return new FuncionarioPleno("Carlos Oliveira", 160.0, 55.0, "Desenvolvedor Pleno", 300.0);
    }

    private static Integer inserirPleno(FuncionarioPleno pleno) throws CommitException {
        System.out.println("\n[INSERT] Registrando FuncionarioPleno");
        System.out.println(gerador.gerarInsert(pleno));
        dao.cadastrar(pleno);
        dao.commit();
        System.out.println("[OK] Inserido com sucesso! ID: " + pleno.getId());
        return pleno.getId();
    }

    private static void buscarPleno(Integer id) throws IdNaoEncontradoException {
        System.out.println("\n[SELECT] Buscando FuncionarioPleno");
        FuncionarioPleno funcionario = (FuncionarioPleno) dao.buscarPorId(id);
        System.out.println(gerador.gerarSelect(funcionario));
        System.out.println("[OK] Encontrado!");
        funcionario.imprimirInformacao();
        double salario = funcionario.calcularSalario();
        System.out.println("Salário final: R$ " + String.format("%.2f", salario));
    }

    private static void atualizarPleno(FuncionarioPleno pleno) throws CommitException {
        System.out.println("\n[UPDATE] Atualizando horas do FuncionarioPleno");
        pleno.setHorasTrabalhadas(220.0);
        System.out.println(gerador.gerarUpdate(pleno, "ID_FUNCIONARIO = " + pleno.getId()));
        dao.atualizar(pleno);
        dao.commit();
        System.out.println("[OK] Atualizado! Novas horas: " + pleno.getHorasTrabalhadas());
        pleno.imprimirInformacao();
        double salario = pleno.calcularSalario();
        System.out.println("Salário final: R$ " + String.format("%.2f", salario));
    }

    private static void deletarPleno(Integer id) throws IdNaoEncontradoException, CommitException {
        System.out.println("\n[DELETE] Removendo FuncionarioPleno");
        FuncionarioPleno temp = new FuncionarioPleno();
        temp.setId(id);
        System.out.println(gerador.gerarDelete(temp, "ID_FUNCIONARIO = " + id));
        dao.remover(id);
        dao.commit();
        System.out.println("[OK] Deletado com sucesso!");
    }

    // ============================================================================
    // TESTES FUNCIONÁRIO SENIOR
    // ============================================================================

    private static void testarFuncionarioSenior() throws IdNaoEncontradoException, CommitException {
        imprimirSeparador("TESTE FUNCIONARIO SENIOR");
        
        FuncionarioSenior senior = criarSenior();
        Integer idSenior = inserirSenior(senior);
        buscarSenior(idSenior);
        atualizarSenior(senior);
        deletarSenior(idSenior);
    }

    private static FuncionarioSenior criarSenior() {
        return new FuncionarioSenior("Marta Santos", 160.0, 80.0, "Desenvolvedor Sênior", 500.0);
    }

    private static Integer inserirSenior(FuncionarioSenior senior) throws CommitException {
        System.out.println("\n[INSERT] Registrando FuncionarioSenior");
        System.out.println(gerador.gerarInsert(senior));
        dao.cadastrar(senior);
        dao.commit();
        System.out.println("[OK] Inserido com sucesso! ID: " + senior.getId());
        return senior.getId();
    }

    private static void buscarSenior(Integer id) throws IdNaoEncontradoException {
        System.out.println("\n[SELECT] Buscando FuncionarioSenior");
        FuncionarioSenior funcionario = (FuncionarioSenior) dao.buscarPorId(id);
        System.out.println(gerador.gerarSelect(funcionario));
        System.out.println("[OK] Encontrado!");
        funcionario.imprimirInformacao();
        double salario = funcionario.calcularSalario();
        System.out.println("Salário final: R$ " + String.format("%.2f", salario));
    }

    private static void atualizarSenior(FuncionarioSenior senior) throws CommitException {
        System.out.println("\n[UPDATE] Atualizando horas do FuncionarioSenior");
        senior.setHorasTrabalhadas(240.0);
        System.out.println(gerador.gerarUpdate(senior, "ID_FUNCIONARIO = " + senior.getId()));
        dao.atualizar(senior);
        dao.commit();
        System.out.println("[OK] Atualizado! Novas horas: " + senior.getHorasTrabalhadas());
        senior.imprimirInformacao();
        double salario = senior.calcularSalario();
        System.out.println("Salário final: R$ " + String.format("%.2f", salario));
    }

    private static void deletarSenior(Integer id) throws IdNaoEncontradoException, CommitException {
        System.out.println("\n[DELETE] Removendo FuncionarioSenior");
        FuncionarioSenior temp = new FuncionarioSenior();
        temp.setId(id);
        System.out.println(gerador.gerarDelete(temp, "ID_FUNCIONARIO = " + id));
        dao.remover(id);
        dao.commit();
        System.out.println("[OK] Deletado com sucesso!");
    }

    // ============================================================================
    // MÉTODOS AUXILIARES
    // ============================================================================

    private static void imprimirSeparador(String titulo) {
        System.out.println("\n" + "=".repeat(80));
        System.out.println(titulo);
        System.out.println("=".repeat(80));
    }

    private static void imprimirFinal() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("[OK] TODOS OS TESTES EXECUTADOS COM SUCESSO!");
        System.out.println("=".repeat(80));
    }
}
