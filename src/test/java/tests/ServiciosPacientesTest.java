/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import edu.eci.pdsw.samples.entities.Consulta;
import edu.eci.pdsw.samples.entities.Eps;
import edu.eci.pdsw.samples.entities.Paciente;
import edu.eci.pdsw.samples.services.ExcepcionServiciosPacientes;
import edu.eci.pdsw.samples.services.ServiciosHistorialPacientesFactory;
import edu.eci.pdsw.samples.services.ServiciosPacientes;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hcadavid
 */
public class ServiciosPacientesTest {
    private ServiciosPacientes servicepacientes;
    Consulta consulta1;
    Paciente paciente1;
    Eps eps1;
    
    public ServiciosPacientesTest() {
    }
    
    @Before
    public void setUp() {
            servicepacientes = ServiciosHistorialPacientesFactory.getInstance().getServiciosPaciente();

    }
    
    
    @Test
    public void registrarConsulta() throws ExcepcionServiciosPacientes{
        eps1 = new Eps("Compensar", "7289374982-0");
        paciente1 = new Paciente(11111,"CC", "Juan Perez", java.sql.Date.valueOf("2000-01-01"), eps1);
        servicepacientes.registrarNuevoPaciente(paciente1);
        assertTrue(servicepacientes.consultarPaciente(11111,"CC").equals(paciente1));
        consulta1 = new Consulta(java.sql.Date.valueOf("2000-01-01"), "Dolor de cabeza", 454);
        servicepacientes.agregarConsultaPaciente(11111, "CC", consulta1);
        assertEquals("Prueba Registrar consulta satisfactoriamente falló",consulta1,servicepacientes.obtenerConsultasEps("Compensar").get(0));
    }
    @Test
    public void registrarPaciente() throws ExcepcionServiciosPacientes{
        Paciente paciente1 = new Paciente(2222,"CC", "Juan Perez", java.sql.Date.valueOf("2000-01-01"), eps1);
        servicepacientes.registrarNuevoPaciente(paciente1);
        assertTrue(servicepacientes.consultarPaciente(2222,"CC").equals(paciente1));
    }

}
