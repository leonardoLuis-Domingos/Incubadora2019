package br.com.service;

import br.com.model.Jogador;
import br.com.model.JogadorHumano;
import br.com.model.JogadorMaquina;
import br.com.model.TipoDeJogador;

import java.util.Random;
import java.util.Scanner;

public class ConsoleService {

    private Scanner leitor = new Scanner(System.in);

    public void mostrarMenu(){

        System.out.println("BEM VINDO AO JOGO DE PAR OU IMPAR DO LEO");
        System.out.println("DIGITE O SEU NOME, JOGADOR NUMERO 1");
        JogadorHumano jogadorNumeroUm = new JogadorHumano(lerNomeDeJogador());
        Jogador jogadorNumeroDois;

        if(decideAdversario()){
            jogadorNumeroDois = new JogadorMaquina();
        }else{
            System.out.println("DIGITE O NOME DO SEGUNDO JOGADOR");
            jogadorNumeroDois = new JogadorHumano(lerNomeDeJogador());
        }

        String continuar;

        do{
            iniciarJogo(jogadorNumeroUm, jogadorNumeroDois);
            System.out.println("DESEJA JOGAR NOVAMENTE ? (s/n)");
            continuar = leitor.nextLine();
        }while(continuar.equalsIgnoreCase("s"));
    }

    private String lerNomeDeJogador(){
        return leitor.nextLine();
    }

    private Boolean decideAdversario(){

        System.out.println("DIGITE 1 PARA JOGAR COM A MAQUINA OU");
        System.out.println("DIGITE 2 PARA JOGAR CONTRA OUTRO JOGADOR");

        Integer opcaoDeAdversario = null;

//        if(opcaoDeAdversario == 0 || opcaoDeAdversario > 2)
//            throw new ValorInvalidoDeAdversarioException();

        do{
            opcaoDeAdversario = lerNumero();
            if(opcaoDeAdversario > 2 || opcaoDeAdversario < 1){
                System.out.println("POR FAVOR DIGITE APENAS 1 OU 2");
            }
        } while (opcaoDeAdversario > 2 || opcaoDeAdversario < 1);

        return opcaoDeAdversario == 1;
    }

    private void iniciarJogo(Jogador jogadorNumeroUm, Jogador jogadorNumeroDois){

        jogadorNumeroUm.setTipoDeJogador(decidirSeOJogadorUmEParOuImpar());
        jogadorNumeroDois.setTipoDeJogador(decideTipoDoJogadorDois(jogadorNumeroUm.getTipoDeJogador()));
        System.out.println("O JOGADOR 1 " + jogadorNumeroUm.getNome() + " É " + jogadorNumeroUm.getTipoDeJogador());
        System.out.println("O JOGADOR 2 " + jogadorNumeroDois.getNome() + " É " + jogadorNumeroDois.getTipoDeJogador());
        System.out.println(jogadorNumeroUm.getNome() + " digite o seu numero");
        Integer numeroJogaodrUm = lerNumero();
        Integer numeroJogadorDois;
        if(jogadorNumeroDois.getNome().equalsIgnoreCase("MAQUINA")){
            numeroJogadorDois = gerarNumeroRandomico(10);
            System.out.println("O NUMERO SORTEADO PARA A MAQUINA FOI : "+ numeroJogadorDois);
        }else {
            System.out.println(jogadorNumeroDois.getNome() + " digite o seu numero");
            numeroJogadorDois = lerNumero();
        }

        verificarQuemGanhou(jogadorNumeroUm, jogadorNumeroDois, numeroJogaodrUm, numeroJogadorDois);
    }

    private TipoDeJogador decideTipoDoJogadorDois(TipoDeJogador tipoDeJogador){
        return tipoDeJogador.equals(TipoDeJogador.PAR) ? TipoDeJogador.IMPAR : TipoDeJogador.PAR;
    }

    private TipoDeJogador decidirSeOJogadorUmEParOuImpar(){
        return gerarNumeroRandomico(2) == 1 ? TipoDeJogador.IMPAR : TipoDeJogador.PAR;
    }

    private Integer lerNumero(){

        Integer numero = null;

        do{
            try{
                numero = Integer.parseInt(leitor.nextLine());

            }catch (NumberFormatException e) {
                System.out.println("POR FAVOR DIGITE APENAS NUMEROS");
                numero = -1;
            }
        }while(numero == -1);

        return numero;
    }

    private Integer gerarNumeroRandomico(Integer range){
        return new Random().nextInt(range) + 1;
    }

    private void verificarQuemGanhou(Jogador jogadorUm, Jogador jogadorDois, Integer numeroJogadorUm, Integer numeroJogadorDois){

        Integer soma = numeroJogadorUm + numeroJogadorDois;
        TipoDeJogador tipoDoNumeroResultante = soma % 2 == 0 ? TipoDeJogador.PAR : TipoDeJogador.IMPAR;

        if(jogadorUm.getTipoDeJogador().equals(tipoDoNumeroResultante)){
            jogadorUm.incrementaPontoDoJogador();
            System.out.println("JOGADOR 1 VENCEU");
        }else{
            jogadorDois.incrementaPontoDoJogador();
            System.out.println("JOGADOR 2 VENCEU");
        }

        System.out.println("PLACAR :");
        System.out.println("JOGADOR 1 : " + jogadorUm.getPontos() + " X " + jogadorDois.getPontos() + " : JOGADOR 2");
    }
}

