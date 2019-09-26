package br.com.exceptions;

public class ValorInvalidoDeAdversarioException extends RuntimeException {
    @Override
    public String getMessage() {
        return "O VALOR PARA ADVERSÁRIO DEVE SER 1 OU 2";
    }
}
