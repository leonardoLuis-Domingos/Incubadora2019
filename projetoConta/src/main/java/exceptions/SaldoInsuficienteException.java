package exceptions;

public class SaldoInsuficienteException extends RuntimeException {

    public SaldoInsuficienteException(){
            super("O saldo é insuficiente");
    }
}
