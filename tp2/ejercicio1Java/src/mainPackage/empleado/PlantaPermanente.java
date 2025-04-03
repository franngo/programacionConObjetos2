package mainPackage.empleado;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.ArrayList;

import mainPackage.Concepto;

public class PlantaPermanente extends Empleado {
	private int cantidadHijos;
	private int antiguedad;
	final static double montoAsignacionPorHijo = 150;
	final static double montoAsignacionPorConyuge = 100;
	final static double montoAsignacionPorAntiguedad = 50;
	final static double montoRetencionesPorHijo = 20;
	
	public PlantaPermanente(String nombre, String direccion, String 
			estadoCivil, GregorianCalendar fechaNacimiento, double 
			sueldoBasico, int cantidadHijos, int antiguedad) {
		super(nombre, direccion, estadoCivil, fechaNacimiento, sueldoBasico);
		this.cantidadHijos = cantidadHijos;
		this.antiguedad = antiguedad;
	}
	
	@Override
	public double sueldoBruto() {
		return this.getSueldoBasico() + this.salarioFamiliar();
	}
	
	@Override
	public double retenciones() {
		return this.porcentajeSueldoBruto(this.porcentajeRetencionesObraSocial())
		+ this.retencionesPorHijo() + this.porcentajeSueldoBruto(
		this.porcentajeRetencionesAportesJubilatorios());
	}
	
	@Override
	public List<Concepto> desgloseConceptos() {
		return new ArrayList<Concepto>(); //TERMINAR!!!!
	}
	
	private double salarioFamiliar() {
		return this.asignacionPorHijo() + this.asignacionPorConyuge()
		+ bonoPorAntiguedad();
	}
	
	private double asignacionPorHijo() {
		return cantidadHijos * montoAsignacionPorHijo;
	}
	
	private double asignacionPorConyuge() {
		if(this.getEstadoCivil()=="Casado") {
			return montoAsignacionPorConyuge;
		} else {
			return 0;
		}
	}
	
	private double bonoPorAntiguedad() {
		return antiguedad * montoAsignacionPorAntiguedad;
	}
	
	private double retencionesPorHijo() {
		return cantidadHijos * montoRetencionesPorHijo;
	}
	
	@Override
	protected int porcentajeRetencionesAportesJubilatorios() {
		return 15;
	}
}
