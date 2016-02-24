package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the movimientos database table.
 * 
 */
@Entity
@Table(name="movimientos")
@NamedQuery(name = "Movimiento.FindByCuenta", query = "SELECT m FROM Movimiento m where m.numerocuenta=?1")
public class Movimiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMovimiento;

	private double cantidad;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;

	private int numerocuenta;

	private String operacion;

	public Movimiento() {
	}

	public Movimiento(Integer idMovimiento, int numerocuenta, Date fecha, double cantidad, String operacion) {
        this.idMovimiento = idMovimiento;
        this.numerocuenta = numerocuenta;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.operacion = operacion;
    }

	public int getIdMovimiento() {
		return this.idMovimiento;
	}

	public void setIdMovimiento(int idMovimiento) {
		this.idMovimiento = idMovimiento;
	}

	public double getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getNumerocuenta() {
		return this.numerocuenta;
	}

	public void setNumerocuenta(int numerocuenta) {
		this.numerocuenta = numerocuenta;
	}

	public String getOperacion() {
		return this.operacion;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}

}