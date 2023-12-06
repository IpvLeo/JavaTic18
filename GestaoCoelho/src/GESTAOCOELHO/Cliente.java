
package GESTAOCOELHO;

import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String cpf;
    private ArrayList<Imovel> imoveis;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.imoveis = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public ArrayList<Imovel> getImoveis() {
        return imoveis;
    }

    public void addImovel(Imovel imovel) {
        imoveis.add(imovel);
    }

    public void removeImovel(Imovel imovel) {
        imoveis.remove(imovel);
        System.out.println("Imóvel removido com sucesso!");
    }

    public void setNome(String novoNome) {
        this.nome = novoNome;
    }
}
