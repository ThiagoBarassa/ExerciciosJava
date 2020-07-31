import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.lang.NumberFormatException;

import javax.swing.*;

public class Tela extends JFrame {
	private static final long serialVersionUID = 1L;
	
	Calculadora c = new Calculadora();
	
	
	private JPanel jContentPane = null;
	
	private JLabel lblNum1 = null;
	private JLabel lblNum2 = null;
	private JLabel lblResult = null;
	
	private JTextField txtNum1 = null;
	private JTextField txtNum2 = null;
	private JTextField txtResult = null;
	
	private JButton btnSomar = null;
	private JButton btnSubtrair = null;
	private JButton btnMultiplicar = null;
	private JButton btnDividir = null;
	private JButton btnSeno = null;
	private JButton btnCos = null;
	private JButton btnTan = null;
	private JButton btnPotencia = null;
	private JButton btnRaiz = null;
	private JButton btnLimpar = null;
	private JButton btnSair = null;
	
	public Tela() {
		super();
		Initialize();
	}
	
	private void Initialize() {
		this.setSize(500,500);
		this.setContentPane(getJContentPane());
		this.setLocationRelativeTo(null);
		this.setTitle("Calculadora");
		
	}
	
	private JPanel getJContentPane() {
		if(jContentPane == null) {
			lblNum1 = new JLabel();
			lblNum1.setBounds(new Rectangle(10,10,150,22));
			lblNum1.setName("lblNum1");
			lblNum1.setText("Primeiro numero");
		}
		if(jContentPane == null) {
			lblNum2 = new JLabel();
			lblNum2.setBounds(new Rectangle(10,60,150,22));
			lblNum2.setName("lblNum2");
			lblNum2.setText("Segundo numero");
		}
		if(jContentPane == null) {
			lblResult = new JLabel();
			lblResult.setBounds(new Rectangle(10,110,150,22));
			lblResult.setName("lblResult");
			lblResult.setText("Resultado");
		}
		
		jContentPane = new JPanel();
		jContentPane.setLayout(null);
		
		jContentPane.add(lblNum1);
		jContentPane.add(lblNum2);
		jContentPane.add(lblResult);
		jContentPane.add(getTxtNum1());
		jContentPane.add(getTxtNum2());
		jContentPane.add(getTxtResult());
		
		jContentPane.add(getBtnSomar());
		jContentPane.add(getBtnDividir());
		jContentPane.add(getBtnSubtrair());
		jContentPane.add(getBtnMultiplicar());
		jContentPane.add(getBtnCos());
		jContentPane.add(getBtnSeno());
		jContentPane.add(getBtnTan());
		jContentPane.add(getBtnPotencia());
		jContentPane.add(getBtnRaiz());
		jContentPane.add(getBtnSair());
		jContentPane.add(getBtnLimpar());
		
		
	return jContentPane;
	}
	
