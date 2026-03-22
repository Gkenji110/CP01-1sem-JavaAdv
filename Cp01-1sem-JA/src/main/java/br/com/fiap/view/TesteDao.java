package br.com.fiap.view;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import br.com.fiap.dao.FuncionarioDao;
import br.com.fiap.dao.FuncionarioDaoImpl;
import br.com.fiap.model.Funcionario;
import br.com.fiap.model.FuncionarioJunior;
import br.com.fiap.model.FuncionarioPleno;
import br.com.fiap.model.FuncionarioSenior;
import br.com.fiap.exception.IdNaoEncontradoException;

public class TesteDao {

    public static void main(String[] args) {
        
        // Inicializando as fábricas e o DAO
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
        EntityManager em = fabrica.createEntityManager();
        FuncionarioDao dao = new FuncionarioDaoImpl(em);

        try {
            System.out.println("=================================================");
            System.out.println("1. CREATE (INSERT) - Instanciando as classes filhas");
            System.out.println("=================================================");
            
            FuncionarioJunior junior = new FuncionarioJunior("Geraldo Junior", 160.0, 30.0);
            FuncionarioPleno pleno = new FuncionarioPleno("Alex Pleno", 160.0, 50.0);
            FuncionarioSenior senior = new FuncionarioSenior("Marta Sênior", 160.0, 80.0, 1500.0);
            
            dao.cadastrar(junior);
            dao.cadastrar(pleno);
            dao.cadastrar(senior);
            dao.commit();
            
            System.out.println("Sucesso! IDs gerados pelo Oracle:");
            System.out.println("ID Junior: " + junior.getId());
            System.out.println("ID Pleno: " + pleno.getId());
            System.out.println("ID Senior: " + senior.getId());


            System.out.println("\n=================================================");
            System.out.println("2. READ (SELECT) - Buscando dinamicamente");
            System.out.println("=================================================");
        
            Funcionario buscaSenior = dao.buscarPorId(senior.getId());

            buscaSenior.imprimirInformacao();


            System.out.println("\n=================================================");
            System.out.println("3. UPDATE (UPDATE) - Atualizando o Pleno");
            System.out.println("=================================================");
            
            pleno.setHorasTrabalhadas(220.0); // Fez hora extra
            dao.atualizar(pleno);
            dao.commit();
            System.out.println("Horas do Pleno (ID " + pleno.getId() + ") atualizadas para 220.0");


            System.out.println("\n=================================================");
            System.out.println("4. DELETE (DELETE) - Removendo o Junior");
            System.out.println("=================================================");
            
            dao.remover(junior.getId());
            dao.commit();
            System.out.println("Junior (ID " + junior.getId() + ") removido do banco com sucesso.");

        } catch (IdNaoEncontradoException e) {
            System.err.println("Erro de busca: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Erro inesperado durante a transação: " + e.getMessage());
            e.printStackTrace();
        } finally {
            em.close();
            fabrica.close();
        }
    }
}