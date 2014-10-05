package br.com.sidlar.dailyquiz.domain;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.Years;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.time.Year;

/**
 * Membro da aplicação
 * @author Fernando de Campos Pinheiro
 */
@Entity
@Table(name="membro")
public class Membro {
	@Id
	@GeneratedValue
	private Integer id;
    private String nome;
	private String email;
	private String senha;
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate dataNascimento;

	public Membro() {

	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Years getIdade(){
		return  Years.yearsBetween(dataNascimento,LocalDate.now());
	}

	public boolean fazAniversarioHoje(){
		return dataNascimento.equals(LocalDate.now()) ;
	}

	public Days obtemDiasParaProximoAniversario(){
        return Days.daysBetween(LocalDate.now(), dataNascimento.plusYears(getIdade().getYears()));
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean possuiSenhaInformada(String senha){
		return	senha.equals(senha);
	}

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    @Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Membro)) return false;

		Membro membro = (Membro) o;

		if (!email.equals(membro.email)) return false;

		return true;

	}




}
