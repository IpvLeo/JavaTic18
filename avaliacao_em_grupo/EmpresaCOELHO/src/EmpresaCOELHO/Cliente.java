package EmpresaCOELHO;
import java.util.ArrayList;

public class Cliente {

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.imoveis = new ArrayList<>();
    }
    
    private String nome;
    private String cpf;
    private ArrayList<Imovel> imoveis;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public String toString() {
        return "Nome: " + nome + ", CPF: " + cpf;
    }

    public ArrayList<Imovel> getImoveis() {
		return imoveis;
	}

	public void adicionarImovel(Imovel imovel) {
		imoveis.add(imovel);
	}

	public void excluiImovel(Imovel imovel) {
		imoveis.remove(imovel);
	}
}
