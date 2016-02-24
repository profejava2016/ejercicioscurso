/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managed;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import entidades.Movimiento;
import modelo.service.GestionCajero;



/**
 *
 * @author Tarde
 */
@ManagedBean
@RequestScoped
public class MovimientosBean {
    
    
    
    @ManagedProperty("#{validacionBean}")
    private ValidacionBean validacionBean;
    private double saldo;
    private List<Movimiento> movimientos;
    
    @ManagedProperty("#{gcajero}")
    GestionCajero gestion;
    public GestionCajero getGestion() {
		return gestion;
	}

	public void setGestion(GestionCajero gestion) {
		this.gestion = gestion;
	}

    public ValidacionBean getValidacionBean() {
        return validacionBean;
    }

    public void setValidacionBean(ValidacionBean validacionBean) {
        this.validacionBean = validacionBean;
    }
    
    public double getSaldo(){
        
        saldo=gestion.obtenerSaldo(validacionBean.getCodigoCuenta());
        return saldo;
    }
    public List<Movimiento> getMovimientos(){
        
        movimientos=gestion.obtenerMovimientos(validacionBean.getCodigoCuenta());
        return movimientos;
    }
    
}
