import java.io.*;

public  class Arquivo {

    public static void arquivoPessoa(Pessoa pessoa) throws IOException {

        File arquivo = new File("/home/incubadora/Documentos/pessoas.txt");
        FileWriter fw = new FileWriter( arquivo, true );
        PrintWriter ps = new PrintWriter( fw, true );
        ps.println(pessoa);
        arquivo.exists();
    }

    public static void arquivoTime(Time time) throws IOException {

        File arquivo = new File("/home/incubadora/Documentos/times.txt");
        FileWriter fw = new FileWriter( arquivo, true );
        PrintWriter ps = new PrintWriter( fw, true );
        ps.println(time);
        arquivo.exists();
    }
}