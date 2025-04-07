package mainPackage;

public class ReciboHaberes {
    private String nombre;
    private String direccion;
    private GregorianCalendar fechaEmision = GregorianCalendar.getInstance();
    private double sueldoBruto;
    private double sueldoNeto;
    private List<Concepto> desgloseConceptos;

    public static ReciboHaberes crearReciboHaberes(Empleado empleado ) {
        return new ReciboHaberes(empleado.getNombre(), 
        empleado.getDireccion(), empleado.getSueldoBruto(), 
        empleado.getSueldoNeto(), empleado.desgloseConceptos() );
    }

    public ReciboHaberes(String nombre, String direccion, double sueldoBruto,
    double sueldoNeto, List<Concepto> desgloseConceptos) {
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

}
