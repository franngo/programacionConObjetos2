package mainPackage.empleado;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import mainPackage.Concepto;
import mainPackage.ReciboHaberes;

abstract public class Empleado {
	private String nombre;
	private String direccion;
	private String estadoCivil;
	private GregorianCalendar fechaNacimiento;
	private double sueldoBasico;
	private List<ReciboHaberes> recibosDeHaberes;
	
	public Empleado(String nombre, String direccion, String estadoCivil,
			GregorianCalendar fechaNacimiento, double sueldoBasico) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.estadoCivil = estadoCivil;
		this.fechaNacimiento = fechaNacimiento;
		this.sueldoBasico = sueldoBasico;
		this.recibosDeHaberes = new ArrayList<ReciboHaberes>();
	}
	
	public int edad() {
		return GregorianCalendar.getInstance().getWeekYear() - 
				fechaNacimiento.getWeekYear();
	}
	
	public double sueldoNeto() {
		return this.sueldoBruto() - this.retenciones();
	}
	
	abstract public double sueldoBruto();
	
	abstract public double retenciones();
	
	abstract public List<Concepto> desgloseConceptos();
	
	public void añadirReciboDeHaberes(ReciboHaberes recibo) {
		recibosDeHaberes.add(recibo);
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public String getEstadoCivil() {
		return estadoCivil;
	}
	
	public double getSueldoBasico() {
		return sueldoBasico;
	}
	
	public ReciboHaberes ultimoReciboDeHaberes() {
		return recibosDeHaberes.getLast();
	}
	
	protected int porcentajeRetencionesObraSocial() {
		return 10;
	}
	
	abstract protected int porcentajeRetencionesAportesJubilatorios();
	
	protected double porcentajeSueldoBruto(int porcentaje) {
		return porcentaje * this.sueldoBruto() / 100;
	}
}
