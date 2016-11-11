package com.stefanini.model;
// Generated 07/11/2016 12:06:19 by Hibernate Tools 4.3.1.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TelefonesId implements java.io.Serializable {

	private int numero;
	private int ddd;
	private int cpfProprietario;

	public TelefonesId() {
	}

	public TelefonesId(int numero, int ddd, int cpfProprietario) {
		this.numero = numero;
		this.ddd = ddd;
		this.cpfProprietario = cpfProprietario;
	}

	@Column(name = "numero", nullable = false)
	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Column(name = "ddd", nullable = false)
	public int getDdd() {
		return this.ddd;
	}

	public void setDdd(int ddd) {
		this.ddd = ddd;
	}

	@Column(name = "cpfProprietario", nullable = false)
	public int getCpfProprietario() {
		return this.cpfProprietario;
	}

	public void setCpfProprietario(int cpfProprietario) {
		this.cpfProprietario = cpfProprietario;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TelefonesId))
			return false;
		TelefonesId castOther = (TelefonesId) other;

		return (this.getNumero() == castOther.getNumero()) && (this.getDdd() == castOther.getDdd())
				&& (this.getCpfProprietario() == castOther.getCpfProprietario());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getNumero();
		result = 37 * result + this.getDdd();
		result = 37 * result + this.getCpfProprietario();
		return result;
	}

}
