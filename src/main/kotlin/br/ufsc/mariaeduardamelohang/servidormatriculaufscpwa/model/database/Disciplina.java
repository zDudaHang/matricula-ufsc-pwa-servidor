package br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.model.database;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_DISCIPLINA")
public class Disciplina implements Serializable {

	private static final long serialVersionUID = 7229281137744422191L;

	@Id
	private String codigo;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private int cargaHoraria;

	public String getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}
}
