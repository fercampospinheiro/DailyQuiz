package br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.questionario;

import junit.framework.TestCase;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import java.time.Period;
import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;

public class TesteQuestionario_ExpiraEm extends TestCase {

    private Questionario  questionario;

    @Before
    public void iniciliza(){
        questionario = new Questionario();
    }



    @Test
    public void Questionario_deveraExpirarEm30Minutos(){

        //fixture
        questionario.foiRespondidoEm(new DateTime(2015,2,9,14,30));
        questionario.defineDataLimiteParaResposta(new DateTime(2015,2,9,15,0));
        //exercise

        DateTime dataEsperada = questionario.expiraEm();

        //verify


    }

    @Test
    public void membro_tera4HorasParaResponderQuestinario(){

    }

    @Test
    public void membro_tera2diasParaResponderQuestionario(){

    }

    @Test
    public void membro_tera2horas30MinutosParaResponderQuestionario(){}

    @Test
    public  void membro_tera3Dias2HorasParaResponderQuestionario(){}

    @Test
    public  void membro_tera3Dias2Horas30MinutosParaReposnderQuestionario(){}

}