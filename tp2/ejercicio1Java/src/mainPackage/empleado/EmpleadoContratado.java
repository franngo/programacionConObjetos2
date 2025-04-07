package mainPackage.empleado;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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
	public List<Concepto> desgloseConceptos() {
		List<Concepto> desglose = new ArrayList<Concepto>();
		desglose.add(new Concepto("Sueldo Básico", this.getSueldoBasico()));
		desglose.add(new Concepto("Gastos Administrativos Contractuales", this.retenciones()));
		return desglose;
	}

}
