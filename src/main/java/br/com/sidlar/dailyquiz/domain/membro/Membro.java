package br.com.sidlar.dailyquiz.domain.membro;

import org.hibernate.annotations.Type;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.Years;

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

	public Membro() {

	}

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

	public boolean isAniversarioHoje(){
		int diaAtual = LocalDate.now().getDayOfMonth();
        int mesAtual = LocalDate.now().getMonthOfYear();
        int diaDoAniversario = this.dataNascimento.getDayOfMonth();
        int mesDoAniversario = this.dataNascimento.getMonthOfYear();

        return (diaDoAniversario == diaAtual) && (mesDoAniversario == mesAtual);
    }
	public Days obtemDiasParaProximoAniversario(){
        LocalDate dataDeHoje = LocalDate.now();
        LocalDate dataDoProximoAniversario = dataNascimento.plusYears(getIdade().getYears()+1);
        return Days.daysBetween(dataDeHoje, dataDoProximoAniversario );
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
		return	this.senha.equals(senha);
	}

    public LocalDate getDataNascimento() {
        return dataNascimento;
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
}
