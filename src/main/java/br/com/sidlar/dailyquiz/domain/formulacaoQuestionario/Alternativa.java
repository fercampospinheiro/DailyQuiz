package br.com.sidlar.dailyquiz.domain.formulacaoQuestionario;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Alternativa {
	@Id @GeneratedValue
	private Integer id;
	private UUID uuid = UUID.randomUUID();
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

		if (uuid != null ? !uuid.equals(that.uuid) : that.uuid != null) return false;

		return true;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public UUID getUuid() {
		return uuid;
	}
}
