package EmpresaCOELHO;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
static Scanner scanner = new Scanner(System.in);
	
	public static void SystemClear() {
		 
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
	}		 

	public static void faturas() {
	    final int REGISTRAR_CONSUMO = 1;
	    final int LISTAR_FATURAS_ABERTAS = 2;
	    final int LISTAR_TODAS_FATURAS = 3;
	    final int VOLTAR_MENU_PRINCIPAL = 4;

	    int opcao;
	    ArrayList<String> menu = new ArrayList<>();
	    menu.add("Registrar Consumo");
	    menu.add("Listar Faturas Abertas");
	    menu.add("Listar Todas as Faturas");
	    menu.add("Voltar ao Menu Principal");

	    do {
	        opcao = SelecionarMenu(menu, "Sistema de Gerenciamento de Faturas");

	        switch (opcao) {
	            case REGISTRAR_CONSUMO:
	            	GerenciaEnergia.registrarConsumo();
	                break;
	            case LISTAR_FATURAS_ABERTAS:
	            	 GerenciaEnergia.mostrarFaturasAbertas();
	                break;
	            case LISTAR_TODAS_FATURAS:
	            	GerenciaEnergia.mostrarTodasFaturas();
	                break;
	            case VOLTAR_MENU_PRINCIPAL:
	                System.out.println("Voltando ao Menu Principal.");
	                break;
	            default:
	                System.out.println("Opção inválida. Escolha novamente.");
	                break;
	        }

	    } while (opcao != VOLTAR_MENU_PRINCIPAL);
	}

	public static void clientes() {
	    final int INCLUIR_CLIENTE = 1;
	    final int CONSULTAR_CLIENTE = 2;
	    final int LISTAR_CLIENTES = 3;
	    final int EXCLUIR_CLIENTE = 4;
	    final int ALTERAR_CLIENTE = 5;
	    final int VOLTAR_MENU_PRINCIPAL = 6;

	    int opcao;
	    ArrayList<String> menu = new ArrayList<>();
	    menu.add("Incluir Cliente");
	    menu.add("Consultar Cliente");
	    menu.add("Listar Clientes");
	    menu.add("Excluir Cliente");
	    menu.add("Alterar Cliente");
	    menu.add("Voltar ao Menu Principal");

	    do {
	        opcao = SelecionarMenu(menu, "Sistema de Gerenciamento de Clientes");

	        switch (opcao) {
	            case INCLUIR_CLIENTE:
	            	GerenciaEnergia.incluirCliente();
	                break;
	            case CONSULTAR_CLIENTE:
	            	GerenciaEnergia.consultarCliente();
	                break;
	            case LISTAR_CLIENTES:
	            	GerenciaEnergia.listarClientes();
	                break;
	            case EXCLUIR_CLIENTE:
	            	GerenciaEnergia.excluirCliente();
	                break;
	            case ALTERAR_CLIENTE:
	            	GerenciaEnergia.alterarCliente();
	                break;
	            case VOLTAR_MENU_PRINCIPAL:
	                System.out.println("Voltando ao Menu Principal.");
	                break;
	            default:
	                System.out.println("Opção inválida. Escolha novamente.");
	                break;
	        }
	    } while (opcao != VOLTAR_MENU_PRINCIPAL);
	}


	public static void imoveis() {
	    final int INCLUIR_IMOVEL = 1;
	    final int CONSULTAR_IMOVEL = 2;
	    final int LISTAR_IMOVEIS = 3;
	    final int EXCLUIR_IMOVEL = 4;
	    final int AJUSTAR_IMOVEL = 5;
	    final int VOLTAR_MENU_PRINCIPAL = 6;

	    int opcao;
	    ArrayList<String> menu = new ArrayList<>();
	    menu.add("Incluir Imóvel");
	    menu.add("Consultar Imóvel");
	    menu.add("Listar Imóveis");
	    menu.add("Excluir Imóvel");
	    menu.add("Alterar Imóvel");
	    menu.add("Voltar ao Menu Principal");

	    do {
	        opcao = SelecionarMenu(menu, "Sistema de Gerenciamento de Imóveis");

	        switch (opcao) {
	            case INCLUIR_IMOVEL:
	            	GerenciaEnergia.incluirImovel();
	                break;
	            case CONSULTAR_IMOVEL:
	            	GerenciaEnergia.consultarImovel();
	                break;
	            case LISTAR_IMOVEIS:
	            	GerenciaEnergia.listarImoveis();
	                break;
	            case EXCLUIR_IMOVEL:
	            	GerenciaEnergia.excluirImovel();
	                break;
	            case AJUSTAR_IMOVEL:
	            	GerenciaEnergia.ajustarImovel();
	                break;
	            case VOLTAR_MENU_PRINCIPAL:
	                System.out.println("Voltando ao Menu Principal.");
	                break;
	            default:
	                System.out.println("Opção inválida. Escolha novamente.");
	                break;
	        }
	    } while (opcao != VOLTAR_MENU_PRINCIPAL);
	}


	public static void pagamentos() {
	    final int INCLUIR_PAGAMENTO = 1;
	    final int LISTAR_PAGAMENTOS = 2;
	    final int LISTAR_PAGAMENTOS_FATURA = 3;
	    final int EXIBIR_REEMBOLSO_FATURA = 4;
	    final int DETALHES_REEMBOLSO_FATURA = 5;
	    final int SAIR = 6;

	    int opcao;
	    ArrayList<String> menu = new ArrayList<>();
	    menu.add("Incluir pagamento");
	    menu.add("Listar pagamentos");
	    menu.add("Listar pagamentos de uma fatura");
	    menu.add("Exibir reembolso de uma fatura");
	    menu.add("Detalhes de reembolso de uma fatura");
	    menu.add("Voltar ao Menu Principal");

	    do {
	        opcao = SelecionarMenu(menu, "Sistema de Gerenciamento de Pagamentos");

	        switch (opcao) {
	            case INCLUIR_PAGAMENTO:
	                GerenciaEnergia.pagar();
	                break;
	            case LISTAR_PAGAMENTOS:
	                GerenciaEnergia.mostrarPagamentos();
	                break;
	            case LISTAR_PAGAMENTOS_FATURA:
	                GerenciaEnergia.mostrarPagamentosDeFatura();
	                break;
	            case EXIBIR_REEMBOLSO_FATURA:
	                GerenciaEnergia.mostrarReembolsos();
	                break;
	            case DETALHES_REEMBOLSO_FATURA:
	                GerenciaEnergia.mostrarDetalhesReembolsoDeFatura();
	                break;
	            case SAIR:
	                System.out.println("Saindo do Menu de Pagamentos.");
	                break;
	            default:
	                System.out.println("Opção inválida. Escolha novamente.");
	                break;
	        }
	    } while (opcao != SAIR);
	}

	
	public static int SelecionarMenu(ArrayList<String> menu, String titulo) {
	    int opcao;
	    do {
	        System.out.println(titulo);
	        for (int i = 0; i < menu.size(); i++) {
	            System.out.println((i + 1) + ". " + menu.get(i));
	        }

	        try {
	            System.out.print("Selecione uma opção: ");
	            opcao = Integer.parseInt(scanner.nextLine());

	            if (opcao < 1 || opcao > menu.size()) {
	                System.out.println("Opção inválida. Escolha uma opção dentro do intervalo disponível.");
	            }
	        } catch (NumberFormatException e) {
	            System.out.println("Entrada inválida. Por favor, insira um número válido.");
	            opcao = 0;
	        }
	    } while (opcao < 1 || opcao > menu.size());

	    return opcao;
	}
}
