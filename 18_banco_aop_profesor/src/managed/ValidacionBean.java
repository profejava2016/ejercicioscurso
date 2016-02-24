/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managed;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import modelo.service.GestionCajero;



/**
 *
 * @author Tarde
 */
@ManagedBean
@SessionScoped
public class ValidacionBean {
   
    
    
   
    private int codigoCuenta;
    @ManagedProperty("#{gcajero}")
    GestionCajero gestion;
    public GestionCajero getGestion() {
		return gestion;
	}

	public void setGestion(GestionCajero gestion) {
		this.gestion = gestion;
	}

    public int getCodigoCuenta() {
        return codigoCuenta;
    }

    public void setCodigoCuenta(int codigoCuenta) {
        this.codigoCuenta = codigoCuenta;
    }
    
    public String validar(){
        
        if(gestion.autenticarCuenta(codigoCuenta)){
            return "operaciones";
        }
        else{
            return null;
        }
    }
    
}
