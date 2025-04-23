package mainPackage.empleado;

import java.util.Calendar;

abstract public class EmpleadoPlanta extends Empleado {
	
	final static int porcentajeRetencionesObraSocial = 10;
	
	public EmpleadoPlanta(String nombre, String direccion, String estadoCivil,
			Calendar fechaNacimiento, double sueldoBasico) {
		super(nombre, direccion, estadoCivil, fechaNacimiento, sueldoBasico);
	}
	
	double porcentajeSueldoBruto(int porcentaje) {
		return porcentaje * this.sueldoBruto() / 100;
	}
	
	abstract int porcentajeRetencionesAportesJubilatorios();
	
}
