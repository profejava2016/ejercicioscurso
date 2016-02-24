package modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import entidades.Movimiento;

@Component
public class DaoMovimientosImpl implements DaoMovimientos {
	@PersistenceContext(unitName="13_banco_PU")
	EntityManager em;
	@Transactional
	@Override
	public void altaMovimiento(Movimiento m) {
		
        em.persist(m);
        
        
    }

    
    /* (non-Javadoc)
	 * @see modelo.dao.DaoMovimientos#obtenerMovimientosDeCuenta(int)
	 */
    @Override
	public List<Movimiento> obtenerMovimientosDeCuenta(int codigo) {
    	
        Query q=em.createNamedQuery("Movimiento.FindByCuenta");
        q.setParameter(1, codigo);
        return (List<Movimiento>)q.getResultList();
    }
  
}
