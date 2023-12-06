package GESTAOCOELHO;

import java.util.ArrayList;


public class CoelhoEmpresa {
 private ArrayList<Cliente> clientes;

 public CoelhoEmpresa() {
     this.clientes = new ArrayList<>();
 }

 public ArrayList<Cliente> getClientes() {
     return clientes;
 }

 public void addCliente(Cliente cliente) {
     clientes.add(cliente);
 }

 public Cliente getClienteByCpf(String cpf) {
     for (Cliente cliente : clientes) {
         if (cliente.getCpf().equals(cpf)) {
             return cliente;
         }
     }
     return null; // Retorna null se não encontrar um cliente com o CPF fornecido
 }

 public void removeCliente(String cpf) {
     Cliente clienteRemover = null;
     for (Cliente cliente : clientes) {
         if (cliente.getCpf().equals(cpf)) {
             clienteRemover = cliente;
             break;
         }
     }
     if (clienteRemover != null) {
         clientes.remove(clienteRemover);
         System.out.println("Cliente removido com sucesso!");
     } else {
         System.out.println("Cliente não encontrado.");
     }
 }
}
