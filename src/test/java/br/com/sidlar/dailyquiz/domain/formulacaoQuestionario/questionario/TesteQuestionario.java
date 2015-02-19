package br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.questionario;

import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TesteQuestionario {

    @Test
    public void acessadoAntesDoPrazo_deveraEstarDisponivel() throws Exception {
        //fixture
        Questionario questionario = new Questionario();
        defineHojeComo("02/01/2015 00:00:00");
        questionario.acessivelAte(obtemData("02/01/2015 00:00:01"));

        //exercise
        boolean resultado = questionario.estaDisponivel();

        //verify
        assertThat(resultado,is(true));
    }

    private void defineHojeComo(String data) {
        DateTime dataAtual = obtemData(data);
        DateTimeUtils.setCurrentMillisFixed(dataAtual.getMillis());
    }

    private DateTime obtemData(String data){
        DateTimeFormatter formatoDaData = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");
        return  formatoDaData.parseDateTime(data);

    }
}