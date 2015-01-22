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

    public Integer getOrdem(){
        return this.ordem;
    }

	public Integer getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Alternativa)) return false;

        Alternativa that = (Alternativa) o;

        if (!ordem.equals(that.ordem)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return ordem.hashCode();
    }
}
