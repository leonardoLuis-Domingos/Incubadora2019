package entidades;

import dao.ContaDao;
import dao.PessoaDao;
import exceptions.SaldoInsuficienteException;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Scanner;

@Entity
@Table(name = "conta")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="numero",nullable = false)
    private Integer numero;

    @Column(name = "saldo", nullable = false)
    private Double saldo;

    @Column(name = "limite", nullable = false)
    private Double limite = 100.0;

    @ManyToOne
    @JoinColumn(name = "id_pessoa", nullable = false)
    private Pessoa pessoa;

    @CreationTimestamp
    @Column(name = "cria_data_atual", nullable = false)
    private LocalDateTime criaDataAtual;

    @UpdateTimestamp
    @Column(name = "data_atualizada", nullable = false)
    private LocalDateTime atualizaData;

    public Conta(){

    }

    public Conta(Integer numero,Double saldo,Pessoa pessoa) {
        this.numero = numero;
        this.saldo = saldo;
        this.pessoa = pessoa;
    }

    public long getId() {
        return id;
    }

    public Integer getNumero() {
        return numero;
    }

    public Double getSaldo() {
        return saldo;
    }

    public Double getLimite() {
        return limite;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void sacar(Double saque) {
        if(saque > saldo){
            Double valorExcedente = saque - saldo;

            if(valorExcedente < this.limite){
                this.saldo = 0.0; //SALDO NAO PODE SER NEGATIVO
                this.limite = this.limite - valorExcedente;
            }else{
                throw new SaldoInsuficienteException();
            }
        }else{
            this.saldo = this.saldo - saque;
        }
    }

    public void depositar(Double deposito) {
        if(this.limite == 100){
            this.saldo += deposito;
        }else if(this.limite < 100){
            Double valorTotal = this.limite + deposito;
            if(valorTotal < 100){
                this.limite = valorTotal;
            }else{
                this.limite = 100.0;
                double valorExcedente = valorTotal - 100;
                this.saldo += valorExcedente;
            }
        }
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public String toString() {
        return "Conta: " +
                " id: " + id +
                " numero: " + numero +
                " saldo: " + saldo +
                " limite: " + limite +
                " pessoa: " + pessoa +
                " criaDataAtual: " + criaDataAtual +
                " atualizaData: " + atualizaData +
                '}';
    }




}
