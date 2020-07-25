package Controller;
import java.sql.*;
import javax.swing.JOptionPane;
import Model.*;
	
		public class ContaDB {
		//Driver de conexão com MySQL(servidor)
				private String servidor = "com.mysql.cj.jdbc.Driver";
				
				//URL que identifica o banco de dados
				private String urlbd = "jdbc:mysql://localhost:3306/SisBanco?useTimezone=true&serverTimezone=UTC";
				
				//Usuario do banco de dados
				private String usubd = "root";
				
				//Senha do banco de dados
				private String senhabd = "";
				
				public void ConsultarConta() {
					Connection con = null;
					
					try {
						Class.forName(servidor);
						con = DriverManager.getConnection(urlbd, usubd, senhabd);
						
						Statement stmt = con.createStatement();
						
						String sql = "SELECT * FROM conta";
						
						ResultSet rs = stmt.executeQuery(sql);
						
						String relacao = "Relação de Contas Cadastradas: \n";
						
						while(rs.next()){
							relacao = relacao + "\nid: " + rs.getString(1).toString() + " - Numero da Conta: " + rs.getString(2) +
									" - Tipo da Conta: " + rs.getString(3) + " - Saldo: " + rs.getString(4).toString() +
									" - Limite: "+rs.getString(5).toString();
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
					finally{
						try {
							con.close();
						}
						catch(Exception ex) {
							ex.printStackTrace();
						}
					}
				}
					public Conta Pesquisar(Conta ct) {
						Connection con = null;
						
						try {
							Class.forName(servidor);
							con = DriverManager.getConnection(urlbd, usubd, senhabd);
							
							Statement stmt = con.createStatement();
							
							String sql = "SELECT * FROM conta WHERE num_conta = " + ct.getNumConta();
							
							ResultSet rs = stmt.executeQuery(sql);
							rs.next();
							
							ct.setFkIdUser(rs.getInt(1));
							ct.setNumConta(rs.getString(2));
							ct.setTipoConta(rs.getString(3));
							ct.setSaldo(rs.getDouble(4));
							ct.setLimite(rs.getDouble(5));
							
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
					return ct;
					}
					
					public void Incluir(Conta ct) {
						Connection con = null;
						PreparedStatement ps = null;
						
						try {
							Class.forName(servidor);
							con = DriverManager.getConnection(urlbd,usubd,senhabd);
							
							//Statement stmt = con.createStatement();
							String sql = "INSERT INTO conta VALUES (?,?,?,?,?)";
							
							ps = con.prepareStatement(sql);
							
							ps.setInt(1, ct.getFkIdUser());
							ps.setString(2, ct.getNumConta());
							ps.setString(3,ct.getTipoConta());
							ps.setDouble(4,ct.getSaldo());
							ps.setDouble(5, ct.getLimite());
							
							ps.executeUpdate();
						}
						catch (ClassNotFoundException ex) {
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
					public void Altera(Conta ct) {
						Connection con = null;
						PreparedStatement ps = null;
						
						try{
						Class.forName(servidor);
						con = DriverManager.getConnection(urlbd,usubd,senhabd);
						
						
						String sql = "UPDATE conta SET saldo = ?,limite = ? WHERE num_conta = ? ";
						
						ps = con.prepareStatement(sql);
						
						ps.setDouble(1,ct.getSaldo());
						ps.setDouble(2, ct.getLimite());
						ps.setString(3, ct.getNumConta());
						
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
					
					public void Exclui(int id) {
						Connection con = null;
						PreparedStatement ps = null;
						
						try {
							Class.forName(servidor);
							con = DriverManager.getConnection(urlbd,usubd,senhabd);
							
							
							String sql = "DELETE FROM conta WHERE fk_idUser = ?";
							
							ps = con.prepareStatement(sql);
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
				}

				
				

