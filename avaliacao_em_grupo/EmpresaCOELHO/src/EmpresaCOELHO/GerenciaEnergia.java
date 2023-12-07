package EmpresaCOELHO;
import java.text.SimpleDateFormat;
import java.util.*;

public class GerenciaEnergia {    

	
	private static ArrayList<Cliente> clientes = new ArrayList<Cliente>() {{
	    add(criarClienteComImovel("Carlos", "11122233344", 103, "Rua X, 30", 8, 2));
	    add(criarClienteComImovel("Ana", "55566677788", 104, "Av Y, 500", 7, 1));
	    add(criarClienteComImovel("Pedro", "99900011122", 105, "Rua Z, 80", 6, 4));
	    add(criarClienteComImovel("Mariana", "33344455566", 106, "Av Principal, 200", 9, 3));
	    add(criarClienteComImovel("Fernanda", "77788899900", 107, "Rua W, 40", 5, 1));
	    add(criarClienteComImovel("Lucas", "22233344455", 108, "Av Secundária, 100", 7, 2));
	    add(criarClienteComImovel("Gabriela", "66677788899", 109, "Rua Y, 60", 8, 0));
	    add(criarClienteComImovel("Rafael", "00011122233", 110, "Av Final, 300", 6, 2));
	    add(criarClienteComImovel("Julia", "44455566677", 111, "Rua Secundária, 70", 4, 1));
	    add(criarClienteComImovel("Gustavo", "88899900011", 112, "Av Inicial, 150", 9, 5));
	}};
    
   	
	public static void incluirCliente() {
	    System.out.println("Incluir Cliente:");
	    System.out.print("Nome: ");
	    scanner.nextLine(); 
	    String nome = scanner.nextLine();
	    
	    String cpf;
	    do {
	        System.out.print("CPF: ");
	        cpf = scanner.nextLine();
	        if (!validarCPF(cpf)) {
	            System.out.println("CPF inválido. Por favor, insira um CPF válido.");
	        }
	    } while (!validarCPF(cpf) || cpfExistente(cpf));

	    Cliente novoCliente = new Cliente(nome, cpf);
	    clientes.add(novoCliente);
	    System.out.println("Cliente incluído com sucesso!");
	}

