package br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.model.database;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TB_TURMA")
public class Turma implements Serializable {

	private static final long serialVersionUID = 1848354516429296191L;

	@Id
	private String codigo;

	@Column(nullable = false)
	private int vagasOfertadas;

	@ManyToOne
	@JoinColumn(name = "id_professor", nullable = false, referencedColumnName = "id")
	private Professor professor;

	@ManyToOne
	@JoinColumn(name = "codigo_disciplina", nullable = false, referencedColumnName = "codigo")
	private Disciplina disciplina;

	@OneToMany(mappedBy = "id.turma")
	private List<TurmaHorarios> horarios;

	public Turma() {
	}

	public Turma(String codigo, int vagasOfertadas, Professor professor, Disciplina disciplina, List<TurmaHorarios> horarios) {
		this.codigo = codigo;
		this.vagasOfertadas = vagasOfertadas;
		this.professor = professor;
		this.disciplina = disciplina;
		this.horarios = horarios;
	}

	public String getCodigo() {
		return codigo;
	}

	public int getVagasOfertadas() {
		return vagasOfertadas;
	}

	public Professor getProfessor() {
		return professor;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public List<TurmaHorarios> getHorarios() {
		return horarios;
	}
}