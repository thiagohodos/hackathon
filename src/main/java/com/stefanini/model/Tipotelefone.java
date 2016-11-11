package com.stefanini.model;
// Generated 07/11/2016 12:06:19 by Hibernate Tools 4.3.1.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipotelefone", catalog = "hackathon")
public class Tipotelefone implements java.io.Serializable {

	private Integer idTipoTelefone;
	private String descricaoTipoTelefone;

	public Tipotelefone() {
	}

	public Tipotelefone(String descricaoTipoTelefone) {
		this.descricaoTipoTelefone = descricaoTipoTelefone;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idTipoTelefone", unique = true, nullable = false)
	public Integer getIdTipoTelefone() {
		return this.idTipoTelefone;
	}

	public void setIdTipoTelefone(Integer idTipoTelefone) {
		this.idTipoTelefone = idTipoTelefone;
	}

	@Column(name = "descricaoTipoTelefone", length = 20)
	public String getDescricaoTipoTelefone() {
		return this.descricaoTipoTelefone;
	}

	public void setDescricaoTipoTelefone(String descricaoTipoTelefone) {
		this.descricaoTipoTelefone = descricaoTipoTelefone;
	}

}
