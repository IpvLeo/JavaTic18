package EmpresaCOELHO;

public class Imovel {

	public Imovel(int matricula, String endereco, int ultimaLeitura, int penultimaLeitura) {
		this.matricula = matricula;
		this.endereco = endereco;
		this.ultimaLeitura = ultimaLeitura;
		this.penultimaLeitura = penultimaLeitura;
	}
	
	private int matricula;
	private String endereco;
	private int ultimaLeitura;
	private int penultimaLeitura;

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setUltimaLeitura(int ultimaLeitura) {
		this.ultimaLeitura = ultimaLeitura;
	}

	public void setPenultimaLeitura(int penultimaLeitura) {
		this.penultimaLeitura = penultimaLeitura;
	}

	public int getMatricula() {
		return matricula;
	}

	public String getEndereco() {
		return endereco;
	}

	public int getUltimaLeitura() {
		return ultimaLeitura;
	}

	public int getPenultimaLeitura() {
		return penultimaLeitura;
	}
	

	@Override
	public String toString() {
		return "Matrícula: " + matricula + ", Endereço: " + endereco + ", Última Leitura: " + ultimaLeitura
				+ ", Penúltima Leitura: " + penultimaLeitura;
	}


}
