package br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.model.database;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PEDIDO_MATRICULA")
public class PedidoMatricula implements Serializable {

	private static final long serialVersionUID = -2137506145016637392L;

	@EmbeddedId
	private PedidoMatriculaPrimaryKey id;

	@Column(nullable = false)
	private int iaaAluno;

	@Column(nullable = false)
	private int vagasOfertadas = 0;

	@Column
	private int posicao;

	@Column(nullable = false)
	private boolean deveNotificarAlunoGanhouVaga = false;

	@Column(nullable = false)
	private boolean deveNotificarAlunoPerdeuVaga = false;

	public PedidoMatricula() {
	}

	public PedidoMatricula(PedidoMatriculaPrimaryKey id) {
		this.id = id;
		iaaAluno = id.getAluno().getIaa();
		vagasOfertadas = id.getTurma().getVagasOfertadas();
	}

	public PedidoMatriculaPrimaryKey getId() {
		return id;
	}

	public int getIaaAluno() {
		return iaaAluno;
	}

	public int getVagasOfertadas() {
		return vagasOfertadas;
	}

	public int getPosicao() {
		return posicao;
	}

	public boolean isDeveNotificarAlunoGanhouVaga() {
		return deveNotificarAlunoGanhouVaga;
	}

	public boolean isDeveNotificarAlunoPerdeuVaga() {
		return deveNotificarAlunoPerdeuVaga;
	}

	public void setDeveNotificarAlunoGanhouVaga(boolean deveNotificarAlunoGanhouVaga) {
		this.deveNotificarAlunoGanhouVaga = deveNotificarAlunoGanhouVaga;
	}

	public void setDeveNotificarAlunoPerdeuVaga(boolean deveNotificarAlunoPerdeuVaga) {
		this.deveNotificarAlunoPerdeuVaga = deveNotificarAlunoPerdeuVaga;
	}
}
