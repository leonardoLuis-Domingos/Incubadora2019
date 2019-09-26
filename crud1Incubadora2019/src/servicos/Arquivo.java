package servicos;
import entidades.Time;

import java.io.*;

public class Arquivo {

    public static String lerArquivo(String rFilename) {
        File file = new File("Arquivos/", rFilename);
        StringBuilder text = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
                text.append(line);
                text.append('\n');
            }
            br.close();
        } catch (IOException e) {
        }
        return text.toString();
    }

    public static void escreverArquivo(String nomeArquivo, String nomeTime) {
        try {
            // File - cria o arquivo "Arquivo é a pasta"
            File root = new File("Arquivos");
            if (!root.exists()) {
                root.mkdirs();// cria a pasta
            }
            // cria o arquivo.txt com o nome passado na variavel
            File gpxfile = new File(root, nomeArquivo);

            StringBuilder conteudoArquivoExistente = new StringBuilder();
            // Se o arquivo existe
            if(gpxfile.exists())
            {
                String conteudoArquivo = lerArquivo(nomeArquivo);// le o que esta no arquivo e salva no conteudo Arquivo
                conteudoArquivoExistente.append(conteudoArquivo);// a variavel tipo StringBuilder concatena com centeudo arquivo
            }
            conteudoArquivoExistente.append(nomeTime);// passa o nome que vc quer escrever
            conteudoArquivoExistente.append("\n");

            // escreve no arquivo
            FileWriter writer = new FileWriter(gpxfile);
            writer.append(conteudoArquivoExistente);
            writer.flush();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void removerArquivo(String rFilename,String nome) {
        File file = new File("Arquivos/", rFilename);
        StringBuilder text = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
                if(!line.equals(nome)){
                    text.append(line);
                    text.append('\n');
                }
            }
            br.close();
            // escreve no arquivo
            FileWriter writer = new FileWriter(file);
            writer.append(text);
            writer.flush();
            writer.close();
        } catch (IOException e) {
        }
    }

    public static void alterarArquivo(String rFilename,String nomeAntigo,String nomeNovo) {
        File file = new File("Arquivos/", rFilename);
        StringBuilder text = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
                if(!line.equals(nomeAntigo)){
                    text.append(line);
                    text.append('\n');
                }else{
                    System.out.println(nomeNovo);
                    text.append(nomeNovo);

                }
            }
            br.close();
            // escreve no arquivo
            FileWriter writer = new FileWriter(file);
            writer.append(text);
            writer.flush();
            writer.close();
        } catch (IOException e) {
        }
    }
}
