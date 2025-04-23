package mainPackage.empleado;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Calendar;
import mainPackage.Concepto;
import mainPackage.ReciboHaberes;

abstract public class Empleado {
	private String nombre;
	private String direccion;
	private String estadoCivil;
	private Calendar fechaNacimiento;
	private double sueldoBasico;
	private List<ReciboHaberes> recibosDeHaberes = new ArrayList<ReciboHaberes>();
	
	public Empleado(String nombre, String direccion, String estadoCivil,
			Calendar fechaNacimiento, double sueldoBasico) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.estadoCivil = estadoCivil;
		this.fechaNacimiento = fechaNacimiento;
		this.sueldoBasico = sueldoBasico;
	}
	
	public int edad() {
		return Calendar.getInstance().getWeekYear() - 
				fechaNacimiento.getWeekYear();
	}
	
	public double sueldoNeto() {
		return this.sueldoBruto() - this.retenciones();
	}
	
	abstract public double sueldoBruto();
	
	abstract public double retenciones();
	
	abstract public Map<String, Concepto> desgloseConceptos();
	
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
	
	protected double porcentajeSueldoBruto(int porcentaje) {
		return porcentaje * this.sueldoBruto() / 100;
	}
}
