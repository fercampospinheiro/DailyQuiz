package br.com.sidlar.dailyquiz.domain.membro;

import org.hibernate.annotations.Type;
import org.joda.time.*;
import javax.persistence.*;

/**
 * Membro da aplicação
 * @author Fernando de Campos Pinheiro
 */
@Entity
public class Membro {
	@Id
	@GeneratedValue
	private Integer id;
    private String nome;
	private String email;
	private String senha;
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate dataNascimento;

	public Membro() {}

    public Membro(String email, String nome) {
        this.email = email;
        this.nome = nome;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Years getIdade(){
		return  Years.yearsBetween(dataNascimento,LocalDate.now());
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean possuiSenhaInformada(String senha){
		return	this.senha.equals(senha);
	}

    
    public Integer getId() {
		return id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Membro)) return false;

		Membro membro = (Membro) o;

		if (!email.equals(membro.email)) return false;

		return true;

	}

    @Override
    public String toString() {
        return "Membro{" +
                "email='" + email + '\'' +
                '}';
    }

	public boolean fazAniversarioHoje() {
        LocalDate dataAtual = LocalDate.now();
        if(dataAtual.getYear() == dataNascimento.getYear()) return false;
		MonthDay diaEMesAtual =  new MonthDay(dataAtual);
		MonthDay diaEMesDoNascimento = new MonthDay(dataNascimento);
		return diaEMesAtual.equals(diaEMesDoNascimento);
	}

	public Days obtemDiasParaAniversario() {
		LocalDate  proximoAniversario = obtemProximoAniversario();
		return Days.daysBetween(new LocalDate(), proximoAniversario);
	}

	private LocalDate obtemProximoAniversario(){
        LocalDate dataAtual = LocalDate.now();

		MonthDay diaMesAtual = new MonthDay(dataAtual.getMonthOfYear(),dataAtual.getDayOfMonth());
		MonthDay diaMesAniversario = new MonthDay(dataNascimento.getMonthOfYear(),dataNascimento.getDayOfMonth());

		int anoAniversario = dataAtual.getYear();

		if(diaMesAniversario.isBefore(diaMesAtual))
			/*Aniversario passou busca próximo ano*/
			anoAniversario++;

		return new LocalDate(anoAniversario,diaMesAniversario.getMonthOfYear(),diaMesAniversario.getDayOfMonth());
	}

}
