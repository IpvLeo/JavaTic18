package EmpresaCOELHO;

import java.util.Date;

public class Reembolso {  
    public Reembolso(double valor) {
        data = new Date();
        this.valor= valor;
    }
    
    private Date data;
    private double valor;

    public Date getData() {
        return data;
    }

    public double getValor() {
        return valor;
    }
}
