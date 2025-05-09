package mainPackage;

import java.util.Map;
import java.util.Calendar;
import java.util.GregorianCalendar;
import mainPackage.empleado.Empleado;

public class ReciboHaberes {
    private String nombre;
    private String direccion;
    private Calendar fechaEmision = GregorianCalendar.getInstance();
    private double sueldoBruto;
    private double sueldoNeto;
    private Map<String, Concepto> desgloseConceptos; 

    public static ReciboHaberes crearReciboHaberes(Empleado empleado ) {
        return new ReciboHaberes(empleado.getNombre(), 
        empleado.getDireccion(), empleado.sueldoBruto(), 
        empleado.sueldoNeto(), empleado.desgloseConceptos() );
    }

    public ReciboHaberes(String nombre, String direccion, double sueldoBruto,
    double sueldoNeto, Map<String, Concepto> desgloseConceptos) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.sueldoBruto = sueldoBruto;
        this.sueldoNeto = sueldoNeto;
        this.desgloseConceptos = desgloseConceptos;
    }

    public double getSueldoBruto() {
        return sueldoBruto;
    }

    public double getSueldoNeto() {
        return sueldoNeto;
    }

    public int cantidadDeConceptos() {
        return desgloseConceptos.size();
    }
    
    //PRECONDICIÓN: Debe haber existir un par con clave coincidente con el String dado por parámetro dentro de desgloseConceptos
    public Concepto conceptoDelRecibo(String concepto) {
    	return desgloseConceptos.get(concepto);
    }

}
