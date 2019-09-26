package entidades;

import servicos.Arquivo;

import java.util.Scanner;

public class Pessoa {

    Scanner sc = new Scanner(System.in);

    private String nome;
    private Time time;

    public  Pessoa(){
    }

    public  Pessoa(String nome,String time){
        this.nome = nome;
        this.time = new Time(time);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void salvarPessoa(){
        String arquivoPessoa = "arquivoPessoa.txt";
        Arquivo.escreverArquivo(arquivoPessoa,this.nome);
        String arquivoTimePessoa = "arquivoTimePessoa.txt";
        Arquivo.escreverArquivo(arquivoTimePessoa,this.nome + "-"+ this.time.getNome());
    }

    public void listaPessoa(){
        String arquivoPessoa = "arquivoPessoa.txt";
        Arquivo.lerArquivo(arquivoPessoa);
    }

    public void removePessoa() {
        String nomeArquivo = "NomePessoa.txt";
        System.out.println("Digite o nome que deseja remover");
        String nomeRemovido = sc.nextLine();
        Arquivo.removerArquivo("NomePessoa.txt",nomeRemovido);
    }

    public void alteraPessoa() {
        String nomeArquivo = "NomeTime.txt";
        System.out.println("Digite o nome que deseja Alterar");
        String nomeAlterado = sc.nextLine();
        System.out.println("Digite o novo nome");
        String nomeNovo= sc.next();
        Arquivo.alterarArquivo("NomeTime.txt",nomeAlterado,nomeNovo);
    }
}
