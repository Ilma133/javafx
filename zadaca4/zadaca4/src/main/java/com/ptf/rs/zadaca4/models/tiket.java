package com.ptf.rs.zadaca4.models;

import java.util.Date;
import java.util.Objects;

public class tiket{
	private Integer Id;
	private String TipUsluge;
	private String NaslovProblema;
	private String ImeOsobe;
	private Date Datum;
	private String NacinPrijave;
	private String Prioritet;
	private String Opis;
	private String Agent;
	private String Email;
	private String Telefon;
	private String Status;
	private Date DatumRj;
	
	
	

	public Date getDatumRj() {
		return DatumRj;
	}

	public void setDatumRj(Date datumRj) {
		DatumRj = datumRj;
	}

	public tiket(Integer id, String tipUsluge, String naslovProblema, String imeOsobe, Date datum, String nacinPrijave,
			String prioritet, String opis, String agent, String email, String telefon, String status, Date DatumRj) {
		super();
	    Id=id;
		TipUsluge = tipUsluge;
		NaslovProblema = naslovProblema;
		ImeOsobe = imeOsobe;
		Datum = datum;
		NacinPrijave = nacinPrijave;
		Prioritet = prioritet;
		Opis = opis;
		Agent = agent;
		Email = email;
		Telefon = telefon;
		Status=status;
		this.DatumRj=DatumRj;
	}
	
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getTipUsluge() {
		return TipUsluge;
	}


	public void setTipUsluge(String tipUsluge) {
		TipUsluge = tipUsluge;
	}


	public String getNaslovProblema() {
		return NaslovProblema;
	}


	public void setNaslovProblema(String naslovProblema) {
		NaslovProblema = naslovProblema;
	}


	public String getImeOsobe() {
		return ImeOsobe;
	}


	public void setImeOsobe(String imeOsobe) {
		ImeOsobe = imeOsobe;
	}


	public Date getDatum() {
		return Datum;
	}


	public void setDatum(Date datum) {
		Datum = datum;
	}


	public String getNacinPrijave() {
		return NacinPrijave;
	}


	public void setNacinPrijave(String nacinPrijave) {
		NacinPrijave = nacinPrijave;
	}


	public String getPrioritet() {
		return Prioritet;
	}


	public void setPrioritet(String prioritet) {
		Prioritet = prioritet;
	}


	public String getOpis() {
		return Opis;
	}


	public void setOpis(String opis) {
		Opis = opis;
	}


	public String getAgent() {
		return Agent;
	}


	public void setAgent(String agent) {
		Agent = agent;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}


	public String getTelefon() {
		return Telefon;
	}


	public void setTelefon(String telefon) {
		this.Telefon = telefon;
	}
	
	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		this.Status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		tiket other = (tiket) obj;
		return Objects.equals(Id, other.Id);
	}


	



	
	
}


