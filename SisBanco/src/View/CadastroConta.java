package View;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

import Controller.*;
import Model.*;

public class CadastroConta extends JFrame {
	public static final long serialVersionUID = 1L;
	
	
	Conta ct = new Conta();
	ContaDB ctdb = new ContaDB();
	
	private JPanel jContentPane = null;
	
	
	private JLabel lblNumCt = null;
	private JLabel lblTipoCt = null;
	private JLabel lblSaldo = null;
	private JLabel lblLimite = null;
	
	private JTextField txtNumCt = null;
	@SuppressWarnings("rawtypes")
	private JComboBox cbbTipo = null;
	private JTextField txtSaldo = null;
	private JTextField txtLimite = null;
	
	private JButton btnConsultar = null;
	private JButton btnPesquisar = null;
	private JButton btnCadastrar = null;
	private JButton btnAlterar = null;
	private JButton btnExcluir = null;
	private JButton btnSair = null;
	
	public CadastroConta() {
		super();
		Initialize();
		
	}
	private void Initialize() {
		this.setSize(500, 500);
		this.setContentPane(getJContentPane());
		this.setLocationRelativeTo(null);
		this.setTitle("Manutenção de Conta");
	}
	
	private JPanel getJContentPane() {
		if(jContentPane == null) {
			lblNumCt = new JLabel();
			lblNumCt.setBounds(new Rectangle(10, 10, 150, 22));
			lblNumCt.setName("lblNumct");
			lblNumCt.setText("Numero da Conta:");
			
			lblTipoCt = new JLabel();
			lblTipoCt.setBounds(new Rectangle(10, 60, 150, 22));
			lblTipoCt.setName("lblTipoCt");
			lblTipoCt.setText("Tipo da Conta");
			
			lblSaldo = new JLabel();
			lblSaldo.setBounds(new Rectangle(10, 110, 150, 22));
			lblSaldo.setName("lblSaldo");
			lblSaldo.setText("Saldo da Conta");
			
			lblLimite = new JLabel();
			lblLimite.setBounds(new Rectangle(10, 160, 150, 22));
			lblLimite.setName("lblLimite");
			lblLimite.setText("Limite da Conta");
			
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			
			jContentPane.add(lblNumCt);
			jContentPane.add(lblTipoCt);
			jContentPane.add(lblSaldo);
			jContentPane.add(lblLimite);
			jContentPane.add(getTxtNumCt());
			jContentPane.add(getCbbTipoCt());
			jContentPane.add(getTxtSaldo());
			jContentPane.add(getTxtLimite());
			
			jContentPane.add(getBtnSair());
			jContentPane.add(getBtnConsultar());
			jContentPane.add(getBtnPesquisar());
			jContentPane.add(getBtnCadastrar());
			jContentPane.add(getBtnAlterar());
			jContentPane.add(getBtnExcluir());
			
			}
		return jContentPane;
}
	private JTextField getTxtNumCt() {
		if(txtNumCt == null) {
			txtNumCt = new JTextField();
			txtNumCt.setBounds(new Rectangle(160, 10, 150, 22));
			txtNumCt.setName("txtNumCt");
		}
		return txtNumCt;
	}
	@SuppressWarnings({ "rawtypes", "unchecked"})
	private JComboBox getCbbTipoCt() {
		if(cbbTipo == null) {
			cbbTipo= new JComboBox();
			cbbTipo.setBounds(new Rectangle(160, 60, 150, 22));
			cbbTipo.setName("cbbTipoCt");
			cbbTipo.addItem("Conta Corrente");
			cbbTipo.addItem("Conta Poupança");
		}
		return cbbTipo;
	}
	private JTextField getTxtSaldo() {
		if(txtSaldo == null) {
			txtSaldo = new JTextField();
			txtSaldo.setBounds(new Rectangle(160,110,100,22));
			txtSaldo.setName("txtSaldo");
			}
		return txtSaldo;
		}
	private JTextField getTxtLimite() {
		if(txtLimite == null) {
			txtLimite = new JTextField();
			txtLimite.setBounds(new Rectangle(160,160,100,22));
			txtLimite.setName("txtLimite");
		}
		return txtLimite;
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
	
	private JButton getBtnConsultar() {
		if(btnConsultar == null) {
			btnConsultar = new JButton();
			btnConsultar.setBounds(new Rectangle(10,300,100,25));
			btnConsultar.setName("btnConsultar");
			btnConsultar.setText("Consultar");
			btnConsultar.addActionListener(new java.awt.event.ActionListener() {
			
				@Override
				public void actionPerformed(ActionEvent arg0) {
					ctdb.ConsultarConta();
				}
			});
		}
		return btnConsultar;
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
	private JButton getBtnCadastrar() {
		if(btnCadastrar == null) {
			btnCadastrar = new JButton();
			btnCadastrar.setBounds(new Rectangle(10, 240, 100, 25));
			btnCadastrar.setName("btnCadastrar");
			btnCadastrar.setText("Cadastrar");
			btnCadastrar.addActionListener(new java.awt.event.ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					ct.setNumConta(txtNumCt.getText());
					ct.setTipoConta(cbbTipo.getSelectedItem().toString());
					ct.setSaldo(Double.parseDouble(txtSaldo.getText()));
					ct.setLimite(Double.parseDouble(txtLimite.getText()));
					
					try {
						ctdb.Incluir(ct);
						JOptionPane.showMessageDialog(null, "Conta Cadastrada");
						Limpar();
					}
					catch(Exception ex) {
						ex.printStackTrace();
					}
				}				
			});
		}
		return btnCadastrar;
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
					ct.setNumConta(txtNumCt.getText());
					ct.setSaldo(Double.parseDouble(txtSaldo.getText()));
					ct.setLimite(Double.parseDouble(txtLimite.getText()));
					
					
					try {
						ctdb.Altera(ct);
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
	
	
	private JButton getBtnExcluir() {
		if(btnExcluir == null) {
			btnExcluir = new JButton();
			btnExcluir.setBounds(new Rectangle(240, 275, 100, 25));
			btnExcluir.setName("btnExcluir");
			btnExcluir.setText("Excluir");
			btnExcluir.addActionListener(new java.awt.event.ActionListener() {

				private JLabel txtId;

				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						ctdb.Exclui(Integer.parseInt(txtId.getText()));
						JOptionPane.showMessageDialog(null, "Produto Excluído");
						Limpar();
					}
					catch(Exception ex) {
						ex.printStackTrace();
					}
				}
			});
		}
		return btnExcluir;
	}
	
	
	public void Limpar() {
		txtNumCt.setText("");
		txtSaldo.setText("");
		txtLimite.setText("");
	}
}

	
	
