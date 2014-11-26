package br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.questao;

import br.com.sidlar.dailyquiz.domain.excecoes.AlternativaRepetidaException;
import br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.alternativa.Alternativa;
import com.google.common.collect.Lists;

import java.util.List;
import javax.persistence.*;

@Entity
public class Questao {
	@Id @GeneratedValue
	private Integer id;
	private Integer ordem;
	private String pergunta;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
	@JoinColumn(name = "idQuestao")
	@OrderColumn(name = "ordem")
	private List<Alternativa> alternativas = Lists.newArrayList();

	@OneToOne
	@JoinColumn(name = "idAlternativaCorreta")
	@OrderColumn(name="ordem")
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
			throw  new AlternativaRepetidaException(String.format("Alternativa já cadastrada : '%' ! Informe outra",alternativa.exibe()));
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

	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Questao questao = (Questao) o;

		if (ordem != null ? !ordem.equals(questao.ordem) : questao.ordem != null) return false;
		if (pergunta != null ? !pergunta.equals(questao.pergunta) : questao.pergunta != null) return false;

		return true;
	}

	public Integer getId() {
		return id;
	}

	public Integer getOrdem() {
		return ordem;
	}

	public String getPergunta() {
		return pergunta;
	}

	public List<Alternativa> getAlternativas() {
		return alternativas;
	}

	public Alternativa getAlternativaCorreta() {
		return alternativaCorreta;
	}
}