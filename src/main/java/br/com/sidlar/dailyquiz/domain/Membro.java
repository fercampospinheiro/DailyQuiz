package br.com.sidlar.dailyquiz.domain;

import javax.persistence.*;

/**
 * Model da camada de negócio
 * @author Fernando de Campos Pinheiro
 */
@Entity
@Table(name="membro")
public class Membro {
	@Id
	@GeneratedValue
	private Integer id;
	private String nome;
	private String email;
	private String senha;

	public Membro() {

	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Membro)) return false;

		Membro membro = (Membro) o;

		if (id != membro.id) return false;
		if (!nome.equals(membro.nome)) return false;
		if (!senha.equals(membro.senha)) return false;
		if (!email.equals(membro.email)) return false;

		return true;

	}




}
