package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class ClienteDAO {

    private Conexao conexao;
    private Connection conn;
    
    public ClienteDAO() 
    {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();

    }

    public void inserir(String nome, String senha) {
        String sql = "INSERT INTO cliente (usuarios, senha) VALUES "
                + "(?, ?)";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, senha);
            stmt.execute();
            System.out.println(stmt.toString());
            JOptionPane.showMessageDialog(null, "Cliente inserido com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao inserir cliente: " + e.getMessage());
        }
    }
    public void adicionar(String nome, String senha) {
        String sql = "INSERT INTO funcionarios (usuarios, senha) VALUES "
                + "(?, ?)";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, senha);
            stmt.execute();
            System.out.println(stmt.toString());
            JOptionPane.showMessageDialog(null, "Funcionario inserido com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao inserir funcionario: " + e.getMessage());
        }
    }

}
