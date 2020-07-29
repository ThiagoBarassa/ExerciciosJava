import java.lang.Math;

public class Calculadora {
	private double num1;
	private double num2;
	private double result;
	
	
	public double getResult() {
		return result;
	}
	public void setResult(double result) {
		this.result = result;
	}
	public double getNum1() {
		return num1;
	}
	public void setNum1(double num1) {
		this.num1 = num1;
	}
	public double getNum2() {
		return num2;
	}
	public void setNum2(double num2) {
		this.num2 = num2;
	}
	
	public double Somar(double num1, double num2) {
		this.setResult(getNum1() + getNum2());
		
		return result;
	}
	public double Subtrair(double num1, double num2) {
		this.setResult(getNum1() - getNum2());
		return result;
	}
	public double Multiplicar(double num1, double num2) {
		this.setResult(getNum1() * getNum2());
		return result;
	}
	public double Dividir(double num1,double num2) {
		this.setResult(getNum1() / getNum2());
		return result;
	}
	public double Cosseno(double num1) {
		this.setResult(Math.cos(getNum1()));
		return result;
	}
	public double Seno(double num1) {
		this.setResult(Math.sin(getNum1()));
		return result;
	}

	public double Tangente(double num1) {
		this.setResult(Math.tan(getNum1()));
		return result;
	}
	public double Potencia(double num1,double num2) {
		this.setResult(Math.pow(getNum1(), getNum2()));
		return result;
	}
	public double Raiz(double num1) {
		this.setResult(Math.sqrt(getNum1()));
		return result;
	}
}