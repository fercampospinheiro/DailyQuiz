package br.com.sidlar.dailyquiz.domain;

import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Classe modelo de um formulario para cricação de novos membros
 * @author  Fernando de Campos Pinheiro
 */
public class FormularioCadastroMembro {
	private String nome;
	private String email;
	private String senha;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
}
