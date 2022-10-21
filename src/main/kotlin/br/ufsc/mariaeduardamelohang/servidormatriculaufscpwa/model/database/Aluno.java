package br.ufsc.mariaeduardamelohang.servidormatriculaufscpwa.model.database;

import static javax.persistence.GenerationType.AUTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "TB_ALUNO")
public class Aluno implements Serializable, UserDetails {

	private static final long serialVersionUID = 871628892533743316L;

	@Id @GeneratedValue(strategy = AUTO)
	private UUID matricula;

	@Column(unique = true, nullable = false)
	private String nomeUsuario;

	@Column(nullable = false)
	private String senha;

	@Column(nullable = false)
	private int iaa;

	@Column
	private String token;

	@Override public Collection<? extends GrantedAuthority> getAuthorities() {
		return new ArrayList<>();
	}

	@Override public String getPassword() {
		return senha;
	}

	@Override public String getUsername() {
		return nomeUsuario;
	}

	@Override public boolean isAccountNonExpired() {
		return true;
	}

	@Override public boolean isAccountNonLocked() {
		return true;
	}

	@Override public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override public boolean isEnabled() {
		return true;
	}

	public Aluno() {
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public int getIaa() {
		return iaa;
	}

	public void setIaa(int iaa) {
		this.iaa = iaa;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public UUID getMatricula() {
		return matricula;
	}
}
