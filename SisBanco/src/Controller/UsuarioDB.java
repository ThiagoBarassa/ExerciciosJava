package Controller;

import java.sql.*;
import javax.swing.JOptionPane;
import Model.*;

public class UsuarioDB {
	//Driver de conexão com MySQL(servidor)
			private String servidor = "com.mysql.cj.jdbc.Driver";
			
			//URL que identifica o banco de dados
			private String urlbd = "jdbc:mysql://localhost:3306/SisBanco?useTimezone=true&serverTimezone=UTC";
			
			//Usuario do banco de dados
			private String usubd = "root";
			
			//Senha do banco de dados
			private String senhabd = "";
			
			
			public void Consultar() {
				Connection con = null;
				
				try {
					Class.forName(servidor);
					con = DriverManager.getConnection(urlbd, usubd, senhabd);
					
					//A classe Statemente é utilizada para fazer consulta no BD
					Statement stmt = con.createStatement();
					String sql = "SELECT * FROM usuario";
					
					//ResultSet permite pegar os resultados do Statement
					ResultSet rs = stmt.executeQuery(sql);
					
					String relacao = "Relação de Usuários Cadastrados: \n";
					
					while(rs.next()){
						relacao = relacao + "\nid: " + rs.getString(1).toString() + " - Nome: " + rs.getString(2) +
								" - CPF: " + rs.getString(3) + " - RG: " + rs.getString(4) +
								" - Estado: "+rs.getString(5) + " - Cidade: "
								+ rs.getString(6)+ " - Endereço: " + rs.getString(7) + " - CEP: " 
								+ rs.getString(8)+ " - Telefone: " + rs.getString(9);
					}
					rs.close();
					JOptionPane.showMessageDialog(null, relacao + "\n");
				}
				catch(ClassNotFoundException ex) {
					ex.printStackTrace();
				}
				catch(SQLException ex) {
					ex.printStackTrace();
				}
				finally {
					try {
						con.close();
					}
					catch(Exception ex) {
						ex.printStackTrace();
					}
				}
			}
			
			public Usuario Pesquisar(Usuario usu) {
				Connection con = null;
				
				try {
					Class.forName(servidor);
					con = DriverManager.getConnection(urlbd, usubd, senhabd);
					
					Statement stmt = con.createStatement();
					String sql = "SELECT * FROM usuario Where id_user = "+ usu.getId();
				
					ResultSet rs = stmt.executeQuery(sql);
					
					rs.next();
					
					usu.setId(rs.getInt(1));
					usu.setNome(rs.getString(2));
					usu.setCpf(rs.getString(3));
					usu.setRg(rs.getString(4));
					usu.setEstado(rs.getString(5));
					usu.setCidade(rs.getString(6));
					usu.setEndereco(rs.getString(7));
					usu.setCep(rs.getString(8));
					usu.setTelefone(rs.getString(9));
					
					rs.close();
				}
				catch(ClassNotFoundException ex) {
					ex.printStackTrace();
				}
				catch(SQLException ex) {
					ex.printStackTrace();
				}
				finally {
					try {
						con.close();
					}
					catch(Exception ex) {
						ex.printStackTrace();
					}
				}
				return usu;
			}
			
			public void Incluir(Usuario usu) {
				Connection con = null;
				PreparedStatement ps = null;
				
				try {
					Class.forName(servidor);
					con = DriverManager.getConnection(urlbd, usubd, senhabd);
					
					//Statement stmt = con.createStatement();
					String sql = "INSERT INTO usuario VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
					
					ps = con.prepareStatement(sql);
					
					ps.setInt(1, usu.getId());
					ps.setString(2, usu.getNome());
					ps.setString(3, usu.getCpf());
					ps.setString(4, usu.getRg());
					ps.setString(5, usu.getEstado());
					ps.setString(6, usu.getCidade());
					ps.setString(7, usu.getEndereco());
					ps.setString(8, usu.getCep());
					ps.setString(9, usu.getTelefone());
					
					ps.executeUpdate();
				}
				catch(ClassNotFoundException ex) {
					ex.printStackTrace();
				}
				catch(SQLException ex) {
					ex.printStackTrace();
				}
				finally {
					try {
						con.close();
					}
					catch(Exception ex){
						ex.printStackTrace();
					}
				}
			}
			
			public void Alterar (Usuario usu) {
				Connection con = null;
				PreparedStatement ps = null;
				
				try {
					Class.forName(servidor);
					con = DriverManager.getConnection(urlbd,usubd,senhabd);
					
					String sql = ("UPDATE usuario SET estado = ?,cidade = ?, endereco = ? " 
							+ "cep = ?, telefone = ? WHERE id_usuario = ?");
					ps = con.prepareStatement(sql);
					
					ps.setString(1, usu.getEstado());
					ps.setString(2, usu.getCidade());
					ps.setString(3, usu.getEndereco());
					ps.setString(4, usu.getCep());
					ps.setString(5, usu.getTelefone());
					
					ps.executeUpdate();
				}
				
				catch(ClassNotFoundException ex) {
					ex.printStackTrace();
				}
				catch(SQLException ex) {
					ex.printStackTrace();
				}
				finally {
					try {
						con.close();
					}
					catch(Exception ex) {
						ex.printStackTrace();
					}
				}
			}
			
			public void Excluir(int id) {
				Connection con = null;
				PreparedStatement ps = null;
				
				try {
					Class.forName(servidor);
					con = DriverManager.getConnection(urlbd,usubd,senhabd);
					
					String sql = ("DELETE FROM usuario WHERE id_usuario = ?");
					
					ps = con.prepareStatement(sql);
					ps.setInt(1,id);
					ps.executeUpdate();
				}
				catch(ClassNotFoundException ex) {
					ex.printStackTrace();
				}catch(SQLException ex) {
					ex.printStackTrace();
				}
				finally {
					try {
						con.close();
					}catch(Exception ex) {
						ex.printStackTrace();
					}
				}
				
			}
			
}

			

