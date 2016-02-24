package modelo.dao;

import java.util.List;

import entidades.Movimiento;

public interface DaoMovimientos {

	void altaMovimiento(Movimiento m);

	List<Movimiento> obtenerMovimientosDeCuenta(int codigo);

}