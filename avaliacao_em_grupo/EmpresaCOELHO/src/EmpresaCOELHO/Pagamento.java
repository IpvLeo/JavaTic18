package EmpresaCOELHO;

import java.util.Date;

public class Pagamento {  
    public Pagamento(double  valor){
        data =  new Date();
        this.valor =  valor;
    }
    
    private Date data;
    private double valor;
    private Reembolso reembolso;

    public void geraReembolso(double valor){
        reembolso = new Reembolso(valor);
    }

    public Date getData() {
        return data;
    }

    public double getValor() {
        return valor;
    }

    public Reembolso getReembolso() {
        return reembolso;
    }
}
