/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managebeans;

import edu.eci.pdsw.samples.entities.Eps;
import edu.eci.pdsw.samples.entities.Paciente;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import edu.eci.pdsw.samples.services.impl.Tupla;
/**
 *
 * @author hp
 */
public class RegistroPacienteBean {
    public int nID;
    public String documenType;
    public String name;
    public String date;
    public Eps epsPaci;
    private final Map<Tupla<Integer, String>, Paciente> pacientes;
    private final List<Eps> epsregistradas;
    
    public RegistroPacienteBean(){
        this.pacientes = new LinkedHashMap<>();
        epsregistradas=new LinkedList<>();
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
}