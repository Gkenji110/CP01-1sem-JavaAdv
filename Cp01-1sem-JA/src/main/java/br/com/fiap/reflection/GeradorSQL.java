package br.com.fiap.reflection;

import br.com.fiap.annotation.Coluna;
import br.com.fiap.annotation.Descricao;
import br.com.fiap.annotation.Tabela;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class GeradorSQL {

    private String getNomeTabela(Class<?> clazz) {

        Class<?> classeAtual = clazz;

        while (classeAtual != null) {
            if (classeAtual.isAnnotationPresent(Tabela.class)) {
                return classeAtual.getAnnotation(Tabela.class).nome();
            }
            if (classeAtual.isAnnotationPresent(Table.class)) {
                String nome = classeAtual.getAnnotation(Table.class).name();
                if (nome != null && !nome.isBlank()) {
                    return nome;
                }
            }
            classeAtual = classeAtual.getSuperclass();
        }

        throw new RuntimeException("Nenhuma classe com @Tabela ou @Table encontrada");
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

    private List<String> getNomesColunas(List<Field> campos) {
        List<String> colunas = new ArrayList<>();

        for (Field campo : campos) {
            if (campo.isAnnotationPresent(Coluna.class)) {
                colunas.add(campo.getAnnotation(Coluna.class).nome());
            } else if (campo.isAnnotationPresent(Column.class)) {
                String nome = campo.getAnnotation(Column.class).name();
                if (nome != null && !nome.isBlank()) {
                    colunas.add(nome);
                }
            }
        }

        return colunas;
    }

    public String gerarSelect(Object obj) {

        Class<?> clazz = obj.getClass();

        String tabela = getNomeTabela(clazz);

        StringBuilder sql = new StringBuilder("SELECT ");

        List<String> colunas = getNomesColunas(getTodosCampos(clazz));

        if (colunas.isEmpty()) {
            sql.append("*");
        } else {
            for (String coluna : colunas) {
                sql.append(coluna).append(", ");
            }
            sql.delete(sql.length() - 2, sql.length());
        }

        sql.append(" FROM ").append(tabela);

        return sql.toString();
    }

    public String gerarInsert(Object obj) {

        Class<?> clazz = obj.getClass();

        String tabela = getNomeTabela(clazz);

        StringBuilder colunas = new StringBuilder();
        StringBuilder valores = new StringBuilder();

        List<String> nomesColunas = getNomesColunas(getTodosCampos(clazz));

        if (nomesColunas.isEmpty()) {
            throw new RuntimeException("Nenhuma coluna mapeada com @Coluna ou @Column");
        }

        for (String coluna : nomesColunas) {
            colunas.append(coluna).append(", ");
            valores.append("?").append(", ");
        }

        colunas.delete(colunas.length() - 2, colunas.length());
        valores.delete(valores.length() - 2, valores.length());

        return "INSERT INTO " + tabela +
                " (" + colunas + ") VALUES (" + valores + ")";
    }

    public String gerarUpdate(Object obj, String where) {

        Class<?> clazz = obj.getClass();

        String tabela = getNomeTabela(clazz);

        StringBuilder sql = new StringBuilder("UPDATE ");

        sql.append(tabela).append(" SET ");

        List<String> colunas = getNomesColunas(getTodosCampos(clazz));

        if (colunas.isEmpty()) {
            throw new RuntimeException("Nenhuma coluna mapeada com @Coluna ou @Column");
        }

        for (String coluna : colunas) {
            sql.append(coluna).append(" = ?, ");
        }

        sql.delete(sql.length() - 2, sql.length());

        sql.append(" WHERE ").append(where);

        return sql.toString();
    }

    public String gerarDelete(Object obj, String where) {

        Class<?> clazz = obj.getClass();

        String tabela = getNomeTabela(clazz);

        return "DELETE FROM " + tabela +
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