package com.crea.dev4.ecole.model.beans;

import java.sql.Date;

public class Livre {
	// Attributs
	private String cote;
	private String num;
	private String titre;
	private Date datepret;

	public Livre(String cote, String num, String titre, Date datepret) {
		super();
		this.cote = cote;
		this.num = num;
		this.titre = titre;
		this.datepret = datepret;
	}

	public Livre() {
		this("", null, "", null);
	}

	public String getCote() {
		return cote;
	}

	public void setCote(String string) {
		this.cote = string;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Date getDatepret() {
		return datepret;
	}

	public void setDatepret(Date date) {
		this.datepret = date;
	}

	public void affiche() {
		System.out.print("cote " + cote + " num " + num + " title " + titre + "datepret" + datepret + "\n");
	}

	public String toString() {
		return "cote " + cote + " num " + num + " title " + titre + "datepret" + datepret;
	}

}
