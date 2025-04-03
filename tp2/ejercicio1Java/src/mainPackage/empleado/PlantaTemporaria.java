package mainPackage.empleado;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import mainPackage.Concepto;

public class PlantaTemporaria extends Empleado {
	private GregorianCalendar finDesignacion;
	private int horasExtra;
	final static double montoPorHorasExtra = 40;
	final static double montoRetencionesPorEdad = 25;
	final static double montoRetencionesPorHorasExtra = 5;
	
	public PlantaTemporaria(String nombre, String direccion, String 
			estadoCivil, GregorianCalendar fechaNacimiento, double 
			sueldoBasico, GregorianCalendar finDesignacion, int 
			horasExtra) {
		super(nombre, direccion, estadoCivil, fechaNacimiento, sueldoBasico);
		this.finDesignacion = finDesignacion;
		this.horasExtra = horasExtra;
	}
	
	@Override
	public double sueldoBruto() {
		return this.getSueldoBasico() + this.bonoHorasExtras();
	}
	
	@Override
	public double retenciones() {
		return this.porcentajeSueldoBruto(this.porcentajeRetencionesObraSocial())
		+ this.retencionesPorEdad() + this.porcentajeSueldoBruto(
		this.porcentajeRetencionesAportesJubilatorios()) +
		this.retencionesPorHorasExtras();
	}
	
	@Override
	public List<Concepto> desgloseConceptos() {
		return new ArrayList<Concepto>(); //TERMINAR!!!!
	}
	
	private double bonoHorasExtras() {
		return horasExtra * montoPorHorasExtra;
	}
	
	@Override
	protected int porcentajeRetencionesAportesJubilatorios() {
		return 10;
	}
	
	private double retencionesPorEdad() {
		if(this.edad()>50) {
			return montoRetencionesPorEdad;
		} else {
			return 0;
		}
	}
	
	private double retencionesPorHorasExtras() {
		return horasExtra * montoRetencionesPorHorasExtra;
	}
	
}
