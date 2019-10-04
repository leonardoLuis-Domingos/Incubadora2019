package aplication;

import db.Conexao;
import entities.Time;
import entities.UpdateTimeRequest;

import static db.Conexao.*;

public class Principal {
    public static void main(String[] args) {
        UpdateTimeRequest updateTimeRequest = new UpdateTimeRequest("UOL");
        Time time = new Time();

        //Conexao.update(1L,updateTimeRequest);
        System.out.println(select());
        //Conexao.delete(1);
    }
}
