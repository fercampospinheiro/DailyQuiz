package br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.questao;

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

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
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

	public void adicionaAlternativa(Alternativa alternativa){

		if(!alternativas.contains(alternativa)) {
			alternativas.add(alternativa);
		}
		else{
			throw  new AlternativaRepetidaException(String.format("Alternativa já cadastrada : '%' ! Informe outra",alternativa.exibe()));
		}
	}

	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public void setAlternativas(List<Alternativa> alternativas) {
        this.alternativas = alternativas;
    }

    public void setAlternativaCorreta(Alternativa alternativaCorreta) {
        this.alternativaCorreta = alternativaCorreta;
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
		return this.alternativaCorreta;
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
}
