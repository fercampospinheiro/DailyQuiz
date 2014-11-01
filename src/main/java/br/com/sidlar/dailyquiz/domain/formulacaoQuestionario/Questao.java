package br.com.sidlar.dailyquiz.domain.formulacaoQuestionario;

import br.com.sidlar.dailyquiz.domain.excecoes.AlternativaRepetidaException;
import com.google.common.collect.Lists;
import java.util.List;
import javax.persistence.*;

@Entity
public class Questao {
	@Id @GeneratedValue(strategy =  GenerationType.AUTO)
	private Integer id;
	private String pergunta;
	@OneToMany
	@JoinColumn(name = "questao_id",referencedColumnName = "id")
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


}
