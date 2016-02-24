package entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cuentas database table.
 * 
 */
@Entity
@Table(name="cuentas")
@NamedQuery(name="Cuenta.findAll", query="SELECT c FROM Cuenta c")
public class Cuenta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int numerocuenta;

	private String nombrecliente;

	private double saldo;

	public Cuenta() {
	}

	public int getNumerocuenta() {
		return this.numerocuenta;
	}

	public void setNumerocuenta(int numerocuenta) {
		this.numerocuenta = numerocuenta;
	}

	public String getNombrecliente() {
		return this.nombrecliente;
	}

	public void setNombrecliente(String nombrecliente) {
		this.nombrecliente = nombrecliente;
	}

	public double getSaldo() {
		return this.saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

}