	private static boolean validarCPF(String cpf) {
	    return cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}");
	}

	private static boolean cpfExistente(String cpf) {
	    for (Cliente cliente : clientes) {
	        if (cliente.getCpf().equals(cpf)) {
	            System.out.println("Não é possível incluir. O CPF " + cpf + " já existe!");
	            return true;
	        }
	    }
	    return false;
	}

	static Imovel buscarImovelPorMatricula(int matricula) {
		for (Cliente cliente : clientes) {
			for (Imovel imovel : cliente.getImoveis()) {
				if (imovel.getMatricula() == matricula) {
					return imovel;
				}
			}
		}
		return null;
	}

	static Cliente buscarClientePorCPF(String cpf) {
		for (Cliente cliente : clientes) {
			if (cliente.getCpf().equals(cpf)) {
				return cliente;
			}
		}
		return null;
	}

	static Fatura buscarFaturaPorId(Long id){
		for(var fatura : faturas){
			if(fatura.getId().equals(id)){
				return fatura;
			}
		}

		return null;
	}

	static Imovel buscarImovelPorMatriculaPorCliente(int matricula, Cliente cliente) {
		for (Imovel imovel : cliente.getImoveis()) {
			if (imovel.getMatricula() == matricula) {
				return imovel;
			}
		}
		return null;
	}

	
	public static void consultarCliente() {
	    System.out.println("Consultar Cliente:");
	    System.out.print("Digite o CPF do cliente a ser consultado: ");
	    scanner.nextLine();
	    String cpfConsulta = scanner.nextLine();

	    Cliente clienteEncontrado = buscarClientePorCPF(cpfConsulta);

	    if (clienteEncontrado != null) {
	        exibirClienteEncontrado(clienteEncontrado);
	    } else {
	        System.out.println("Cliente não encontrado.");
	    }
	}

	public static void listarClientes() {
	    System.out.println("Lista de Clientes:");
	    if (clientes.isEmpty()) {
	        System.out.println("Não há clientes cadastrados.");
	    } else {
	        for (Cliente cliente : clientes) {
	            exibirCliente(cliente);
	        }
	    }
	}

	private static void exibirClienteEncontrado(Cliente cliente) {
	    System.out.println("Cliente encontrado:");
	    exibirCliente(cliente);
	}

	private static void exibirCliente(Cliente cliente) {
	    System.out.println(cliente);
	}

	
	public static void excluirCliente() {
	    System.out.println("Excluir Cliente:");
	    System.out.print("Digite o CPF do cliente a ser excluído: ");
	    scanner.nextLine();
	    String cpfExclusao = scanner.nextLine();

	    if (clientes.isEmpty()) {
	        System.out.println("Não há clientes para excluir.");
	        return;
	    }

	    Iterator<Cliente> iterator = clientes.iterator();
	    while (iterator.hasNext()) {
	        Cliente cliente = iterator.next();
	        if (cliente.getCpf().equals(cpfExclusao)) {
	            iterator.remove();
	            System.out.println("Cliente excluído com sucesso.");
	            return;
	        }
	    }
	    System.out.println("Cliente não encontrado para exclusão.");
	}

	
	 private static Cliente criarClienteComImovel(String nome, String cpf, int matricula, String endereco, int ultimaLeitura, int penultimaLeitura) {
	        Cliente novoCliente = new Cliente(nome, cpf);
	        Imovel novoImovel = new Imovel(matricula, endereco, ultimaLeitura, penultimaLeitura);
	        novoCliente.adicionarImovel(novoImovel);
	        return novoCliente;
	    }
	private static ArrayList<Fatura> faturas = new ArrayList<>();
	
	private static Scanner scanner = new Scanner(System.in);
	
	public static void alterarCliente() {
	    System.out.println("Alterar Cliente:");
	    
	    scanner.nextLine();
	    System.out.print("CPF: ");
	    String cpfAlteracao = scanner.nextLine();

	    Cliente clienteExistente = buscarClientePorCPF(cpfAlteracao);

	    if (clienteExistente != null) {
	        System.out.println("Digite o novo nome: ");
	        String novoNome = scanner.nextLine();
	        System.out.println("Digite o novo CPF: ");
	        String novoCpf = scanner.nextLine();

	        if (!novoCpf.equals(cpfAlteracao)) {
	            Cliente clienteNovoCpf = buscarClientePorCPF(novoCpf);
	            if (clienteNovoCpf != null) {
	                System.out.println("Não é possível alterar. O CPF " + novoCpf + " já existe!");
	                return;
	            }
	        }

	        clienteExistente.setNome(novoNome);
	        clienteExistente.setCpf(novoCpf);
	        System.out.println("Cliente alterado com sucesso.");
	    } else {
	        System.out.println("Cliente não encontrado para alteração.");
	    }
	}

	public static void incluirImovel() {
	    System.out.println("Incluir Imóvel:");
	    System.out.println("Informe o CPF do cliente: ");
	    String cpfCliente = scanner.next();

	    Cliente cliente = buscarClientePorCPF(cpfCliente);

	    if (cliente == null) {
	        System.out.println("Cliente não encontrado para inclusão de Imóvel.");
	        return;
	    }

	    System.out.print("Matrícula: ");
	    int matricula = scanner.nextInt();
	    Imovel existeImovelMatricula = buscarImovelPorMatricula(matricula);

	    if (existeImovelMatricula != null) {
	        System.out.println("Não é possível incluir o imóvel. A matrícula " + matricula + " já existe!");
	        return;
	    }

	    System.out.print("Endereço: ");
	    scanner.nextLine();
	    String endereco = scanner.nextLine();

	    int ultimaLeitura = obterLeitura("Digite a última leitura: ");
	    int penultimaLeitura = obterLeitura("Digite a penúltima leitura: ");

	    while (ultimaLeitura < penultimaLeitura) {
	        System.out.println("A última leitura deve ser maior que a penúltima leitura. Tente novamente.");
	        ultimaLeitura = obterLeitura("Digite a última leitura: ");
	        penultimaLeitura = obterLeitura("Digite a penúltima leitura: ");
	    }

	    Imovel novoImovel = new Imovel(matricula, endereco, ultimaLeitura, penultimaLeitura);
	    cliente.adicionarImovel(novoImovel);

	    System.out.println("Imóvel incluído com sucesso!");
	}

	private static int obterLeitura(String mensagem) {
	    System.out.println(mensagem);
	    return scanner.nextInt();
	}

	
	public static void consultarImovel() {
	    System.out.println("Consultar Imóvel:");
	    System.out.print("Digite a Matrícula do imóvel a ser consultado: ");
	    int matriculaConsulta = scanner.nextInt();
	    boolean imovelEncontrado = false;

	    for (Cliente cliente : clientes) {
	        for (Imovel imovel : cliente.getImoveis()) {
	            if (imovel.getMatricula() == matriculaConsulta) {
	                exibirDetalhesImovelEncontrado(imovel);
	                imovelEncontrado = true;
	                break;
	            }
	        }
	        if (imovelEncontrado) {
	            break;
	        }
	    }

	    if (!imovelEncontrado) {
	        System.out.println("Imóvel não encontrado.");
	    }
	}

	private static void exibirDetalhesImovelEncontrado(Imovel imovel) {
	    System.out.println("Imóvel encontrado:");
	    System.out.println(imovel);
	}


	public static void listarImoveis() {
		System.out.println("Lista de Imóveis:");

		for (Cliente cliente : clientes) {
			for (Imovel imovel : cliente.getImoveis()) {
				System.out.println(imovel);
			}
		}
	}

	
	public static void excluirImovel() {
	    System.out.println("Excluir Imóvel:");
	    System.out.print("Digite a Matrícula do imóvel a ser excluído: ");
	    int matriculaExclusao = scanner.nextInt();

	    boolean imovelEncontrado = false;
	    for (Cliente cliente : clientes) {
	        for (Imovel imovel : cliente.getImoveis()) {
	            if (imovel.getMatricula() == matriculaExclusao) {
	                cliente.excluiImovel(imovel);
	                imovelEncontrado = true;
	                break;
	            }
	        }
	        if (imovelEncontrado) {
	            break;
	        }
	    }

	    if (imovelEncontrado) {
	        System.out.println("Imóvel removido com sucesso.");
	    } else {
	        System.out.println("Imóvel não encontrado para exclusão.");
	    }
	}

	
	public static void ajustarImovel() {
	    System.out.println("Alterar Imóvel:");
	    System.out.print("Digite a Matrícula do imóvel a ser alterado: ");
	    int matriculaAlteracao = scanner.nextInt();

	    for (Cliente cliente : clientes) {
	        for (Imovel imovel : cliente.getImoveis()) {
	            if (imovel.getMatricula() == matriculaAlteracao) {
	                alterarDetalhesImovel(imovel);
	                return;
	            }
	        }
	    }

	    System.out.println("Imóvel não encontrado para alteração.");
	}

	private static void alterarDetalhesImovel(Imovel imovel) {
	    System.out.println("Digite o novo endereço: ");
	    scanner.nextLine();
	    String novoEndereco = scanner.nextLine();

	    int novaUltimaLeitura = obterNovaLeitura("Digite a última leitura: ");
	    int novaPenultimaLeitura = obterNovaLeitura("Digite a penúltima leitura: ");

	    imovel.setEndereco(novoEndereco);
	    imovel.setUltimaLeitura(novaUltimaLeitura);
	    imovel.setPenultimaLeitura(novaPenultimaLeitura);
	    
	    System.out.println("Imóvel alterado com sucesso.");
	}

	private static int obterNovaLeitura(String mensagem) {
	    int novaLeitura;
	    do {
	        System.out.println(mensagem);
	        novaLeitura = scanner.nextInt();
	        if (novaLeitura <= 0) {
	            System.out.println("A leitura deve ser um número positivo. Tente novamente.");
	        }
	    } while (novaLeitura <= 0);

	    return novaLeitura;
	}

	
	public static void registrarConsumo() {
	    System.out.println("Informe a matrícula do imóvel: ");
	    int matricula = scanner.nextInt();

	    Imovel imovel = buscarImovelPorMatricula(matricula);

	    if (imovel != null) {
	        int ultimaLeitura = imovel.getUltimaLeitura();
	        int penultimaLeitura = imovel.getPenultimaLeitura();

	        int leituraAtual = obterLeituraAtual(ultimaLeitura);
	        
	        Fatura novaFatura = criarNovaFatura(imovel, ultimaLeitura, penultimaLeitura, leituraAtual);
	        faturas.add(novaFatura);

	        imovel.setPenultimaLeitura(ultimaLeitura);
	        imovel.setUltimaLeitura(leituraAtual);

	        System.out.println("Fatura registrada com sucesso!");
	    } else {
	        System.out.println("Imóvel não encontrado.");
	    }
	}

	private static int obterLeituraAtual(int ultimaLeitura) {
	    int leituraAtual = ultimaLeitura;
	    do {
	        System.out.println("Informe a leitura atual (deve ser maior que a última leitura: " + ultimaLeitura + "): ");
	        leituraAtual = scanner.nextInt();
	        if (leituraAtual <= ultimaLeitura) {
	            System.out.println("A leitura atual deve ser maior que a última leitura. Tente novamente.");
	        }
	    } while (leituraAtual <= ultimaLeitura);

	    return leituraAtual;
	}

	private static Fatura criarNovaFatura(Imovel imovel, int ultimaLeitura, int penultimaLeitura, int leituraAtual) {
	    return new Fatura(imovel, ultimaLeitura, penultimaLeitura);
	}


	
	public static void mostrarFaturasAbertas() {
	    if (faturas.isEmpty()) {
	        System.out.println("Não há faturas cadastradas.");
	        return;
	    }

	    System.out.println("Listagem de Faturas Abertas:");
	    boolean existemFaturasAbertas = false;

	    for (Fatura fatura : faturas) {
	        if (!fatura.isQuitada()) {
	        	exibirDetalhesFaturaImove(fatura);
	            existemFaturasAbertas = true;
	        }
	    }

	    if (!existemFaturasAbertas) {
	        System.out.println("Não há faturas em aberto.");
	    }
	}

	private static void exibirDetalhesFaturaImove(Fatura fatura) {
	    System.out.println("---------------");
	    System.out.println("ID da Fatura: " + fatura.getId());
	    System.out.println("Imóvel: " + fatura.getImovel());
	}

	
	public static void mostrarTodasFaturas() {
	    if (faturas.isEmpty()) {
	        System.out.println("Não há faturas para exibir.");
	        return;
	    }

	    System.out.println("Listagem de Todas as Faturas:");
	    for (Fatura fatura : faturas) {
	    	exibirDetalhesFaturaImovel(fatura);
	    }
	}

	private static void exibirDetalhesFaturaImovel(Fatura fatura) {
	    System.out.println("---------------");
	    System.out.println("ID da Fatura: " + fatura.getId());
	    System.out.println("Imóvel: " + fatura.getImovel());
	}

	
	public static void pagar() {
	    System.out.println("Por favor, informe o CPF do cliente: ");
	    String cpfCliente = scanner.next();

	    Cliente cliente = buscarClientePorCPF(cpfCliente);

	    if (cliente == null) {
	        System.out.println("Cliente não encontrado. Pagamento cancelado.");
	        return;
	    }

	    System.out.printf("Digite a matrícula do imóvel de %s para gerar o pagamento da fatura:%n", cliente.getNome());
	    int matricula = scanner.nextInt();

	    Imovel imovelSelecionado = null;
	    for (var imovel : cliente.getImoveis()) {
	        if (imovel.getMatricula() == matricula) {
	            imovelSelecionado = imovel;
	            break;
	        }
	    }

	    if (imovelSelecionado == null) {
	        System.out.println("Matrícula do imóvel inválida. Pagamento cancelado.");
	        return;
	    }

	    mostrarFaturasDoImovel(imovelSelecionado);
	    long idFatura = selecionarFatura(imovelSelecionado);

	    if (idFatura == -1) {
	        System.out.println("ID da fatura inválido. Pagamento cancelado.");
	        return;
	    }

	    realizarPagamento(idFatura);
	}

	private static void mostrarFaturasDoImovel(Imovel imovel) {
	    System.out.println("Lista de faturas vinculadas ao imóvel:");
	    for (var fatura : faturas) {
	        if (fatura.getImovel().equals(imovel)) {
	            System.out.println(fatura.toString());
	        }
	    }
	}

	private static long selecionarFatura(Imovel imovel) {
	    long idFatura = -1;
	    int quantasFaturas = 0;

	    for (var fatura : faturas) {
	        if (fatura.getImovel().equals(imovel)) {
	            quantasFaturas++;
	            idFatura = fatura.getId();
	        }
	    }

	    if (quantasFaturas > 1) {
	        System.out.println("Por favor, digite o ID da fatura para realizar o pagamento:");
	        return scanner.nextLong();
	    }

	    return idFatura;
	}

	private static void realizarPagamento(long idFatura) {
	    for (var fatura : faturas) {
	        if (fatura.getId().equals(idFatura)) {
	            System.out.println("Digite o valor do pagamento:");
	            double valor = scanner.nextDouble();
	            var pagamento = new Pagamento(valor);

	            fatura.adicionaPagamento(pagamento);
	            System.out.println("Pagamento realizado com sucesso!");
	            return;
	        }
	    }
	    System.out.println("ID da fatura não encontrado. O pagamento não foi realizado.");
	}

	
	public static void mostrarPagamentos() {
	    System.out.println("Lista de pagamentos:");
	    for (var fatura : faturas) {
	        exibirDetalhesFatura(fatura);
	        listarPagamentosDaFatura(fatura);
	    }
	    System.out.println("---------------");
	}

	private static void exibirDetalhesFatura(Fatura fatura) {
	    System.out.println("--------------");
	    System.out.println("Fatura nº: " + fatura.getId());
	    System.out.println("Imovel: " + fatura.getImovel());
	    System.out.println("Pagamentos");
	}

	private static void listarPagamentosDaFatura(Fatura fatura) {
	    for (var pagamento : fatura.getPagamentos()) {
	        exibirDetalhesPagamento(pagamento);
	        exibirReembolsoSeExistir(pagamento);
	    }
	}

	private static void exibirDetalhesPagamento(Pagamento pagamento) {
	    System.out.println("---------------");
	    System.out.println("Data: " + sdf.format(pagamento.getData()));
	    System.out.printf("Valor: R$%.2f%n", pagamento.getValor());
	}

	private static void exibirReembolsoSeExistir(Pagamento pagamento) {
	    if (pagamento.getReembolso() != null) {
	        System.out.println("Reembolso:");
	        System.out.println("Data: " + sdf.format(pagamento.getReembolso().getData()));
	        System.out.printf("Valor: R$%.2f%n", pagamento.getReembolso().getValor());
	    }
	}

	
	public static void mostrarPagamentosDeFatura() {
	    mostrarTodasFaturas();
	    System.out.println("\nDigite o ID da fatura para listar os pagamentos:");
	    Long idFatura = scanner.nextLong();
	    var fatura = buscarFaturaPorId(idFatura);

	    if (fatura != null) {
	        exibirPagamentosDaFatura(fatura);
	    } else {
	        System.out.println("Não foi encontrada nenhuma fatura com este ID!");
	    }
	}

	private static void exibirPagamentosDaFatura(Fatura fatura) {
	    System.out.printf("Pagamentos da fatura de ID %d:%n", fatura.getId());
	    for (var pagamento : fatura.getPagamentos()) {
	        imprimirDetalhesPagamento(pagamento);
	    }
	    System.out.println("---------------");
	}

	private static void imprimirDetalhesPagamento(Pagamento pagamento) {
	    System.out.println("Data: " + sdf.format(pagamento.getData()));
	    System.out.printf("Valor: R$%.2f%n", pagamento.getValor());
	}

	
	public static void mostrarReembolsos() {
	    System.out.println("Lista de reembolsos:");
	    for (var fatura : faturas) {
	        listarReembolsosDaFatura(fatura);
	    }
	}

	private static void listarReembolsosDaFatura(Fatura fatura) {
	    if (!faturaPossuiPagamentos(fatura)) {
	        return;
	    }

	    for (var pagamento : fatura.getPagamentos()) {
	        if (pagamentoPossuiReembolso(pagamento)) {
	            imprimirDetalhesReembolso(pagamento);
	        }
	    }
	}


	private static void imprimirDetalhesReembolso(Pagamento pagamento) {
	    System.out.println("Data: " + sdf.format(pagamento.getReembolso().getData()));
	    System.out.printf("Valor: R$%.2f%n", pagamento.getReembolso().getValor());
	}

	
	public static void mostrarDetalhesReembolsoDeFatura() {
	    mostrarTodasFaturas();
	    System.out.println("\nDigite o ID da fatura:");
	    Long idFatura = scanner.nextLong();
	    var fatura = buscarFaturaPorId(idFatura);

	    if (fatura != null) {
	        if (faturaPossuiPagamentos(fatura)) {
	            exibirReembolso(fatura);
	        } else {
	            System.out.println("Não há reembolso, fatura não possui pagamentos.");
	        }
	    } else {
	        System.out.println("O ID especificado não pertence a nenhuma fatura!");
	    }
	}

	private static boolean faturaPossuiPagamentos(Fatura fatura) {
	    return !fatura.getPagamentos().isEmpty();
	}

	private static void exibirReembolso(Fatura fatura) {
	    boolean reembolsoEncontrado = false;

	    for (var pagamento : fatura.getPagamentos()) {
	        if (pagamentoPossuiReembolso(pagamento)) {
	            System.out.println("Reembolso:");
	            System.out.println("Data: " + sdf.format(pagamento.getReembolso().getData()));
	            System.out.printf("Valor: R$%.2f%n", pagamento.getReembolso().getValor());
	            reembolsoEncontrado = true;
	            break;
	        }
	    }

	    if (!reembolsoEncontrado) {
	        System.out.println("A fatura não possui reembolso!");
	    }
	}

	private static boolean pagamentoPossuiReembolso(Pagamento pagamento) {
	    return pagamento.getReembolso() != null;
	}
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public static ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public static Scanner getScanner() {
		return scanner;
	}

	public static void setClientes(ArrayList<Cliente> clientes) {
		GerenciaEnergia.clientes = clientes;
	}

	public static void setScanner(Scanner scanner) {
		GerenciaEnergia.scanner = scanner;
	}

	public static ArrayList<Fatura> getFaturas() {
		return faturas;
	}

	public static void setFaturas(ArrayList<Fatura> faturas) {
		GerenciaEnergia.faturas = faturas;
	}

}
