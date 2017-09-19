package br.edu.ifsc.projeto.bd;

import br.com.hms.control.Pessoa;
import br.com.hms.model.mPessoa;
import br.edu.ifsc.projeto.view.GuiPrincipal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DB {
    
    public static final String url = "jdbc:mysql://localhost:3306/projeto";
    public static final String login = "root";
    public static final String senha = "@Federal5547155";
    public Connection connection;
    public PreparedStatement preparedStatement;
    public ResultSet resultSet;
    
    public DB() {
        try {
          
          connection = DriverManager.getConnection(url, login, senha);
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public int bdAtualizar(String sql) {
        int id = 0;
        try {  
            this.preparedStatement = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            this.preparedStatement.executeUpdate();
            ResultSet rs = this.preparedStatement.getGeneratedKeys();
            if (rs.first()) {
                id = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
    public ResultSet bdConsultar(String sql) {
        try {
            this.preparedStatement = this.connection.prepareStatement(sql);
            this.resultSet = this.preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.resultSet;
    }

    public void fecharConexao() {
        try {
            this.preparedStatement.close();
            this.connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public boolean validaSenha(String user, String pass){
        try {
            String sql = "select usua_regi, usua_senh, usua_codi, pess_codi from Usuario where usua_regi = ? and usua_senh = ?";
            boolean autenticado = false; 
            
            this.preparedStatement = this.connection.prepareStatement(sql);
            
            this.preparedStatement.setString(1, user);
            this.preparedStatement.setString(2, pass);
            
            this.resultSet = this.preparedStatement.executeQuery();

            if(this.resultSet.next()){
                String loginBanco = this.resultSet.getString("usua_regi");  
                String senhaBanco = this.resultSet.getString("usua_senh");  
                autenticado = true;  
                GuiPrincipal.userdata = new ArrayList<>();
                GuiPrincipal.userdata.add(this.resultSet.getInt("usua_codi"));
                Pessoa p = new Pessoa();
                p.setPess_codi(this.resultSet.getInt("pess_codi"));
                mPessoa a = new mPessoa(this);
                System.out.println(p.getPess_codi());
                a.consultar(p, null, false);
                GuiPrincipal.userdata.add(a.listaPessoa().get(0).getPess_tipo().charAt(0));
            } 
            this.preparedStatement.close();
            
            return autenticado;
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}  
  

