package br.com.sidlar.dailyquiz.domain.formulacaoQuestionario;

import br.com.sidlar.dailyquiz.domain.excecoes.AlternativaRepetidaException;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.UUID;
import javax.persistence.*;

@Entity
public class Questao {
	@Id @GeneratedValue
	private Integer id;
	private UUID uuid = UUID.randomUUID();
	private String pergunta;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "idQuestao")
	private List<Alternativa> alternativas = Lists.newArrayList();
	@OneToOne
	private Alternativa alternativaCorreta;

	public Questao() {
	}

	public Questao(String pergunta) {
		this.pergunta = pergunta;
	}

	public void formulaPergunta(String pergunta){
		this.pergunta = pergunta;
	}
	
	public void adicionaAlternativa(Alternativa alternativa){

		if(!alternativas.contains(alternativa)) {
			alternativas.add(alternativa);
		}
		else{
			throw  new AlternativaRepetidaException(String.format("A alternativa : '%' ! Informe outra",alternativa.exibe()));
		}
	}
	public String exibe() {
		return pergunta;
	}

	public void defineAlternativaCorreta(Alternativa alternativa){
		this.alternativaCorreta = alternativa;
	}

	public boolean ehIgualRespostaDaQuestao(Alternativa alternativa){
		return this.alternativaCorreta.equals(alternativa);
	}

	public UUID getUuid() {
		return uuid;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Questao questao = (Questao) o;

		if (uuid != null ? !uuid.equals(questao.uuid) : questao.uuid != null) return false;

		return true;
	}
}
