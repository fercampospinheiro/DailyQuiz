package br.com.sidlar.dailyquiz.domain;

/**
 * @author  Fernando de Campos Pinheiro
 */
public class FormularioCadastroMembro {
	private String nome;
	private String UserName;
	private String senha;

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
