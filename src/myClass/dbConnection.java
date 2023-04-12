package myClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dbConnection {
    private Statement stmt1 = null;
    private Statement stmt2 = null;
    private Connection conn = null;
    
    public dbConnection(){
        String ConAddress = "jdbc:mysql://localhost/2107980_muhammad_yusuf_bahtiar_tp2dpbo";
        String user = "root";
        String pass = "";
        connect(ConAddress, user, pass);
    }

    private void connect(String ConAddress, String username, String pass){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(ConAddress, username, pass);
            stmt1 = conn.createStatement();
            stmt2 = conn.createStatement();
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public ResultSet selectQuery1(String sql){
        try{
            stmt1.executeQuery(sql);
            return stmt1.getResultSet();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return null;
    }
    
    public ResultSet selectQuery2(String sql){
        try{
            stmt2.executeQuery(sql);
            return stmt2.getResultSet();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return null;
    }
    
    public int updateQuery1(String sql){
        try{
            return stmt1.executeUpdate(sql);
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return 0;
    }
    
    public int updateQuery2(String sql){
        try{
            return stmt2.executeUpdate(sql);
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return 0;
    }
    
    public Statement getStatement1(){
        return stmt1;
    }
    
    public Statement getStatement2(){
        return stmt2;
    }
}