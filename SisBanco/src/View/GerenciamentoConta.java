package View;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

import Controller.*;
import Model.*;

public class GerenciamentoConta extends JFrame {
	public static final long serialVersionUID = 1L;
	
	GerenciamentoDeConta geConta = new GerenciamentoDeConta();
	Usuario usu = new Usuario();
	UsuarioDB usudb = new UsuarioDB();
	Conta ct = new Conta();
	ContaDB ctdb = new ContaDB();
	
	private JPanel jContentPane = null;
	
	private JLabel lblId = null;
	private JLabel lblNome = null;
	private JLabel lblCpf = null;
	private JLabel lblRg = null;
	private JLabel lblNumCt = null;
	private JLabel lblTipoCt = null;
	private JLabel lblSaldo = null;
	private JLabel lblLimite = null;
	
	private JTextField txtId = null;
	private JTextField txtNome = null;
	private JTextField txtCpf = null;
	private JTextField txtRg = null;
	private JTextField txtNumCt = null;
	@SuppressWarnings("rawtypes")
	private JComboBox cbbTipo = null;
	private JTextField txtSaldo = null;
	private JTextField txtLimite = null;
	private JButton btnPesquisar = null;
	private JButton btnSair = null;
	public GerenciamentoConta() {
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
			lblId = new JLabel();
			lblId.setBounds(new Rectangle(10, 10, 150, 22));
			lblId.setName("lblId");
			lblId.setText("Identificação:");
			
			lblNome = new JLabel();
			lblNome.setBounds(new Rectangle(10, 40, 150, 22));
			lblNome.setName("lblNome");
			lblNome.setText("Nome do Titular:");
			
			lblCpf = new JLabel();
			lblCpf.setBounds(new Rectangle(10, 70, 150, 22));
			lblCpf.setName("lblCpf");
			lblCpf.setText("CPF:");
			
			lblRg = new JLabel();
			lblRg.setBounds(new Rectangle(10, 100, 150, 22));
			lblRg.setName("lblCpf");
			lblRg.setText("RG:");
			
			lblNumCt = new JLabel();
			lblNumCt.setBounds(new Rectangle(10, 130, 150, 22));
			lblNumCt.setName("lblNumct");
			lblNumCt.setText("Numero da Conta:");
			
			lblTipoCt = new JLabel();
			lblTipoCt.setBounds(new Rectangle(10, 160, 150, 22));
			lblTipoCt.setName("lblTipoCt");
			lblTipoCt.setText("Tipo da Conta");
			
			lblSaldo = new JLabel();
			lblSaldo.setBounds(new Rectangle(10, 190, 150, 22));
			lblSaldo.setName("lblSaldo");
			lblSaldo.setText("Saldo da Conta");
			
			lblLimite = new JLabel();
			lblLimite.setBounds(new Rectangle(10, 220, 150, 22));
			lblLimite.setName("lblLimite");
			lblLimite.setText("Limite da Conta");
			
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			
			jContentPane.add(lblId);
			jContentPane.add(lblNome);
			jContentPane.add(lblCpf);
			jContentPane.add(lblRg);
			jContentPane.add(lblNumCt);
			jContentPane.add(lblTipoCt);
			jContentPane.add(lblSaldo);
			jContentPane.add(lblLimite);
			jContentPane.add(getTxtId());
			jContentPane.add(getTxtNome());
			jContentPane.add(getTxtCpf());
			jContentPane.add(getTxtRg());
			jContentPane.add(getTxtNumCt());
			jContentPane.add(getCbbTipoCt());
			jContentPane.add(getTxtSaldo());
			jContentPane.add(getTxtLimite());
			
			jContentPane.add(getBtnSair());
			jContentPane.add(getBtnPesquisar());
			
			
			}
		return jContentPane;
}
	private JTextField getTxtId() {
		if(txtId ==null) {
			txtId = new JTextField();
			txtId.setBounds(new Rectangle(150, 10, 100, 22));
			txtId.setName("txtId");
			
		}
		return txtId;
		}
	private JTextField getTxtNome() {
		if(txtNome ==null) {
			txtNome = new JTextField();
			txtNome.setBounds(new Rectangle(150, 40, 100, 22));
			txtNome.setName("txtNome");
			
		}
		return txtNome;
		}
	private JTextField getTxtCpf() {
		if(txtCpf == null) {
			txtCpf = new JTextField();
			txtCpf.setBounds(new Rectangle(150,70,100,22));
			txtCpf.setName("txtCpf");
			
		}
		return txtCpf;
	}
	private JTextField getTxtRg() {
		if(txtRg == null) {
			txtRg = new JTextField();
			txtRg.setBounds(new Rectangle(150,100,100,22));
			txtRg.setName("txtRg");
		
		}
		return txtRg;
	}
	private JTextField getTxtNumCt() {
		if(txtNumCt == null) {
			txtNumCt = new JTextField();
			txtNumCt.setBounds(new Rectangle(150, 130, 100, 22));
			txtNumCt.setName("txtNumCt");
		}
		return txtNumCt;
	}
	@SuppressWarnings({ "rawtypes", "unchecked"})
	private JComboBox getCbbTipoCt() {
		if(cbbTipo == null) {
			cbbTipo= new JComboBox();
			cbbTipo.setBounds(new Rectangle(150, 160, 150, 22));
			cbbTipo.setName("cbbTipoCt");
			cbbTipo.addItem("Conta Corrente");
			cbbTipo.addItem("Conta Poupança");
		}
		return cbbTipo;
	}
	private JTextField getTxtSaldo() {
		if(txtSaldo == null) {
			txtSaldo = new JTextField();
			txtSaldo.setBounds(new Rectangle(150,190,100,22));
			txtSaldo.setName("txtSaldo");
			}
		return txtSaldo;
		}
	private JTextField getTxtLimite() {
		if(txtLimite == null) {
			txtLimite = new JTextField();
			txtLimite.setBounds(new Rectangle(150,220,100,22));
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
	private JButton getBtnPesquisar() {
		if(btnPesquisar == null) {
			btnPesquisar = new JButton();
			btnPesquisar.setBounds(new Rectangle(350, 10, 100, 25));
			btnPesquisar.setName("btnPesquisar");
			btnPesquisar.setText("Pesquisar");
			btnPesquisar.addActionListener(new java.awt.event.ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					Usuario usuPesquisar = new Usuario();
					Conta ctPesquisar = new Conta();
					GerenciamentoDeConta geConta = new GerenciamentoDeConta();
					
					if(txtId.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Numero da conta invalido");
						txtId.grabFocus();
					}else if (txtNumCt.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Numero da conta invalido");
						txtNumCt.grabFocus();
					}
					else {
						usu.setId(Integer.parseInt(txtId.getText()));
						ct.setNumConta(txtNumCt.getText());
						usuPesquisar = usudb.Pesquisar(usu);
						ctPesquisar = ctdb.Pesquisar(ct);
						geConta.Pesquisar(usu,ct, geConta);
						
						txtId.setText(String.valueOf(usu.getId()));
						txtNome.setText(usuPesquisar.getNome());
						txtCpf.setText(usuPesquisar.getCpf());
						txtRg.setText(usuPesquisar.getRg());
						txtNumCt.setText(ctPesquisar.getNumConta());
						txtSaldo.setText(String.valueOf(ctPesquisar.getSaldo()));
						txtLimite.setText(String.valueOf(ctPesquisar.getLimite()));
						
						if(ctPesquisar.getTipoConta().contentEquals("Conta Corrente")) {
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
	
	public void Limpar() {
		txtNumCt.setText("");
		txtSaldo.setText("");
		txtLimite.setText("");
	}
}
