package br.com.sidlar.dailyquiz.domain.formulacaoQuestionario;

import javax.persistence.*;

@Entity
public class Alternativa {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String descricao;

	public Alternativa() {
	}
	public Alternativa( String descricao) {
		this.descricao = descricao;
	}

	public String  exibe(){
		return this.descricao;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Alternativa)) return false;

		Alternativa that = (Alternativa) o;

		if (descricao != null ? !descricao.equals(that.descricao) : that.descricao != null) return false;

		return true;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
