package mainPackage;

import java.util.Collection;
import mainPackage.empleado.Empleado;

public class Empresa {
	private String nombre; 
	private String cuit;
	private Collection<Empleado> empleados;
	
	public Empresa(String nombre, String cuit, Collection<Empleado>
	empleados) {
		this.nombre = nombre;
		this.cuit = cuit;
		this.empleados = empleados;
	}
	
	public double totalSueldosNetos() {
		return empleados.stream()
				.mapToInt((empleado) -> empleado.sueldoNeto())
				.sum();
	}
	
	public double totalSueldosBrutos() {
		return empleados.stream()
				.mapToInt((empleado) -> empleado.sueldoBruto())
				.sum();
	}

	public double totalRetenciones() {
		return empleados.stream()
				.mapToInt((empleado) -> empleado.retenciones())
				.sum();
	}
	
	public void realizarLiquidacionesSueldos() {
		//para cada emp, llamar static de Concepto pasando el emp y el
		//ReciboHaberes resultante se lo hacés guardar al emp con su
		//método para eso
	}
}
