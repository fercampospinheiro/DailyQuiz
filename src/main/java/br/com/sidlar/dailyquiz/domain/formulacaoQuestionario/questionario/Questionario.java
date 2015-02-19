package br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.questionario;

import br.com.sidlar.dailyquiz.domain.excecoes.QuestaoRepetidaException;
import br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.questao.Questao;
import br.com.sidlar.dailyquiz.domain.membro.Membro;
import com.google.common.collect.Lists;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;
import javax.persistence.*;
import java.util.List;

@Entity
public class Questionario {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "idQuestionario")
    @OrderColumn(name = "ordem")
	private List<Questao> questoes = Lists.newArrayList();

	private String nome;

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime dataDisponivel;

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime dataLimite;

	@OneToOne
	@JoinColumn(name = "idMembroCriador")

	private Membro membroCriador;


    public Questionario() {
	}

	public Questionario(String nome) {
		this.nome = nome;
	}

	public void adicionaQuestao(Questao questao) {
		if (!questoes.contains(questao)) {
			this.questoes.add(questao);
		} else {
			throw new QuestaoRepetidaException("Questao Repetida! Informe outra questão!");
		}

	}

	public void  criadoPor(Membro membro){
		this.membroCriador = membro;
	}

	public void acessivelAte(DateTime dataLimite) {
			this.dataLimite = dataLimite;
	}

	public String expiraEm() {

		if(!estaDisponivel()){
			return "prazo expirado";
		}

		DateTime dataAtual = new DateTime().now();
		Period period = new Period( dataAtual, dataLimite);
		PeriodFormatter formatoDaData;

		if (period.getDays() > 0) {
			formatoDaData = new PeriodFormatterBuilder()
					.appendDays().appendSuffix(" dia ", " dias ").toFormatter();

		}
		else if (period.getHours()>1){
			formatoDaData = new PeriodFormatterBuilder()
					.appendHours().appendSuffix(" hora "," horas ").toFormatter();
		}
		else if(period.getHours()==1){
			formatoDaData = new PeriodFormatterBuilder()
					.appendHours().appendSuffix(" hora ", " horas ")
					.appendSuffix(" e ")
					.appendMinutes()
					.appendSuffix(" minuto ", " minutos ")
					.toFormatter();
		}
		else {
			formatoDaData = new PeriodFormatterBuilder()
					.appendMinutes().appendSuffix(" minuto "," minutos ").toFormatter();
		}

		return period.toString(formatoDaData);
	}

	public boolean estaDisponivel(){
		DateTime dataAtual = DateTime.now();
		return dataAtual.isBefore(dataLimite);
	}

	public String getNome() {
		return nome;
	}

	public List<Questao> getQuestoes() {
		return questoes;
	}

	public Integer getId() {
		return id;
	}
}


