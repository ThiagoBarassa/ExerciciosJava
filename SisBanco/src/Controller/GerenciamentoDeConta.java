package Controller;

import Model.*;
import java.sql.*;
// import javax.swing.JOptionPane;


public class GerenciamentoDeConta {
	
	private String servidor = "com.mysql.cj.jdbc.Driver";
	private String urlbd = "jdbc:mysql://localhost:3306/SisBanco?useTimezone=true&serverTimezone=UTC";
	private String usubd = "root";
	private String senhabd = "";
	
	

	public void Sacar (Conta ct) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try{
			Class.forName(servidor);
			con = DriverManager.getConnection(urlbd,usubd,senhabd);
			
			ct.Sacar();
			
			String sql = "UPDATE conta SET saldo = ?  WHERE num_conta = ? ";
			
			ps = con.prepareStatement(sql);
			
			
			ps.setDouble(1,ct.getSaldo());
			ps.setString(2,ct.getNumConta());
			
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
	public void Depositar (Conta ct) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try{
			Class.forName(servidor);
			con = DriverManager.getConnection(urlbd,usubd,senhabd);
			
			
			String sql = "UPDATE conta SET saldo = ?  WHERE num_conta = ? ";
			
			ps = con.prepareStatement(sql);
			
			
			ps.setDouble(1,ct.getSaldo());
			ps.setString(2,ct.getNumConta());	
			
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
	public GerenciamentoDeConta Pesquisar(Usuario usu, Conta ct, GerenciamentoDeConta geConta) {
		Connection con = null;
		
		try {
			Class.forName(servidor);
			con = DriverManager.getConnection(urlbd, usubd, senhabd);
			
			Statement stmt = con.createStatement();
			
			String sql = "SELECT u.id_user, u.nome,u.cpf,u.rg,c.num_conta,c.tipo_conta, c.saldo,c.limite "
					+ "FROM usuario as u JOIN conta as c ON (u.id_user = c.fkid_user)  " + usu.getId()+ ct.getFkIdUser();
			
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			
			usu.setId(rs.getInt(1));
			ct.setFkIdUser(rs.getInt(2));
			usu.setNome(rs.getString(3));
			usu.setCpf(rs.getString(4));
			usu.setRg(rs.getString(5));
			ct.setNumConta(rs.getString(6));
			ct.setTipoConta(rs.getString(7));
			ct.setSaldo(rs.getDouble(8));
			ct.setLimite(rs.getDouble(9));
			
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
		return geConta;
	}

}
	
