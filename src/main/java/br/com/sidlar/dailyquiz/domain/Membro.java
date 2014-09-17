package br.com.sidlar.dailyquiz.domain;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.Years;

import javax.persistence.*;
import java.time.Year;

/**
 * Model da camada de negócio
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
	@Column(name = "datanascimento")
	private LocalDate dataNascimento;

	public Membro() {

	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public int getIdade(){
		return  Years.yearsBetween(dataNascimento,LocalDate.now()).getYears();
	}

	public boolean eHDiaDoAniversario(LocalDate dataAtual ){
		return dataNascimento == dataAtual ;
	}

	public int diasRestantesParaProximoAniversario(){
		return Days.daysBetween(LocalDate.now(),dataNascimento.plusYears(1)).getDays();
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

	public boolean validaSenha(String senha){
		return	senha.equals(senha);
	}



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Membro)) return false;

		Membro membro = (Membro) o;

		if (id != membro.id) return false;
		if (!nome.equals(membro.nome)) return false;
		if (!senha.equals(membro.senha)) return false;
		if (!email.equals(membro.email)) return false;

		return true;

	}




}
