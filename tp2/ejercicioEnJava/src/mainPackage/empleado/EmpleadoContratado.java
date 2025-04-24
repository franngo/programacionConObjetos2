package mainPackage.empleado;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import mainPackage.Concepto;

public class EmpleadoContratado extends Empleado {
	private int numeroContrato;
	private String medioDePago;
	final static double gastosAdministrativosContractuales = 50;
	
	public EmpleadoContratado(String nombre, String direccion, String 
			estadoCivil, Calendar fechaNacimiento, double 
			sueldoBasico, int numeroContrato, String medioDePago) {
		super(nombre, direccion, estadoCivil, fechaNacimiento, sueldoBasico);
		this.numeroContrato = numeroContrato;
		this.medioDePago = medioDePago;
	}
	
	@Override
	public double sueldoBruto() {
		return this.getSueldoBasico();
	}
	
	@Override
	public double retenciones() {
		return gastosAdministrativosContractuales;
	}
	
	@Override
	public Map<String, Concepto> desgloseConceptos() {
		Map<String, Concepto> desglose = new HashMap<String, Concepto>();
		desglose.put("Sueldo Básico", new Concepto("Sueldo Básico", this.getSueldoBasico()));
		desglose.put("Gastos Administrativos Contractuales", new Concepto("Gastos Administrativos Contractuales", gastosAdministrativosContractuales));
		return desglose;
	}

}
