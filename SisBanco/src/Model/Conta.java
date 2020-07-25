package Model;
import javax.swing.JOptionPane;
public class Conta {
	private int fkid_user;
	private String numConta, tipoConta;
	private double saldo = 0, limite = 0, valor = 0;
	
	public Conta() {
		this(0,"","",0.0,0.0, 0.0);
	}
	public Conta(int fkid_user, String numConta,String tipoConta, double saldo, double limite, double valor) {
		this.fkid_user = fkid_user;
		this.numConta = numConta;
		this.tipoConta = tipoConta;
		this.saldo = saldo;
		this.limite = limite;
		this.valor = valor;
	}
	public int getFkIdUser() {
		return fkid_user;
	}
	public void setFkIdUser(int fkid_user) {
		this.fkid_user = fkid_user;
	}
	public String getNumConta() {
		return numConta;
	}
	public void setNumConta(String numConta) {
		this.numConta = numConta;
	}
	public String getTipoConta() {
		return tipoConta;
	}
	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public double getLimite() {
		return limite;
	}
	public void setLimite(double limite) {
		this.limite = limite;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public double Sacar() {
	if (valor > saldo) {
		JOptionPane.showMessageDialog(null, "Saldo Insuficiente");
		return 0;
	}
	else {
		saldo -= valor;
	}
	return valor;
	}
	
	public void Depositar() {
		saldo += valor;
	}
}
