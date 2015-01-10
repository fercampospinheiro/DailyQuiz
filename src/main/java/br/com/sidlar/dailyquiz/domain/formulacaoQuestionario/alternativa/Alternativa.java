package br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.alternativa;

import javax.persistence.*;

@Entity
public class Alternativa {
	@Id @GeneratedValue
	private Integer id;
	private Integer ordem;
	private String descricao;

	public Alternativa() {
	}
	public Alternativa( String descricao) {
		this.descricao = descricao;
	}

	public String  exibe(){
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Alternativa that = (Alternativa) o;

		if (descricao != null ? !descricao.equals(that.descricao) : that.descricao != null) return false;
		if (ordem != null ? !ordem.equals(that.ordem) : that.ordem != null) return false;

		return true;
	}

	public Integer getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}
}
