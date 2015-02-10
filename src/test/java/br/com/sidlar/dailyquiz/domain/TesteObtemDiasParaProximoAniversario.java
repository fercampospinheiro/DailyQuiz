package br.com.sidlar.dailyquiz.domain;
import br.com.sidlar.dailyquiz.domain.membro.Membro;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TesteObtemDiasParaProximoAniversario {

    private Membro membro;

    @Before
   public void inicializa(){
       membro = new Membro();
   }


}