/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managebeans;


import edu.eci.pdsw.samples.entities.Eps;
import edu.eci.pdsw.samples.entities.Paciente;
import edu.eci.pdsw.samples.services.ExcepcionServiciosPacientes;
import edu.eci.pdsw.samples.services.ServiciosHistorialPacientesFactory;
import edu.eci.pdsw.samples.services.ServiciosPacientes;
import edu.eci.pdsw.samples.services.impl.Tupla;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;

import org.primefaces.context.RequestContext;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author 2106913
 */
@ManagedBean(name = "HistorialPacientes")
@SessionScoped
public class RegistroConsultaBean implements Serializable {
    
    public Paciente paciPivote;
    public int nID;
    public String documenType;
    public String name;
    public String date;
    public Eps epsPaci;
    private final Map<Tupla<Integer, String>, Paciente> pacientes;
    private final List<Eps> epsregistradas;
    private final ServiciosPacientes servicepacientes = ServiciosHistorialPacientesFactory.getInstance().getServiciosPaciente();

    

    public RegistroConsultaBean() {
        this.pacientes = new LinkedHashMap<>();
        epsregistradas=new LinkedList<>();
    }
    public void registrarNuevoPaciente(Paciente paciente) throws ExcepcionServiciosPacientes {   
        Eps eps1 = new Eps("Compensar", "7289374982-0");
        epsregistradas.add(eps1);
        Paciente paciente1 = new Paciente(11111,"CC", "Juan Perez", java.sql.Date.valueOf("2000-01-01"), eps1);
        registrarNuevoPaciente(paciente1);
        pacientes.put(new Tupla<>(paciente.getId(), paciente.getTipoId()), paciente);
        System.out.println("pac interfaz"+paciente.getId());
    }
    public void setnID(int nID){
        this.nID = nID;
    }
    public void setdocumenType(String documenType){
        this.documenType = documenType;
    }
    public void setname(String name){
        this.name = name;
    }
    public void setdate(String date){
        this.date  = date;
    }
    public void setepsPaci(Eps epsPaci){
        this.epsPaci = epsPaci;
    }
    public int getnID(){
        return nID;
    }
    public String getdocumenType(){
        return documenType;
    }
    public String getname(){
        return name;
    }
    public String getdate(){
        return date;
    }
    public Eps getepsPaci(){
        return epsPaci;
    }
   
    public void showMessage(String estado, String mensaje) {
        FacesMessage message;
        message = new FacesMessage(FacesMessage.SEVERITY_INFO, estado, mensaje);
        RequestContext.getCurrentInstance().showMessageInDialog(message);
    }


}
