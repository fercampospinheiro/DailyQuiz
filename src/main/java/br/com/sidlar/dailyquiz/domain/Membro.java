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
	@Column(name="username")
	private String userName;
	@Column(length = 64)
	private String senha;

	public Membro() {

	}

	public void geraHashCodeDaSenhaDoMembro(){
		this.senha = String.valueOf(senha.hashCode());
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}




	@Override
	public String toString() {
		return "Membro{" +
				"id=" + id +
				", nome='" + nome + '\'' +
				", userName='" + userName + '\'' +
				", senha='" + senha + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Membro)) return false;

		Membro membro = (Membro) o;

		if (id != membro.id) return false;
		if (!nome.equals(membro.nome)) return false;
		if (!senha.equals(membro.senha)) return false;
		if (!userName.equals(membro.userName)) return false;

		return true;

	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + nome.hashCode();
		result = 31 * result + userName.hashCode();
		result = 31 * result + senha.hashCode();
		return result;
	}



}
