import javax.swing.*;
import java.io.IOException;


public class Principal {

    public static void main(String[] args) throws IOException {


            JOptionPane.showMessageDialog(null,
                    "Sistema de cadastro");

            int opcaoPrincipal;
            do{
                opcaoPrincipal = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1- Time\n2- Pessoa\n3- Sair"));
                switch (opcaoPrincipal){

                    case 1:
                        subMenuTime();
                        break;
                    case 2:
                        subMenuPessoa();
                        break;
                    case 3:
                        System.exit(0);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null,
                                "Opção Invalida");
                        break;
                }
            }while(opcaoPrincipal != 3);

    }

    private static void subMenuTime() throws IOException {
        int opcaoSubMenuTime;
        do{
             opcaoSubMenuTime = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "1- Adicionar\n2- Remover\n3- Alterar\n4- listar\n5- Voltar ao menu principal"));
            switch (opcaoSubMenuTime ){

                case 1:
                    Arquivo.arquivoTime(TimeCrud.Adicionar());
                    break;
                case 2:

                    break;
                case 3:
                    break;
                case 4:
                    TimeCrud.Listar();
                    break;
                case 5:
                    break;
                default:
                    JOptionPane.showMessageDialog(null,
                            "Opção Invalida");
                    break;
            }
        }while(opcaoSubMenuTime !=5);





    }
    private static void subMenuPessoa() throws IOException {
        int opcaoSubMenuPessoa;
        do{
            opcaoSubMenuPessoa = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "1- Adicionar\n2- Remover\n3- Alterar\n4- listar\n5- Voltar ao menu principal"));
            switch (opcaoSubMenuPessoa ){

                case 1:
                    Arquivo.arquivoPessoa(PessoaCrud.Adicionar());
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    PessoaCrud.Listar();
                    break;
                case 5:
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Opção Invalida");
                    break;
            }
        }while(opcaoSubMenuPessoa !=5);
    }




}
