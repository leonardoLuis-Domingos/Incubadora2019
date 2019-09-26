import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class TimeCrud {

    static Time time = new Time();
    /*
    public static void Alterar() {

    }

    public static void Remover() {

    }
    */
    public static Time Adicionar() {
        time.setNome(informacoes("Nome"));
        while(time.getNome().length() < 3 ) {
            JOptionPane.showMessageDialog(null,
                    "O nome ou time devem conter mais que 3 caracteres");
            time.setNome(informacoes("Nome"));
        }
        return time;
    }

    public static void Listar() throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader("/home/incubadora/Documentos/times.txt"));
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
