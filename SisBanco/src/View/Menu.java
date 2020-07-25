package View;
import java.awt.event.ActionEvent;

import javax.swing.*;



public class Menu extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JMenuItem itemUsuario = null;
	private JMenuItem itemPesquisa = null;
	private JMenuItem itemSacar = null;
	private JMenuItem itemDepositar = null;
	private JMenuItem itemConta = null;
	private JMenuItem itemSair = null;
	
	public Menu() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setTitle("Menu Principal");
		
		
		JMenuBar menuBar = new JMenuBar();
		
		
		setJMenuBar(menuBar);
		
		
		JMenu cadastroMenu = new JMenu("Cadastro");
		JMenu gerenciarMenu = new JMenu("Gerenciamento");
		JMenu sairMenu = new JMenu("Sair");
	
		
		
		menuBar.add(cadastroMenu);
		menuBar.add(gerenciarMenu);
		menuBar.add(sairMenu);
	
		
		cadastroMenu.add(getItemUsuario());
		cadastroMenu.add(getItemConta());
		gerenciarMenu.add(getItemDepositar());
		gerenciarMenu.add(getItemSacar());
		gerenciarMenu.add(getItemPesquisa());
		sairMenu.add(getItemSair());
	}
	
	
	private JMenuItem getItemPesquisa() {
		if(itemPesquisa == null) {
			itemPesquisa = new JMenuItem();
			itemPesquisa.setName("itemPesquisa");
			itemPesquisa.setText("Extrato");
			itemPesquisa.addActionListener(new java.awt.event.ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					GerenciamentoConta geConta = new GerenciamentoConta();
					geConta.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					geConta.setVisible(true);
				}
			});
		}
		return itemPesquisa;
	}
	private JMenuItem getItemSacar() {
		if(itemSacar == null) {
			itemSacar = new JMenuItem();
			itemSacar.setName("itemSacar");
			itemSacar.setText("Sacar");
			itemSacar.addActionListener(new java.awt.event.ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					Sacar saConta = new Sacar();
					saConta.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					saConta.setVisible(true);
				}
			});
		}
		return itemSacar;
	}

	private JMenuItem getItemDepositar() {
		if(itemDepositar == null) {
			itemDepositar = new JMenuItem();
			itemDepositar.setName("itemDepositar");
			itemDepositar.setText("Depositar");
			itemDepositar.addActionListener(new java.awt.event.ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					Depositar deConta = new Depositar();
					deConta.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					deConta.setVisible(true);
				}
			});
		}
		return itemDepositar;
	}


	private JMenuItem getItemUsuario() {
		if(itemUsuario == null) {
			itemUsuario = new JMenuItem();
			itemUsuario.setName("itemUsuario");
			itemUsuario.setText("Usuário");
			itemUsuario.addActionListener(new java.awt.event.ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					CadastroUsuario cadUsuario = new CadastroUsuario();
					cadUsuario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					cadUsuario.setVisible(true);
				}
			});
		}
		return itemUsuario;
	}
	
	
		private JMenuItem getItemConta() {
			if(itemConta == null) {
				itemConta = new JMenuItem();
				itemConta.setName("itemConta");
				itemConta.setText("Conta");
				itemConta.addActionListener(new java.awt.event.ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						CadastroConta cadConta = new CadastroConta();
						cadConta.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						cadConta.setVisible(true);
					}
				});
			}
			return itemConta;
		}
	
	private JMenuItem getItemSair() {
		if(itemSair == null) {
			itemSair = new JMenuItem();
			itemSair.setName("itemSair");
			itemSair.setText("Sair");
			itemSair.addActionListener(new java.awt.event.ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);	
				}
			});
		}
		return itemSair;
	}
}

	
