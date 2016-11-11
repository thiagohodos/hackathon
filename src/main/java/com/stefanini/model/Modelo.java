package com.stefanini.model;
// Generated 07/11/2016 12:06:19 by Hibernate Tools 4.3.1.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "modelo", catalog = "hackathon")
public class Modelo implements java.io.Serializable {

	private Integer idModelo;
	private String descricaoModelo;
	private String categoria;

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idModelo", unique = true, nullable = false)
	public Integer getIdModelo() {
		return this.idModelo;
	}

	public void setIdModelo(Integer idModelo) {
		this.idModelo = idModelo;
	}

	@Column(name = "descricaoModelo", length = 50)
	public String getDescricaoModelo() {
		return this.descricaoModelo;
	}

	public void setDescricaoModelo(String descricaoModelo) {
		this.descricaoModelo = descricaoModelo;
	}

}
