package mainPackage.empleado;

import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;

import mainPackage.Concepto;

public class PlantaPermanente extends EmpleadoPlanta {
	private int cantidadHijos;
	private int antiguedad;
	final static double montoAsignacionPorHijo = 150;
	final static double montoAsignacionPorConyuge = 100;
	final static double montoAsignacionPorAntiguedad = 50;
	final static double montoObraSocialPorHijo = 20;
	
	public PlantaPermanente(String nombre, String direccion, String 
			estadoCivil, Calendar fechaNacimiento, double 
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
		return this.porcentajeSueldoBruto(EmpleadoPlanta.porcentajeRetencionesObraSocial)
		+ this.retencionesObraSocialPorHijos() + this.porcentajeSueldoBruto(
		this.porcentajeRetencionesAportesJubilatorios());
	}
	
	@Override
	public Map<String, Concepto> desgloseConceptos() {
		Map<String, Concepto> desglose = new HashMap<String, Concepto>();
		desglose.put("Sueldo Básico", new Concepto("Sueldo Básico", this.getSueldoBasico()));
		desglose.put("Asignación por hijo", new Concepto("Asignación por hijo", this.asignacionPorHijo()));
		desglose.put("Asignación por conyuge", new Concepto("Asignación por conyuge", this.asignacionPorConyuge()));
		desglose.put("Bono por antiguedad", new Concepto("Bono por antiguedad", this.bonoPorAntiguedad()));
		desglose.put("Retenciones por Obra Social", new Concepto("Retenciones por Obra Social", this.porcentajeSueldoBruto(EmpleadoPlanta.porcentajeRetencionesObraSocial)));
		desglose.put("Retenciones por Obra Social de los hijos", new Concepto("Retenciones por Obra Social de los hijos", this.retencionesObraSocialPorHijos()));
		desglose.put("Retenciones por Aportes Jubilatorios", new Concepto("Retenciones por Aportes Jubilatorios", this.porcentajeSueldoBruto(this.porcentajeRetencionesAportesJubilatorios())));
		return desglose;
	}
	
	private double salarioFamiliar() {
		return this.asignacionPorHijo() + this.asignacionPorConyuge()
		+ bonoPorAntiguedad();
	}
	
	private double asignacionPorHijo() {
		return cantidadHijos * montoAsignacionPorHijo;
	}
	
	private double asignacionPorConyuge() {
		if(this.getEstadoCivil().equalsIgnoreCase("Casado")) {
			return montoAsignacionPorConyuge;
		} else {
			return 0;
		}
	}
	
	private double bonoPorAntiguedad() {
		return antiguedad * montoAsignacionPorAntiguedad;
	}
	
	@Override
	int porcentajeRetencionesAportesJubilatorios() {
		return 15;
	}
	
	private double retencionesObraSocialPorHijos() {
		return cantidadHijos * montoObraSocialPorHijo;
	}
	
}
