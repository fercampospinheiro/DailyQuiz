package br.com.sidlar.dailyquiz.domain;

import org.joda.time.DateTime;

/**
 * Classe modelo de um formulario para cricação de novos membros
 * @author  Fernando de Campos Pinheiro
 */
public class FormularioCadastroMembro {
	private String nome;
	private String UserName;
	private String senha;
	private DateTime dataNascimento;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
