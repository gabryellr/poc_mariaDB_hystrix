package com.gabryelrock.github.poc.hystrix.mariadb;
import java.sql.*;

public class ConectorDb {
    static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    static final String DB_URL = "jdbc:mariadb://localhost:3306/song-service";
    static final String USER = "root";
    static final String PASS = "root";

    public Connection getConnection(){
        Connection conn = null;
        try{
            Class.forName(JDBC_DRIVER);
            conn =  DriverManager.getConnection(DB_URL,USER, PASS);
        }catch(Exception e){
            e.printStackTrace();
        }
        return conn;
    }

    public void closeConnection(Connection con){
        if(con != null){
            try{
                con.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void closeConnection(Connection con, PreparedStatement stmt){
        closeConnection(con);
        if(stmt != null){
            try{
                stmt.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
        closeConnection(con, stmt);
        if(rs != null){
            try{
                rs.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

