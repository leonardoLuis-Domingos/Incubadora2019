package db;
import entities.Time;
import entities.UpdateTimeRequest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Conexao {
    private static Connection conexao = null;

    public static Connection getConnection() {

        String url = "jdbc:postgresql://localhost:5432/incubadorajdbc";
        String usuario = "postgres";
        String senha = "123123";
        String driver = "org.postgresql.Driver";
        try {
            Connection conexao = null;
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conectou");
            return conexao;
        } catch (ClassNotFoundException e) {
            // Erro caso o driver JDBC não foi instalado
            e.printStackTrace();
            System.out.println("Erro jdbc não instalado");
        } catch (SQLException e) {
            // Erro caso haja problemas para se conectar ao banco de dados
            e.printStackTrace();
            System.out.println("não conectado ");
        }
        return null;
    }

    public static void insert(Time time){

        try(
                Connection conexao = Conexao.getConnection();
                PreparedStatement statement = conexao.prepareStatement("insert into time(nome) values (?)");
            ){

            statement.setString(1,time.getNome());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Time> select(){
        try(Connection conexao = Conexao.getConnection();
            Statement statement = conexao.createStatement();
            ResultSet resultSet = statement.executeQuery("select id_time, nome from time")
            ){

            List<Time> listaTime = new ArrayList<>();

            while (resultSet.next()){
                Time time = new Time();

                time.setId(resultSet.getInt("id_time"));
                time.setNome(resultSet.getString("nome"));

                listaTime.add(time);
            }

            return listaTime;

        } catch (SQLException e) {
            System.err.println("deu ruim");
            throw new RuntimeException(e);
        }
    }

    public static void update(Long id, UpdateTimeRequest updateTimeRequest){

        try(  Connection conexao = Conexao.getConnection();
              PreparedStatement statement = conexao.prepareStatement("update time set nome= ? where id_time = ?");
              ){
                statement.setString(1,updateTimeRequest.getNome());
                statement.setLong(2,id);
                statement.executeUpdate();

        } catch (SQLException e) {
            System.err.println("deu ruim");
            throw new RuntimeException(e);
        }
    }

    public static void delete(long id) {

        try(Connection conexao = Conexao.getConnection();
            PreparedStatement statement = conexao.prepareStatement("delete from time where id_time = ?")
        ){
            statement.setLong(1, id);
            statement.executeUpdate();
        }catch (SQLException e) {
            System.err.println("deu ruim");
            throw new RuntimeException(e);
        }
    }
}
