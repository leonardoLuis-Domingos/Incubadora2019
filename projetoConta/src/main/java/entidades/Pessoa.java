package entidades;


import br.com.caelum.stella.validation.CPFValidator;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="nome",nullable = false,columnDefinition = "text")
    private String nome;

    @Column(name="cpf",nullable = false, length = 14)
    private String cpf;

    @CreationTimestamp
    @Column(name = "cria_data_atual", nullable = false)
    private LocalDateTime criaDataAtual;

    @UpdateTimestamp
    @Column(name = "data_atualizada", nullable = false)
    private LocalDateTime atualizaData;

    public Pessoa(){

    }

    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public static boolean valida(String cpf){
        CPFValidator cpfValidator = new CPFValidator();
        try{ cpfValidator.assertValid(cpf);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", criaDataAtual=" + criaDataAtual +
                ", atualizaData=" + atualizaData +
                '}';
    }
}
