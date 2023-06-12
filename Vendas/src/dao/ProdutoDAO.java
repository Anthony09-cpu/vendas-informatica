package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import beans.Produto;
import java.sql.DriverManager;

public class ProdutoDAO {

    private Conexao conexao;
    private Connection conn;

    public ProdutoDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();

    }

    public void inserir(Produto vendas) {
        String sql = "INSERT INTO vendas(nome, valor, qtd) VALUES "
                + "(?, ?, ?)";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, vendas.getNome());
            stmt.setDouble(2, vendas.getValor());
            stmt.setInt(3, vendas.getQtd());
            stmt.execute();
        } catch (Exception e) {
            System.out.println("Erro ao inserir produto: " + e.getMessage());
        }
    }

    public Produto getVenda(int id) {
        String sql = "SELECT * FROM vendas WHERE id = ?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Produto vendas = new Produto();
            while (rs.next()) {

                vendas.setNome(rs.getString("nome"));
                vendas.setValor(rs.getDouble("valor"));
                vendas.setQtd(rs.getInt("qtd"));
                return vendas;
            }
            return null;
        } catch (Exception e) {
            System.out.println("Erro!" + e.getMessage());
            return null;
        }
    }

    public Produto getVenda(String nome) {
        String sql = "SELECT * FROM vendas WHERE nome = ?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            Produto vendas = new Produto();
            while (rs.next()) {
                vendas.setId(rs.getInt("id"));
                vendas.setNome(rs.getString("nome"));
                vendas.setValor(rs.getDouble("valor"));
                vendas.setQtd(rs.getInt("qtd"));
                return vendas;
            }
            return null;
        } catch (Exception e) {
            System.out.println("Erro!" + e.getMessage());
            return null;
        }
    }

    public void editar(Produto vendas) {
        String sql = "UPDATE vendas SET nome=?, valor=? WHERE id=?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);

            stmt.setString(1, vendas.getNome());
            stmt.setDouble(2, vendas.getValor());
            stmt.setInt(3, vendas.getId());
            stmt.execute();
        } catch (Exception e) {
            System.out.println("Erro ao editar produto ou valor: " + e.getMessage());
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM vendas WHERE id = ?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
        } catch (Exception e) {
            System.out.println("Erro ao excluir o produto: " + e.getMessage());
        }
    }

    public List<Produto> getVendas(String nome) {
        String sql = "SELECT * FROM vendas WHERE nome LIKE ?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, "%" + nome + "%");
            ResultSet rs = stmt.executeQuery();
            List<Produto> listaVendas = new ArrayList<>();

            while (rs.next()) {
                Produto vendas = new Produto();
                vendas.setId(rs.getInt("id"));
                vendas.setNome(rs.getString("nome"));
                vendas.setValor(rs.getDouble("valor"));
                vendas.setQtd(rs.getInt("qtd"));
                listaVendas.add(vendas);
            }
            return listaVendas;
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }

    public void diminuir(Produto produto) {
        String sql = "UPDATE vendas SET qtd = qtd - ? WHERE id = ?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);

            stmt.setInt(1, produto.getQtd());
            stmt.setInt(2, produto.getId());
            stmt.execute();
        } catch (Exception e) {
            System.out.println("Erro ao diminuir quantidade: " + e.getMessage());
        }
    }
}
