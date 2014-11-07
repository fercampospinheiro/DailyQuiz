package br.com.sidlar.dailyquiz.domain;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

public class main {

	
	public static void main(String[] args) {

		DateTime disponivel = DateTime.now();
		DateTime limite = new DateTime(2014,11,07,10,0);
		Period periodo = new Period(disponivel,limite);

		PeriodFormatter periodFormat = new PeriodFormatterBuilder()
				.appendDays()
				.appendSuffix(" dias ")
				.appendHours()
				.appendSuffix(" horas ")
				.appendMinutes()
				.appendSuffix(" minutos ")
				.toFormatter();

		System.out.println(periodFormat.print(periodo));

	}
}
