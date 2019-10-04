package entities;

public class Time {

    private int id;
    private String nome;

    public Time(){

    }

    public Time(int id,String nome) {
        this.nome = nome;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Time{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
