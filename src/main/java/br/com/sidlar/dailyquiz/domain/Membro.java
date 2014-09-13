package br.com.sidlar.dailyquiz.domain;

import org.joda.time.DateTime;

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
	private DateTime dataNascimento;

	public Membro() {

	}

	public void setDataNascimento(DateTime dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public int getIdade(){
		return DateTime.now().getYear() - dataNascimento.getYear();
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

	public boolean validaSenha(String senha){
		return	senha.equals(senha);
	}

	public boolean ehDiaDeAniversario(DateTime diaAtual){
		return dataNascimento.equals(diaAtual);
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
