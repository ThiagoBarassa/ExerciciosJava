package View;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

import Controller.*;
import Model.*;

public class CadastroUsuario extends JFrame {
	public static final long serialVersionUID = 1L;
	
	Usuario usu = new Usuario();
	UsuarioDB usudb = new UsuarioDB();
	
	private JPanel JContentPane = null;
	
	private JLabel lblId = null;
	private JLabel lblNome = null;
	private JLabel lblCpf = null;
	private JLabel lblRg = null;
	private JLabel lblEstado = null;
	private JLabel lblCidade = null;
	private JLabel lblEndereco = null;
	private JLabel lblCep = null;
	private JLabel lblTelefone = null;
	
	private JTextField txtId = null;
	private JTextField txtNome = null;
	private JTextField txtCpf = null;
	private JTextField txtRg = null;
	private JTextField txtEstado = null;
	private JTextField txtCidade = null;
	private JTextField txtEndereco = null;
	private JTextField txtCep = null;
	private JTextField txtTelefone = null;
	
	private JButton btnConsultar = null;
	private JButton btnPesquisar = null;
	private JButton btnCadastrar = null;
	private JButton btnAlterar = null;
	private JButton btnExcluir = null;
	private JButton btnSair = null;
	
	public CadastroUsuario() {
		super();
		Initialize();
	}
	
	public void Initialize() {
		this.setSize(500, 500);
		this.setContentPane(getJContentPane());
		this.setLocationRelativeTo(null);
		this.setTitle("Manutenção de Usuario");
	}
	
	private JPanel getJContentPane() {
		if(JContentPane == null) {
			lblId = new JLabel();
			lblId.setBounds(new Rectangle (10, 10, 150, 22));
			lblId.setName("lblId");
			lblId.setText("ID do Usuario");
			
			lblNome = new JLabel();
			lblNome.setBounds(new Rectangle (10, 50, 150, 22));
			lblNome.setName("lblNome");
			lblNome.setText("Nome: ");
			
			lblCpf = new JLabel();
			lblCpf.setBounds(new Rectangle (10, 90, 150, 22));
			lblCpf.setName("lblCpf");
			lblCpf.setText("CPF: ");
			
			lblRg = new JLabel();
			lblRg.setBounds(new Rectangle (10, 130, 150, 22));
			lblRg.setName("lblRg");
			lblRg.setText("RG: ");
			
			lblEstado = new JLabel();
			lblEstado.setBounds(new Rectangle (10, 170, 150, 22));
			lblEstado.setName("lblEstado");
			lblEstado.setText("Estado: ");
			
			lblCidade = new JLabel();
			lblCidade.setBounds(new Rectangle (10, 210, 150, 22));
			lblCidade.setName("lblCidade");
			lblCidade.setText("Cidade: ");
			
			lblEndereco = new JLabel();
			lblEndereco.setBounds(new Rectangle (10, 250, 150, 22));
			lblEndereco.setName("lblEndereco");
			lblEndereco.setText("Endereço: ");
			
			lblCep = new JLabel();
			lblCep.setBounds(new Rectangle (10, 290, 150, 22));
			lblCep.setName("lblCep");
			lblCep.setText("CEP: ");
			
			lblTelefone = new JLabel();
			lblTelefone.setBounds(new Rectangle (10, 330, 150, 22));
			lblTelefone.setName("lblTelefone");
			lblTelefone.setText("Telefone: ");
			
			JContentPane = new JPanel();
			JContentPane.setLayout(null);
			
			JContentPane.add(lblId);
			JContentPane.add(lblNome);
			JContentPane.add(lblCpf);
			JContentPane.add(lblRg);
			JContentPane.add(lblEstado);
			JContentPane.add(lblCidade);
			JContentPane.add(lblEndereco);
			JContentPane.add(lblCep);
			JContentPane.add(lblTelefone);
			JContentPane.add(getTxtId());
			JContentPane.add(getTxtNome());
			JContentPane.add(getTxtCpf());
			JContentPane.add(getTxtRg());
			JContentPane.add(getTxtEstado());
			JContentPane.add(getTxtCidade());
			JContentPane.add(getTxtEstado());
			JContentPane.add(getTxtEndereco());
			JContentPane.add(getTxtCep());
			JContentPane.add(getTxtTelefone());
			
			JContentPane.add(getBtnSair());
			JContentPane.add(getBtnConsultar());
			JContentPane.add(getBtnPesquisar());
			JContentPane.add(getBtnCadastrar());
			JContentPane.add(getBtnAlterar());
			JContentPane.add(getBtnExcluir());
			
			
			
		}
		return JContentPane;
	}
	private JTextField getTxtId() {
		if(txtId == null) {
			txtId = new JTextField();
			txtId.setBounds(new Rectangle(100,10,100,22));
			txtId.setName("txtId");
			
		}
		return txtId;
	}
	
