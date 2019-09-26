import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class PessoaCrud {

    static Pessoa pessoa = new Pessoa();
    /*
    public static void Alterar() {

    }

    public static void Remover() {

    }
    */
    public static Pessoa Adicionar() {
        pessoa.setNome(informacoes("Nome"));
        pessoa.setTime(informacoes("Time"));
        while(pessoa.getNome().length() < 3 || pessoa.getTime().length() < 3) {
            JOptionPane.showMessageDialog(null,
                    "O nome ou time devem conter mais que 3 caracteres");
            pessoa.setNome(informacoes("Nome"));
            pessoa.setTime(informacoes("Time"));
        }
        return pessoa;
    }

    public static void Listar() throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader("/home/incubadora/Documentos/pessoas.txt"));
        StringBuilder line = new StringBuilder();
        while (in.hasNextLine()) {
           line.append(in.nextLine());
           line.append("\n");
        }
        JOptionPane.showMessageDialog(null,line);
    }

    private static String informacoes(String texto) {
        return JOptionPane.showInputDialog(texto);
    }
}
