package MainPackageTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.GregorianCalendar;
import mainPackage.*;
import mainPackage.empleado.*;

public class EmpresaTest {
	PlantaPermanente daniel = new PlantaPermanente("Daniel Zapata", "La Rioja 4072", "Casado", new GregorianCalendar(1990, 3, 21), 850000, 2, 5);
	PlantaTemporaria claudia = new PlantaTemporaria("Claudia Miretti", "San Juan 3200", "Soltero", new GregorianCalendar(1980, 2, 19), 900000, new GregorianCalendar(2025, 9, 1), 6);
	PlantaPermanente graciela = new PlantaPermanente("Graciela López", "Buenos Aires 1083", "Casado", new GregorianCalendar(1985, 11, 5), 1000000, 1, 10);
	
	Empresa fortalezaSeguros = new Empresa("Fortaleza Seguros", "2028493842878");
	
	@BeforeEach
	void setUp() {
		fortalezaSeguros.agregarEmpleado(daniel);
		fortalezaSeguros.agregarEmpleado(claudia);
		fortalezaSeguros.agregarEmpleado(graciela);
	}
	
	@Test
	void totalSueldosNetos() {
		assertEquals(637947.5, daniel.sueldoNeto()); //850000 + 300 + 100 + 250 - 85065 - 40 - 127597.5 = 638000
		assertEquals(720162, claudia.sueldoNeto()); //900000 + 240 - 90024 - 0 - 90024 - 30 = 720162
		assertEquals(750542.5, graciela.sueldoNeto());//1000000 + 150 + 100 + 500 - 100075 - 20 - 150112.5 = 750542.5
		assertEquals(2108652, fortalezaSeguros.totalSueldosNetos());
	}
	
	@Test
	void liquidacionDeSueldos() {
		fortalezaSeguros.realizarLiquidacionesSueldos();
		ReciboHaberes reciboDaniel= daniel.ultimoReciboDeHaberes();
		assertEquals(daniel.sueldoBruto(), reciboDaniel.getSueldoBruto());
		assertEquals(daniel.sueldoNeto(), reciboDaniel.getSueldoNeto());
		assertEquals(7, reciboDaniel.cantidadDeConceptos()); //los PlantaPermanente tienen 7 conceptos en sus recibos
		Concepto conceptoSueldoBasicoDaniel = reciboDaniel.conceptoDelRecibo("Sueldo Básico");
		assertEquals("Sueldo Básico", conceptoSueldoBasicoDaniel.getRazon());
		assertEquals(850000, conceptoSueldoBasicoDaniel.getMonto());
	}
	
	//SE AGREGA UN EMPLEADO CONTRATADO
	@Test
	void totalSueldosNetosAgregandoContratado() {
		EmpleadoContratado carolina = new EmpleadoContratado("Carolina Gómez", "Córdoba 4442", "Soltero", new GregorianCalendar(2003, 3, 21), 400000, 387209, "Transferencia Bancaria a Cuenta Personal");
		fortalezaSeguros.agregarEmpleado(carolina);
		assertEquals(2508602, fortalezaSeguros.totalSueldosNetos()); //el de carolina es 399950
	}
	

}