	private JTextField getTxtNome() {
		if(txtNome ==null) {
			txtNome = new JTextField();
			txtNome.setBounds(new Rectangle(100, 50, 100, 22));
			txtNome.setName("txtNome");
			
		}
		return txtNome;
		}
	private JTextField getTxtCpf() {
		if(txtCpf == null) {
			txtCpf = new JTextField();
			txtCpf.setBounds(new Rectangle(100,90,100,22));
			txtCpf.setName("txtCpf");
			
		}
		return txtCpf;
	}
	private JTextField getTxtRg() {
		if(txtRg == null) {
			txtRg = new JTextField();
			txtRg.setBounds(new Rectangle(100,130,100,22));
			txtRg.setName("txtRg");
		
		}
		return txtRg;
	}
	private JTextField getTxtEstado() {
		if(txtEstado == null) {
			txtEstado = new JTextField();
			txtEstado.setBounds(new Rectangle(100,170,100,22));
			txtEstado.setName("txtEstado");
			
		}return txtEstado;
	}
	private JTextField getTxtCidade() {
		if(txtCidade == null) {
			txtCidade = new JTextField();
			txtCidade.setBounds(new Rectangle(100,210,100,22));
			txtCidade.setName("txtCidade");
			
		}
		return txtCidade;
	}
	private JTextField getTxtEndereco() {
		if(txtEndereco == null) {
			txtEndereco = new JTextField();
			txtEndereco.setBounds(new Rectangle(100,250,100,22));
			txtEndereco.setName("txtEndereco");
			
		}
		return txtEndereco;
	}
	private JTextField getTxtCep() {
		if(txtCep == null) {
			txtCep = new JTextField();
			txtCep.setBounds(new Rectangle(100,290,100,22));
			txtCep.setName("txtCep");
			
		}
		return txtCep;
	}
	private JTextField getTxtTelefone() {
		if(txtTelefone == null) {
			txtTelefone = new JTextField();
			txtTelefone.setBounds(new Rectangle(100,330,100,22));
			txtTelefone.setName("txtTelefone");
			
		}
		return txtTelefone;
	}
	
	private JButton getBtnSair() {
		if(btnSair == null) {
			btnSair = new JButton();
			btnSair.setBounds(new Rectangle(300, 250, 100, 25));
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
			btnConsultar.setBounds(new Rectangle(300, 210, 100, 25 ));
			btnConsultar.setName("btnConsultar");
			btnConsultar.setText("Consultar");
			btnConsultar.addActionListener(new java.awt.event.ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					usudb.Consultar();
				}
			});
		}return btnConsultar;
	}
	private JButton getBtnPesquisar() {
		if(btnPesquisar == null) {
			btnPesquisar = new JButton();
			btnPesquisar.setBounds(new Rectangle(300,10,100,25));
			btnPesquisar.setName("btnPesquisar");
			btnPesquisar.setText("Pesquisar");
			btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Usuario usuPesquisa = new Usuario();
					
					if(txtId.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "ID invalido");
						txtId.grabFocus();
					}
					else {
						usu.setId(Integer.parseInt(txtId.getText()));
						
						usuPesquisa = usudb.Pesquisar(usu);
						
						txtId.setText(String.valueOf(usuPesquisa.getId()));
						txtNome.setText(usuPesquisa.getNome());
						txtCpf.setText(usuPesquisa.getCpf());
						txtRg.setText(usuPesquisa.getRg());
						txtEstado.setText(usuPesquisa.getEstado());
						txtCidade.setText(usuPesquisa.getCidade());
						txtEndereco.setText(usuPesquisa.getEndereco());
						txtCep.setText(usuPesquisa.getCep());
						txtTelefone.setText(usuPesquisa.getTelefone());
						
					}
				}
			});
		
		}return btnPesquisar;
	}
	private JButton getBtnCadastrar() {
		if(btnCadastrar == null) {
			btnCadastrar = new JButton();
			btnCadastrar.setBounds(new Rectangle(300, 60, 100, 25));
			btnCadastrar.setName("btnCadastrar");
			btnCadastrar.setText("Cadastrar");
			btnCadastrar.addActionListener(new java.awt.event.ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					usu.setNome(txtNome.getText());
					usu.setCpf(txtCpf.getText());
					usu.setRg(txtRg.getText());
					usu.setEstado(txtEstado.getText());
					usu.setCidade(txtCidade.getText());
					usu.setEndereco(txtEndereco.getText());
					usu.setCep(txtCep.getText());
					usu.setTelefone(txtTelefone.getText());
					
					try {
						usudb.Incluir(usu);
						JOptionPane.showMessageDialog(null, "Usuario Cadastrado");
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
			btnAlterar.setBounds(new Rectangle(300, 110, 100, 25));
			btnAlterar.setName("btnAlterar");
			btnAlterar.setText("Alterar");
			btnAlterar.addActionListener(new java.awt.event.ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					usu.setEstado(txtEstado.getText());
					usu.setCidade(txtCidade.getText());
					usu.setEndereco(txtEndereco.getText());
					usu.setCep(txtCep.getText());
					usu.setTelefone(txtTelefone.getText());
					
					try {
						usudb.Alterar(usu);
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
			btnExcluir.setBounds(new Rectangle(300, 160, 100, 25));
			btnExcluir.setName("btnExcluir");
			btnExcluir.setText("Excluir");
			btnExcluir.addActionListener(new java.awt.event.ActionListener() {

				private JLabel txtId;

				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						usudb.Excluir(Integer.parseInt(txtId.getText()));
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
		txtId.setText("");
		txtNome.setText("");
		txtCpf.setText("");
		txtRg.setText("");
		txtEstado.setText("");
		txtCidade.setText("");
		txtEndereco.setText("");
		txtCep.setText("");
		txtTelefone.setText("");
	}
}
