package mainPackage;

public class Concepto {
    private String concepto;
    private double monto;

    public Concepto(String concepto, double monto) {
        this.concepto = concepto;
        this.monto = monto;
    }
    
    public String getRazon() {
    	return concepto;
    }
    
    public double getMonto() {
    	return monto;
    }
}
