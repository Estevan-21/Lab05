/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

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
    public ServiciosPacientesTest() {
    }
    
    @Before
    public void setUp() {
            servicepacientes = ServiciosHistorialPacientesFactory.getInstance().getServiciosPaciente();

    }
    @Test
    public void registraElPaciente() throws ExcepcionServiciosPacientes{
        Eps eps1 = new Eps("Compensar", "7289374982-0");
        Paciente paciente1 = new Paciente(11111,"CC", "Juan Perez", java.sql.Date.valueOf("2000-01-01"), eps1);
        servicepacientes.registrarNuevoPaciente(paciente1);
        assertTrue(servicepacientes.consultarPaciente(0,"CC").equals(paciente1));
    }
}
