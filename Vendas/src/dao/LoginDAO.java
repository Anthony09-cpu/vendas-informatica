package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {
    private Conexao conexao;
    private Connection conn;

    public LoginDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }

    public boolean login(String nome, String senha) {
        String sql = "SELECT * FROM funcionarios WHERE usuarios = ? and senha = ?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println("Erro Login: " + e.getMessage());
            return false;
        }
    }
    public boolean entrar(String nome, String senha){
    
    String sql = "SELECT * FROM cliente WHERE usuarios = ? and senha = ?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println("Erro Login: " + e.getMessage());
            return false;
        }
    }
}

























