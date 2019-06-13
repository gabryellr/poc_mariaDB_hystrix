package com.gabryelrock.github.poc.hystrix.mariadb.DaoMusicas;

import com.gabryelrock.github.poc.hystrix.mariadb.ConectorDb;
import com.gabryelrock.github.poc.hystrix.mariadb.Model.Musica;
import com.google.gson.Gson;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MusicasDao {

    public String listarMusicas(){
        ConectorDb dbConnector = new ConectorDb();
        ResultSet rs;
        List<Musica> musicas = new ArrayList<>();
        String sql = "SELECT * FROM musicas";

        try(Connection con = dbConnector.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)){
            rs = stmt.executeQuery();
            while (rs.next()){
                Musica musica = new Musica();
                musica.setId(rs.getInt("id_musicas"));
                musica.setTitulo(rs.getString("titulo"));
                musicas.add(musica);
            }
        }catch (SQLException e){
                e.printStackTrace();
        }
        return new Gson().toJson(musicas);
    }
}
