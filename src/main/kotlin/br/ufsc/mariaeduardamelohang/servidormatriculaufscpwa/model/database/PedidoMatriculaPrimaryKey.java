package br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.model.database;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Embeddable
public class PedidoMatriculaPrimaryKey implements Serializable {

	private static final long serialVersionUID = 2964997141275501320L;

	@ManyToOne
	@MapsId
	@JsonIgnore
	private Turma turma;

	@ManyToOne
	@MapsId
	@JsonIgnore
	private Aluno aluno;

	public Turma getTurma() {
		return turma;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public PedidoMatriculaPrimaryKey() {
	}

	public PedidoMatriculaPrimaryKey(Turma turma, Aluno aluno) {
		this.turma = turma;
		this.aluno = aluno;
	}
}
