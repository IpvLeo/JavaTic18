package GESTAOCOELHO;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        CoelhoEmpresa coelhoEmpresa = new CoelhoEmpresa();

        while (true) {
            System.out.println("========================");
            System.out.println("Menu:");
            System.out.println("========================");
            System.out.println("1. Gestão de Clientes");
            System.out.println("2. Gestão de Imóveis");
            System.out.println("3. Gestão de Faturas");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1: // Gestão de Clientes
                    System.out.println("1. Incluir Cliente");
                    System.out.println("2. Consultar Cliente");
                    System.out.println("3. Listar Clientes");
                    System.out.println("4. Excluir Cliente");
                    System.out.println("5. Alterar Cliente");
                    System.out.print("Escolha uma opção: ");
                    int opcaoCliente = scanner.nextInt();

                    switch (opcaoCliente) {
                        case 1: // Incluir Cliente
                            System.out.print("Digite o nome do cliente: ");
                            String nomeCliente = scanner.next();
                            System.out.print("Digite o CPF do cliente: ");
                            String cpfCliente = scanner.next();
                            Cliente novoCliente = new Cliente(nomeCliente, cpfCliente);
                            coelhoEmpresa.addCliente(novoCliente);
                            System.out.println("Cliente adicionado com sucesso!");
                            break;
                        case 2: // Consultar Cliente
                            System.out.print("Digite o CPF do cliente a ser consultado: ");
                            String cpfConsulta = scanner.next();
                            for (Cliente cliente : coelhoEmpresa.getClientes()) {
                                if (cliente.getCpf().equals(cpfConsulta)) {
                                    System.out.println("Nome: " + cliente.getNome());
                                    System.out.println("CPF: " + cliente.getCpf());
                                    System.out.println("Imóveis:");
                                    for (Imovel imovel : cliente.getImoveis()) {
                                        System.out.println("Endereço: " + imovel.getEndereco());
                                        System.out.println("Última Leitura: " + imovel.getUltimaLeitura());
                                        System.out.println("Penúltima Leitura: " + imovel.getPenultimaLeitura());
                                    }
                                    break;
                                }
                            }
                            break;
                        case 3: // Listar Clientes
                            System.out.println("Lista de Clientes:");
                            for (Cliente cliente : coelhoEmpresa.getClientes()) {
                                System.out.println("Nome: " + cliente.getNome());
                                System.out.println("CPF: " + cliente.getCpf());
                                System.out.println("---------------");
                            }
                            break;
                        case 4: // Excluir Cliente
                            System.out.print("Digite o CPF do cliente a ser excluído: ");
                            String cpfExclusao = scanner.next();
                            coelhoEmpresa.removeCliente(cpfExclusao);
                            System.out.println("Cliente excluído com sucesso!");
                            break;
                        case 5: // Alterar Cliente
                            System.out.print("Digite o CPF do cliente a ser alterado: ");
                            String cpfAlteracao = scanner.next();
                            Cliente clienteAlterar = coelhoEmpresa.getClienteByCpf(cpfAlteracao);

                            if (clienteAlterar != null) {
                                System.out.print("Digite o novo nome do cliente: ");
                                String novoNome = scanner.next();
                                clienteAlterar.setNome(novoNome);

                                System.out.println("Cliente alterado com sucesso!");
                            } else {
                                System.out.println("Cliente não encontrado.");
                            }
                            break;
                        default:
                            System.out.println("Opção inválida para Gestão de Clientes.");
                    }
                    break;

                case 2: // Gestão de Imóveis
                    System.out.println("1. Incluir Imóvel");
                    System.out.println("2. Consultar Imóvel");
                    System.out.println("3. Listar Imóveis");
                    System.out.println("4. Excluir Imóvel");
                    System.out.println("5. Alterar Imóvel");
                    System.out.print("Escolha uma opção: ");
                    int opcaoImovel = scanner.nextInt();

                    switch (opcaoImovel) {
                        case 1: // Incluir Imóvel
                            System.out.print("Digite o endereço do imóvel: ");
                            String enderecoImovel = scanner.next();

                            // Verifica se o próximo token é um double antes de chamar nextDouble
                            while (!scanner.hasNextDouble()) {
                                System.out.println("Por favor, digite um valor numérico para a última leitura do imóvel.");
                                scanner.next(); // Consome o token não numérico
                            }
                            double ultimaLeitura = scanner.nextDouble();

                            System.out.print("Digite a penúltima leitura do imóvel: ");
                            while (!scanner.hasNextDouble()) {
                                System.out.println("Por favor, digite um valor numérico para a penúltima leitura do imóvel.");
                                scanner.next(); // Consome o token não numérico
                            }
                            double penultimaLeitura = scanner.nextDouble();

                            Imovel novoImovel = new Imovel(enderecoImovel, ultimaLeitura, penultimaLeitura);

                            // Supondo que você já tenha um Cliente para associar o imóvel (pode incluir essa lógica)
                            coelhoEmpresa.getClientes().get(0).addImovel(novoImovel);

                            System.out.println("Imóvel adicionado com sucesso!");
                            break;
                        case 2: // Consultar Imóvel
                            System.out.print("Digite o endereço do imóvel a ser consultado: ");
                            String enderecoConsulta = scanner.next();

                            for (Cliente cliente : coelhoEmpresa.getClientes()) {
                                for (Imovel imovel : cliente.getImoveis()) {
                                    if (imovel.getEndereco().equals(enderecoConsulta)) {
                                        System.out.println("Endereço: " + imovel.getEndereco());
                                        System.out.println("Última Leitura: " + imovel.getUltimaLeitura());
                                        System.out.println("Penúltima Leitura: " + imovel.getPenultimaLeitura());
                                        break;
                                    }
                                }
                            }
                            break;
                        case 3: // Listar Imóveis
                            System.out.println("Lista de Imóveis:");

                            for (Cliente cliente : coelhoEmpresa.getClientes()) {
                                for (Imovel imovel : cliente.getImoveis()) {
                                    System.out.println("Endereço: " + imovel.getEndereco());
                                    System.out.println("Última Leitura: " + imovel.getUltimaLeitura());
                                    System.out.println("Penúltima Leitura: " + imovel.getPenultimaLeitura());
                                    System.out.println("---------------");
                                }
                            }
                            break;
                        case 4: // Excluir Imóvel
                            System.out.print("Digite o endereço do imóvel a ser excluído: ");
                            String enderecoExclusao = scanner.next();

                            for (Cliente cliente : coelhoEmpresa.getClientes()) {
                                for (Imovel imovel : cliente.getImoveis()) {
                                    if (imovel.getEndereco().equals(enderecoExclusao)) {
                                        cliente.removeImovel(imovel);
                                        System.out.println("Imóvel excluído com sucesso!");
                                        break;
                                    }
                                }
                            }
                            break;
                        case 5: // Alterar Imóvel
                            System.out.print("Digite o endereço do imóvel a ser alterado: ");
                            String enderecoAlteracao = scanner.next();

                            for (Cliente cliente : coelhoEmpresa.getClientes()) {
                                for (Imovel imovel : cliente.getImoveis()) {
                                    if (imovel.getEndereco().equals(enderecoAlteracao)) {
                                        System.out.print("Digite a nova última leitura do imóvel: ");
                                        double novaUltimaLeitura = scanner.nextDouble();
                                        imovel.setUltimaLeitura(novaUltimaLeitura);

                                        System.out.print("Digite a nova penúltima leitura do imóvel: ");
                                        double novaPenultimaLeitura = scanner.nextDouble();
                                        imovel.setPenultimaLeitura(novaPenultimaLeitura);

                                        System.out.println("Imóvel alterado com sucesso!");
                                        break;
                                    }
                                }
                            }
                            break;
                        default:
                            System.out.println("Opção inválida para Gestão de Imóveis.");
                    }
                    break;

                case 3: // Gestão de Faturas
                    System.out.println("1. Gerar Fatura");
                    System.out.println("2. Listar Todas as Faturas");
                    System.out.println("3. Listar Faturas em Aberto");
                    System.out.print("Escolha uma opção: ");
                    int opcaoFatura = scanner.nextInt();

                    switch (opcaoFatura) {
                        case 1: // Gerar Fatura
                            System.out.print("Digite o endereço do imóvel para gerar a fatura: ");
                            String enderecoFatura = scanner.next();

                            for (Cliente cliente : coelhoEmpresa.getClientes()) {
                                for (Imovel imovel : cliente.getImoveis()) {
                                    if (imovel.getEndereco().equals(enderecoFatura)) {
                                        imovel.gerarFatura();
                                        break;
                                    }
                                }
                            }
                            break;

                        case 2: // Listar Todas as Faturas
                            System.out.println("Lista de Todas as Faturas:");
                            // Percorra todos os clientes e imóveis para listar as faturas
                            for (Cliente cliente : coelhoEmpresa.getClientes()) {
                                for (Imovel imovel : cliente.getImoveis()) {
                                    Fatura faturaImovel = imovel.getFatura();
                                    if (faturaImovel != null) {
                                        System.out.println("Endereço: " + imovel.getEndereco());
                                        System.out.println("Data de Emissão: " + faturaImovel.getDataEmissao());
                                        System.out.println("Leitura Anterior: " + faturaImovel.getLeituraAnterior());
                                        System.out.println("Leitura Atual: " + faturaImovel.getLeituraAtual());
                                        System.out.println("Valor Calculado: " + faturaImovel.getValorCalculado());
                                        System.out.println("Quitada: " + faturaImovel.isQuitada());
                                        System.out.println("---------------");
                                    }
                                }
                            }
                            break;

                        case 3: // Listar Faturas em Aberto
                            System.out.println("Lista de Faturas em Aberto:");
                            // Percorra todos os clientes e imóveis para listar as faturas em aberto
                            for (Cliente cliente : coelhoEmpresa.getClientes()) {
                                for (Imovel imovel : cliente.getImoveis()) {
                                    Fatura faturaImovel = imovel.getFatura();
                                    if (faturaImovel != null && !faturaImovel.isQuitada()) {
                                        System.out.println("Endereço: " + imovel.getEndereco());
                                        System.out.println("Data de Emissão: " + faturaImovel.getDataEmissao());
                                        System.out.println("Leitura Anterior: " + faturaImovel.getLeituraAnterior());
                                        System.out.println("Leitura Atual: " + faturaImovel.getLeituraAtual());
                                        System.out.println("Valor Calculado: " + faturaImovel.getValorCalculado());
                                        System.out.println("Quitada: " + faturaImovel.isQuitada());
                                        System.out.println("---------------");
                                    }
                                }
                            }
                            break;

                        default:
                            System.out.println("Opção inválida para Gestão de Faturas.");
                    }
                    break;

                case 4: // Sair
                    System.out.println("Saindo do programa. Obrigado!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
}

