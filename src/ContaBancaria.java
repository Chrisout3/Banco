import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class ContaBancaria {
	
	private int numeroConta;
	public String titular;
	private double saldoConta;
	protected Date dataAberturaConta;
	private double limiteConta;
	protected String tipoConta;
	
		
	//conta bancaria
	public ContaBancaria(String tipoConta, int numeroConta) {
		super();
		this.tipoConta = tipoConta;
		this.numeroConta = numeroConta;
		saldoConta = 0;
		dataAberturaConta = new Date();
	}
	
	public void setConta(int Conta, String tipoConta) {
		this.tipoConta = tipoConta;
	}
	
	//numero da conta 
	public int getNumeroConta() {
		return numeroConta;
	}
	//numero da conta 
	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}
	
	//deposito em conta
	protected boolean deposita(double valor) {
		if(valor > 0) {
			this.saldoConta += (valor - valor * 0.10/100);
			
			return true;
		} 
		return false;
	}
	
	// saque em conta 
	
	protected boolean saque(double valor) {
		if(this.saldoConta >= valor && valor > 0) {
			this.saldoConta -= valor;
			
			return true;
		} 
		return false;
	}
	
	
	//titular da conta 
	public void setTitular(String titular) {
		this.titular = titular;
	}
	
	/*
	public boolean transfere(double valor, ContaCliente destino) {
		if(this.saldoConta >=valor) {
			this.saldoConta -= valor;
			destino.deposita(valor);
			return true;
		}
		return false;
	}
	*/
	
	
	//data formatada quando criar conta 
	public String getDateAberturaFormatada() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.format(dataAberturaConta);
	}
	
	// formato para Real
	public String getSaldoFormatado() {
		Locale localeBr = new Locale("pt","BR");
		NumberFormat dinheiro = NumberFormat.getCurrencyInstance(localeBr);
		return dinheiro.format(saldoConta);
	}
	
	// exibir extrato bancario
	public void exibirExtrato() {
		System.out.println("Titular : " + titular + "\n" + "Numero da Conta : " + numeroConta + tipoConta + "\n" + "Data de Abertura " + getDateAberturaFormatada() + "\n" + "Saldo " + getSaldoFormatado());
	}
	
	//verificar saldo em conta 
	public void saldoEmConta() {
		System.out.println("Titular : " + titular + "\n" + "Saldo " +"R$ " + getSaldoFormatado());
		
	}
	
	public String toString() {
		return "Titular : " + this.titular + "\n" + "Numero da Conta : " + numeroConta + tipoConta + "\n" + "Data de Abertura " + getDateAberturaFormatada() + "\n" + "Saldo " + getSaldoFormatado();
		 
	}

	public double getLimiteConta() {
		return limiteConta;
	}

	public void setLimiteConta(double limiteConta) {
		this.limiteConta = limiteConta;
	}

}
