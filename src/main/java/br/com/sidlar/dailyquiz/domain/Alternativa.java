package br.com.sidlar.dailyquiz.domain;

public class Alternativa {
	private Long id;
	private String descricao;
	
	public Alternativa( String descricao) {
		this.descricao = descricao;
	}

	public String  exibe(){
		return this.descricao;
	}
}
