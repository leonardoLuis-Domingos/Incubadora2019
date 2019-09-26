public class Time {
    private String nome;

    public Time() {
    }

    public Time(String nome, String time) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    @Override
    public String toString() {
        return nome;
    }
}
