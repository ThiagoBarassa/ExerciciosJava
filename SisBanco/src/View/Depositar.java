package View;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

import Controller.*;
import Model.*;

public class Depositar extends JFrame {
	public static final long serialVersionUID = 1L;
	
	GerenciamentoDeConta geConta = new GerenciamentoDeConta();
	Usuario usu = new Usuario();
	UsuarioDB usudb = new UsuarioDB();
	Conta ct = new Conta();
	ContaDB ctdb = new ContaDB();
	
	private JPanel jContentPane = null;
	
	private JLabel lblValor = null;
	private JLabel lblNumCt = null;
	private JLabel lblTipoCt = null;
	private JLabel lblSaldo = null;
	private JLabel lblLimite = null;
	
	private JTextField txtValor = null;
	private JTextField txtNumCt = null;
	@SuppressWarnings("rawtypes")
	private JComboBox cbbTipo = null;
	private JTextField txtSaldo = null;
	private JTextField txtLimite = null;
	private JButton btnPesquisar = null;
	private JButton btnSair = null;
	private JButton btnAlterar = null;
	public Depositar() {
		super();
		Initialize();
		
	}
	private void Initialize() {
		this.setSize(500, 500);
		this.setContentPane(getJContentPane());
		this.setLocationRelativeTo(null);
		this.setTitle("Gerenciamento de Conta");
	}
	private JPanel getJContentPane() {
		if(jContentPane == null) {
			lblNumCt = new JLabel();
			lblNumCt.setBounds(new Rectangle(10, 10, 150, 22));
			lblNumCt.setName("lblNumct");
			lblNumCt.setText("Numero da Conta:");
			
			lblTipoCt = new JLabel();
			lblTipoCt.setBounds(new Rectangle(10, 50, 150, 22));
			lblTipoCt.setName("lblTipoCt");
			lblTipoCt.setText("Tipo da Conta");
			
			lblSaldo = new JLabel();
			lblSaldo.setBounds(new Rectangle(10, 90, 150, 22));
			lblSaldo.setName("lblSaldo");
			lblSaldo.setText("Saldo da Conta");
			
			lblLimite = new JLabel();
			lblLimite.setBounds(new Rectangle(10, 130, 150, 22));
			lblLimite.setName("lblLimite");
			lblLimite.setText("Limite da Conta");
			
			lblValor = new JLabel();
			lblValor.setBounds(new Rectangle(10, 180, 150, 22));
			lblValor.setName("lblNumct");
			lblValor.setText("Valor a ser Depositado:");
			
			
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			
			jContentPane.add(lblNumCt);
			jContentPane.add(lblTipoCt);
			jContentPane.add(lblValor);
			jContentPane.add(lblSaldo);
			jContentPane.add(lblLimite);
			jContentPane.add(getTxtValor());
			jContentPane.add(getTxtNumCt());
			jContentPane.add(getCbbTipoCt());
			jContentPane.add(getTxtSaldo());
			jContentPane.add(getTxtLimite());
			
			jContentPane.add(getBtnSair());
			jContentPane.add(getBtnPesquisar());
			jContentPane.add(getBtnAlterar());
			
			}
		return jContentPane;
}

	private JTextField getTxtNumCt() {
		if(txtNumCt == null) {
			txtNumCt = new JTextField();
			txtNumCt.setBounds(new Rectangle(150, 10, 150, 22));
			txtNumCt.setName("txtNumCt");
		}
		return txtNumCt;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked"})
	private JComboBox getCbbTipoCt() {
		if(cbbTipo == null) {
			cbbTipo= new JComboBox();
			cbbTipo.setBounds(new Rectangle(150, 50, 150, 22));
			cbbTipo.setName("cbbTipoCt");
			cbbTipo.addItem("Conta Corrente");
			cbbTipo.addItem("Conta Poupança");
		}
		return cbbTipo;
	}
	private JTextField getTxtSaldo() {
		if(txtSaldo == null) {
			txtSaldo = new JTextField();
			txtSaldo.setBounds(new Rectangle(150,90,100,22));
			txtSaldo.setName("txtSaldo");
			}
		return txtSaldo;
		}
	private JTextField getTxtLimite() {
		if(txtLimite == null) {
			txtLimite = new JTextField();
			txtLimite.setBounds(new Rectangle(150,130,100,22));
			txtLimite.setName("txtLimite");
		}
		return txtLimite;
	}
	private JTextField getTxtValor() {
		if(txtValor == null) {
			txtValor = new JTextField();
			txtValor.setBounds(new Rectangle(150, 180, 150, 22));
			txtValor.setName("txtValor");
		}
		return txtValor;
	}
	
	private JButton getBtnSair() {
		if(btnSair == null) {
			btnSair = new JButton();
			btnSair.setBounds(new Rectangle(240, 240, 100, 25));
			btnSair.setName("btnSair");
			btnSair.setText("Sair");
			btnSair.addActionListener(new java.awt.event.ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					dispose();
				}
			});
		}
		return btnSair;
	}
	private JButton getBtnPesquisar() {
		if(btnPesquisar == null) {
			btnPesquisar = new JButton();
			btnPesquisar.setBounds(new Rectangle(350, 10, 100, 25));
			btnPesquisar.setName("btnPesquisar");
			btnPesquisar.setText("Pesquisar");
			btnPesquisar.addActionListener(new java.awt.event.ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					Conta ctPesquisa = new Conta();
					
					if(txtNumCt.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Numero da conta invalido");
						txtNumCt.grabFocus();
					}
					else {
						ct.setNumConta((txtNumCt.getText()));
						
						ctPesquisa = ctdb.Pesquisar(ct);
						
						txtNumCt.setText(ctPesquisa.getNumConta());
						txtSaldo.setText(String.valueOf(ctPesquisa.getSaldo()));
						txtLimite.setText(String.valueOf(ctPesquisa.getLimite()));
						
						if(ctPesquisa.getTipoConta().contentEquals("Conta Corrente")) {
							cbbTipo.setSelectedIndex(0);
						}
						else {
							cbbTipo.setSelectedIndex(1);
						}
					}
				}
			});
		}
		return btnPesquisar;
	}
	private JButton getBtnAlterar() {
		if(btnAlterar == null) {
			btnAlterar = new JButton();
			btnAlterar.setBounds(new Rectangle(125, 240, 100, 25));
			btnAlterar.setName("btnAlterar");
			btnAlterar.setText("Alterar");
			btnAlterar.addActionListener(new java.awt.event.ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					ct.setSaldo(Double.parseDouble(txtSaldo.getText()));
					ct.setValor(Double.parseDouble(txtValor.getText()));
					
					try {
						ct.Depositar();
						geConta.Depositar(ct);
						JOptionPane.showMessageDialog(null, "Alteração Concluida");
						Limpar();
					}
					catch(Exception ex) {
						ex.printStackTrace();
					}
				}
			});
		}
		return btnAlterar;
	}
	
	
	public void Limpar() {
		txtNumCt.setText("");
		txtSaldo.setText("");
		txtLimite.setText("");
		txtValor.setText("");
	}
}
