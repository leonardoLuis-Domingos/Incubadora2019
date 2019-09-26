package entidades;

import servicos.Arquivo;

import java.util.Scanner;

public class Time {
    Scanner sc = new Scanner(System.in);

    private String nome;

    public Time(){
    }

    public Time(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void salvaTime() {
        String nomeArquivo = "NomeTime.txt";
        Arquivo.escreverArquivo( nomeArquivo, this.nome);
    }

    public void listaTime() {
        String nomeArquivo = "NomeTime.txt";
        System.out.println(Arquivo.lerArquivo(nomeArquivo));
    }

    public void removeTime() {
        String nomeArquivo = "NomeTime.txt";
        System.out.println("Digite o nome que deseja remover");
        String nomeRemovido = sc.nextLine();
        Arquivo.removerArquivo("NomeTime.txt",nomeRemovido);
    }

    public void alteraTime() {
        String nomeArquivo = "NomeTime.txt";
        System.out.println("Digite o nome que deseja Alterar");
        String nomeAlterado = sc.nextLine();
        System.out.println("Digite o novo nome");
        String nomeNovo= sc.next();
        Arquivo.alterarArquivo("NomeTime.txt",nomeAlterado,nomeNovo);
    }

}
