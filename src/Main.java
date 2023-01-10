
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	
	public static ArrayList<ContaBancaria> listaDeContas = new ArrayList<>();

    public static void main(String[] args) throws Exception {
    	
    	
    	//switch case do menu principal//
        int opcao;
        Scanner entrada = new Scanner(System.in);

        do {
            Menu.GerarMenu();
            opcao = entrada.nextInt();

            switch (opcao) {
            	case 1 :
            		CriarConta();
                    break;
                case 2:
                	DepositoConta();
                    break;
                    
                case 3:
                	saqueConta();
                	break;
                	
                case 4:
                	ExtratoConta();
                    break;
                    
                case 5:
                	saldoEmConta();
                	break;
                    
                case 6: ExibirConta();
                	break;
                	
                    
                case 0:
                    System.out.println("Volte Sempre");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }
	
    // switch case para criar conta
    private static void CriarConta() {
    	
    	System.out.println("Criar Conta");
		Scanner criar = new Scanner(System.in);
		
	   	   System.out.println("Digite numero da conta: ");
	   	   

	      	int nConta = Integer.parseInt(criar.nextLine());
	      	System.out.println("Nome Cliente");
	      	String titular = criar.nextLine();
	      	
	      	System.out.println("Tipo Conta");
	      	System.out.println("**Precione enter para escolher conta**");
	      	String tipoConta = criar.nextLine();
	      		
	    
		int opcao2;
		
		do {
			Menu2.GerarMenu2();
			opcao2 = Integer.parseInt(criar.nextLine());
			
			switch (opcao2) {
			
			case 1: 
				tipoConta = "\n" + "Conta Corrente";
			break;
			
			case 2: 
				tipoConta = "\n" + "Conta Poupanca";
			break;
			
			default:
                System.out.println("Opção inválida.");
			}
		}while (tipoConta == null);
		
		
		ContaBancaria contaBancaria = new ContaBancaria(tipoConta, nConta);
		contaBancaria.setTitular(titular);
		listaDeContas.add(contaBancaria);
		
	}
	
    //exibir listagem de contas 
	private static void ExibirConta() {
		System.out.println("**Listas de Contas**" + "\n");
		for(ContaBancaria i: listaDeContas) {
    		System.out.println(i);
    		System.out.println("\n");
    		}
	}

	//depositar em conta especifica
    public static void DepositoConta() {   
    	Scanner entrada = new Scanner(System.in);
    	System.out.println("Digite a conta para deposito");
        int numeroContaEncontrar = Integer.parseInt(entrada.nextLine());
        ContaBancaria contaDeposito = null;
        
        for (ContaBancaria conta : listaDeContas) {
        	if (conta.getNumeroConta() == numeroContaEncontrar) {
        		System.out.println("Conta encontrada!");
        		contaDeposito = conta;
        		break;
        	}
        }
        
        if (contaDeposito == null) {
        	System.out.println("Não encontrou!");
        } else {
        	System.out.println("Valor");
        	double valor = Double.parseDouble(entrada.nextLine());
        	
        	/* contaDeposito.deposita(valor);
        	System.out.println("Foram depositados "+valor+" R$. Saldo atual: "+contaDeposito.getSaldoFormatado());
        	*/
        	if(contaDeposito.deposita(valor)) {
        	System.out.println("Foram depositados "+valor+" R$. Saldo atual: "+contaDeposito.getSaldoFormatado());
            	}else {
            		System.out.println("Não foi possivel depositar");
            	}
        }
    }
        
   
    //puxar extrato da conta
    public static void ExtratoConta() {
    	Scanner entrada = new Scanner(System.in);
    	System.out.println("Digite a conta para extrato");
        int numeroContaEncontrar = Integer.parseInt(entrada.nextLine());
        ContaBancaria exibirExtrato = null;
        
        for (ContaBancaria conta : listaDeContas) {
        	if (conta.getNumeroConta() == numeroContaEncontrar) {
        		System.out.println("Conta encontrada!");
        		conta.exibirExtrato();
        		return;
        	}
        }
        
        System.out.println("Conta não encontrada!");
    }
    
    
    // sacar o valor da conta 
    public static void saqueConta() {
    	Scanner entrada = new Scanner(System.in);
    	System.out.println("Digite a conta para saque");
        int numeroContaEncontrar = Integer.parseInt(entrada.nextLine());
        ContaBancaria saque = null;
        
        for (ContaBancaria conta : listaDeContas) {
        	if (conta.getNumeroConta() == numeroContaEncontrar) {
        		System.out.println("Conta encontrada!" + "\n");
        		saque = conta;
        		break;
        	}
        }
        if (saque == null) {
        	System.out.println("Não encontrou!");
        } else {
        	System.out.println("Digite o valor para sacar:");
        	double valor = Double.parseDouble(entrada.nextLine());
        	
        	if(saque.saque(valor)) {
        	System.out.println("Foram Sacados "+valor+" R$. Saldo atual: "+saque.getSaldoFormatado());
        	}else {
        		System.out.println("Você não tem limite");
        	}
        }
    }
 
    // consultar saldo em conta 
    public static void saldoEmConta() {
    	Scanner entrada = new Scanner(System.in);
    	System.out.println("Digite a conta para ver o saldo");
        int numeroContaEncontrar = Integer.parseInt(entrada.nextLine());
        ContaBancaria saldoEmConta = null;
        
        for (ContaBancaria conta : listaDeContas) {
        	if (conta.getNumeroConta() == numeroContaEncontrar) {
        		System.out.println("Conta encontrada!" + "\n");
        		conta.saldoEmConta();
        		return;
        	}
        }
        
        System.out.println("Conta não encontrada!");
    }
}
