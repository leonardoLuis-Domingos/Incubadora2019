import br.com.caelum.stella.validation.CPFValidator;

public class Principal {
    public static void main(String[] args) {

        String cpf = "357.672.271-87";
        valida(cpf);

        boolean valido = valida(cpf);
        System.out.println(valido);
    }

    public static boolean valida(String cpf) {
        CPFValidator cpfValidator = new CPFValidator();
        try{ cpfValidator.assertValid(cpf);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
