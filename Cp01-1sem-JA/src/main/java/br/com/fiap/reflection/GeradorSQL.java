package br.com.fiap.reflection;

import br.com.fiap.annotation.Coluna;
import br.com.fiap.annotation.Descricao;
import br.com.fiap.annotation.Tabela;
import br.com.fiap.dao.FuncionarioDao;
import br.com.fiap.dao.FuncionarioSeniorDao;
import br.com.fiap.dao.FuncionarioSeniorDaoImpl;
import br.com.fiap.model.Funcionario;
import br.com.fiap.model.FuncionarioSenior;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class GeradorSQL {

    private Tabela getTabela(Class<?> clazz) {

        Class<?> classeAtual = clazz;

        while (classeAtual != null && !classeAtual.isAnnotationPresent(Tabela.class)) {
            classeAtual = classeAtual.getSuperclass();
        }

        if (classeAtual == null) {
            throw new RuntimeException("Nenhuma classe com @Table encontrada");
        }

        return classeAtual.getAnnotation(Tabela.class);
    }

    private List<Field> getTodosCampos(Class<?> clazz) {

        List<Field> campos = new ArrayList<>();

        while (clazz != null) {
            for (Field f : clazz.getDeclaredFields()) {
                campos.add(f);
            }
            clazz = clazz.getSuperclass();
        }

        return campos;
    }

    public String gerarSelect(Object obj) {

        Class<?> clazz = obj.getClass();

        Tabela tabela = getTabela(clazz);

        StringBuilder sql = new StringBuilder("SELECT ");

        List<Field> campos = getTodosCampos(clazz);

        for (Field campo : campos) {

            if (campo.isAnnotationPresent(Coluna.class)) {
                Coluna col = campo.getAnnotation(Coluna.class);
                sql.append(col.nome()).append(", ");
            }
        }

        sql.delete(sql.length() - 2, sql.length());

        sql.append(" FROM ").append(tabela.nome());

        return sql.toString();
    }

    public String gerarInsert(Object obj) {

        Class<?> clazz = obj.getClass();

        Tabela tabela = getTabela(clazz);

        StringBuilder colunas = new StringBuilder();
        StringBuilder valores = new StringBuilder();

        List<Field> campos = getTodosCampos(clazz);

        for (Field campo : campos) {

            if (campo.isAnnotationPresent(Coluna.class)) {

                Coluna col = campo.getAnnotation(Coluna.class);

                colunas.append(col.nome()).append(", ");

                valores.append("?").append(", ");
            }
        }

        colunas.delete(colunas.length() - 2, colunas.length());
        valores.delete(valores.length() - 2, valores.length());

        return "INSERT INTO " + tabela.nome() +
                " (" + colunas + ") VALUES (" + valores + ")";
    }

    public String gerarUpdate(Object obj, String where) {

        Class<?> clazz = obj.getClass();

        Tabela tabela = getTabela(clazz);

        StringBuilder sql = new StringBuilder("UPDATE ");

        sql.append(tabela.nome()).append(" SET ");

        List<Field> campos = getTodosCampos(clazz);

        for (Field campo : campos) {

            if (campo.isAnnotationPresent(Coluna.class)) {

                Coluna col = campo.getAnnotation(Coluna.class);

                sql.append(col.nome()).append(" = ?, ");
            }
        }

        sql.delete(sql.length() - 2, sql.length());

        sql.append(" WHERE ").append(where);

        return sql.toString();
    }

    public String gerarDelete(Object obj, String where) {

        Class<?> clazz = obj.getClass();

        Tabela tabela = getTabela(clazz);

        return "DELETE FROM " + tabela.nome() +
                " WHERE " + where;
    }

    public void mostrarDescricoes(Object obj) {

        Class<?> clazz = obj.getClass();

        System.out.println("\n=== DESCRIÇÕES ===");

        if (clazz.isAnnotationPresent(Descricao.class)) {
            Descricao d = clazz.getAnnotation(Descricao.class);
            System.out.println("Tabela: " + d.descricao());
        }

        List<Field> campos = getTodosCampos(clazz);

        for (Field campo : campos) {

            if (campo.isAnnotationPresent(Descricao.class)) {
                Descricao d = campo.getAnnotation(Descricao.class);
                System.out.println(campo.getName() + ": " + d.descricao());
            }
        }
    }

}