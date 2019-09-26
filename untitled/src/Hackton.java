import java.sql.SQLOutput;
import java.util.Scanner;

public class Hackton {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int escolha;
        int escolhaJogador2;
        int letra;
        String jogador1;
        String jogador2;
        int valor1;
        int valor2;
        int cont;
        int deNovo;

        do {
            System.out.println("Deseja jogar contra pessoa ou pc?");
            System.out.println("Digite 1 para pessoa e digite 2 para pc");

            do {
                letra = sc.nextInt();

                if (letra != 1 && letra != 2) {
                    System.out.println("Digite apenas os numeros 1 ou 2!");
                }

            } while (letra != 1 && letra != 2);

            if (letra == 1) {

                System.out.println("Digite o nome do jogardor um: ");
                jogador1 = sc.next();

                System.out.println("Digite o nome do jogador dois: ");
                jogador2 = sc.next();
            } else {
                System.out.println("Digite o nome do jogardor um: ");
                jogador1 = sc.next();
            }

            System.out.println("Jogador 1 ");
            System.out.println("Digite 1 para Impar e digite 2 para Par");

            do {
                escolha = sc.nextInt();

                if (escolha == 1) {
                    escolhaJogador2 = 2;
                } else if (escolha == 2) {
                    escolhaJogador2 = 1;
                } else {
                    System.out.println("Digite apenas 1 ou 2");
                }

            } while (escolha != 1 && escolha != 2);

            System.out.println("Jogador 1, digite seu numero: ");
            valor1 = sc.nextInt();

            if (letra == 1) {
                System.out.println("Jogador 2, digite seu numero: ");
                valor2 = sc.nextInt();
            } else {
                valor2 = 1 + (int) (Math.random()*10);
            }

            int soma = valor1 + valor2;

            if (soma % 2 == 0) {
                if (escolha == 2) {
                    System.out.println("Jogador 1 Venceu!");
                } else {
                    System.out.println("Jogador 2 ou PC Venceu!");
                }
            }

            System.out.println("Deseja jogar de novo?(1 = Sim ou 2 = Não)");
            do {
                deNovo = sc.nextInt();
            } while (deNovo != 1 && deNovo != 2);


        }while (deNovo != 2);
    }
}
