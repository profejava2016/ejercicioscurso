package modelo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import entidades.Cuenta;
import entidades.Movimiento;
import modelo.dao.DaoCuentas;
import modelo.dao.DaoMovimientos;
@Component("gcajero")
public class GestionCajeroImpl implements GestionCajero {
	
	@Autowired
    DaoCuentas dcuentas;
	@Autowired
    DaoMovimientos dmovimientos;

    
    public GestionCajeroImpl(){
    	
    }
   
   	
    /* (non-Javadoc)
	 * @see modelo.service.GestionCajero#extraer(int, double)
	 */
    @Transactional
    @Override
	public void extraer(int codigo, double cantidad) {
        
        Cuenta c=dcuentas.buscarCuentaPorCodigo(codigo);
        c.setSaldo(c.getSaldo()-cantidad);
        dcuentas.actualizarCuenta(c);
        Movimiento m=new Movimiento(0, c.getNumerocuenta(),new Date(), cantidad, "Extracción");      
        dmovimientos.altaMovimiento(m);
    }


    /* (non-Javadoc)
	 * @see modelo.service.GestionCajero#ingresar(int, double)
	 */
    @Transactional
    @Override
	public void ingresar(int codigo, double cantidad) {
       
        Cuenta c=dcuentas.buscarCuentaPorCodigo(codigo);
        c.setSaldo(c.getSaldo()+cantidad);
        
        dcuentas.actualizarCuenta(c);
        Movimiento m=new Movimiento(0, c.getNumerocuenta(),new Date(), cantidad, "Ingreso");      
       
        dmovimientos.altaMovimiento(m);
    }

  
    /* (non-Javadoc)
	 * @see modelo.service.GestionCajero#autenticarCuenta(int)
	 */
    @Override
	public boolean autenticarCuenta(int codigo) {
        
        Cuenta cuenta= dcuentas.buscarCuentaPorCodigo(codigo);
        if(cuenta==null){
            return false;
        }else{
            return true;
        }
    }

 
    /* (non-Javadoc)
	 * @see modelo.service.GestionCajero#obtenerMovimientos(int)
	 */
    @Override
	public List<Movimiento> obtenerMovimientos(int codigo) {
      
        return dmovimientos.obtenerMovimientosDeCuenta(codigo);
    }

    
    /* (non-Javadoc)
	 * @see modelo.service.GestionCajero#obtenerSaldo(int)
	 */
    @Override
	public double obtenerSaldo(int codigo) {
        
        return (dcuentas.buscarCuentaPorCodigo(codigo)).getSaldo();
    }
}
