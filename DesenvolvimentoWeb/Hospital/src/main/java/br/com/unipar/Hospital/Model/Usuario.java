package br.com.unipar.Hospital.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "USUARIO")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 100)
	@NotBlank
	@NotEmpty
	@NotNull
	private String nome;

	@Column(length = 100)
	@NotBlank
	@NotEmpty
	@NotNull
	private String usuarioAd;

	@Column(length = 100)
	@NotBlank
	@NotEmpty
	@NotNull
	private String senha;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuarioAd() {
		return usuarioAd;
	}

	public void setUsuarioAd(String usuarioAd) {
		this.usuarioAd = usuarioAd;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Usuario(Long id, @NotBlank @NotEmpty @NotNull String nome, @NotBlank @NotEmpty @NotNull String usuarioAd,
			@NotBlank @NotEmpty @NotNull String senha) {
		this.id = id;
		this.nome = nome;
		this.usuarioAd = usuarioAd;
		this.senha = senha;
	}

	public Usuario() {
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", usuarioAd=" + usuarioAd + ", senha=" + senha + "]";
	}

}
