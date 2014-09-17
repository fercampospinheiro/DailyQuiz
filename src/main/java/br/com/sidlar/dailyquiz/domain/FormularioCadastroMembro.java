package br.com.sidlar.dailyquiz.domain;

import org.joda.time.LocalDate;

/**
 * Classe modelo de um formulario para cricação de novos membros
 * @author  Fernando de Campos Pinheiro
 */
public class FormularioCadastroMembro {
	private String nome;
	private String UserName;
	private String senha;
	private LocalDate dataNascimento;

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
