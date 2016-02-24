package modelo.service;

import java.util.List;

import entidades.Movimiento;

public interface GestionCajero {

	void extraer(int codigo, double cantidad);

	void ingresar(int codigo, double cantidad);

	boolean autenticarCuenta(int codigo);

	List<Movimiento> obtenerMovimientos(int codigo);

	double obtenerSaldo(int codigo);

}