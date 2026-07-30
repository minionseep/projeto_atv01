/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public boolean cadastrarProduto (ProdutosDTO produto){
        
        
        conn = new conectaDAO().connectDB();
        String sql = "INSERT INTO `produtos` (`id`, `nome`, `valor`, `status`) VALUES (?, ?, ?)";
        try {
            String valor = Integer.toString(produto.getValor());
        
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, produto.getNome());
            ps.setString(2, valor);
            ps.setString(3, produto.getStatus());

            int linhas = ps.executeUpdate();
            ps.close();
            System.out.println("Produto cadastrado com sucesso!");
            return linhas > 0;

        } catch (SQLException ex) {
            System.out.println("Erro ao inserir produto: " + ex.getMessage());
            return false;
        }
    }
        
    
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        return listagem;
    }
    
    
    
        
}

