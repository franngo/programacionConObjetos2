package mainPackage.empleado;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import mainPackage.Concepto;

public class PlantaTemporaria extends Empleado {
	private Calendar finDesignacion;
	private int horasExtra;
	final static double montoPorHorasExtra = 40;
	final static double montoRetencionesPorEdad = 25;
	final static double montoRetencionesPorHorasExtra = 5;
	
	public PlantaTemporaria(String nombre, String direccion, String 
			estadoCivil, Calendar fechaNacimiento, double 
			sueldoBasico, Calendar finDesignacion, int 
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
		List<Concepto> desglose = new ArrayList<Concepto>();
		desglose.add(new Concepto("Sueldo Básico", this.getSueldoBasico()));
		desglose.add(new Concepto("Bono por horas extras", this.bonoHorasExtras()));
		desglose.add(new Concepto("Retenciones por Obra Social", this.porcentajeSueldoBruto(this.porcentajeRetencionesObraSocial())));
		desglose.add(new Concepto("Retenciones de Obra Social por edad", this.retencionesPorEdad()));
		desglose.add(new Concepto("Retenciones por Aportes Jubilatorios", this.porcentajeSueldoBruto(this.porcentajeRetencionesAportesJubilatorios())));
		desglose.add(new Concepto("Retenciones de Aportes Jubilatorios por horas extras", this.retencionesPorHorasExtras()));
		return desglose;
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
