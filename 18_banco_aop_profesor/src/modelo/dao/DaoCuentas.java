package modelo.dao;

import entidades.Cuenta;

public interface DaoCuentas {

	Cuenta buscarCuentaPorCodigo(int codigo);

	void actualizarCuenta(Cuenta c);

}