	private JTextField getTxtNum1() {
		if(txtNum1 == null) {
			txtNum1 = new JTextField();
			txtNum1.setBounds(new Rectangle(160, 10, 150, 22));
			txtNum1.setName("txtNum1");
		}
		return txtNum1;
	}
	private JTextField getTxtNum2() {
		if(txtNum2 == null) {
			txtNum2 = new JTextField();
			txtNum2.setBounds(new Rectangle(160, 60, 150, 22));
			txtNum2.setName("txtNum2");
		}
		return txtNum2;
	}
	private JTextField getTxtResult() {
		if(txtResult == null) {
			txtResult = new JTextField();
			txtResult.setBounds(new Rectangle(160, 110, 150, 22));
			txtResult.setName("txtResult");
		}
		return txtResult;
	}
	private JButton getBtnSomar() {
		if(btnSomar == null) {
			btnSomar = new JButton();
			btnSomar.setBounds(new Rectangle(10, 240, 100, 25));
			btnSomar.setName("btnSomar");
			btnSomar.setText("Somar");
			btnSomar.addActionListener(new java.awt.event.ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					validaNumero(txtNum1, txtNum2);
						if(txtNum1.getText().isEmpty() || txtNum2.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Adicione um numero");
						txtNum1.grabFocus();
						txtNum2.grabFocus();
					}
					else {
						c.setNum1(Double.parseDouble(txtNum1.getText()));
						c.setNum2(Double.parseDouble(txtNum2.getText()));
						c.Somar(c.getNum1(),c.getNum2());
						txtResult.setText(String.valueOf(c.getResult()));
				
				}
				}
						
			});
			}
		
		return btnSomar;
	}
	
	private JButton getBtnSubtrair() {
		if(btnSubtrair == null) {
			btnSubtrair = new JButton();
			btnSubtrair.setBounds(new Rectangle(120, 240, 100, 25));
			btnSubtrair.setName("btnSubtrair");
			btnSubtrair.setText("Subtrairr");
			btnSubtrair.addActionListener(new java.awt.event.ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					validaNumero(txtNum1, txtNum2);
					if(txtNum1.getText().isEmpty() || txtNum2.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Adicione um numero");
						txtNum1.grabFocus();
						txtNum2.grabFocus();
					}
					else {
					
					c.setNum1(Double.parseDouble(txtNum1.getText()));
					c.setNum2(Double.parseDouble(txtNum2.getText()));
					c.Subtrair(c.getNum1(),c.getNum2());
					
					txtResult.setText(String.valueOf(c.getResult()));
					}
					}
			});
		}
		return btnSubtrair;
	}
	private JButton getBtnDividir() {
		if(btnDividir == null) {
			btnDividir = new JButton();
			btnDividir.setBounds(new Rectangle(230, 240, 100, 25));
			btnDividir.setName("btnSomar");
			btnDividir.setText("Dividir");
			btnDividir.addActionListener(new java.awt.event.ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					validaNumero(txtNum1, txtNum2);
					if(txtNum1.getText().isEmpty() || txtNum2.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Adicione um numero");
						txtNum1.grabFocus();
						txtNum2.grabFocus();
					}
					else if (Double.parseDouble(txtNum2.getText()) != 0) {
					c.setNum1(Double.parseDouble(txtNum1.getText()));
					c.setNum2(Double.parseDouble(txtNum2.getText()));
					c.Dividir(c.getNum1(),c.getNum2());
					
					txtResult.setText(String.valueOf(c.getResult()));
					}
					else {
						JOptionPane.showMessageDialog(null, "Opera��o Invalida");
					}
						
					}
			});
		}
		return btnDividir;
	}
	private JButton getBtnMultiplicar() {
		if(btnMultiplicar == null) {
			btnMultiplicar = new JButton();
			btnMultiplicar.setBounds(new Rectangle(340, 240, 100, 25));
			btnMultiplicar.setName("btnMultiplicar");
			btnMultiplicar.setText("Multiplicar");
			btnMultiplicar.addActionListener(new java.awt.event.ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					validaNumero(txtNum1, txtNum2);
					if(txtNum1.getText().isEmpty() || txtNum2.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Adicione um numero");
						txtNum1.grabFocus();
						txtNum2.grabFocus();
					}
					else {
					c.setNum1(Double.parseDouble(txtNum1.getText()));
					c.setNum2(Double.parseDouble(txtNum2.getText()));
					c.Multiplicar(c.getNum1(),c.getNum2());
				
					txtResult.setText(String.valueOf(c.getResult()));
				}
				}
			});
		}
		return btnMultiplicar;
	}
	private JButton getBtnSeno() {
		if(btnSeno == null) {
			btnSeno = new JButton();
			btnSeno.setBounds(new Rectangle(10, 300, 100, 25));
			btnSeno.setName("btnSeno");
			btnSeno.setText("Seno");
			btnSeno.addActionListener(new java.awt.event.ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					validaNumero(txtNum1);
					if(txtNum1.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Adicione um numero");
						txtNum1.grabFocus();
					}
					else {
					c.setNum1(Double.parseDouble(txtNum1.getText()));
					c.Seno(c.getNum1());
				
					txtResult.setText(String.valueOf(c.getResult()));
					}
				}
			});
		}
		return btnSeno;
	}
	private JButton getBtnCos() {
		if(btnCos == null) {
			btnCos = new JButton();
			btnCos.setBounds(new Rectangle(120, 300, 100, 25));
			btnCos.setName("btnCos");
			btnCos.setText("Cosseno");
			btnCos.addActionListener(new java.awt.event.ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					validaNumero(txtNum1);
					if(txtNum1.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Adicione um numero");
						txtNum1.grabFocus();
					}
					else {
					c.setNum1(Double.parseDouble(txtNum1.getText()));
					c.Cosseno(c.getNum1());
				
					txtResult.setText(String.valueOf(c.getResult()));
					}
				}
			});
		}
		return btnCos;
	}
	private JButton getBtnTan() {
		if(btnTan == null) {
			btnTan = new JButton();
			btnTan.setBounds(new Rectangle(230, 300, 100, 25));
			btnTan.setName("btnTan");
			btnTan.setText("Tangente");
			btnTan.addActionListener(new java.awt.event.ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					validaNumero(txtNum1);
					if(txtNum1.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Adicione um numero");
						txtNum1.grabFocus();
					}
					else {
					c.setNum1(Double.parseDouble(txtNum1.getText()));
					c.Tangente(c.getNum1());
				
					txtResult.setText(String.valueOf(c.getResult()));
					}
				}
			});
		}
		return btnTan;
	}
	private JButton getBtnRaiz() {
		if(btnRaiz == null) {
			btnRaiz = new JButton();
			btnRaiz.setBounds(new Rectangle(340, 300, 100, 25));
			btnRaiz.setName("btnRaiz");
			btnRaiz.setText("Raiz");
			btnRaiz.addActionListener(new java.awt.event.ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					 validaNumero(txtNum1);
					if(txtNum1.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Adicione um numero");
						txtNum1.grabFocus();
					}else {
					c.setNum1(Double.parseDouble(txtNum1.getText()));
					c.Raiz(c.getNum1());
				
					txtResult.setText(String.valueOf(c.getResult()));
					}
					}
			});
		}
		return btnRaiz;
	}
	private JButton getBtnPotencia() {
		if(btnPotencia == null) {
			btnPotencia = new JButton();
			btnPotencia.setBounds(new Rectangle(10, 360, 100, 25));
			btnPotencia.setName("btnPotencia");
			btnPotencia.setText("Potencia");
			btnPotencia.addActionListener(new java.awt.event.ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					validaNumero(txtNum1, txtNum2);
					if(txtNum1.getText().isEmpty() || txtNum2.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Adicione um numero");
						txtNum1.grabFocus();
						txtNum2.grabFocus();
					}
					else {
					c.setNum1(Double.parseDouble(txtNum1.getText()));
					c.setNum2(Double.parseDouble(txtNum2.getText()));
					c.Potencia(c.getNum1(),c.getNum2());
				
					txtResult.setText(String.valueOf(c.getResult()));
					}
				}
			});
		}
		return btnPotencia;
	}
	private JButton getBtnSair() {
		if(btnSair == null) {
			btnSair = new JButton();
			btnSair.setBounds(new Rectangle(350, 10, 100, 25));
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
	private JButton getBtnLimpar() {
		if(btnLimpar == null) {
			btnLimpar = new JButton();
			btnLimpar.setBounds(new Rectangle(350, 60, 100, 25));
			btnLimpar.setName("btnLimpar");
			btnLimpar.setText("Limpar");
			btnLimpar.addActionListener(new java.awt.event.ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					Limpar();
				}
			});
		}
		return btnLimpar;
	}
	
	public void Limpar() {
		txtNum1.setText("");
		txtNum2.setText("");
		txtResult.setText("");
	}
	//metodo
	public static void validaNumero(JTextField txtNum1, JTextField txtNum2) {
		@SuppressWarnings("unused")
		long valor;
		if (txtNum1.getText().length() != 0 || txtNum2.getText().length() != 0) {
		try {
		valor = Long.parseLong(txtNum1.getText());
		valor = Long.parseLong(txtNum2.getText());
		} catch (NumberFormatException ex) {
		JOptionPane.showMessageDialog(null, "Esse Campo s� aceita n�meros", "Informa��o", JOptionPane.INFORMATION_MESSAGE);
		txtNum1.grabFocus();
		txtNum1.setText(""); 
		txtNum2.grabFocus();
		txtNum2.setText(""); 
		}
		}
		}
	//sobrecarga do metodo acima
	public static void validaNumero(JTextField txtNum1) {
		@SuppressWarnings("unused")
		long valor;
		if (txtNum1.getText().length() != 0) {
		try {
		valor = Long.parseLong(txtNum1.getText());
		} catch (NumberFormatException ex) {
		JOptionPane.showMessageDialog(null, "Esse Campo s� aceita n�meros", "Informa��o", JOptionPane.INFORMATION_MESSAGE);
		txtNum1.grabFocus();
		txtNum1.setText(""); 
		 
		}
		}
		}
	

}
