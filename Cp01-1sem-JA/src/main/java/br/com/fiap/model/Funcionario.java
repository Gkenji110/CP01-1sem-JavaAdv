package br.com.fiap.model;


import br.com.fiap.annotation.Coluna;
import br.com.fiap.annotation.Descricao;
import jakarta.persistence.*;
import br.com.fiap.annotation.Tabela;


@Entity
@Table(name = "TAB_FUNCIONARIO") // Usando a anotação oficial da JPA!
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // Explicita a herança
@DiscriminatorColumn(name = "TIPO_FUNCIONARIO", length = 30)
@SequenceGenerator(name="funcionario", sequenceName = "SQ_TAB_FUNCIONARIO", allocationSize = 1)
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "funcionario")
    @Column(name = "ID_FUNCIONARIO")
    private Integer id;

    @Column(name = "NM_FUNCIONARIO", nullable = false, length = 100)
    private String nome;

    @Column(name = "NR_HORAS_TRABALHADAS", nullable = false)
    private double horasTrabalhadas;

    @Column(name = "VL_HORA", nullable = false)
    private double valorPorHora;
    public Funcionario() {}

    public Funcionario(String nome, double horasTrabalhadas, double valorPorHora) {
        this.nome = nome;
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorPorHora = valorPorHora;
    }

    @PostPersist
    private void executar() {
        System.out.println("Executando o método..");
    }

    public double calcularSalario() {
        return horasTrabalhadas * valorPorHora;
    }

    public void imprimirInformacao() {
        System.out.println("Informações do funcionário");
        System.out.println("Nome:                   " + nome);
        System.out.println("Horas trabalhadas:      " + horasTrabalhadas + "h");
        System.out.println("Valor por hora:         R$ " + String.format("%.2f", valorPorHora));
        System.out.println("Salário final:          R$ " + String.format("%.2f", calcularSalario()));
        System.out.println("===========================");
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public double getHorasTrabalhadas() {return horasTrabalhadas;}
    public void setHorasTrabalhadas(double horasTrabalhadas) {this.horasTrabalhadas = horasTrabalhadas;}

    public double getValorPorHora() {return valorPorHora;}
    public void setValorPorHora(double valorPorHora) {this.valorPorHora = valorPorHora;}

}
