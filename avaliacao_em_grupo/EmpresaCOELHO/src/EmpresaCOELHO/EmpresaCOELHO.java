package EmpresaCOELHO;

import java.util.ArrayList;

public class EmpresaCOELHO {
	
	public static void MenuInicial() {    

	    final int GESTAO_CLIENTES = 1;
	    final int GESTAO_IMOVEIS = 2;
	    final int GESTAO_FATURAS = 3;
	    final int GESTAO_PAGAMENTOS = 4;
	    final int SAIR = 5;

	    ArrayList<String> menu = new ArrayList<>();
	    menu.add("Gestão de Clientes");
	    menu.add("Gestão de Imóveis");
	    menu.add("Gestão de Faturas");
	    menu.add("Gestão de Pagamentos");
	    menu.add("Sair");
	    
	    int op;

	    do {
	        op = Menu.SelecionarMenu(menu, "Energia Coelho");

	        switch (op) {
	            case GESTAO_CLIENTES:
	                Menu.clientes();
	                break;
	            case GESTAO_IMOVEIS:
	            	Menu.imoveis();
	                break;
	            case GESTAO_FATURAS:
	            	Menu.faturas();
	                break;
	            case GESTAO_PAGAMENTOS:
	            	Menu.pagamentos();
	                break;
	            case SAIR:
	                System.out.println("Finalizado.");
	                break;
	            default:
	                System.out.println("Opção inválida, por favor, escolha uma opção válida.");
	                break;
	        }

	    } while (op != SAIR);
	}
    
	public static void main(String[] args) {
		MenuInicial();
	}
	
}
