package mainPackage;

import java.util.Collection;
import java.util.ArrayList;
import mainPackage.empleado.Empleado;

public class Empresa {
	private String nombre; 
	private String cuit;
	private Collection<Empleado> empleados;
	
	public Empresa(String nombre, String cuit) {
		this.nombre = nombre;
		this.cuit = cuit;
		this.empleados = new ArrayList<Empleado>();
	}
	
	public Empresa(String nombre, String cuit, Collection<Empleado>
	empleados) {
		this.nombre = nombre;
		this.cuit = cuit;
		this.empleados = empleados;
	}
	
	public void agregarEmpleado(Empleado empleado) {
		empleados.add(empleado);
	}
	
	public double totalSueldosNetos() {
		return empleados.stream()
				.mapToDouble((empleado) -> empleado.sueldoNeto())
				.sum();
	}
	
	public double totalSueldosBrutos() {
		return empleados.stream()
				.mapToDouble((empleado) -> empleado.sueldoBruto())
				.sum();
	}

	public double totalRetenciones() {
		return empleados.stream()
				.mapToDouble((empleado) -> empleado.retenciones())
				.sum();
	}
	
	public void realizarLiquidacionesSueldos() {
		for (Empleado empleado : empleados) {
			ReciboHaberes recibo = ReciboHaberes.crearReciboHaberes(empleado);
			empleado.añadirReciboDeHaberes(recibo);
		}
	}
}
